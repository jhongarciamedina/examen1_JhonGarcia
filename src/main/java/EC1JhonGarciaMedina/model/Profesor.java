package EC1JhonGarciaMedina.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Profesor")
@Entity
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	
	@Column(name = "profesor")
	private String profesor;
	
	@ManyToMany
	@JoinTable(name = "profesorCurso",
	joinColumns = @JoinColumn(name ="id_curso",
	nullable  = false, unique = true, 
	foreignKey  = @ForeignKey(foreignKeyDefinition  = "foreign key(id_curso) references Curso (id_curso)")),
	inverseJoinColumns  =
	@JoinColumn(
	name="id_profesor",
	nullable = false,
	unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition  = "foreign key(id_profesor) references Profesor (id_profesor)")))
	private List<Curso> curso;

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	
	

}
