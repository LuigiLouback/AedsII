
public class CelulaMatrix {
int elemento;
CelulaMatrix sup,esq,dir,inf;
    CelulaMatrix(){

    }
    CelulaMatrix(int elemento){
        this.elemento=elemento;
        sup=esq=dir=inf=null;
    }
}
