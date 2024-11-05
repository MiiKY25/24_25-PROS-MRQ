//Modificar los programas C de nombre actividad9fifocrealee.c y actividad9fifoescribe.c, 
//para que cuando se ejecute el programa actividad9fifoescribe, envíe al programa actividad9fifocrealee 
//un mensaje para que éste lo visualice. El programa actividad9fifoescribe será el encargado de crear el fifo. 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main(void) {
    int fp;
    char saludo[] = "Un saludo !!!!!\n"; // Mensaje a enviar

    // Verifica si la FIFO ya existe
    if (access("FIFO2", F_OK) == -1) {
        // Crea la FIFO llamada "FIFO2" con permisos de lectura y escritura
        if (mkfifo("FIFO2", 0666) == -1) {
            perror("Error al crear FIFO");
            exit(1);
        }
    } else {
        printf("FIFO ya existe, no se crea de nuevo.\n");
    }

    printf("Mandando información al FIFO...\n");

    // Abre la FIFO con permiso de escritura
    fp = open("FIFO2", O_WRONLY); // Cambié el flag a O_WRONLY para escritura

    // Verifica si ocurrió un error al abrir la FIFO
    if (fp == -1) {
        perror("Error al abrir el FIFO para escribir");
        exit(1);
    }


    // Escribe el mensaje contenido en 'saludo' dentro de la FIFO
    write(fp, saludo, strlen(saludo)); // Usar strlen para enviar solo el tamaño real del mensaje

    close(fp); // Cierra el FIFO

    return 0;
}
