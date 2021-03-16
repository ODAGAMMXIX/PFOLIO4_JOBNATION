package com.exampleTecnocode.tecnocode.service;

import com.exampleTecnocode.tecnocode.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);

}
