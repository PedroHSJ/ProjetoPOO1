/*
 * IFPB - TSI - POO - PROJETO1
 * Prof. Fausto Ayres
 * 
 * Aplica��o console para testar a classe JogoDaForca
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class AplicacaoConsole {
	public static void main(String[] args) {
		try {
			Scanner teclado = new Scanner (System.in);
			String[] penalidades = {"perna1", "perna2", "bra�o1", "bra�o2", "tronco", "cabe�a"};
			String letra;
			String[] letrasAdivinhadas; 	//letras adivinhadas
			ArrayList<Integer> posicoes;	//posicoes adivinhadas
			
			JogoDaForca jogo = new JogoDaForca("palavras.txt");
			//System.out.println(jogo);

			jogo.iniciar();
			System.out.println("Dica da palavra = " + jogo.getDica());
			System.out.println("Tamanho da palavra = " + jogo.getTamanho());
			letrasAdivinhadas = new String[jogo.getTamanho()];	
			Arrays.fill(letrasAdivinhadas, "");

			do {
				System.out.println("\nDigite uma letra da palavra ");				
				letra = teclado.nextLine().toUpperCase();
				
				try {
					posicoes = jogo.getPosicoes(letra);
					if (posicoes.size()>0) {
						System.out.println("Posições encontradas="+ posicoes);
						for(int i : posicoes)
							letrasAdivinhadas[i] = letra;
						System.out.println(Arrays.toString(letrasAdivinhadas));
						System.out.println("Total de acertos="+jogo.getAcertos());
					} 
					else {
						System.out.println("Você errou - penalidade = "+jogo.getPenalidade()+", retirar "+ penalidades[jogo.getPenalidade()-1]);
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			while(!jogo.terminou());

			teclado.close();
			System.out.println("\n---- game over ----");
			System.out.println("Resultado final = "+jogo.getResultado() );
			System.out.println("Situação final = "+ Arrays.toString(letrasAdivinhadas));

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
