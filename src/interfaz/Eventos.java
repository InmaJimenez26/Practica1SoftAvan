package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import blast.BlastController;

public class Eventos implements ActionListener{
	private VistaElementos elementos;
	
	public Eventos(VistaElementos elem) {
		this.elementos = elem;
	}
	
	public void actionPerformed(ActionEvent e) {
	//	elementos.reiniciarVentana();
		boolean correcto = true;
		//secuencia
		String secuencia = "";
		try {
			secuencia = elementos.getSecuencia().getSelectedItem().toString().toUpperCase();
		}
		catch (NullPointerException n){
			mostrarError("Especifique la secuencia a buscar");
			correcto = false;
		}
		if (correcto &secuencia.equals("")) {
			mostrarError("No ha introducido la secuencia a buscar");
			correcto = false;
		}
		else if (!buscar(secuencia)) {
			elementos.getSecuencia().addItem(secuencia);
		}
		//porcentaje
		String porc = null;
		float porcentaje = -1;
		try {
			porc = elementos.getPorcentaje().getText();
			porcentaje = Float.parseFloat(porc);
		}
		catch (NumberFormatException n) {
			if(porc.equals("")) {
				mostrarError("Especifique el porcentaje");
			}
			else {
				mostrarError("Formato inadecuado");
			}
			correcto = false;
		}
		if (porcentaje != -1 & (porcentaje < 0 || porcentaje > 1)) {
			mostrarError("Porcentaje fuera de rango");
			correcto = false;
		}
		//
		BlastController cnt = new BlastController();
		String resultado = "";
		if (elementos.getProteina().isSelected() & correcto) {
			try {
				resultado = cnt.blastQuery('p', elementos.getBaseDatos().getSelectedItem().toString(),
						elementos.getIdentificadores().getSelectedItem().toString(), porcentaje, secuencia);
			}
			catch(Exception excep) {
				mostrarError("Error en la búsqueda"+excep.toString());	
			}
		}
		else if(elementos.getNucleotido().isSelected()) {
			resultado = "Aún no podemos buscar nucleótidos";
		}
		elementos.getResultado().setText(resultado);
	}

	private boolean buscar(String secuencia) {
		boolean res = false;
		for (int i=0; i<elementos.getSecuencia().getItemCount(); i++) {
			if(elementos.getSecuencia().getItemAt(i).equals(secuencia)) {
				res = true;
			}
		}
		return res;
	}

	private void mostrarError(String string) {
		JDialog d = new JDialog();
		d.add(new JLabel(string));
		d.setSize(250,100);
		d.setVisible(true);
		
	}
}
