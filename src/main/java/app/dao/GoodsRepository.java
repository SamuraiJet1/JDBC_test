package app.dao;

import app.entity.Good;
import app.exceptions.PreparedExseptions;
import app.util.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class GoodsRepository {
    public static void insert (Good good) throws PreparedExseptions{

        String sql = "INSERT INTO GOODS (NAME, AMOUNT,COUNT) VALUES (?,?,?);";

        try(Connection connection= MyConnection.getConnection()){
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setString(1,good.getName());
            preparedStatement.setDouble(2, good.getAmount());
            preparedStatement.setInt(3,good.getCount());
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        }catch (SQLException ex){
            throw new PreparedExseptions(ex.getMessage());
        }

    }

    public  static List<Good> get() throws PreparedExseptions{
        String sql = "SELECT * FROM GOODS";

        try(Connection connection= MyConnection.getConnection()){
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Good> goods= new ArrayList<>();
            while (resultSet.next()){
                Good good = new Good();
                good.setId(resultSet.getInt("ID"));
                good.setName(resultSet.getString("NAME"));
                good.setAmount(resultSet.getDouble("AMOUNT"));
                good.setCount(resultSet.getInt("COUNT"));
                goods.add (good);
            }
            return goods;

        }catch (SQLException ex){
            throw new PreparedExseptions(ex.getMessage());
        }
    }
    public  static Good getOne(int id) throws PreparedExseptions{
        String sql = "SELECT * FROM GOODS WHERE ID = "+ id;

        try(Connection connection= MyConnection.getConnection()){
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            Good good= new Good();

             if (resultSet.next())   {
                good.setId(resultSet.getInt("ID"));
                good.setName(resultSet.getString("NAME"));
                good.setAmount(resultSet.getDouble("AMOUNT"));
                good.setCount(resultSet.getInt("COUNT"));

            }
            return good;

        }catch (SQLException ex){
            throw new PreparedExseptions(ex.getMessage());
        }
    }

    public  static void delete(int id) throws PreparedExseptions{
        String sql = "DELETE FROM GOODS WHERE ID = "+ id;

        try(Connection connection= MyConnection.getConnection()){
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new PreparedExseptions(ex.getMessage());
        }
    }




}
