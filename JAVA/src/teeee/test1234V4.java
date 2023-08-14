package teeee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.Highlighter.Highlight;

import jdk.incubator.vector.VectorOperators.Test;



public class test1234V4 extends JFrame {
    protected static final int WIDTH = 600;
    private static final int HEIGHT = 800;

	private JPanel gamePanel;
	private Timer timer;
	private int ballX, ballY, ballX_green = BALL_INITIAL_X_green, ballY_green = BALL_INITIAL_Y_green;
	private int paddleX, paddleX_Red;
	private int ballSpeedX, ballSpeedY, ballSpeedX_green, ballSpeedY_green;
	static int score_Blue;
	private int score_Red;
	private boolean isGameRunning; // 遊戲開始狀態為false尚未開始
	public static String playerName;


 
    
    private static final int PADDLE_WIDTH_BLUE= 100;
    private static final int PADDLE_WIDTH_RED= 100;
    private static final int PADDLE_HEIGHT_BLUE = 10;
    private static final int PADDLE_HEIGHT_RED= 10;
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_Y_RED = HEIGHT - PADDLE_HEIGHT_RED - 790;
    private static final int PADDLE_Y = HEIGHT - PADDLE_HEIGHT_BLUE - 40;
    private static final int BALL_INITIAL_X = WIDTH / 2 - BALL_SIZE / 2;
    private static int BALL_INITIAL_Y = 720;
    private static int BALL_INITIAL_X_green = WIDTH / 2 ;
    private static int BALL_INITIAL_Y_green = HEIGHT / 2;
    
    
    public test1234V4() {
     

		showInputDialog();
		//queryPlayerName();
		setTitle("桌上曲棍球");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gamePanel = new JPanel() { // 這段看不太懂
			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };

        gamePanel.setFocusable(true); //開啟鍵盤功能與setVisible相同意思
        gamePanel.setBackground(Color.BLACK); //設定視窗背景顏色
        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        add(gamePanel);
        initializeGame();

        setVisible(true); //顯示視窗
    }

    
    private void showInputDialog() {
        playerName = JOptionPane.showInputDialog(this, "請輸入您的名字：", "輸入名字", JOptionPane.PLAIN_MESSAGE);
           if (playerName == null || playerName.trim().isEmpty()) {
               int choice = JOptionPane.showConfirmDialog(this, "確定要離開遊戲吗？", "離開遊戲", JOptionPane.YES_NO_OPTION);
               if (choice == JOptionPane.YES_OPTION) {
                   System.exit(0);
               } else {
            	  
                   showInputDialog();
               }
           }
       } 
    
    private void initializeGame() {
     
        ballX = BALL_INITIAL_X;
        ballY = BALL_INITIAL_Y;
//        ballX_green = BALL_INITIAL_X_green;
//        ballY_green = BALL_INITIAL_Y_green;
        
        paddleX = WIDTH / 2 - PADDLE_WIDTH_BLUE / 2;
        paddleX_Red = WIDTH / 2 - PADDLE_WIDTH_RED / 2;
        ballSpeedX = 2;
        ballSpeedY = -2;
        ballSpeedX_green = 2;
        ballSpeedY_green = -2;
        
        
        isGameRunning = true;

        gamePanel.requestFocusInWindow();
        startGameLoop();
    }

    private void startGameLoop() {
     
     
     
        timer = new Timer(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                gamePanel.repaint();
            }
        });
        timer.start();
    }

    public void changeball() {  //換人發球
        BALL_INITIAL_Y = 15;//
        
       }
       public void changeball01() {  //換人發球
        BALL_INITIAL_Y = 720;//
        
       }
    private void updateGame() {
    	ballX += ballSpeedX; //藍色發球起始方向
        ballY += ballSpeedY;//藍色發球起始方向//紅色得分
        ballX_green += ballSpeedX_green;
        ballY_green += ballSpeedY_green;
       
//    	if(ballY >= HEIGHT - BALL_SIZE - BALL_SIZE - BALL_SIZE - PADDLE_HEIGHT_BLUE) { 
//    		if(ballX == paddleX ){
//    			 ballX += ballSpeedX; //藍色發球起始方向
//    		        ballY += ballSpeedY;//藍色發球起始方向//紅色得分
//    		}
//       	
//    	}else if(ballY >= PADDLE_HEIGHT_RED){ //藍色得分
//    		ballX -= ballSpeedX; //紅色發球起始方向
//            ballY -= ballSpeedY;//紅色發球起始方向	
//    	}
        

        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
            ballSpeedX = -ballSpeedX;
       }
        
        if (ballX_green <= 0 || ballX_green >= WIDTH - BALL_SIZE) {
            ballSpeedX_green = -ballSpeedX_green;
       }
        
      
      if (ballY_green <= 0 || ballY_green >= HEIGHT - BALL_SIZE) {
       ballSpeedY_green = -ballSpeedY_green;
      }
//|| ballY >= HEIGHT - BALL_SIZE)
//        if (ballY >= HEIGHT - BALL_SIZE) {
//         ballSpeedY = -ballSpeedY;
//        }
        
//上方邊界
      
//      if (ballY >= HEIGHT - BALL_SIZE - BALL_SIZE - BALL_SIZE - PADDLE_HEIGHT_BLUE) { //藍方撞球判斷
//          if (ballX >= paddleX && ballX <= paddleX + PADDLE_WIDTH_BLUE) {
//              
//           ballSpeedY = -ballSpeedY;               
//              ballSpeedY--;
//              
//          } else {
//           score_Red++;
//              gameOver();               
//              
//          }
//      }

		if (ballY >= HEIGHT - BALL_SIZE - BALL_SIZE - BALL_SIZE - PADDLE_HEIGHT_BLUE) { // 藍方撞球判斷
			if (ballX >= paddleX && ballX <= paddleX + PADDLE_WIDTH_BLUE) {

				ballSpeedY = -ballSpeedY;
				ballSpeedY--;
				

			} else {
				score_Red++;
//				changeball01();
				gameOver();

			}
		}
        
        if (ballY <= PADDLE_HEIGHT_RED) {
            if (ballX >= paddleX_Red && ballX <= paddleX_Red + PADDLE_WIDTH_RED) {
                
             

            	ballSpeedY = -ballSpeedY;
                ballSpeedY++;
            
                
                
            } else {
          
                score_Blue++;
//              changeball();
              gameOver();
            }
        }
 }
 

    private void draw(Graphics g) {
//     Graphics2D g2 = (Graphics2D)g;  //將Graphics g強制轉型為Graphics2D就可設置線條長度與顏色

     
     
     try {
            Image backgroundImage = ImageIO.read(getClass().getResource("/桌上曲棍球桌.png"));
            g.drawImage(backgroundImage, -4, -20, getWidth(), getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
     
//     Stroke stroke = new BasicStroke(3.0f);   
//     g2.setStroke(new BasicStroke(3.0f));
//     g2.setColor(Color.WHITE);
//     g2.drawLine(0, HEIGHT/2, WIDTH, HEIGHT/2);
     
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
        if(score_Blue >2 || score_Red > 2) {
        	 g.setColor(Color.WHITE);
             g.fillOval(ballX_green, ballY_green, BALL_SIZE, BALL_SIZE);

        }
       
        g.setColor(Color.BLUE);
        g.fillRect(paddleX, PADDLE_Y, PADDLE_WIDTH_BLUE, PADDLE_HEIGHT_BLUE);

//        g.setColor(Color.RED);
//        g.fillRect(paddleX_Red,PADDLE_Y_RED, PADDLE_WIDTH_RED, PADDLE_HEIGHT_RED);
        g.setColor(Color.RED);
        g.fillRect(paddleX_Red,PADDLE_Y_RED, PADDLE_WIDTH_RED, PADDLE_HEIGHT_RED);
        
        g.setColor(Color.WHITE);
        Font font = new Font("SansSerif", Font.PLAIN, 25); //設定字體大小
        g.setFont(font); //將字體打小樣式套用到Graphics中
        
        g.setColor(Color.WHITE); //設定字體顏色
        
        
        
        
//        
//        for(String a:Player_name) {
//        	
//        	g.drawString("玩家名稱: " + a, 10, HEIGHT/2 +115);
//        	
//        
//        }
//        
        
        System.out.println();
        g.drawString("藍方得分: " + score_Blue, 10, HEIGHT/2 +35);
        g.drawString("紅方得分: " + score_Red, 10, HEIGHT/2 -55);
//        g.drawString("玩家排名: " + Player_id, 10, HEIGHT/2 +85);
        g.drawString("玩家名稱: " + jdbc01.Player_name, 10, HEIGHT/2 +115);
        g.drawString("玩家得分: " + jdbc01.Player_score, 10, HEIGHT/2 +145);
        
}
        

    private void handleKeyPress(KeyEvent e) {
        int key = e.getKeyCode();
        int key1 = e.getKeyCode();


        if (key1 == KeyEvent.VK_A) { //如果案A
            paddleX_Red -= 20;//X-20參數(往左走)
            if (paddleX_Red< 0) {
                paddleX_Red = 0;
            }
        } else if (key1 == KeyEvent.VK_D) { //如果案D
            paddleX_Red += 20;  //X+20參數(往右走)
            if (paddleX_Red > WIDTH - PADDLE_WIDTH_BLUE) { //判斷如果碰到邊界
                paddleX_Red = WIDTH - PADDLE_WIDTH_BLUE;   //就讓他停在邊界
            }
        }
        
        if (key == KeyEvent.VK_LEFT) {
            paddleX -= 20;
            if (paddleX < 0) {
                paddleX = 0;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            paddleX += 20;
            if (paddleX > WIDTH - PADDLE_WIDTH_BLUE) {
                paddleX = WIDTH - PADDLE_WIDTH_BLUE;
            }
        }
    }

    private void gameOver() {
     
        isGameRunning = false;
  initializeGame();
  timer.stop();
  if (score_Blue == 2) {
   
   int choice = JOptionPane.showConfirmDialog(this,
     "遊戲結束藍方勝利 " , "Game Over",
     JOptionPane.YES_NO_OPTION);
   
   if (choice == JOptionPane.YES_OPTION) {
    
    score_Blue=0;    
    initializeGame();
    timer.stop();
    
   } else {
	   jdbc01.balljdbc01();
	   jdbc01.queryPlayerName();
    
    System.exit(0);
   }
   
  } else if (score_Red == 5) {
   
   int choice = JOptionPane.showConfirmDialog(this,
     "遊戲結束紅方勝利" , "Game Over",
     JOptionPane.YES_NO_OPTION);
   if (choice == JOptionPane.YES_OPTION) {
    
    score_Red=0;
    initializeGame();    
    timer.stop();
    
   } else {
    System.exit(0);
    
   }
  
  }

 }
//                ". Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
//  if (score_Blue >= 5) {
//   if (choice == JOptionPane.YES_OPTION) {
//    initializeGame();
//
//   } else {
//    System.exit(0);
//   }
//  }else {
//   initializeGame();
//  }
// }
     
    JDBC jdbc01 = new JDBC();
    

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(test1234V4::new);
       
        
       
        
    }


 
}