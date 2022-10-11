import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame frame;
	private JPanel panel;
	private JButton botaoIniciar;
	private JLabel fundo;
	private JButton botaoSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		botaoIniciar = new JButton("Iniciar Jogo");
		botaoIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game tela = new game();
			}
			
		});
		botaoIniciar.setBounds(157, 141, 135, 23);
		panel.add(botaoIniciar);
		
		botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		botaoSair.setBounds(157, 169, 135, 23);
		panel.add(botaoSair);
		
		fundo = new JLabel("");
		fundo.setBounds(0, 0, 434, 261);
		panel.add(fundo);
		ImageIcon icon =new ImageIcon(Janela.class.getResource("/imagens/forcaa.png" ));
		icon.setImage(icon.getImage().getScaledInstance(fundo.getWidth(), fundo.getHeight(), 1) );
		fundo.setIcon(icon);
		
	}

}
