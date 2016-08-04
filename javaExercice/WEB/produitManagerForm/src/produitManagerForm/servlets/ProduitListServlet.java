package produitManagerForm.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produitManagerForm.metier.Produit;
import produitManagerForm.utils.ProduitDAO;


public class ProduitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProduitListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getAttribute renvoie un object, je dois le convertir en (List<Produit>)
		/*List<Produit> produits = (List<Produit>)getServletContext().getAttribute("produits");
		
		List<Produit> filteredList = new ArrayList<>(produits);
		
		request.setAttribute("produits", filteredList);
		
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);*/
		
		ProduitDAO produitdao = (ProduitDAO)getServletContext().getAttribute("produitDAO");
		String tri = request.getParameter("tri");
		if(tri == null)
			tri = "0";
		
		
		List<Produit> produits = produitdao.findAll();
		request.setAttribute("produits", produits);
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
