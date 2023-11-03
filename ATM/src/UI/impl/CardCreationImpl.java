package UI.impl;

import UI.CardCreation;
import Engine.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class CardCreationImpl implements CardCreation {
    @Override
    public boolean createNewAccount(String userFirstName, String userLastName) {
        // Генерируем номер карты и код
        String cardNumber = generateCardNumber();
        String cardCode = generateCode();

        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            // Вставляем информацию о новой карте (номер карты и код)
            int rs = stmt.executeUpdate("INSERT INTO cards (card_number, card_code) VALUES ('" + cardNumber + "', '" + cardCode + "')", Statement.RETURN_GENERATED_KEYS);

            if (rs == 0) {
                return false;
            }

            int lastInsertId = -1;

            // Получаем ID новой карты
            ResultSet rs_last_id = stmt.getGeneratedKeys();

            if (rs_last_id.next()) {
                lastInsertId = rs_last_id.getInt(1);
            }

            // Вставляем информацию о балансе новой карты
            int rs2 = stmt.executeUpdate("INSERT INTO balance (card_id, balance) VALUES (" + lastInsertId + ", 0)");

            if (rs2 == 0) {
                return false;
            }

            // Вставляем информацию о владельце карты (имя и фамилия)
            int rs3 = stmt.executeUpdate("INSERT INTO account_detail (card_id, first_name, last_name) VALUES (" + lastInsertId + ", '" + userFirstName + "', '" + userLastName + "')");

            if (rs3 == 0) {
                return false;
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n");
        System.out.println(userFirstName + " " + userLastName);

        System.out.println("Номер карты: " + cardNumber);
        System.out.println("Код: " + cardCode);

        return true;
    }

    // Метод для генерации номера карты (ваш существующий метод)
    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder(10);

        // Генерируем 10 случайных цифр для номера карты
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            cardNumber.append(digit);
        }

        return cardNumber.toString();
    }


    // Метод для генерации кода (ваш существующий метод)
    private String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder(3);

        // Генерируем 3 случайных цифры для кода карты
        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(10);
            code.append(digit);
        }

        return code.toString();
    }

}