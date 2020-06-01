package coustomresponse;
import java.io.Serializable;

/**
 * @Data : 2019/7/11
 * @Des : Socket消息体
 */
public class CustomSocketMsg<T> implements Serializable {
    private static final long serialVersionUID = -569315342607629651L;
    private String code;
    private String message;
    private String roomid;
    private String sender;
    private T data;

    @Override
    public String toString() {
        return "{" +
                "code:" + code +
                ", message:'" + message + '\'' +
                ", data:" + data +
                ", roomid:" + roomid +
                ", sender:" + sender +
                '}';
    }
    

    /**
	 * @return the roomid
	 */
	public String getRoomid() {
		return roomid;
	}


	/**
	 * @param roomid the roomid to set
	 */
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}


	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}


	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
