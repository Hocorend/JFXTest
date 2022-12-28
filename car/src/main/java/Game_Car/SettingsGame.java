package Game_Car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SettingsGame extends App{
    Separator separator = new Separator();
    boolean mode = getModeScreen();
    Button back = new Button();
    Button apply = new Button();
    Label labelModeScreen = new Label();
    ComboBox<String> modeScreenBox;
    ObservableList<String> modeScreen = FXCollections.observableArrayList("Fullscreen","Windowed");

    public void settingsGame(Stage stage){

        GridPane gridPaneSettings = new GridPane();

        ColumnConstraints[]columnConstraints = new ColumnConstraints[5];
        RowConstraints[]rowConstraints = new RowConstraints[5];

        for (int i = 0; i < 5; i++) {
            columnConstraints[i] = new ColumnConstraints();
            rowConstraints[i] = new RowConstraints();
            columnConstraints[i].setPercentWidth(100/5);
            rowConstraints[i].setPercentHeight(100/5);
            gridPaneSettings.getColumnConstraints().add(columnConstraints[i]);
            gridPaneSettings.getRowConstraints().add(rowConstraints[i]);
        }

        labelModeScreen.setText("Label mode: ");
        gridPaneSettings.add(labelModeScreen,0,1);

        modeScreenBox = new ComboBox<>(modeScreen);
        modeScreenBox.setMinWidth(100);
        gridPaneSettings.setMargin(modeScreenBox,new Insets(10));
        gridPaneSettings.add(modeScreenBox,1,1);

        modeScreenBox.setValue("Windowed");
        if(mode){
            modeScreenBox.setValue("Fullscreen");
        } else modeScreenBox.setValue("Windowed");

        labelModeScreen.setText("Window mode:");

        back.setText("Back");
        back.setMinWidth(50);
        gridPaneSettings.setMargin(back, new Insets(10));
        gridPaneSettings.add(back,4,3);

        back.setOnAction(ae -> {
                MenuGame menuGame = new MenuGame();
                menuGame.menu(stage);
            });

        apply.setText("Apply");
        apply.setMinWidth(50);
        gridPaneSettings.setMargin(apply, new Insets(20));
        gridPaneSettings.add(apply,3,3);

        apply.setOnAction(ae -> {
                setModeScreen(mode);
                stage.setFullScreen(getModeScreen());
            });

        modeScreenBox.setOnAction(ae -> {
                if("Fullscreen" == modeScreenBox.getValue()){
                    mode = true;
                }
                else mode = false;
            });

        gridPaneSettings.setPadding(new Insets(10,10,10,10));



        Scene scene = new Scene(gridPaneSettings,500,500);

        stage.setScene(scene);
        stage.setFullScreen(getModeScreen());

        stage.show();

    }
}
