package model;
import java.util.List;

/**
 *
 * Created by Nezhinskij VV on 25.12.2016.
 */
public class Friends {
    private long id;
    private List<Long> friends;

    public Friends(long id, List<Long> friends) {
        this.id = id;
        this.friends = friends;
    }
}
