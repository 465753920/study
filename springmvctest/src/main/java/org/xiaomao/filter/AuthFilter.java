package org.xiaomao.filter;

import javax.servlet.*;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter Initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Auth success.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("AuthFilter Destroy.");
    }
}
