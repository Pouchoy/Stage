<%@page import="exerciceWeb3.metier.Produit"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Produit.io, application de folie</title>
</head>
<body>
<h2>Produit.io, the app</h2>
<a href="ProduitServelt?tri=nom">tri nom</a>
<a href="ProduitServelt?tri=prix">tri prix</a>
<a href="ProduitServelt?tri=poids">tri poids</a>
<a href="ProduitServelt?tri=stock">tri stock</a>
<a href="ProduitServelt?tri=zero">tri stock</a><br />
<form method="get">
	<label for="chaine">chaine a rechercher</label> <input type="text" name="chaine" id="chaine" /><br />
	<input type="submit" value="chercher" name="action2" />
</form>
<table border="1">
	<tr><th>Nom</th><th>prix</th><th>poids</th><th>stock</th><th>action</th></tr>
<% 
List<Produit> produits = (List<Produit>)request.getAttribute("produits");
for (Produit t : produits) {			
%>
<tr>
	<td><%= t.getNom() %></td>
	<td><%= t.getPrix() %></td>
	<td><%= t.getPoids() %></td>
	<td><%= t.getStock() %></td>
	<td><form method="post">
			<input type="hidden" 
				   name="id"
				   value="<%= t.getId()%>"/>
			<input type="submit" value="terminer" name="action" />
			<input type="submit" value="editer" name="action" />
		</form>
	</td>
</tr>
<%
}
%>
</table>
<form method="post">
	<input type="hidden" name="id" id="id" value="0" /><br />
	<label for="nom">nom</label> <input type="text" name="nom" id="nom" /><br />
	<label for="prix">prix</label> <input type="text"  name="prix" id="prix"/><br />
	<label for="poids">poids</label> <input type="text"  name="poids" id="poids"/><br />
	<label for="stock">stock</label> <input type="text"  name="stock" id="stock"/><br />
	<input type="submit" value="ajouter" id="ajouter"/>
</form>

</body>
</html>