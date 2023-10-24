package UI.LoginScreen;
import Engine.Authentication.LoginManager;

public interface LoginScreen {

    void start();
    int accountChoice();
    void showAvailableChoices(int constants);
    public int ShowLoginScreen();
}
