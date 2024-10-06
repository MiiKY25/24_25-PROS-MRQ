//Haz un programa C que genere la siguiente estructura de procesos:
// PADRE --> HIJO 1 --> HIJO 2 --> HIJO n
//Librerias
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    int n=5;
    pid_t pid;
    pid_t padre_pid = getpid();  // Guardamos el PID del proceso padre

    printf("Proceso padre %d\n", getpid());

    for (int i = 1; i <= n; i++) { //Bucle que se repidte n veces
        pid = fork();
        if (pid == -1) { //Comprobamos que se ha creado el proceso correctamente
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        }
        if (pid == 0) {
            printf("Soy el hijo %d, Mi padre es %d y mi PID es %d.\n", i, padre_pid, getpid());
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
