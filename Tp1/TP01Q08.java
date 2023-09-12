package Tp1;

/*Faça um programa que leia um número inteiro n indicando o número de valores reais que devem ser lidos e salvos sequencialmente em um arquivo 
texto. Após a leitura dos valores, devemos fechar o arquivo.
 Em seguida, reabri-lo e fazer a leitura de trás para frente usando os métodos getFilePointer e seek da classe RandomAccessFile e mostre todos os valores lidos na tela. Nessa questão, você não pode usar,
  arrays, strings ou qualquer estrutura de dados.
   A entrada padrão é composta por um número inteiro n e mais n números reais. A saída padrão corresponde a n números reais mostrados um por linha de saída. */
import java.io.RandomAccessFile;

public class TP01Q08 {
    public static void main(String[] args) throws Exception {
        int n = MyIO.readInt();// leia um número inteiro n indicando o número de valores reais
        RandomAccessFile exercicio = new RandomAccessFile("questao.txt", "rw");
        for (int i = 0; i < n; i++) {
            float a = MyIO.readFloat();// lendo os numeros
            exercicio.writeFloat(a);// colocando os numeros no arquivo
        }
        exercicio.close();// Após a leitura dos valores, devemos fechar o arquivo
        RandomAccessFile exercicio2 = new RandomAccessFile("questao.txt", "r");// reabri-lo e fazer a leitura de trás
                                                                               // para frente
        long tamanhoArquivo = exercicio2.length(); // Obtém o tamanho do arquivo em bytes
        long posicao = tamanhoArquivo - 4; // Tamanho de um float em bytes (4 bytes)

        while (posicao >= 0) {
            exercicio2.seek(posicao); // Posiciona o ponteiro no byte a ser lido
            float numero = exercicio2.readFloat(); // Lê um número float de 4 bytes
            posicao -= 4; // Move a posição para o próximo número
            if (numero % 1 == 0) {
                MyIO.println((int) numero);// formatando pra saida
            } else {
                MyIO.println(numero);
            }
        }
        exercicio2.close();
    }
}
