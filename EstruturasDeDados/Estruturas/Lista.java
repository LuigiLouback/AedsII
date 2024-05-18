/*LISTA  */
class Lista {
    int[] array;
    int n;

    Lista(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    void inserirInicio(int x) {
        if (n >= array.length) {
            System.out.println("Da pra fazer isso não amigo");
        } else {

            for (int i = n; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = x;
            n++;
        }
    }

    void inserirFim(int x) {
        if (n >= array.length) {
            System.out.println("Da pra fazer isso não amigo");
        } else {
            array[n] = x;
            n++;
        }
    }

    void inserir(int x, int pos) {
        if (n >= array.length || pos < 0 || pos > n) {
            System.out.println("Da pra fazer isso não amigo");
        } else {
            for (int i = n; i > pos; i--) {
                array[i] = array[i - 1];

            }
            array[pos] = x;
            n++;
        }
    }

    int removerInicio() {
  if(n==0){
    System.out.println("eita não pode remover não");
    return 0;
  }
  else{
    int resp=array[0];
    n--;
    for(int i=1;i<n;i++){
        array[i-1]=array[i];
    }
    
    return resp;
  }
    }

    int removerFim() {
        if(n==0){
            System.out.println("eita não pode remover não");
            return 0;
          }
          else{
            n--;
            return array[n];
          }
    }

    int remover(int pos) {
        if(n==0){
            System.out.println("eita não pode remover não");
            return 0;
          }
          else{
            int resp=array[pos];
            n--;
            for(int i=pos;i<n;i++){
                array[i]=array[i+1];
            }
           return resp;
          }
    }

    void mostrar() {
        System.out.print("[ ");
        for (int i = 0; i < n; i++){
        System.out.print(array[i] + " ");
        }
        System.out.println(" ]");
    }

public static void main(String[] args) {
    System.out.println("==== LISTA LINEAR ====");
Lista lista = new Lista(6);
int x1, x2, x3;
lista.inserirInicio(1);
lista.inserirFim(7);
lista.inserirFim(9);
lista.inserirInicio(3);
lista.inserir(8, 3);
lista.inserir(4, 2);
lista.mostrar();
x1 = lista.removerInicio();
x2 = lista.removerFim();
x3 = lista.remover(2);
System.out.print(x1 + ", " + x2 + ", " + x3);
System.out.println();
lista.mostrar();
}
}
