package Questao5;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JogodaDaSorte extends JFrame implements ActionListener {
    private JButton[] botoes;
    private JLabel resultadoLabel;
    private JTextField tentativaAtual;
    private int numeroSecreto;
    private int tentativasFeitas;

    public JogodaDaSorte() {
        setTitle("Bem vindo ao jogo do Milhão");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Random random = new Random();
        numeroSecreto = random.nextInt(20) + 1;
        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 5, 5));
        botoes = new JButton[20];
        for (int i = 0; i < 20; i++) {
            botoes[i] = new JButton(String.valueOf(i+1));
            botoes[i].addActionListener(this);
            painelBotoes.add(botoes[i]);
        }
        resultadoLabel = new JLabel("");
        tentativaAtual = new JTextField(5);
        tentativaAtual.setEditable(false);
        setLayout(new FlowLayout());
        add(new JLabel("Tentativa Atual:"));
        add(tentativaAtual);
        add(painelBotoes);
        add(resultadoLabel);
    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 20; i++) {
            if (e.getSource() == botoes[i]) {
                int escolhaUsuario = i + 1;
                tentativaAtual.setText(String.valueOf(++tentativasFeitas));
                if (tentativasFeitas == 5) {
                    desabilitarBotoes();
                    resultadoLabel.setText("Que Pena! Você usou todas as tentativas. O número secreto era: " + numeroSecreto);
                    return;
                }
                if (escolhaUsuario == numeroSecreto) {
                    desabilitarBotoes();
                    resultadoLabel.setText("Você acertou! Parabéns");
                }
                else {
                	resultadoLabel.setText("Que azar! Você errou. Tente novamente.");
                }
            }
        }  
    }
    private void desabilitarBotoes() {
        for (JButton botao : botoes) {
            botao.setEnabled(false);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogodaDaSorte jogo = new JogodaDaSorte();
            jogo.setVisible(true);
            });
    }
  
}