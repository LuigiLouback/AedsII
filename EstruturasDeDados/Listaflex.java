/*LISTA FLEXIVEL  */

public class Listaflex {
    Celula primeiro;
    Celula ultimo;

    Listaflex() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    int tamanho() {
        int tamanho = 0;
        Celula i;
        for (i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

    void inserirFim(int x) {// igual a fila
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    int removerInicio() {// igual a fila
        int resp = -1;
        if (primeiro == ultimo) {
            System.out.println("erro");
        } else {
            resp = primeiro.elemento;
            Celula tmp = primeiro;
            primeiro = tmp.prox;
            tmp.prox = null;
            tmp = null;
        }

        return resp;
    }

    int removerFim() {
        int resp = -1;
        if (ultimo == primeiro)
            System.out.print("erro pra remover");
        else {
            resp = ultimo.elemento;
            Celula i = primeiro;
            while (i.prox != ultimo) {
                i = i.prox;
            }
            ultimo = i;
            i.prox = null;
            i = null;
        }
        return resp;
    }

    void inserirPos(int x, int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            System.out.println("Erro!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    int remover(int pos) {
        int elemento = -1, tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            System.out.println("Erro!");
        } else if (pos == 0) {
            removerInicio();
        } else if (pos == tamanho - 1) {
            removerFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
        return elemento;
    }

    void mostrar() {
        System.out.print("[ ");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");

        }
        System.out.println("]");
    }
}

class Main3 {
    public static void main(String[] args) {
        Listaflex lista = new Listaflex();
        System.out.println("inserir 1 3 ");
        lista.inserirInicio(1);
        lista.inserirInicio(3);
        lista.mostrar();
        System.out.println("inserir no final o 5");
        lista.inserirFim(5);
        lista.mostrar();
        lista.inserirPos(10, 2);
        lista.mostrar();
        lista.remover(2);
        lista.mostrar();
        lista.inserirFim(40);
        lista.mostrar();
        lista.removerFim();
        lista.removerInicio();
        lista.mostrar();
    }
}