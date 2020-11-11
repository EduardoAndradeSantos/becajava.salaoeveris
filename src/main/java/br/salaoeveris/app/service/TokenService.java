//package br.salaoeveris.app.service;
//
//import java.util.Date;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import br.salaoeveris.app.model.Usuario;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Service
//public class TokenService {
//
//	public String gerarToken(Authentication authentication) {
//		Usuario logado = (Usuario) authentication.getPrincipal();
//		
//		Date hoje = new Date();
//		Date dataExpiracao = new Date(hoje.getTime() + 86400000);
//		String secret = "tercessireveoalasetset";
//	
//		return Jwts.builder()
//				.setId("API Salão Everis")
//				.setSubject(logado.getId().toString())
//				.setIssuedAt(hoje)
//				.setExpiration(dataExpiracao)
//				.signWith(SignatureAlgorithm.HS256, secret)
//				.compact();
//	}
//
//}