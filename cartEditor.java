package edu.miracostacollege.cs112.capstoneproject.view;


import edu.miracostacollege.cs112.capstoneproject.controller.Controller;
import edu.miracostacollege.cs112.capstoneproject.model.allClothes;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class cartEditor extends Scene {


   private Scene previousScene;


   public static final int WIDTH = 800;
   public static final int HEIGHT = 600;
   private Controller controller = Controller.getInstance();
   private ListView<allClothes> clothingLV = new ListView<>();
   private Button removeButton = new Button("Remove Item");
   private Button cancelButton = new Button("Continue Shopping");
   private Button checkout = new Button("Checkout");
   private Button pay = new Button ("Pay Now");
   private Label totalLabel = new Label();
   private ObservableList<allClothes> clothingList;
   private allClothes selectedItem;




   public cartEditor (Scene previousScene){


       super(new GridPane(), WIDTH, HEIGHT);


       clothingList = controller.getAllClothes();
       clothingLV.setItems(clothingList);
       clothingLV.setPrefWidth(WIDTH);
       clothingLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> updateSelectedItem(newVal));




       HBox hBox2 = new HBox();
       hBox2.setAlignment(Pos.BOTTOM_RIGHT);
       hBox2.setSpacing(10);
       hBox2.getChildren().add(checkout);


       HBox hBox = new HBox();
       hBox.setAlignment(Pos.BOTTOM_RIGHT);
       hBox.setSpacing(10);
       hBox.getChildren().add(totalLabel);


       pay = new Button("Pay Now");
       pay.setOnAction(e -> payNow());
       pay.setVisible(false);
       HBox hBox3 = new HBox();
       hBox3.setAlignment(Pos.BOTTOM_RIGHT);
       hBox3.setSpacing(10);
       hBox3.getChildren().add(pay);




       GridPane pane = new GridPane();


       pane.setHgap(10.0);
       pane.setVgap(5);
       pane.setPadding(new Insets(5));


       pane.add(new Label("Your Cart"), 0, 1);


       pane.add(cancelButton, 0, 10);
       cancelButton.setOnAction(e -> goBackToPrevScene());




       pane.add(clothingLV, 0, 6, 2, 1);
       pane.add(removeButton, 0, 7, 2, 1);
       pane.add(hBox2, 1,7);
       pane.add(hBox, 1,11);
       pane.add(hBox3,1,13);








       clothingLV.getSelectionModel().selectedIndexProperty().addListener((obsVal, oldVal, newVal) ->
               updateRemoveButton(newVal));




       removeButton.setDisable(true);




       // Wire up the add button the addLaureate() method
       removeButton.setOnAction(e -> removeItem());
       checkout.setOnAction(e -> checkout());






       this.setRoot(pane);


   }
   private double calculateTotal() {


       double total = 0.0;
       for (allClothes item : clothingList){
           total+= item.getPrice();
       }
       return total;
   }
   private void checkout() {
       double totalAmount = calculateTotal();
       // Create the label with the total amount
       totalLabel.setText("Your total is: $" + String.format("%.2f", totalAmount));
       pay.setVisible(true);


   }


   private void payNow() {
       // Implement the logic for handling the payment
       ViewNavigator.loadScene("Thank You",new thankYou(this));
   }
   private void updateRemoveButton(Number newVal) {




       removeButton.setDisable(newVal.intValue() == -1);
   }


   private void removeItem() {




       int index = clothingLV.getSelectionModel().getSelectedIndex();
       if (index >= 0) {
           controller.removeItem(selectedItem);
       }
       clothingLV.getSelectionModel().select(-1);


   }






   private void updateSelectedItem(allClothes newVal) {
       selectedItem = newVal;
       // Disable the removeButton if selectedVehicle is null
       removeButton.setDisable(selectedItem == null);
   }
   private void goBackToPrevScene() {
       //DONE: Navigate back to the previous scene (e.g. MainScene)
       ViewNavigator.loadScene("Inventory", new Inventory(this));
   }








}

