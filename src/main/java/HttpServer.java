import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

public class HttpServer {
    private final Server server = new Server(8181);

    public void start() throws Exception {
        Resource resource = Resource.newClassPathResource("/website");
        WebAppContext handler = new WebAppContext(resource, "/");

        handler.addServlet(new ServletHolder(new MyServlet()), "/api");
        server.setHandler(handler);

        server.start();
    }
}
