package dao;

import model.Dancer;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


public interface DancerDao {
    Collection<Dancer> getAll();
    Dancer getById(long id);
    boolean isRegistered(HttpServletRequest req, String login, String hashPassword);
}
