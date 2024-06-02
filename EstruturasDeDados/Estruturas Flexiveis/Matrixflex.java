public class Matrixflex {
    CelulaMatrix inicio;
    int linha, coluna;
    Matrixflex(){

    }
    Matrixflex(int l,int c){
  this.linha=l;
  this.coluna=c;
  inicio= new CelulaMatrix();
  CelulaMatrix col =inicio;
  for(int i=1;i<c;i++,col=col.dir){
    col.dir=new CelulaMatrix();
    col.dir.esq=col;
  }
  CelulaMatrix lin=inicio;
  for(int j=1;j<l;j++,lin=lin.inf){
    lin.inf=new CelulaMatrix();
    lin.inf.sup=lin;
    col=lin.inf;
    for(int i=1;i<c;i++,col=col.dir){
      col.dir=new CelulaMatrix();
      col.dir.esq=col;
      col.dir.sup=col.sup.dir;
      col.sup.dir.inf=col.dir;
    }
  }
    }
 
}
