package dao;

import model.Style;

import java.util.Collection;

/**
 *
 * Created by Nezhinskij VV on 23.11.2016.
 */
public interface StyleDao {
    Collection<Style> getAll();
    Style getById();
}
