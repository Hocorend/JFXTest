package Game_Car;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuGame extends App{
    App app = new App();
    ConfirmExit confirmExit = new ConfirmExit();
    Button startGame;
    Button settingsGame;
    Button exitGame;

    public void menu(Stage stage){
        stage.setTitle("Car");
        startGame = new Button();
        startGame.setText("Start");

        settingsGame = new Button();
        settingsGame.setText("Settings");

        exitGame = new Button();
        exitGame.setText("Exit");

        startGame.setOnAction(ae -> {

            //Game

            });

        settingsGame.setOnAction(ae -> {
                SettingsGame settingsGame = new SettingsGame();
                settingsGame.settingsGame(stage);
            });

        exitGame.setOnAction((ea)-> confirmExit.confirm());

        FlowPane flowPaneMenu = new FlowPane(Orientation.VERTICAL,10,20);
        flowPaneMenu.setAlignment(Pos.CENTER);
        flowPaneMenu.setColumnHalignment(HPos.CENTER);
        flowPaneMenu.getChildren().addAll(startGame,settingsGame,exitGame);

        Scene sceneMenu = new Scene(flowPaneMenu,500,500);



        stage.setScene(sceneMenu);
        stage.setFullScreen(getModeScreen());

        stage.show();
    }
}
