package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String url = "jdbc:mysql://localhost:3306/db_hr?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";

    private Connection connection;

    public Connection getConnect(){
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            this.connection = connection;
            return this.connection;
        }catch(SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }
}
