package Tp1;
/*O Imperador Júlio César foi um dos principais nomes do Império Romano. Entre suas contribuições, temos um algoritmo de criptografia
 chamado Ciframento de César. Segundo os historiadores, César utilizava esse algoritmo para criptografar as mensagens que enviava aos seus generais durante as batalhas.
A ideia básica é um simples deslocamento de caracteres. Assim, por exemplo, se a chave utilizada para criptografar as mensagens for 3, todas as ocorrências do caractere 'a' 
são substituídas pelo caractere 'd', as do 'b' por 'e', e assim sucessivamente.


Crie um método iterativo que recebe uma string como parâmetro e retorna outra contendo a entrada de forma cifrada. Neste exercício, 
suponha a chave de ciframento três. Na saída padrão, para cada linha de entrada, escreva uma linha com a mensagem criptografada. */

public class TP01Q03 {
    public static void main(String args[]) {
        boolean parar = true;

        while (parar == true) {// continuar até escrever FIM
            String s = MyIO.readLine();
            if (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
                parar = false;
            } else {

                MyIO.println(cesar(s));//se a palavra nao for FIM printa a palavra cifrada
            }

        }
    }

    public static String cesar(String s) {//metodo para o ciframento
        int chave = 3;//chave do gabarito
        String n = "";
        for (int i = 0; i < (s.length()); i++) {//percorre todas as letras da string
            n += (char) (s.charAt(i) + chave);//adciona as letras + 3(tabela ascii) uma por uma na string
        }

        return n;
    }
}