package Questao2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CadastroLogin {
    private List<Usuario> usuarios;
    private String arquivo;
    public CadastroLogin(String arquivo) {
        this.usuarios = new ArrayList<>();
        this.arquivo = arquivo;
        carregarUsuarios();
    }
    private void carregarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(" ");
                Usuario usuario = new Usuario(dados[0], dados[1]);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void salvarUsuarios() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Usuario usuario : usuarios) {
                writer.println(usuario.getLogin() + " " + usuario.getSenha());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarUsuario(String login, String senha) {
        Usuario novoUsuario = new Usuario(login, senha);
        usuarios.add(novoUsuario);
        salvarUsuarios();
    }
    public boolean fazerLogin(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
