package hw3.view;

import hw3.Message;
import hw3.UpdateMessage;
import hw3.ResetMessage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * View class which handles the display that the user sees
 */
public class View extends JFrame {
    BlockingQueue<Message> queue;
    JTextField redSizeTextField;
    JTextField greenSizeTextField;
    JTextField blueSizeTextField;

    JButton updateButton;
    JButton resetButton;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    DrawGraph draw;

    /**
     * Constructor that initializes the view display for the user
     *
     * @param queue BlockingQueue of Messages to send to the Controller
     * @param redHeight Value used for calculating the height of the red rectangle
     * @param greenHeight Value used for calculating the height of the green rectangle
     * @param blueHeight Value used for calculating the height of the blue rectangle
     */
    public View(BlockingQueue<Message> queue, int redHeight, int greenHeight, int blueHeight) {
        this.queue = queue;

        this.redLabel = new JLabel("Red:");
        this.redSizeTextField = new JTextField("" + redHeight);
        this.greenLabel = new JLabel("Green:");
        this.greenSizeTextField = new JTextField("" + greenHeight);
        this.blueLabel = new JLabel("Blue:");
        this.blueSizeTextField = new JTextField("" + blueHeight);

        this.updateButton = new JButton("Update");
        this.resetButton = new JButton("Reset");

        this.draw = new DrawGraph(redHeight, greenHeight, blueHeight);

        Dimension dHeight10 = new Dimension(0, 10);
        Dimension dHeight20 = new Dimension(0, 20);
        Dimension dHeight25 = new Dimension(0,25);

        updateButton.addActionListener(e -> {
            int redValue = Integer.parseInt(redSizeTextField.getText());
            int greenValue = Integer.parseInt(greenSizeTextField.getText());
            int blueValue = Integer.parseInt(blueSizeTextField.getText());
            try {
                Message msg = new UpdateMessage(redValue, greenValue, blueValue);
                queue.put(msg);
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        resetButton.addActionListener(e -> {
            try {
                queue.put(new ResetMessage());
            } catch (InterruptedException exception) {
                //nothing
            }
        });

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.add(redLabel);
        labelPanel.add(Box.createRigidArea(dHeight10));
        labelPanel.add(redSizeTextField);
        labelPanel.add(Box.createRigidArea(dHeight20));
        labelPanel.add(greenLabel);
        labelPanel.add(Box.createRigidArea(dHeight10));
        labelPanel.add(greenSizeTextField);
        labelPanel.add(Box.createRigidArea(dHeight20));
        labelPanel.add(blueLabel);
        labelPanel.add(Box.createRigidArea(dHeight10));
        labelPanel.add(blueSizeTextField);
        labelPanel.add(Box.createRigidArea(dHeight25));
        labelPanel.add(updateButton);
        labelPanel.add(Box.createRigidArea(dHeight25));
        labelPanel.add(resetButton);

        JPanel graphPanel = new JPanel();
        graphPanel.setAlignmentY(BOTTOM_ALIGNMENT);
        graphPanel.add(draw);
        draw.repaint();

        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.add(labelPanel);
        this.add(graphPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method to update the bar graph component based on the values given
     *
     * @param redValue Value used for calculating the height of the red rectangle
     * @param greenValue Value used for calculating the height of the green rectangle
     * @param blueValue Value used for calculating the height of the blue rectangle
     */
    public void updateBarGraph(int redValue, int greenValue, int blueValue) {
        this.redSizeTextField.setText("" + redValue);
        this.greenSizeTextField.setText("" + greenValue);
        this.blueSizeTextField.setText("" + blueValue);

        draw.UpdateRectangleHeights(redValue, greenValue, blueValue);
        draw.repaint();
    }

    /**
     * Method which resets the bar graph to heights of 0
     */
    public void resetBarGraph() {
        this.redSizeTextField.setText("0");
        this.greenSizeTextField.setText("0");
        this.blueSizeTextField.setText("0");

        draw.UpdateRectangleHeights(0, 0, 0);
        draw.repaint();
    }
}
