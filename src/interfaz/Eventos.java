package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import blast.BlastController;

public class Eventos implements ActionListener{
	private VistaElementos elementos;
	
	public Eventos(VistaElementos elem) {
		this.elementos = elem;
	}
	
	public void actionPerformed(ActionEvent e) {
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
		if (correcto & secuencia.equals("")) {
			mostrarError("No ha introducido la secuencia a buscar");
			correcto = false;
		}
		else if (!yaBuscada(secuencia)) {
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
		//resultado
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
			mostrarError("Aún no podemos buscar nucleótidos");
		}
		
		elementos.getResultado().setText(resultado);
		
		
	}

	private boolean yaBuscada(String secuencia) {
		boolean result = false;
		for (int i = 0; i < elementos.getSecuencia().getItemCount(); i++) {
			if(elementos.getSecuencia().getItemAt(i).equals(secuencia)) {
				result = true;
			}
		}
		return result;
	}

	private void mostrarError(String error) {
		JFrame mensaje = new JFrame();
		JLabel contenido = new JLabel(error);
		mensaje.add(contenido);
		mensaje.pack();
		mensaje.setVisible(true);
		
	}
}
