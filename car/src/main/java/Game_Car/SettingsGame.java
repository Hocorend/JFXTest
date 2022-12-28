package Game_Car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
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
        separator.setPrefWidth(200);
        modeScreenBox = new ComboBox<>(modeScreen);
        modeScreenBox.setValue("Windowed");
        if(mode){
            modeScreenBox.setValue("Fullscreen");
        } else modeScreenBox.setValue("Windowed");

        labelModeScreen.setText("Window mode:");

        back.setText("Back");

        back.setOnAction(ae -> {
                MenuGame menuGame = new MenuGame();
                menuGame.menu(stage);
            });

        apply.setText("Apply");

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

        FlowPane flowPane = new FlowPane(Orientation.VERTICAL,10,20);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().addAll(labelModeScreen,modeScreenBox,separator,apply,back);


        Scene scene = new Scene(flowPane,500,500);

        stage.setScene(scene);
        stage.setFullScreen(getModeScreen());

        stage.show();

    }

}
