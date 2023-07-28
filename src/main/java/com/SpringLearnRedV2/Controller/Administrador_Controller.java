package com.SpringLearnRedV2.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Usuario;
import com.SpringLearnRedV2.Service.Creador_Service;
import com.SpringLearnRedV2.Service.Usuario_Service;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("admin")
public class Administrador_Controller {
	private final Logger LOGGER=LoggerFactory.getLogger(Usuario_Controller.class);

	
	@Autowired
	private Creador_Service creador_Service;
	@Autowired
	private Usuario_Service usuario_Service;
	
	
	
	
	@GetMapping("")
	public String Dash(HttpSession session, Model model,Model cursos, Model usuario,Model creadores,Model Vista)  {
		///ES UN MOSTRAR 
		///CANTIDAD TOTAL DE CURSOS
		 LOGGER.info("La Sesión del Usuario {}", session.getAttribute("idusuario"));
			int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
			session.setAttribute("idusuario", idUsuario);
		int cantidadCursos = creador_Service.findAllCursos().size();
		cursos.addAttribute("Cursos_ALL", cantidadCursos);
	    
		Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
		 Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
	        usuarioObject = optionalUsuario.orElse(null); // Obtener el objeto Usuario o asignar null si el Optional está vacío
	        usuario.addAttribute("Usuario", usuarioObject);
	        
	     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
	        model.addAttribute("usuario", usuarioObject);
		///CANTIDAD DE USUARIOS
		int cantidadusuarios = usuario_Service.finaAll().size();
		usuario.addAttribute("Usuarios_ALL", cantidadusuarios);
		 
		///CANTIDAD TOTAL CREADORS
		int cantidadcreadores = creador_Service.findAllCreadores().size();
		creadores.addAttribute("Creadores_ALL", cantidadcreadores);
		///CANTIDAD TOTAL DE VISTA
		List<Curso> cursoc = usuario_Service.findAllCursosnormal();
		int cantidadVista = 0;

		for (Curso cursoss : cursoc) {
		    //String vistaString = cursoss.getVizualizacion_G();
		    //int vistaInt = Integer.parseInt(vistaString);
		    //cantidadVista += vistaInt;
			 LOGGER.info("Cantidad de Vistas {}",  cursoss.getVizualizacion_G());
		}
		Vista.addAttribute("Vistas_ALL", cantidadVista);
		//-----------------------------------------
	    LOGGER.info("Cantidad de Cursos {}",  cantidadCursos);
	    LOGGER.info("Cantidad de Usuarios {}",  cantidadusuarios);
	    LOGGER.info("Cantidad de Creadores {}",  cantidadcreadores);
	   
	    return "admin/Dash";
	}
	
	
	@GetMapping("Cursos")
	public String Cursos(HttpSession session, Model model,Model cursos, Model usuario,Model creadores,Model Vista)  {
		///ES UN MOSTRAR 
		 LOGGER.info("La Sesión del Usuario {}", session.getAttribute("idusuario"));
			int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
			session.setAttribute("idusuario", idUsuario);
		///CANTIDAD TOTAL DE CURSOS
			Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
			 Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
		        usuarioObject = optionalUsuario.orElse(null); // Obtener el objeto Usuario o asignar null si el Optional está vacío
		        usuario.addAttribute("Usuario", usuarioObject);
		        
		     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
		        model.addAttribute("usuario", usuarioObject);
		cursos.addAttribute("cursos", creador_Service.findAllCursos());
	    

		///CANTIDAD DE USUARIOS
		int cantidadusuarios = usuario_Service.finaAll().size();
		usuario.addAttribute("Usuarios_ALL", cantidadusuarios);
		 
		///CANTIDAD TOTAL CREADORS
		int cantidadcreadores = creador_Service.findAllCreadores().size();
		creadores.addAttribute("Creadores_ALL", cantidadcreadores);
		///CANTIDAD TOTAL DE VISTA
		List<Curso> cursoc = usuario_Service.findAllCursosnormal();
		int cantidadVista = 0;

		for (Curso cursoss : cursoc) {
		    //String vistaString = cursoss.getVizualizacion_G();
		    //int vistaInt = Integer.parseInt(vistaString);
		    //cantidadVista += vistaInt;
			 LOGGER.info("Cantidad de Vistas {}",  cursoss.getVizualizacion_G());
		}
		Vista.addAttribute("Vistas_ALL", cantidadVista);
		//-----------------------------------------
	 
	     
	    return "admin/Cursos";
	}
	
	
	

	@GetMapping("Creadores")
	public String Creadores(HttpSession session, Model model,Model cursos, Model usuario,Model creadores,Model Vista)  {
		///ES UN MOSTRAR 
		 LOGGER.info("La Sesión del Usuario {}", session.getAttribute("idusuario"));
			int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
			session.setAttribute("idusuario", idUsuario);
		    cursos.addAttribute("cursos", creador_Service.findAllCursos());
	    
		    Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
			 Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
		        usuarioObject = optionalUsuario.orElse(null); // Obtener el objeto Usuario o asignar null si el Optional está vacío
		        usuario.addAttribute("Usuario", usuarioObject);
		        
		     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
		        model.addAttribute("usuario", usuarioObject);
		///CANTIDAD DE USUARIOS
		 
		usuario.addAttribute("Usuarios_ALL", usuario_Service.finaAll());
		 
		///CANTIDAD TOTAL CREADORS
		int cantidadcreadores = creador_Service.findAllCreadores().size();
		creadores.addAttribute("Creadores_ALL", cantidadcreadores);
		///CANTIDAD TOTAL DE VISTA
		List<Curso> cursoc = usuario_Service.findAllCursosnormal();
		int cantidadVista = 0;

		for (Curso cursoss : cursoc) {
		    //String vistaString = cursoss.getVizualizacion_G();
		    //int vistaInt = Integer.parseInt(vistaString);
		    //cantidadVista += vistaInt;
			 LOGGER.info("Cantidad de Vistas {}",  cursoss.getVizualizacion_G());
		}
		Vista.addAttribute("Vistas_ALL", cantidadVista);
		//-----------------------------------------
	 
	     
	    return "admin/Creadores";
	}
	
	
}
