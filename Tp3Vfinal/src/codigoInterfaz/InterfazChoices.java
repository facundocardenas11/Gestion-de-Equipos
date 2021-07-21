package codigoInterfaz;

import java.awt.Choice;
import javax.swing.JPanel;
import codigoProduccion.Empleado;
import codigoProduccion.EquipoTrabajo;

public class InterfazChoices {

	private Choice choice_addIncompatibilidad1 = new Choice();
	private Choice choice_addIncompatibilidad2 = new Choice();
	private Choice choice_quitarIncompatibilidad1 = new Choice();
	private Choice choice_quitarIncompatibilidad2 = new Choice();
	private Choice choice_quitarEmpleado = new Choice();
	private Choice choice_Rol = new Choice();

	InterfazChoices() {
		choice_addIncompatibilidad1.setBounds(707, 447, 267, 20);
		choice_addIncompatibilidad2.setBounds(707, 473, 267, 20);
		choice_quitarIncompatibilidad2.setBounds(707, 603, 267, 20);
		choice_quitarIncompatibilidad1.setBounds(707, 577, 267, 20);
		choice_quitarEmpleado.setBounds(707, 328, 267, 20);
		choice_Rol.setBounds(864, 166, 110, 22);
	}

	void buffer(JPanel contentPane) {
		bufferChoiceRol();
		contentPane.add(choice_addIncompatibilidad2);
		contentPane.add(choice_addIncompatibilidad1);
		contentPane.add(choice_quitarIncompatibilidad2);
		contentPane.add(choice_quitarIncompatibilidad1);
		contentPane.add(choice_quitarEmpleado);
		contentPane.add(choice_Rol);
	}

	void bufferChoiceRol() {
		choice_Rol.add("Líder de Proyecto");
		choice_Rol.add("Arquitecto");
		choice_Rol.add("Programador");
		choice_Rol.add("Tester");
	}

	public String getRol() {
		return choice_Rol.getSelectedItem();
	}

	void actualizarListas(EquipoTrabajo equipo) {
		choice_quitarEmpleado.removeAll();
		for (Empleado iterable_element : equipo.getEmpleados()) {
			choice_quitarEmpleado.add(iterable_element.getDni());
		}
		choice_addIncompatibilidad1.removeAll();
		for (Empleado iterable_element : equipo.getEmpleados()) {
			choice_addIncompatibilidad1.add(iterable_element.getDni());
		}
		choice_addIncompatibilidad2.removeAll();
		for (Empleado iterable_element : equipo.getEmpleados()) {
			choice_addIncompatibilidad2.add(iterable_element.getDni());
		}
		choice_quitarIncompatibilidad1.removeAll();
		for (Empleado iterable_element : equipo.getEmpleados()) {
			choice_quitarIncompatibilidad1.add(iterable_element.getDni());
		}
		choice_quitarIncompatibilidad2.removeAll();
		for (Empleado iterable_element : equipo.getEmpleados()) {
			choice_quitarIncompatibilidad2.add(iterable_element.getDni());
		}
	}

	public Choice getQuitarEmpleado() {
		return choice_quitarEmpleado;

	}

	public String getEmpleado1() {
		return choice_addIncompatibilidad1.getSelectedItem();
	}

	public String getEmpleado2() {
		return choice_addIncompatibilidad2.getSelectedItem();
	}

}
