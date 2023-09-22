import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder response = new StringBuilder();

        if (AnimalRepository.getAnimalsMap().isEmpty()) {
            response.append("No animals here :(");
        } else {
            AnimalRepository.getAnimalsMap().forEach((key, value) ->
                response.append(String.format("%s. %s named %s \r\n", key, value.getType().toString(), value.getName()))
            );
        }

        resp.getWriter().write(response.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String type = req.getParameter("type");
        String name = req.getParameter("name");

        AnimalRepository.addAnimal(AnimalType.valueOf(type.toUpperCase()), name);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        AnimalRepository.changeAnimalName(id, name);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        AnimalRepository.removeAnimal(id);
    }
}
