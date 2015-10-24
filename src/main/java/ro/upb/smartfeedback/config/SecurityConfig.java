//package template.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//
//import javax.sql.DataSource;
//
///**
// * Created by Madalin.Colezea on 6/24/2015.
// * Asigura autentificarea prin baza de data configurata in DataSourceConfig
// * Preconditii:
// *  - baza de date contine o tabele users(username, password, enables)
// *  - baza de data contine o tabela user_roles(user_role_id, username(->users), role)
// */
//@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    /*
//    * Configurare autentificare prin baza de date
//     */
////    @Autowired
////    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
////
////        auth.jdbcAuthentication().dataSource(dataSource)
////                .usersByUsernameQuery(
////                        "select username,password, enabled from users where username=?")
////                .authoritiesByUsernameQuery(
////                        "select username, role from user_roles where username=?");
////    }
//
//    /*
//    * Configurare restrictionare rute in functie de url si rolul utilizatorului
//    * TODO in functie de necesitatile aplicatiei
//    * */
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/login").permitAll()
////                .anyRequest().authenticated()
////                .and().formLogin().loginPage("/login").and().csrf();
////                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
////                .and()
////                .formLogin().loginPage("/login").failureUrl("/login?error")
////                .usernameParameter("username").passwordParameter("password")
////                .and()
////                .logout().logoutSuccessUrl("/login?logout")
////                .and()
////                .exceptionHandling().accessDeniedPage("/403")
////                .and()
////                .csrf();
////    }
//}
