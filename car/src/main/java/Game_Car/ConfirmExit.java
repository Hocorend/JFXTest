package Game_Car;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmExit extends App{

    public static void confirm(){
        Stage windowExit = new Stage();
        windowExit.initModality(Modality.APPLICATION_MODAL);
        windowExit.setTitle("Exit confirmation");

        Label label = new Label("You want to close the game?");
        label.setText(label.getText());

        Button answerYes = new Button("Yes");
        Button answerNo = new Button("No");

        answerYes.setOnAction(ae -> {
            windowExit.close();
            window.close();
            });

        answerNo.setOnAction(ae -> windowExit.close());

        FlowPane flowPane = new FlowPane(10,10);
        flowPane.setAlignment(Pos.CENTER);

        flowPane.getChildren().addAll(label,answerYes,answerNo);
        Scene scene = new Scene(flowPane, 450,100);

        windowExit.setScene(scene);
        windowExit.showAndWait();

    }
}
