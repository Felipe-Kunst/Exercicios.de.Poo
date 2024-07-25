package Questao2;

public class LogindoUsuario{
    public static void main(String[] args) {
    	CadastroLogin cadastro = new CadastroLogin("C:\\Users\\uso\\eclipse-workspace\\Atividade_Avaliativa_2_POO\\src\\Questao2\\Usuarios.txt");
        cadastro.cadastrarUsuario("FelipeKunst", "JavaMakeMeCrazy");
        cadastro.cadastrarUsuario("SamuelBarrocas","JAVA123" );
        boolean login1 = cadastro.fazerLogin("FelipeKunst", "JavaMakeMeCrazy");
        boolean login2  = cadastro.fazerLogin("SamuelBarrocas", "JAVA");
        boolean login3 = cadastro.fazerLogin("SamuelBarrocas", "JAVA123");
        
        if (login1) {
            System.out.println("SUCESSO");
        } else {
            System.out.println("FRACASSO");
        }
        if (login2) {
            System.out.println("SUCESSO");
        } else {
            System.out.println("FRACASSO");
        }
        if (login3) {
            System.out.println("SUCESSO");
        } else {
            System.out.println("FRACASSO");
        }
    }
}
