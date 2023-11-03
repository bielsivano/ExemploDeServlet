package br.com.ibm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {
    private List<String> usuariosAtivos;
    private List<String> usuariosInativos;
    private List<String> administradores;

    @Override
    public void init() throws ServletException {
        usuariosAtivos = new ArrayList<>();
        usuariosAtivos.add("Gabriel");
        usuariosAtivos.add("Yan");
        usuariosAtivos.add("Glauber");

        usuariosInativos = new ArrayList<>();
        usuariosInativos.add("Felipe");
        usuariosInativos.add("carlos");

        administradores = new ArrayList<>();
        administradores.add("Maria");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("usuariosAtivos", usuariosAtivos);
        request.setAttribute("usuariosInativos", usuariosInativos);
        request.setAttribute("administradores", administradores);

        request.getRequestDispatcher("/listaUsuarios.jsp").forward(request, response);
    }
}



