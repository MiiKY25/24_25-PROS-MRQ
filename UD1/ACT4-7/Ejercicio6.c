//Haz un programa C que genere la siguiente estructura de procesos:
// PADRE --> HIJO 1
//        \\\---> HIJO 2 --> HIJO 3
//Librerias
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    pid_t padre_pid = getpid(); // Guardamos el PID del proceso padre

    //Creacion del hijo 1
    pid = fork();
    if (pid == -1) { //Comprobamos que se ha creado el proceso correctamente
        printf("No se ha podido crear el proceso hijo...\n");
        exit(-1);
    }
    if (pid == 0) {
        printf("Yo soy el hijo %d, mi padre es PID = %d , yo soy PID = %d.\n", 1, padre_pid, getpid());
        exit(0); // Finaliza el proceso hijo 1
    }

    //Creacion de los hijos 2 y 3
    for (int i = 1; i < 3; i++) { //Bucle que se repite dos veces
        pid = fork();
        if (pid == -1) { //Comprobamos que se ha creado el proceso correctamente
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        }
        if (pid == 0) {
            printf("Yo soy el hijo %d, mi padre es PID = %d , yo soy PID = %d.\n", i+1, padre_pid, getpid());
            //Guardamos el actual PID para luego mostrarlo como padre del siguiente hijo
            padre_pid=getpid();
        }else {
            //Esperamos a que termine cada proceso para poder continuar con el siguiente
            wait(NULL);
            exit(0); // Finaliza el proceso hijo
        }
    }
    
    return 0;   
}
