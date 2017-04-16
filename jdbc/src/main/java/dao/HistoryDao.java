package dao;

import model.MessageContainer;

import java.util.Collection;
import java.util.List;

/**
 * Created by Nezhinskij VV on 29.03.2017.
 *
 */
public interface HistoryDao {
    Collection<MessageContainer> getByIds(long id, long id2);
    void addReadMessage(MessageContainer ms);
}
