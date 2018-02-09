/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import bazafilmow.model.Film;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class EdycjaFilmuController implements Initializable {

    
    @FXML
    public TextField Tytul;
    
    @FXML
    public TextField Rok;
    
    @FXML
    public TextField Money;
    
    @FXML
    private ComboBox WyborKraju;
    
    @FXML
    private ComboBox WyborAktora;
    
    @FXML
    private ComboBox WyborRe;
    
    @FXML
    private RadioButton Komedia;
    
    @FXML
    private RadioButton Obyczajowy;
    
    @FXML
    private RadioButton Akcji;
    
    @FXML
    private RadioButton Sensacyjny;
    
    @FXML
    private RadioButton Horror;
    
    @FXML
    private RadioButton Animowany;
    
    @FXML
    private RadioButton Dramat;
    
    @FXML
    private RadioButton Thriller;
    
    @FXML
    private RadioButton Fantasy;
     
    
    @FXML
    private ListView ViewAktorzy;
    
    @FXML
    private ListView ViewRezyserzy;
    
    @FXML
    private Button RemoveAktora;
    
    @FXML
    private Button RemoveRe;
    
    static Film b;
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
     EDITController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Tytul.setText(b.getTytul());
        Film value = (Film) controller.lista.getSelectionModel().getSelectedItem();        
        Tytul.setText(value.getTytul());
        
    }


    public void setText(String Tytul,String Rok){
        
        this.Tytul.setText(Tytul);
        this.Rok.setText(Rok);
        
    }
    
    public static void DajFilm(Film a){
        b=a;
        System.out.println(b.getTytul());
        //Tytul.setText(b.getTytul());
    }
    
    
    
}
