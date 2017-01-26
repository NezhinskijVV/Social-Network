package dao;

import model.Dancer;

import java.util.Collection;
import java.util.Date;


public interface DancerDao {
    Collection<Dancer> getAll();
    Dancer getById(long id);
    boolean existingEmail(String email);
    long isRegistered(String login, String hashPassword);
    void register(String name, String surname, Date dob, String nickname, String email, String password, String telephone, long style);
}
