package app;


import app.dao.PreparedDB;
import app.entity.Good;
import app.dao.GoodsRepository;
import app.exceptions.PreparedExseptions;

import java.util.List;

//Connection- для подключения к ДБ
//Statment - для выполнения запросов
//PrepareStatement
//ResultSet

public class App {

    public static void main(String[] args) {
        try {

            GoodsRepository.delete(3);
            PreparedDB.prepared();
//            Good good = new Good ("Steak",1500,10);
//            GoodsRepository.insert(good);
//            System.out.println(GoodsRepository.getOne(3));
//            List<Good> goodList = GoodsRepository.get();
//            for (Good good: goodList){
//                System.out.println(good);
//            }
        } catch (PreparedExseptions ex) {
            System.out.println(ex.getMessage());
        }




    }
}
