import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyPlane extends Thread{

    public GameFrame gf;
    int x = 200,y = 650;
    int width = 35;
    int height = 35;

    int speed = 5;
    Image image = new ImageIcon("Img/MyPlane02.png").getImage();

    boolean up,down,left,right;

    int code;




//    public void draw(Graphics g){
//        g.drawImage(image,x-44,y,null);
//    }


    public MyPlane(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public MyPlane(){}


    @Override
    public void run() {
        while(true){

            if(up){
                if(y!=0) {
                    y -= speed;
                }

            }
            if(down){
                if(y!=720){
                    y +=speed;
                }
            }
            if(left){
                if(x!=0) {
                    x -= speed;
                }
            }
            if(right){
                if(x!=400) {
                    x += speed;
                }
            }

//            else if(hit()){
//                this.speed = 0;
//                this.image = new ImageIcon("Img/boom6.png").getImage();
//                try {
//                    this.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                break;
//            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public Boolean hit(){
        Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.height);

        Rectangle rect = null;

        for(int i =0;i<gf.enemyPlanes.size();i++){
            EnemyPlane enemyPlane = gf.enemyPlanes.get(i);
            rect = new Rectangle(enemyPlane.x,enemyPlane.y-1,enemyPlane.width,enemyPlane.height);
            if(myrect.intersects(rect)){
                return true;
            }

        }
        return false;

    }

}
