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
            /*lï¿½ as palavras + dicas do arquivo e as coloca nas respectivas listas. Lanï¿½a (throw) a exceï¿½ï¿½o ï¿½arquivo inexistenteï¿½,
            caso o arquivo nï¿½o exista.*/
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
                //System.out.println(palavras);
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
           /*retorna uma lista com as posiï¿½ï¿½es encontradas da letra na palavra sorteada ou retorna uma lista vazia. Substitui as
            letras encontradas na palavra por ï¿½*ï¿½. Contabiliza um acerto, para cada ocorrï¿½ncia encontrada, ou incrementa a
            penalidade, no caso da inexistï¿½ncia da letra. O parï¿½metro letra ï¿½ vï¿½lido se tem apenas 1 caractere alfabï¿½tico sem
            acento ï¿½ pode ser maiï¿½scula ou minï¿½scula.*/
           
        	
        	letra = letra.toUpperCase().trim(); //coloca dentro de uma variavel a letra maiuscula e tira espaços
        	
        	//caso seja digitado mais de um caracter ou n seja digitado nada  
        	if(letra.length() > 1 || letra.length() == 0){
        		throw new Exception ("Digite um caractere por vez.");
        	}
        	
        	//limita a ser digitado so letras 
        	if(!Pattern.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", letra)) {
        		throw new Exception ("Digite uma letra.");

        	}
        	
            
            //-------------------------------------------------------------------------
        	
        	ArrayList<Integer> posicao = new ArrayList<>();
        	
        	boolean acertou = false;
        	String b = "*";
        	char caractere = letra.charAt(0);
        	char asterisco = b.charAt(0);
        	
        	//verifica se a letra ja foi colocada
        	for(int i = 0; i < letras_colocadas.size(); i++){
        		if(caractere == letras_colocadas.get(i)){
        			throw new Exception ("Letra já foi lançada");
        		}
        	}
        	    //adiciona a letra no ArrayList<Character> letras_colocadas
                letras_colocadas.add(caractere);
                
                //varifica se a letra lançada existe na palavra sorteada
                for(int j = 0; j < palavra_sorteada.length(); j++){
                    if(caractere == palavra_sorteada.charAt(j)){
                        posicao.add(j);
                        acertou = true;
                    }
                }
                
                //contabiliza os acertos
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
        	//verifica se o jogo terminou
            return (acertos == palavra_sorteada.length() || penalidade == 6) ?  true : false;
        }
        
        public String getResultado() {
        	//diz se venceu ou perdeu
        	if(penalidade == 6){ 
        		return "Você foi enforcado!";
        	}
        	else if(acertos == palavra_sorteada.length()) {
        		return "Parabéns, você venceu.";
        	}
        	else {
        		return "Jogo em andamento...";
        	}
        }		
}