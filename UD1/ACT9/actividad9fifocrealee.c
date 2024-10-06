//Modificar los programas C de nombre actividad9fifocrealee.c y actividad9fifoescribe.c, 
//para que cuando se ejecute el programa actividad9fifoescribe, envíe al programa actividad9fifocrealee 
//un mensaje para que éste lo visualice. El programa actividad9fifoescribe será el encargado de crear el fifo. 
#include <fcntl.h>  // Para las operaciones de open, read y close
#include <unistd.h> // Para las operaciones del sistema como close
#include <sys/stat.h> // Para el uso de mknod y la creación de FIFOs
#include <stdio.h>  // Para printf y otras funciones de entrada/salida
#include <stdlib.h> // Para exit

int main (void) {
    int fp;
    int p, bytesleidos;  bytes se han leído
    char saludo[] = "Un saludo !!!!!\n", buffer[10]; eídos

    // Crea una FIFO llamada "FIFO2" con permisos de lectura y escritura
    p = mknod("FIFO2", S_IFIFO | 0666, 0);

    // Verifica si ha ocurrido un error al crear la FIFO
    if (p == -1) {
        printf("Ha ocurrido un error.... \n"); 
        exit(0); 
    }

    // Bucle infinito para leer continuamente de la FIFO
    while (1) {
        fp = open("FIFO2", 0); // Abre la FIFO en modo lectura (flag 0 para lectura)
        bytesleidos = read(fp, buffer, 1); // Lee 1 byte de la FIFO
        printf("Obteniendo información..."); 

        // Mientras se siga leyendo algún byte (bytesleidos != 0), sigue imprimiendo el contenido
        while (bytesleidos != 0) {
            printf("%s", buffer); 
            bytesleidos = read(fp, buffer, 1); // Lee el siguiente byte
        }

        close(fp); 
    }

    return (0); 
}
