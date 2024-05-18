/*FILA FLEXIVEL  */

public class Filaflex {
    Celula primeiro, ultimo;

    Filaflex() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    int remover() {
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
    void mostrar(){
    System.out.print("[ ");
    for(Celula i=primeiro.prox;i!=null;i=i.prox){
     System.out.print(i.elemento+" ");

    }
    System.out.println("]");
    }

    }
    class Main2{
        public static void main(String[] args) {
            Filaflex fila=new Filaflex();
            fila.inserir(3);
            fila.inserir(10);
            fila.inserir(70);
            fila.mostrar();
            fila.remover();
            fila.mostrar();
        }
    }


