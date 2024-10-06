// Realiza un programa en C que cree un proceso (tendremos un proceso padre y otro hijo). 
// El programa definirá una variable entera y le dará un valor 6. 
// El proceso padre incrementará dicho valor en 5 y el hijo restará 5. 
//Librerias
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    int variable=6; //Creacion de varibale
    pid_t pid;
    
    printf("Valor inicial de la variable: %d\n", variable);

    //Creacion del hijo
    pid = fork();
    if (pid == -1) { //Comprobamos que se ha creado el proceso correctamente
        printf("No se ha podido crear el proceso hijo...\n");
        exit(-1);
    }
    if (pid == 0) {
         // Este es el proceso hijo
        variable -= 5;
        printf("Variable en Proceso Hijo: %d\n", variable);
    }else {
        // Este es el proceso padre
        wait(NULL);  // Espera a que el proceso hijo termine
        variable += 5;
        printf("Variable en Proceso Padre: %d\n", variable);
    }
    return 0;   
}
