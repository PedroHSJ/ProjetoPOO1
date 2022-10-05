

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
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
	private JTextField textField;
	private String letra;
	private JogoDaForca jogo;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	String[] penalidades = {"perna1", "perna2", "bra�o1", "bra�o2", "tronco", "cabe�a"};
	ArrayList<Integer> posicoes;
	String[] letrasAdivinhadas;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DIGITE UMA LETRA");
		lblNewLabel.setBounds(20, 75, 124, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 103, 97, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DICA:");
		lblNewLabel_1.setBounds(20, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("...");
		lblNewLabel_2.setBounds(55, 7, 206, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				letra = textField.getText().toUpperCase();
				textField.setText("");
				lblNewLabel_7.setText("...");
			  
					try {
						posicoes = jogo.getPosicoes(letra);					
						if (posicoes.size()>0) {
							//lblNewLabel_3.setText("posicoes encontradas=");
							System.out.println("posicoes encontradas="+ posicoes);
							lblNewLabel_3.setText("posicoes encontradas="+posicoes);				
							for(int i : posicoes)
								letrasAdivinhadas[i] = letra;
							System.out.println(Arrays.toString(letrasAdivinhadas));
							lblNewLabel_4.setText(Arrays.toString(letrasAdivinhadas));
							System.out.println("total de acertos="+jogo.getAcertos());
							lblNewLabel_5.setText("total de acertos = "+jogo.getAcertos());
						}else {
							System.out.println("voce errou - penalidade="+jogo.getPenalidade()+", retirar "+ penalidades[jogo.getPenalidade()-1]);
							lblNewLabel_6.setText("total de erros = " + jogo.getPenalidade());
						}
					}
					catch(Exception a) {
						System.out.println(a.getMessage());
						lblNewLabel_7.setText(a.getMessage());					

					}
					/*catch(NullPointerException b) {
						System.out.println(b.getMessage());
						lblNewLabel_7.setText("clique em iniciar o jogo");					
					}*/
									
				if(jogo.terminou() == true) {
					String mensagem = "\n           ---- game over ----" + 
				                      "\nresultado final = " + jogo.getResultado() + 
				                      "\nsituacao final = " + Arrays.toString(letrasAdivinhadas);
					JOptionPane.showMessageDialog(null, mensagem);
				};
			}
		});
		btnNewButton.setBounds(45, 137, 52, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("iniciar jogo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jogo = new JogoDaForca("palavras.csv");
					
					jogo.iniciar();									
					lblNewLabel_2.setText(jogo.getDica());
					letrasAdivinhadas = new String[jogo.getTamanho()];	
					Arrays.fill(letrasAdivinhadas, "");
					
					//em caso de inicio de uma nova partida
					lblNewLabel_3.setText("*");
					lblNewLabel_4.setText("- - - - - -");
					lblNewLabel_5.setText("total de acertos = 0");
					lblNewLabel_6.setText("total de erros = 0");
					lblNewLabel_7.setText("...");
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(171, 227, 124, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(20, 43, 183, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("- - - - - -");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4.setBounds(193, 166, 158, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("total de acertos = 0");
		lblNewLabel_5.setBounds(315, 11, 109, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("total de erros = 0");
		lblNewLabel_6.setBounds(327, 32, 97, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("...");
		lblNewLabel_7.setBounds(73, 193, 259, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("ALERTA:");
		lblNewLabel_8.setBounds(20, 197, 86, 23);
		frame.getContentPane().add(lblNewLabel_8);
	}
}
