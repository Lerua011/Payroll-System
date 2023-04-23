public class Bonificaciones {
    // Atributos
    private double comisiones;
    private double incentivo;
  
    // Constructor
    public Bonificaciones(double comisiones, double incentivo) {
      this.comisiones = comisiones;
      this.incentivo = incentivo;
    }
  
    // Métodos
    public double getComisiones() {
      return comisiones;
    }
  
    public double getIncentivo() {
      return incentivo;
    }
  
    public void setComisiones(double comisiones) {
      this.comisiones = comisiones;
    }
  
    public void setIncentivo(double incentivo) {
      this.incentivo = incentivo;
    }
  }