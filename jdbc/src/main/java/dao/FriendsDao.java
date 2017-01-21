package dao;

import common.ConnectionPoolException;
import model.Dancer;

import java.sql.SQLException;
import java.util.Collection;


/**
 * Created by Nezhinskij VV on 25.12.2016.
 *
 */
public interface FriendsDao {
    Collection<Long> getIdsById(long id) throws ConnectionPoolException, SQLException;
    Collection<Dancer> getDancersById(long id) throws ConnectionPoolException, SQLException;
    boolean isFriend(long id, long friendsId);
    void addFriend(long id, long friendId);
}
