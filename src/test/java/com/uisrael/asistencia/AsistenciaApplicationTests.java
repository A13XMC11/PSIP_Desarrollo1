package com.uisrael.asistencia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.asistencia.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.uisrael.asistencia.infraestructura.repositorios.IEmpleadoRepositorio;

@SpringBootTest
class AsistenciaApplicationTests {
	
	@Autowired
	IEmpleadoRepositorio repoEmpleado;
	
	@Test
	void contextLoads() {
		
		EmpleadoEntity nuevoEmp = new EmpleadoEntity();
		nuevoEmp.setNombreEmpleado("Alexander");
		nuevoEmp.setApellidosEmpleado("Mejia Cevallos");
		nuevoEmp.setCorreoEmpleado("alexander777800@gmail.com");
		nuevoEmp.setContrasenaEmpleado("Test123");
		repoEmpleado.save(nuevoEmp);
		
		System.out.println(nuevoEmp.getNombreEmpleado()+" "+nuevoEmp.getApellidosEmpleado()+" "+nuevoEmp.getCorreoEmpleado()+" "+nuevoEmp.getContrasenaEmpleado());
	}

}
