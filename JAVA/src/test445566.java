import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test445566 extends JFrame {
    private static final int TRACK_LENGTH = 20;
    private static final int NUM_HORSES = 5;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    private static final int HORSE_HEIGHT = 50;
    private static final int HORSE_WIDTH = 50;

    private List<Horse> horses;
    private JPanel trackPanel;
    private JLabel[] horseLabels;

    public test445566() {
        setTitle("Horse Race Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);

        horses = new ArrayList<>();
        for (int i = 1; i <= NUM_HORSES; i++) {
            Horse horse = new Horse("Horse " + i);
            horses.add(horse);
        }

        trackPanel = new JPanel();
        trackPanel.setLayout(null);
        trackPanel.setPreferredSize(new Dimension(TRACK_LENGTH * HORSE_WIDTH, FRAME_HEIGHT));

        horseLabels = new JLabel[NUM_HORSES];
        for (int i = 0; i < NUM_HORSES; i++) {
            JLabel horseLabel = new JLabel(horses.get(i).getName());
            horseLabel.setBounds(0, i * HORSE_HEIGHT, HORSE_WIDTH, HORSE_HEIGHT);
            trackPanel.add(horseLabel);
            horseLabels[i] = horseLabel;
        }

        add(trackPanel);
    }

    public void startRace() {
        boolean raceFinished = false;
        while (!raceFinished) {
            for (Horse horse : horses) {
                horse.move();
                int horseIndex = horses.indexOf(horse);
                horseLabels[horseIndex].setLocation(horse.getPosition() * HORSE_WIDTH, horseIndex * HORSE_HEIGHT);

                if (horse.getPosition() >= TRACK_LENGTH) {
                    raceFinished = true;
                    JOptionPane.showMessageDialog(this, horse.getName() + " wins the race!");
                    break;
                }
            }

            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    	test445566 game = new test445566();
        game.setVisible(true);

        game.startRace();
    }
}

class Horse {
    private String name;
    private int position;

    public Horse(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        Random rand = new Random();
        int distance = rand.nextInt(3) + 1; // Randomly move 1-3 steps
        position += distance;
    }
}
