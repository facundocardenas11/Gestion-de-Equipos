package codigoInterfaz;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JPanel;

public class InterfazTextoRolesEmpleados {
	private Label label = new Label("Líderes de Proyecto");
	private Label label_1 = new Label("Arquitectos");
	private Label label_2 = new Label("Programadores");
	private Label label_3 = new Label("Testers");
	
	InterfazTextoRolesEmpleados(){
		label.setBounds(10, 166, 161, 22);
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(177, 166, 161, 22);
		label_1.setAlignment(Label.CENTER);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(344, 166, 161, 22);
		label_2.setAlignment(Label.CENTER);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_3.setBounds(511, 166, 161, 22);
		label_3.setAlignment(Label.CENTER);
		label_3.setBackground(Color.LIGHT_GRAY);
	}
	void buffer(JPanel contentPane) {
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
	}	
}