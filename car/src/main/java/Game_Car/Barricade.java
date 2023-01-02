package Game_Car;

public class Barricade extends Game implements Runnable{
    private int x;
    private int y;
    private int count = 1;
    private int height;
    private int weight;

    Thread t;

    Barricade(int x,int y){
        height = 0;
        weight = 40;
        this.x = x;
        this.y = y;
        t = new Thread(this,"Barricade stream");
        t.start();
    }

    Barricade(){}

    public void barricade(){
        if(count<=4){
            y=0;
            height+=10;
        } else {
            y+=10;
        }
        if (y==450){
            height=0;
            y=0;
            count = 0;
        }
        count++;
    }

    public void run(){
        while (true){
            barricade();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getWeight() {
        return weight;
    }
}
