import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Crayon{
	private Color couleur;
	private int taille;
	private int tailleGomme;
	private Point place;

	public Crayon(Color cou,int tai){
		couleur=cou;
		taille=tai;
		tailleGomme=5;
		place=new Point(0,0);
	}
	public Crayon(){
		this(Color.white,3);
	}
	public Crayon(Color r){
		this(r,3);
	}
	public Crayon(int tai){
		this(Color.white,tai);
	}

	public int getTaille(){
		return taille;
	}
	public void setTaille(int ta){
		taille=ta;
	}
	public Color getCouleur(){
		return couleur;
	}
	public void setCouleur(Color c){
		couleur=c;
	}
	public Point getXY(){
		return place;
	}
	public void setXY(Point p){
		place=p;
	}
	public void setTailleGomme(int t){
		tailleGomme=t;
	}
	public void dessiner(Graphics g){
		g.setColor(couleur);
		g.fillRect((int)place.getX(),(int)place.getY(),taille,taille);
	}
	public void effacer(Graphics g,Color t){
		g.setColor(t);
		g.fillRect((int)place.getX(),(int)place.getY(),tailleGomme*2,tailleGomme*2);
	}
}