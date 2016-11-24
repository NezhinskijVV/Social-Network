package dao;

import model.Dancer;

import java.util.Collection;

/**
 * 
 * Created by Nezhinskij VV on 17.11.2016.
 */
public interface DancerDao {
    Collection<Dancer> getAll();
    Dancer getById(long id);
    boolean isRegistered(String login, String hashPassword);

}
