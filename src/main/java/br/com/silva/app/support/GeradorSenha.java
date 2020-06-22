package br.com.silva.app.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

    private static final Logger log = LoggerFactory.getLogger(GeradorSenha.class);

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info(encoder.encode("test1"));
    }
}

