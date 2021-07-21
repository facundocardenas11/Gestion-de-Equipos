package codigoInterfaz;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import codigoProduccion.EquipoTrabajo;
import codigoProduccion.FuerzaBruta;

public class InterfazBotones {
	private Button button = new Button("Crear Grupo de Trabajo");
	private Button button1menos = new Button("<<");
	private Button button1mas = new Button(">>");
	private Button button2menos = new Button("<<");
	private Button button2mas = new Button(">>");
	private Button button3menos = new Button("<<");
	private Button button3mas = new Button(">>");
	private Button button4menos = new Button("<<");
	private Button button4mas = new Button(">>");
	private Button buttonAddIncompatibilidad = new Button("Añadir Incompatibilidad");
	private Button buttonAddEmpleado = new Button("Añadir Nuevo Empleado");
	private Button buttonquitarIncompatibilidad = new Button("Quitar Incompatibilidad");
	private Button buttonQuitarEmpleado = new Button("QuitarEmpleado");

	InterfazBotones() {
		button.setBounds(351, 10, 166, 146);
		button.setFont(new Font("Arial Black", Font.BOLD, 12));
		button1mas.setBounds(323, 50, 22, 22);
		button2mas.setBounds(323, 78, 22, 22);
		button3mas.setBounds(323, 106, 22, 22);
		button4mas.setBounds(323, 134, 22, 22);
		button1menos.setBounds(209, 50, 22, 22);
		button2menos.setBounds(209, 78, 22, 22);
		button3menos.setBounds(209, 106, 22, 22);
		button4menos.setBounds(209, 134, 22, 22);
		buttonAddIncompatibilidad.setBounds(707, 499, 267, 22);
		buttonAddEmpleado.setBounds(707, 250, 267, 22);
		buttonquitarIncompatibilidad.setBounds(707, 629, 267, 22);
		buttonQuitarEmpleado.setBounds(707, 354, 267, 22);
	}

	public void buffer(JPanel contentPane) {
		contentPane.add(button);
		contentPane.add(button1menos);
		contentPane.add(button2menos);
		contentPane.add(button3menos);
		contentPane.add(button4menos);
		contentPane.add(button1mas);
		contentPane.add(button2mas);
		contentPane.add(button3mas);
		contentPane.add(button4mas);
		contentPane.add(buttonAddIncompatibilidad);
		contentPane.add(buttonAddEmpleado);
		contentPane.add(buttonquitarIncompatibilidad);
		contentPane.add(buttonQuitarEmpleado);
	}

	public void añadirQuitarIncompatibilidad(EquipoTrabajo equip, InterfazChoices jChoice) {
		buttonAddIncompatibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equip.addIncompatibilidad(equip.getemploye(jChoice.getEmpleado1()),
						equip.getemploye(jChoice.getEmpleado2()));
				// System.out.println(equip);
			}
		});
		buttonquitarIncompatibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equip.quitarIncompatibilidad(equip.getemploye(jChoice.getEmpleado1()),
						equip.getemploye(jChoice.getEmpleado2()));
			}
		});
	}

	public void añadirQuitarEmpleado(InterfazTextoaddEmpleados jText, InterfazChoices jChoice, EquipoTrabajo equip,
			InterfazListaEmpleados jList) {
		buttonAddEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!jText.getDNI().isEmpty()) {
					if (!jText.getNombre().isEmpty()) {
						if (!jText.getApellido().isEmpty()) {
							if (!equip.perteneceEmpleado(jText.getDNI())) {
								equip.nuevoEmpleado(jChoice.getRol(), jText.getDNI(), jText.getNombre(),
										jText.getApellido());
								jText.actualizar();
								jList.actualizarListas(equip);
								jChoice.actualizarListas(equip);
							}
						}
					}
				}
			}
		});
		buttonQuitarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equip.quitarEmpleado(jChoice.getQuitarEmpleado().getSelectedItem());
				jText.actualizar();
				jChoice.actualizarListas(equip);
				jList.actualizarListas(equip);

			}
		});
	}

	public void accionFuerzaBruta(FuerzaBruta fuerzaBruta, EquipoTrabajo equip, InterfazTexto jText,
			InterfazListaEmpleados jList) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread HiloFuerzaBruta = new Thread(fuerzaBruta);
				HiloFuerzaBruta.start(); // Inicio del hilo paralelo.
				fuerzaBruta.crearGrupo(equip, jText.getValue(1), jText.getValue(2), jText.getValue(3),
						jText.getValue(4));
				jList.actualizarListas(fuerzaBruta.getEquipo());
				// System.out.println(fuerzaBruta.getEquipo());
				try {
					HiloFuerzaBruta.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				;
			}
		});
	}

	public void accionesBotones(InterfazTexto jText) {
		button1menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jText.getValue(1) > 1) {
					jText.setValue(1, jText.getValue(1) - 1);
				}
			}
		});
		button1mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText.setValue(1, jText.getValue(1) + 1);
			}
		});
		button2menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jText.getValue(2) > 1) {
					jText.setValue(2, jText.getValue(2) - 1);
				}
			}
		});
		button2mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText.setValue(2, jText.getValue(2) + 1);
			}
		});
		button3menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jText.getValue(3) > 1) {
					jText.setValue(3, jText.getValue(3) - 1);
				}
			}
		});
		button3mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText.setValue(3, jText.getValue(3) + 1);
			}
		});
		button4menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jText.getValue(4) > 1) {
					jText.setValue(4, jText.getValue(4) - 1);
				}
			}
		});
		button4mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jText.setValue(4, jText.getValue(4) + 1);
			}
		});
	}
}
