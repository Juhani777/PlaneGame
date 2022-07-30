import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;


//  用上下左右键盘控制方向
//  用Q/q键进行射击

public class GameFrame extends JFrame {

//    Background bg = new Background();
    Image bgimage;
//    Image mpimage;
    MyPlane myPlane;

    Vector<Bullet> bullets = new Vector<>();
    Vector<EnemyPlane>enemyPlanes = new Vector<>();
    GameFrame frame;

    public GameFrame(){

        frame = this;
        myPlane = new MyPlane();
        new Thread(myPlane).start();


         bgimage = new ImageIcon("Img/background01.jpg").getImage();

        this.setSize(500,850);
        this.setTitle("雷霆战机");
//        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

//        JProgressBar bar = new JProgressBar(1, 100);
//        bar.setStringPainted(true); //描绘文字
//        bar.setString("加载飞机和子弹中,请稍候，精彩马上开始");  //设置显示文字
//        bar.setBackground(Color.ORANGE);  //设置背景色
//        bar.setBounds(100, 800, 1000, 100);//设置大小和位置
//        bar.setValue(20); //设置进度条值



        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
//                    myPlane.move();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            Random random = new Random();
            @Override
            public void run() {
                while(true){
                    EnemyPlane enemyPlane = new EnemyPlane(random.nextInt(500),0,frame);
//                    enemyPlanes.add(new EnemyPlane(random.nextInt(500),0,frame));
                    enemyPlane.start();
                    enemyPlanes.add(enemyPlane);
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }



    public void paint(Graphics g){
//        Image bgimage = new ImageIcon("Background01.jpg").getImage();
//        System.out.println("绘制画板");

        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);
        Graphics bi = image.getGraphics();

        bi.drawImage(bgimage,0,0,null);
        bi.drawImage(myPlane.image, myPlane.x,myPlane.y,null);
        for(int i=0;i<bullets.size();i++){
//            System.out.println(bullets);
            Bullet bullet = bullets.get(i);
            if(bullet.y>=-1) {
//                bi.drawImage(bullet.image, bullet.x-25,bullet.y-=bullet.speed,bullet.width,bullet.height,null);
                bi.drawImage(bullet.image, bullet.x-10, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
                bi.drawImage(bullet.image, bullet.x+10, bullet.y -= bullet.speed, bullet.width, bullet.height, null);

            } else
                bullets.remove(bullet);
        }

        for(int i=0;i<enemyPlanes.size();i++){
//            System.out.println(bullets);
             EnemyPlane enemy = enemyPlanes.get(i);
//             enemy.start();
            if(enemy.y<=850)
                bi.drawImage(enemy.image, enemy.x,enemy.y+=enemy.speed,enemy.width,enemy.height,null);
            else
                enemyPlanes.remove(enemy);
        }


        g.drawImage(image,0,0,null);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        Player player = new Player(frame);
        frame.addKeyListener(player);

        System.out.println("用上下左右键盘控制方向");
        System.out.println("用Q/q键进行射击");
    }





}
