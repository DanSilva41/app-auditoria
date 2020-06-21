package br.com.silva.app.security.token;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CustomJwtTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Optional<String> username = Optional.ofNullable(authentication.getName());

        username.ifPresent(u -> {
            Map<String, Object> additionalInfo = new HashMap<>();
            additionalInfo.put("username", u);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            String encoded = super.encode(accessToken, authentication);
            ((DefaultOAuth2AccessToken) accessToken).setValue(encoded);
        });
        return accessToken;
    }

}

