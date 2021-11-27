package hw3;

/**
 *  Message type that is sent when the UpdateButton is pressed, sends the 3 values in the textfields at that time
 */
public class UpdateMessage implements Message {
    int redValue;
    int greenValue;
    int blueValue;

    /**
     * Method that updates the fields which store what values to be sent to the Controller
     *
     * @param redValue Value used for determining height of red rectangle
     * @param greenValue Value used for determining height of green rectangle
     * @param blueValue Value used for determining height of blue rectangle
     */
    public UpdateMessage(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    /**
     * Accessor method for redValue field
     *
     * @return redValue as an int
     */
    public int getRedValue() {
        return this.redValue;
    }

    /**
     * Accessor method for greenValue field
     *
     * @return greenValue as an int
     */
    public int getGreenValue() {
        return this.greenValue;
    }

    /**
     * Accessor method for blueValue field
     *
     * @return blueValue as an int
     */
    public int getBlueValue() {
        return this.blueValue;
    }
}
