#include <stdio.h>
#include <stdlib.h>
/*Faça um programa que leia um número inteiro n indicando o número de valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto.
 Após a leitura dos valores, devemos fechar o arquivo. Em seguida, reabri-lo e fazer a leitura de trás para frente usando os métodos getFilePointer e seek da classe RandomAccessFile e
  mostre todos os valores lidos na tela. Nessa questão, você não pode usar, arrays, strings ou qualquer estrutura de dados.
 A entrada padrão é composta por um número inteiro n e mais n números reais.
  A saída padrão corresponde a n números reais mostrados um por linha de saída.*/
int main() {
    int n;
    scanf("%d", &n); // leia um número inteiro n indicando o número de valores reais

    FILE *exercicio = fopen("questao.txt", "wb"); 

    for (int i = 0; i < n; i++) {
        float a;
        scanf("%f", &a); // lendo os números
        fwrite(&a, sizeof(float), 1, exercicio); // colocando os números no arquivo
    }

    fclose(exercicio); // Após a escrita dos valores, feche o arquivo

    exercicio = fopen("questao.txt", "rb"); // Reabra o arquivo 
    fseek(exercicio, 0, SEEK_END); // Posicione o ponteiro no final do arquivo

    long tamanhoArquivo = ftell(exercicio); // Obtém o tamanho do arquivo em bytes
    long posicao = tamanhoArquivo - sizeof(float); // Tamanho de um float em bytes (4 bytes)

    while (posicao >= 0) {
        fseek(exercicio, posicao, SEEK_SET); // Posiciona o ponteiro no byte a ser lido
        float numero;
        fread(&numero, sizeof(float), 1, exercicio); // Lê um número float de 4 bytes
        posicao -= sizeof(float); // Move a posição para o próximo número


        // formatação de saída
       
        else if (numero - (int)numero == 0) {
            printf("%d\n", (int)numero); 
        } 
         else if (numero * 10 == (int)(numero * 10)) {
        printf("%.1f\n", numero);
    } 
         else if (numero * 100 == (int)(numero * 100)) {
        printf("%.2f\n", numero);
    } 
          else {
           printf("%.3f\n", numero);
    }
        
    
    }
    fclose(exercicio); // Feche o arquivo

    return 0;
}