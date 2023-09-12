package Tp1;
/*Crie um método iterativo que recebe uma string e retorna true se a mesma é composta somente por vogais.
Crie outro método iterativo que recebe uma string e retorna true se a mesma é composta somente por consoantes. 
Crie um terceiro método iterativo que recebe uma string e retorna true se a mesma corresponde a um número inteiro. 
Crie um quarto método iterativo que recebe uma string e retorna true se a mesma corresponde a um número real.

Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma X1 X2 X3 X4 onde cada Xi é um booleano indicando se a é entrada é:
 composta somente por vogais (X1); composta somente somente por consoantes (X2); um número inteiro (X3); um número real (X4). Se Xi for verdadeiro, seu valor será SIM, caso contrário, NÃO. */
public class TP01Q06 {
    public static boolean isVogal(String s) {
        boolean vogal = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a' && s.charAt(i) != 'A' && s.charAt(i) != 'e' && s.charAt(i) != 'E'
                    && s.charAt(i) != 'i' && s.charAt(i) != 'I' && s.charAt(i) != 'o' && s.charAt(i) != 'O'
                    && s.charAt(i) != 'u' && s.charAt(i) != 'U') {
                vogal = false;
                i = s.length();
            }
        }
        return vogal;
    }

    public static boolean isConsoante(String s) {
        boolean consoante = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E'
                    || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O'
                    || s.charAt(i) == 'u' || s.charAt(i) == 'U'||s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3'
                    || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7'
                    || s.charAt(i) == '8' || s.charAt(i) == '9') {
                consoante = false;
                i = s.length();
            }
        }
        return consoante;
    }

    public static boolean isNum(String s) {
        boolean numero = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2' && s.charAt(i) != '3'
                    && s.charAt(i) != '4' && s.charAt(i) != '5' && s.charAt(i) != '6' && s.charAt(i) != '7'
                    && s.charAt(i) != '8' && s.charAt(i) != '9') {
                numero = false;
                i = s.length();
            }

        }
        return numero;
    }

    public static boolean isNumReal(String s) {
        boolean numero = true;
        int pontos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' || s.charAt(i) == ',') {// se a letra for um . ou uma , add +1
                pontos++;
            } else if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2' && s.charAt(i) != '3'
                    && s.charAt(i) != '4' && s.charAt(i) != '5' && s.charAt(i) != '6' && s.charAt(i) != '7'
                    && s.charAt(i) != '8' && s.charAt(i) != '9') {
                numero = false;// se não for . ou , e nao for um numero, a resp é falsa

                i = s.length();
            }
            if (pontos > 1) {// se tiver mais de um ponto ou vírgula o numero nao é real
                numero = false;
            }
        }
        return numero;
    }
    public static boolean confirmar(String s) {
        boolean parar = true;
        if (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
                parar = false;
            }
            return parar;
    }

    public static void main(String args[]) {
           String s = MyIO.readLine();
        while (confirmar(s)) {// continuar até escrever FIM
            
             if (isVogal(s) == true) {
                MyIO.print("SIM ");
            } else {// se não for escreve não
                MyIO.print("NAO ");
            }
            if (isConsoante(s) == true) {
                MyIO.print("SIM ");
            } else {// se não for escreve não
                MyIO.print("NAO ");
            }
            if (isNum(s) == true) {
                MyIO.print("SIM ");
            } else {// se não for escreve não
                MyIO.print("NAO ");
            }
            if (isNumReal(s) == true) {
                MyIO.println("SIM ");
            } else {// se não for escreve não
                MyIO.println("NAO ");
            }
             s = MyIO.readLine();
        }
    }
}
