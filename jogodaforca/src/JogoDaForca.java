import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;

public class JogoDaForca {
    private ArrayList<String> palavras = new ArrayList<>(); // lista de palavras lidas do arquivo
    private ArrayList<String> dicas = new ArrayList<>(); // lista de dicas lidas do arquivo
    private ArrayList<Character> letras_colocadas = new ArrayList<>(); //lisa de letras colocadas
    private String dica=""; // dica da palavra sorteada
    private int acertos; // contador de acertos
    private int penalidade;
    private String palavra_sorteada;

        public JogoDaForca(String nomearquivo)  throws Exception{
            /*l� as palavras + dicas do arquivo e as coloca nas respectivas listas. Lan�a (throw) a exce��o �arquivo inexistente�,
            caso o arquivo n�o exista.*/
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
                //System.out.println(palavras);
                //System.out.println(dicas);
            } catch (FileNotFoundException e) {
                throw new Exception("arquivo inexistente");
            }
        }

        public void iniciar(){
            Random random = new Random();
            int numero_sorteado = random.nextInt(palavras.size());
            palavra_sorteada = palavras.get(numero_sorteado);
            dica = dicas.get(numero_sorteado);

            
        }

        public String getPalavra_sorteada(){
            return palavra_sorteada;
        }

        public String getDica(){
            // if(palavra_sorteada == palavras.get(0)){
            //     return dicas.get(0);
            // }else if(palavra_sorteada == palavras.get(1)){
            //     return dicas.get(1);
            // }else if(palavra_sorteada == palavras.get(2)){
            //     return dicas.get(2);
            // }else{
            //     return dicas.get(3);
            // }
            return dica;
            
        }

        public int getTamanho(){
            return palavra_sorteada.length();

        }

        public ArrayList<Integer> getPosicoes(String letra) throws Exception{
           /*retorna uma lista com as posi��es encontradas da letra na palavra sorteada ou retorna uma lista vazia. Substitui as
            letras encontradas na palavra por �*�. Contabiliza um acerto, para cada ocorr�ncia encontrada, ou incrementa a
            penalidade, no caso da inexist�ncia da letra. O par�metro letra � v�lido se tem apenas 1 caractere alfab�tico sem
            acento � pode ser mai�scula ou min�scula.*/
           
        	//Exe��es;
        	letra = letra.toUpperCase().trim();
        	if(letra.length() > 1 || letra.length() == 0){
        		throw new Exception ("Digite um caractere por vez.");
        	}
        	
        	if(!Pattern.matches("[a-zA-Z]", letra)) {
        		throw new Exception ("Digite uma letra.");

        	}
        	//letra = letra.toUpperCase().trim();
            
            //-------------------------------------------------------------------------
        	
        	ArrayList<Integer> posicao = new ArrayList<>();
        	
        	boolean acertou = false;
        	String b = "*";
        	char caractere = letra.charAt(0);
        	char asterisco = b.charAt(0);
        	
        	for(int i = 0; i < letras_colocadas.size(); i++){
        		if(caractere == letras_colocadas.get(i)){
        			throw new Exception ("Letra j� foi lan�ada");
        		}
        	}
                letras_colocadas.add(caractere);
    
                for(int j = 0; j < palavra_sorteada.length(); j++){
                    if(caractere == palavra_sorteada.charAt(j)){
                        posicao.add(j);
                        acertou = true;
                    }
                }
                if(acertou){
                    acertos = acertos + 1;
                    palavra_sorteada = palavra_sorteada.replace(caractere, asterisco);
                    if(posicao.size() == 2){
                        acertos = acertos + 1;
                    }    
                }else{
                    penalidade += 1;
                }
                return posicao;             
        }

        public int getPenalidade(){
            //retorna a penalidade atual (0, 1, 2, ... 6)
            return penalidade;
        }
        
        public int getAcertos(){
            //retorna o total de acertos
            return acertos;
        }

        public boolean terminou(){
            return (acertos == palavra_sorteada.length() || penalidade == 6) ?  true : false;
        }
        public String getResultado() {
        	if(penalidade == 6){ 
        		return "Voc� foi enforcado!";
        	}
        	else if(acertos == palavra_sorteada.length()) {
        		return "Parab�ns!Voc� venceu.";
        	}
        	else {
        		return "Jogo em andamento...";
        	}
        }		
}