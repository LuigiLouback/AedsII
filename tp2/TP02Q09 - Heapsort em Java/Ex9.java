import java.util.*;
//import java.time.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
 class Personagens {
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private   String ancestry;
    private String species;
    private  String patronus;
    private  Boolean hogwartsStaff;
    private  Boolean hogwartsStudent;
    private String actorName;
    private  Boolean alive;
    private Date dateOfBirth;
    private  int yearOfBirth;
    private String eyeColour;
    private String gender;
    private   String hairColour;
    private  Boolean wizard;
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
        setDateOfBirth(datawizard[1]);// index 0 é sempre um valor "lixo"
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
  public class Ex9{
 
    public static int getMaiorFilho(int i, int tamHeap, Personagens[] nomesInseridos) {
        int filho;
    
       
        if (2 * i == tamHeap || nomesInseridos[2 * i].getHairColour().compareTo(nomesInseridos[2 * i + 1].getHairColour()) > 0) {
            filho = 2 * i; 
        } else if (nomesInseridos[2 * i].getHairColour().compareTo(nomesInseridos[2 * i + 1].getHairColour()) == 0) {
            // Se as cores de cabelo dos filhos à esquerda e à direita forem iguais, desempata comparando os nomes
            if (nomesInseridos[2 * i].getName().compareTo(nomesInseridos[2 * i + 1].getName()) > 0) {
                filho = 2 * i; 
            } else {
                filho = 2 * i + 1; 
            }
        } else {
            filho = 2 * i + 1; 
        }
    
        return filho;
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


        //HEAPSORT         
   int numcomp=0;
   int nummovi=0;

        Personagens[] tmp = new Personagens[z+1];
        for(int i = 0; i < z; i++){
           tmp[i+1] = nomesInseridos[i];
        }
        nomesInseridos = tmp;
  
        for (int tamHeap = 2; tamHeap <= z; tamHeap++) {
            for (int i = tamHeap; i > 1; i /= 2) {
                // Se as cores do cabelo forem iguais, compare os nomes
                if (nomesInseridos[i].getHairColour().equals(nomesInseridos[i / 2].getHairColour())) {
                    // Compare os nomes
                    if (nomesInseridos[i].getName().compareTo(nomesInseridos[i / 2].getName()) > 0) {
                        // Troca os elementos no heap se o nome for maior
                        numcomp++;
                        Personagens temp = nomesInseridos[i];
                        nomesInseridos[i] = nomesInseridos[i / 2];
                        nomesInseridos[i / 2] = temp;
                        nummovi++;
                    } else {
                        break; //os nomes estão em ordem correta
                    }
                } else {
                    // Se as cores do cabelo forem diferentes, compare-as diretamente
                    if (nomesInseridos[i].getHairColour().compareTo(nomesInseridos[i / 2].getHairColour()) > 0) {
                        // Troca os elementos no heap se a cor do cabelo for maior
                        numcomp++;
                        Personagens temp = nomesInseridos[i];
                        nomesInseridos[i] = nomesInseridos[i / 2];
                        nomesInseridos[i / 2] = temp;
                        nummovi++;
                    } else {
                        break; // as cores do cabelo estão em ordem correta
                    }
                }
            }
        }


        
    
        //Ordenacao propriamente dita
        int tamHeap = z;
        while (tamHeap > 1) {
            Personagens temp = nomesInseridos[1];
            nomesInseridos[1] = nomesInseridos[tamHeap];
            nomesInseridos[tamHeap] = temp;
            tamHeap--;
            int i = 1;
            while (i <= (tamHeap / 2)) {
                int filho = getMaiorFilho(i, tamHeap, nomesInseridos);
                if (nomesInseridos[i].getHairColour().equals(nomesInseridos[filho].getHairColour())) {
                    if (nomesInseridos[i].getName().compareTo(nomesInseridos[filho].getName()) < 0) {
                        temp = nomesInseridos[i];
                        nomesInseridos[i] = nomesInseridos[filho];
                        nomesInseridos[filho] = temp;
                        i = filho;
                    } else {
                        i = tamHeap;
                    }
                } else {
                    if (nomesInseridos[i].getHairColour().compareTo(nomesInseridos[filho].getHairColour()) < 0) {
                        temp = nomesInseridos[i];
                        nomesInseridos[i] = nomesInseridos[filho];
                        nomesInseridos[filho] = temp;
                        i = filho;
                    } else {
                        i = tamHeap;
                    }
                }
            }
        }
  
        //Alterar o vetor para voltar a posicao zero
        tmp = nomesInseridos;
        nomesInseridos = new Personagens[z];
        for(int i = 0; i < z; i++){
           nomesInseridos[i] = tmp[i+1];
        }
     
  
  



        for(int u=0;u<nomesInseridos.length;u++){
            //confere o id da entrada e do personagem
            if(nomesInseridos[u]!=null)
               nomesInseridos[u].imprimir();
            
        }






        long endTime = System.nanoTime(); // Captura o tempo de término da execução
        long duration = (endTime - startTime) / 1000000; // Calcula o tempo total de execução em milissegundos

        // Escreve os dados capturados em um arquivo de log
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrícula_heapsort.txt"))) {
            // Escreve a matrícula, o tempo de execução e o número de comparações separados por tabulação
            writer.write("814143\t" + duration + "\t" + numcomp + "\t"+(3*nummovi) );
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
  
    
    

