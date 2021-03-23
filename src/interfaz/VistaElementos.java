package interfaz;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaElementos extends JPanel{
	private static final long serialVersionUID = 1L;
	//delcaraciones de los elementos que voy a utilizar en varios metodos
	private JComboBox<String> secuenciaConsulta;
	private JTextField porcentaje;
	private JRadioButton proteina;
	private JComboBox<String> baseDatos;
	private JComboBox<String> identificadores;
	private JRadioButton nucleotido;
	private JTextArea result;
	private JButton botonConsulta;
	
	public VistaElementos() {
		//paneles que voy a utilizar
		JPanel PrimerPanel = new JPanel();
		PrimerPanel.setLayout(new GridLayout(3,1));
		JPanel SegundoPanel = new JPanel();
		SegundoPanel.setLayout(new GridLayout(2,1));
		JPanel TercerPanel = new JPanel();
		TercerPanel.setLayout(new GridLayout(2,1));
		JPanel CuartoPanel = new JPanel();
		CuartoPanel.setLayout(new GridLayout(1,1));
		JPanel QuintoPanel = new JPanel();
		QuintoPanel.setLayout(new GridLayout(2,2));
	
		//Primer panel con los radiobuttons
		JLabel titulo = new JLabel("Tipo de petición:"); 
		
		String prot = new String("Proteína");
		String nuc = new String("Nucleótido");
		proteina = new JRadioButton(prot);
		proteina.setSelected(true);
		nucleotido = new JRadioButton(nuc);
		nucleotido.setSelected(false);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(nucleotido);
		grupo.add(proteina);
	
		PrimerPanel.add(titulo);
		PrimerPanel.add(nucleotido);
		PrimerPanel.add(proteina);
		
		//Segundo panel con el combobox
		JLabel titulo2 = new JLabel("Introduce la secuencia para consultar:");
		
		secuenciaConsulta = new JComboBox<String>();
		secuenciaConsulta.setEditable(true);
		
		SegundoPanel.add(titulo2);
		SegundoPanel.add(secuenciaConsulta);
		
		//Tercer panel con el porcentaje
		JLabel titulo3 = new JLabel("Porcentaje (0.0-1.0):");
		porcentaje = new JTextField();
		
		TercerPanel.add(titulo3);
		TercerPanel.add(porcentaje);
	
		//cuarto panel con el boton consulta
		botonConsulta = new JButton("Hacer consulta");
		botonConsulta.setOpaque(true);
		CuartoPanel.add(botonConsulta);
		
		//Quinto panel con la base de datos
		JLabel titulo4 = new JLabel("Elija la base de datos:");
		baseDatos = new JComboBox<String>();
		baseDatos.addItem("resources/yeast.aa");
		
		JLabel titulo5 = new JLabel("Elija los identificadores:");
		identificadores = new JComboBox<String>();
		identificadores.addItem("resources/yeast.aa.indexs");
		
		QuintoPanel.add(titulo4);
		QuintoPanel.add(baseDatos);
		QuintoPanel.add(titulo5);
		QuintoPanel.add(identificadores);
		
		//Text area del resultado con scrollpane
		result = new JTextArea(40,60);
		result.setEditable(true);
		JScrollPane scroll = new JScrollPane(result);
				
		//añadir los paneles
		this.add(PrimerPanel);
		this.add(SegundoPanel);
		this.add(TercerPanel);
		this.add(QuintoPanel);
		this.add(CuartoPanel);
		this.add(scroll);
	}
	public JComboBox<String> getSecuencia() {
		return secuenciaConsulta;
	}
	public JTextField getPorcentaje() {
		return porcentaje;
	}
	public JRadioButton getProteina() {
		return proteina;
	}
	public JComboBox<String> getBaseDatos() {
		return baseDatos;
	}
	public JComboBox<String> getIdentificadores() {
		return identificadores;
	}
	public JRadioButton getNucleotido() {
		return nucleotido;
	}
	public JTextArea getResultado() {
		return result;
	}
	public JButton getConsultar() {
		return botonConsulta;
	}

	
}
