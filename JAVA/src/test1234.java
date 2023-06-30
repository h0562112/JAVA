import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test1234 extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JPanel gamePanel;
    private Timer timer;
    private int ballX, ballY;
    private int paddleX,paddleX_Red ;
    private int ballSpeedX, ballSpeedY;
    private int score_Blue,score_Red;
    private boolean isGameRunning;

    private static final int PADDLE_WIDTH_BLUE= 100;
    private static final int PADDLE_WIDTH_RED=100;
    private static final int PADDLE_HEIGHT_BLUE = 10;
    private static final int PADDLE_HEIGHT_RED= 10;
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_Y_RED = HEIGHT - PADDLE_HEIGHT_RED - 590;
    private static final int PADDLE_Y = HEIGHT - PADDLE_HEIGHT_BLUE - 40;
    private static final int BALL_INITIAL_X = WIDTH / 2 - BALL_SIZE / 2;
    private static final int BALL_INITIAL_Y = HEIGHT - PADDLE_HEIGHT_BLUE - 50 - BALL_SIZE;

    public test1234() {
        setTitle("Brick Breaker Game");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };

        gamePanel.setFocusable(true); //鍵盤移動
        gamePanel.setBackground(Color.BLACK);
        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        add(gamePanel);
        initializeGame();

        setVisible(true);
    }

    private void initializeGame() {
        ballX = BALL_INITIAL_X;
        ballY = BALL_INITIAL_Y;
        paddleX = WIDTH / 2 - PADDLE_WIDTH_BLUE / 2;
        paddleX_Red = WIDTH / 2 - PADDLE_WIDTH_RED / 2;
        ballSpeedX = 2;
        ballSpeedY = -2;
        score_Blue = 0;
        score_Red = 0;
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

    private void updateGame() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;
//
        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
            ballSpeedX = -ballSpeedX;
       }
//|| ballY >= HEIGHT - BALL_SIZE)
//        if (ballY >= HEIGHT - BALL_SIZE) {
//        	ballSpeedY = -ballSpeedY;
//        }
        
//上方邊界

        if (ballY >= HEIGHT - BALL_SIZE - BALL_SIZE - BALL_SIZE - PADDLE_HEIGHT_BLUE) { //藍方撞球判斷
            if (ballX >= paddleX && ballX <= paddleX + PADDLE_WIDTH_BLUE) {
                ballSpeedY = -ballSpeedY;
                
                ballSpeedY--;
            } else {
                gameOver();
                score_Red++;
                
            }
        }
        
        if (ballY <= PADDLE_HEIGHT_RED) {
            if (ballX >= paddleX_Red && ballX <= paddleX_Red + PADDLE_WIDTH_RED) {
                ballSpeedY = -ballSpeedY;
                
                ballSpeedY++;
            } else {
                gameOver();
                score_Blue++;
            }
        }
 }
 

    private void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        g.setColor(Color.BLUE);
        g.fillRect(paddleX, PADDLE_Y, PADDLE_WIDTH_BLUE, PADDLE_HEIGHT_BLUE);

        g.setColor(Color.RED);
        g.fillRect(paddleX_Red,PADDLE_Y_RED, PADDLE_WIDTH_RED, PADDLE_HEIGHT_RED);

        g.setColor(Color.GREEN);
        g.drawString("Score_Blue: " + score_Blue, 10, 550);
        g.drawString("Score_Red: " + score_Red, 10, 20);
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
        timer.stop();

        int choice = JOptionPane.showConfirmDialog(this, "Game Over! Your score is " + score_Blue +score_Red+
                ". Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            initializeGame();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(test1234::new);
    }
}
