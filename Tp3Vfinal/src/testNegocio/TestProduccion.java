package testNegocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import codigoInterfaz.InterfazListaEmpleados;
import codigoInterfaz.InterfazTexto;
import codigoProduccion.Empleado;
import codigoProduccion.EquipoTrabajo;
import codigoProduccion.FuerzaBruta;

class TestProduccion {
	InterfazTexto jText;
	InterfazListaEmpleados jList;
	FuerzaBruta fuerzaBruta;

	/*
	 * TODO: Se testea que nos devuelva el equipo optimo resuelto por fuerza bruta.
	 * 
	 * 
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEquipoOptimo() {

		EquipoTrabajo Desarrolladores = new EquipoTrabajo();

		Empleado AntonioToranzo = new Empleado("Programador", "42054625", " Antonio", "Sirollini");
		Empleado RodrigoCabrera = new Empleado("Tester", "39170901", " Rodrigo", "Cabrera");
		Empleado FranciscoRodriguez = new Empleado("Tester", "39170901", "Francisco", "Rodriguez");
		Empleado MatiasAnchorena = new Empleado("Programador", "42054625", "Matias", "Anchorena");
		Empleado AdrianNario = new Empleado("Arquitecto", "43445667", "Adrian", "Nario");
		Empleado ErnestoMaldini = new Empleado("Arquitecto", "43445667", "Ernesto", "Maldini");
		Empleado EzequielGimenez = new Empleado("Lider", "12333456", "Ezequiel", "Gimenez");

		ArrayList<Empleado> lideres = new ArrayList<Empleado>();
		ArrayList<Empleado> arquitectos = new ArrayList<Empleado>();
		ArrayList<Empleado> programadores = new ArrayList<Empleado>();
		ArrayList<Empleado> testers = new ArrayList<Empleado>();

		programadores.add(AntonioToranzo);
		programadores.add(MatiasAnchorena);

		testers.add(RodrigoCabrera);
		testers.add(FranciscoRodriguez);

		arquitectos.add(AdrianNario);
		arquitectos.add(ErnestoMaldini);

		lideres.add(EzequielGimenez);

		EquipoTrabajo DesarrolladoresOptimos = new EquipoTrabajo();

		Empleado AntonioToranzoOp = new Empleado("Programador", "42054625", " Antonio", "Sirollini");
		Empleado RodrigoCabreraOp = new Empleado("Tester", "39170901", " Rodrigo", "Cabrera");
		Empleado FranciscoRodriguezOp = new Empleado("Tester", "39170901", "Francisco", "Rodriguez");
		Empleado MatiasAnchorenaOp = new Empleado("Programador", "42054625", "Matias", "Anchorena");
		Empleado EzequielGimenezOp = new Empleado("Lider", "12333456", "Ezequiel", "Gimenez");
		Empleado ErnestoMaldiniOp = new Empleado("Arquitecto", "43445667", "Ernesto", "Maldini");

		ArrayList<Empleado> lideresOp = new ArrayList<Empleado>();
		ArrayList<Empleado> arquitectosOp = new ArrayList<Empleado>();
		ArrayList<Empleado> programadoresOp = new ArrayList<Empleado>();
		ArrayList<Empleado> testersOp = new ArrayList<Empleado>();

		programadoresOp.add(AntonioToranzo);
		programadoresOp.add(MatiasAnchorena);

		testersOp.add(RodrigoCabrera);
		testersOp.add(FranciscoRodriguez);

		lideresOp.add(EzequielGimenez);

		arquitectosOp.add(ErnestoMaldiniOp);

		DesarrolladoresOptimos.nuevoEmpleado(AntonioToranzoOp.getRol(), AntonioToranzoOp.getDni(),
				AntonioToranzoOp.getNombre(), AntonioToranzoOp.getApellido());
		DesarrolladoresOptimos.nuevoEmpleado(RodrigoCabreraOp.getRol(), RodrigoCabreraOp.getDni(),
				RodrigoCabreraOp.getNombre(), RodrigoCabreraOp.getApellido());
		DesarrolladoresOptimos.nuevoEmpleado(FranciscoRodriguezOp.getRol(), FranciscoRodriguezOp.getDni(),
				FranciscoRodriguezOp.getNombre(), FranciscoRodriguezOp.getApellido());
		DesarrolladoresOptimos.nuevoEmpleado(MatiasAnchorenaOp.getRol(), MatiasAnchorenaOp.getDni(),
				MatiasAnchorenaOp.getNombre(), MatiasAnchorenaOp.getApellido());
		DesarrolladoresOptimos.nuevoEmpleado(EzequielGimenezOp.getRol(), EzequielGimenezOp.getDni(),
				EzequielGimenezOp.getNombre(), EzequielGimenezOp.getApellido());

		Desarrolladores.nuevoEmpleado(AntonioToranzo.getRol(), AntonioToranzo.getDni(), AntonioToranzo.getNombre(),
				AntonioToranzo.getApellido());
		Desarrolladores.nuevoEmpleado(RodrigoCabrera.getRol(), RodrigoCabrera.getDni(), RodrigoCabrera.getNombre(),
				RodrigoCabrera.getApellido());
		Desarrolladores.nuevoEmpleado(FranciscoRodriguez.getRol(), FranciscoRodriguez.getDni(),
				FranciscoRodriguez.getNombre(), FranciscoRodriguez.getApellido());
		Desarrolladores.nuevoEmpleado(MatiasAnchorena.getRol(), MatiasAnchorena.getDni(), MatiasAnchorenaOp.getNombre(),
				MatiasAnchorena.getApellido());
		Desarrolladores.nuevoEmpleado(EzequielGimenez.getRol(), EzequielGimenez.getDni(), EzequielGimenez.getNombre(),
				EzequielGimenez.getApellido());

		HashMap<Empleado, ArrayList<Empleado>> equipoTrabajo = new HashMap<Empleado, ArrayList<Empleado>>();
		HashMap<Empleado, ArrayList<Empleado>> equipoTrabajoOp = new HashMap<Empleado, ArrayList<Empleado>>();

		// Limpio la lista para asegurarme que no tengo nada
		equipoTrabajo.clear();
		equipoTrabajoOp.clear();

		// Agrego la estructura de de HashMap a mis Desarrolladores y
		// DesarrolladoresOptimos
		Desarrolladores.setEquipoTrabajo(equipoTrabajo);
		DesarrolladoresOptimos.setEquipoTrabajo(equipoTrabajo);

		equipoTrabajo.put(AntonioToranzo, programadores);
		equipoTrabajo.put(RodrigoCabrera, testers);
		equipoTrabajo.put(FranciscoRodriguez, testers);
		equipoTrabajo.put(MatiasAnchorena, programadores);
		equipoTrabajo.put(AdrianNario, arquitectos);
		equipoTrabajo.put(ErnestoMaldini, arquitectos);
		equipoTrabajo.put(EzequielGimenez, lideres);

		equipoTrabajoOp.put(AntonioToranzoOp, programadoresOp);
		equipoTrabajoOp.put(RodrigoCabreraOp, testersOp);
		equipoTrabajoOp.put(FranciscoRodriguezOp, testersOp);
		equipoTrabajoOp.put(MatiasAnchorenaOp, programadoresOp);
		equipoTrabajoOp.put(ErnestoMaldiniOp, arquitectosOp);
		equipoTrabajoOp.put(EzequielGimenezOp, lideresOp);

		// Agrego incompatibilidad entre empleados para cuando arme el equipo me quite
		// incompatibilidades

		Desarrolladores.crearGrupoTrabajo(lideres.size(), arquitectos.size(), programadores.size(), testers.size());

		assertFalse(Desarrolladores.getEquipoTrabajo() == DesarrolladoresOptimos.getEquipoTrabajo());

	}

	@Test
	void EmpleadosIgualesTest() {
		// Setup
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();
		Empleado Facundo = new Empleado("Programador", "42054625", " Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado("Tester", "39170901", " Rodrigo", "Cabrera");
		Empleado Francisco = new Empleado("Tester", "39170901", " Rodrigo", "Cabrera");
		Empleado Matias = new Empleado("Programador", "42054625", "Facundo", "Cardenas");
		// Excercice
		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni(), Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni(), Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.nuevoEmpleado(Francisco.getRol(), Francisco.getDni(), Francisco.getNombre(),
				Francisco.getApellido());
		Desarrolladores.nuevoEmpleado(Matias.getRol(), Matias.getDni(), Matias.getNombre(), Matias.getApellido());

		// Verify
		assertTrue(true == Rodrigo.equals(Francisco));
		assertTrue(true == Matias.equals(Facundo));
	}

	@Test
	void EmpleadosDistintosTest() {
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();
		Empleado Facundo = new Empleado("Programador", "42054625", " Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado("Programador", "39170901", " Rodrigo", "Cabrera");
		Empleado Francisco = new Empleado("Tester", "14309704", " Francisco", "Santillan");
		Empleado Matias = new Empleado("Tester", "20477665", " Matias", "Rodriguez");

		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni(), Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni(), Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.nuevoEmpleado(Francisco.getRol(), Francisco.getDni(), Francisco.getNombre(),
				Francisco.getApellido());
		Desarrolladores.nuevoEmpleado(Matias.getRol(), Matias.getDni(), Matias.getNombre(), Matias.getApellido());

		assertFalse(true == Rodrigo.equals(Facundo));
		assertFalse(true == Matias.equals(Francisco));
	}

	@Test
	void AgregarEmpleadoTest() {
		EquipoTrabajo Developers = new EquipoTrabajo();
		Empleado Matias = new Empleado("Tester", "42054625", "Matias", "Guzman");
		Developers.nuevoEmpleado(Matias.getRol(), Matias.getDni(), Matias.getNombre(), Matias.getApellido());
		boolean acum = Developers.perteneceEmpleado(Matias.getDni());
		assertEquals(true, acum);
	}

	void QuitarEmpleadoTest() {
		EquipoTrabajo Developers = new EquipoTrabajo();
		Empleado Matias = new Empleado("Tester", "42054625", "Matias", "Guzman");
		Developers.nuevoEmpleado(Matias.getRol(), Matias.getDni(), Matias.getNombre(), Matias.getApellido());
		Developers.quitarEmpleado(Matias.getDni());

		assertFalse(Developers.perteneceEmpleado(Matias.getDni()));
	}

	@Test
	void esCompatibleTest() {
		HashMap<Empleado, ArrayList<Empleado>> equip = new HashMap<Empleado, ArrayList<Empleado>>();
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();
		Empleado Facundo = new Empleado("Programador", "42054625", " Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado("Programador", "39170901", " Rodrigo", "Cabrera");
		Empleado Francisco = new Empleado("Tester", "14309704", " Francisco", "Santillan");
		Empleado Matias = new Empleado("Tester", "20477665", " Matias", "Rodriguez");

		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni(), Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni(), Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.nuevoEmpleado(Francisco.getRol(), Francisco.getDni(), Francisco.getNombre(),
				Francisco.getApellido());
		Desarrolladores.nuevoEmpleado(Matias.getRol(), Matias.getDni(), Matias.getNombre(), Matias.getApellido());
		// boolean ret = Desarrolladores.esCompatibleConGrupoTrabajo(equip, Facundo);
		assertTrue(Desarrolladores.esCompatibleConGrupoTrabajo(equip, Facundo));
	}

	@Test
	void cantidadEmpleadosTest() {
		EquipoTrabajo Desarrolladores1 = new EquipoTrabajo();
		Empleado Facundo = new Empleado("Lider", "42054625", " Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado("Arquitecto", "39170901", " Rodrigo", "Cabrera");
		Desarrolladores1.nuevoEmpleado(Facundo.getRol(), Facundo.getDni(), Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores1.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni(), Rodrigo.getNombre(), Rodrigo.getApellido());
		assertEquals(2, Desarrolladores1.getEmpleados().size());
	}

	@Test
	void quitarEmpleadoListTest() {
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();
		Empleado Facundo = new Empleado("Lider", "42054625", " Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado("Arquitecto", "39170901", " Rodrigo", "Cabrera");
		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni(), Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni(), Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.quitarEmpleadoList(Facundo.getDni());
		boolean ret = Desarrolladores.perteneceEmpleado(Facundo.getDni());
		assertTrue(false == ret);
	}
}