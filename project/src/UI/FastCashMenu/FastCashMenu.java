package UI.FastCashMenu;

import Engine.Operations.Deposit;
import Engine.Operations.FastCash;

public interface FastCashMenu {
    void start();
    void showFastCash(FastCash fastCash);
    int userChoice();
    void ShowChoices(int Constants);
}
