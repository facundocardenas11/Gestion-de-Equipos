package codigoProduccion;

public class FuerzaBruta implements Runnable {

	EquipoTrabajo equipoAuxiliar;

	public FuerzaBruta() {
		equipoAuxiliar = new EquipoTrabajo();
	}

	public void crearGrupo(EquipoTrabajo equip, int cantLideres, int cantArquitectos, int cantProgramadores,
			int cantTesters) {
		equipoAuxiliar = equip.clone();
		equipoAuxiliar.crearGrupoTrabajo(cantLideres, cantArquitectos, cantProgramadores, cantTesters);
	}

	public EquipoTrabajo getEquipo() {
		return equipoAuxiliar;
	}

	@Override
	public void run() {

	}

}
