package br.com.uemg.autopecas.DAO;

import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public interface CRUD {

    public void create(Object object) throws SQLException;

    public List<Object> read() throws SQLException;

    public void update(Object object) throws SQLException;

    public void delete(Object object) throws SQLException;

}
