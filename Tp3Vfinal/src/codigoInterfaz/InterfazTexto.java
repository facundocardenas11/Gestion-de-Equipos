package codigoInterfaz;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JPanel;

public class InterfazTexto {
	private Label label = new Label("Rol");
	private Label label_1 = new Label("Líderes de Proyecto");
	private Label label_2 = new Label("Arquitectos");
	private Label label_3 = new Label("Programadores");
	private Label label_4 = new Label("Testers");
	private Label label_5 = new Label("Cant. Minima");
	private Label label_6 = new Label("Cant. Maxima");
	private int t1 = 1;
	private int t2 = 1;
	private int t3 = 1;
	private int t4 = 1;
	private TextField textField = new TextField("1");
	private TextField textField_1 = new TextField(t1 + "");
	private TextField textField_2 = new TextField("1");
	private TextField textField_3 = new TextField(t2 + "");
	private TextField textField_4 = new TextField("1");
	private TextField textField_5 = new TextField(t3 + "");
	private TextField textField_6 = new TextField("1");
	private TextField textField_7 = new TextField(t4 + "");

	InterfazTexto() {
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(10, 10, 135, 22);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(10, 50, 135, 22);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(10, 78, 135, 22);
		label_3.setBackground(Color.LIGHT_GRAY);
		label_3.setBounds(10, 106, 135, 22);
		label_4.setBackground(Color.LIGHT_GRAY);
		label_4.setBounds(10, 134, 135, 22);
		label_5.setBackground(Color.LIGHT_GRAY);
		label_5.setAlignment(Label.CENTER);
		label_5.setBounds(151, 10, 80, 22);
		label_6.setBackground(Color.LIGHT_GRAY);
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(237, 10, 80, 22);
		textField.setBounds(151, 50, 22, 22);
		textField_1.setBounds(237, 50, 80, 22);
		textField_2.setBounds(151, 78, 22, 22);
		textField_3.setBounds(237, 78, 80, 22);
		textField_4.setBounds(151, 106, 22, 22);
		textField_5.setBounds(237, 106, 80, 22);
		textField_6.setBounds(151, 134, 22, 22);
		textField_7.setBounds(237, 134, 80, 22);
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField_6.setEditable(false);
		textField_7.setEditable(false);
	}

	public void buffer(JPanel contentPane) {
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(label_5);
		contentPane.add(label_6);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		contentPane.add(textField_5);
		contentPane.add(textField_6);
		contentPane.add(textField_7);
	}

	public TextField getText(int a) {
		if (a == 1) {
			return textField_1;
		}
		if (a == 2) {
			return textField_3;
		}
		if (a == 3) {
			return textField_5;
		} else {
			return textField_7;
		}
	}

	public void setValue(int a, int b) {
		if (a == 1) {
			t1 = b;
			textField_1.setText(t1 + "");
		}
		if (a == 2) {
			t2 = b;
			textField_3.setText(t2 + "");
		}
		if (a == 3) {
			t3 = b;
			textField_5.setText(t3 + "");
		}
		if (a == 4) {
			t4 = b;
			textField_7.setText(t4 + "");
		}
	}

	public int getValue(int a) {
		if (a == 1) {
			return t1;
		}
		if (a == 2) {
			return t2;
		}
		if (a == 3) {
			return t3;
		} else {
			return t4;
		}
	}
}
