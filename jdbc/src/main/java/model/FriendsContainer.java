package model;

/**
 *
 * Created by Nezhinskij VV on 21.01.2017.
 */
public class FriendsContainer {
    private long  idFrom;
    private long idTo;



    private String nameOfAddingDancer;

    public FriendsContainer(long idFrom, long idTo, String nameOfAddingDancer) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.nameOfAddingDancer = nameOfAddingDancer;
    }

    public String getNameOfAddingDancer() {
        return nameOfAddingDancer;
    }

    public long getIdFrom() {
        return idFrom;
    }

    public long getIdTo() {
        return idTo;
    }
}

