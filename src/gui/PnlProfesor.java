package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class PnlProfesor extends Panel {
	Panel p = new Panel();
	
	public PnlProfesor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/first.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/anterior.png")));
		toolBar.add(btnAnterior);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/siguiente.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/ultimo.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/guardar.png")));
		toolBar.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/nuevo.png")));
		toolBar.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(PnlProfesor.class.getResource("/imagenes/borrar.png")));
		toolBar.add(btnNewButton_6);
	
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(p, gbc_lblNewLabel);
	}

}
