package hw3.model;

/**
 * Model class which contains information about the heights of bars in the bar graph
 */
public class Model {
    private int redHeight;
    private int greenHeight;
    private int blueHeight;

    /**
     * Method which updates the values used for the heights in the bar graphs, only accepts positive ints
     *
     * @param redHeight Int value used for calculating the height of the red rectangle
     * @param greenHeight Int value used for calculating the height of the green rectangle
     * @param blueHeight int value used for calculating the height of the blue rectangle
     */
    public void updateHeights(int redHeight, int greenHeight, int blueHeight) {
        if (redHeight >= 0) {
            this.redHeight = redHeight;
        }

        if (greenHeight >= 0) {
            this.greenHeight = greenHeight;
        }

        if (blueHeight >= 0) {
            this.blueHeight = blueHeight;
        }
    }

    /**
     * Method to reset the fields all to 0
     */
    public void resetHeights() {
        this.redHeight = 0;
        this.greenHeight = 0;
        this.blueHeight = 0;
    }

    /**
     * Accessor method for redHeight field
     *
     * @return redHeight field as an int
     */
    public int returnRedHeight() {
        return redHeight;
    }

    /**
     * Accessor method for greenHeight field
     *
     * @return greenHeight field as an int
     */
    public int returnGreenHeight() {
        return greenHeight;
    }

    /**
     * Accessor method for blueHeight field
     *
     * @return blueHeight field as an int
     */
    public int returnBlueHeight() {
        return blueHeight;
    }
}
