package interfaz;



import javax.swing.JFrame;

public class Ventana {
	private static void createAndShowGUI ( ) {
		JFrame ventana = new JFrame("PETICIÓN");
		
		VistaElementos elementos = new VistaElementos();
		Eventos evento = new Eventos(elementos);
		
		elementos.getConsultar().addActionListener(evento);
		
		ventana.getContentPane().add(elementos);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack(); //coge el tamaño necesario
		ventana.setVisible(true);//para que se vea
		//ventana.setExtendedState(true);
	}
	
	
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread: //creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		}) ; 
	}
}
