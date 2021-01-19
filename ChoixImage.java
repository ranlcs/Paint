import java.io.File;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChoixImage extends JFrame{
	JFileChooser fichier;
	public static String emplacement = "D:/";

	public ChoixImage(){ 
		setSize(400,400);
		setLocation(50,50);
		setVisible(false);
		fichier = new JFileChooser();
		fichier.setCurrentDirectory(new File(emplacement));
		int returnVal = fichier.showDialog(this,"OK");
		add(fichier);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			emplacement = fichier.getSelectedFile().toString();
			setVisible(false);
		}
		else
			setVisible(false);
	}
	public JFileChooser getFichier(){
		return fichier;
	}
	public void addActionListener(ActionListener a){
		fichier.addActionListener(a);
		fichier.approveSelection();
	}
	public String getEmplacement(){
		fichier.setCurrentDirectory(new File(emplacement));
		return emplacement;
	}
}