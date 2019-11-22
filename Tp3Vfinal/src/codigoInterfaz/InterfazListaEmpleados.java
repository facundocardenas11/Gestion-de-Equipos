package codigoInterfaz;

import java.awt.List;
import javax.swing.JPanel;
import codigoProduccion.Empleado;
import codigoProduccion.EquipoTrabajo;

public class InterfazListaEmpleados {	
		private List list = new List();
		private List list_1 = new List();
		private List list_2 = new List();
      	private List list_3 = new List();
		
	InterfazListaEmpleados(){
		list.setBounds(10, 194, 161, 457);
		list_1.setBounds(177, 194, 161, 457);
		list_2.setBounds(344, 194, 161, 457);
		list_3.setBounds(511, 194, 161, 457);
	}
	void buffer(JPanel contentPane) {
		contentPane.add(list);
		contentPane.add(list_1);
		contentPane.add(list_2);
		contentPane.add(list_3);
	}
	void actualizarListas(EquipoTrabajo equipo) {
		list.removeAll();
		for (Empleado iterable_element : equipo.getLideres()) {
			list.add(iterable_element.toString());
		}
		list_1.removeAll();
		for (Empleado iterable_element : equipo.getArquitectos()) {
			list_1.add(iterable_element.toString());
		}
		list_2.removeAll();
		for (Empleado iterable_element : equipo.getProgramadores()) {
			list_2.add(iterable_element.toString());
		}
		list_3.removeAll();
		for (Empleado iterable_element : equipo.getTesters()) {
			list_3.add(iterable_element.toString());
		}
	}
}
