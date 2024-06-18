package com.blackfox.bunq;

import com.blackfox.bunq.maintenance.SceneLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import com.blackfox.bunq.database.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = SceneLoader.getPane("main");
        Scene scene = new Scene(root, 960, 600);

        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("BunQ");
        stage.show();
    }


    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        Logger.getLogger("com.mchange").setLevel(Level.WARNING);
        HibernateUtil.getSessionFactory();

        // fetchingExample("Dziady", "123dziady");

        launch();
        HibernateUtil.close();
    }

    /*public static void testWithRecivers() {
        Client test;
        try {
            test = HibernateUtil.getClient(57161548);
        } catch (ClientNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        try {
            test.saveReceiver(57161548);
        } catch (ReceiverDuplicateException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(test.getSavedReceivers().size());
        for (var i : test.getSavedReceivers()) {
            System.out.println(i.getReceiverId() + " " + i.getReceiverAsClient().getLastname());
        }
    }*/
}
