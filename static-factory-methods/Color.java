public class Color {
    private int red, green, blue;

    // Privae constructor prevents direct instantiation
    private Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // Static factory method with a clear name
    public static Color fromRGB(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    // Static factory method explaining a complete different conversion logic
    public static Color fromHex(int hexValue) {
        int r = (hexValue >> 16) & 0xFF;
        int g = (hexValue >> 8) & 0xFF;
        int b = hexValue & 0xFF; 
        return new Color(r, g, b);
    }
}

// Client code:
Color red = Color.fromRGB(255, 0, 0);
Color blue = Color.fromHex(0x0000FF);