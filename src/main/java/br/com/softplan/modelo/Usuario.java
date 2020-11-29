package br.com.softplan.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj != null;
		result = result && getClass().isInstance(obj);
		result = result && hashCode() > 0;
		result = result && obj.hashCode() > 0;
		result = result && hashCode() == obj.hashCode();
		return result;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : super.hashCode();
	}

}