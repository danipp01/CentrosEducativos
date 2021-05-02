package gui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Principal extends JFrame {

	private JTabbedPane jTabbedPane = null;
	
	private static Principal instance = null;

	public static Principal getInstance () {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}

	public Principal() {
		super("Gestión de venta de coches");
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
		Principal.getInstance().setVisible(true);
	}

}