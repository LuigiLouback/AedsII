/*Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo. Na saída padrão, para cada linha de entrada,
 escreva uma linha de saída com SIM/NÃO indicando se a linha é um palíndromo. Destaca-se que uma linha de entrada pode ter caracteres não letras. */

#include <stdio.h>
#include <stdbool.h>
#include <string.h>


   bool isPalindromo(char s[]) {// método para verificar se é palíndromo
        bool resp = true;
        for (int i = 0; i < (strlen(s) / 2); i++) {
            if (s[i] != s[(strlen(s) - 1 - i)]) {// compara a primeira e a ultima letra da palavra
                resp = false;
                i = strlen(s);// condição de parada
            }
        }
        return resp;
    }



int main(void) {
   bool parar = true;
  char s[500];
        while (parar == true) {// continuar até escrever FIM
            scanf(" %[^\n]%*c",s);
            if (s[0] == 'F' && s[1] == 'I' && s[2] == 'M') {
                parar = false;
            }

            else if (isPalindromo(s) == true) {// se for palíndromo escreve sim
                printf("SIM\n");
            } else {// se não for escreve não
                printf("NAO\n");
        }

    }}

  

  