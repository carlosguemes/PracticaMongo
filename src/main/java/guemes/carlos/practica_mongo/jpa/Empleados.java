package guemes.carlos.practica_mongo.jpa;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document("empleados")
public class Empleados implements Serializable {

    private static final long serialVersionUID = -1169233562062703758L;
    @Id
    private String empNo;
    private String nombre;
    private String apellido;
    private String oficio;
    private String direccion;
    private String fechaAlta;
    private Float salario;
    private Float comision;

    private int calculo;

    @JsonProperty("departamentos")
    private Departamentos departamentos;

    //Este constructor es obligatorio para que MongoDB pueda crear un Document de este tipo y asignarle
    //valor a sus atributos
    public Empleados() {
    }


    @JsonCreator
    public Empleados(@JsonProperty("empNo")String empNo, @JsonProperty("nombre")String nombre,
                     @JsonProperty("apellido")String apellido, @JsonProperty("salario")Float salario) {
        this.empNo = empNo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmpNo() {
        return empNo;
    }


    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public Float getSalario() {
        return salario;
    }


    public void setSalario(Float salario) {
        this.salario = salario;
    }


    public int getCalculo() {
        return calculo;
    }


    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }


    public Departamentos getDepartamentos() {
        return departamentos;
    }


    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }


    public String getOficio() {
        return oficio;
    }


    public void setOficio(String oficio) {
        this.oficio = oficio;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getFechaAlta() {
        return fechaAlta;
    }


    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    public Float getComision() {
        return comision;
    }


    public void setComision(Float comision) {
        this.comision = comision;
    }

}
