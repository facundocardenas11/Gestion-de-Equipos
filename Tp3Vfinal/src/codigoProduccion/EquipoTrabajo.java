package codigoProduccion;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

public class EquipoTrabajo implements Cloneable {

	private HashMap<Empleado, ArrayList<Empleado>> equipoTrabajo = new HashMap<Empleado, ArrayList<Empleado>>();
	private ArrayList<Empleado> lideres = new ArrayList<Empleado>();
	private ArrayList<Empleado> arquitectos = new ArrayList<Empleado>();
	private ArrayList<Empleado> programadores = new ArrayList<Empleado>();
	private ArrayList<Empleado> testers = new ArrayList<Empleado>();

	public EquipoTrabajo() {

	}

	public EquipoTrabajo(HashMap<Empleado, ArrayList<Empleado>> equipoTrabajo, ArrayList<Empleado> lideres,
			ArrayList<Empleado> arquitectos, ArrayList<Empleado> programadores, ArrayList<Empleado> testers) {
		super();
		this.equipoTrabajo = equipoTrabajo;
		this.lideres = lideres;
		this.arquitectos = arquitectos;
		this.programadores = programadores;
		this.testers = testers;
	}

	public void crearGrupoTrabajo(int cantLideres, int cantArquitectos, int cantProgramadores, int cantTesters) {
		ordenarEmpleados();
		int aux = Math.max(lideres.size(), arquitectos.size());
		aux = Math.max(aux, programadores.size());
		aux = Math.max(aux, testers.size());

		HashMap<Empleado, ArrayList<Empleado>> equipAux = new HashMap<Empleado, ArrayList<Empleado>>();
		ArrayList<Empleado> lAux = new ArrayList<Empleado>(); // Lideres
		ArrayList<Empleado> aAux = new ArrayList<Empleado>(); // Arquitectos
		ArrayList<Empleado> pAux = new ArrayList<Empleado>(); // Programadores
		ArrayList<Empleado> tAux = new ArrayList<Empleado>(); // Testers

		for (int i = 0; i < aux; i++) {
			if (lAux.size() < cantLideres) {
				if (i < lideres.size()) {
					if (esCompatibleConGrupoTrabajo(equipAux, getLider(i))) {
						equipAux.put(getLider(i), equipoTrabajo.get(getLider(i)));
						lAux.add(lideres.get(i));
					}
				}
			}
			if (aAux.size() < cantArquitectos) {
				if (i < arquitectos.size()) {
					if (esCompatibleConGrupoTrabajo(equipAux, getArquitecto(i))) {
						equipAux.put(getArquitecto(i), equipoTrabajo.get(getArquitecto(i)));
						aAux.add(arquitectos.get(i));
					}
				}
			}
			if (pAux.size() < cantProgramadores) {
				if (i < programadores.size()) {
					if (esCompatibleConGrupoTrabajo(equipAux, getProgramador(i))) {
						equipAux.put(getProgramador(i), equipoTrabajo.get(getProgramador(i)));
						pAux.add(programadores.get(i));
					}
				}
			}
			if (tAux.size() < cantTesters) {
				if (i < testers.size()) {
					if (esCompatibleConGrupoTrabajo(equipAux, getTester(i))) {
						equipAux.put(getTester(i), equipoTrabajo.get(getTester(i)));
						tAux.add(testers.get(i));
					}
				}
			}
		}
		equipoTrabajo = equipAux;
		lideres = lAux;
		arquitectos = aAux;
		programadores = pAux;
		testers = tAux;
	}

	public Empleado getLider(int i) {
		Empleado aux = lideres.get(i);
		for (Empleado employe : equipoTrabajo.keySet()) {
			if (aux.getDni().equals(employe.getDni())) {
				aux = employe;
				return aux;
			}
		}
		return aux;
	}

	public Empleado getArquitecto(int i) {
		Empleado aux = arquitectos.get(i);
		for (Empleado employe : equipoTrabajo.keySet()) {
			if (aux.getDni().equals(employe.getDni())) {
				aux = employe;
				return aux;
			}
		}
		return aux;
	}

	public Empleado getProgramador(int i) {
		Empleado aux = programadores.get(i);
		for (Empleado employe : equipoTrabajo.keySet()) {
			if (aux.getDni().equals(employe.getDni())) {
				aux = employe;
				return aux;
			}
		}
		return aux;
	}

	public Empleado getTester(int i) {
		Empleado aux = testers.get(i);
		for (Empleado employe : equipoTrabajo.keySet()) {
			if (aux.getDni().equals(employe.getDni())) {
				aux = employe;
				return aux;
			}
		}
		return aux;
	}

	public void ordenarEmpleados() {
		ordenarEmpleados(lideres);
		ordenarEmpleados(arquitectos);
		ordenarEmpleados(programadores);
		ordenarEmpleados(testers);
	}

	public int getCantIncompatible(Empleado e) {
		if (equipoTrabajo.containsKey(e)) {
			if (equipoTrabajo.get(e) != null) {
				return equipoTrabajo.get(e).size();
			}
		}
		return 0;
	}

	public void ordenarEmpleados(ArrayList<Empleado> listEmpleados) {
		for (int i = 0; i < listEmpleados.size(); i++) {
			for (int j = i + 1; j < listEmpleados.size(); j++) {
				if (getCantIncompatible(listEmpleados.get(i)) > getCantIncompatible(listEmpleados.get(j))) {
					Empleado aux = listEmpleados.get(i);
					listEmpleados.set(i, listEmpleados.get(i));
					listEmpleados.set(j, aux);
				}
			}
		}
	}

	public void nuevoEmpleado(String rol, String dni, String nombre, String apellido) {
		equipoTrabajo.put(new Empleado(rol, dni, nombre, apellido), new ArrayList<Empleado>());
		if (rol == "Líder de Proyecto") {
			lideres.add(new Empleado(rol, dni, nombre, apellido));
		}
		if (rol == "Arquitecto") {
			arquitectos.add(new Empleado(rol, dni, nombre, apellido));
		}
		if (rol == "Programador") {
			programadores.add(new Empleado(rol, dni, nombre, apellido));
		}
		if (rol == "Tester") {
			testers.add(new Empleado(rol, dni, nombre, apellido));
		}
	}

	public void addIncompatibilidad(Empleado a, Empleado b) {
		equipoTrabajo.get(a).add(b);
		equipoTrabajo.get(b).add(a);
	}

	public void quitarIncompatibilidad(Empleado a, Empleado b) {
		equipoTrabajo.get(a).remove(b);
		equipoTrabajo.get(b).remove(a);
	}

	public boolean esCompatibleConGrupoTrabajo(HashMap<Empleado, ArrayList<Empleado>> equip, Empleado empleado) {
		boolean compatible = true;
		for (Empleado employe : equip.keySet()) {
			for (int i = 0; i < equip.get(employe).size(); i++) {
				if (empleado.compararDNI(equip.get(employe).get(i).getDni())) {
					compatible = compatible && false;
				} else {
					compatible = compatible && true;
				}
			}
		}
		return compatible;
	}

	public ArrayList<Empleado> getLideres() {
		return lideres;
	}

	public ArrayList<Empleado> getArquitectos() {
		return arquitectos;
	}

	public ArrayList<Empleado> getProgramadores() {
		return programadores;
	}

	public ArrayList<Empleado> getTesters() {
		return testers;
	}

	public Set<Empleado> getEmpleados() {
		return equipoTrabajo.keySet();
	}

	public void quitarEmpleado(String selectedItem) {
		equipoTrabajo.remove(getemploye(selectedItem), equipoTrabajo.get(getemploye(selectedItem)));
		quitarEmpleadoList(selectedItem);
	}

	public void quitarEmpleadoList(String selectedItem) {
		for (Empleado empleado : lideres) {
			if (empleado.getDni().equals(selectedItem)) {
				lideres.remove(empleado);
				break;
			}
		}
		for (Empleado empleado : arquitectos) {
			if (empleado.getDni().equals(selectedItem)) {
				arquitectos.remove(empleado);
				break;
			}
		}
		for (Empleado empleado : programadores) {
			if (empleado.getDni().equals(selectedItem)) {
				programadores.remove(empleado);
				break;
			}
		}
		for (Empleado empleado : testers) {
			if (empleado.getDni().equals(selectedItem)) {
				testers.remove(empleado);
				break;
			}
		}
	}

	public Empleado getemploye(String dni) {
		Empleado empleadox = new Empleado();
		for (Empleado empleado : equipoTrabajo.keySet()) {
			if (empleado.getDni() == dni) {
				empleadox = empleado;
			}
		}
		return empleadox;
	}

	public boolean perteneceEmpleado(String a) {
		for (Empleado empleado : lideres) {
			if (empleado.compararDNI(a)) {
				return true;
			}
		}
		for (Empleado empleado : arquitectos) {
			if (empleado.compararDNI(a)) {
				return true;
			}
		}
		for (Empleado empleado : programadores) {
			if (empleado.compararDNI(a)) {
				return true;
			}
		}
		for (Empleado empleado : testers) {
			if (empleado.compararDNI(a)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "EquipoTrabajo [equipoTrabajo=" + equipoTrabajo + "]";
	}

	@Override
	protected EquipoTrabajo clone() {
		EquipoTrabajo clone = new EquipoTrabajo();
		try {
			clone = (EquipoTrabajo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	public HashMap<Empleado, ArrayList<Empleado>> getEquipoTrabajo() {
		return equipoTrabajo;
	}

	public void setEquipoTrabajo(HashMap<Empleado, ArrayList<Empleado>> equipoTrabajo) {
		this.equipoTrabajo = equipoTrabajo;
	}

	public void setLideres(ArrayList<Empleado> lideres) {
		this.lideres = lideres;
	}

	public void setArquitectos(ArrayList<Empleado> arquitectos) {
		this.arquitectos = arquitectos;
	}

	public void setProgramadores(ArrayList<Empleado> programadores) {
		this.programadores = programadores;
	}

	public void setTesters(ArrayList<Empleado> testers) {
		this.testers = testers;
	}
}