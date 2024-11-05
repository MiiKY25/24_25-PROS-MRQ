//Modificar los programas C de nombre actividad9fifocrealee.c y actividad9fifoescribe.c, 
//para que cuando se ejecute el programa actividad9fifoescribe, envíe al programa actividad9fifocrealee 
//un mensaje para que éste lo visualice. El programa actividad9fifoescribe será el encargado de crear el fifo. 
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(void) {
    int fp;
    char buffer[128]; // Buffer más grande para leer mensajes completos
    int bytesleidos;

    // Abre la FIFO en modo lectura
    fp = open("FIFO2", O_RDONLY); // Abrimos el FIFO en modo lectura
    if (fp == -1) {
        perror("Error al abrir el FIFO para leer");
        exit(1);
    }

    while (1) {
        // Intentar leer el mensaje
        bytesleidos = read(fp, buffer, sizeof(buffer) - 1); // Leemos hasta el tamaño del buffer - 1 para el '\0'
        
        // Verifica si se leyeron bytes
        if (bytesleidos > 0) {
            buffer[bytesleidos] = '\0'; // Aseguramos que el buffer sea una cadena
            printf("Mensaje recibido: %s", buffer);
        } else if (bytesleidos == -1) {
            perror("Error al leer del FIFO");
            break; // Salimos si hay un error
        }
        
        // Salir del bucle si no se lee nada
        if (bytesleidos == 0) {
            break; // Puede romper el bucle si no hay más datos
        }
    }

    close(fp); // Cerrar el FIFO al final
    return 0;
}
