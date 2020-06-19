package br.com.silva.app.security.token;

import br.com.silva.app.rest.dto.UsuarioDTO;
import br.com.silva.app.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Component
public class CustomJwtTokenConverter extends JwtAccessTokenConverter {

    private UsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String login = authentication.getName().split(";")[0];
        Optional<UsuarioDTO> usuarioRetornado = usuarioService.buscarPorUsername(login);

        usuarioRetornado.ifPresent(u -> {
            Map<String, Object> additionalInfo = new HashMap<>();
            additionalInfo.put("username", u.getUsername());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            String encoded = super.encode(accessToken, authentication);
            ((DefaultOAuth2AccessToken) accessToken).setValue(encoded);
        });
        return accessToken;
    }

}

