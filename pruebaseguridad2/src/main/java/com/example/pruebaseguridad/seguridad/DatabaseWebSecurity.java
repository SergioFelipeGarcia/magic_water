package com.example.pruebaseguridad.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class DatabaseWebSecurity  {


    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select NIF, password, activo from Usuario where NIF=?");
        users.setAuthoritiesByUsernameQuery("SELECT  NIF, permiso FROM Usuario WHERE NIF=?");
        return users;
    }

    // Filtros por URL.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/imagenes/**").permitAll()
                .requestMatchers("/", "/login", "/signup").permitAll()
                .requestMatchers("/tarea").hasAnyAuthority("trabajador", "supervisor")
                .requestMatchers("/proyecto").hasAuthority("supervisor")
                .requestMatchers("tareas/editartarea").hasAuthority("trabajador")
                .requestMatchers("tareas/nueva_tarea").hasAuthority("trabajador")
                .anyRequest().authenticated());
        http.formLogin(formLogin -> formLogin.loginPage("/login").permitAll());
        http.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());
        http.exceptionHandling((exception)-> exception.accessDeniedPage("/denegado"));

        return http.build();
    }
}
