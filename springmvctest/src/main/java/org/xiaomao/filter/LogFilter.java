package org.xiaomao.filter;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter Initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String address = request.getRemoteAddr();
        String host = request.getRemoteHost();
        System.out.println("Address: " + address);
        System.out.println("Host: " + host);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter Destroy.");
    }
}
