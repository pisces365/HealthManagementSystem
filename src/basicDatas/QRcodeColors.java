package basicDatas;

public class QRcodeColors {
    private int red;
    private int yellow;
    private int green;
    private int blue;

    public QRcodeColors(int red, int yellow, int green, int blue) {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.blue = blue;
    }

    public QRcodeColors() {
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red += red;
    }

    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow += yellow;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green += green;
    }
}
