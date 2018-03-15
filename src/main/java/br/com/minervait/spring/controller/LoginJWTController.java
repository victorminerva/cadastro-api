package br.com.minervait.spring.controller;

import java.util.ArrayList;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minervait.spring.model.Usuario;
import br.com.minervait.spring.service.loginjwtservice.LoginJWTService;
import br.com.minervait.spring.utils.TokenJWTUtil;

@RestController
public class LoginJWTController {

	@Autowired
	LoginJWTService loginJWTService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@FormParam("username") String username,
			@FormParam("password") String password) {
		Usuario usuario = validateCredentials(username, password);

		String token = TokenJWTUtil.gerarToken(usuario.getUsuarioNome(), new ArrayList<String>());
		return ResponseEntity.ok().header("Authorization", "Bearer " + token).build();
	}

	private Usuario validateCredentials(String username, String password) {
		Usuario usuario = loginJWTService.retrieveUserWithUsernameAndPassword(username, password);
		return usuario;
	}

}
