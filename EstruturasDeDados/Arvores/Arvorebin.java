/*ARVORE BINARIA (DE PESQUISA) */
public class Arvorebin {
    No raiz;

    Arvorebin(){
        raiz=null;
    }



    void inserir(int x){
       raiz=inserir(x,raiz);
    }
   No inserir(int x, No i){
    if(i==null){
    i =new No(x);
    }
    else if(i.elemento>x){
      i.esq= inserir(x,i.esq);
    }
    else if(i.elemento<x){
        i.dir=inserir(x, i.dir);
    }
return i;
    }


    boolean pesquisar(int x){
        return pesquisar(x,raiz);
    }
    boolean pesquisar(int x ,No i){
        boolean resp=false;
        if(i!=null){
            if(x==i.elemento){
                resp=true;
            }
            else if(x>i.elemento){
                resp=pesquisar(x,i.dir);
            }
            else if(x<i.elemento){
                resp=pesquisar(x, i.esq);
            }
        }
        return resp;
    }


    void caminharCentral(){//imprimir em ordem crescente
        caminharCentral(raiz);
    }
    void caminharCentral(No i){
        if(i!=null){
            caminharCentral(i.esq);
            System.out.print(" "+ i.elemento+" ");
            caminharCentral(i.dir);
        } 
    }
    void caminharPreordem(){
        caminharPreordem(raiz);
    }
    void caminharPreordem(No i){
        if(i!=null){
            System.out.print(" "+ i.elemento+" ");
            caminharPreordem(i.esq);
            caminharPreordem(i.dir);
        } 
    }
    void caminharPosordem(){
        caminharPosordem(raiz);
    }
    void caminharPosordem(No i){
        if(i!=null){
            caminharPosordem(i.esq);
            caminharPosordem(i.dir);
            System.out.print(" "+ i.elemento+" ");
            
        } 
    }



    public int getAltura(){
        return getAltura(raiz, 0);
     }
  
    int getAltura(No i, int altura){
        if(i == null){
            altura--;
         } else {
            int alturaEsq = getAltura(i.esq, altura + 1);
            int alturaDir = getAltura(i.dir, altura + 1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
         }
         return altura;
    }




    int somaElementos(){
        return somaElementos(raiz);
    }
    int somaElementos(No i){
        int soma=0;
        if(i!=null){
            soma=i.elemento+(somaElementos(i.esq)+somaElementos(i.dir));
        }
        return soma;
    }




    int elementosPares(){
        return elementosPares(raiz);
    }
    int elementosPares(No i){
        int resp=0;
        if(i!=null){
            if(i.elemento%2==0){
                resp=1+elementosPares(i.dir)+elementosPares(i.esq);
            }
        }
        return resp;
    }



}
class Main4{
    public static void main(String[] args) {
        Arvorebin arvore =new Arvorebin();
        arvore.inserir(34);
        arvore.inserir(8);
        arvore.inserir(37);
        arvore.inserir(10);
        arvore.inserir(155);
        arvore.inserir(17);
        arvore.inserir(13);
        arvore.inserir(1);
        arvore.inserir(45);
        arvore.caminharCentral();
        System.out.println("");
        if(arvore.pesquisar(7)){
            System.out.println("existe");
        }
        else{
            System.out.println("não existe");
        }
       
   arvore.caminharPreordem();
   System.out.println("");
   arvore.caminharPosordem();
   System.out.println("");
   System.out.println("altura da arvore: "+arvore.getAltura());
   System.out.println("Soma dos elementos: "+arvore.somaElementos());
   System.out.println("Numero de elementos pares:  "+arvore.elementosPares());
    }
}
