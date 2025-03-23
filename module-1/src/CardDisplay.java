/**
 * Name: Brian Preston
 * Course: CSD-340
 * Assignment: M1 Assignment
 * Description: This JavaFX application displays four randomly selected card images from a deck
 * and allows the user to refresh the selection with a button click using lambda expressions.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.util.Collections;
import java.util.ArrayList;

public class CardDisplay extends Application {
    private ArrayList<String> cards = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        loadCards();
        HBox cardBox = new HBox(10);
        refreshCards(cardBox);

        Button btnRefresh = new Button("Refresh");
        btnRefresh.setOnAction(e -> refreshCards(cardBox));

        HBox root = new HBox(10);
        root.getChildren().addAll(cardBox, btnRefresh);

        Scene scene = new Scene(root, 500, 250);
        primaryStage.setTitle("Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadCards() {
        // Load images from the cards directory
        for (int i = 1; i <= 52; i++) {
            String imagePath = "file:../cards/" + i + ".png";
            File f = new File(imagePath.substring(5));  // Remove the "file:" part for File check
            if (!f.exists()) {
                System.out.println("File does not exist: " + f.getAbsolutePath());
            } else {
                cards.add(imagePath);
            }
        }
    }

    private void refreshCards(HBox cardBox) {
        Collections.shuffle(cards);
        cardBox.getChildren().clear();
        for (int i = 0; i < 4; i++) {
            Image img = new Image(cards.get(i));
            if (img.isError()) {
                System.out.println("Error loading image: " + cards.get(i));
            }
            ImageView imgView = new ImageView(img);
            imgView.setFitHeight(100); // Set the height of the image
            imgView.setFitWidth(80);  // Set the width of the image
            cardBox.getChildren().add(imgView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

