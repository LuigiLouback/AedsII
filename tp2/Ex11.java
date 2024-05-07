import java.util.*;
//import java.time.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

//import java.time.format.DateTimeFormatter;
 class Personagens {
  private  String id;
  private   String name;
  private   List<String> alternate_names;
  private   String house;
  private  String ancestry;
  private  String species;
  private   String patronus;
  private   Boolean hogwartsStaff;
  private   Boolean hogwartsStudent;
  private    String actorName;
  private    Boolean alive;
     Date dateOfBirth;
     private  int yearOfBirth;
     private   String eyeColour;
     private   String gender;
     private  String hairColour;
     private   Boolean wizard;
    SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
    public Personagens() {

    }

    public Personagens(String id, String name, List<String> alternate_names, String house, String ancestry,
            String species, String patronus,
            Boolean hogwartsStaff, Boolean hogwartsStudent, String actorName, Boolean alive, String dateOfBirth,
            int yearOfBirth, String eyeColour, String gender, String hairColour, Boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        setDateOfBirth(dateOfBirth);
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAlternateNames() {
        return alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public String getPatronus() {
        return patronus;
    }

    public Boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public Boolean isHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public Boolean getisAlive() {
        return alive;
    }

    public Date getDateOfBirth() {
       return dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public Boolean isWizard() {
        return wizard;
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlternateNames(List<String> alternate_names) {
        this.alternate_names = alternate_names;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            this.dateOfBirth = formato.parse(dateOfBirth);
        } catch (ParseException e) {
            System.err.println(e);
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }
    public Personagens clone() {
        Personagens cloned = new Personagens();
        cloned.id = this.id;
        cloned.name = this.name;
        cloned.alternate_names = new ArrayList<>(this.alternate_names);
        cloned.house = this.house;
        cloned.ancestry = this.ancestry;
        cloned.species = this.species;
        cloned.patronus = this.patronus;
        cloned.hogwartsStaff = this.hogwartsStaff;
        cloned.hogwartsStudent = this.hogwartsStudent;
        cloned.actorName = this.actorName;
        cloned.alive = this.alive;
        cloned.dateOfBirth = this.dateOfBirth;
        cloned.yearOfBirth = this.yearOfBirth;
        cloned.eyeColour = this.eyeColour;
        cloned.gender = this.gender;
        cloned.hairColour = this.hairColour;
        cloned.wizard = this.wizard;
        return cloned;
    }



    public void ler(String linha) {
        String testes[] = linha.split("\\[");//primeiro split
        List<String> valoresTeste2 = new ArrayList<>();
        for (int i = 0; i < testes.length; i++) {
            String testes2[] = testes[i].split("]");//segundo split
             //separa a linha em 5 partes:
             //a primeira (index 0) é id e nome 
            //a segunda(index 1) é a lista dos nomes alternativos
            //a terceira (index 2) é de house até alive
            //a quarta (index 3) linha é a outra lista que não pede no exercicio
            //a quinta (index 4) é da data ate wizard
            for (int j = 0; j < testes2.length; j++) {
                valoresTeste2.add(testes2[j]);
            }
        }
        List<String> alternateNamesList = new ArrayList<>();
        String textosemaspas = valoresTeste2.get(1).replace("'", "");//tirar as aspas dos nomes alternativos
        String listaNomes[] = textosemaspas.split(",");//colocar cada nome na lista
        for (String nome : listaNomes) {
            alternateNamesList.add(nome.trim()); // Adicione cada nome à lista (trim() remove espaços em branco extras)
        }
        setAlternateNames(alternateNamesList);

        String idnome[] = valoresTeste2.get(0).split(";");// split pra pegar o ID e o nome 


        String humanalive[] = valoresTeste2.get(2).split(";");// house ate alive
        for (int n = 0; n < humanalive.length; n++) {//se não tiver valor coloca 0
            if (humanalive[n].equals("VERDADEIRO")) {
                humanalive[n] = "true";
            }
            else if(humanalive[n].equals("FALSO")) {
                humanalive[n] = "false";
        }
    }

        String datawizard[] = valoresTeste2.get(4).split(";");// data ate wizard
        for (int m = 0; m < datawizard.length; m++) {//se nao tiver valor coloca 0
            if (datawizard[m].equals("VERDADEIRO")) {
                datawizard[m] = "true";
            }
            else if(datawizard[m].equals("FALSO")) {
                datawizard[m] = "false";
        }}
   
 
        setId(idnome[0]);
        setName(idnome[1]);
        setHouse(humanalive[1]);// index 0 é sempre um valor "lixo"
        setAncestry(humanalive[2]);
        setSpecies(humanalive[3]);
        setPatronus(humanalive[4]);
        setHogwartsStaff(Boolean.parseBoolean(humanalive[5]));
        setHogwartsStudent(Boolean.parseBoolean(humanalive[6]));
        setActorName(humanalive[7]);
        setAlive(Boolean.parseBoolean(humanalive[8]));
    
       setDateOfBirth((datawizard[1]));// index 0 é sempre um valor "lixo"
        setYearOfBirth(Integer.parseInt(datawizard[2]));
        setEyeColour(datawizard[3]);
        setGender(datawizard[4]);
        setHairColour(datawizard[5]);
        setWizard(Boolean.parseBoolean(datawizard[6]));
    }
  public void imprimir (){
    String alternateNamesString = "{";//o verde imprime com chave :(
    for (String alternateName : alternate_names) {
        alternateNamesString += alternateName + ", ";
    }
    
    if (alternate_names.size() > 0) {
        alternateNamesString = alternateNamesString.substring(0, alternateNamesString.length() - 2);
    }
    alternateNamesString += "}";

    System.out.println("["+id+" ## "+name+" ## "+alternateNamesString+" ## "+house+" ## "+ancestry+" ## "+species+" ## "+patronus+" ## "+hogwartsStaff+" ## "+hogwartsStudent+
    " ## "+actorName+" ## "+alive+" ## "+formato.format(dateOfBirth)+" ## "+yearOfBirth+" ## "+eyeColour+" ## "+gender+" ## "+hairColour+" ## "+wizard+"]");
  }
}
  public class Ex11{


   public static void countingSort(Personagens[] nomesinseridos, int n) {
    if (n <= 0) {
        return; 
    }
    int menorAno = nomesinseridos[0].getYearOfBirth();
    int maiorAno = nomesinseridos[0].getYearOfBirth();
    for (int i = 1; i < n; i++) {
        int ano = nomesinseridos[i].getYearOfBirth();
        if (ano < menorAno) {
            menorAno = ano;
        }
        if (ano > maiorAno) {
            maiorAno = ano;
        }
    }
    int range = maiorAno - menorAno + 1;
    int[] count = new int[range];
    for (int i = 0; i < n; i++) {
        int index = nomesinseridos[i].getYearOfBirth() - menorAno;
        count[index]++;
    }
    for (int i = 1; i < range; i++) {
        count[i] += count[i - 1];
    }
    Personagens[] ordenado = new Personagens[n];
    for (int i = n - 1; i >= 0; i--) {
        int ano = nomesinseridos[i].getYearOfBirth();
        int index = ano - menorAno;
        count[index]--;
        ordenado[count[index]] = nomesinseridos[i];
    }
    for (int i = 0; i < n; i++) {
        nomesinseridos[i] = ordenado[i];
    }
    ordenarPorNomeDentroDoMesmoAno(nomesinseridos, n);
}

private static void ordenarPorNomeDentroDoMesmoAno(Personagens[] nomesinseridos, int n) {
    int start = 0;
    while (start < n) {
        int ano = nomesinseridos[start].getYearOfBirth();
        int end = start + 1;

        // Encontrar o subarray com o mesmo ano de nascimento
        while (end < n && nomesinseridos[end].getYearOfBirth() == ano) {
            end++;
        }

        // Ordenar o subarray por nome usando ordenação por inserção
        ordenarPorInsercaoPorNome(nomesinseridos, start, end);

        start = end; // Avançar para o próximo grupo com um ano diferente
    }
}

private static void ordenarPorInsercaoPorNome(Personagens[] nomesinseridos, int start, int end) {
    for (int i = start + 1; i < end; i++) {
        Personagens chave = nomesinseridos[i];
        int j = i - 1;

        // Comparar o nome dos nomesinseridos
        while (j >= start && nomesinseridos[j].getName().compareTo(chave.getName()) > 0) {
            nomesinseridos[j + 1] = nomesinseridos[j];
            j--;
        }

        nomesinseridos[j + 1] = chave;
    }
}






    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Personagens> personagens=new ArrayList<>();
      
        Scanner sc = new Scanner(System.in);
     
        String nomeArquivo = "/tmp/characters.csv";

        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String receba;
           //ler as linhas do arquivo e adcionar na lista de personagens
            bufferedReader.readLine();
            while ((receba = bufferedReader.readLine()) != null) {
                Personagens personagem = new Personagens();
                personagem.ler(receba);
                personagens.add(personagem);
            }

            bufferedReader.close(); 
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        //ler id da entrada
        int z=0;
        Personagens nomesInseridos[]=new Personagens[1000];
        String linhalida=sc.nextLine();
        while(!linhalida.equals("FIM")){
            for(int u=0;u<personagens.size();u++){
                //confere o id da entrada e do personagem
               if(linhalida.equals(personagens.get(u).getId())){
                nomesInseridos[z]=personagens.get(u);
                z++;
              //      personagens.get(u).imprimir();
                }
            }
           linhalida=sc.nextLine();
        }

  countingSort(nomesInseridos, z);

       
         
      
      
          
        for(int u=0;u<nomesInseridos.length;u++){
            //confere o id da entrada e do personagem
            if(nomesInseridos[u]!=null)
               nomesInseridos[u].imprimir();
            
        }




int numcomp=0;
int nummovi=0;

        long endTime = System.nanoTime(); // Captura o tempo de término da execução
        long duration = (endTime - startTime) / 1000000; // Calcula o tempo total de execução em milissegundos

        // Escreve os dados capturados em um arquivo de log
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrícula_countingsort.txt"))) {
            // Escreve a matrícula, o tempo de execução e o número de comparações separados por tabulação
           writer.write("814143\t" + duration + "\t" + numcomp + "\t" +( 3*nummovi) );
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
  
    
    

