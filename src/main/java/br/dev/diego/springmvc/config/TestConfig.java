package br.dev.diego.springmvc.config;

import br.dev.diego.springmvc.domain.*;
import br.dev.diego.springmvc.domain.enums.EstadoPagamento;
import br.dev.diego.springmvc.domain.enums.TipoCliente;
import br.dev.diego.springmvc.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException{
        dbService.instantiateTestDatabase();
        return true;
    }

}
