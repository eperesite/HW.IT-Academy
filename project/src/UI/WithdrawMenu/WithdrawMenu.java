package UI.WithdrawMenu;

import Engine.Operations.Transfer;
import Engine.Operations.Withdraw;

public interface WithdrawMenu {
    void start();
    void showWithdraw(Withdraw withdraw);
    int userChoice();
    void ShowChoices(int Constants);
}
