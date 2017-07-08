
package com.knowledge.store.boot;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Startup extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Startup.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            VBox page = (VBox) FXMLLoader.load(getClass().getResource("/com/knowledge/store/views/HomeView.fxml"));
            Scene scene = new Scene(page);            
            //scene.getStylesheets().add("/com/knowledge/store/views/resources/knowledge-store.css");
            ObservableList l= scene.getStylesheets();
            for (Object object : l) {
                System.out.println(object);
            }
            System.out.println("C:\\Program Files\\Java\\jdk1.8.0_65");
            primaryStage.setScene(scene);
            primaryStage.setTitle("Info Store");            
            //primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

