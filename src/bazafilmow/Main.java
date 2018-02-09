/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.Utils;
import static bazafilmow.Utils.loadKraje;
import bazafilmow.model.*;
import bazafilmow.Utilities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 *
 * @author Danielos and Michaelos
 */


public class Main extends Application{
    

private BorderPane RootLayout;    

    @Override
    public void start(Stage primaryStage) {
        try {

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("RootLayout.fxml"));
                RootLayout = loader.load();
	          	                       
	            
	        // Show the scene containing the root layout.
	        Scene scene = new Scene(RootLayout);
	        primaryStage.setMinHeight(340);
	        primaryStage.setMinWidth(600);
                primaryStage.setScene(scene);
                primaryStage.show();
                
	} catch(Exception e) {
                e.printStackTrace();
	}
    }
       
    
    
    public static void main(String[] args) {
                
                Utilities3.dodajGatunki();
               //Gatunek gg=new Gatunek();
               //gg=Utilities3.dajGatunek("Komedia");
               //System.out.println(gg.getNazwa());
                
                
                EntityManager em = Utils.getEntityManager();

		em.getTransaction().begin();
                loadKraje();
        
                Film f = new Film();
                Film f2 = new Film();
                Film f3 = new Film();
                
                f.setTytul("Szybcy");
                f2.setTytul("Szybsi");
                f3.setTytul("Najszybsi");
                
                short rok = 2008;
                short rok2 = 1995;
                
                f.setRokProd(rok);
                f2.setRokProd(rok2);
                
                //Kraj x = new Kraj();
                //x.setNazwa("Polska");
                
               // Kraj y = new Kraj();
                //y.setNazwa("NiePolska");
                
               // f.addKraj(x); //dodanie krajow do filmow
               //f2.addKraj(x);
                
                Aktor aktor1 = new Aktor();
                aktor1.setImie("AktorImie1");
                aktor1.setNazwisko("AktorNazwisko1");
                
                
                //dodatkowi
                
                  Aktor aktor10 = new Aktor();
                aktor10.setImie("Michal");
                aktor10.setNazwisko("Wisniewski");
                  Aktor aktor100 = new Aktor();
                aktor100.setImie("Jacek");
                aktor100.setNazwisko("Stonoga");
                  Aktor aktor1000 = new Aktor();
                aktor1000.setImie("Dominik");
                aktor1000.setNazwisko("Redzynia");
                  Aktor major = new Aktor();
                major.setImie("Major");
                major.setNazwisko("Kononowicz");
                
                em.persist(aktor10);
                em.persist(aktor100);
                em.persist(aktor1000);
                em.persist(major);
                //
                
                
                
                Aktor aktor2 = new Aktor();
                aktor2.setImie("AktorImie2");
                aktor2.setNazwisko("AktorNazwisko2");
                
                Gatunek gatunek1 = new Gatunek();
                gatunek1.setNazwa("Paranormalny");
                
                Gatunek gatunek2 = new Gatunek();
                gatunek2.setNazwa("Przyrodniczy");
                
                
                
                //f2.deleteKraj(x); //usuwanie tylko relacji a nie usuwa kraju z bazy
                //f.deleteKraj(x);
                //em.remove(x);
                //em.remove(y);
                
                Rezyser rez1 = new Rezyser();
                rez1.setImie("Daniel");
                rez1.setNazwisko("Janowski");
                rez1.setNarodowosc("Polska");
                
                Rezyser rez2 = new Rezyser();
                rez2.setImie("Dan");
                rez2.setNazwisko("Jan");
                rez2.setNarodowosc("Pol");
                
                
                
                em.persist(f);
                em.persist(f2);
                
                f.addRezyser(rez1);
                f.addRezyser(rez2);
                f2.addRezyser(rez2);
                
                
                
 
               //em.persist(aktor2);
               //em.persist(aktor1);
               
               f.addAktor(aktor1);
               //f.addAktor(aktor2);
               //f2.addAktor(aktor2);
               aktor1.addFilm(f2);
               em.getTransaction().commit();
               
               em.getTransaction().begin();
  
               
               
               
               em.persist(gatunek1);
               em.persist(gatunek2);
               f2.addGatunek(gatunek1);
               f.addGatunek(gatunek2);
               f.addGatunek(gatunek1);
               f2.addGatunek(gatunek2);
                
                em.refresh(aktor1);
                aktor1.deleteFilm(f);
                //f2.deleteAktor(aktor1);

               
                
                //System.out.println(f.getTytul()+" "+f.getAktorzy());
                //System.out.println(f2.getTytul()+" "+f2.getAktorzy());
                

                //System.out.println(aktor1.getImie()+" "+aktor1.getFilmy());
                
                

                em.getTransaction().commit();
		em.close();
                

    launch(args);

    }
    
}

