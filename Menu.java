import java.util.Scanner;

public class Menu {
  public static void main(String[] args) {
   
    Scanner sc = new Scanner(System.in);
    int lenguaje = 0;

    do{ 

    System.out.println("Para español presione 1:");
    System.out.println("For english press 2:");

    if (!sc.hasNextInt()) {
      System.out.println("Opción no válida");
      System.out.println("Invalid option.");
      sc.next();
    }else{
    lenguaje= sc.nextInt();
      sc.nextLine();

    

    if (lenguaje == 1){

    
    Colaborador[] colaboradores = new Colaborador[10];
    Deducciones[] deduccion = new Deducciones[10];
    Bonificaciones[] bonificacion = new Bonificaciones[10];

    
    int opcion = 0;

   
    int contador = 0;
    int contador1 = 0;
    int contador2 = 0;
    int contraR=0;
    int contra1R=0;
    double ccss = 10.5;
    double rebajo = 0;
    double ahorro = 0;
    int limite1 = 941000;
    int limite2 = 1381000;
    int limite3 = 2423000;
    int limite4 = 4845000;


  
     do{ 
   
      System.out.println("Menú de opciones:");
      System.out.println("1. Añadir colaborador");
      System.out.println("2. Añadir deducción");
      System.out.println("3. Añadir bonificación");
      System.out.println("4. Mostrar planilla");
      System.out.println("5. Borrar datos ingresados");
      System.out.println("6. Modificar valores predeterminados");
      System.out.println("7. Salir");

     
      System.out.print("Ingrese la opción que desea: ");
      

      if (!sc.hasNextInt()) {
        System.out.println("Opción no válida");
        sc.next();
        }else{
      
      opcion = sc.nextInt();
      sc.nextLine();

      
      switch (opcion) {
        case 1:
         
          if (contador == 10) {
            
            System.out.println("No se pueden registrar más colaboradores.");
          } else {
           
            System.out.print("Ingrese el nombre del colaborador: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese la cédula del colaborador: ");
            String cedula = sc.nextLine();
            System.out.print("Ingrese el salario del colaborador: ");
            if (!sc.hasNextDouble()) {
              System.out.println("Opción no válida, vuelva a intentar");
              sc.next();
              break;
            }
            Double salario = sc.nextDouble();
          

          
            Colaborador colaborador = new Colaborador(nombre, cedula, salario);

          
            colaboradores[contador] = colaborador;

        
            contador++;

            
            System.out.println("Colaborador agregado con éxito.");
          }
          break;
        case 2:
        
          if (contador == contador1) {

            
            
            System.out.println("No hay ningún colaborador registrado en este espacio.");
          } else {
            
            Colaborador colaborador = colaboradores[contador1];
            if ( colaborador.getSalario() < limite1 ) {
              rebajo=0;
            }
            if ( colaborador.getSalario() >= limite1 && colaborador.getSalario() < limite2 ) {
              rebajo = (colaborador.getSalario()-limite1)*0.1; 
            }
            if ( colaborador.getSalario() >= limite2 && colaborador.getSalario() < limite3 ) {
              rebajo = ((colaborador.getSalario()-limite2)*0.15) + (limite2-limite1)*0.1;  
            }
            if ( colaborador.getSalario() >= limite3 && colaborador.getSalario() < limite4 ) {
              rebajo = ((colaborador.getSalario()-limite3)*0.2) + ((limite3-limite2)*0.15) + (limite2-limite1)*0.1;
            }
            if ( colaborador.getSalario() >= limite4 ) {
              rebajo = (colaborador.getSalario()-limite4)*0.25+((limite4-limite3)*0.2) + ((limite3-limite2)*0.15) + (limite2-limite1)*0.1;
            }

            System.out.println("Se están guardando las deducciones de " + colaborador.getNombre());
            System.out.println("El porcentaje de CCSS es de " + ccss);
            System.out.println("El rebajo de Hacienda es de " + rebajo);
            System.out.print("Ingrese el porcentaje de Asociación: ");
            if (!sc.hasNextDouble()) {
              System.out.println("Opción no válida, vuelva a intentar");
              sc.next();
              break;
            }
            double asociacion = sc.nextDouble();

            if ( asociacion > 0 ) {
              System.out.print("Ingrese el monto de Ahorro: ");
            
            if (!sc.hasNextDouble()) {
              System.out.println("Opción no válida, vuelva a intentar");
              sc.next();
              break;
            }
            ahorro = sc.nextDouble();
            }

          
          
          
            
            Deducciones deduccionones = new Deducciones(asociacion, ahorro, rebajo);

            deduccion[contador1] = deduccionones;
            
            contador1++;

            
            System.out.println("Deducción agregada con éxito.");
          }
          break;
        case 3:
         
          if (contador == 0) {

            
           
            System.out.println("No hay ningún colaborador registrado.");
          } else {
            Colaborador colaborador = colaboradores[contador2];
            System.out.println("Se están guardando las deducciones de " + colaborador.getNombre());
            System.out.print("Ingrese el porcentaje de las comisiones: ");
            if (!sc.hasNextDouble()) {
              System.out.println("Opción no válida, vuelva a intentar");
              sc.next();
              break;
            }
            double comisiones = sc.nextDouble();
            System.out.print("Ingrese el monto del incentivo: ");
            if (!sc.hasNextDouble()) {
              System.out.println("Opción no válida, vuelva a intentar");
              sc.next();
              break;
            }
            double incentivo = sc.nextDouble();

            Bonificaciones bonificaciones = new Bonificaciones(comisiones, incentivo);

            bonificacion[contador2] = bonificaciones;

            contador2++;
        }
        break;
        case 4:
  
if (contador == 0) {
   
    System.out.println("No hay ningún colaborador registrado.");
  } else {
   
    for (int i = 0; i < contador; i++) {
     
      Colaborador colaborador = colaboradores[i];
      Deducciones deducciones = deduccion[i];
      Bonificaciones bonificaciones = bonificacion[i];
  
      
      if (deducciones == null || bonificaciones == null) {
      
        System.out.println("No se han asignado las deducciones o las bonificaciones al colaborador " + colaborador.getNombre());
      } else {
    
        double salarioBruto = colaborador.getSalario() + ( colaborador.getSalario() * bonificaciones.getComisiones() / 100) + bonificaciones.getIncentivo();
  
       
        double salarioNeto = salarioBruto - (salarioBruto * ccss / 100) - (salarioBruto * deducciones.getAsociacion() / 100) - deducciones.getAhorro() - rebajo;
        double salarioNQ = salarioNeto/2;
  
       
        System.out.println("El salario neto mensual  del colaborador " + colaborador.getNombre() + " es: " + salarioNeto + " y el salario neto quincenal del colaborador " + colaborador.getNombre() + " es: " + salarioNQ);
      }
    }
  }
  break;
  case 5:
  System.out.print("Ingrese la contraseña para borrar los datos: ");
  if (!sc.hasNextInt()) {
    System.out.println("Contraseña incorrecta.");
    sc.next();
    break;
  }
  int contra = sc.nextInt();

  if (contra == contraR) {
  for ( int B=0; B<colaboradores.length; B++){
    colaboradores[B] = null;
    deduccion[B] = null;
    bonificacion[B] = null;
    contador = 0;
    contador1 = 0;
    contador2 = 0;
    }
  }else{
    System.out.println("Contraseña incorrecta.");
  }

  break;
  case 6:

  System.out.print("Ingrese la contraseña para modificar los datos: ");
  if (!sc.hasNextInt()) {
    System.out.println("Contraseña incorrecta.");
    sc.next();
    break;
  }
  int contra1 = sc.nextInt();


  if (contra1 == contra1R) {
  
  System.out.print("Ingrese el porcentaje de CCSS: ");
  if (!sc.hasNextDouble()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  ccss = sc.nextDouble();
  System.out.print("Ingrese el primer limite de salario: ");
  if (!sc.hasNextInt()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  limite1 = sc.nextInt();
  System.out.print("Ingrese el segundo limite de salario: ");
  if (!sc.hasNextInt()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  limite2 = sc.nextInt();
  System.out.print("Ingrese el tercer limite de salario: ");
  if (!sc.hasNextInt()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  limite3 = sc.nextInt();
  System.out.print("Ingrese el cuarto limite de salario: ");
  if (!sc.hasNextInt()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  limite4 = sc.nextInt();
  System.out.print("Ingrese la nueva contraseña para borrar los datos: ");
  if (!sc.hasNextInt()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  contraR = sc.nextInt();
  System.out.print("Ingrese la nueva contraseña para modificar los valores predeterminados: ");
  if (!sc.hasNextInt()) {
    System.out.println("Error, no se puede usar este formato.");
    sc.next();
    break;
  }
  contra1R = sc.nextInt();
}else {
  System.out.println("Contraseña incorrecta.");


}}}} while ( opcion  != 7);
System.out.println("Muchas gracias por usar el sistema de planilla ");
     }
    
     if (lenguaje == 2){

    
      Colaborador[] colaboradores = new Colaborador[10];
      Deducciones[] deduccion = new Deducciones[10];
      Bonificaciones[] bonificacion = new Bonificaciones[10];
  
      
      int opcion = 0;
  
     
      int contador = 0;
      int contador1 = 0;
      int contador2 = 0;
      int contraR=0;
      int contra1R=0;
      double ccss = 10.5;
      double rebajo = 0;
      double ahorro = 0;
      int limite1 = 941000;
      int limite2 = 1381000;
      int limite3 = 2423000;
      int limite4 = 4845000;
  
  
    
       do{ 
     
        System.out.println("Options menu:");
        System.out.println("1. Add Collaborator");
        System.out.println("2. Add deduction");
        System.out.println("3. Add bonus");
        System.out.println("4. Show payroll");
        System.out.println("5. Delete entered data");
        System.out.println("6. Modify default values");
        System.out.println("7. Exit");
  
       
        System.out.print("Enter the option you want: ");
        
  
        if (!sc.hasNextInt()) {
          System.out.println("Invalid option");
          sc.next();
          }else{
        
        opcion = sc.nextInt();
        sc.nextLine();
  
        
        switch (opcion) {
          case 1:
           
            if (contador == 10) {
              
              System.out.println("No more collaborators can be registered.");
            } else {
             
              System.out.print("Enter the name of the collaborator:");
              String nombre = sc.nextLine();
              System.out.print("Enter the employee's ID:");
              String cedula = sc.nextLine();
              System.out.print("Enter the employee's salary:");
              if (!sc.hasNextDouble()) {
                System.out.println("Invalid option, please try again");
                sc.next();
                break;
              }
              Double salario = sc.nextDouble();
            
  
            
              Colaborador colaborador = new Colaborador(nombre, cedula, salario);
  
            
              colaboradores[contador] = colaborador;
  
          
              contador++;
  
              
              System.out.println("Collaborator successfully added.");
            }
            break;
          case 2:
          
            if (contador == contador1) {
  
              
              
              System.out.println("There is no registered contributor in this space.");
            } else {
              
              Colaborador colaborador = colaboradores[contador1];
              if ( colaborador.getSalario() < limite1 ) {
                rebajo=0;
              }
              if ( colaborador.getSalario() >= limite1 && colaborador.getSalario() < limite2 ) {
                rebajo = (colaborador.getSalario()-limite1)*0.1; 
              }
              if ( colaborador.getSalario() >= limite2 && colaborador.getSalario() < limite3 ) {
                rebajo = ((colaborador.getSalario()-limite2)*0.15) + (limite2-limite1)*0.1;  
              }
              if ( colaborador.getSalario() >= limite3 && colaborador.getSalario() < limite4 ) {
                rebajo = ((colaborador.getSalario()-limite3)*0.2) + ((limite3-limite2)*0.15) + (limite2-limite1)*0.1;
              }
              if ( colaborador.getSalario() >= limite4 ) {
                rebajo = (colaborador.getSalario()-limite4)*0.25+((limite4-limite3)*0.2) + ((limite3-limite2)*0.15) + (limite2-limite1)*0.1;
              }
  
              System.out.println("Deductions from" + colaborador.getNombre());
              System.out.println("The percentage of CCSS is " + ccss);
              System.out.println("The rebate of Hacienda is " + rebajo);
              System.out.print("Enter the Association percentage:");
              if (!sc.hasNextDouble()) {
                System.out.println("Invalid option, please try again");
                sc.next();
                break;
              }
              double asociacion = sc.nextDouble();
  
              if ( asociacion > 0 ) {
                System.out.print("Enter the Savings amount: ");
              
              if (!sc.hasNextDouble()) {
                System.out.println("Invalid option, please try again");
                sc.next();
                break;
              }
              ahorro = sc.nextDouble();
              }
  
            
            
            
              
              Deducciones deduccionones = new Deducciones(asociacion, ahorro, rebajo);
  
              deduccion[contador1] = deduccionones;
              
              contador1++;
  
              
              System.out.println("Deduction added successfully.");
            }
            break;
          case 3:
           
            if (contador == 0) {
  
              
             
              System.out.println("There is no registered collaborator.");
            } else {
              Colaborador colaborador = colaboradores[contador2];
              System.out.println("Bonuses from " + colaborador.getNombre());
              System.out.print("Enter the percentage of commissions: ");
              if (!sc.hasNextDouble()) {
                System.out.println("Invalid option, please try again");
                sc.next();
                break;
              }
              double comisiones = sc.nextDouble();
              System.out.print("Enter the incentive amount: ");
              if (!sc.hasNextDouble()) {
                System.out.println("Invalid option, please try again");
                sc.next();
                break;
              }
              double incentivo = sc.nextDouble();
  
              Bonificaciones bonificaciones = new Bonificaciones(comisiones, incentivo);
  
              bonificacion[contador2] = bonificaciones;
  
              contador2++;
          }
          break;
          case 4:
    
  if (contador == 0) {
     
      System.out.println("There is no registered collaborator.");
    } else {
     
      for (int i = 0; i < contador; i++) {
       
        Colaborador colaborador = colaboradores[i];
        Deducciones deducciones = deduccion[i];
        Bonificaciones bonificaciones = bonificacion[i];
    
        
        if (deducciones == null || bonificaciones == null) {
        
          System.out.println("No deductions or bonuses have been assigned to the collaborator " + colaborador.getNombre());
        } else {
      
          double salarioBruto = colaborador.getSalario() + ( colaborador.getSalario() * bonificaciones.getComisiones() / 100) + bonificaciones.getIncentivo();
    
         
          double salarioNeto = salarioBruto - (salarioBruto * ccss / 100) - (salarioBruto * deducciones.getAsociacion() / 100) - deducciones.getAhorro() - rebajo;
          double salarioNQ = salarioNeto/2;
    
         
          System.out.println("The employee's " + colaborador.getNombre() + " monthly net salary is: " + salarioNeto + " and the employee's  " + colaborador.getNombre() + " fortnightly net salary is: " + salarioNQ);
        }
      }
    }
    break;
    case 5:
    System.out.print("Enter the password to erase the data: ");
    if (!sc.hasNextInt()) {
      System.out.println("Incorrect password.");
      sc.next();
      break;
    }
    int contra = sc.nextInt();
  
    if (contra == contraR) {
    for ( int B=0; B<colaboradores.length; B++){
      colaboradores[B] = null;
      deduccion[B] = null;
      bonificacion[B] = null;
      contador = 0;
      contador1 = 0;
      contador2 = 0;
      }
    }else{
      System.out.println("Incorrect password.");
    }
  
    break;
    case 6:
  
    System.out.print("Enter the password to modify the data:");
    if (!sc.hasNextInt()) {
      System.out.println("Incorrect password.");
      sc.next();
      break;
    }
    int contra1 = sc.nextInt();
  
  
    if (contra1 == contra1R) {
    
    System.out.print("Enter the CCSS percentage:");
    if (!sc.hasNextDouble()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    ccss = sc.nextDouble();
    System.out.print("Enter the first salary limit:");
    if (!sc.hasNextInt()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    limite1 = sc.nextInt();
    System.out.print("Enter the second salary limit:");
    if (!sc.hasNextInt()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    limite2 = sc.nextInt();
    System.out.print("Enter the third salary limit:");
    if (!sc.hasNextInt()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    limite3 = sc.nextInt();
    System.out.print("Enter the fourth salary limit: ");
    if (!sc.hasNextInt()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    limite4 = sc.nextInt();
    System.out.print("Enter the new password to erase the data: ");
    if (!sc.hasNextInt()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    contraR = sc.nextInt();
    System.out.print("Enter the new password to modify the default values:");
    if (!sc.hasNextInt()) {
      System.out.println("Error, this format cannot be used.");
      sc.next();
      break;
    }
    contra1R = sc.nextInt();
  }else{
    System.out.println("Incorrect password.");



}}}} while ( opcion  != 7);
  System.out.println("Thank you very much for using the payroll system");
       }

    if ( lenguaje != 1 && lenguaje != 2)  {
      System.out.println("Opción no valida.");
      System.out.println("Invalid option.");
      lenguaje = 0;
    }
    
    }}while( lenguaje == 0);}}