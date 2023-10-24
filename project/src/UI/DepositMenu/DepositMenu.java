package UI.DepositMenu;

import Engine.Operations.Deposit;

public interface DepositMenu {
    void start();
    void showDeposit(Deposit deposit);
    int accountChoice();
    void ShowChoices(int Constants);

}
