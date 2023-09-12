package Tp1;

import java.util.Random;

/*Crie um método iterativo que recebe uma string, sorteia duas letras minúsculas aleatórias (código ASCII >= 'a' e <= 'z'), substitui todas as ocorrências da
 primeira letra na string pela segunda e retorna a string com as alterações efetuadas. Na saída padrão, para cada linha de entrada,
 execute o método desenvolvido nesta questão e mostre a string retornada como uma linha de saída.
  Abaixo, observamos um exemplo de entrada supondo que para a primeira linha as letras sorteados foram o 'a' e o 'q'. Para a segunda linha, foram o 'e' e o 'k'. */
public class TP01Q04 {
    public static void main(String args[]) {
        boolean parar = true;
        Random gerador = new Random();
        gerador.setSeed(4);
        while (parar == true) {// continuar até escrever FIM
            String s = MyIO.readLine();
            if (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
                parar = false;
            } else {

                MyIO.println(aleatorio(s, gerador));
            }

        }
    }

    public static String aleatorio(String s, Random gerador) {
        String nova = "";
        char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));// expressão para pegar a priemira letra
                                                                        // aleatória
        char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));// ^^segunda letra aleatória
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letra1) {// se a letra da String for igual a letra 1
                nova += letra2;// troca essa letra pela letra 2
            } else {
                nova += s.charAt(i);// se não continua com as letras originais
            }
        }
        return nova;
    }
}
