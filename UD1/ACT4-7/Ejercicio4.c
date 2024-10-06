//Haz un programa C que genere una estructura de procesos con un padre y 3 hijos. 
//Visualiza por cada hijo su PID y el del padre. Visualiza también el PID del 
//padre de todos.
//Librerias
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    pid_t padre_pid = getpid();  // Guardamos el PID del proceso padre

    for (int i = 1; i < 4; i++) {
        pid = fork();        
        if (pid == -1) { //Comprobamos que se ha creado el proceso correctamente
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        }
        if (pid == 0) {
            //Mostramos la informacion del proceso creado
            printf("Soy el hijo %d, Mi padre es %d y mi PID es %d.\n", i, padre_pid, getpid());
            exit(0);  // Finaliza el proceso hijo
        }
    }

    // Proceso padre espera a que todos los hijos terminen
    for (int i = 1; i < 4; i++) {
        wait(NULL);
    }

    printf("Proceso padre %d\n", padre_pid);

    return 0;
}
