// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Scanner;
// import java.util.Random;

// public class JogoDaForca {
//     private ArrayList<String> palavras = new ArrayList<>(); // lista de palavras lidas do arquivo
//     private ArrayList<String> dicas = new ArrayList<>(); // lista de dicas lidas do arquivo
//     private String dica=""; // dica da palavra sorteada
//     private String[] letras; // letras da palavra sorteada
//     private int acertos; // contador de acertos
//     private int penalidade;
//     private String palavra_sorteada;

//     //public JogoDaForca() throws Exception{
//         /*lê as palavras + dicas do arquivo e as coloca nas respectivas listas. Lança (throw) a exceção “arquivo inexistente”,
//         caso o arquivo não exista.*/

//         public JogoDaForca(String nomearquivo)  throws Exception{
//             /*lê as palavras + dicas do arquivo e as coloca nas respectivas listas. Lança (throw) a exceção “arquivo inexistente”,
//             caso o arquivo não exista.*/
//             try {
//                 Scanner arquivo = new Scanner(new File(nomearquivo));
//                 String entrada, palavra;
//                 String dica;
//                 String [] partes;
//                 while(arquivo.hasNextLine()) {
//                     entrada = arquivo.nextLine();
//                     partes = entrada.split(";");
//                     dica = partes[1];
//                     palavra = partes[0];
//                     palavras.add(palavra);
//                     dicas.add(dica);
//                 }
//                 arquivo.close();
//                 //System.out.println(palavras);
//                 //System.out.println(dicas);
//             } catch (FileNotFoundException e) {
//                 throw new Exception("arquivo inexistente");
//             }
//         }

//         public void iniciar(){
//             Random sorteio = new Random();
//             palavra_sorteada = palavras.get(sorteio.nextInt(palavras.size()));
//         }

//         public String getPalavra_sorteada(){
//             return palavra_sorteada;
//         }

//         public String getDica(){
//             // if(palavra_sorteada == palavras.get(0)){
//             //     return dicas.get(0);
//             // }else if(palavra_sorteada == palavras.get(1)){
//             //     return dicas.get(1);
//             // }else if(palavra_sorteada == palavras.get(2)){
//             //     return dicas.get(2);
//             // }else{
//             //     return dicas.get(3);
//             // }

//             for(int i = 0; i < palavras.length; i++){
//                 if(palavra_sorteada == palavras.get(i)){
//                     return dicas.get(i)
//                 }
//             }
            
//         }

//         public int getTamanho(){
//             return palavra_sorteada.length();

//         }

//         //public ArrayList<Integer> getPosicoes(char letra) throws Exception{
//             /*retorna uma lista com as posições encontradas da letra na palavra sorteada ou retorna uma lista vazia. Substitui as
//             letras encontradas na palavra por “*”. Contabiliza um acerto, para cada ocorrência encontrada, ou incrementa a
//             penalidade, no caso da inexistência da letra. O parâmetro letra é válido se tem apenas 1 caractere alfabético sem
//             acento – pode ser maiúscula ou minúscula.*/

//             //ArrayList<Integer> guarda_letras_que_existem = new ArrayList<>();
            
//             //for(int i = 0; i<palavra_sorteada.length(); i++){
//                 /*if(palavra_sorteada.indexOf(letra) >= 0){
//                     for(int j = 0; j<palavra_sorteada.length(); j++){


//                     }
//                 }
//             }*/
            
//         //}
        
//         public String toString(){
//             return  "\n----------------------------TESTANDO SE TÁ CERTO---------------------------" +
//                     "\nPalavra sorteada => " + this.getPalavra_sorteada();
//         }

//     }