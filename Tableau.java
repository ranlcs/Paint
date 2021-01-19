import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Tableau extends JPanel implements ActionListener,AdjustmentListener,ItemListener{
	public static Color[] COULEUR = {Color.white,Color.red,Color.green,Color.blue,Color.yellow,MyColor.ORANGE,Color.pink,Color.magenta,Color.cyan,Color.white};
	public static String[] NOMCOULEUR = {"white","rouge","vert","bleu","jaune","orange","rose","magenta","cyan","white"};
	private Dessin des = new Dessin();
	private JToggleButton crayon = new JToggleButton(new ImageIcon(getClass().getResource("/Photo/stylo.png")));
	private JToggleButton gomme = new JToggleButton("Gomme");
	private JToggleButton[] couleur = new JToggleButton[COULEUR.length];
	private JButton sauvegarde = new JButton("Sauvegarder");
	private JButton nouveau = new JButton("Nouveau");
	private JScrollBar tailleCrayonGomme = new JScrollBar(JScrollBar.HORIZONTAL,5,0,1,11);

	public Tableau(){
		setLayout(new BorderLayout());
		ButtonGroup ens = new ButtonGroup();
		
		//emplacement generale
		Box gauche=Box.createVerticalBox();
		add(gauche,BorderLayout.WEST);
		add(des,BorderLayout.CENTER);

		//Gomme crayon et leur taille
		Box haut = Box.createVerticalBox();
		crayon.setSelected(true);
		crayon.setPreferredSize(new Dimension(33,35));
		crayon.setActionCommand("Crayon");
		crayon.addActionListener(this);
		tailleCrayonGomme.addAdjustmentListener(this);
		JPanel cra = new JPanel();
		cra.add(crayon);
		haut.add(cra);
		haut.add(tailleCrayonGomme);
		gauche.add(haut);

		gauche.add(Box.createVerticalStrut(10));

		//panel des couleurs
		JPanel panelCouleur = new JPanel();
		panelCouleur.setLayout(new FlowLayout());
		JPanel gaucheCouleur = new JPanel();
		gaucheCouleur.setLayout(new GridLayout(5,2,7,7));
		panelCouleur.setPreferredSize(new Dimension(100,150));
		panelCouleur.add(gaucheCouleur);
		panelCouleur.add(Box.createHorizontalStrut(10));
		gauche.add(panelCouleur);
		for(int i=0;i<couleur.length;i++){
			String t="/Photo/"+NOMCOULEUR[i]+".png";
			couleur[i] = new JToggleButton(new ImageIcon(getClass().getResource(t)));
			couleur[i].addActionListener(this);
			couleur[i].setActionCommand(String.valueOf(i));
			couleur[i].setSize(10,10);
			couleur[i].setPreferredSize(new Dimension(22,22));
			gaucheCouleur.add(couleur[i]);
			ens.add(couleur[i]);
		}
		couleur[0].setSelected(true);

		gauche.add(Box.createVerticalStrut(10));
		
		JPanel nou = new JPanel();
		nou.setLayout(new BorderLayout());
		nouveau.addActionListener(this);
		gauche.add(nou);
		nou.add(nouveau,BorderLayout.NORTH);
		
		//sauvegarde
		JPanel bas = new JPanel();
		bas.setLayout(new BorderLayout());
		sauvegarde.addActionListener(this);
		gauche.add(bas);
		bas.add(sauvegarde,BorderLayout.NORTH);	
	}

	public void actionPerformed(ActionEvent a){
		String nom="";
		try{
			JButton but = (JButton)a.getSource();
			nom = but.getActionCommand();
		}
		catch(Exception e){
			try{
				JToggleButton but = (JToggleButton)a.getSource();
				nom = but.getActionCommand();
			}
			catch(Exception e1){
				System.out.println(e1);
			}
		}
		if(nom.equals("Crayon")){
			des.setTaille(tailleCrayonGomme.getValue());
			des.setTailleGomme(tailleCrayonGomme.getValue());
			des.changerEtat();
			if(crayon.isSelected())
				crayon.setIcon(new ImageIcon(getClass().getResource("/Photo/stylo.png")));
			else
				crayon.setIcon(new ImageIcon(getClass().getResource("/Photo/gomme.png")));
		}
		else if(nom.equals("Sauvegarder")){
			ChoixImage tre = new ChoixImage();
			String empl=tre.getEmplacement();
			try{
				if(empl.lastIndexOf('c')>=0)
					empl=empl.substring(0,empl.length()-4);
				des.sauvegarder(empl);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else if(nom.equals("Nouveau")){
			des.nouveau();
		}
		else try{
			int p = Integer.parseInt(nom);
			String t="/Photo/"+NOMCOULEUR[p]+".png";
			des.setCouleur(COULEUR[p]);
			des.setTaille(tailleCrayonGomme.getValue());
			des.setTailleGomme(tailleCrayonGomme.getValue());
			des.setEtat(true);
			crayon.setSelected(true);
			crayon.setIcon(new ImageIcon(getClass().getResource("/Photo/stylo.png")));
			couleur[couleur.length-1].setIcon(new ImageIcon(getClass().getResource(t)));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void adjustmentValueChanged(AdjustmentEvent a){
		if(crayon.isSelected())
			des.setTaille(a.getValue());
		else
			des.setTailleGomme(a.getValue());
	}
	public void itemStateChanged(ItemEvent o){
		int i=0;
		while(i<couleur.length && !couleur[i].isSelected()){
			i++;
		}

		if(i!=couleur.length)
			des.setCouleur(COULEUR[i]);
	}
}