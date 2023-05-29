package gui;

import javafx.stage.Stage;

public class ScreenSettings {
    public static Stage primaryStage;
    public static int screenWidth = 1920;
    public static int screenHeight = 1080;
    public static boolean isFullScreen = false;

    public static void initializeScreen(){
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(isFullScreen);
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
    }
}
