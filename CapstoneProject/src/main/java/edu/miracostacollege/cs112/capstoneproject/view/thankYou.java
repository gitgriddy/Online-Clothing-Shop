package edu.miracostacollege.cs112.capstoneproject.view;

import edu.miracostacollege.cs112.capstoneproject.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class thankYou extends Scene {
    private Scene previousScene;
    private ImageView gif = new ImageView();

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Controller controller = Controller.getInstance();
    public thankYou(Scene previousScene){
        super(new GridPane(), WIDTH, HEIGHT);

        gif.setImage(new Image("200w.gif"));
        gif.setFitWidth(WIDTH);
        gif.setFitHeight(HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.add(gif, 0, 0, 2, 1);

        this.setRoot(pane);


    }
}
