/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class SearchingTest1Controller implements Initializable {

    
    @FXML
    private TextArea TextA1;
    @FXML
    private ListView<String> ListView1;

    
     ObservableList<String> items;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ObservableList<String> items =FXCollections.observableArrayList();
        ListView1.setItems(items);
        Wyszukaj();
        
        // TODO
    }    

    @FXML
    private void WyszukajSzybko(KeyEvent event) {
        Wyszukaj();
   
        
    }
    
    
     void Wyszukaj(){
         
        String s=TextA1.getText();
         List<Aktor> Wynik ;
         
         
     
         
         items =FXCollections.observableArrayList();
         Wynik=Utilities.WyszukajAktoraPoStringuBezPowtorzenAlpha(s);
        
        String g;
         
      
          //System.out.println(Wynik.size());
         for(int i=0;i<Wynik.size();i++){
             
         
             
         g=Wynik.get(i).getNazwisko()+" "+Wynik.get(i).getImie();
         items.add(g);
         
         }
        ListView1.setItems(items);
    
    }
    
}
