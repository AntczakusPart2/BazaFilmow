/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 *
 * @author Mateusz
 */




public class Utilities {
    
    
 public static List<Aktor> WyszukajPoNazwisku(String Nazwisko){
 
     List<Aktor> Aktorzy;
     
     

     EntityManager em = Utils.getEntityManager();

     Aktorzy=em.createNamedQuery("Aktor.findByNazwisko") .setParameter("nazwisko", Nazwisko).getResultList();
     
     
     //System.out.println(Aktorzy.size()); liczba aktorow o takim Nazwisku
    return Aktorzy;
 }  
 
 
 public static List<Aktor> WyszukajPoNazwiskuPartialy(String Nazwisko){
 
     List<Aktor> Aktorzy;
      List<Aktor> Wynik = new ArrayList<Aktor>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Aktor.findAll").getResultList();
    
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
      
      Nazwisko=Nazwisko.toLowerCase();
          
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i); 
        
       Wynik.add(Aktorzy.get(i));  
     //  System.out.println(Aktorzy.get(i).getNazwisko());
       
         }
 
      }   
      
     
    
     return Wynik;
 }
     
 
 //sprawdza czy pasuje jako imie lub nazwisko
 public static List<Aktor> WyszukajAktoraPoStringu(String Nazwisko){
 
     List<Aktor> Aktorzy;
      List<Aktor> Wynik = new ArrayList<Aktor>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Aktor.findAll").getResultList();
    
       Nazwisko=Nazwisko.toLowerCase();
      
      
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik.add(Aktorzy.get(i));  
      // System.out.println(Aktorzy.get(i).getNazwisko());  //testy
                }
        }      
       for(int i=0;i<Aktorzy.size();i++){   
      if(Aktorzy.get(i).getImie().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik.add(Aktorzy.get(i));  
       //System.out.println(Aktorzy.get(i).getImie());  
                }
        }  
      
     
    
     return Wynik;
 }
 
 //sprawdza czy dany aktor znajduje sie juz w liscie
 private static List<Aktor> SprawdzP(List<Aktor> Lista,Aktor  nowy){
 
     int dodanie=0;
    for(int i=0;i<Lista.size();i++){
    if(Lista.get(i).equals(nowy)==true){
    dodanie=1;
         }
     }    
    if(dodanie==0){
    Lista.add(nowy);  
     }   
return Lista;
 }
 
 
  private static List<Film> SprawdzFilm(List<Film> Lista,Film  nowy){
 
     int dodanie=0;
    for(int i=0;i<Lista.size();i++){
    if(Lista.get(i).equals(nowy)==true){
    dodanie=1;
         }
     }    
    if(dodanie==0){
    Lista.add(nowy);  
     }   
return Lista;
 }
 
 
 
 public static List<Aktor> WyszukajAktoraPoStringuBezPowtorzen(String Nazwisko){
 
     List<Aktor> Aktorzy;
      List<Aktor> Wynik = new ArrayList<Aktor>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Aktor.findAll").getResultList();
    
       Nazwisko=Nazwisko.toLowerCase();
      
      
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i); 
       Wynik=SprawdzP(Wynik,Aktorzy.get(i)); 
      // System.out.println(Aktorzy.get(i).getNazwisko());  //testy
                }
        }   
      
      
       for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getImie().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik=SprawdzP(Wynik,Aktorzy.get(i)); 
       //System.out.println(Aktorzy.get(i).getImie());  //test 2
                }
        }  
      
     
    
     return Wynik;
 }
 
 
 
  public static List<Aktor> WyszukajAktoraPoStringuBezPowtorzenAlpha(String Nazwisko){
 
     List<Aktor> Aktorzy;
      List<Aktor> Wynik = new ArrayList<Aktor>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Aktor.findAllAlpha").getResultList();
    
       Nazwisko=Nazwisko.toLowerCase();
      
      
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i); 
       Wynik=SprawdzP(Wynik,Aktorzy.get(i)); 
      // System.out.println(Aktorzy.get(i).getNazwisko());  //testy
                }
        }   
      
      
       for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getImie().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik=SprawdzP(Wynik,Aktorzy.get(i)); 
       //System.out.println(Aktorzy.get(i).getImie());  //test 2
                }
        }  
      
     
    
     return Wynik;
 }
 
 
 
 
 public static List<Film> WyszukajFilmPoStringuBezPowtorzen(String nazwaf){
      List<Film> Filmy;
      List<Film> Wynik = new ArrayList<Film>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Filmy=em.createNamedQuery("Film.findAll").getResultList();
    
       nazwaf=nazwaf.toLowerCase();
      
      
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Filmy.size();i++){
         
      if(Filmy.get(i).getTytul().toLowerCase().contains(nazwaf)==true){
     
       // System.out.println(i); 
       Wynik=SprawdzFilm(Wynik,Filmy.get(i)); 
     //  System.out.println(Filmy.get(i).getTytul());  //testy
                }
        }   
      
      
       
     return Wynik;
 
 
 }
 
 
 
 private static List<Rezyser> SprawdzRezysera(List<Rezyser> Lista,Rezyser  nowy){
 
     int dodanie=0;
    for(int i=0;i<Lista.size();i++){
    if(Lista.get(i).equals(nowy)==true){
    dodanie=1;
         }
     }    
    if(dodanie==0){
    Lista.add(nowy);  
     }   
return Lista;
 }
 
 
  public static List<Rezyser> WyszukajRezyseraPoStringu(String Nazwisko){
 
     List<Rezyser> Aktorzy;
      List<Rezyser> Wynik = new ArrayList<Rezyser>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Rezyser.findAll").getResultList();
    
       Nazwisko=Nazwisko.toLowerCase();
      
      
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik.add(Aktorzy.get(i));  
      // System.out.println(Aktorzy.get(i).getNazwisko());  //testy
                }
        }      
       for(int i=0;i<Aktorzy.size();i++){   
      if(Aktorzy.get(i).getImie().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik.add(Aktorzy.get(i));  
       //System.out.println(Aktorzy.get(i).getImie());  
                }
        }  
      
     
    
     return Wynik;
 }
 
 
 
 
 
 public static List<Aktor> PodajListeAktor(){
 List<Aktor> Aktorzy;
 
 
     EntityManager em = Utils.getEntityManager();

     Aktorzy=em.createNamedQuery("Aktor.findAllAlpha").getResultList();
     
     
     
     return Aktorzy;
 
 }
 
  public static List<Film> PodajListeFilm(){
 List<Film> Filmy;
 
 
     EntityManager em = Utils.getEntityManager();

     Filmy=em.createNamedQuery("Film.findAllAlpha").getResultList();
     
     
     
     return Filmy;
 
 }
  
  
  
   public static List<Gatunek> PodajListeGatunk(){
 List<Gatunek> Gatunki;
 
 
     EntityManager em = Utils.getEntityManager();

     Gatunki=em.createNamedQuery("Gatunek.findAllAlpha").getResultList();
     
     
     
     return Gatunki;
 
 }
   
   
   
     public static List<Kraj> PodajListeKraj(){
 List<Kraj> Kraje;
 
 
     EntityManager em = Utils.getEntityManager();

     Kraje=em.createNamedQuery("Kraj.findAllAlpha").getResultList();
     
     
     
     return Kraje;
 
 }
 
        public static List<Rezyser> PodajListeRezyser(){
 List<Rezyser> Rezyserowe;
 
 
     EntityManager em = Utils.getEntityManager();

     Rezyserowe=em.createNamedQuery("Rezyser.findAllAlpha").getResultList();
     
     
     
     return Rezyserowe;
 
 }  
   

}
