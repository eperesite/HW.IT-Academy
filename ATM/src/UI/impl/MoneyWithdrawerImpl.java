package UI.impl;

import UI.MoneyWithdrawer;
import Engine.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MoneyWithdrawerImpl implements MoneyWithdrawer {
    @Override
    public boolean withdrawFromTheCard(double amountWithdrawCard) {
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            // Проверяем, достаточно ли средств на балансе
            String checkBalanceQuery = "SELECT balance FROM balance";
            ResultSet rs = stmt.executeQuery(checkBalanceQuery);

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                if (currentBalance >= amountWithdrawCard) {
                    // Снимаем деньги с баланса
                    String withdrawQuery = "UPDATE balance SET balance = balance - " + amountWithdrawCard;
                    int rs2 = stmt.executeUpdate(withdrawQuery);

                    con.close();

                    return rs2 > 0;
                } else {
                    System.out.println("Недостаточно средств на балансе");
                    return false;
                }
            } else {
                System.out.println("Ошибка при проверке баланса");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
