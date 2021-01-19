import java.awt.Color;

public class MyColor extends Color{
	public static final MyColor NOIR = new MyColor(0,0,0);
	public static final MyColor BLANC = new MyColor(255,255,255);
	public static final MyColor GRIS= new MyColor(128,128,128);
	public static final MyColor GRIS_CLAIR= new MyColor(192,192,192);
	public static final MyColor GRIS_FONCE= new MyColor(64,64,64); 

	public static final MyColor ROUGE = new MyColor(255,0,0);
	public static final MyColor GRENAT= new MyColor(170,0,0);

	public static final MyColor VERT = new MyColor(0,255,0);
	public static final MyColor VERT_FONCE = new MyColor(0,100,0);

	public static final MyColor BLEU = new MyColor(0,0,255);
	public static final MyColor CYAN= new MyColor(0,255,255);

	
	public static final MyColor VIOLET = new MyColor(100,0,100);
	public static final MyColor ROSE= new MyColor(235,165,165);
	public static final MyColor MAGENTA= new MyColor(255,0,255);
	
	public static final MyColor MARRON = new MyColor(140,50,0);
	public static final MyColor MARRON_CLAIR = new MyColor(170,100,0);
	public static final MyColor ORANGE = new MyColor(255,100,0);
	public static final MyColor JAUNE= new MyColor(255,255,0);
	
	
	public MyColor(int r,int g,int b){
		super(r,g,b);
	}
}