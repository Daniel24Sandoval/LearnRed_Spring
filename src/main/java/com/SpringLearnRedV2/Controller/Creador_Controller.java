package com.SpringLearnRedV2.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.CreadorU;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Seccion_Curso;
import com.SpringLearnRedV2.Model.Usuario;
import com.SpringLearnRedV2.Service.Creador_Service;
import com.SpringLearnRedV2.Service.Usuario_Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("creador")
public class Creador_Controller {
	 private final Logger LOGGER=LoggerFactory.getLogger(Usuario_Controller.class);
	@Autowired
	private Creador_Service creador_Service;
	@Autowired
	private Usuario_Service usuario_Service;
	
	
	
	
	
	
	@GetMapping("")
	public String Cursos(HttpSession session, Model model, Model usuario,HttpSession sessioUSER) {
	    int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
	    model.addAttribute("cursoList", creador_Service.finAllCourseIDCreador(idUsuario));
	    session.getAttribute("idusuario");
	    
	 // OBTENER EL ATRIBUTO DE USUARIO DESDE EL MODELO
	    Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
	    if (usuarioObject != null) {
	        usuario.addAttribute("Usuario", usuarioObject);
	    } else {
	    	// SI EL ATRIBUTO DE USUARIO NO ESTÁ PRESENTE EN EL MODELO, OBTENERLO DEL SERVICIO
 
	        Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
	        usuarioObject = optionalUsuario.orElse(null); // Obtener el objeto Usuario o asignar null si el Optional está vacío
	        usuario.addAttribute("Usuario", usuarioObject);
	        
	     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
	        model.addAttribute("usuario", usuarioObject);
	    }
	    //CAPTURAR EL ID DEL CREADOR
	    Optional<CreadorU> optionalCreador = creador_Service.get(idUsuario);
	    if (optionalCreador.isPresent()) {
	        CreadorU primerCreador = optionalCreador.get();
	        int idCreador = primerCreador.getId();
	        LOGGER.info("Este creador es: {}", idCreador);
	        model.addAttribute("idCreador", idCreador);
	    } else {
	        LOGGER.info("La lista de creadores está vacía");
	    }
	    
	    //OBTENER LA LISTA DE LOS CURSOS POR IDCREADOR:
	    
	   
	    List<Curso> cursos = creador_Service.finAllCourseIDCreador(optionalCreador.get().getId());
	    if(!cursos.isEmpty()) {
	    	 model.addAttribute("cursos", cursos);
	    }else {
	    	 
	        model.addAttribute("cursos", null);
	    }
	    

	     
	    ///ENVIAR EL IDCREADOR A LAS SIGUIENTES VISTA
	    session.setAttribute("idCreador", optionalCreador.get().getId());
	    sessioUSER.setAttribute("idusuario", idUsuario);
	    
	    return "creador/Cursos";
	}


@GetMapping("/dash")
public String dash(HttpSession session,HttpSession sessioUSER,Model usuario, Model model ) {
	 int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
	 int idCreador = Integer.parseInt(sessioUSER.getAttribute("idCreador").toString());
	session.getAttribute("idCreador");
	sessioUSER.getAttribute("idusuario");
	// OBTENER EL ATRIBUTO DE USUARIO DESDE EL MODELO
    Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
    if (usuarioObject != null) {
        usuario.addAttribute("Usuario", usuarioObject);
    } else {
    	// SI EL ATRIBUTO DE USUARIO NO ESTÁ PRESENTE EN EL MODELO, OBTENERLO DEL SERVICIO
        Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
        usuarioObject = optionalUsuario.orElse(null); // OBTENER EL OBJETO USUARIO O ASIGNAR NULL SI EL OPTIONAL ESTÁ VACÍO

        usuario.addAttribute("Usuario", usuarioObject);
        
     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
 
        model.addAttribute("usuario", usuarioObject);
    }
    
      ///FUNCION PARA OBTENER EL TOTAL DE CURSOS:
    List<Curso> cursos = creador_Service.finAllCourseIDCreador(idCreador);
    int cantidadCursos = cursos.size();
    model.addAttribute("cantidadC",cantidadCursos);

	  ///FUNCION PARA OBTENER EL TOTAL DE VISUALIZACIONES:
	    
	  ///FUNCION PARA OBTENER EL TOTAL DE ESTUDIANTES:
	    
	  ///FUNCION PARA OBTENER EL TOTAL DE VALORACION:
 
	return "creador/dash";
}
@GetMapping("ListaMotenizacion")
public String ListaMotenizacion(HttpSession session,HttpSession sessioUSER, Model model, Model usuario) {
	
	int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
	 int idCreador = Integer.parseInt(session.getAttribute("idCreador").toString());
		// OBTENER EL ATRIBUTO DE USUARIO DESDE EL MODELO
	    Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
	    if (usuarioObject != null) {
	        usuario.addAttribute("Usuario", usuarioObject);
	    } else {
	    	// SI EL ATRIBUTO DE USUARIO NO ESTÁ PRESENTE EN EL MODELO, OBTENERLO DEL SERVICIO
	        Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
	        usuarioObject = optionalUsuario.orElse(null); // OBTENER EL OBJETO USUARIO O ASIGNAR NULL SI EL OPTIONAL ESTÁ VACÍO

	        usuario.addAttribute("Usuario", usuarioObject);
	        
	     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
	 
	        model.addAttribute("usuario", usuarioObject);
	    }
	    //OBTENER LA LISTA DE LOS CURSOS POR IDCREADOR:
	    
		   
	    List<Curso> cursos = creador_Service.finAllCourseIDCreador(idCreador);
	    if(!cursos.isEmpty()) {
	    	 model.addAttribute("cursos", cursos);
	    }else {
	    	 
	        model.addAttribute("cursos", null);
	    }
	 // OBTENER CURSO POR ID
	    //------------------------------------------------------------------

	    Map<Curso, Integer> vistasPorCurso = new HashMap<>();

	    for (Curso curso : cursos) {
	        int totalVistasCurso = 0;
	        List<Seccion_Curso> seccionesCurso = creador_Service.findSeccionesCursoByCursoId(curso.getId());

	        for (Seccion_Curso seccion : seccionesCurso) {
	            List<Contenido> contenidos = creador_Service.findContenidoBySeccionId(seccion.getId());
	            
	            for (Contenido contenido : contenidos) {
	                totalVistasCurso += contenido.getVizualizacion();
	            }
	        }
	        
	        vistasPorCurso.put(curso, totalVistasCurso);
	        
	    }

	 // OBTENER DATOS CURSO Y TOTAL DE VISTA
	    for (Map.Entry<Curso, Integer> entry : vistasPorCurso.entrySet()) {
	        Curso curso = entry.getKey();
	        int totalVistasCurso = entry.getValue();
	        ///AQUI CADA VEZ QUE ENTRA ACTUALIZA LAS VISTAS TOTALES
	        creador_Service.updateVistaCurso(curso.getId(), totalVistasCurso);
	        LOGGER.info("Curso: {}, Vista Totales: {}", curso.getTitulo_G(), totalVistasCurso);
	    }

	    //------------------------------------------------------------------


	    
	    
	    
	    
	return "creador/ListaMotenizacion";
	
}


@GetMapping("monetizacion")
public String monetizacion(HttpSession session,HttpSession sessioUSER, Model model, Model usuario,@RequestParam("id") Integer id) {
	 int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
	 int idCreador = Integer.parseInt(session.getAttribute("idCreador").toString());
		// OBTENER EL ATRIBUTO DE USUARIO DESDE EL MODELO
	    Usuario usuarioObject = (Usuario) model.getAttribute("usuario");
	    if (usuarioObject != null) {
	        usuario.addAttribute("Usuario", usuarioObject);
	    } else {
	    	// SI EL ATRIBUTO DE USUARIO NO ESTÁ PRESENTE EN EL MODELO, OBTENERLO DEL SERVICIO
	        Optional<Usuario> optionalUsuario = usuario_Service.get(idUsuario);
	        usuarioObject = optionalUsuario.orElse(null); // OBTENER EL OBJETO USUARIO O ASIGNAR NULL SI EL OPTIONAL ESTÁ VACÍO

	        usuario.addAttribute("Usuario", usuarioObject);
	        
	     // GUARDAR EL ATRIBUTO DE USUARIO EN EL MODELO PARA FUTURAS SOLICITUDES
	 
	        model.addAttribute("usuario", usuarioObject);
	    }
	    List<Curso> cursos = creador_Service.finAllCourseIDCurso(id);
	    if (!cursos.isEmpty()) {
	        for (Curso curso : cursos) {
	        	 
	            int vizualizacion = Integer.parseInt(curso.getVizualizacion_G());
	            int pago = (int) Math.round((vizualizacion / 1000.0) * 5.78);
	            curso.setHoras(pago+"");
	        }
	        
	        model.addAttribute("cursos", cursos);
	    } else {
	        model.addAttribute("cursos", null);
	    }

	return null;
}

	
	@GetMapping("Creacion_C")
	public String Creacion_C(Model model, HttpSession session,HttpSession sessioUSER) {
		model.addAttribute("categoria", creador_Service.findAllCategorias());
		 int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
		 int idCreador = Integer.parseInt(sessioUSER.getAttribute("idCreador").toString());
		 session.setAttribute("idUsuario", idUsuario);
		 session.setAttribute("idCreador", idCreador);
		return "creador/Creacion_C";
	}
	
	
	@PostMapping("/creacionC")
	public String creacionC(@RequestParam("categoria") Integer idcategoria,
	        @RequestParam("idusuario") Integer creadorU_id, Curso curso, RedirectAttributes attributes,HttpSession session,HttpSession sessioUSER) {
		int idUsuario = Integer.parseInt(session.getAttribute("idusuario").toString());
		 int idCreador = Integer.parseInt(sessioUSER.getAttribute("idCreador").toString());
		 session.setAttribute("idUsuario", idUsuario);
		 session.setAttribute("idCreador", idCreador);
	  LOGGER.info("Este objeto es producto: {}", curso);
	  LOGGER.info("SI ESTA RECIENDO IDCREADOR {}", creadorU_id);

	  creador_Service.save(curso, idCreador, idcategoria);
	  
	  // Obtén el ID del curso creado
	  Integer idCursoCreado = curso.getId();
	  
	  // Agrega el ID del curso como atributo en RedirectAttributes para enviarlo a la otra ventana
	  attributes.addAttribute("idCurso", idCursoCreado);

	  return "redirect:/creador/Creacion_Secciones";
	}
	
	///th:action="@{/creador/crearContenido	}

	@GetMapping("Creacion_Secciones")
	public String Creacion_Secciones(@RequestParam("idCurso") Integer idCurso,  Model model, Model model2) {
		// UTILIZA EL ID DEL CURSO SEGÚN TUS NECESIDADES EN LA LÓGICA
	  LOGGER.info("ID DEL CURSO CREADO {}", idCurso);
	  model.addAttribute("idCurso", idCurso);
	  
	  //LISTAREMOS LAS SECCIONES PARA HACER EL CRUD:
	  
		  model2.addAttribute("SeccionesList", creador_Service.findSeccionesCursoByCursoId(idCurso));
	  
	  
	  
	  return "/creador/Creacion_Secciones";
	}
	
	
	

@PostMapping("/crearContenido")
public String crearContenido(@RequestParam("curso_id") Integer idCurso,
                             Seccion_Curso seccion_Curso,
                             RedirectAttributes attributes,
                             HttpServletRequest request) throws IllegalStateException, IOException {
    // GUARDAR LA SECCIÓN Y OBTENER SU ID
    Seccion_Curso seccionGuardada = creador_Service.save(seccion_Curso, idCurso);
    Integer idSeccion = seccionGuardada.getId();

    // OBTENER LOS PARÁMETROS DEL FORMULARIO
    Map<String, String[]> parameterMap = request.getParameterMap();

    // ITERAR SOBRE LOS INPUTS DE LAS MINISECCIONES
    int contador = 0;

    for (String paramName : parameterMap.keySet()) {
        // VERIFICAR SI EL NOMBRE DEL PARÁMETRO CORRESPONDE A UN INPUT DE MINISECCIÓN
        if (paramName.startsWith("titulo-")) {
            contador++;

            // CREAR UNA NUEVA INSTANCIA DE CONTENIDO EN CADA ITERACIÓN
            Contenido contenido = new Contenido();

            // OBTENER LOS NÚMEROS DE SECCIÓN Y MINISECCIÓN
            String[] parts = paramName.split("-");
            int seccionNum = Integer.parseInt(parts[1]);
            int miniseccionNum = Integer.parseInt(parts[2]);

            // OBTENER EL TÍTULO DE LA MINISECCIÓN
            String titulo = parameterMap.get(paramName)[0];

            // CONSTRUIR LOS NOMBRES DE LOS PARÁMETROS DE VIDEO Y ARCHIVO
            String videoParamName = "video-" + seccionNum + "-" + miniseccionNum;
            String archivoParamName = "archivo-" + seccionNum + "-" + miniseccionNum;

            // OBTENER LOS ARCHIVOS DE VIDEO Y ARCHIVO
            MultipartFile videoFile = ((MultipartHttpServletRequest) request).getFile(videoParamName);
            MultipartFile archivoFile = ((MultipartHttpServletRequest) request).getFile(archivoParamName);

            // VERIFICAR SI SE CARGÓ UN ARCHIVO DE VIDEO Y GUARDARLO EN LA CARPETA DE DESTINO
            if (videoFile != null && !videoFile.isEmpty()) {
                if (videoFile.getSize() <= 2000 * 1048576) {  // Verificar el tamaño máximo permitido (en bytes)
                    String videoFileName = videoFile.getOriginalFilename();
                    String videoFilePath = "C:\\Users\\kimbe\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\LearnRedV2\\src\\main\\resources\\static\\Cursos_V\\" + videoFileName;
                    File videoDest = new File(videoFilePath);
                    videoFile.transferTo(videoDest);

                    // OBTENER LA URL DEL ARCHIVO DE VIDEO Y ASIGNARLA AL CONTENIDO
                    String videoUrl = "../Cursos_V/" + videoFileName;  // Actualiza la ruta de la carpeta destino
                    contenido.setArchivo(videoUrl);
                } else {
                    // Manejar el caso cuando el archivo excede el tamaño máximo permitido
                    // Agregar el código correspondiente, por ejemplo, mostrar un mensaje de error al usuario
                }
            }


            // VERIFICAR SI SE CARGÓ UN ARCHIVO ADJUNTO Y GUARDARLO EN LA CARPETA DE DESTINO
            if (archivoFile != null && !archivoFile.isEmpty()) {
                if (archivoFile.getSize() <= 2000 * 1048576) {  // Verificar el tamaño máximo permitido (en bytes)
                	String archivoFileName = archivoFile.getOriginalFilename();
                	String archivoFilePath = "C:\\Users\\kimbe\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\LearnRedV2\\src\\main\\resources\\static\\Archivos_V\\" + archivoFileName;
                	File archivoDest = new File(archivoFilePath);
                	archivoFile.transferTo(archivoDest);

                    // OBTENER LA URL DEL ARCHIVO ADJUNTO Y ASIGNARLA AL CONTENIDO
                    String archivoUrl = "../Archivos_V/" + archivoFileName;  // Actualiza la ruta de la carpeta destino
                    contenido.setTipo_Archivo(archivoUrl);
                } else {
                    // Manejar el caso cuando el archivo excede el tamaño máximo permitido
                    // Agregar el código correspondiente, por ejemplo, mostrar un mensaje de error al usuario
                }
            }

            // ASIGNAR LOS VALORES AL CONTENIDO
            contenido.setTitulo(titulo);
            // Asignar otros valores según sea necesario

            // GUARDAR LA MINISECCIÓN UTILIZANDO EL ID DE LA SECCIÓN
            creador_Service.save(contenido, idSeccion);
        }
    }

    // ...
    LOGGER.info("Número de Parámetros {}", contador);
    attributes.addAttribute("idCurso", idCurso);

    return "redirect:/creador/Creacion_Secciones";
}
@PostMapping("/guardarImgCurso")
public String guardarImgCurso(@RequestParam("curso_id") Integer curso_id, @RequestParam("Anuncio") MultipartFile imagen, RedirectAttributes attributes) {
    // VERIFICA SI SE HA CARGADO UNA IMAGEN
    if (!imagen.isEmpty()) {
        try {
            // OBTIENE EL NOMBRE DE LA IMAGEN
            String nombreImagen = imagen.getOriginalFilename();
            
            // GUARDA LA IMAGEN EN LA UBICACIÓN DESEADA (POR EJEMPLO, EN UNA CARPETA EN EL SISTEMA DE ARCHIVOS)
            String rutaImagenLocal = "C:\\Users\\kimbe\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\LearnRedV2\\src\\main\\resources\\static\\Imagen_Cursos\\" + nombreImagen;
            File archivoDest = new File(rutaImagenLocal);
            imagen.transferTo(archivoDest);
            
            // OBTÉN LA RUTA RELATIVA DE LA IMAGEN PARA LA VISUALIZACIÓN DESDE HTML
            String rutaImagenCorta = "../Imagen_Cursos/" + nombreImagen;
            
            // ASIGNA LA URL DE LA IMAGEN AL CAMPO ANUNCIO DEL OBJETO CURSO
            Curso curso = new Curso();
            curso.setAnuncio(rutaImagenCorta);
            
            // ACTUALIZA EL CURSO EN LA BASE DE DATOS
            creador_Service.updateCurso(curso_id, curso);
        } catch (Exception e) {
            e.printStackTrace();
            // MANEJO DE ERRORES EN CASO DE QUE NO SE PUEDA GUARDAR LA IMAGEN
        }
    }
    
    attributes.addAttribute("idCurso", curso_id);
    return "redirect:/creador/Creacion_Secciones";
}




}
