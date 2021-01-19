import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;

public class Paint extends JFrame{
	public Paint(){
		Toolkit tk = getToolkit();
		Image im = tk.getImage(getClass().getResource("/Photo/stylo.png"));
		setTitle("Mon paint");
		setIconImage(im);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700,500);
		setLocation(0,0);
		getContentPane().add(new Tableau());
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Paint();
	}
}