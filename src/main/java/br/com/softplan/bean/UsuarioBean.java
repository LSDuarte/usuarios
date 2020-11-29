package br.com.softplan.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softplan.dao.Dao;
import br.com.softplan.modelo.Usuario;
import br.com.softplan.util.JSFUtil;

/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salvar() {
		new Dao<Usuario>(Usuario.class).adiciona(this.usuario);
		JSFUtil.adicionarMensagemSucesso("Adicionado novo usuário!", null);
		JSFUtil.adicionarMensagemSucesso("Usuário: " + usuario.getNome(), null);
		JSFUtil.adicionarMensagemSucesso("E-mail: " + usuario.getEmail(), null);
		this.usuario = new Usuario();
	}

}