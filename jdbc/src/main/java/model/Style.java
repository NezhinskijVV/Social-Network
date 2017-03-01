package model;

/**
 * Created by Nezhinskij VV on 23.11.2016.
 *
 */
public class Style {
    private long id;
    private String style;

    public Style(long id, String style) {
        this.id = id;
        this.style = style;
    }

    public long getId() {
        return id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
