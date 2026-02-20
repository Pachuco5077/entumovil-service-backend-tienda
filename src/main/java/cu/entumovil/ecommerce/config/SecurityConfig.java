package cu.entumovil.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOriginPattern("*"); // permite cualquier origen
		configuration.addAllowedMethod("*");        // permite cualquier método (GET, POST, etc.)
		configuration.addAllowedHeader("*");        // permite cualquier header
		configuration.setAllowCredentials(true);    // permite cookies / Authorization headers

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authz -> authz
						.anyRequest().permitAll()
				)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();

	}

	/*@Autowired
	private JwtAuthenticationConverter jwtAuthenticationConverter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests (http -> http
						.requestMatchers(
								"/payment/login",
								"/checkout/newPay",
								"/payment/savePay",
								"/payment/all",
								"/payment/{id}",
								"/payment/finalizados",
								"/payment/pendientes",
								"/payment/countries",
								"/admin/login",
								"/admin/newPay",
								"/admin/savePay",
								"/admin/all",
								"/admin/{id}",
								"/admin/finalizados",
								"/admin/pendientes",
								"/admin/countries",
								"/checkout/user/login",
								"/checkout/user/newPay",
								"/checkout/user/savePay",
								"/checkout/user/all/{user}",
								"/checkout/user/all",
								"/checkout/user/{id}",
								"/checkout/user/finalizados/{user}",
								"/checkout/user/pendientes/{user}",
								"/checkout/user/countries"
								)
						.permitAll()
						//.anyRequest().authenticated()
						)
				.oauth2ResourceServer(oauth -> 
				{oauth.jwt(jwt -> jwt
						.jwtAuthenticationConverter(jwtAuthenticationConverter));
				})
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}*/


}
