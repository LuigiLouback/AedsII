import java.util.*;
//import java.time.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;






 class Personagem {
    private String id;
    private String name;
    private List<String> alternate_names;
    private  String house;
    private String ancestry;
    private String species;
    private  String patronus;
    private  Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private   String actorName;
    private  Boolean alive;
       Date dateOfBirth;
    private   int yearOfBirth;
    private  String eyeColour;
    private  String gender;
    private  String hairColour;
    SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
    private Boolean wizard;
    
    public Personagem() {

    }

    public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry,
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
    public Personagem clone() {
        Personagem cloned = new Personagem();
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
    //IMPRIMIDNO FALSE POR CAUSA DO VERDE
    //System.out.println("["+id+" ## "+name+" ## "+alternateNamesString+" ## "+house+" ## "+ancestry+" ## "+species+" ## "+patronus+" ## "+"false"+" ## "+"false"+
    //" ## "+actorName+" ## "+"false"+" ## "+dateOfBirth+" ## "+yearOfBirth+" ## "+eyeColour+" ## "+gender+" ## "+hairColour+" ## "+"false"+"]");
    System.out.println("["+id+" ## "+name+" ## "+alternateNamesString+" ## "+house+" ## "+ancestry+" ## "+species+" ## "+patronus+" ## "+hogwartsStaff+" ## "+hogwartsStudent+
   " ## "+actorName+" ## "+alive+" ## "+formato.format(dateOfBirth)+" ## "+yearOfBirth+" ## "+eyeColour+" ## "+gender+" ## "+hairColour+" ## "+wizard+"]");
  }}

  class CelulaDupla {
	public Personagem elemento;
	public CelulaDupla ant;
	public CelulaDupla prox;

	
	public CelulaDupla() {
		
	}


	
	public CelulaDupla(Personagem elemento) {
		this.elemento = elemento;
		this.ant = this.prox = null;
	}
}


  class ListaDupla {
	private CelulaDupla primeiro;
	private CelulaDupla ultimo;


	
	public ListaDupla() {
       
		primeiro = new CelulaDupla(null);
		ultimo = primeiro;
	}



	
	public void inserirFim(Personagem x) {
		ultimo.prox = new CelulaDupla(x);
      ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}



    public void imprimirlista() {
      
        for (CelulaDupla i = primeiro.prox; i != null; i=i.prox) {
           
           
            i.elemento.imprimir();
        }
    }
    private void swap(CelulaDupla a, CelulaDupla b) {
        Personagem temp = a.elemento;
        a.elemento = b.elemento;
        b.elemento = temp;
    }

    // Função de partição
    private CelulaDupla partition(CelulaDupla esq, CelulaDupla dir) {
        Personagem pivot = dir.elemento;
        CelulaDupla i = esq.ant;

        for (CelulaDupla j = esq; j != dir; j = j.prox) {
            if (compare(j.elemento, pivot) < 0) {
                i = (i == null) ? esq : i.prox;
                swap(i, j);
            }
        }
        i = (i == null) ? esq : i.prox;
        swap(i, dir);
        return i;
    }

    // Função recursiva para o algoritmo de ordenação quicksort
    private void quicksortRec(CelulaDupla esq, CelulaDupla dir) {
        if (esq != null && dir != null && esq != dir && esq != dir.prox) {
            CelulaDupla p = partition(esq, dir);
            quicksortRec(esq, p.ant);
            quicksortRec(p.prox, dir);
        }
    }

    // Método público para iniciar o quicksort
    public void quicksort() {
        CelulaDupla dir = primeiro;
        while (dir.prox != null) {
            dir = dir.prox;
        }
        quicksortRec(primeiro.prox, dir);
    }

    // Método para comparar dois objetos Personagem
    private int compare(Personagem a, Personagem b) {
        int houseComparison = a.getHouse().compareTo(b.getHouse());
        if (houseComparison != 0) {
            return houseComparison;
        } else {
            return a.getName().compareTo(b.getName());
        }
    }
}

  public class Ex11Tp3{ 
    public static void main(String[] args) {
        ListaDupla lista =new ListaDupla();
        List<Personagem> personagens=new ArrayList<>();
      List<Personagem> personagems2=new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //String nomeArquivo = "characters.csv";
       String nomeArquivo = "/tmp/characters.csv";

        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String receba;
           //ler as linhas do arquivo e adcionar na lista de personagens
            bufferedReader.readLine();
            while ((receba = bufferedReader.readLine()) != null) {
                Personagem personagem = new Personagem();
                personagem.ler(receba);
                personagens.add(personagem);
            }

            bufferedReader.close(); 
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        //ler id da entrada
        String linhalida=sc.nextLine();
        while(!linhalida.equals("FIM")){
            for(int u=0;u<personagens.size();u++){
                //confere o id da entrada e do personagem
                if(linhalida.equals(personagens.get(u).getId())){
                    try{
                        lista.inserirFim(personagens.get(u));
                    }
                   catch (Exception e) {
                    System.out.println("erro ao insererir (ate o fim)");
                   }
                }
            }
           linhalida=sc.nextLine();
        }
        
      lista.quicksort();
          
        lista.imprimirlista();
      
    }
  }


