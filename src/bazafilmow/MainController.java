/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.persistence.*;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class MainController implements Initializable {

    @FXML
    private Button  newMovie;
    @FXML
    private Button SzukajAktora;
    
    @FXML 
    private Button EditMovie;
    
    @FXML
    private Button Look;
    
    @FXML
    private Button Muzyka;
    
    final URL resource = getClass().getResource("Nice.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            
    }
        
        @FXML
        private void handleMusic(ActionEvent event){
                       
            boolean flag = true;
            mediaPlayer.play();
            
            if(flag == true){
                mediaPlayer.pause();                
                flag = false;  
            }
               
        }
    
        
	 @FXML
            private void handleButtonAction(ActionEvent event) throws IOException {
	        System.out.println("You clicked me!");
	        Parent movie_parent = FXMLLoader.load(getClass().getResource("NEW.fxml"));
	        Scene movie_scene = new Scene(movie_parent);             
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setTitle("Nowy Film");
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();  
	            	            
	    }    


            
            @FXML
            private void handleEditButtonAction(ActionEvent event) throws IOException {
	        System.out.println("You clicked me!");
	        Parent movie_parent = FXMLLoader.load(getClass().getResource("EDIT.fxml"));
	        Scene movie_scene = new Scene(movie_parent);             
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setTitle("Edytuj Film");
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();  
	            	            
	    } 
            @FXML
            private void GoSzukaj(ActionEvent event) throws IOException{
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchingTest1.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Szukanie aktora");
                stage.setScene(new Scene(root1));  
                stage.show();
            }
}
