package model;

/**
 *
 * Created by Nezhinskij VV on 25.11.2016.
 */
public class MessageContainer {
    private long  id_dancer;
    private long id_dancer2;
    private String message;
    private boolean isRead;

    public MessageContainer(long id_dancer, long id_dancer2, String message, boolean isRead) {
        this.id_dancer = id_dancer;
        this.id_dancer2 = id_dancer2;
        this.message = message;
        this.isRead = isRead;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public long getId_dancer() {
        return id_dancer;
    }

    public long getId_dancer2() {
        return id_dancer2;
    }
}
