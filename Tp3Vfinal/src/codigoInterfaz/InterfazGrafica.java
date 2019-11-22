package codigoInterfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import codigoProduccion.EquipoTrabajo;
import codigoProduccion.FuerzaBruta;

public class InterfazGrafica extends JFrame {
	private JPanel contentPane;
	private InterfazTexto jText = new InterfazTexto();
	private InterfazBotones jButton = new InterfazBotones();
	private InterfazTextoRolesEmpleados jText2 = new InterfazTextoRolesEmpleados();
	private InterfazTextoaddEmpleados jText3 = new InterfazTextoaddEmpleados();
	private InterfazListaEmpleados jList = new InterfazListaEmpleados();
	private InterfazChoices jChoice = new InterfazChoices();
	private EquipoTrabajo listaEmpleados = new EquipoTrabajo();
	private FuerzaBruta fuerzaBruta = new FuerzaBruta();
	
	public InterfazGrafica() {
		setTitle("Software Factory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buffer();
	}
	public void buffer() {
		jText.buffer(contentPane);
		jText2.buffer(contentPane);
		jText3.buffer(contentPane);
		jButton.buffer(contentPane);
		jButton.accionesBotones(jText);
		jButton.añadirQuitarEmpleado(jText3, jChoice, listaEmpleados,jList);
		jButton.añadirQuitarIncompatibilidad(listaEmpleados, jChoice);
		jList.buffer(contentPane);
		jChoice.buffer(contentPane);
		jButton.accionFuerzaBruta(fuerzaBruta, listaEmpleados, jText,jList);
	}}