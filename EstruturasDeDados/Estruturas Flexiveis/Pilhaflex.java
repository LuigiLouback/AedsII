
/*PILHA FLEXIVEL */
public class Pilhaflex {
  Celula topo;

  public Pilhaflex() {
    this.topo = null;
  }

  void inserir(int x) {
    Celula tmp = new Celula(x);
    tmp.prox = topo;
    topo = tmp;
    tmp = null;
  }

  int remover() /* throws Exception */ {
    if (topo == null)
      // throw new Exception("Erro!");
      System.out.println("erro na remoção a pilha esta vazia");
    int resp = topo.elemento;
    Celula tmp = topo;
    topo = topo.prox;
    tmp.prox = null;
    tmp = null;
    return resp;
  }

  void mostrarrecursivo(Celula i) {
    if (i != null) {

      System.out.print(" " + i.elemento);
      mostrarrecursivo(i.prox);
    }

  }

  void mostrarIterativo() {
    Pilhaflex outro = new Pilhaflex();
    for (Celula i = topo; i != null; i = i.prox) {
      outro.inserir(i.elemento);
    }
    outro.mostrar();
  }

  void mostrar() {
    System.out.print("[ ");
    for (Celula i = topo; i != null; i = i.prox) {
      System.out.print(i.elemento + " ");
    }
    System.out.println("]");
  }

  int somaDosElementos() {
    Celula i = topo;
    return somaDosElementos(0, i);
  }

  int somaDosElementos(int x, Celula i) {
    int resp = 0;
    if (i != null) {
      x++;
      resp = i.elemento + somaDosElementos(x, i.prox);
    }

    return resp;
  }

  int recursivoretornaMaior() {
    return recursivoretornaMaior(topo, topo.elemento);
  }

  int recursivoretornaMaior(Celula topo, int maior) {
    if (topo != null) {
      if (topo.elemento > maior) {
        maior = topo.elemento;
      }
      return recursivoretornaMaior(topo.prox, maior);
    }
    return maior;
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("TESTE DA PILHA FLEXIVEL");
    Pilhaflex pilha = new Pilhaflex();
    pilha.inserir(3);
    pilha.inserir(7);
    pilha.inserir(10);
    pilha.inserir(11);
    pilha.inserir(7);
    pilha.inserir(43);
    System.out.println("INSERI 3 7 10 11 7 43");
    pilha.mostrar();
    pilha.remover();
    System.out.println("REMOVI 1");
    pilha.mostrar();
    System.out.println(pilha.somaDosElementos());
    pilha.mostrar();
    System.out.println(pilha.recursivoretornaMaior());
    pilha.inserir(40);
    pilha.mostrar();
    System.out.println(pilha.recursivoretornaMaior());
    pilha.mostrarrecursivo(pilha.topo);
    System.out.println("");
    pilha.mostrarIterativo();
  }
}