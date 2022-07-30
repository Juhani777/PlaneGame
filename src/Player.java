import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {

//    MyPlane myPlane;

    GameFrame frame;
    public Player(GameFrame frame){
        this.frame = frame;
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
//        myPlane.code = code;
//        myPlane.move();
        if(code==38){
            frame.myPlane.up = true;
        }
        else if(code==40){
            frame.myPlane.down = true;
        }
        else if(code==37){
            frame.myPlane.left = true;
        }
        else if(code==39){
            frame.myPlane.right = true;
        }
        else if(code==81){
            addBullet();
        }

    }

    public void keyTyped(KeyEvent e){};

    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
//        myPlane.code = code;
//        myPlane.move();
        if(code==38){
            frame.myPlane.up = false;
        }
        else if(code==40){
            frame.myPlane.down = false;
        }
        else if(code==37){
            frame.myPlane.left = false;
        }
        else if(code==39){
            frame.myPlane.right = false;
        }
    };



    public void addBullet(){
        frame.bullets.add(new Bullet(frame.myPlane.x+35,frame.myPlane.y-20));

    }
}
