package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by Nezhinskij VV on 26.11.2016.
 */
public class History {
    private ArrayList<MessageContainer> list;

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

    public int notReadMessages(long id){
        int res = 0;
        for (MessageContainer m : list
                )
            if ( !m.isRead() & (id == m.getidDancer2())) res++;
        return res;
    }

    public Set<Long> fromNotReadMessages(long id){
        Set<Long> listOfDancers = new HashSet<>();
        for (MessageContainer m : list
                )
            if ( !m.isRead() & (id == m.getidDancer2())){
                listOfDancers.add(m.getidDancer());
            }
            return listOfDancers;
    }

}
