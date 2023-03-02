/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1.servicios.publicos;

/**
 *
 * @author bravo
 */
import java.util.Scanner;
public class PROYECTO1SERVICIOSPUBLICOS {

    public static Scanner scanner = new Scanner(System.in);
    public static int[] numPago = new int[10];
    public static String[] fecha = new String[10];
    public static String[] hora = new String[10];
    public static String[] ced = new String[10];
    public static String[] nom = new String[10];
    public static String[] apellido1 = new String[10];
    public static String[] apellido2 = new String[10];
    public static int[] numCaja = new int[10];
    public static int[] tipoServ = new int[10];
    public static int[] numFact = new int[10];
    public static double[] montoPagar = new double[10];
    public static double[] montoComi = new double[10];
    public static double[] montoDeduci = new double[10];
    public static double[] montoPagaCliente = new double[10];
    public static double[] vuelto = new double[10];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option = 0;
        do {

            

            System.out.println("Menu:");
            System.out.println("1. Inicializar vectores");
            System.out.println("2. Realizar pagos");
            System.out.println("3. Consultar pagos");
            System.out.println("4. Modificar Pagos");
            System.out.println("5. Eliminar Pagos");
            System.out.println("6. Submenú Reportes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            switch (option) {

                case 1:
                    System.out.println("Iniciando vectores");
                    InicializarVectores();
                    break;
                case 2:
                    System.out.println("Realice los pago");
                    RealizarPagos();
                    break;
                case 3:
                    System.out.println("Consulte los pagos");
                    consultarPagos();
                    break;
                case 4:
                    System.out.println("Modifique los pagos");
                    modificarPagos();
                    break;
                case 5:
                    System.out.println("Elimine Pagos");
                    eliminarPago();
                    break;
                case 6:
                    System.out.println("Seleccione una opción del submenú de reportes");
                    SubmenuReportes();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor seleccione una opción válida");
            }
        } while (option != 7);

    }

    public static void InicializarVectores() {
        for (int i = 0; i > 10; i++) {
            numPago[i] = 0;
            fecha[i] = "";
            hora[i] = "";
            ced[i] = "";
            nom[i] = "";
            apellido1[i] = "";
            apellido2[i] = "";
            numCaja[i] = 0;
            tipoServ[i] = 0;
            numFact[i] = 0;
            montoPagar[i] = 0;
            montoComi[i] = 0;
            montoDeduci[i]= 0;
            montoPagaCliente[i] = 0;
            vuelto[i] = 0;
        }//Fin del ciclo for

    }//Fin del metodo InicializarVectores

    public static void RealizarPagos() {
        int i = 0;
        String respuesta = "";
       if (i != 10 ) {
        do {
            i++;
            numPago[i] = (int) (Math.random() * 100 + 1);
            System.out.println("Digite la fecha");
            fecha[i] = scanner.next();
            System.out.println("Digite la hora");
            hora[i] = scanner.next();
            System.out.println("Digite su numero de cedula");
            ced[i] = scanner.next();
            System.out.println("Digite su nombre (sin apellidos)");
            nom[i] = scanner.next();
            System.out.println("Digite su primer apelligo");
            apellido1[i] = scanner.next();
            System.out.println("Digite su segundo apellido");
            apellido2[i] = scanner.next();
            numCaja[i] = (int) (Math.random() * 3 + 1);
            System.out.println("Eliga un servicio:\n 1=Recibo de luz\n 2=Recibo teléfono\n 3=Recibo de agua");
            tipoServ[i] = scanner.nextInt();
            System.out.println("Digite el numero de factura");
            numFact[i]= scanner.nextInt();
            System.out.println("Digite el monto a pagar");
            montoPagar[i] = scanner.nextInt();
            System.out.println("Digite el monto a pagar");
            if(tipoServ[i] ==1){//Electricidad
            montoComi[i] =montoPagar[i]*0.04;
            //System.out.println("Comision : "+montoComi[i]);
            }
            if(tipoServ[i] ==2){//Telefono
            montoComi[i] =montoPagar[i]*0.055;
            //System.out.println("Comision : "+montoComi[i]);
            }
            if(tipoServ[i] ==3){//Agua
            montoComi[i] =montoPagar[i]*0.065;
            //System.out.println("Comision : "+montoComi[i]);
            } 
            //Fin de los ciclos if
            montoDeduci[i]=montoPagar[i]-montoComi[i];
            
            System.out.println("Paga con:");
            montoPagaCliente[i]=scanner.nextInt();
            
            if(montoPagaCliente[i]<montoPagar[i]){
                System.out.println("Error el pago no puede ser menor que el monto a pagar\nVolviendo al menu principal");
                return;
            }else{
              vuelto[i]=montoPagaCliente[i]-montoPagar[i];  
            }
            
            System.out.println("Desea continuar s/n?\nPosicion del vector: "+i);
            respuesta = scanner.next();
            if(i == 9){
               System.out.println("Vectores Llenos"); 
                return;
            }//Fin del ciclo if
            
            System.out.println("Numero de Pago: "+numPago[i]+"\nFecha: "+fecha[i]+"      Hora:    "+hora[i]+"\nCedula:     "+ced[i]
       +"       Nombre:      "+nom[i]+"\nApellido1:     "+apellido1[i]+"       Apellido2:      "+apellido2[i]+"\n\nTipo de servicio: "+tipoServ[i]
       +"      [1-Electricidad 2-Telefono 3-Agua]\n\nNumero de factura: "+numFact[i]+"       Monto Pagar:      "+montoPagar[i]+"\nComision autorizada: "+montoComi[i]
       +"       Paga con:      "+montoPagaCliente[i]+"\nMonto deducido: "+montoDeduci[i]+"       Vuelto:      "+vuelto[i]+"\n");
            
            if(respuesta == "n" && respuesta == "N"){
               System.out.println("Volviendo al menu principal");

                return;
            }//Fin del ciclo if
        } while (i<=9 && respuesta.equalsIgnoreCase("s") );//Fin del ciclo do while
           System.out.println("Volviendo al menu principal");

            }//Fin del ciclo if
       
    }//Fin del metodo RealizarPagos 
    
    public static void consultarPagos(){
    Scanner consultar = new Scanner (System.in);
    System.out.println("Digite el numero de pago que quiere consultar: ");
    int buscarNumPago= consultar.nextInt();
    boolean encontrado = false;
    
    for(int inicio =0; inicio < numPago.length; inicio++){
    
    if(numPago[inicio]==buscarNumPago){
    limpiarConsola();
    System.out.println("Encontrado en la posicion: "+inicio);
    encontrado = true;
    
                System.out.println("Numero de Pago: "+numPago[inicio]+"\nFecha: "+fecha[inicio]+"      Hora:    "+hora[inicio]+"\nCedula:     "+ced[inicio]
       +"       Nombre:      "+nom[inicio]+"\nApellido1:     "+apellido1[inicio]+"       Apellido2:      "+apellido2[inicio]+"\n\nTipo de servicio: "+tipoServ[inicio]
       +"      [1-Electricidad 2-Telefono 3-Agua]\n\nNumero de factura: "+numFact[inicio]+"       Monto Pagar:      "+montoPagar[inicio]+"\nComision autorizada: "+montoComi[inicio]
       +"       Paga con:      "+montoPagaCliente[inicio]+"\nMonto deducido: "+montoDeduci[inicio]+"       Vuelto:      "+vuelto[inicio]+"\n");
    
    break;
     }
    }
    if(!encontrado){
      System.out.println("No se encuentra");  
    }
   }//Fin del metodo consultarPagos 
     public static void modificarPagos(){
      Scanner m = new Scanner(System.in);
      int numeroPagoModificar = 0;
      int opcionModificar = 0;
      boolean modificar = true;
      System.out.println("Digite el numero de pago para modificar los datos ");
      numeroPagoModificar = m.nextInt();

        for (int a = 0; a < numPago.length; a++) {

          if (numPago[a] == numeroPagoModificar) {
              limpiarConsola();
              System.out.println("Pago encontrado en la posicion: " + a);

               do {

               System.out.println("Que dato desea modificar?");
               System.out.println("1. fecha");
               System.out.println("2. hora");
               System.out.println("3. cedula");
               System.out.println("4. nombre");
               System.out.println("5. apellido1");
               System.out.println("6. apellido2");
               System.out.println("7. tipo de servicio");
               System.out.println("8. numero de factura");
               System.out.println("9. Salir o cancelar modificacion");
               System.out.print("Seleccione opcion a modificar: ");
               opcionModificar = m.nextInt();
            System.out.print("******ANTES DE LA MODIFICACION******\n");
           System.out.println("Numero de Pago: " + numPago[a] + "\nFecha: " + fecha[a] + "      Hora:    " + hora[a] + "\nCedula:     " + ced[a]
           + "       Nombre:      " + nom[a] + "\nApellido1:     " + apellido1[a] + "       Apellido2:      " + apellido2[a] + "\n\nTipo de servicio: " + tipoServ[a]
         + "      [1-Electricidad 2-Telefono 3-Agua]\n\nNumero de factura: " + numFact[a] + "       Monto Pagar:      " + montoPagar[a] + "\nComision autorizada: " + montoComi[a]
           + "       Paga con:      " + montoPagaCliente[a] + "\nMonto deducido: " + montoDeduci[a] + "       Vuelto:      " + vuelto[a] + "\n");
                switch (opcionModificar) {
                   case 1:
                     System.out.println("Digite la fecha");
                     fecha[a] = m.next();
                     System.out.println("Nuevo Dato:   " + fecha[a]);
                          break;
                   case 2:
                     System.out.println("Digite la hora");
                     hora[a] = m.next();
                     System.out.println("Nuevo Dato:   " + hora[a]); 
                          break;
                   case 3:
                     System.out.println("Digite su numero de cedula");
                     ced[a] = m.next();
                     System.out.println("Nuevo Dato:   " + ced[a]);
                          break;
                   case 4:
                     System.out.println("Digite su nombre (sin apellidos)");
                     nom[a] = m.next();
                     System.out.println("Nuevo Dato:   " + nom[a]);
                         break;
                   case 5:
                     System.out.println("Digite su primer apelligo");
                     apellido1[a] = m.next();
                     System.out.println("Nuevo Dato:   " + apellido1[a]);
                         break;
                   case 6:
                     System.out.println("Digite su segundo apellido");
                     apellido2[a] = m.next();
                     System.out.println("Nuevo Dato:   " + apellido2[a]);
                         break;
                   case 7:
                     System.out.println("Eliga un servicio:\n 1=Recibo de luz\n 2=Recibo teléfono\n 3=Recibo de agua");
                     tipoServ[a] = m.nextInt();
                            if(tipoServ[a] ==1){//Electricidad
                            montoComi[a] =montoPagar[a]*0.04;   
                            }
                            if(tipoServ[a] ==2){//Telefono
                            montoComi[a] =montoPagar[a]*0.055;
                            }
                            if(tipoServ[a] ==3){//Agua
                            montoComi[a] =montoPagar[a]*0.065;
                            } 
                            System.out.println("Nuevo Dato:   " + tipoServ[a]);
                         break;
                   case 8:
                     System.out.println("Digite el numero de factura");
                     numFact[a] = m.nextInt();
                     System.out.println("Nuevo Dato:   " + numFact[a]);
                        break;
                   case 9:
                     System.out.println("modificacion cancelada");
                        break;
                     }//Fin del switch

                 } while (opcionModificar != 9);
                            montoDeduci[a]=montoPagar[a]-montoComi[a];
                            vuelto[a]=montoPagaCliente[a]-montoPagar[a];   
            System.out.println("Numero de Pago: " + numPago[a] + "\nFecha: " + fecha[a] + "      Hora:    " + hora[a] + "\nCedula:     " + ced[a]
            + "       Nombre:      " + nom[a] + "\nApellido1:     " + apellido1[a] + "       Apellido2:      " + apellido2[a] + "\n\nTipo de servicio: " + tipoServ[a]
       + "      [1-Electricidad 2-Telefono 3-Agua]\n\nNumero de factura: " + numFact[a] + "       Monto Pagar:      " + montoPagar[a] + "\nComision autorizada: " + montoComi[a]
            + "       Paga con:      " + montoPagaCliente[a] + "\nMonto deducido: " + montoDeduci[a] + "       Vuelto:      " + vuelto[a] + "\n");
                  
             }//Fin de la condicion if 

         }//Fin del ciclo for
         if (modificar == false) {
             System.out.println("Pago no se encuentra Registrado");
         }//Fin de la condicion if

 }//Fin del metodo modificarPagos 
     public static void eliminarPago(){
     Scanner e = new Scanner (System.in);
     int numeroEliminar=0;
     boolean eliminado =true;
     System.out.println("Digite el numero de pago que quiere eliminar ");
     numeroEliminar= e.nextInt(); 
       for(int y=0;y<numPago.length;y++){
           System.out.println("Seguro que quieres eliminar el pago? s/n");
         String respuestaUsuarioE= e.next();
         if(respuestaUsuarioE.equalsIgnoreCase("n")){
          System.out.println("La información no fue eliminada");
          break;
         }
          if(numPago[y]==numeroEliminar){
              limpiarConsola();
             //Sustituye todos los valores por 0 o null de la posicion del vector elegido
             numPago[y]=0;
             fecha[y]=null;
             hora[y]=null;
             ced[y]=null;
             nom[y]=null;
             apellido1[y]=null;
             apellido2[y]=null;
             numCaja[y]=0;
             tipoServ[y]=0;
             numFact[y]=0;
             montoPagar[y]=0;
             montoComi[y]=0;        
             montoDeduci[y]=0;
             montoPagaCliente[y]=0;
             vuelto[y]=0;        
             eliminado = true; 
             System.out.println("La información ya fue eliminada");
             break;
          } 
       }//Fin del ciclo for
       if(eliminado==false){
        System.out.println("Pago no se encuentra Registrado");   
       }//Fin de la condicion if
       
       
}//Fin del metodo eliminarPago
     
     public static void SubmenuReportes(){
    int option = 0;
        do {

            System.out.println("Submenu:");
            System.out.println("1. Ver todos los pagos");
            System.out.println("2. Ver pagos por tipo de servicio");
            System.out.println("3. Ver pagos por codigo de caja");
            System.out.println("4. Ver dinero comisionado por servicio");
            System.out.println("5. Regresar al menu principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            switch (option) {

                case 1:
                    System.out.println("Todos los pagos");
                    VertodoslosPagos();
                    break;
                case 2:
                    System.out.println("Pagos por tipo de servicio");
                    TipodeServicio();
                    break;
                case 3:
                    System.out.println("Pagos por codigo de caja");
                    CodigodeCaja();
                    break;
                case 4:
                    System.out.println("Dinero comisionado por servicio");
                    Comisionado();
                    break;
                    
                case 5:
                    System.out.println("Saliendo de submenu...");
                    break;
                    
                default:
                    System.out.println("Opción inválida, por favor seleccione una opción válida");
            }
        } while (option != 5);
}//Fin del metodo Submenu
     
     public static void VertodoslosPagos(){
         int montototal = 0;
         int totalregistros = 0;
         for (int inicio = 0; inicio < 10; inicio++) {
             if (numPago[inicio] > 0){
                 System.out.println("Numero de Pago: "+numPago[inicio]+"\nFecha: "+fecha[inicio]+"      Hora:    "+hora[inicio]+"\nCedula:     "+ced[inicio]
       +"       Nombre:      "+nom[inicio]+"\nApellido1:     "+apellido1[inicio]+"       Apellido2:      "+apellido2[inicio]+ "       Monto Pagar:      "+montoPagar[inicio]);
                
                 totalregistros++;
                 montototal += montoPagar [inicio];
             }
         }
         System.out.println("Monto total: "+montototal+ "Total de registros: "+totalregistros);
     }
     
     public static void TipodeServicio(){
         int respuesta = 0;
         int montototal = 0;
         int totalregistros = 0;
         System.out.println("Digite el tipo de pago que desea consultar");
         respuesta = scanner.nextInt();
         for (int inicio = 0; inicio < 10; inicio++) {
             if (numPago[inicio] > 0 && tipoServ[inicio] == respuesta){
                 
                 System.out.println("Numero de Pago: "+numPago[inicio]+"\nFecha: "+fecha[inicio]+"      Hora:    "+hora[inicio]+"\nCedula:     "+ced[inicio]
       +"       Nombre:      "+nom[inicio]+"\nApellido1:     "+apellido1[inicio]+"       Apellido2:      "+apellido2[inicio]+ "       Monto Pagar:      "+montoPagar[inicio]);
                
                 totalregistros++;
                 montototal += montoPagar [inicio];
             }
         }
         System.out.println("Monto total: "+montototal+ "Total de registros: "+totalregistros);
     }
     
     public static void CodigodeCaja(){
         int respuesta = 0;
         int montototal = 0;
         int totalregistros = 0;
         System.out.println("Digite el codigo que desea consultar");
         respuesta = scanner.nextInt();
         for (int inicio = 0; inicio < 10; inicio++) {
             if (numPago[inicio] > 0 && numCaja[inicio] == respuesta){
                 
                 System.out.println("Numero de Pago: "+numPago[inicio]+"\nFecha: "+fecha[inicio]+"      Hora:    "+hora[inicio]+"\nCedula:     "+ced[inicio]
       +"       Nombre:      "+nom[inicio]+"\nApellido1:     "+apellido1[inicio]+"       Apellido2:      "+apellido2[inicio]+ "       Monto Pagar:      "+montoPagar[inicio]);
                
                 totalregistros++;
                 montototal += montoPagar [inicio];
             }
         }
         System.out.println("Monto total: "+montototal+ "Total de registros: "+totalregistros);
     }
     
     public static void Comisionado(){
         int telectricidad = 0;
         int ttelefono = 0;
         int tagua = 0;
         int tmontototal = 0;
         int celectricidad = 0;
         int ctelefono = 0;
         int cagua = 0;
         int cmontototal = 0;
         
         for (int inicio = 0; inicio < 10; inicio++) {
             if (numPago[inicio] > 0){
                 if(tipoServ[inicio] == 1){
                    telectricidad++;
                    tmontototal++;
                    celectricidad += montoComi[inicio];
                    cmontototal +=  montoComi[inicio];
                 }
                 
                 if(tipoServ[inicio] == 2){
                    ttelefono++;
                    tmontototal++;
                    ctelefono += montoComi[inicio];
                    cmontototal +=  montoComi[inicio];
                 }
                 
                 if(tipoServ[inicio] == 3){
                    tagua++;
                    tmontototal++;
                    cagua += montoComi[inicio];
                    cmontototal +=  montoComi[inicio];
                 }
                
             }
         }
         System.out.println("1. Electricidad. Transacciones: "+telectricidad+ " Comisionado: "+celectricidad );
         System.out.println("2. Telefono. Transacciones: "+ttelefono+ " Comisionado: "+ctelefono );
         System.out.println("3. Agua. Transacciones: "+tagua+ " Comisionado: "+cagua );
         System.out.println("1. Total Transacciones: "+tmontototal+ "Total Comisionado: "+cmontototal);
     }
     

public static void limpiarConsola(){
 Scanner clean = new Scanner(System.in);
       for(int i = 0; i < 100; i++) {
         System.out.println(" ");
      }//Fin del ciclo for
       
      System.out.print("\033[H\033[2J");
      System.out.flush();
}//Fin del metodo limpiarConsola   
     
     
     
     
}//Fin de la clase PROYECTO1SERVICIOSPUBLICOS

     