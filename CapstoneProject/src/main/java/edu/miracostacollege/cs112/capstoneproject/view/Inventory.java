package edu.miracostacollege.cs112.capstoneproject.view;

import edu.miracostacollege.cs112.capstoneproject.controller.Controller;
import edu.miracostacollege.cs112.capstoneproject.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * The <code>AddScene</code> class allows a user to enter the information to add a new Vehicle to the collection
 * of EPA fuel economy data.
 * Fields are validated (must be provided) before the user is able to save the information.
 *
 * @author Michael Paulding
 * @version 1.1
 */
public class Inventory extends Scene {
    private Scene previousScene;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Controller controller = Controller.getInstance();
    private ImageView items = new ImageView();
    private Label nameLabel = new Label("Item #:");

    private Button addButton = new Button("Add to Cart");
    private Button cart = new Button("View Cart");
    private ComboBox<String> style = new ComboBox<>();
    private TextField sizeTF = new TextField();
    private ObservableList<allClothes> allClothesList;


    public Inventory(Scene previousScene){

        super(new GridPane(), WIDTH, HEIGHT);
        items.setImage(new Image("Add a little bit of body text.png"));
        items.setFitWidth(600);
        items.setFitHeight(600);



        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.add(items, 0, 0, 2, 1);

        style.getItems().addAll("1", "2","3","4","5","6","7","8","9","10","11","12");
        style.setValue("1");

        sizeTF.disableProperty().bind(style.valueProperty().isEqualTo("1")
                .or(style.valueProperty().isEqualTo("2"))
                .or(style.valueProperty().isEqualTo("3")));

        pane.add(nameLabel, 0, 2);

        pane.add(style,1,2);
        pane.add(new Label("Size:"), 0, 3);
        pane.add(sizeTF, 1, 3);
        pane.add(addButton, 1, 7);
        pane.add(cart, 1,8);

        cart.setOnAction(e -> shop());

        allClothesList = controller.getAllClothes();


        addButton.setOnAction(e -> addItem());



        this.setRoot(pane);
    }

    private void shop(){

        ViewNavigator.loadScene("Shopping Cart", new cartEditor(this));
    }
    private void addItem() {
        String size = sizeTF.getText();
        if(style.getValue().equals("1")){
            controller.addClothes((new Hat("Brown Kirby Trucker Hat", 55)));
        }
        if(style.getValue().equals("2")){
            controller.addClothes((new Hat("Pink Kirby Trucker Hat", 55)));
        }
        if(style.getValue().equals("3")){
            controller.addClothes((new Hat("Earth Blue Fitted Hat", 130)));

        }
        if(style.getValue().equals("4")){
            controller.addClothes((new Hoodie(size,"Black Akimbo Club Hoodie", 150)));
        }
        if(style.getValue().equals("5")){
            controller.addClothes((new Hoodie(size,"Pink Akimbo Club Hoodie", 150)));
        }
        if(style.getValue().equals("6")){
            controller.addClothes((new Hoodie(size,"Blue Akimbo Club Hoodie", 150)));
        }
        if(style.getValue().equals("7")){
            controller.addClothes((new Pants(size,"Dickies 874", 35)));
        }
        if(style.getValue().equals("8")){
            controller.addClothes((new Pants(size,"Arcteryx Gamma", 180)));
        }
        if(style.getValue().equals("9")){
            controller.addClothes((new Pants(size,"Carhartt W Amherst", 250)));
        }
        if(style.getValue().equals("10")){
            controller.addClothes((new Shoes(size,"Adidas Samba", 100)));
        }
        if(style.getValue().equals("11")){
            controller.addClothes((new Shoes(size,"Nike Dunk Low", 130)));
        }
        if(style.getValue().equals("12")){
            controller.addClothes((new Shoes(size,"ASICS GT-2160", 140)));
        }

        style.setValue("1");
        sizeTF.clear();
    }


}
