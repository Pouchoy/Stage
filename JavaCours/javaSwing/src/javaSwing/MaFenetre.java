package javaSwing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MaFenetre extends JFrame implements ActionListener
{
	private JButton bouton1;
	private JButton bouton2;
	private JTextField saisie1;
	private JLabel label1;
	private JCheckBox checkBox1;
	public final static String ACTION_SALUTATION = "salutation";
	public final static String ACTION_MESSAGE = "Bonjour";
	
	public MaFenetre()
	{
		//titre de la fenetre
		super("ma super fenetre");
		
		//définir la taille de ma fenetre
		setSize(800,600);
		
		//permet de centrer la fenetre
		setLocationRelativeTo(null);
		
		//terminer le programme quand on ferme la fenetre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//le flowLayout organise les composants graphiques
		//de gauche a droite et de haut en bas
		setLayout(new FlowLayout());
		
		bouton1 = new JButton("cliquez moi!");
		bouton1.setActionCommand(ACTION_SALUTATION);
		add(bouton1);
		
		bouton1.addActionListener(this);
		
		
		saisie1 = new JTextField(30); 
		add(saisie1);
		
		label1 = new JLabel("un super label");
		add(label1);
		
		//case a cocher
		checkBox1 = new JCheckBox("cochez moi!");
		checkBox1.setSelected(true);
		add(checkBox1);
		
		bouton2 = new JButton("deuxieme");
		bouton2.setActionCommand(ACTION_MESSAGE);
		bouton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "hohoho");				
			}
		});
		add(bouton2);
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("fichier");
		menu1.add("ouvrir");
		menu1.add("fermer");
		JMenuItem menusalutation = new JMenuItem("salutation");
		menu1.add(menusalutation);
		menusalutation.addActionListener(this);
		menusalutation.setActionCommand(ACTION_SALUTATION);
		menubar.add(menu1);
		
		//ajout du menu dans ma fenetre
		this.setJMenuBar(menubar);
		
		/*
		 * for(int i = 1; i <= 15; i++)
			add(new JButton("bouton test " + i));
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(this, "clique");
		//JOptionPane.showMessageDialog(this, saisie1.getText());
		switch(e.getActionCommand()){
		case ACTION_SALUTATION:
			JOptionPane.showMessageDialog(this, ACTION_SALUTATION);
			break;
		case ACTION_MESSAGE:
			JOptionPane.showMessageDialog(this, ACTION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(this,"au revoir");
			break;
		}
	}
}
