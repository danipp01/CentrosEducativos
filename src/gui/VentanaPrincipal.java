package gui;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	private JTabbedPane jTabbedPane = null;
	
	private static VentanaPrincipal instance = null;
	
	public static VentanaPrincipal getInstance () {
		if (instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}
	
	public VentanaPrincipal() {
		super("Gestión de Educación");
		this.setBounds(0, 0, 600, 400);
		
		this.setMenuBar(new MenuBar());
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
	}

	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		
		jTabbedPane.add("Estudiante", new PnlEstudiante());
		jTabbedPane.add("Profesor", new PnlProfesor());

		return jTabbedPane;
	}
	
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}

	public static void main(String[] args) {
		VentanaPrincipal.getInstance().setVisible(true);
	}
}