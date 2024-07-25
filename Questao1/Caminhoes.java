package Questao1;

public class Caminhoes extends Veiculo{
	private int Massa;
	
	public int getMassa() {
		return Massa;
	}
	public void setMassa(int massa) {
		this.Massa = massa;
	}
	  public String toString() {
	        return String.valueOf(Massa);
	  }
	
	public static void main(String[]agrs) {
		 Companhia name = new Companhia();
		 name.setName("Volvo");
		 Funcionario Funcionarios = new Funcionario();
		 Funcionarios.setFuncionario("Jonas Rodrigues");
		 Veiculo NumerodeRegistro = new Veiculo();
		 NumerodeRegistro.setNumerodeRegistro("15857588448");
		 Caminhoes Massa= new Caminhoes();
		 Massa.setMassa(19000);
		 System.out.println("Nome da Companhia e " +  name);
		 System.out.println("Nome do Funcionario e " + Funcionarios);
		 System.out.println("Numero de Registro do Veiculo e " + NumerodeRegistro);
		 System.out.println("A Massa e do Caminhão e "  + Massa + "KG");
		}
}