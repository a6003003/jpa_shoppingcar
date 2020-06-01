package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOServer;

// 实现CommandLineRunner接口代表在Spring启动后服务就跟着启动。Order则表示注入优先级为1,即注入的顺序靠前，优先级高
@Component	// 让Spring将其添加为一个可注入的组件
@Order(1)		
public class SocketioServerRunner implements CommandLineRunner {
    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public SocketioServerRunner(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
    	// spring服务启动后会紧接着启动run方法，即会吊起来socket服务。
        logger.info("ServerRunner 开始启动啦...");
        server.start();
    }
}
