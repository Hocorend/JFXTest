package Game_Car;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application{

    static Stage window;

    Button startGame;
    Button settingsGame;
    Button exitGame;
    boolean modeScreen = false;

    public void setModeScreen(boolean modeScreen) {
        this.modeScreen = modeScreen;
    }

    public boolean getModeScreen(){
        return modeScreen;
    }

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setMinHeight(200);
        window.setMinWidth(200);
        window.setMaxHeight(1000);
        window.setMaxWidth(1000);

        MenuGame menuGame = new MenuGame();
        menuGame.menu(window);

        window.setOnCloseRequest(ae -> {
            ae.consume();
            ConfirmExit.confirm();
        });
    }

}