package model;

/**
 *
 * Created by Nezhinskij VV on 21.01.2017.
 */
public class FriendsContainer {
    private long  idFrom;
    private long idTo;

    private String nameOfAddingDancer;

    public FriendsContainer(long idFrom, long idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }


    public String getNameOfAddingDancer() {
        return nameOfAddingDancer;
    }

    public void setNameOfAddingDancer(String nameOfAddingDancer) {
        this.nameOfAddingDancer = nameOfAddingDancer;
    }

    public long getIdFrom() {
        return idFrom;
    }

    public long getIdTo() {
        return idTo;
    }
}

