

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class game {

	private JFrame frame;
	private JTextField campoTexto;
	private String letra;
	private JogoDaForca jogo;
	private ImageIcon icon;
	private JLabel campoPosicoes;
	private JLabel campoPalavra;
	private JLabel acertos;
	private JLabel erros;
	private String[] penalidades = {"perna1", "perna2", "braï¿½o1", "braï¿½o2", "tronco", "cabeï¿½a"};
	private String[] corpo = {"1.png", "2.png","3.png","4.png","5.png","6.png"};
	private ArrayList<Integer> posicoes;
	private String[] letrasAdivinhadas;
	private JLabel campoAtencao;
	private JLabel labelAlerta;
	private JLabel letra_colocada;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel forca;
	private JLabel imgFundo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game window = new game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public game() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel digiteLetra = new JLabel("DIGITE UMA LETRA");
		digiteLetra.setBounds(156, 116, 124, 23);
		frame.getContentPane().add(digiteLetra);
		
		campoTexto = new JTextField();
		campoTexto.setBounds(156, 137, 97, 23);
		frame.getContentPane().add(campoTexto);
		campoTexto.setColumns(10);
		campoTexto.getRootPane();
		campoTexto.requestFocus();
		
		JLabel dica = new JLabel("DICA:");
		dica.setBounds(135, 11, 46, 14);
		frame.getContentPane().add(dica);
		
		JLabel campoDica = new JLabel("...");
		campoDica.setBounds(171, 7, 152, 23);
		frame.getContentPane().add(campoDica);
		
		JButton botao_ok = new JButton("OK");
		botao_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				letra = campoTexto.getText().toUpperCase().trim();
				campoTexto.setText("");
				campoAtencao.setText("...");
				campoTexto.getRootPane().setDefaultButton(botao_ok);
				campoTexto.requestFocus();
			        
				    //executa a logica do jogo ao clicar no botao ok
					try {
						posicoes = jogo.getPosicoes(letra);
						textArea.append(letra+"\n");
						if (posicoes.size()>0) {
							//lblNewLabel_3.setText("posicoes encontradas=");
							System.out.println("Posições encontradas ="+ posicoes);
							campoPosicoes.setText("Posições encontradas ="+posicoes);				
							for(int i : posicoes)
								letrasAdivinhadas[i] = letra;
							System.out.println(Arrays.toString(letrasAdivinhadas));
							campoPalavra.setText(Arrays.toString(letrasAdivinhadas));
							System.out.println("Acertos="+jogo.getAcertos());
							acertos.setText("Acertos = "+jogo.getAcertos());
						}else {
							System.out.println("VocÃª errou! - Penalidade= "+jogo.getPenalidade()+", retirar "+ penalidades[jogo.getPenalidade()-1]);
							//if(jogo.getPenalidade() == 1) {
								
								int penalidade = jogo.getPenalidade();
								for(int i = 1; i<corpo.length +1; i++){
									if(i == penalidade){
										icon = new ImageIcon(game.class.getResource("/imagens/" + corpo[jogo.getPenalidade()-1]));
										forca.setIcon(icon); 
										icon.setImage(icon.getImage().getScaledInstance(forca.getWidth(), forca.getHeight(), 1) );
										forca.setIcon(icon);
									}
								//}						
												
							}
							
							erros.setText("Erros = " + jogo.getPenalidade());
							forca.setText(penalidades[jogo.getPenalidade()-1]);
						}
					}
					catch(Exception a) {
						System.out.println(a.getMessage());
						campoAtencao.setText(a.getMessage());
						
					}
					
						
				//se o jogo acaba, coloca um alerta com o resumo do jogo 	
				if(jogo.terminou() == true) {
					botao_ok.setEnabled(false);
					String mensagem = "\n           ---- game over ----" + 
				                      "\nResultado Final = " + jogo.getResultado() + 
				                      "\nSituação Final = " + Arrays.toString(letrasAdivinhadas);
					JOptionPane.showMessageDialog(null, mensagem);
				};
			}
		});
		botao_ok.setBounds(263, 137, 52, 23);
		frame.getContentPane().add(botao_ok);
		botao_ok.setEnabled(false);
		
		JButton botaoJogar = new JButton("Jogar");
		botaoJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//envia a palavra do nome do arquivo 
					jogo = new JogoDaForca("palavras.txt");
					
					//monta a imagem do boneco na forca 
					icon = new ImageIcon(game.class.getResource("/imagens/0.png"));
					forca.setIcon(icon);
					
					icon.setImage(icon.getImage().getScaledInstance(forca.getWidth(), forca.getHeight(), 1) );
					forca.setIcon(icon);
					
					//chama o metodo iniciar jogo e executa sua função
					jogo.iniciar();									
					campoDica.setText(jogo.getDica());
					letrasAdivinhadas = new String[jogo.getTamanho()];	
					Arrays.fill(letrasAdivinhadas, "");
					botao_ok.setEnabled(true);
					
					campoTexto.getRootPane().setDefaultButton(botao_ok);
					campoTexto.requestFocus();
					textArea.enable();
					
					
					
					//em caso de inicio de uma nova partida
					campoPosicoes.setText("*");
					campoPalavra.setText("- - - - - -");
					acertos.setText("Acertos = 0");
					erros.setText("Erros = 0");
					campoAtencao.setText("...");
					textArea.setText("");
					
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					campoAtencao.setText(e1.getMessage());
				}
			}
		});
		botaoJogar.setBounds(156, 189, 124, 23);
		frame.getContentPane().add(botaoJogar);
		
		campoPosicoes = new JLabel("*");
		campoPosicoes.setBounds(241, 223, 183, 31);
		frame.getContentPane().add(campoPosicoes);
		
		campoPalavra = new JLabel("- - - - - -");
		campoPalavra.setFont(new Font("Tahoma", Font.BOLD, 19));
		campoPalavra.setBounds(171, 74, 158, 31);
		frame.getContentPane().add(campoPalavra);
		
		acertos = new JLabel("Acertos = 0");
		acertos.setForeground(Color.GREEN);
		acertos.setBounds(354, 11, 70, 14);
		frame.getContentPane().add(acertos);
		
		erros = new JLabel("Erros = 0");
		erros.setForeground(Color.RED);
		erros.setBounds(354, 28, 52, 14);
		frame.getContentPane().add(erros);
		
		campoAtencao = new JLabel("...");
		campoAtencao.setBounds(70, 223, 259, 31);
		frame.getContentPane().add(campoAtencao);
		
		labelAlerta = new JLabel("ALERTA:");
		labelAlerta.setForeground(Color.BLUE);
		labelAlerta.setBounds(20, 227, 86, 23);
		frame.getContentPane().add(labelAlerta);
				
		letra_colocada = new JLabel("Letras Colocadas");
		letra_colocada.setFont(new Font("Tahoma", Font.BOLD, 10));
		letra_colocada.setBounds(337, 62, 109, 36);
		frame.getContentPane().add(letra_colocada);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 90, 86, 70); /*347, 102, 77, 148*/
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.disable();
		
		
		forca = new JLabel("FORCA");
		forca.setBounds(20, 43, 97, 117);
		frame.getContentPane().add(forca);
		
		imgFundo = new JLabel("Fundo");
		imgFundo.setBounds(0, -3, 434, 264);
		frame.getContentPane().add(imgFundo);
		ImageIcon icon =new ImageIcon(Janela.class.getResource("/imagens/fundo.jpg" ));
		icon.setImage(icon.getImage().getScaledInstance(imgFundo.getWidth(), imgFundo.getHeight(), 1) );
		imgFundo.setIcon(icon);
		
	}
}
