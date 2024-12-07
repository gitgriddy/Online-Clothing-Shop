package edu.miracostacollege.cs112.capstoneproject.view;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FrontPage extends Scene {

    public static final int WIDTH = 850;
    public static final int HEIGHT = 600;
    private ImageView logo = new ImageView();
    private Button addButton = new Button("Enter Store");


    public FrontPage(){

        super(new GridPane(), WIDTH, HEIGHT);
        logo.setImage(new Image("Main.png"));
        logo.setFitWidth(775);
        logo.setFitHeight(525);

        addButton.setOnAction(e -> goShopping());


        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.add(logo, 0, 0, 2, 1);

        pane.add(addButton, 0, 5, 2, 1);


        this.setRoot(pane);

    }
    private void goShopping() {
        //DONE: Use the ViewNavigator to load the AddScene
        ViewNavigator.loadScene("Inventory", new Inventory(this));
    }

}
