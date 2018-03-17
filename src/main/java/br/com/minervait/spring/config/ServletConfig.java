package br.com.minervait.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.minervait.spring.controller.pessoacontroller.PessoaController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { PessoaController.class })
public class ServletConfig extends WebMvcConfigurerAdapter {

}
