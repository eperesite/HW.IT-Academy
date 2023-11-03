import Engine.User;
import Engine.UserInput;
import UI.*;
import UI.impl.*;

public class Main {
    public static void main(String[] args) {
        String otherCardNumber = UserInput.enterCardNumber();
        double amountToOtherCard = UserInput.enterAmount();

// Вызов методов для ввода данных
        String userFirstName = UserInput.enterFirstName();
        String userLastName = UserInput.enterLastName();
        String cardNumber = UserInput.enterCardNumber();
        String cardCode = UserInput.enterCode();
        Double amount = UserInput.enterAmount();

        // Создание экземпляра класса User
        User user = new User(userFirstName, userLastName);

        // Вызов методов для выполнения операций с аккаунтом
        Boolean accountWasCreated = user.createNewAccount();
        Double cardBalance = user.checkBalance();
        Integer cardId = user.getCardId();
        Integer otherCardId = user.getCardIdByNumber(cardNumber);
        Integer putMoneyInSuccess = user.putMoneyIn(amount);
        Integer withdrawSuccess = user.withdrawFromTheCard(amount);
        Integer transferSuccess = user.transferToOther(otherCardId, amount);

        CardCreation cardCreation = new CardCreationImpl();
        BalanceCheck balanceCheck = new BalanceCheckImpl();
        MoneyDepositor moneyDepositor = new MoneyDepositorImpl();
        MoneyWithdrawer moneyWithdrawer = new MoneyWithdrawerImpl();
        MoneyTransfer moneyTransfer = new MoneyTransferImpl();

        boolean accountWasCreated = cardCreation.createNewAccount(userFirstName, userLastName);
        double cardBalance = balanceCheck.checkBalance();
        int putMoneyInSuccess = moneyDepositor.putMoneyIn(amountPutMoneyInCard);
        int withdrawSuccess = moneyWithdrawer.withdrawFromTheCard(amountWithdrawCard);
        int transferSuccess = moneyTransfer.transferToOther(otherCardNumber, amountToOtherCard);

    }
}