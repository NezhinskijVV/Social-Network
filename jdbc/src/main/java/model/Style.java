package model;

/**
 * Created by Nezhinskij VV on 23.11.2016.
 *
 */
public class Style {
    private long id;
    private String style;
    private boolean classic;

    public Style(long id, String style, boolean classic) {
        this.id = id;
        this.style = style;
        this.classic = classic;
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

    public boolean isClassic() {
        return classic;
    }

    public void setClassic(boolean classic) {
        this.classic = classic;
    }
}
