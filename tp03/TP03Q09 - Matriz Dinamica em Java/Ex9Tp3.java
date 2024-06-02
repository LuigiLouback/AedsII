import java.util.*;
class CelulaMatrix {
  int elemento;
  CelulaMatrix sup, esq, dir, inf;

  CelulaMatrix() {

  }

  CelulaMatrix(int elemento) {
    this.elemento = elemento;
    sup = esq = dir = inf = null;
  }
}

class Matrixflex {
  CelulaMatrix inicio;
  int linha, coluna;

  Matrixflex() {

  }

  Matrixflex(int l, int c) {
    this.linha = l;
    this.coluna = c;
    inicio = new CelulaMatrix();
    CelulaMatrix col = inicio;
    for (int i = 1; i < c; i++, col = col.dir) {
      col.dir = new CelulaMatrix();
      col.dir.esq = col;
    }
    CelulaMatrix lin = inicio;
    for (int j = 1; j < l; j++, lin = lin.inf) {
      lin.inf = new CelulaMatrix();
      lin.inf.sup = lin;
      col = lin.inf;
      for (int i = 1; i < c; i++, col = col.dir) {
        col.dir = new CelulaMatrix();
        col.dir.esq = col;
        col.dir.sup = col.sup.dir;
        col.sup.dir.inf = col.dir;
      }
    }
  }

  public void preencher(int[][] valores) {
    CelulaMatrix lin = inicio;
    for (int i = 0; i < linha; i++) {
      CelulaMatrix col = lin;
      for (int j = 0; j < coluna; j++) {
        if (col != null) {
          col.elemento = valores[i][j];
          col = col.dir;
        }
      }
      lin = lin.inf;
    }
  }

  public void imprimir() {
    CelulaMatrix lin = inicio;
    for (int i = 0; i < linha; i++) {
      CelulaMatrix col = lin;
      for (int j = 0; j < coluna; j++) {
        if (col != null) {
          System.out.print(col.elemento + " ");
          col = col.dir;
        }
      }
      System.out.println();
      lin = lin.inf;
    }
  }

}

public class Ex9Tp3 {
  public static Matrixflex soma(Matrixflex a, Matrixflex b) {
    Matrixflex resp = new Matrixflex(a.linha, a.coluna);
    CelulaMatrix linA = a.inicio, linB = b.inicio, linR = resp.inicio;

    for (int i = 0; i < a.linha; i++) {
      CelulaMatrix colA = linA, colB = linB, colR = linR;
      for (int j = 0; j < a.coluna; j++) {
        colR.elemento = colA.elemento + colB.elemento;
        colA = colA.dir;
        colB = colB.dir;
        colR = colR.dir;
      }
      linA = linA.inf;
      linB = linB.inf;
      linR = linR.inf;
    }
    return resp;
  }

  public static Matrixflex multiplicar(Matrixflex a, Matrixflex b) {
    Matrixflex resp = new Matrixflex(a.linha, b.coluna);
    CelulaMatrix linR = resp.inicio;
    for (int i = 0; i < a.linha; i++) {
      CelulaMatrix colR = linR;
      for (int j = 0; j < b.coluna; j++) {
        CelulaMatrix colA = getCelula(a.inicio, i, 0);
        CelulaMatrix linB = getCelula(b.inicio, 0, j);
        int soma = 0;
        for (int k = 0; k < a.coluna; k++) {
          soma += colA.elemento * linB.elemento;
          colA = colA.dir;
          linB = linB.inf;
        }
        colR.elemento = soma;
        colR = colR.dir;
      }
      linR = linR.inf;
    }

    return resp;
  }

  public static CelulaMatrix getCelula(CelulaMatrix inicio, int linha, int coluna) {
    CelulaMatrix celula = inicio;
    for (int i = 0; i < linha; i++) {
      celula = celula.inf;
    }
    for (int j = 0; j < coluna; j++) {
      celula = celula.dir;
    }
    return celula;
  }

  public static void diaonalprinc(Matrixflex a) {
    CelulaMatrix lin = a.inicio;
    while (lin != null) {
      System.out.print(lin.elemento + " ");
      lin = lin.inf;
      if (lin != null) {
        lin = lin.dir;
      }
    }
    System.out.println();
  }

  public static void diagonalsec(Matrixflex a) {
    CelulaMatrix lin = a.inicio;
    while (lin.dir != null) {
      lin = lin.dir;
    }

    while (lin != null) {
      System.out.print(lin.elemento + " ");
      lin = lin.inf;
      if (lin != null) {
        lin = lin.esq;
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  while(n>0){
    int l1=sc.nextInt();
    int c1=sc.nextInt();
    Matrixflex matriz =new Matrixflex(l1,c1);
    int matrizvalores[][]=new int[l1][c1];
    for (int i = 0; i < l1; i++) {
      for (int j = 0; j < c1; j++) {
          matrizvalores[i][j] = sc.nextInt();
      }
  }
  matriz.preencher(matrizvalores);
  int l2=sc.nextInt();
  int c2=sc.nextInt();
  Matrixflex matriz2 =new Matrixflex(l2,c2);
  int matrizvalores2[][]=new int[l2][c2];
  for (int i = 0; i < l2; i++) {
    for (int j = 0; j < c2; j++) {
        matrizvalores2[i][j] = sc.nextInt();
    }
}
matriz2.preencher(matrizvalores2);
diaonalprinc(matriz);
diagonalsec(matriz);
Matrixflex som = soma(matriz, matriz2);
som.imprimir();
Matrixflex mul = multiplicar(matriz, matriz2);
mul.imprimir();
    n--;
  }

  
  }
}
