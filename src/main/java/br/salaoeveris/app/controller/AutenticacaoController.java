//package br.salaoeveris.app.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.salaoeveris.app.request.LoginRequest;
//
//@RestController
//@RequestMapping("/auth")
//public class AutenticacaoController {
//
//	@Autowired
//	private AuthenticationManager authManager;
//	
//	@PostMapping
//	public ResponseEntity<?> autenticar(@RequestBody @Validated LoginRequest form){
//		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
//		Authentication authentication = authManager.authenticate(dadosLogin);
//		
//		return ResponseEntity.ok().build();
//	}
//}
