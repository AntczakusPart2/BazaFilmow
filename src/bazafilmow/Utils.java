/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Kraj;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class Utils {
    static EntityManager em;
    public static EntityManager getEntityManager() 
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
        em = entityManagerFactory.createEntityManager();
        return em;
    }
    public static void loadKraje()
    {
	String[] locales = Locale.getISOCountries();
        TreeSet<Kraj> kraje = new TreeSet<>();
	for (String countryCode : locales) 
        {
		Locale obj = new Locale("", countryCode);
                Kraj k = new Kraj();
                k.setNazwa(obj.getDisplayCountry());
                kraje.add(k);
	}
        for(Kraj k : kraje)
        {
            em.persist(k);  
        }
        //TODO: Kraje do tabeli w kolejnosci alfabetycznej
    }
    
    
    
    
}
