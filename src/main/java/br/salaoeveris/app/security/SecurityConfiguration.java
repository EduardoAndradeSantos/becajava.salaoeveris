//package br.salaoeveris.app.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import br.salaoeveris.app.service.AutenticacaoService;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private AutenticacaoService AutenticacaoService;
//	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	@Bean
//	protected AuthenticationManager authenticationManager() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManager();
//	}
//
//	// Configuração de autenticação
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(AutenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
//
//	}
//
//	// Configuração de autorização
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers(HttpMethod.GET).permitAll()
//				.antMatchers(HttpMethod.GET, "/clientes/*").permitAll()
//				.antMatchers(HttpMethod.POST, "/auth").permitAll()
//				.anyRequest().authenticated()
//				.and().csrf().disable()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//				//avisa que não vai criar sessão
//	}
//
//	// Configurações de recursos estaticos
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	}
//
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
//	}
//	
//	
//}