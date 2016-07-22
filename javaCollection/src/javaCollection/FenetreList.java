package javaCollection;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class FenetreList extends JFrame {
	
	//panel auto-scrollant
	private JScrollPane panneauList;
	//le composant graphique JList
	private JList<String> liste;
	private DefaultListModel<String> data;
	
	public FenetreList(){
		super("liste de choix");
		
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//je crée mon tableau de donnée (vide)
		data = new DefaultListModel<>();
		//je crée ma jlist associée au tableau
		liste = new JList<>(data);
		//je place ma jlist dans le scrollpane
		panneauList = new JScrollPane(liste);

		add(panneauList, BorderLayout.CENTER);
		
		data.addElement("Paris");
		data.addElement("Montpellier");
		data.addElement("Toulouse");
		data.addElement("Lyon");
		data.addElement("Clermont-Ferraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaand");
		data.addElement("Rennes");
		data.addElement("Rouen");
	}

}
