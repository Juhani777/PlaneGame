import javax.swing.*;
import java.awt.*;

public class EnemyPlane extends Thread{

    public GameFrame gf;
    public int x,y;
    public int width = 50;
    public int height = 50;
    public int speed = 2;

    public Image image = new ImageIcon("Img/Enemy01.png").getImage();

    public EnemyPlane(int x,int y,GameFrame gf){
        this.x = x;
        this.y = y;
        this.gf = gf;
    }

    public EnemyPlane(int x,int y,int width,int height,GameFrame gf){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gf = gf;
    }

    @Override
    public void run(){
        while(true){
            if(hit()) {
                this.speed = 0;
                this.image = new ImageIcon("Img/boom2.png").getImage();
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                gf.enemyPlanes.remove(this);

                break;
            }

            if(this.y>=850){
                break;
            }
            try{
                this.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public boolean hit(){
        Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.height);

        Rectangle rect = null;

        for(int i =0;i<gf.bullets.size();i++){
            Bullet bullet = gf.bullets.get(i);
            rect = new Rectangle(bullet.x,bullet.y-1,bullet.width,bullet.height);

            if(myrect.intersects(rect)){
                return true;
            }
        }
        return false;
    }



}
