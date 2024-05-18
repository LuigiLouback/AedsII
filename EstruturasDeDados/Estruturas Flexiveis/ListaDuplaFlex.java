class ListaDuplaFlex{
Celuladupla primeiro,ultimo;
ListaDuplaFlex(){
    primeiro=new Celuladupla();
    ultimo=primeiro;
}



public void inserirInicio(int x) { 
primeiro.elemento=x;
primeiro.ant=new Celuladupla();
primeiro.ant.prox=primeiro;
primeiro=primeiro.ant;

 }


public void inserirFim(int x) { 
  ultimo.prox=new Celuladupla(x);
  ultimo.prox.ant=ultimo;
  ultimo=ultimo.prox;
}


public int removerInicio() { 
    int element = -1;
if(primeiro==ultimo){
    System.out.println("Erro ao remover, lista vazia");
}
else{
    Celuladupla tmp=primeiro;
    primeiro=primeiro.prox;
 element=primeiro.elemento;
 tmp.prox = primeiro.ant = null;
 tmp = null;
 
}
return element;
}


public int removerFim() { 
    int remover=-1;
    if(primeiro==ultimo){
        System.out.println("erro ao remover, lsita vazia");
    }
    else{
        remover=ultimo.elemento;
        ultimo=ultimo.ant;
        ultimo.prox.ant=null;
        ultimo.prox=null;
    }
    return remover;
}


public void inserir(int x, int pos) { 
//verificações de tamanho etc
/*..... */
    Celuladupla i = primeiro;
    for (int j = 0; j < pos; j++, i = i.prox);
    Celuladupla tmp = new Celuladupla(x);
    tmp.ant = i;
    tmp.prox = i.prox;
    tmp.ant.prox = tmp.prox.ant = tmp;
    tmp = i = null;

}


public int remover(int pos) { 
    int elemento=-1;
if(primeiro==ultimo){
    System.out.print("ERRO");
}
else{
    Celuladupla i = primeiro; for (int j = 0; j <= pos; j++, i = i.prox);
i.ant.prox = i.prox; i.prox.ant = i.ant;
elemento = i.elemento; i = i.prox = i.ant = null;
}
return elemento;
}


public void mostrar() { 
    System.out.print("[ ");
        for (Celuladupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");

        }
        System.out.println("]");
}


}