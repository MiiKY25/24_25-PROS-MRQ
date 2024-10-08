//Realiza un programa C en donde un hijo envíe 3 señales SIGUSR1 a su padre 
//y después envíe una señal SIGKILL para que el proceso padre termine.
//Padre recibe señal ...10
//Padre recibe señal ...10
//Padre recibe señal ...10
//Terminado (killed)
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <signal.h>

// Contador de señales recibidas
int contador = 0;

// Manejador de la señal SIGUSR1
void manejador_SIGUSR1(int sig) {
    contador++;
    printf("Padre recibe señal ...10\n");
}

int main() {
    // Registrar el manejador de SIGUSR1
    signal(SIGUSR1, manejador_SIGUSR1);

    pid_t pid = fork();

    if (pid < 0) {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Este es el proceso hijo
        pid_t padre_pid = getppid(); // Obtener el PID del padre

        // Enviar 3 señales SIGUSR1 al padre
        for (int i = 0; i < 3; i++) {
            kill(padre_pid, SIGUSR1);
            sleep(1); // Esperar un segundo entre cada señal para ver la salida
        }

        // Enviar la señal SIGKILL al padre para finalizarlo
        kill(padre_pid, SIGKILL);

        exit(EXIT_SUCCESS);
    } else {
        // Este es el proceso padre, debe esperar a las señales
        while (1) {
            pause(); // Espera a que llegue una señal
        }
    }

    return 0;
}

