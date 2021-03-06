import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String method = httpRequest.getMethod();
        String url = String.valueOf(httpRequest.getRequestURL());

        System.out.printf("Method: %s, url: %s, duration: %dms%n", method, url, end - start);
    }

    @Override
    public void destroy (){

    }
}