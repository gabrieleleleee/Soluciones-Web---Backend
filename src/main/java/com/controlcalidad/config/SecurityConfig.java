package com.controlcalidad.config;

import com.controlcalidad.filter.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Configuracion central de Spring Security.
 * - /auth/login es publica (no requiere token)
 * - Cada modulo tiene rutas protegidas por autoridad MODULO_<nombre>
 * - Administradores (ROL_ID_1 / MODULO_ADMIN) acceden a todo
 * - Sin sesion HTTP (STATELESS): cada request lleva su propio token
 * - Contrasenas encriptadas con BCrypt
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter,
                          UserDetailsService userDetailsService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()

                // ADMIN: solo usuarios con rol admin
                .requestMatchers("/roles/**", "/usuarios/**", "/permisos/**",
                                 "/bitacora-auditoria/**", "/capacitaciones/**")
                    .hasAnyAuthority("ROL_ID_1", "MODULO_ADMIN")

                // PRODUCTOS: supervisor y admin
                .requestMatchers("/productos/**", "/categorias/**", "/lotes/**",
                                 "/unidades-medida/**")
                    .hasAnyAuthority("ROL_ID_1", "MODULO_ADMIN", "MODULO_PRODUCTOS")

                // CALIDAD: inspector de calidad y admin
                .requestMatchers("/estandares/**", "/defectos/**", "/motivos-rechazo/**",
                                 "/alertas/**")
                    .hasAnyAuthority("ROL_ID_1", "MODULO_ADMIN", "MODULO_CALIDAD")

                // INSPECCION: inspector y admin
                .requestMatchers("/inspecciones/**", "/detalles-inspeccion/**",
                                 "/acciones-correctivas/**", "/devoluciones/**")
                    .hasAnyAuthority("ROL_ID_1", "MODULO_ADMIN", "MODULO_INSPECCION")

                // PRODUCCION: produccion y admin
                .requestMatchers("/materias-primas/**", "/proveedores/**",
                                 "/areas-produccion/**", "/maquinarias/**",
                                 "/historiales-mantenimiento/**")
                    .hasAnyAuthority("ROL_ID_1", "MODULO_ADMIN", "MODULO_PRODUCCION")

                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
