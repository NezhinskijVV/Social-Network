package model;

/**
 *
 * Created by Nezhinskij VV on 25.11.2016.
 */
public class MessageContainer {
    private long  idDancer;
    private long idDancer2;
    private String message;
    private boolean isRead;

    public MessageContainer(long idDancer, long idDancer2, String message, boolean isRead) {
        this.idDancer = idDancer;
        this.idDancer2 = idDancer2;
        this.message = message;
        this.isRead = isRead;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public long getidDancer() {
        return idDancer;
    }

    public long getidDancer2() {
        return idDancer2;
    }
}
