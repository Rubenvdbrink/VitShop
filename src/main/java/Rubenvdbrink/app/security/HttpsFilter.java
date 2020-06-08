package Rubenvdbrink.app.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
//uncomment later
public class HttpsFilter extends HttpFilter {
    private static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";
    private static final String HSTS = "Strict-Transport-Security";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getHeader(X_FORWARDED_PROTO) != null) {
            if (req.getHeader(X_FORWARDED_PROTO).equals("http")) {
                var requestedURL = req.getRequestURL().toString();
                res.sendRedirect(requestedURL.replace("http://", "https://"));
            } else
                res.setHeader(HSTS, "max-age=31536000; includeSubDomains");
        }
        chain.doFilter(req, res);
    }
}
