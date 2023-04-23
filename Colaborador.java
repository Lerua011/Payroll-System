public class Colaborador {
    // Atributos
    private String nombre;
    private String cedula;
    private double salario;
  
    // Constructor
    public Colaborador(String nombre, String cedula, double salario) {
      this.nombre = nombre;
      this.cedula = cedula;
      this.salario = salario;
    }
  
    // Métodos
    public String getNombre() {
      return nombre;
    }
  
    public String getCedula() {
      return cedula;
    }
  
    public double getSalario() {
      return salario;
    }
  
    public void setNombre(String nombre) {
      this.nombre = nombre;
    }
  
    public void setCedula(String cedula) {
      this.cedula = cedula;
    }
  
    public void setSalario(double salario) {
      this.salario = salario;
    }
  }