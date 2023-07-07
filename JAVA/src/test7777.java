import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class test7777 extends JFrame{
    private String playerName;
    private JPanel gamePanel;

    public void showInputDialog() {
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
    public void showInputDialogG() {
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

    public static void main(String[] args) {
        test7777 game = new test7777();
        game.showInputDialog();
        game.startGame();
    }

    private JTextArea textArea;
    private JButton button;
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    public test7777() {
        setTitle("文字冒險遊戲");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFont(normalFont);
        setSize(800, 600);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        button = new JButton("START");
        button.addActionListener(e -> {
            startGame();
            button.setEnabled(false);
        });
        add(button, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void draw(Graphics g) {
        g.drawString(playerName, 10, 10);

        try {
            Image backgroundImage = ImageIO.read(new File("pinpon/01.jpg"));
            g.drawImage(backgroundImage, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame() {
    	
        textArea.setText("現在在一個房間裡。有一扇門在你面前。\n");
        textArea.append("你想要打開門嗎？(是/否)\n");

        JButton yesButton = new JButton("是");
        yesButton.addActionListener(e -> {
            textArea.append("你走出房子，看到一片廣闊的草地。\n");
            textArea.append("遊戲結束。\n");
            button.setEnabled(false);
        });

        JButton noButton = new JButton("否");
        noButton.addActionListener(e -> {
            textArea.append("你決定不打開門。遊戲結束。\n");
            button.setEnabled(false);
        });

        add(noButton, BorderLayout.EAST);
        add(yesButton, BorderLayout.WEST);

        revalidate();
        repaint();
    }
}
