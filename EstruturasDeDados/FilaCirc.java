/*FILA CIRCULAR  */
public class FilaCirc {
    int ultimo;
    int primeiro;
    int[] array;

    FilaCirc(int tamanho){
    array=new int[tamanho+1];
    primeiro=ultimo=0;
    }

    void inserir(int x){
        if((ultimo +1)% array.length==primeiro){
            System.out.println("pode fazer isso nao parceiro a fila ta cheia");
        }
        else{
      array[ultimo]=x;
      ultimo=(ultimo+1)%array.length;
        }
    }
    int remover(){
        int resp=0;
        if(primeiro==ultimo){
            System.out.println("erro amigao n tem ngm pra remover");
        }
        else{
            resp=array[primeiro];
            primeiro=(primeiro+1)%array.length;
        }
        return resp;
    }
    void mostrar(){
        System.out.print("[ ");
        for(int i=primeiro; i!=ultimo;i=((i+1)%array.length)){
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }

    void isVazio(){
        if(primeiro==ultimo){
            System.out.println("a fila ta vazia");
        }
        else{
            System.out.println("a fila não ta vazia");
        }
    }

    void pesquisar (int elemento){
        boolean resp=false;
        for(int i=primeiro;i!=ultimo;i=((i+1)%array.length)){
            if(array[i]==elemento){
                resp=true;
                break;
            }
            else{
                resp=false;
            }
        }
        if(resp==true){
            System.out.println("elemento ta aq");
        }
        else{
            System.out.println("elemento nao ta aq");
        }
        
    }
    void retornaPos(int posicao){
        
        if(posicao>=array.length){
          System.out.println("posição invalida ");
        }
        else {
            int index = (primeiro + posicao) % array.length;
            System.out.println("O elemento nessa posição é " + array[index]);
        }
        }
  int removeMaiorQueDez(){
    int resp=-1;
    if(primeiro==ultimo){
        System.out.println("erro amigao n tem ngm pra remover");
    }
    for(int i=primeiro;i!=ultimo;i=((i+1)%array.length)){
        if(array[i]>10){
            resp=array[i];
            for(int k=i;k!=ultimo;k=((k+1)%array.length)){
              array[k]=array[k+1]%array.length;
            }
            ultimo = (ultimo - 1 + array.length) % array.length;
            
        }
        
    }
    return resp;
  }
       

    public static void main (String []args){
        System.out.println("==== FILA ESTATICA ====");
        FilaCirc fila = new FilaCirc(5);
        int x1, x2, x3;
  
        fila.inserir(5);
        fila.inserir(7);
        fila.inserir(8);
        fila.inserir(9);
        System.out.println("Apos insercoes(5, 7, 8, 9): ");
        fila.mostrar();
        x1 = fila.remover();
        x2 = fila.remover();
  
        System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
        fila.mostrar();
        fila.inserir(3);
        fila.inserir(4);
  
  
        System.out.println("Apos insercoes(3, 4): ");
        fila.mostrar();
        x1 = fila.remover();
      x2 = fila.remover();
      x3 = fila.remover();

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
      fila.mostrar();
      fila.inserir(4);
      fila.inserir(5);

      System.out.println("Apos insercoes(4, 5): ");
      fila.inserir(13);
      fila.mostrar();
      fila.inserir(5);
      fila.mostrar();
    fila.pesquisar(5);
    fila.retornaPos(3);
    x1= fila.removeMaiorQueDez();
    System.out.println(x1);
    fila.mostrar();
    }
}
