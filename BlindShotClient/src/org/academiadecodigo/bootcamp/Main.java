package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.utils.Navigation;

import java.io.IOException;

/**
 * Created by codecadet on 28/06/17.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation navigation = Navigation.getInstance();

        navigation.setStage(primaryStage);
        navigation.loadScreen("grid");
        Main.startServer();

    }

    public static void startServer() {

        Client client = new Client();

        try {

            client.connect();
            client.recieveMessage();
            client.sendMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}