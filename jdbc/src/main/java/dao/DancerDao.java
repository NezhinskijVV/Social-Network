package dao;

import model.Dancer;

import java.util.Collection;


public interface DancerDao {
    Collection<Dancer> getAll();
    Dancer getById(long id);
    long isRegistered(String login, String hashPassword);
}
