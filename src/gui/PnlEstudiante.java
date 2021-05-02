package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import gui.Estudiante;
import gui.TipologiaSexo;
import gui.ControladorEstudiante;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnlEstudiante extends Panel {
	Panel p = new Panel();
	Estudiante actual = new Estudiante();

	public PnlEstudiante() {
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
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PnlEstudiante.class.getResource("Escritorio/DAW/Programación/1.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(PnlEstudiante.class.getResource("Escritorio/DAW/Programación/2.png")));
		toolBar.add(btnAnterior);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/siguiente.png")));
		toolBar.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		
		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/ultimo.png")));
		toolBar.add(btnUltimo);
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/guardar.png")));
		toolBar.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/nuevo.png")));
		toolBar.add(btnNuevo);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(PnlEstudiante.class.getResource("/imagenes/borrar.png")));
		toolBar.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
				vaciarCampos();
			}
		});
	
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(p, gbc_lblNewLabel);
	}
	
	
	
	
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.p.setNombre(this.actual.getNombre());
			this.p.setApellido1(this.actual.getApellido1());
			this.p.setApellido2(this.actual.getApellido2());
			this.p.setDNI(this.actual.getDni());
			this.p.setDireccion(this.actual.getDireccion());
			this.p.setEmail(this.actual.getEmail());
			this.p.setTelefono(this.actual.getTelefono());
			TipologiaSexo t = (TipologiaSexo) p.getJcbSexo().getSelectedItem();
	        this.actual.setTipologiasexo(t);
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
        this.actual.setNombre(this.p.getNombre());
        this.actual.setApellido1(this.p.getPrimerApellido());
        this.actual.setApellido2(this.p.getSegundoApellido());
        this.actual.setDni(this.p.getDni());
        this.actual.setDireccion(this.p.getDireccion());
        this.actual.setEmail(this.p.getEmail());
        this.actual.setTelefono(this.p.getTelefono());
        TipologiaSexo t = (TipologiaSexo) this.p.getJcbSexo().getSelectedItem();
        this.actual.setTipologiasexo(t);
    }
	
	/**
	 * 
	 */ 
	private void vaciarCampos() {
        this.p.jtfNombre.setText("");
        this.p.jtfPrimerApellido.setText("");
        this.p.jtfSegundoApellido.setText("");
        this.p.jtfDNI.setText("");
        this.p.jtfDireccion.setText("");
        this.p.jtfTelefono.setText("");
        this.p.jtfEmail.setText("");
        this.p.jcbSexo.setSelectedIndex(0);
    }
	
	
	/**
	 * 
	 */
	private void guardar () {
        cargarActualDesdePantalla();
        boolean resultado = ControladorEstudiante.getInstance().guardar(this.actual);
        if (resultado == true && this.actual != null && this.actual.getId() > 0) {
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
        }
        else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
	
	private void borrar() {
		String posiblesRespuestas[] = {"Sí","No"};
			int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión Centro Educativo", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	ControladorEstudiante.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    }
	}
	
}
	
	
	
	