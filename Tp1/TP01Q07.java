package Tp1;
/* Leia duas strings sendo que a primeira é o nome de uma página web e a segunda, seu endereço. 
Por exemplo, Pontifícia Universidade Católica de Minas Gerais e www.pucminas.br. Em seguida, mostre na tela o número de vogais (sem e com acento), 
consoantes e dos padrões <br> e <table> que aparecem no código dessa página. A entrada padrão é composta por várias linhas. 
Cada uma contém várias strings sendo que a primeira é um endereço web e as demais o nome dessa página web. A última linha da entrada padrão contém a palavra FIM.


A saída padrão contém várias linhas sendo que cada uma apresenta o número de ocorrência (valor xi entre parênteses) de cada caractere ou string solicitado.
 Cada linha de saída será da seguinte forma: a(x1) e(x2) i(x3) o(x4) u(x5) á(x6) é(x7) í(x8) ó(x9) ú(x10) à(x11) è(x12) ì(x13) ò(x14) ù(x15) ã(x16) õ(x17) â(x19) ê(x19)
  î(x20) ô(x21) û(x22) consoante(x23) <br>{x24) <table>(x25) nomepágina(x26).*/
import java.io.*;
import java.net.*;

public class TP01Q07 {
    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static void exercício(String html, String s) {
        int a = 0, e = 0, i = 0, o = 0, u = 0, a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0, a3 = 0, e3 = 0, i3 = 0, o3 = 0,
                u3 = 0, a4 = 0, o4 = 0, a5 = 0, e5 = 0, i5 = 0, o5 = 0, u5 = 0, cons = 0, br = 0, table = 0;
        for (int n = 0; n < html.length(); n++) {
            if (html.charAt(n) == 'a') {//contando cada letra pedida
                a++;
            } else if (html.charAt(n) == 'a') {
                a++;
            } else if (html.charAt(n) == 'e') {
                e++;
            } else if (html.charAt(n) == 'i') {
                i++;
            } else if (html.charAt(n) == 'o') {
                o++;
            } else if (html.charAt(n) == 'u') {
                u++;
            } else if (html.charAt(n) == '\u00e1') {
                a2++;
            } else if (html.charAt(n) == '\u00e9') {
                e2++;
            } else if (html.charAt(n) == '\u00ed') {
                i2++;
            } else if (html.charAt(n) == '\u00f3') {
                o2++;
            } else if (html.charAt(n) == '\u00fa') {
                u2++;
            } else if (html.charAt(n) == '\u00e0') {
                a3++;
            } else if (html.charAt(n) == '\u00e8') {
                e3++;
            } else if (html.charAt(n) == '\u00ec') {
                i3++;
            } else if (html.charAt(n) == '\u00f2') {
                o3++;
            } else if (html.charAt(n) == '\u00f9') {
                u3++;
            } else if (html.charAt(n) == '\u00e3') {
                a4++;
            } else if (html.charAt(n) == '\u00f5') {
                o4++;
            } else if (html.charAt(n) == '\u00e2') {
                a5++;
            } else if (html.charAt(n) == '\u00ea') {
                e5++;
            } else if (html.charAt(n) == '\u00ee') {
                i5++;
            } else if (html.charAt(n) == '\u00f4') {
                o5++;
            } else if (html.charAt(n) == '\u00fb') {
                u5++;
            }

            else if (html.charAt(n) >= 'a' && html.charAt(n) <= 'z') {//contando as consoantes
                cons++;
            } else if (html.charAt(n) == '<') {
                if (html.charAt(n+1) == 'b' && html.charAt(n + 2) == 'r' && html.charAt(n + 3) == '>') {//contando os <br>
                    br++;
                    cons--;
                    cons--;
                } else if (html.charAt(n+1) == 't' && html.charAt(n + 2) == 'a' && html.charAt(n + 3) == 'b'//contando os <table>
                        && html.charAt(n + 4) == 'l' && html.charAt(n + 5) == 'e' && html.charAt(n + 6) == '>') {
                    table++;
                    cons--;
                    a--;
                    cons--;
                    cons--;
                    e--;
                }
            }

        }
        MyIO.println("a(" + a + ") e(" + e + ") i(" + i + ") o(" + o + ") u(" + u + ") á(" + a2 + ") é(" + e2 + ") í("//printar no formato do verde
                + i2 + ") ó(" + o2 + ") ú(" + u2 + ") à(" + a3 + ") è(" + e3 + ") ì(" + i3 + ") ò(" + o3 + ") ù(" + u3
                + ") ã(" + a4 + ") õ(" + o4 + ") â(" + a5 + ") ê(" + e5 + ") î(" + i5 + ") ô(" + o5 + ") û(" + u5
                + ") consoante(" + cons + ") <br>(" + br + ") <table>(" + table + ") " + s);
    }

    public static void main(String args[]) {
        boolean parar = true;
        String endereco, html;
        while (parar == true) {// continuar até escrever FIM
            String s = MyIO.readLine();//titulo 
            if (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
                parar = false;
            } else {
                endereco = MyIO.readLine();//url
                html = getHtml(endereco);
                exercício(html, s);
            }

        }

    }

}
