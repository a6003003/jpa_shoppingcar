package com.example.demo.service.impl;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.BroadcastAckCallback;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.demo.dao.chatroomhistory.ChatRoomHistoryDao;
import com.example.demo.entity.chatroomHistory.ChatRoomHistoryEntity;

import coustomresponse.CustomSocketMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.example.demo.service.impl.ChatRoomhistoryServiceImp;
import com.google.gson.Gson;
/**
 * @Data: 2019/7/10
 * @Des: SocketIO事件接收
 */
@Component
public class MessageEventhandlerService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String DEFAULT_ROOM_ID = "123";


    @Autowired
    private SocketIOServer server;
    
    @Autowired
	private ChatRoomhistoryServiceImp chatroomhistoryService;
    
	@Autowired
	ChatRoomServiceImp chatroomService;
    private static Map<String, SocketIOClient> clientMap;

    static {
        clientMap = new ConcurrentHashMap<>();
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String clientName = client.getHandshakeData().getSingleUrlParam("clientName");
        String roomId = client.getHandshakeData().getSingleUrlParam("roomId");
        clientMap.put(clientName, client);//將clientName設為map的key
        CustomSocketMsg socketMsg = new CustomSocketMsg();
        socketMsg.setMessage(clientName + "上線了 ");
        socketMsg.setData(clientMap.keySet());
        // 如果roomId不為空，通知指定房號誰上線
        if (roomId != null) {
            client.joinRoom(roomId);
            server.getRoomOperations("1").sendEvent("onlineMessage", socketMsg);
        } else {
            // 否則通知所有人
            server.getBroadcastOperations().sendEvent("onlineMessage", socketMsg);
        }
        
        logger.info(clientName + "連接上了 ");
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        String clientName = client.getHandshakeData().getSingleUrlParam("clientName");
        String roomId = client.getHandshakeData().getSingleUrlParam("roomId");
        client.disconnect();
        clientMap.remove(clientName);
        CustomSocketMsg socketMsg = new CustomSocketMsg();
        socketMsg.setMessage(clientName + "下線了 ");
        socketMsg.setData(clientMap.keySet());
        if (roomId != null) {
            client.joinRoom(roomId);
            server.getRoomOperations("1").sendEvent("onlineMessage", socketMsg);
        } else {
            // 否则的话通知所有人
            server.getBroadcastOperations().sendEvent("onlineMessage", socketMsg);
        }
        logger.info(clientName + "離線 " + client.getSessionId());
    }

    /**
     * 发送所有人信息
     *
     * @param client
     * @param msg
     */
    @OnEvent(value = "sendMessage")
    public void onSendMessage(SocketIOClient client, CustomSocketMsg msg) {
        server.getBroadcastOperations().sendEvent("receiveMessage", msg.getMessage(), new BroadcastAckCallback<String>(String.class, 5000) {
            @Override
            protected void onAllSuccess() {
                logger.info("全部应答：" + msg);
            }

            @Override
            protected void onClientTimeout(SocketIOClient client) {
                logger.info("应答超时：" + client.getSessionId().toString());
            }
        });
    }

    /**
     * 发送所有人信息
     *
     * @param client
     * @param msg
     * @param ackSender
     */
    @OnEvent(value = "sendOneMessage")
    public void sendOneMessage(SocketIOClient client, CustomSocketMsg msg, AckRequest ackSender) {
        String clientName = msg.getCode();
        if (clientMap.containsKey(clientName)) {
        	chatroomhistoryService.InsertRoomID(msg.getRoomid(), msg.getCode(),  msg.getSender(), msg.getMessage());//將聊天記錄存入MySQL
        	 clientMap.get(clientName).sendEvent("receiveMessage",msg.getMessage());//推送聊天訊息給Server
        
        } else {
            if (ackSender.isAckRequested()) {
                ackSender.sendAckData("查無此人");
            }
        }

    }

    /**
     * 发送群聊信息
     *
     * @param client
     * @param msg
     * @param ackSender
     */
    @OnEvent(value = "sendRoomMessage")
    public void sendRoomMessage(SocketIOClient client, CustomSocketMsg msg, AckRequest ackSender) {
        String roomId = client.getHandshakeData().getSingleUrlParam("roomId");
        if (client.getAllRooms().contains(roomId)) {
            server.getRoomOperations(roomId).sendEvent("receiveMessage", msg.getMessage(), new BroadcastAckCallback<Object>(Object.class, 5000) {
                @Override
                protected void onAllSuccess() {
                    logger.info("全部应答：" + msg);
                }

                @Override
                protected void onClientTimeout(SocketIOClient client) {
                    logger.info("应答超时：" + client.getSessionId().toString());
                }
            });
        } else {
            // 如果需要回执，则回执错误信息
            if (ackSender.isAckRequested()) {
                ackSender.sendAckData("roomId有错误");
            }
        }
    }

    // spring Ioc 容器销毁前停止服务
    @PreDestroy
    public void stop() {
        if (server != null) {
            server.stop();
        }
    }
}
