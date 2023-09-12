//RECURSIVO

#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
/*Crie um método iterativo que recebe uma string, sorteia duas letras minúsculas aleatórias (código ASCII >= 'a' e <= 'z'), substitui todas as ocorrências da
 primeira letra na string pela segunda e retorna a string com as alterações efetuadas. Na saída padrão, para cada linha de entrada,
 execute o método desenvolvido nesta questão e mostre a string retornada como uma linha de saída.
  Abaixo, observamos um exemplo de entrada supondo que para a primeira linha as letras sorteados foram o 'a' e o 'q'. Para a segunda linha, foram o 'e' e o 'k'. */

char* aleatorio(char s[], int i) {
    char letra1 = 'a' + rand() % 26;
    char letra2 = 'a' + rand() % 26;

    if (i < strlen(s)) {
        if (s[i] == letra1) {// se a letra da String for igual a letra 1
            s[i] = letra2;// troca essa letra pela letra 2
        }
        return aleatorio(s, i + 1); // Retornar a chamada recursiva
    }
    return s; // Retornar a string após todas as modificações
}


int main(void) {
    srand(4);
    char s[500];
    bool parar = true;
    
   while (parar == true) {
       scanf(" %[^\n]", s);

        if (s[0] == 'F' && s[1] == 'I' && s[2] == 'M') {
            parar = false;
        } else {
           char* resultado = aleatorio(s, 0);
            printf("%s\n", resultado);
            
            
        }
    }


}