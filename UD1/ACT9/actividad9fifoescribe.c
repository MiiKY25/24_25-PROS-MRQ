//Modificar los programas C de nombre actividad9fifocrealee.c y actividad9fifoescribe.c, 
//para que cuando se ejecute el programa actividad9fifoescribe, envíe al programa actividad9fifocrealee 
//un mensaje para que éste lo visualice. El programa actividad9fifoescribe será el encargado de crear el fifo. 
#include <stdio.h>   
#include <stdlib.h>  
#include <string.h>  
#include <fcntl.h>   
#include <unistd.h>  

int main(void) {
    int fp; 
    int p, bytesleidos; 
    char saludo[] = "Un saludo....\n"; 

    // Abre la FIFO llamada "FIFO2" con permiso de escritura
    fp = open("FIFO2", 1); 

    // Verifica si ocurrió un error al abrir la FIFO
    if (fp == -1) {
        printf("Error al abrir el fichero... \n"); /
        exit(1); 
    }

    printf("Mandando información al FIFO...\n");

    // Escribe el mensaje contenido en 'saludo' dentro de la FIFO
    write(fp, saludo, sizeof(saludo)); 

    
    close(fp);

    return(0); 
}
