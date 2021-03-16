package com.exampleTecnocode.tecnocode.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exampleTecnocode.tecnocode.exception.ErroAutenticacao;
import com.exampleTecnocode.tecnocode.exception.RegraNegocioException;
import com.exampleTecnocode.tecnocode.model.entity.Usuario;
import com.exampleTecnocode.tecnocode.model.repository.UsuarioRepository;
import com.exampleTecnocode.tecnocode.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);

		if (!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado");
		}

		if (usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha Inválida");

		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe usuário cadastrado com esse e-mail");
		}

	}

}
