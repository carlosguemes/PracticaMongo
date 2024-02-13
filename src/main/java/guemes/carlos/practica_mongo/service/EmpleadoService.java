package guemes.carlos.practica_mongo.service;

import guemes.carlos.practica_mongo.jpa.Empleados;

import java.util.List;

public interface EmpleadoService {

    public Empleados findByEmpNo(String empleadoNo);
    public List<Empleados> findAll();
    public int saveEmpleado(Empleados empleado);
    public int saveAll(List<Empleados> empleado);
    public List<Empleados> findByNombre(String name);
    public List<Empleados> findBySalarioGreaterThan(Float salario);
    public Empleados updateEmpleado(String emp_no, String nombre, String apellidos);
    public int deleteEmpleado (String id);
}
