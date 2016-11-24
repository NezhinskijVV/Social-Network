package dao;

import model.Dancer;

import java.util.Collection;


public interface DancerDao {
    Collection<Dancer> getAll();
    Dancer getById(long id);
    boolean isRegistered(String login, String hashPassword);

}
