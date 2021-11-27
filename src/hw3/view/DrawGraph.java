package hw3.view;

import javax.swing.*;
import java.awt.*;

/**
 * JComponent class which draws a bar graph containing 3 bars with different heights
 */
public class DrawGraph extends JComponent {
    int redHeight;
    int greenHeight;
    int blueHeight;

    Rectangle redRectangle;
    Rectangle blueRectangle;
    Rectangle greenRectangle;

    /**
     * Constructor which initializes the dimensions of the 3 rectangles to be drawn
     *
     * @param height1 Value that is used to calculate the height of the red rectangle
     * @param height2 Value that is used to calculate the height of the green rectangle
     * @param height3 Value that is used to calculate the height of the blue rectangle
     */
    public DrawGraph(int height1, int height2, int height3) {
        this.redHeight = height1 * 20;
        this.greenHeight = height2 * 20;
        this.blueHeight = height3 * 20;

        this.redRectangle = new Rectangle(30, 290 - redHeight, 50, redHeight);
        this.greenRectangle = new Rectangle(130, 290 - greenHeight, 50, greenHeight);
        this.blueRectangle = new Rectangle(230, 290 - blueHeight, 50, blueHeight);
    }

    /**
     * Method to update the dimensions of the 3 rectangles
     *
     * @param height1 Value that is used to calculate the height of the red rectangle
     * @param height2 Value that is used to calculate the height of the green rectangle
     * @param height3 Value that is used to calculate the height of the blue rectangle
     */
    public void UpdateRectangleHeights(int height1, int height2, int height3) {
        this.redHeight = height1 * 20;
        this.greenHeight = height2 * 20;
        this.blueHeight = height3 * 20;

        this.redRectangle = new Rectangle(30, 290 - redHeight, 50, redHeight);
        this.greenRectangle = new Rectangle(130, 290 - greenHeight, 50, greenHeight);
        this.blueRectangle = new Rectangle(230, 290 - blueHeight, 50, blueHeight);
    }

    /**
     * Method for setting the dimension of the JComponent
     *
     * @return Dimension of a set size
     */
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    /**
     * Method which draws the 3 rectangles of different colors and heights
     *
     * @param g Graphics used to draw
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.draw(redRectangle);
        g2.fill(redRectangle);

        g2.setColor(Color.green);
        g2.draw(greenRectangle);
        g2.fill(greenRectangle);

        g2.setColor(Color.blue);
        g2.draw(blueRectangle);
        g2.fill(blueRectangle);
    }
}
