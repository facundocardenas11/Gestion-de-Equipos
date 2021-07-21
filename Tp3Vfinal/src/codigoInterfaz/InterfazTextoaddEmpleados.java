package codigoInterfaz;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JPanel;

public class InterfazTextoaddEmpleados {
	private Label label = new Label("A\u00F1adir Empleado");
	private Label label_1 = new Label("DNI");
	private Label label_2 = new Label("Nombre");
	private Label label_3 = new Label("Apellido");
	private Label label_5 = new Label("Quitar Incompatibilidad");
	private Label label_6 = new Label("Quitar Empleado");
	private Label label_4 = new Label("A\u00F1adir Incompatibilidad");
	private TextField tDNI = new TextField();
	private TextField tNombre = new TextField();
	private TextField tApellido = new TextField();

	InterfazTextoaddEmpleados() {
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(707, 166, 151, 22);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(707, 194, 85, 22);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(798, 194, 85, 22);
		label_3.setBackground(Color.LIGHT_GRAY);
		label_3.setBounds(889, 194, 85, 22);
		label_5.setBackground(Color.LIGHT_GRAY);
		label_5.setAlignment(Label.CENTER);
		label_5.setBounds(707, 549, 267, 22);
		label_6.setBackground(Color.LIGHT_GRAY);
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(707, 300, 267, 22);
		label_4.setAlignment(Label.CENTER);
		label_4.setBackground(Color.LIGHT_GRAY);
		label_4.setBounds(707, 419, 267, 22);
		tDNI.setBounds(707, 222, 85, 22);
		tNombre.setBounds(798, 222, 85, 22);
		tApellido.setBounds(889, 222, 85, 22);
	}

	void buffer(JPanel contentPane) {
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(label_5);
		contentPane.add(label_6);
		contentPane.add(label_4);
		contentPane.add(tDNI);
		contentPane.add(tNombre);
		contentPane.add(tApellido);
	}

	public String getDNI() {
		return tDNI.getText();
	}

	public String getNombre() {
		return tNombre.getText();
	}

	public String getApellido() {
		return tApellido.getText();
	}

	public void actualizar() {
		tDNI.setText("");
		tNombre.setText("");
		tApellido.setText("");
	}
}