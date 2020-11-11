//package br.salaoeveris.app.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.security.core.GrantedAuthority;
//
//@Entity
//public class Perfil implements GrantedAuthority {
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private static final long serialVersionUID = 1L;
//	private String nome;
//	
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	@Override
//	public String getAuthority() {
//		return nome;
//	}
//	
//}