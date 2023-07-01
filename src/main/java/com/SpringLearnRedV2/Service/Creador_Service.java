package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import com.SpringLearnRedV2.Model.Categoria;
import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.CreadorU;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Seccion_Curso;
import com.SpringLearnRedV2.Model.Usuario;

 
public interface Creador_Service {
	 public Categoria save(Categoria categoria);
	    public Curso save(Curso curso, Integer 	creadorU_id , Integer categoria_id);
	    public Seccion_Curso save(Seccion_Curso curso, Integer curso_id);
	    public Contenido save(Contenido contenido, Integer idSeccionesCurso);
	    public CreadorU save(CreadorU creadorU, Integer idUsuario);
	    ///LISTAR CURSOS
	    public List<Curso> findAllCursos();
	    public List<Curso> finAllCourseIDCreador(Integer creadorU_id);
	    public List<Curso> finAllCourseIDCurso(Integer id);
	   /// public Contenido  finAllContenidoUniqueById(Integer contenido_id); 
	    public List<Seccion_Curso> findSeccionesCursoByCursoId(Integer curso_id);
	    public List<Categoria> findAllCategorias();
	    public List<Contenido> findContenidoBySeccionId(Integer seccion_Curso);
	    public List<Contenido> finAllContenidoById(Integer contenido_id);
	    public List<Contenido> findContenidoByCursoId(Integer curso_id );
	    //public List<CreadorU>  findCreadorById(Integer id);
	    public Optional<CreadorU> get(Integer id);
 	    /// UPDATE
	    public Curso updateCurso(Integer idCurso, Curso curso);
	    public Curso updateVistaCurso(Integer idCurso, Integer visualizacion);
	   /// public List<Seccion_Curso> findSeccionesByCursoId(Integer cursoId);
	    public Seccion_Curso updateSeccionCurso(Integer idSeccionCurso, Seccion_Curso seccionCurso);
	    public Contenido updateContenido(Integer idContenido, Contenido contenido);


	}
