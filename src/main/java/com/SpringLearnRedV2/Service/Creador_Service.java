package com.SpringLearnRedV2.Service;

import java.util.List;

import com.SpringLearnRedV2.Model.Categoria;
import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.CreadorU;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Seccion_Curso;

 
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

	    public List<Seccion_Curso> findSeccionesCursoByCursoId(Integer curso_id);
	    public List<Categoria> findAllCategorias();
	    public List<Contenido> findContenidoBySeccionId(Integer seccion_Curso);
	    public List<Contenido> finAllContenidoById(Integer contenido_id);
	    public List<Contenido> findContenidoByCursoId(Integer curso_id );
 	    /// UPDATE
	    public Curso updateCurso(Integer idCurso, Curso curso);
	   /// public List<Seccion_Curso> findSeccionesByCursoId(Integer cursoId);
	    public Seccion_Curso updateSeccionCurso(Integer idSeccionCurso, Seccion_Curso seccionCurso);
	    public Contenido updateContenido(Integer idContenido, Contenido contenido);


	}
