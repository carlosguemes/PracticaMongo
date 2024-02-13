package guemes.carlos.practica_mongo.repository;

import java.util.List;

import guemes.carlos.practica_mongo.jpa.Empleados;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface EmpleadoRepository extends MongoRepository<Empleados, String> {
    //https://www.mongodb.com/compatibility/spring-boot
    //https://www.baeldung.com/queries-in-spring-data-mongodb

    Empleados findByEmpNo(String empNo);

    @Query(value = "{ 'nombre' : ?0 }")
    List<Empleados> findByNombre(String nombre);

    @Query(value="{'salario':{ $gt: ?0}}", fields="{'empNo':1, 'nombre':1, 'apellido':1}")
    List<Empleados> findAllSalarioGreaterThan(Float salario);


}
