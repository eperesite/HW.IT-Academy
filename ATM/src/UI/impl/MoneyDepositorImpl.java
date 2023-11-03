package UI.impl;


import UI.MoneyDepositor;
import Engine.Database;

import java.sql.Connection;
import java.sql.Statement;

public class MoneyDepositorImpl implements MoneyDepositor {
    @Override
    public boolean putMoneyIn(double amountPutMoneyInCard) {
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            // Изменяем баланс карты для внесения денег
            String query = "UPDATE balance SET balance = balance + " + amountPutMoneyInCard;
            int rs = stmt.executeUpdate(query);

            con.close();

            return rs > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
