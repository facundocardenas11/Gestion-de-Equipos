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
	
	@Test
	void EmpleadosIgualesTest()
	{
		//Setup
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();	
		Empleado Facundo = new Empleado ("Programador", "42054625" ," Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado ("Tester", "39170901" ," Rodrigo", "Cabrera");
		Empleado Francisco = new Empleado("Tester", "39170901" ," Rodrigo", "Cabrera");
		Empleado Matias = new Empleado("Programador", "42054625" ,"Facundo","Cardenas");
	    //Excercice 
		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni() , Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni() ,Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.nuevoEmpleado(Francisco.getRol(), Francisco.getDni() , Francisco.getNombre(), Francisco.getApellido());
		Desarrolladores.nuevoEmpleado(Matias.getRol(), Matias.getDni() ,Matias.getNombre(), Matias.getApellido());
			
	    //Verify		
		assertTrue(true==Rodrigo.equals(Francisco));
		assertTrue(true==Matias.equals(Facundo));	
		}
	@Test
	void EmpleadosDistintosTest()
		{
	 	EquipoTrabajo Desarrolladores = new EquipoTrabajo();			
	   	Empleado Facundo = new Empleado ("Programador", "42054625" ," Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado ("Programador", "39170901" ," Rodrigo", "Cabrera");
		Empleado Francisco = new Empleado("Tester", "14309704" ," Francisco", "Santillan");
		Empleado Matias = new Empleado("Tester", "20477665" ," Matias", "Rodriguez");
			
		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni() , Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni() ,Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.nuevoEmpleado(Francisco.getRol(), Francisco.getDni() , Francisco.getNombre(), Francisco.getApellido());
		Desarrolladores.nuevoEmpleado(Matias.getRol(), Matias.getDni() ,Matias.getNombre(), Matias.getApellido());
							
		assertFalse(true==Rodrigo.equals(Facundo));
		assertFalse(true==Matias.equals(Francisco));
	   }
	@Test
	void AgregarEmpleadoTest()
	{
	   EquipoTrabajo Developers= new EquipoTrabajo();		
	   Empleado Matias = new Empleado ("Tester", "42054625","Matias","Guzman");
	   Developers.nuevoEmpleado(Matias.getRol(),Matias.getDni(),Matias.getNombre(),Matias.getApellido());
	   boolean acum = Developers.perteneceEmpleado(Matias.getDni());
	   assertEquals(true,acum);	
	}
	void QuitarEmpleadoTest()
	{
	  EquipoTrabajo Developers= new EquipoTrabajo();		
	  Empleado Matias = new Empleado ("Tester", "42054625","Matias","Guzman");
	  Developers.nuevoEmpleado(Matias.getRol(),Matias.getDni(),Matias.getNombre(),Matias.getApellido());
	  Developers.quitarEmpleado(Matias.getDni());
			
	  assertTrue(false==Developers.perteneceEmpleado(Matias.getDni()));
	}	
	@Test
	void esCompatibleTest()
	{
		HashMap<Empleado,ArrayList<Empleado>> equip= new HashMap<Empleado,ArrayList<Empleado>>();
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();
	   	Empleado Facundo = new Empleado ("Programador", "42054625" ," Facundo", "Cardenas");
		Empleado Rodrigo = new Empleado ("Programador", "39170901" ," Rodrigo", "Cabrera");
		Empleado Francisco = new Empleado("Tester", "14309704" ," Francisco", "Santillan");
		Empleado Matias = new Empleado("Tester", "20477665" ," Matias", "Rodriguez");
	
		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni() , Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni() ,Rodrigo.getNombre(), Rodrigo.getApellido());		
		Desarrolladores.nuevoEmpleado(Francisco.getRol(), Francisco.getDni() , Francisco.getNombre(), Francisco.getApellido());
		Desarrolladores.nuevoEmpleado(Matias.getRol(), Matias.getDni() ,Matias.getNombre(), Matias.getApellido());
		boolean ret= Desarrolladores.esCompatibleConGrupoTrabajo(equip, Facundo);
		assertEquals(true, ret);
	}
	@Test
	void cantidadEmpleadosTest()
	{
		EquipoTrabajo Desarrolladores1 = new EquipoTrabajo();
		Empleado Facundo   = new Empleado ("Lider", "42054625" ," Facundo", "Cardenas");
		Empleado Rodrigo   = new Empleado ("Arquitecto", "39170901" ," Rodrigo", "Cabrera");
		Desarrolladores1.nuevoEmpleado(Facundo.getRol(), Facundo.getDni() , Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores1.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni() ,Rodrigo.getNombre(), Rodrigo.getApellido());
		assertEquals(2,Desarrolladores1.getEmpleados().size());
	}
	@Test
	void quitarEmpleadoListTest()
	{
		EquipoTrabajo Desarrolladores = new EquipoTrabajo();
		Empleado Facundo   = new Empleado ("Lider", "42054625" ," Facundo", "Cardenas");
		Empleado Rodrigo   = new Empleado ("Arquitecto", "39170901" ," Rodrigo", "Cabrera");
		Desarrolladores.nuevoEmpleado(Facundo.getRol(), Facundo.getDni() , Facundo.getNombre(), Facundo.getApellido());
		Desarrolladores.nuevoEmpleado(Rodrigo.getRol(), Rodrigo.getDni() ,Rodrigo.getNombre(), Rodrigo.getApellido());
		Desarrolladores.quitarEmpleadoList(Facundo.getDni());
		boolean ret= Desarrolladores.perteneceEmpleado(Facundo.getDni());
		assertTrue(false==ret);
	}
}