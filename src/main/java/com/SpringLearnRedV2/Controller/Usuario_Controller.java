package com.SpringLearnRedV2.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Seccion_Curso;
import com.SpringLearnRedV2.Model.Usuario;
import com.SpringLearnRedV2.Service.Creador_Service;
import com.SpringLearnRedV2.Service.Usuario_Service;



@Controller
@RequestMapping("usuario")
public class Usuario_Controller {

private final Logger LOGGER=LoggerFactory.getLogger(Usuario_Controller.class);

	@Autowired
	private Usuario_Service usuario_Service; 
	@Autowired
	private Creador_Service creador_Service;

	@GetMapping("")
	public String home() {
		
		
		return "usuario/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
	
	@PostMapping("/acceder")
	public String acceder(Usuario usuario) {
		///LOGGER.info("acceso : {}", usuario);
		return "redirect:/usuario/inicio";
	}
	
	
	@GetMapping("/registro")
	public String registro() {
		return "usuario/registro";
	}

	@PostMapping("/save")
	public String save(Usuario usuario, RedirectAttributes atribute ) {
		LOGGER.info("este objeto es producto{}",usuario);

		usuario_Service.save(usuario);
	if (usuario.getCorreo_U()!=null){
		atribute.addFlashAttribute("success", "success");
	}else {
		atribute.addFlashAttribute("danger", "danger");
	}
	 
		return "redirect:/usuario/login";
	}
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("Cursos_ALL", creador_Service.findAllCursos());
		 
		return "usuario/inicio";
	}
	
	@GetMapping("/Reproductor")
	public String Reproductor(@RequestParam("id") Integer id, Model curso, Model secciones, Model contenido, RedirectAttributes attributes) {

	    // OBTENER CURSO POR ID
	    curso.addAttribute("cursoxid", creador_Service.finAllCourseIDCurso(id));

	    // OBTENER SECCIONES DEL CURSO
	    List<Seccion_Curso> seccionesCurso = creador_Service.findSeccionesCursoByCursoId(id);

	    // CREAR UNA LISTA PARA ALMACENAR LOS CONTENIDOS RELACIONADOS
	    List<Contenido> contenidosRelacionados = new ArrayList<>();

	    // RECORRER CADA SECCIÓN Y OBTENER LOS CONTENIDOS RELACIONADOS
	    for (Seccion_Curso seccion : seccionesCurso) {
	        List<Contenido> contenidos = creador_Service.findContenidoBySeccionId(seccion.getId());
	        contenidosRelacionados.addAll(contenidos);
	    }

	    // AGREGAR LOS CONTENIDOS RELACIONADOS AL MODELO "contenido"
	    contenido.addAttribute("contenidoxidseccion", contenidosRelacionados);

	    return "usuario/Reproductor";
	}

}
