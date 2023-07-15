package com.SpringLearnRedV2.Controller;

import java.sql.Date;
import java.time.LocalDate;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

 
import com.SpringLearnRedV2.Model.Categoria;
import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.CreadorU;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Interacciones;
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
	public String inicio(Model model, HttpSession session) {
	    LOGGER.info("La Sesión del Usuario {}", session.getAttribute("idusuario"));
	    model.addAttribute("Cursos_ALL", creador_Service.findAllCursos());

	    //--------------------------------------------------------------------
	    int idUsuario = (int) session.getAttribute("idusuario");
	    List<Interacciones> interacciones = usuario_Service.findAllByUsuarioId(idUsuario);

	    // OBTENER EL ID DEL CREADOR DE CURSOS DE LAS INTERACCIONES
	    List<Integer> creadorIds = interacciones.stream()
	            .map(interaccion -> interaccion.getCreadorU().getId())
	            .collect(Collectors.toList());

	    //--------------------------------------------------------------------
	    // OBTENER LA CATEGORÍA DEL ÚLTIMO CURSO VISTO POR EL USUARIO
	    Categoria ultimaCategoria = null;
	    if (!interacciones.isEmpty()) {
	        ultimaCategoria = interacciones.get(interacciones.size() - 1).getCurso().getCategoria();
	    }
	    if (ultimaCategoria != null) {
	    	
	    	 // BUSCAR CURSOS POR LOS ID DE LOS CREADORES
		    List<Curso> cursosPorCreador = new ArrayList<>();
		    for (int creadorId : creadorIds) {
		        List<Curso> cursos = creador_Service.finAllCourseIDCreador(creadorId);
		        cursosPorCreador.addAll(cursos);
		    }
		    
		    // BUSCAR CURSOS POR LA CATEGORÍA DEL ÚLTIMO CURSO VISTO
		    List<Curso> cursosPorCategoria = usuario_Service.findCursosByCategoria(ultimaCategoria.getId());
		    
		    Set<Curso> cursosRecomendados = new HashSet<>();
		    cursosRecomendados.addAll(cursosPorCreador);
		    cursosRecomendados.addAll(cursosPorCategoria);

		    // CONVERTIR EL CONJUNTO EN UNA LISTA

		    List<Curso> cursosRecomendadosLista = new ArrayList<>(cursosRecomendados);

		    // MEZCLAR ALEATORIAMENTE LOS CURSOS RECOMENDADOS
		    Collections.shuffle(cursosRecomendadosLista);

		    // OBTENER LOS PRIMEROS 3 CURSOS DE LA LISTA MEZCLADA
		    List<Curso> cursosMostrados = cursosRecomendadosLista.subList(0, Math.min(cursosRecomendadosLista.size(), 3));

		    model.addAttribute("cursosRecomendados", cursosMostrados);
	    	
	    	
	    	} else {
	    		 model.addAttribute("cursosRecomendados", null);
	    		
	    }
	    
	   


 

	    return "usuario/inicio";
	}

	
	
	
	@GetMapping("/Reproductor")
	public String Reproductor(@RequestParam("id") Integer id, Model curso, Model secciones,
			Model contenido, RedirectAttributes attributes,HttpSession session) {
		LOGGER.info("La Sesion del Usuario {}",session.getAttribute("idusuario"));
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
	 ///OBTENER FECHA:
	LocalDate fechaLocal = LocalDate.now();
    Date fechaSQL = Date.valueOf(fechaLocal);
	
	//CAPTURAR DATOS PARA ALMACENAR EN INTERACCIONES:
    List<Curso> cursos = creador_Service.finAllCourseIDCurso(id);
    for (Curso cursoss : cursos) {
        Interacciones interacciones = new Interacciones(); // Crear una nueva instancia de Interacciones
        String titulo = cursoss.getTitulo_G();
        int idcreador = cursoss.getCreadorU().getId();
        Date fecha = fechaSQL;
        int idc = cursoss.getId();
        int idusuario = (int) session.getAttribute("idusuario");
        interacciones.setTitulo(titulo);
        interacciones.setFecha(fecha);
        usuario_Service.save(interacciones, idcreador, idc, idusuario);
    }


	
	
	
	
	
	
	
	
	
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
			Boolean creador = usu.get().getCreador();

		  if(creador != null && creador.equals(true)) {
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
