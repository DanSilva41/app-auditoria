package br.com.silva.app.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.security")
@Getter
@Setter
@ToString
public class AppSecurityConfig {
    private AppPermitRequestsConfig permitRequests;

    @Getter
    @Setter
    @ToString
    public static class AppPermitRequestsConfig {
        private List<String> matchersAll;
        private List<String> matchersGet;

        public List<String> builderPermitAll() {
            List<String> result = new ArrayList<>();
            if (matchersAll != null) {
                result.addAll(matchersAll);
            }
            return result;
        }

        public List<String> builderPermitGet() {
            List<String> result = new ArrayList<>();
            if (matchersGet != null) {
                result.addAll(matchersGet);
            }
            return result;
        }


        @Getter
        @Setter
        @ToString
        public static class AppMatchersPermitRequestsConfig {
            private List<String> matchersAll;
            private List<String> matchersGet;
        }
    }

}
