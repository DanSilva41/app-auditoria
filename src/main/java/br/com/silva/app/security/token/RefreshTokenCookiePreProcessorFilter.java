package br.com.silva.app.security.token;

import org.apache.catalina.util.ParameterMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreProcessorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (StringUtils.isNotBlank(req.getRequestURI()) &&
                req.getRequestURI().contains(TokenConstantes.URI_OAUTH_TOKEN)
                && TokenConstantes.REFRESH_TOKEN_GRANT_TYPE.equalsIgnoreCase(req.getParameter(TokenConstantes.GRANT_TYPE))
                && req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals(TokenConstantes.REFRESH_TOKEN_COOKIE_NAME)) {
                    String refreshToken = cookie.getValue();
                    req = new MyServletRequestWrapper(req, refreshToken);
                }
            }
        }

        chain.doFilter(req, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    static class MyServletRequestWrapper extends HttpServletRequestWrapper {

        private String refreshToken;

        public MyServletRequestWrapper(HttpServletRequest request, String refreshToken) {
            super(request);
            this.refreshToken = refreshToken;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
            map.put(TokenConstantes.REFRESH_TOKEN_GRANT_TYPE, new String[]{refreshToken});
            map.setLocked(true);
            return map;
        }
    }
}

