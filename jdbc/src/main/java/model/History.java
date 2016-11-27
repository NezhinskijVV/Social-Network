package model;

import java.util.ArrayList;

/**
 *
 * Created by Nezhinskij VV on 26.11.2016.
 */
public class History {
    private ArrayList<MessageContainer> list;
    //private ArrayList<MessageContainer> isntReadList;

    public History() {
        list = new ArrayList<>();
    }

    public ArrayList<MessageContainer> getList() {
        return list;
    }

    public void setList(ArrayList<MessageContainer> list) {
        this.list = list;
    }

    public void addToHistory(MessageContainer m){
        if (!m.isRead()){
            list.add(m);
        }
    }


}
