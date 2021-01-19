import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Color;

public class Dessin extends JPanel{
	private Crayon cray;
	private JPanel tab=this;
	private boolean dessiner=true;
	private BufferedImage enregis;
	private Graphics2D g2d;

	public Dessin(){
		super();
		setBorder(BorderFactory.createBevelBorder(5,Color.red,Color.orange));
		cray=new Crayon();
		addMouseListener(new Clique());
		addMouseMotionListener(new Deplacement());
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent k){
				if(k.getKeyCode()==KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
		setSize(625,500);
		enregis = new BufferedImage(getSize().width,getSize().height,BufferedImage.TYPE_INT_RGB);
		g2d=enregis.createGraphics();
		setBackground(Color.black);
	}

	public void setTaille(int ta){
		cray.setTaille(ta);
	}
	public void setTailleGomme(int t){
		cray.setTailleGomme(t);
	}
	public void setCouleur(Color c){
		cray.setCouleur(c);
	}
	public void changerEtat(){
		dessiner=!dessiner;
	}
	public void setEtat(boolean tre){
		dessiner=tre;
	}
	class Clique extends MouseAdapter{
		public void mouseEnterred(MouseEvent m){
			requestFocus();
		}
		public void mousePressed(MouseEvent e){
			Graphics g = getGraphics();
			cray.setXY(new Point(e.getX(),e.getY()));
			if(dessiner){
				cray.dessiner(g);
				cray.dessiner(g2d);
			}
			else{
				cray.effacer(g,tab.getBackground());
				cray.effacer(g2d,tab.getBackground());
			}
		}
	}
	public void nouveau(){
		Graphics g = getGraphics();
		g.setColor(getBackground());
		g2d.setColor(getBackground());
		g.fillRect(0,0,getSize().width,getSize().height);
		g2d.fillRect(0,0,getSize().width+1000,getSize().height+1000);
	}
	public void sauvegarder(String emplNom) throws Exception {
		if(!emplNom.equals("D:/")){
			File file = new File(emplNom+".png");
			ImageIO.write(enregis,"png",file);
		}
	}

	class Deplacement extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent m){
			Graphics g=tab.getGraphics();
			cray.setXY(new Point(m.getX(),m.getY()));
			if(dessiner){
				cray.dessiner(g);
				cray.dessiner(g2d);
			}
			else{
				cray.effacer(g,tab.getBackground());
				cray.effacer(g2d,Color.black);
			}
		}
	}


}