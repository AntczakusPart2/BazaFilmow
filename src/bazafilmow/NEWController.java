/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.Utils;
import static bazafilmow.Utils.em;
import bazafilmow.model.Aktor;
import bazafilmow.model.Film;
import bazafilmow.model.Gatunek;
import bazafilmow.model.Kraj;
import bazafilmow.model.Rezyser;
import java.io.IOException;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class NEWController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField Tytul;
    
    @FXML
    private TextField Rok;
    
    @FXML
    private TextField Money;
    
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
    private RadioButton Sci;
        
    @FXML
    private RadioButton Dokument;
            
    @FXML
    private RadioButton Przygodowy;
             
    
    @FXML
    private Label NazwaKraju;
    
     
    @FXML
    private ListView ViewAktorzy;
    
    @FXML
    private ListView ViewRezyserzy;
    
    @FXML
    private Button RemoveAktora;
    
    @FXML
    private Button RemoveRe;
    
    
    
    //static int count =1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Utilities3.dodajGatunki();
        
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        ObservableList<String> list3 = FXCollections.observableArrayList();
        
        
	//String[] locales = Locale.getISOCountries();		
		 
		//for (String countryCode : locales) 
                //{                   
                //    Locale obj = new Locale("", countryCode);
                //    list.add(obj.getDisplayCountry());
                //}
			
                //WyborKraju.setItems(list);
		//WyborKraju.setItems(loadKraje());
                
                EntityManager em = Utils.getEntityManager();
                
                
                Query queryKraj = em.createNamedQuery("Kraj.findAll");
                Collection kraje = queryKraj.getResultList();     
                list.addAll(kraje);
                WyborKraju.setItems(list);

                Query queryAktorzy = em.createNamedQuery("Aktor.findAll");
                Collection aktorzy = queryAktorzy.getResultList();     
                list2.addAll(aktorzy);
                WyborAktora.setItems(list2);

                Query queryRezyserzy = em.createNamedQuery("Rezyser.findAll");
                Collection rezyserzy = queryRezyserzy.getResultList();
                list3.addAll(rezyserzy);
                WyborRe.setItems(list3);
    }    
    
            @FXML
            private void comboActionAktor() {
                //WyborAktora.valueProperty().addListener(new ChangeListener<String>() {
                  //  @Override
                   // public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        
                ObservableList<String> list = FXCollections.observableArrayList();
                EntityManager em = Utils.getEntityManager();
                    
                Query queryAktorzy = em.createNamedQuery("Aktor.findAll");
                Collection aktorzy = queryAktorzy.getResultList();     
                list.addAll(aktorzy);
                WyborAktora.setItems(list);
                   
                if(!ViewAktorzy.getItems().contains(WyborAktora.getSelectionModel().getSelectedItem())){                                           
                 
                    ViewAktorzy.getItems().add(WyborAktora.getSelectionModel().getSelectedItem());
                    
                }
                                     
                   // }
               // });
            }

            @FXML
            private void comboActionKraj(){
                
                Kraj lol = new Kraj();
                lol = (Kraj) WyborKraju.getSelectionModel().getSelectedItem();
                String nazwa = lol.getNazwa();
                NazwaKraju.setText(nazwa);
                
            }
            
            @FXML
            private void comboActionRezyser() {
                //WyborAktora.valueProperty().addListener(new ChangeListener<String>() {
                  //  @Override
                   // public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        
                 ObservableList<String> list = FXCollections.observableArrayList();
                 EntityManager em = Utils.getEntityManager();
                    
                Query queryRez = em.createNamedQuery("Rezyser.findAll");
                Collection rezyserzy = queryRez.getResultList();     
                list.addAll(rezyserzy);
                WyborRe.setItems(list);
                
                if(!ViewRezyserzy.getItems().contains(WyborRe.getSelectionModel().getSelectedItem())){                                           
                
                    ViewRezyserzy.getItems().add(WyborRe.getSelectionModel().getSelectedItem());
                    
                }
                   // }
               // });
            }
            
            @FXML
	    private void handleUsunButtonAkt(ActionEvent event){
                ViewAktorzy.getItems().remove(ViewAktorzy.getSelectionModel().getSelectedItem());
            }
    
            
            @FXML
	    private void handleUsunButtonRez(ActionEvent event){
                ViewRezyserzy.getItems().remove(ViewRezyserzy.getSelectionModel().getSelectedItem());
            }
            
            @FXML
	    private void handleOKButton(ActionEvent event) throws IOException{
	        System.out.println("OK Clicked");
                
                EntityManager em = Utils.getEntityManager();
                em.getTransaction().begin();
                
                
                Film f = new Film();
                boolean flag =false;
                

                
                 Set<Gatunek> gg=dodanieGatunkowDoFilmu(f);
                 if(gg.isEmpty()==false){
                 f.setGatunki(gg);
                 
                 }
                
	        
                em.persist(f);             

                
                dodanieGatunkowDoFilmu(f);
                
                System.out.println(f.getGatunki());
                
                
               // f.addKraj((Kraj) WyborKraju.getSelectionModel().getSelectedItem());
               // em.persist(f);
                
                if (Tytul.getText() == null || Tytul.getText().trim().isEmpty()) {
                    
                     Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("NULL ERROR");
                    alert.setHeaderText("Tytuł nie może być NULL");
                    alert.setContentText("Zmień tytuł!");

                    alert.showAndWait();
                    flag = false;
                   
                }
                else{
                    
                    f.setTytul(Tytul.getText());
                    em.persist(f); 
                    flag = true;       
                    
                }
                
                if (Rok.getText() == null || Rok.getText().trim().isEmpty()){
                    
                     Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("NULL ERROR");
                    alert.setHeaderText("Rok nie może być NULL");
                    alert.setContentText("Zmień rok!");

                    alert.showAndWait();
                    flag = false;
                }
                else{
                    
                     short RokValue = Short.parseShort(Rok.getText()); //-short
                    f.setRokProd(RokValue);
                    em.persist(f); 
                    flag = true;
                    
                }
                
                if (Money.getText() == null || Money.getText().trim().isEmpty()){ 
                    
                     Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("NULL ERROR");
                    alert.setHeaderText("BoxOffice nie może być NULL");
                    alert.setContentText("Zmień BoxOffice!");

                    alert.showAndWait();
                    flag = false;
                }
                else{
                    
                    float BoxOffice = Float.parseFloat(Money.getText()); //-float
                    f.setBoxOffice(BoxOffice);
                    em.persist(f);
                    flag = true;
                                  
                }
                

                //f.addAktor((Aktor) WyborAktora.getSelectionModel().getSelectedItem());

                
                    for(int i=0;i<ViewAktorzy.getItems().size();i++){
                       
                       f.addAktor((Aktor) ViewAktorzy.getItems().get(i));
                    }
                em.persist(f);                         
                System.out.println(f.getAktorzy());
                
                
                    for(int i=0;i<ViewRezyserzy.getItems().size();i++){
                       
                       f.addRezyser((Rezyser) ViewRezyserzy.getItems().get(i));
                    }
                    
                em.persist(f);
                System.out.println(f.getRezyserzy());
                
                
                
                if(flag == true){
      
                em.getTransaction().commit();

		em.close();

                
                Parent movie_parent = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
                
                }
                
                
	    }
    
            @FXML
	    private void handleNewAktorButton(ActionEvent event) throws IOException{
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewAktor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Nowy Aktor");
                stage.setScene(new Scene(root1));  
                stage.show();
            }
            
            @FXML
	    private void handleNewRezButton(ActionEvent event) throws IOException{
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewRez.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Nowy Reżyser");
                stage.setScene(new Scene(root1));  
                stage.show();
          
            }
            
            @FXML
	    private void handleCancelButton(ActionEvent event) throws IOException{
                Parent movie_parent = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
            }
            
            
            //zakładam że sam film został juz utworzony i jest w bazie
            
            private Set<Gatunek> dodanieGatunkowDoFilmu(Film f){
                
                Gatunek g = new Gatunek();
                
                 Set<Gatunek> SetG = new HashSet<Gatunek>();
            
            
                if(Obyczajowy.isSelected()==true){
                g=Utilities3.dajGatunek("Obyczajowy");
                SetG.add(g);
                
                }
                 if(Komedia.isSelected()==true){
                Gatunek g1=Utilities3.dajGatunek("Komedia");
                System.out.println(g1.getNazwa());
                  SetG.add(g1);
                }
                 
                  if(Akcji.isSelected()==true){
                g=Utilities3.dajGatunek("Akcji");
                  SetG.add(g);
                }
                  
                if(Sensacyjny.isSelected()==true){
                g=Utilities3.dajGatunek("Sensacyjny");
                  SetG.add(g);
                }
                
                if(Horror.isSelected()==true){
                g=Utilities3.dajGatunek("Horror");
                  SetG.add(g);
                }
                
                if(Animowany.isSelected()==true){
                g=Utilities3.dajGatunek("Animowany");
                  SetG.add(g);
                }
                
                if(Dramat.isSelected()==true){
                g=Utilities3.dajGatunek("Dramat");
                  SetG.add(g);
                }
                
                if(Thriller.isSelected()==true){
                g=Utilities3.dajGatunek("Thriller");
                  SetG.add(g);
                }
                
                if(Fantasy.isSelected()==true){
                g=Utilities3.dajGatunek("Fantasy");
                  SetG.add(g);
                }
            
                if(Sci.isSelected()== true){
                g=Utilities3.dajGatunek("Sci-Fi");
                 SetG.add(g);
                }
                     
                if(Dokument.isSelected()){
                g=Utilities3.dajGatunek("Dokumentalny");
                 SetG.add(g);
                }
                
                if(Przygodowy.isSelected()){
                g=Utilities3.dajGatunek("Przygodowy");
                 SetG.add(g);
                }
              return SetG;  
            }

            
                
        }
            

