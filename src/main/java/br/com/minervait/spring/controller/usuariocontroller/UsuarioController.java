package br.com.minervait.spring.controller.usuariocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minervait.spring.model.Usuario;
import br.com.minervait.spring.service.usuarioservice.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/usuario")
	public ResponseEntity<?> registerNewUser(@RequestBody Usuario usuario) {
		final Long id = usuarioService.registerNewUser(usuario);
		return ResponseEntity.ok("O usuário foi registrado com sucesso! " + id);
	}

}
