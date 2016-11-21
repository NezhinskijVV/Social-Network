package dao;

import model.Person;

import java.util.Collection;

/**
 * 
 * Created by Nezhinskij VV on 17.11.2016.
 */
public interface PersonDao {
    Collection<Person> getAll();
    Person getById(long id);
    boolean isRegistered(String login, String hashPassword);

}
