package Actividad5;

import java.io.Serializable;

public class EnviaFichero implements Serializable{
	
	//Declaracion de atributos del fichero a subir al servidor
	byte[] contenidoFichero;
	String nombre;
	String directorio;
	
	//Constructor
	public EnviaFichero(byte[] contenidoFichero, String nombre, String directorio) {
		this.contenidoFichero = contenidoFichero;
		this.nombre = nombre;
		this.directorio = directorio;
	}

	//Metodo para obtener el contenido del fichero
	public byte[] getContenidoFichero() {
		return contenidoFichero;
	}

	//Metodo para obtener el nombre del fichero
	public String getNombre() {
		return nombre;
	}

	//Metodo para obtener el directorio del fichero
	public String getDirectorio() {
		return directorio;
	}
	
}
