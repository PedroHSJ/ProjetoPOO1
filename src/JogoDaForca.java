import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JogoDaForca {
    private ArrayList<String> palavras = new ArrayList<>(); // lista de palavras lidas do arquivo
    private ArrayList<String> dicas = new ArrayList<>(); // lista de dicas lidas do arquivo
    private String dica=""; // dica da palavra sorteada
    private String[] letras; // letras da palavra sorteada
    private int acertos; // contador de acertos
    private int penalidade;

    //public JogoDaForca() throws Exception{
        /*lê as palavras + dicas do arquivo e as coloca nas respectivas listas. Lança (throw) a exceção “arquivo inexistente”,
        caso o arquivo não exista.*/

        public JogoDaForca(String nomearquivo)  throws Exception{
            // ler do arquivo placas.csv, a placa de cada vaga ocupada no momento
            try {
                Scanner arquivo = new Scanner(new File(nomearquivo));
                String entrada, palavra;
                String dica;
                String [] partes;
                while(arquivo.hasNextLine()) {
                    entrada = arquivo.nextLine();
                    partes = entrada.split(";");
                    dica = partes[1];
                    palavra = partes[0];
                    palavras.add(palavra);
                    dicas.add(dica);
                }
                arquivo.close();
                System.out.println(palavras);
            } catch (FileNotFoundException e) {
                throw new Exception("arquivo inexistente");
            }
        }

        /*public void iniciar(){

        }

        public String getDica(){
            
        }

        public int getTamanho(){

        }

        public ArrayList<Integer> getPosicoes(String letra) throws Exception{

        }*/

        







    }