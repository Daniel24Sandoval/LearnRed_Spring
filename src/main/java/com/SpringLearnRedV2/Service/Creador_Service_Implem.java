package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringLearnRedV2.Dao.Categoria_Dao;
import com.SpringLearnRedV2.Dao.Contenido_Dao;
import com.SpringLearnRedV2.Dao.Contenido_Daoo;
import com.SpringLearnRedV2.Dao.Creador_Dao;
import com.SpringLearnRedV2.Dao.Creador_U_Dao;
import com.SpringLearnRedV2.Dao.Curso_Dao;
import com.SpringLearnRedV2.Dao.Secciones_Dao;
import com.SpringLearnRedV2.Dao.Usuario_Dao;
import com.SpringLearnRedV2.Model.Categoria;
import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.CreadorU;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Seccion_Curso;
import com.SpringLearnRedV2.Model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

 
@Service
public class Creador_Service_Implem implements Creador_Service{

	@Autowired
	  private  Creador_Dao creador_Dao;
	@Autowired
	  private  Categoria_Dao categoria_Dao ;
	@Autowired
	  private  Curso_Dao curso_Dao ;
	@Autowired
	  private  Secciones_Dao secciones_Dao ;
	@Autowired
	  private  Contenido_Dao contenido_Dao ;
	@Autowired
	  private  Usuario_Dao usuario_Dao ;
	
	
	@Override
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public Curso save(Curso curso, Integer creadorU_id, Integer categoria_id) {
        // Obtener el objeto CreadorU utilizando el id recibido
        CreadorU creadorU = creador_Dao.findById(creadorU_id).orElse(null);

        // Obtener el objeto Categoria utilizando el id recibido
        Categoria categoria = categoria_Dao.findById(categoria_id).orElse(null);

        // Establecer la relación creadorU en el objeto curso
        curso.setCreadorU(creadorU);

        // Establecer la relación categoria en el objeto curso
        curso.setCategoria(categoria);

        // Guardar el objeto curso en la base de datos
        return curso_Dao.save(curso);
    }


	@Override
	public Seccion_Curso save(Seccion_Curso seccionCurso, Integer curso_id) {
		// TODO Auto-generated method stub
		 // Obtener el objeto  o
	    Curso curso = curso_Dao.findById(curso_id).orElse(null);

        // Establecer la relación creadorU en el objeto curso
        seccionCurso.setCurso(curso);
	 
		return secciones_Dao.save(seccionCurso);
	}

	@Override
	public Contenido save(Contenido contenido, Integer idSeccionesCurso) {
		// TODO Auto-generated method stub
		Seccion_Curso seccion_Curso = secciones_Dao.findById(idSeccionesCurso).orElse(null);

        contenido.setSeccion_Curso(seccion_Curso);

		return contenido_Dao.save(contenido);
	}

	@Override
	public CreadorU save(CreadorU creadorU, Integer idUsuario) {
		// TODO Auto-generated method stub
		Usuario usuario=usuario_Dao.findById(idUsuario).orElse(null);
		creadorU.setUsuario(usuario);
		return creador_Dao.save(creadorU);
	}

	@Override
	public List<Curso> findAllCursos() {
	    List<Curso> cursos = curso_Dao.findAll(); // Obtener la lista de cursos
	    
	    // Iterar sobre los cursos y obtener el nombre del usuario
	    for (Curso curso : cursos) {
	        CreadorU creadorU = curso.getCreadorU(); // Obtener el objeto Creador del curso
	        Usuario usuario = creadorU.getUsuario(); // Obtener el objeto Usuario del Creador
	        
	        // Obtener el nombre del usuario y establecerlo en el curso
	        String nombreUsuario = usuario.getNombre();
	        curso.setVizualizacion_G(nombreUsuario);
	    }
	    
	    return cursos;
	}

	@Override
	public List<Seccion_Curso> findSeccionesCursoByCursoId(Integer curso_id) {
		
	    return secciones_Dao.findByCursoId(curso_id);
	}


	@Override
	public List<Categoria> findAllCategorias() {
		// TODO Auto-generated method stub
		return categoria_Dao.findAll();
	}

	@Override
	public List<Contenido> findContenidoBySeccionId(Integer seccionId) {
		// TODO Auto-generated method stub
		///contenido_Dao.findById(seccionCursoId).orElse(null);
		 return contenido_Dao.findByid(seccionId);
		///return contenido_Dao.findBySeccionCursoId(seccionId);
	}
	
	
	
	@Override
	public Curso updateCurso(Integer idCurso, Curso curso) {
	// BUSCAR EL CURSO EXISTENTE EN LA BASE DE DATOS
	Curso cursoExistente = curso_Dao.findById(idCurso).orElse(null);

 
	// VERIFICAR SI EL CURSO EXISTE
	if (cursoExistente != null) {
	    // ACTUALIZAR LOS DATOS DEL CURSO EXISTENTE
	    cursoExistente.setAnuncio(curso.getAnuncio());
	    // ... ASIGNAR LOS DEMÁS VALORES QUE DESEAS ACTUALIZAR
	    
	    // GUARDAR LOS CAMBIOS EN LA BASE DE DATOS
	    curso_Dao.save(cursoExistente);
	}

	return cursoExistente;
	}

	@Override
	public Seccion_Curso updateSeccionCurso(Integer idSeccionCurso, Seccion_Curso seccionCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenido updateContenido(Integer idContenido, Contenido contenido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> finAllCourseIDCreador(Integer creadorU_id) {
		// TODO Auto-generated method stub
		return  curso_Dao.findAllByCreadorU_id(creadorU_id);
	}

	@Override
	public List<Curso> finAllCourseIDCurso(Integer id) {
		// TODO Auto-generated method stub
		 curso_Dao.findById(id).orElse(null);
		 
		return curso_Dao.findAllById(id);
	}

	@Override
	public List<Contenido> findContenidoByCursoId(Integer curso_id) {
	    // TODO Auto-generated method stub
	    return contenido_Dao.findAll();
	}

	@Override
	public List<Contenido> finAllContenidoById(Integer id) {
		// TODO Auto-generated method stub
	      ///contenido_Dao.findById(id).orElse(null);
		return contenido_Dao.findAllById(id);
	}

 

	@Override
	public Optional<CreadorU> get(Integer usuario_id) {
		// TODO Auto-generated method stub
		return creador_Dao.findByUsuario_id(usuario_id);
	}

	@Override
	public Curso updateVistaCurso(Integer idCurso, Integer visualizacion) {
		// BUSCAR EL CURSO EXISTENTE EN LA BASE DE DATOS
		Curso cursoExistente = curso_Dao.findById(idCurso).orElse(null);

	 
		// VERIFICAR SI EL CURSO EXISTE
		if (cursoExistente != null) {
		    // ACTUALIZAR LOS DATOS DEL CURSO EXISTENTE
			String vista= visualizacion+"";
		    cursoExistente.setVizualizacion_G(vista);
 
		    return curso_Dao.save(cursoExistente);
		}else {
			return null;
		}

		  
	}

	@Override
	public List<CreadorU> findAllCreadores() {
		// TODO Auto-generated method stub
		return creador_Dao.findAll();
	}


	 
 
 


}
