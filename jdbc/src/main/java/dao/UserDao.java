package dao;

import model.User;

import java.util.Collection;

/**
 * Created by Nezhinskij VV on 17.11.2016.
 */
public interface UserDao {
    Collection<User> getAll();
    User getById(long id);
}
