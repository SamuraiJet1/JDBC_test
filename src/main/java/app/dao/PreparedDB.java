package app.dao;

import app.exceptions.PreparedExseptions;
import app.util.MyConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class PreparedDB {
    public static void prepared() throws PreparedExseptions {
        createTableGoods();
        insertGoods();
    }

    private static void createTableGoods() throws PreparedExseptions {
        String sql = "CREATE TABLE IF NOT EXISTS GOODS (" +
                "ID INT AUTO_INCREMENT,"+
                "NAME VARCHAR (255) NOT NULL,"+
                "AMOUNT NUMBER (10,2),"+
                "COUNT INT"+
                ")";

        try (Connection connection= MyConnection.getConnection();
            Statement statement = connection.createStatement()
        ){
            statement.execute(sql);

        }catch (SQLException ex){
            throw new PreparedExseptions(ex.getMessage());
        }
    }

    private static void insertGoods() throws PreparedExseptions {
        String sql = "INSERT INTO GOODS (NAME, AMOUNT,COUNT) VALUES ('Milk',50,10);" +
                "INSERT INTO GOODS (NAME, AMOUNT,COUNT) VALUES ('Bread',30,5);" +
                "INSERT INTO GOODS (NAME, AMOUNT,COUNT) VALUES ('Meat',250,3);" ;

        try (Connection connection= MyConnection.getConnection();
             Statement statement = connection.createStatement()
        ){
            statement.execute(sql);

        }catch (SQLException ex){
            throw new PreparedExseptions(ex.getMessage());
        }




    }
}
