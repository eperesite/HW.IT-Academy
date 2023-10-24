package UI.TransferMenu;

import Engine.Operations.FastCash;
import Engine.Operations.Transfer;

public interface TransferMenu {
    void start();
    void showTransfer(Transfer transfer);
    int userChoice();
    void ShowChoices(int Constants);
}
