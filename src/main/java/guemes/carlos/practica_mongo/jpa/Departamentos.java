package guemes.carlos.practica_mongo.jpa;

public class Departamentos implements java.io.Serializable {

    private static final long serialVersionUID = -125852380724809251L;

    private byte deptNo;
    private String dnombre;
    private String loc;

    public Departamentos() {
    }

    public Departamentos(byte deptNo, String dnombre, String loc) {
        this.deptNo = deptNo;
        this.dnombre = dnombre;
        this.loc = loc;
    }

    public byte getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(byte deptNo) {
        this.deptNo = deptNo;
    }

    public String getDnombre() {
        return this.dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}
