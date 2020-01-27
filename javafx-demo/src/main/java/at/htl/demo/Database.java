package at.htl.demo;

import org.apache.derby.jdbc.ClientDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    static final String db = "db";
    static final String username = "app";
    static final String password = "app";

    public DataSource getDataSource(){

        ClientDataSource dataSource = new ClientDataSource();
        dataSource.setDatabaseName(db);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;

    }

    public void createTable(){

        try(Connection conn = getDataSource().getConnection()) {

            String sql = "create table test (" +
                    "int id primary key," +
                    "varchar(250) name" +
                    ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
