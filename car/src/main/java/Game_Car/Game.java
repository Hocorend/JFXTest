package Game_Car;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.lang.annotation.Annotation;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements EventHandler<KeyEvent>{



    double x;
    double y;

    Button pause = new Button("Pause");

    Canvas canvas = new Canvas();
    GraphicsContext gc = canvas.getGraphicsContext2D();
    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane,500,500);
    Barricade barricade1,barricade2,barricade3,barricade4,barricade5,barricade6;

    public void game(Stage stage){
        barricade1 = new Barricade(20,0);







        Button left = new Button("Left");
        left.setPrefSize(100,Double.MAX_VALUE);
        Button right = new Button("Right");
        right.setPrefSize(100,Double.MAX_VALUE);

        pause.setPrefSize(Double.MAX_VALUE,50);

        canvas = new Canvas(scene.getWidth()-200,scene.getHeight()-50);

        gc = canvas.getGraphicsContext2D();
        x = canvas.getWidth()/2-20;
        y = canvas.getHeight()-40;
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.clearRect(20,0,canvas.getWidth()-40,canvas.getHeight());

                gc.fillRect(0,0,20,canvas.getHeight());
                gc.fillRect(canvas.getWidth()-20,0,20,canvas.getHeight());
                gc.fillRect(x, y, 40, 40);

                gc.fillRect(barricade1.getX(),barricade1.getY(), barricade1.getWeight(), barricade1.getHeight());
            }
        };
        timer.start();



        gc.fillRect(0,0,20,canvas.getHeight());
        gc.fillRect(canvas.getWidth()-20,0,20,canvas.getHeight());



        left.setOnAction(actionEvent -> {if(pause.getText()=="Pause")left();});
        right.setOnAction(actionEvent -> {if(pause.getText()=="Pause")right();});

        pause.setOnAction(actionEvent -> {
                if(pause.getText()=="Pause"){
                    timer.stop();
                    pause.setText("Play");
                } else if (pause.getText()=="Play") {
                    timer.start();
                    pause.setText("Pause");
                }
        });

        scene.setOnKeyPressed(this);

        borderPane.setLeft(left);
        borderPane.setRight(right);
        borderPane.setTop(pause);



        borderPane.setCenter(canvas);

        stage.setScene(scene);
        stage.show();
    }

    public void left(){
        if(x!=20) {
            x = x - 10;
        }
    }

    public void right(){
        if(x!=canvas.getWidth()-60){
            x=x+10;
        }
    }

    public void handle(KeyEvent event) {
        if(pause.getText()=="Pause") {
            if (event.getCode().toString() == "A") left();
            if (event.getCode().toString() == "D") right();
        }
    }
}
