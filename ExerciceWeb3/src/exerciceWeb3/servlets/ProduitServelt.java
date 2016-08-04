package exerciceWeb3.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciceWeb3.metier.Produit;

public class ProduitServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int compteur_nom = 0;
	private int compteur_prix = 0;
	private int compteur_poids = 0;
	private int compteur_stock = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServelt() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// je récupere la liste de produit
				List<Produit> produits = (List<Produit>)getServletContext().getAttribute("produits");
				
				// ici, on fera le filtrage/tri/etc
				// je copie la liste des taches
				List<Produit> sortedList = new ArrayList<>(produits);
				
				String tri = request.getParameter("tri");
				tri = (tri == null)? "priorite" : tri;
				String chaine = request.getParameter("chaine");
				if(chaine != null)
				{
					tri = "chercher";
				}
				
				switch(tri){
					case "nom":
						// et je la tri par ordre inverse de priorité
						if(compteur_nom == 0)
						{
							Collections.sort(sortedList,(t1, t2) -> t1.getNom().compareTo(t2.getNom()));
							compteur_nom = 1;
						}
						else
						{
							Collections.sort(sortedList,(t1, t2) -> t2.getNom().compareTo(t1.getNom()));
							compteur_nom = 0;
						}
						
						break;
					case "prix":
						// et je la tri par ordre inverse de priorité
						if(compteur_prix == 0)
						{
							Collections.sort(sortedList,(t1, t2) -> ((Double)t1.getPrix()).compareTo(t2.getPrix()));
							compteur_prix=1;
						}
						else
						{
							Collections.sort(sortedList,(t1, t2) -> ((Double)t2.getPrix()).compareTo(t1.getPrix()));
							compteur_prix=0;
						}
						
						break;
					case "poids":
						if(compteur_poids == 0)
						{
							Collections.sort(sortedList,(t1, t2) -> ((Double)t1.getPoids()).compareTo(t2.getPoids()));
							compteur_poids=1;
						}
						else
						{
							Collections.sort(sortedList,(t1, t2) -> ((Double)t2.getPoids()).compareTo(t1.getPoids()));
							compteur_poids=0;
						}
						break;
					case "stock":
						if(compteur_stock == 0)
						{
							Collections.sort(sortedList,(t1, t2) -> ((Integer)t1.getStock()).compareTo(t2.getStock()));
							compteur_stock=1;
						}
						else
						{
							Collections.sort(sortedList,(t1, t2) -> ((Integer)t2.getStock()).compareTo(t1.getStock()));
							compteur_stock=0;
						}
						
						break;
					case "zero":
						sortedList = sortedList.stream().filter(p -> p.getStock() > 0).collect(Collectors.toList());
						break;
					case "chercher":
						sortedList.removeIf(p -> p.getNom().indexOf(chaine)< 0);
						break;
				}
				
				
				// je met la liste des taches a afficher dans la requette
				// pour que la page jsp puisse l'afficher
				request.setAttribute("produits", sortedList);
				
				// je demande a la page liste.jsp de faire l'affichage
				getServletContext().getRequestDispatcher("/produit.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Produit> produits = (List<Produit>)getServletContext().getAttribute("produits");
		
		if (action != null && action.equals("terminer")) {
			//suppression d'une tache
			// recuperation du nom de la tache a supprimer (champ hidden)
			int id = Integer.parseInt(request.getParameter("id"));
			
			// je retire la tache avec la même description
			produits.removeIf(p -> p.getId() == id);
		}
		else if(action != null && action.equals("editer"))
		{
			System.out.println("bonjour");
		}
		else
		{
			Produit p = new Produit(Integer.parseInt(request.getParameter("id")),
									request.getParameter("nom"),
									Double.parseDouble(request.getParameter("prix")),
									Double.parseDouble(request.getParameter("poids")),
									Integer.parseInt(request.getParameter("stock"))
									);
			
				if(p.getId() == 0)
				{
					int max = 0;
					for(Produit p1 : produits)
						if(p1.getId()>max)
							max = p1.getId();
					p.setId(max+1);
				}
			produits.add(p);
		}
		/*
		// je rapelle doGet pour faire un affichage "classique" de ma liste de taches
		doGet(request, response);*/
		response.sendRedirect("ProduitServelt");
	}

}
