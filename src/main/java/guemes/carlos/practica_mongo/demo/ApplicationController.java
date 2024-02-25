package guemes.carlos.practica_mongo.demo;

import java.util.List;
import java.util.Map;

import guemes.carlos.practica_mongo.jpa.Empleados;
import guemes.carlos.practica_mongo.jpa.Movies;
import guemes.carlos.practica_mongo.service.EmpleadoService;
import guemes.carlos.practica_mongo.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApplicationController {

    //Inyección del Servicio.
    /*@Autowired
    private EmpleadoService empleadoService;*/

    @Autowired
    private MoviesService moviesService;


    /*@GetMapping(value="find/{idEmpleado}/nombre/{nombre}")
    public boolean findById2(@PathVariable("idEmpleado")String idEmpleado,
                             @PathVariable("nombre") String nombre) {
        Empleados empleado = null;
        System.out.println("findById2: " + idEmpleado);
        System.out.println("findById2: " + nombre);
        empleado = empleadoService.findByEmpNo(idEmpleado);
        return (null!=empleado) && nombre.equals(empleado.getNombre());
    }


    /*@GetMapping(value="findAll")
    public List<Empleados> findAll() {
        System.out.println("findAll");
        return empleadoService.findAll();
    }

    @PostMapping(value="saveOne")
    public int saveEmpleado(@RequestBody Empleados empleado) {
        System.out.println("saveEmpleado");
        return empleadoService.saveEmpleado(empleado);
    }

    @PostMapping(value="saveAll")
    public int saveEmpleado(@RequestBody List<Empleados> empleado) {
        System.out.println("saveAll");
        return empleadoService.saveAll(empleado);
    }

    // Postman:localhost:8081/find/salario/1000
    @GetMapping(value="find/salario/{salario}")
    public List<Empleados> findBySalarioMayor(@PathVariable("salario") Float salario) {
        System.out.println("findById2: " + salario);
        return empleadoService.findBySalarioGreaterThan(salario);
    }

    // Postman:localhost:8081/find/nombre/Pepe
    @GetMapping(value="find/nombre/{nombre}")
    public List<Empleados> findByNombre(@PathVariable("nombre") String nombre) {
        System.out.println("findById2: " + nombre);
        return empleadoService.findByNombre(nombre);
    }

    // Postman:localhost:8082/updateEmpleado
    @PutMapping(value="updateEmpleado")
    public String updateEmpleado(@RequestBody Map<String, Object> requestBody){
        int result = -2;
        String emp_no = (String) requestBody.get("empNo");
        String nombre = (String) requestBody.get("nombre");
        String apellido = (String) requestBody.get("apellido");
        //int calculo = ((Number) requestBody.get("calculo")).intValue();

        Empleados emp = empleadoService.updateEmpleado(emp_no, nombre, apellido);

        try{
            result = empleadoService.saveEmpleado(emp);
        }
        catch (Exception e){
            return "No se ha podido encontrar al empleado con el ID proporcionado";
        }

        if (result == 1){
            return "Empleado actualizado correctamente";
        }

        else
            return "No se ha podido actualizar el empleado";

    }


    // Postman:localhost:8082/updateEmpleado
    @DeleteMapping(value="deleteEmpleado")
    public String deleteEmpleado(@RequestBody Map<String, Object> requestBody){
        int result = -2;
        String id = (String) requestBody.get("_id");

        try{
            result = empleadoService.deleteEmpleado(id);
        }
        catch (Exception e){
            return "No se ha podido encontrar al empleado con el ID proporcionado";
        }

        if (result == 1){
            return "Empleado eliminado correctamente";
        }

        else
            return "No se ha podido eliminar al empleado";

    }*/


    //MOVIES


    // Postman:localhost:8082/movies/findAll
    @GetMapping(value="movies/findAll")
    public List<Movies> findAll() {
        System.out.println("findAll");
        return moviesService.findAll();
    }

    @GetMapping(value="movies/findByTitle")
    public String findByTitle(@RequestBody Map<String, Object> requestBody){
        String titulo = (String) requestBody.get("title");
        boolean encontrado = true;

        Movies pelicula = null;

        try{
            pelicula = moviesService.findByTitle(titulo);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        if (pelicula != null)
            return pelicula.toString();

        else
            return "No se ha podido encontrar una película con el título indicado";
    }

    // Postman:localhost:8082/movies/findByGenres
    @GetMapping(value="movies/findByGenres")
    public String findByGenres(@RequestBody Map<String, Object> requestBody) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        List<String> generos = (List<String>) requestBody.get("genres");

        List<Movies> peliculas = moviesService.findByGenres(generos);

        if (peliculas == null || peliculas.isEmpty())
            sb.append("No se ha podido encontrar una película con ese o esos géneros");

        else{
            for (Movies pelicula: peliculas){
                sb.append("Película " + i++ + ": \n");
                sb.append(pelicula.toString());
                sb.append("\n\n");
            }
        }
        return sb.toString();
    }

    //Postman: localhost:8082/movies/updatePelicula
    @PutMapping(value="movies/updatePelicula")
    public String updatePelicula(@RequestBody Map<String, Object> requestBody){
        int result = -2;
        String id = (String) requestBody.get("id");
        String titulo = (String) requestBody.get("title");
        int anyo = ((Number) requestBody.get("year")).intValue();

        Movies pelicula = moviesService.updatePelicula(id, titulo, anyo);

        try{
            result = moviesService.savePelicula(pelicula);
        }
        catch (Exception e){
            return "No se ha podido encontrar la película con el ID proporcionado";
        }

        if (result == 1){
            return "Película actualizado correctamente";
        }

        else
            return "No se ha podido actualizar la película";

    }

    // Postman:localhost:8082/updateEmpleado
    @DeleteMapping(value="movies/deletePelicula")
    public String deletePelicula(@RequestBody Map<String, Object> requestBody){
        int result = -2;
        String id = (String) requestBody.get("id");

        try{
            result = moviesService.deletePelicula(id);
        }
        catch (Exception e){
            return "No se ha podido encontrar la película con el ID proporcionado";
        }

        if (result == 1){
            return "Película eliminada correctamente";
        }

        else
            return "No se ha podido eliminar la película";

    }
}

