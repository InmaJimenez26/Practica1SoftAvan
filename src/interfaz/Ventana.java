package interfaz;

import javax.swing.JFrame;

public class Ventana {
	private static void createAndShowGUI ( ) {
		JFrame ventana = new JFrame("PETICIÓN");
		
		VistaElementos elementos = new VistaElementos(); //crear objetos de las otras dos clases
		Eventos evento = new Eventos(elementos);
		
		elementos.getConsultar().addActionListener(evento); //añadir actionListener
		
		ventana.getContentPane().add(elementos); //añadir los elementos a la ventana
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.pack(); //coge el tamaño necesario
		ventana.setVisible(true);//para que se vea
	}
	
	public static void main(String[] args) {
		//método que se ejecuta
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		}) ; 
	}
}
