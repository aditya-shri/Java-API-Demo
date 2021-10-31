package com.abc.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UriFilter",urlPatterns = "/*")
public class URIFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        System.out.println("In URIFilter : " + uri);
        if(uri.equalsIgnoreCase("/") ||
                uri.equalsIgnoreCase("/error") ||
                uri.equalsIgnoreCase("/user") ||
                uri.equalsIgnoreCase("/order")){
            chain.doFilter(req,resp);
        }else{
            response.sendRedirect("/error");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}