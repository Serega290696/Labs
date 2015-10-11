package com.mylab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by serega.
 */
public class MainController extends Application {
    private static Stage primaryStage;
    private static final String TITLE = "Task #4";
//    private final String iconPath = "icon.png";
    public static void startApp() {
        launch();
    }
    @Override
    public void start(Stage primaryStageT) throws Exception {
        primaryStage = primaryStageT;

        Parent root = FXMLLoader.load(MainController.class.getResource("/fxml/Main.fxml"));
        primaryStage.setScene(new Scene(root, null));
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
