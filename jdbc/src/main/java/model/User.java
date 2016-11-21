package model;

/**
 * Created by Nezhinskij VV on 17.11.2016.
 */
public class User {
    private final long id;
    private final String name;
    private final String style;

    public User(long id, String name, String style) {
        this.id = id;
        this.name = name;
        this.style = style;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }
}