package exerciceWeb3.utils;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import exerciceWeb3.metier.Produit;

public class ProduitListener implements ServletContextListener {


    public ProduitListener() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("démarrage de la webapp");
    	// je récupère le contexte de la webapp (objet "global" de notre application)
    	ServletContext ctx = arg0.getServletContext();
    	// je cree une todoliste vide
    	List<Produit> produits = new ArrayList<>();
    	// je stocke cette liste comme attribut du contexte de la webapp
    	// comme cela, elle est accessible de partout
    	ctx.setAttribute("produits", produits);
    }
	
}
