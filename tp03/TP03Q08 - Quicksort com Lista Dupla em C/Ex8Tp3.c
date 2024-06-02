#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#define MAX_FIELDS 18 
typedef struct Personagem {
  char id[50];
    char name[100];
    char alternate_names[100][100];
    char house[50];
    char ancestry[50];
    char species[50];
    char patronus[50];
    char hogwartsStaff[30];
    char hogwartsStudent[30];
    char actorName[100];
    char alive[30];
    char dateOfBirth[20];
    int yearOfBirth;
    char eyeColour[20];
    char gender[20];
    char hairColour[20];
    char wizard[30];
} Personagem;

void imprimir(Personagem *personagem){
printf("[%s ## %s ##",personagem->id,personagem->name);
if(strcmp(personagem->alternate_names[0],"{}")!=0){
int num_alternate_names = 0;
    while (num_alternate_names < 10 && personagem->alternate_names[num_alternate_names][0] != '\0') {
        num_alternate_names++;
    }

    // Imprimir os nomes alternativos
    printf(" {");
    for (int i = 0; i < num_alternate_names; i++) {
        
        printf("%s", personagem->alternate_names[i]);
        if(i > num_alternate_names - 1)
        printf(" ");
        if (i < num_alternate_names - 1) {
            printf(", ");
        }
    }
    printf("} ");
}
 
    printf("## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",personagem->house,personagem->ancestry,personagem->species,personagem->patronus,personagem->hogwartsStaff,
    personagem->hogwartsStudent,personagem->actorName,personagem->alive,personagem->dateOfBirth,personagem->yearOfBirth,personagem->eyeColour,personagem->gender,personagem->hairColour,personagem->wizard);
}

void ler (Personagem *personagem, char* entrada){
   
    strcpy(personagem->alternate_names,"");
char *campos[MAX_FIELDS];
    int i = 0;
    int comeco = 0;
    int tamanhoCampo = 0;
    int len = strlen(entrada);
    
    // Percorrendo a string original
    for (int j = 0; j <= len; j++) {
        if (entrada[j] == ';' || entrada[j] == '\0') {
            // Verificar se encontramos dois ponto e vírgula consecutivos
            if (tamanhoCampo == 0 && entrada[j+1] == ';') {
                campos[i++] = "vazio";
                j++; // Pular o segundo ponto e vírgula
            } else {
                // Alocar memória para o campo atual e copiá-lo
                campos[i] = (char *)malloc(tamanhoCampo + 1);
                strncpy(campos[i], entrada + comeco, tamanhoCampo);
                campos[i][tamanhoCampo] = '\0';
                i++;
            }
            comeco = j + 1; // Atualizar o início do próximo campo
            tamanhoCampo = 0; // Resetar o comprimento do campo
        } else {
            tamanhoCampo++; // Incrementar o comprimento do campo
        }
    }
  int count = 0;
 
 if (strcmp(campos[2], "") != 0) {
    const char delimiters[] = "[''],";//organizar os nomes alternativos
    char *token;
   
    token = strtok(campos[2], delimiters);
    while (token != NULL) {
        if (strcmp(token, " ") != 0) {
        strcpy(personagem->alternate_names[count], token);
        count++;
        
        }
        token = strtok(NULL, delimiters);
    }
     strcpy(personagem->alternate_names[count],"\0");
} 
else {
    strcpy(personagem->alternate_names[0], "{}");
   count++;
}
//colocar da forma do verde
if(campos[17][0] == 'V') {
    strcpy(campos[17], "true");
} else if(campos[17][0] == 'F') {
    strcpy(campos[17], "false");
}
if(strcmp(campos[7],"VERDADEIRO")==0){
    strcpy(campos[7],"true");
}
else if(strcmp(campos[7],"FALSO")==0){
    strcpy(campos[7],"false");
}
if(strcmp(campos[10],"VERDADEIRO")==0){
    strcpy(campos[10],"true");
}
else if(strcmp(campos[10],"FALSO")==0){
    strcpy(campos[10],"false");
}

if(strcmp(campos[8],"VERDADEIRO")==0){
    strcpy(campos[8],"true");
}
else if(strcmp(campos[8],"FALSO")==0){
    strcpy(campos[8],"false");
}
   strcpy(personagem->id, campos[0]);
    strcpy(personagem->name, campos[1]);
   //personagem->alternate_names=campos[2];
    strcpy(personagem->house, campos[3]);
    strcpy(personagem->ancestry, campos[4]);
    strcpy(personagem->species, campos[5]);
    strcpy(personagem->patronus, campos[6]);
    strcpy(personagem->hogwartsStaff, campos[7]);
    strcpy(personagem->hogwartsStudent, campos[8]);
    strcpy(personagem->actorName, campos[9]);
    strcpy(personagem->alive, campos[10]);
    //strcpy(personagem->name, campos[11]);
    strcpy(personagem->dateOfBirth, campos[12]);
    personagem->yearOfBirth = atoi(campos[13]);
    strcpy(personagem->eyeColour, campos[14]);
    strcpy(personagem->gender, campos[15]);
    strcpy(personagem->hairColour, campos[16]);
    strcpy(personagem->wizard, campos[17]);

}



bool isFim(char *id) { return id[0] == 'F' && id[1] == 'I' && id[2] == 'M'; }









void writeLog(long duration, int *numcompemovi) {
    FILE *file = fopen("matrícula_quicksort2.txt", "w");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo de log");
        exit(EXIT_FAILURE);
    }
    fprintf(file, "814143\t%ld\t%d\t%d\n", duration, numcompemovi[0], (3 * numcompemovi[1]));
    fclose(file);
}




typedef struct CelulaDupla {
	Personagem elemento;        // Elemento inserido na celula.
	struct CelulaDupla* prox; // Aponta a celula prox.
   struct CelulaDupla* ant;  // Aponta a celula anterior.
} CelulaDupla;

CelulaDupla* novaCelulaDupla(Personagem elemento) {
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}


CelulaDupla* primeiro;
CelulaDupla* ultimo;



void start () {
    Personagem lixo;
   primeiro = novaCelulaDupla(lixo);
   ultimo = primeiro;
}



void inserir(Personagem x) {
   ultimo->prox = novaCelulaDupla(x);
   ultimo->prox->ant = ultimo;
   ultimo = ultimo->prox;
}


void mostrar() {
   CelulaDupla* i;
   for (i = primeiro->prox; i != NULL; i = i->prox) {
     imprimir(&(i->elemento));
     
   }
 
}

//=============================================================================
void swap(CelulaDupla* a, CelulaDupla* b) {
    Personagem temp = a->elemento;
    a->elemento = b->elemento;
    b->elemento = temp;
}

// Particiona a lista em torno de um elemento pivô
CelulaDupla* paricao(CelulaDupla* esq, CelulaDupla* dir, int* numcompemovi) {
    Personagem pivot = dir->elemento;
    CelulaDupla* i = esq->ant;

    for (CelulaDupla* j = esq; j != dir; j = j->prox) {
        int comparison = strcmp(j->elemento.house, pivot.house);
        if (comparison < 0 || (comparison == 0 && strcmp(j->elemento.name, pivot.name) < 0)) {
            numcompemovi[0]++;
            i = (i == NULL) ? esq : i->prox;
            swap(i, j);
            numcompemovi[1]++;
        }
    }
    i = (i == NULL) ? esq : i->prox;
    swap(i, dir);
    numcompemovi[1]++;
    return i;
}

// Função recursiva para ordenar a lista
void quicksortRec(CelulaDupla* esq, CelulaDupla* dir, int* numcompemovi) {
    if (esq != NULL && dir != NULL && esq != dir && esq != dir->prox) {
        CelulaDupla* p = paricao(esq, dir, numcompemovi);
        quicksortRec(esq, p->ant, numcompemovi);
        quicksortRec(p->prox, dir, numcompemovi);
    }
}

// Função principal para ordenar a lista usando o algoritmo quicksort
void quicksort(CelulaDupla* head, int* numcompemovi) {
    CelulaDupla* dir = head;
    while (dir->prox != NULL) {
        dir = dir->prox;
    }
    quicksortRec(head, dir, numcompemovi);
}


int main() {
     start();
    FILE *arquivo;
    clock_t startTime, endTime;
    startTime = clock();
    int numcompemovi[2] = {0, 0};
    char linha[800];
    char entrada[100];
    Personagem personagem;
    Personagem persoangens[50];
    // Abra o arquivo
   
   //arquivo = fopen("C:/Users/MaiS i5/Desktop/testeC/characters.csv","r");
   //arquivo = fopen("C:/Users/MaiS i5/Desktop/testeC/characters.csv","r");  
 arquivo = fopen("/tmp/characters.csv","r");
    // Verifica se o arquivo foi aberto corretamente
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }
    
    // Lê cada linha do arquivo
    scanf("%s", entrada);
    while (!isFim(entrada)) {
        rewind(arquivo);
        while (fgets(linha, 500, arquivo) != NULL) {
            // Verifica se os primeiros 36 caracteres da linha são iguais à entrada
            if (strncmp(linha, entrada, 36) == 0) {
                linha[strcspn(linha, "\n")] = '\0';
                // Se forem iguais, imprime a linha
                ler(&personagem, linha);
              //  persoangens[n] = personagem;
              //  n++;
              inserir(personagem);
             
                scanf("%s", entrada);
                // Ou salva em algum lugar, dependendo do que você quer fazer
            }
        }
    }
   


    fclose(arquivo); // Fecha o arquivo após ler todas as linhas
   quicksort(primeiro->prox, numcompemovi);
  
   mostrar();
  
    endTime = clock();
    long duration = ((double)(endTime - startTime) * 1000) / CLOCKS_PER_SEC;
    writeLog(duration, numcompemovi);
    return 0;
}