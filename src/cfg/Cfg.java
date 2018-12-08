package cfg;

public class Cfg {

    private static int windowHeight = 750;
    private static int windowWidth =800;

    public static int getWindowHeight() {
        return windowHeight;
    }

    public static void setWindowHeight(int windowHeight) {
        Cfg.windowHeight = windowHeight;
    }

    public static int getWindowWidth() {
        return windowWidth;
    }

    public static void setWindowWidth(int windowWidth) {
        Cfg.windowWidth = windowWidth;
    }
}
