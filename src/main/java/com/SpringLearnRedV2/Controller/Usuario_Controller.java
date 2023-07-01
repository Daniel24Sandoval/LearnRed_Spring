package com.SpringLearnRedV2.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 
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
import com.SpringLearnRedV2.Model.CreadorU;
import com.SpringLearnRedV2.Model.Seccion_Curso;
import com.SpringLearnRedV2.Model.Usuario;
import com.SpringLearnRedV2.Service.Creador_Service;
import com.SpringLearnRedV2.Service.Usuario_Service;

import jakarta.servlet.http.HttpSession;



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
	public String acceder(Usuario usuario, HttpSession session) {
	    Optional<Usuario> userOptional = usuario_Service.findByCorreo(usuario.getCorreo());
	    
	    if (userOptional.isPresent()) {
	    	///AQUI SE VA A GUARDAR LAS SECCIONES 
	       session.setAttribute("idusuario", userOptional.get().getId());
			   LOGGER.info("Usuario de BD : {}", userOptional.get());
	       if(userOptional.get().getRol().equals("User")) {
	    	   return "redirect:/usuario/inicio";
	       }if(userOptional.get().getRol().equals("Admin")){
	    	   return "redirect:/admin";
	    	   
	       }else {
	    	   return "redirect:/";
	       }
	    	   
	       }
	        // Resto del código para procesar el usuario encontrado
	        
	       
	     else {
	        // Manejo de la situación en la que no se encuentra el usuario
	        // Puedes mostrar un mensaje de error o redirigir a una página de inicio de sesión nuevamente
	    	 LOGGER.info("NO HAY NI USUARIO" );
			 
	    	 return "redirect:/";
	         
	    }
	}

	
	
	
	
	
	@GetMapping("/registro")
	public String registro() {

		return "usuario/registro";
	}

	@PostMapping("/save")
	public String save(Usuario usuario, RedirectAttributes atribute ) {
		LOGGER.info("este objeto es producto{}",usuario);

		 usuario_Service.save(usuario);
	if (usuario.getCorreo()!=null){
		atribute.addFlashAttribute("success", "success");
	}else {
		atribute.addFlashAttribute("danger", "danger");
	}
	 
		return "redirect:/usuario/login";
	}
	
	
	@GetMapping("/inicio")
	public String inicio(Model model,HttpSession session) {
		LOGGER.info("La Sesion del Usuario {}",session.getAttribute("idusuario"));

		model.addAttribute("Cursos_ALL", creador_Service.findAllCursos());
		 
		return "usuario/inicio";
	}
	
	
	
	@GetMapping("/Reproductor")
	public String Reproductor(@RequestParam("id") Integer id, Model curso, Model secciones,
			Model contenido, RedirectAttributes attributes,HttpSession session) {


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

	// AGREGAR LOS CONTENIDOS RELACIONADOS AL MODELO "CONTENIDO"
	contenido.addAttribute("contenidoxidseccion", contenidosRelacionados);
	attributes.addAttribute("idCurso", id);
	curso.addAttribute("id", id);
	LOGGER.info("La Sesion del Usuario {}",session.getAttribute("idusuario"));

	return "usuario/Reproductor";
	}

	
	
	
	
	@GetMapping("/ReproductorContenido")
	public String ReproductorContenido(@RequestParam("id") Integer idContenido, @RequestParam("idCurso") 
	Integer id, Model curso,Contenido con, Model secciones, Model contenido,
	Model contenidoU, RedirectAttributes attributes,HttpSession session) {
	

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
//MOSTRAR CONTENIDO SEGUN ID:
	 contenidoU.addAttribute("ContenidoU",creador_Service.finAllContenidoById(idContenido));
	// AGREGAR LOS CONTENIDOS RELACIONADOS AL MODELO "CONTENIDO"
	contenido.addAttribute("contenidoxidseccion", contenidosRelacionados);
	curso.addAttribute("id", id);
	///ESTOY HACIENDO UN CONSULTA, PARA OBTENER EL NUMERO DE VISTAS, Y LUEGO ACTUALIZAR
	List<Contenido> contenidov = creador_Service.finAllContenidoById(idContenido);
	int numeroVistas = 0;
	for (Contenido contenidoo : contenidov) {
	    numeroVistas += contenidoo.getVizualizacion();
	}
	LOGGER.info("La Sesion del Usuario {}",session.getAttribute("idusuario"));
	usuario_Service.updateVizualizacion(numeroVistas+1,idContenido);
	
	return "usuario/ReproductorContenido";
	}
 
	@GetMapping("/validaCreador")
	public String validaCreador(HttpSession session, Model usuarioo, RedirectAttributes attributes) {
		//LOGGER.info("La Sesion del Usuario {}",session.getAttribute("idusuario"));
		int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
		Optional<Usuario> usu = usuario_Service.get(idUsuario);

		if (usu.isPresent()) {
	 
		  if(usu.get().getCreador().equals(true)) {
			  LOGGER.info("La Sesion del Usuario {}",session.getAttribute("idusuario"));
			  Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
			    Usuario usuarioObject = optionalUsuario.orElse(null); // Obtener el objeto Usuario o asignar null si el Optional está vacío
			    LOGGER.info("USER {}",usuarioObject);
			    attributes.addFlashAttribute("usuario", usuarioObject);
			  return "redirect:/creador";
		  }else {
			 
				 
			  //usu.addAttribute("usuario", usuario_Service.get(idUsuario));
			  LOGGER.info("ID USER {}",session.getAttribute("idusuario"));
			  session.setAttribute("idusuario", idUsuario);
			  
			  Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
				Usuario usuario = optionalUsuario.orElse(null); // Obtener el objeto Usuario o asignar null si el Optional está vacío

				attributes.addFlashAttribute("usuario", usuario);
			  
			  return "redirect:/usuario/ConfirmacionCreador";
		  }
		  


		} else {
		  // El usuario no existe o no se encontró en la base de datos
			 return "redirect:/SS";
		}
		
		
	}

	@GetMapping("/ConfirmacionCreador")
	public String ConfirmacionCreador(HttpSession session,Model usuario) {
		int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
		
		session.getAttribute("idusuario");
		
		usuario.addAttribute("usuario", usuario_Service.get(idUsuario));
		return "usuario/ConfirmacionCreador";
		
	}
	
	
	
	@GetMapping("/Aceptar")
	public String Aceptar(HttpSession session, CreadorU creadoru) {
	    int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
	    creadoru.setTitulo("RANN");creadoru.setTitulo("REM");
	    creador_Service.save(creadoru, idUsuario);
	    usuario_Service.updatemodCreadorById(true, idUsuario);

	    
	    return "redirect:/creador";
	}

	

}
