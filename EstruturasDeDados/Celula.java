/*CÉLULA PARA ESTRUTURAS FLEXIVEIS */

public class Celula {
    public int elemento;
    Celula prox;
    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.elemento=x;
        this.prox=null;
    }
}
