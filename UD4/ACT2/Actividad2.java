package Actividad2;

import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Actividad2 {
	
	private final static String SERVIDOR = "172.20.104.145";
	private final static int PUERTO = 21;
	private final static String USUARIO = "dinux";
	private final static String CONTRASENA = "dinux";
	private final static String nombreCarpeta = "aplicacionwebramos";
	
	public static void main(String[] args) {
		//Cliente FTP
		FTPClient clienteFTP = new FTPClient();
		
		try {
         System.out.println("Nos conectamos a " + SERVIDOR);
         
         //Conectarse al servidor
         clienteFTP.connect(SERVIDOR, PUERTO);
         
         //Comprobar el usuario y contraseña
         if (clienteFTP.login(USUARIO, CONTRASENA)) {
             System.out.println("Login correcto");
             System.out.println("Directorio actual: " + clienteFTP.printWorkingDirectory());
             
             // Establecer modos
             clienteFTP.enterLocalPassiveMode();
             clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
             
             // Crear estructura de carpetas
             boolean carpetaInicial = clienteFTP.makeDirectory(nombreCarpeta);
             boolean carpetaHtml = clienteFTP.makeDirectory(nombreCarpeta + "/html");
             boolean carpetaImagenes = clienteFTP.makeDirectory(nombreCarpeta + "/imagenes");
             boolean carpetaCss = clienteFTP.makeDirectory(nombreCarpeta + "/css");
             
             //Comprobar si se han creado
             if (carpetaInicial && carpetaHtml && carpetaImagenes && carpetaCss) {
                 System.out.println("Directorios creados...");
             } else {
                 System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
             }
             
             //Hacer el Logout
             if (clienteFTP.logout()) {
                 System.out.println("Logout del servidor FTP....");
             } else {
                 System.out.println("Error al hacer logout");
             }
             
             //Login Incorrecto
         } else {
             System.out.println("Login incorrecto...");
         }
         
         //Mostrar Error
     } catch (IOException e) {
         System.out.println("Error: " + e.getMessage());
         e.printStackTrace();
         
     } finally {
    	 //Desconectarse del servidor
         try {
             if (clienteFTP.isConnected()) {
                 clienteFTP.disconnect();
                 System.out.println("Desconectado...");
             }
             
         } catch (IOException e) {
             System.out.println("Error al desconectar: " + e.getMessage());
             e.printStackTrace();
         }
     }
	}
}
