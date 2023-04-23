public class Deducciones {
    // Atributos
    private double asociacion;
    private double ahorro;
    private double rebajo;
  
    // Constructor
    public Deducciones(double asociacion, double ahorro, double rebajo) {
      this.asociacion = asociacion;
      this.ahorro = ahorro;
      this.rebajo = rebajo;
    }
  
    // Métodos
  
    public double getAsociacion() {
      return asociacion;
    }
  
    public double getAhorro() {
      return ahorro;
    }

    public double getRebajo() {
      return rebajo;
    }
    
  
    public void setAsociacion(double asociacion) {
      this.asociacion = asociacion;
    }

    public void setRebajo(double rebajo) {
      this.rebajo = rebajo;
    }
  
    public void setAhorro(double ahorro) {
      this.ahorro = ahorro;
    }
  }