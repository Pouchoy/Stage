package exercice_java_5_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Fenetre extends JFrame implements ActionListener, DocumentListener {
	
	//panel auto-scrollant
		private static final  String ACTION_LIST = "LIST";
		private static final  String ACTION_PRODUIT = "PRODUIT";
		private static final String ACTION_SAUVEGARDER = "SAUVEGARDER";
		private static final String ACTION_LOAD = "LOAD";
		private static final String ACTION_ENREGISTRER = "ENREGISTRER";
		public static final String TRI_PRIX = "tri par prix";
		public static final String TRI_POIDS = "tri par poids";
		public static final String TRI_NOM = "tri par nom";
		public static final String TRI_POIDS_PRIX = "poids/prix";
		public static final String EDIT_PRODUIT = "edition";
		public static final String TRI_PRODUIT = "trier";
		public static final String SAVE_PRODUIT = "sauver";
		
		private boolean affiche_erreur = false;
		private boolean affiche = true;
		private JScrollPane panneauList;
		//le composant graphique JList
		private JList<Produit> liste;
		private DefaultListModel<Produit> data;
		private JButton boutonList;
		private JButton boutonRentrerProduit;
		private JPanel panelCommande;
		private JTextField textField;
		private JTextField textField2;
		private JTextField textField3;
		private JButton boutonSauvegarder;
		private JButton boutonLoad;
		private JButton boutonEnregistrer;
		private JLabel label;
		private JLabel label1;
		private JLabel label2;
		private JComboBox<String> choixTri;
		private JPanel panelHaut;
		
		private Pattern nomMotif;
		private Comparator<Produit> produitNomComparator;
		private Comparator<Produit> produitPoidsComparator;
		
		public Fenetre(){
			super("Traitement des produits");
			
			setSize(800,600);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			//je crée mon tableau de donnée (vide)
			data = new DefaultListModel<Produit>();
			//je crée ma jlist associée au tableau
			liste = new JList<Produit>(data);
			//je place ma jlist dans le scrollpane
			panneauList = new JScrollPane(liste);
			
			boutonList = new JButton("Listes");
			boutonList.setActionCommand(ACTION_LIST);
			boutonList.addActionListener(this);
			//boutonList.setPreferredSize(new Dimension(40, 50));
			add(boutonList);
			
			
			boutonRentrerProduit = new JButton("Saisir produit");
			boutonRentrerProduit.setActionCommand(ACTION_PRODUIT);
			boutonRentrerProduit.addActionListener(this);
			//boutonList.setPreferredSize(new Dimension(40,50));
			add(boutonRentrerProduit);

			panelCommande = new JPanel();
			add(panelCommande, BorderLayout.EAST);
			BoxLayout b1 = new BoxLayout(panelCommande, BoxLayout.Y_AXIS);
			panelCommande.setLayout(b1);
			
			label = new JLabel("Produit :");
			label.setVisible(false);
			
			textField = new JTextField();
			textField.getDocument().addDocumentListener(this);
			textField.setSize(40, 10);
			textField.setVisible(false);
			
			label1 = new JLabel("Prix :");
			label1.setVisible(false);
			
			textField2 = new JTextField();
			textField2.getDocument().addDocumentListener(this);
			textField2.setSize(40, 10);
			textField2.setVisible(false);
			
			label2 = new JLabel("Poids :");
			label2.setVisible(false);
			
			textField3 = new JTextField();
			textField3.getDocument().addDocumentListener(this);
			textField3.setSize(40, 10);
			textField3.setVisible(false);
			
			boutonEnregistrer = new JButton("Enregistrer");
			boutonEnregistrer.setActionCommand(ACTION_ENREGISTRER);
			boutonEnregistrer.addActionListener(this);
			boutonEnregistrer.setVisible(false);
			
			boutonSauvegarder = new JButton("Save");
			boutonSauvegarder.setActionCommand(ACTION_SAUVEGARDER);
			boutonSauvegarder.addActionListener(this);
			
			boutonLoad = new JButton("Load");
			boutonLoad.setActionCommand(ACTION_LOAD);
			boutonLoad.addActionListener(this);
			
			panelCommande.add(boutonList);
			panelCommande.add(boutonRentrerProduit);
			
			panelCommande.add(label);
			panelCommande.add(textField);
			panelCommande.add(label1);
			panelCommande.add(textField2);
			panelCommande.add(label2);
			panelCommande.add(textField3);
			panelCommande.add(boutonEnregistrer);
			panelCommande.add(Box.createRigidArea(new Dimension(0,100)));
			panelCommande.add(boutonSauvegarder);
			panelCommande.add(boutonLoad);
			
			add(panneauList, BorderLayout.CENTER);
			
			panelHaut = new JPanel();
			add(panelHaut, BorderLayout.NORTH);
			BoxLayout b2 = new BoxLayout(panelCommande, BoxLayout.Y_AXIS);
			panelCommande.setLayout(b2);
			
			
			choixTri = new JComboBox<>(new String[] {TRI_PRIX, TRI_POIDS, TRI_NOM, TRI_POIDS_PRIX});
			choixTri.setSelectedIndex(0);
			panelHaut.add(choixTri);
			choixTri.setActionCommand(TRI_PRODUIT);
			choixTri.addActionListener(this);
			
			
			setResizable(false);
			
			nomMotif = Pattern.compile("^[-' _a-z0-9]{2,40}$", Pattern.CASE_INSENSITIVE);
			
		
			/*textField.setBackground(Color.WHITE);
			textField2.setBackground(Color.WHITE);
			textField3.setBackground(Color.WHITE);*/
			
			produitPoidsComparator = new Produit.PoidsComparator();
			produitNomComparator = new Produit.NomComparator();
			
			/*produitPoidsComparator = new Comparator<Produit>(){
				@Override
				public int compare(Produit o1, Produit o2)
				{
					if(o1.getPoids()< o2.getPoids())
						return -1;
					if(o1.getPoids() > o2.getPoids())
						return 1;
					return 0;
				}
			};
			
			produitNomComparator = new Comparator<Produit>(){
				@Override
				public int compare(Produit o1, Produit o2)
				{
					return o1.getNom().compareTo(o2.getNom());
				}
			};*/
			
		}
		
		private void validatefield()
		{
			boolean isValid = true;
			if(affiche_erreur)
			{
			
				if(textField2.getText().equals(null) && textField3.getText().equals(""))
				{
					textField2.setBackground(Color.WHITE);
				}
				else
				{
					try{
						Double.parseDouble(textField2.getText());
						textField2.setBackground(Color.GREEN);
					}
					catch(NumberFormatException ex)
					{
						isValid = false;
						textField2.setBackground(Color.RED);
					}
				}
				
				if( textField3.getText().equals(null) && textField3.getText().equals("") )
				{
					textField3.setBackground(Color.WHITE);
				}
				else
				{
					try{
						Double.parseDouble(textField3.getText());
						textField3.setBackground(Color.GREEN);
					}
					catch(NumberFormatException ex)
					{
						isValid = false;
						textField3.setBackground(Color.RED);
					}
				}
				if( !nomMotif.matcher(textField.getText()).matches() )
				{
					textField.setBackground(Color.RED);
					isValid = false;
				}
				else
				{
					textField.setBackground(Color.GREEN);
				}
				this.boutonEnregistrer.setEnabled(isValid);
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			affiche_erreur = true;
			validatefield();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			affiche_erreur = true;
			validatefield();		
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			affiche_erreur = true;
			validatefield();
		}
		
		
		public void afficherList()
		{
			Random rd = new Random();
			for (int i = 0; i < 10; i++) {
				if (rd.nextBoolean())
					data.addElement(  new Produit("fromage" +	i,
												rd.nextDouble() * 100.0,
												rd.nextDouble() * 10.0));
				else
					data.addElement( new Produit("dessert" +	i,
												rd.nextDouble() * 100.0,
												rd.nextDouble() * 10.0));
			}
			trier_liste();
		}
		
		private void rentrerProduit() {
			if(affiche)
			{
				textField.setVisible(true);
				textField2.setVisible(true);
				textField3.setVisible(true);
				boutonEnregistrer.setVisible(true);
				label.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				affiche = false;
			}
			else
			{
				textField.setVisible(false);
				textField2.setVisible(false);
				textField3.setVisible(false);
				boutonEnregistrer.setVisible(false);
				label.setVisible(false);
				label1.setVisible(false);
				label2.setVisible(false);
				affiche = true;
			}
		}
		
		private void trier_liste() {
			// j'ai ma collection de produit a trier
			List<Produit> produits = new ArrayList<Produit>();
			// je copie le contenu de mon defaultlistModel
			// dans la liste a trier
			for (int i = 0; i < data.size(); i++)
				produits.add(data.getElementAt(i));
			
			// je rÃ©cupere le choix de tri actuel dans la combobox
			switch (choixTri.getItemAt(choixTri.getSelectedIndex())) 
			{
				case TRI_PRIX:
					// je trie ma liste
					Collections.sort(produits);
					break;
				case TRI_POIDS:
					// je trie ma liste
					Collections.sort(produits, produitPoidsComparator);
					break;
				case TRI_NOM:
					// je trie ma liste
					Collections.sort(produits, produitNomComparator);
					break;
				case TRI_POIDS_PRIX:
					Collections.sort(produits, (p1, p2) -> {
						return  new Double(p1.getPrix() / p1.getPoids()).compareTo(p2.getPrix() / p2.getPoids()); 
					});
			}
			
			
			//je recopie ma liste dans le defaultListModel
			data.clear();
			for (Produit p : produits)
				data.addElement(p);
			
		}
		
		private void load() {
	 		
			
	 		try 
		 	{
	 			String path = System.getProperty("user.dir" );
				String path_source = "/src/exercice_java_5_1/";
		 		JFileChooser dialogue = new JFileChooser(path+ path_source);
		 		String texte = "";
	            dialogue.showOpenDialog(null);
	 			if(dialogue.getSelectedFile().getAbsolutePath() != null)
	 			{
		            File fichier = new File(dialogue.getSelectedFile().getAbsolutePath());
		  			
		 			BufferedReader inStream  = new BufferedReader (new FileReader(fichier));
	
		  			data.clear();
		 			for (String line = inStream.readLine(); line != null; line = inStream.readLine()) {
		 	             texte = line;
		 	             ajouterProduitList(texte);
		 	        }
		   			inStream.close();
	 			}
	  		} 
	 		catch (Exception e) 
	  		{
	              System.out.println("Exception cause: "+e);
	  		}		
		}

		private void ajouterProduitList(String texte) {
			data.addElement(Produit.comeToCSV(texte));
			trier_liste();
		}

		private void sauvegarder() {
			String path = System.getProperty("user.dir" );
			String path_source = "/src/exercice_java_5_1/";
	 		JFileChooser dialogue1 = new JFileChooser(path+ path_source);
	 		dialogue1.showOpenDialog(null);
	 		
			//ecrire dans un fichier
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(dialogue1.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			for(Object o : data.toArray())
			{
				Produit p = (Produit) o; 
				pw.println(p.toCSV());
			}
			pw.close();
			
		}
		
		private void enregistrer() {
			data.addElement(Produit.comeToCSV(textField.getText() + ";" + textField2.getText() + ";" + textField3.getText()));
			trier_liste();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(ACTION_LIST))
				this.afficherList();
			else if(e.getActionCommand().equals(ACTION_PRODUIT))
				this.rentrerProduit();
			else if(e.getActionCommand().equals(ACTION_ENREGISTRER))
				this.enregistrer();
			else if(e.getActionCommand().equals(ACTION_SAUVEGARDER))
				this.sauvegarder();
			else if(e.getActionCommand().equals(ACTION_LOAD))
				this.load();
			else if (e.getActionCommand().equals(TRI_PRODUIT))
				this.trier_liste();
			else
				System.out.println("clique non reconnu");
			
		}

		

	

		

}
