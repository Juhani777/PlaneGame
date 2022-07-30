import javax.swing.*;
import java.awt.*;

public class Bullet{

    int x,y;
    int width = 40;
    int height = 40;
    int speed = 10;
    Image image = new ImageIcon("Img/mybullets6.png").getImage();


    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//    public void run(){
//        while(true){
//            y-=speed;
//            if (y==-5){
//                break;
//            }
//        }
//    }
}
