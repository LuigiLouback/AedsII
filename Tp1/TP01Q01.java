package Tp1;

/*Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo. Na saída padrão, para cada linha de entrada,
 escreva uma linha de saída com SIM/NÃO indicando se a linha é um palíndromo. Destaca-se que uma linha de entrada pode ter caracteres não letras. */
public class TP01Q01 {
    public static void main(String args[]) {
        boolean parar = true;

        while (parar == true) {// continuar até escrever FIM
            String s = MyIO.readLine();
            if (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
                parar = false;
            }

            else if (isPalindromo(s) == true) {// se for palíndromo escreve sim
                MyIO.println("SIM");
            } else {// se não for escreve não
                MyIO.println("NAO");
            }
        }

    }

    public static boolean isPalindromo(String s) {// método para verificar se é palíndromo
        boolean resp = true;
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {// compara a primeira e a ultima letra da palavra
                resp = false;
                i = s.length();// condição de parada
            }
        }
        return resp;
    }

}