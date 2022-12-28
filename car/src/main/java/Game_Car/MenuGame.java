package Game_Car;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuGame extends App{
    App app = new App();
    ConfirmExit confirmExit = new ConfirmExit();
    Button startGame;
    Button settingsGame;
    Button exitGame;

    public void menu(Stage stage){
        GridPane gridPaneMenu = new GridPane();

        ColumnConstraints[]columnConstraints = new ColumnConstraints[5];
        RowConstraints[]rowConstraints = new RowConstraints[5];

        for (int i = 0; i < 5; i++) {
            columnConstraints[i] = new ColumnConstraints();
            rowConstraints[i] = new RowConstraints();
            columnConstraints[i].setPercentWidth(100/5);
            rowConstraints[i].setPercentHeight(100/5);
            gridPaneMenu.getColumnConstraints().add(columnConstraints[i]);
            gridPaneMenu.getRowConstraints().add(rowConstraints[i]);
        }

        stage.setTitle("Car");
        startGame = new Button();
        startGame.setText("Start");
        startGame.setMaxWidth(Double.MAX_VALUE);
        startGame.setMaxHeight(Double.MAX_VALUE);
        gridPaneMenu.setHgrow(startGame,Priority.ALWAYS);
        gridPaneMenu.setVgrow(startGame,Priority.ALWAYS);
        gridPaneMenu.setMargin(startGame,new Insets(10));
        gridPaneMenu.add(startGame,2,1);

        settingsGame = new Button();
        settingsGame.setText("Settings");
        settingsGame.setMaxWidth(Double.MAX_VALUE);
        settingsGame.setMaxHeight(Double.MAX_VALUE);
        gridPaneMenu.setHgrow(settingsGame,Priority.ALWAYS);
        gridPaneMenu.setVgrow(settingsGame,Priority.ALWAYS);
        gridPaneMenu.setMargin(settingsGame,new Insets(10));
        gridPaneMenu.add(settingsGame,2,2);

        exitGame = new Button();
        exitGame.setText("Exit");
        exitGame.setMaxWidth(Double.MAX_VALUE);
        exitGame.setMaxHeight(Double.MAX_VALUE);
        gridPaneMenu.setHgrow(exitGame,Priority.ALWAYS);
        gridPaneMenu.setVgrow(exitGame,Priority.ALWAYS);
        gridPaneMenu.setMargin(exitGame,new Insets(10));
        gridPaneMenu.add(exitGame,2,3);

        startGame.setOnAction(ae -> {

            //Game

            });

        settingsGame.setOnAction(ae -> {
                SettingsGame settingsGame = new SettingsGame();
                settingsGame.settingsGame(stage);
            });

        exitGame.setOnAction((ea)-> confirmExit.confirm());

        gridPaneMenu.setPadding(new Insets(10,10,10,10));

        Scene sceneMenu = new Scene(gridPaneMenu,500,500);

        stage.setScene(sceneMenu);
        stage.setFullScreen(getModeScreen());

        stage.show();
    }
}
