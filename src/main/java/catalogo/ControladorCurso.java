package catalogo;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControladorCurso {
    
    @RequestMapping("/cursos")
    public ArrayList<Curso> index() throws SQLException {
        return new DAO().selectFrom();
    }
    
    @RequestMapping("/anadir")
    public void greeting(@RequestParam(value="act", defaultValue="false") String activo,
                         @RequestParam(value="tit", defaultValue="") String titulo,
                         @RequestParam(value="pro", defaultValue="") String profesor,
                         @RequestParam(value="niv", defaultValue="Basico") String nivel,
                         @RequestParam(value="hor", defaultValue="5") String horas
    ) throws NumberFormatException, SQLException {
    	new DAO().insertInto(Boolean.parseBoolean(activo), titulo, profesor, nivel, Integer.parseInt(horas));
    }
}
