package UI.impl;

import Engine.Database;
import UI.MoneyTransfer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MoneyTransferImpl implements MoneyTransfer {
    private String cardNumber;
    private String cardCode;

    public MoneyTransferImpl() {
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
    }

    @Override
    public int transferToOther(String otherCardNumber, double amountToOtherCard) {
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            // Найдем ID карты текущего пользователя по номеру и коду
            ResultSet rs = stmt.executeQuery("SELECT * FROM cards WHERE card_number = '" + cardNumber + "' AND card_code = '" + cardCode + "'");
            int senderCardId = -1;

            if (rs.next()) {
                senderCardId = rs.getInt("id");
            } else {
                // Карта не найдена, возвращаем код ошибки -1
                return -1;
            }

            // Проверим баланс отправителя
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM balance WHERE card_id = " + senderCardId);
            double senderBalance = 0.0;

            if (rs2.next()) {
                senderBalance = rs2.getDouble("balance");
            }

            if (senderBalance < amountToOtherCard) {
                // Недостаточно средств на балансе, возвращаем код ошибки -2
                return -2;
            }

            // Найдем ID карты получателя по номеру
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM cards WHERE card_number = '" + otherCardNumber + "'");
            int receiverCardId = -1;

            if (rs3.next()) {
                receiverCardId = rs3.getInt("id");
            } else {
                // Карта получателя не найдена, возвращаем код ошибки -3
                return -3;
            }

            // Выполняем перевод
            double newSenderBalance = senderBalance - amountToOtherCard;
            double newReceiverBalance = 0.0;

            // Обновляем баланс отправителя
            int rs4 = stmt.executeUpdate("UPDATE balance SET balance = " + newSenderBalance + " WHERE card_id = " + senderCardId);

            if (rs4 == 0) {
                // Ошибка при обновлении баланса отправителя, возвращаем код ошибки -4
                return -4;
            }

            // Получаем текущий баланс получателя
            ResultSet rs5 = stmt.executeQuery("SELECT * FROM balance WHERE card_id = " + receiverCardId);

            if (rs5.next()) {
                newReceiverBalance = rs5.getDouble("balance");
            }

            newReceiverBalance += amountToOtherCard;

            // Обновляем баланс получателя
            int rs6 = stmt.executeUpdate("UPDATE balance SET balance = " + newReceiverBalance + " WHERE card_id = " + receiverCardId);

            if (rs6 == 0) {
                // Ошибка при обновлении баланса получателя, возвращаем код ошибки -5
                return -5;
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Перевод выполнен успешно, возвращаем код успеха 0
        return 0;
    }
}
