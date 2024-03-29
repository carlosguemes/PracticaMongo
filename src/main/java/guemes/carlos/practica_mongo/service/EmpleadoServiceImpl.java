package guemes.carlos.practica_mongo.service;

import guemes.carlos.practica_mongo.jpa.Empleados;
import guemes.carlos.practica_mongo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleados findByEmpNo(String empleadoNo) {
        return empleadoRepository.findByEmpNo(empleadoNo);
    }

    @Override
    public List<Empleados> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public int saveEmpleado(Empleados empleado) {
        //La base de datos configurada en application.properties se creará cuando se ha
        Empleados result = empleadoRepository.save(empleado);
        return null==result?0:1;
    }

    @Override
    public int saveAll(List<Empleados> empleado) {
        //La base de datos configurada en application.properties se creará cuando se ha
        int result = 0;
        for (Empleados listaEmpleados : empleado) {
            empleadoRepository.save(listaEmpleados);
            result ++;
        }
        return result;
    }
    @Override
    public List<Empleados> findByNombre(String name) {
        return empleadoRepository.findByNombre(name);
    }

    @Override
    public List<Empleados> findBySalarioGreaterThan(Float salario) {
        return empleadoRepository.findAllSalarioGreaterThan(salario);
    }

    @Override
    public Empleados updateEmpleado(String emp_no, String nombre, String apellidos) {
        Empleados empleado = null;
        //Variable para saber si el empleado ha sido encontrado
        boolean encontrado = true;

        //Intentamos encontrar el empleado con el id pasado por parámetro
        try{
            empleado = empleadoRepository.findById(emp_no).get();

        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            encontrado = false;
        }

        //Si ha encontrado al empleado se actualiza y se devuelve al empleado
        if (encontrado){
            empleado.setNombre(nombre);
            empleado.setApellido(apellidos);
            System.out.println("Nombre actualizado: " + empleado.getNombre());
            return empleado;
        }

        //Si no lo encuentra devolverá null, por lo que no se actualizará
        else
            return null;
    }

    @Override
    public int deleteEmpleado(String id) {
        Empleados empleado = null;
        //Variable para saber si el empleado ha sido encontrado
        boolean encontrado = true;

        //Intentamos encontrar el empleado con el id pasado por parámetro
        try{
            empleado = empleadoRepository.findById(id).get();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            encontrado = false;
        }

        //Si ha encontrado al empleado se elimina y se devuelve un número positivo
        if (encontrado){
            empleadoRepository.delete(empleado);
            return 1;
        }

        //Si no lo encuentra devolverá un número negativo, por lo que no se borrará
        else
            return -1;
    }
}
