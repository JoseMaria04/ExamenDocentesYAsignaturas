package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorAsignaturasPorDocente;
import controller.ControladorDocente;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfNombre;
	JComboBox<Docente> jcbDocente;
	JList<Asignatura> jlAsignaturaNoSelecionada;
	JList<Asignatura> jlAsignaturaSelecionada;
	private DefaultListModel<Asignatura> listModelAsignaturaNoSelecionada = null;
	private DefaultListModel<Asignatura> listModelAsignaturaSelecionada = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Docentes y asignaturas");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.weightx = 1.0;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 0;
		gbc_jtfNombre.gridy = 1;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JButton jbtFiltrar = new JButton("Filtrar");
		jbtFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		GridBagConstraints gbc_jbtFiltrar = new GridBagConstraints();
		gbc_jbtFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_jbtFiltrar.gridx = 1;
		gbc_jbtFiltrar.gridy = 1;
		contentPane.add(jbtFiltrar, gbc_jbtFiltrar);
		
		jcbDocente = new JComboBox<Docente>();
		GridBagConstraints gbc_jcbDocente = new GridBagConstraints();
		gbc_jcbDocente.insets = new Insets(0, 0, 5, 5);
		gbc_jcbDocente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbDocente.gridx = 0;
		gbc_jcbDocente.gridy = 2;
		contentPane.add(jcbDocente, gbc_jcbDocente);
		
		JButton jbtCargarMaterias = new JButton("CargarMaterias");
		jbtCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMateria();
			}
		});
		GridBagConstraints gbc_jbtCargarMaterias = new GridBagConstraints();
		gbc_jbtCargarMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_jbtCargarMaterias.gridx = 1;
		gbc_jbtCargarMaterias.gridy = 2;
		contentPane.add(jbtCargarMaterias, gbc_jbtCargarMaterias);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.weighty = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{220, 0, 189};
		gbl_panel.rowWeights = new double[]{0.0, 1.0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0};
//		gbl_panel.columnWidths = new int[]{0};
//		gbl_panel.rowHeights = new int[]{0};
//		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Asignatura no selecionada");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asignaturas selecionada");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jlAsignaturaNoSelecionada = new JList<Asignatura>(getDefaultListModel(true));
		GridBagConstraints gbc_jlAsignaturaNoSelecionada = new GridBagConstraints();
		gbc_jlAsignaturaNoSelecionada.weighty = 1.0;
		gbc_jlAsignaturaNoSelecionada.insets = new Insets(0, 0, 0, 5);
		gbc_jlAsignaturaNoSelecionada.fill = GridBagConstraints.BOTH;
		gbc_jlAsignaturaNoSelecionada.gridx = 0;
		gbc_jlAsignaturaNoSelecionada.gridy = 1;
		panel.add(jlAsignaturaNoSelecionada, gbc_jlAsignaturaNoSelecionada);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
//		gbl_panel_1.columnWidths = new int[]{0};
//		gbl_panel_1.rowHeights = new int[]{0};
//		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton jbtDerecha = new JButton(">>");
		jbtDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosDerecha();
			}
		});
		GridBagConstraints gbc_jbtDerecha = new GridBagConstraints();
		gbc_jbtDerecha.insets = new Insets(0, 0, 5, 0);
		gbc_jbtDerecha.gridx = 0;
		gbc_jbtDerecha.gridy = 0;
		panel_1.add(jbtDerecha, gbc_jbtDerecha);
		
		JButton jbtSelecionadoDerecha = new JButton(">");
		jbtSelecionadoDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionadoDerecha();
			}
		});
		GridBagConstraints gbc_jbtSelecionadoDerecha = new GridBagConstraints();
		gbc_jbtSelecionadoDerecha.insets = new Insets(0, 0, 5, 0);
		gbc_jbtSelecionadoDerecha.gridx = 0;
		gbc_jbtSelecionadoDerecha.gridy = 1;
		panel_1.add(jbtSelecionadoDerecha, gbc_jbtSelecionadoDerecha);
		
		JButton jbtSelecionadoIzquierda = new JButton("<");
		jbtSelecionadoIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionadoIzquierda();
			}
		});
		GridBagConstraints gbc_jbtSelecionadoIzquierda = new GridBagConstraints();
		gbc_jbtSelecionadoIzquierda.insets = new Insets(0, 0, 5, 0);
		gbc_jbtSelecionadoIzquierda.gridx = 0;
		gbc_jbtSelecionadoIzquierda.gridy = 2;
		panel_1.add(jbtSelecionadoIzquierda, gbc_jbtSelecionadoIzquierda);
		
		JButton jbtIzquierda = new JButton("<<");
		jbtIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosIzquierda();
			}
		});
		GridBagConstraints gbc_jbtIzquierda = new GridBagConstraints();
		gbc_jbtIzquierda.gridx = 0;
		gbc_jbtIzquierda.gridy = 3;
		panel_1.add(jbtIzquierda, gbc_jbtIzquierda);
		
		jlAsignaturaSelecionada = new JList<Asignatura>(getDefaultListModel(false));
		GridBagConstraints gbc_jlAsignaturaSelecionada = new GridBagConstraints();
		gbc_jlAsignaturaSelecionada.weighty = 1.0;
		gbc_jlAsignaturaSelecionada.fill = GridBagConstraints.BOTH;
		gbc_jlAsignaturaSelecionada.gridx = 2;
		gbc_jlAsignaturaSelecionada.gridy = 1;
		panel.add(jlAsignaturaSelecionada, gbc_jlAsignaturaSelecionada);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints jbtGuardar = new GridBagConstraints();
		jbtGuardar.gridwidth = 2;
		jbtGuardar.insets = new Insets(0, 0, 0, 5);
		jbtGuardar.gridx = 0;
		jbtGuardar.gridy = 4;
		contentPane.add(btnNewButton, jbtGuardar);
	}

	/**
	 * 
	 */
	private void filtrar() {
		jcbDocente.removeAllItems();
		for (Docente d : ControladorDocente.findByLikeDescripcion(jtfNombre.getText())) {
			jcbDocente.addItem(d);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModel(boolean isNoSelecionada) {
		if(isNoSelecionada) {
			this.listModelAsignaturaNoSelecionada = new DefaultListModel<Asignatura>();
			return this.listModelAsignaturaNoSelecionada;
		}
		else {
			this.listModelAsignaturaSelecionada = new DefaultListModel<Asignatura>();
			return this.listModelAsignaturaSelecionada;
		}
	}
	
	private void cargarMateria() {
		this.listModelAsignaturaNoSelecionada.removeAllElements();
		this.listModelAsignaturaSelecionada.removeAllElements();
		Docente d = (Docente) jcbDocente.getSelectedItem();
		
		for (Asignaturaspordocente as : d.getAsignaturaspordocentes()) {
			this.listModelAsignaturaSelecionada.addElement(as.getAsignatura());	
		}
		
		for (Asignaturaspordocente a : ControladorAsignaturasPorDocente.findAll()) {
			if(prueba(a)) {
				this.listModelAsignaturaNoSelecionada.addElement(a.getAsignatura());	

			}
		}
	}
	
	private boolean prueba(Asignaturaspordocente a) {
		for (int i = 0; i < this.listModelAsignaturaSelecionada.getSize(); i++) {
			Asignatura as =  this.listModelAsignaturaSelecionada.get(i);
			
			if(a.getAsignatura().getId() != as.getId()) {
				return true;
			}
		} 
		
		return false;
	}
	
	/**
	 * 
	 */
	private void todosIzquierda() {
		for (int i = 0; i < this.listModelAsignaturaSelecionada.size(); i++) {
		    this.listModelAsignaturaNoSelecionada.addElement(this.listModelAsignaturaSelecionada.getElementAt(i));
		}
		
	    this.listModelAsignaturaSelecionada.removeAllElements();
	}
	
	/**
	 * 
	 */
	private void selecionadoIzquierda() {
		this.listModelAsignaturaNoSelecionada.addElement(this.jlAsignaturaSelecionada.getSelectedValue());
		this.listModelAsignaturaSelecionada.removeElement(this.jlAsignaturaSelecionada.getSelectedValue());
	}
	
	/**
	 * 
	 */
	private void todosDerecha() {
		for (int i = 0; i < this.listModelAsignaturaNoSelecionada.size(); i++) {
		    this.listModelAsignaturaSelecionada.addElement(this.listModelAsignaturaNoSelecionada.getElementAt(i));
		}
		
	    this.listModelAsignaturaNoSelecionada.removeAllElements();
	}
	
	/**
	 * 
	 */
	private void selecionadoDerecha() {
		this.listModelAsignaturaSelecionada.addElement(this.jlAsignaturaNoSelecionada.getSelectedValue());
		this.listModelAsignaturaNoSelecionada.removeElement(this.jlAsignaturaNoSelecionada.getSelectedValue());
	}
	
	
	private void guardar() {
		Docente d = (Docente) jcbDocente.getSelectedItem();
		
		for (Asignaturaspordocente as : ControladorAsignaturasPorDocente.findByIdDocente(d.getId())) {
			ControladorAsignaturasPorDocente.eliminarEntidad(as);
		}
		
		for (int i = 0; i < this.listModelAsignaturaSelecionada.getSize(); i++) {
			Asignatura a = listModelAsignaturaSelecionada.getElementAt(i);
			
			Asignaturaspordocente as = new Asignaturaspordocente();
			as.setAsignatura(a);
			as.setDocente(d);
			ControladorAsignaturasPorDocente.creacionAsignaturaPorDocente(as);
		}
	}
}
