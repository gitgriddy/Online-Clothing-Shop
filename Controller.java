package edu.miracostacollege.cs112.capstoneproject.controller;


import edu.miracostacollege.cs112.capstoneproject.model.Model;
import edu.miracostacollege.cs112.capstoneproject.model.Hoodie;
import edu.miracostacollege.cs112.capstoneproject.model.Hat;
import edu.miracostacollege.cs112.capstoneproject.model.Pants;
import edu.miracostacollege.cs112.capstoneproject.model.Shoes;
import edu.miracostacollege.cs112.capstoneproject.model.allClothes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.Collections;


/**
* The <code>Controller</code> is a Singleton object that relays all commands between the Model and View
* (and vice versa).  There is only one Controller object, accessible by a call to the static getInstance()
* method.
*
* @author Michael Paulding
* @version 1.0
*/
public class Controller {


   private static Controller theInstance;
   private ObservableList<allClothes> allClothes;




   private Controller() {}


   public static Controller getInstance() {
      if (theInstance == null) {
         theInstance = new Controller();


         theInstance.allClothes = Model.populateListFromBinaryFile();


      }
      return theInstance;
   }




   public ObservableList<allClothes> getAllClothes() {
      return allClothes;
   }


   public void addClothes(allClothes v)
   {
      allClothes.add(v);


   }
   public void removeItem(allClothes v){
      allClothes.remove(v);
   }




   public void saveData() {
      Model.writeDataToBinaryFile(allClothes);
   }










}
