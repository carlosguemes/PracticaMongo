package guemes.carlos.practica_mongo.demo;

import java.util.List;
import java.util.Map;

import guemes.carlos.practica_mongo.jpa.Empleados;
import guemes.carlos.practica_mongo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApplicationController {

    //Inyección del Servicio.
    @Autowired
    private EmpleadoService empleadoService;


    @GetMapping(value="find/{idEmpleado}/nombre/{nombre}")
    public boolean findById2(@PathVariable("idEmpleado")String idEmpleado,
                             @PathVariable("nombre") String nombre) {
        Empleados empleado = null;
        System.out.println("findById2: " + idEmpleado);
        System.out.println("findById2: " + nombre);
        empleado = empleadoService.findByEmpNo(idEmpleado);
        return (null!=empleado) && nombre.equals(empleado.getNombre());
    }


    @GetMapping(value="findAll")
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
        String id = (String) requestBody.get("_id");
        String emp_no = (String) requestBody.get("empNo");
        String nombre = (String) requestBody.get("nombre");
        String apellido = (String) requestBody.get("apellido");
        //int calculo = ((Number) requestBody.get("calculo")).intValue();

        Empleados emp = empleadoService.updateEmpleado(id, emp_no, nombre, apellido);

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

    }

}

