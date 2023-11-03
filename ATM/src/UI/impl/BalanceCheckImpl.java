package UI.impl;

import UI.BalanceCheck;
import Engine.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BalanceCheckImpl implements BalanceCheck {
    private String cardNumber;
    private String cardCode;

    public BalanceCheckImpl() {
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
    }

    @Override
    public double checkBalance() {
        double cardBalance = 0.0;

        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            // Найдем ID карты по номеру и коду
            ResultSet rs = stmt.executeQuery("SELECT * FROM cards WHERE card_number = '" + cardNumber + "' AND card_code = '" + cardCode + "'");
            int cardId = -1;

            if (rs.next()) {
                cardId = rs.getInt("id");
            } else {
                // Вернем нулевой баланс, так как карта не найдена
                return cardBalance;
            }

            // Получим баланс карты
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM balance WHERE card_id = " + cardId);

            if (rs3.next()) {
                cardBalance = rs3.getDouble("balance");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return cardBalance;
    }
}