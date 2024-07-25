package Questao3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class MudancadeBrilhoRGB {
	public static final int AMOUNT = 0;
	static boolean Continuar = true;

	public static void main(String[] args) {
		while (Continuar) {
			String filepath = "C:\\Users\\uso\\Documents\\Eclipse Projects\\AulasDePOO\\AV2_FelipeKunst\\src\\q3_FelipeKunst\\ImagemOriginal.jpeg";
			File file = new File(filepath);
			Scanner s = new Scanner(System.in);
			System.out.println("Escolha um Valor Para Modificar o Brilho de sua Imagem.");
			int AMOUNT = s.nextInt();
			try {
				BufferedImage imagem = ImageIO.read(file);
				int width = imagem.getWidth();
				int height = imagem.getHeight();
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						Color c = new Color(imagem.getRGB(i, j));
						int newred = ((c.getRed() + AMOUNT) <= 255) ? (c.getRed() + AMOUNT) : 255;
						int newgreen = ((c.getGreen() + AMOUNT) <= 255) ? (c.getGreen() + AMOUNT) : 255;
						int newblue = ((c.getBlue() + AMOUNT) <= 255) ? (c.getBlue() + AMOUNT) : 255;
						imagem.setRGB(i, j, new Color(newred, newgreen, newblue).getRGB());
					}
				}
				
				ImageIO.write(imagem, "jpg", new File("C:\\Users\\uso\\Documents\\Eclipse Projects\\AulasDePOO\\AV2_FelipeKunst\\src\\q3_FelipeKunst\\ImagemModificada.jpeg"));
				System.out.println("Imagem salva com sucesso.");
				System.out.println("Agora Verifique sua Imagem.");
			} catch (IOException exc) {
				System.out.println("Erro ao carregar a imagem: " + exc.getMessage());
				}		
			System.out.println("Deseja mudar a imagem novamente?  (sim/nao)");
			String resposta = s.next();
			if (!resposta.equalsIgnoreCase("sim")) {
				Continuar = false;	
				}
		}
		
		System.out.println("O programa foi encerrado. Ate mais Tarde!");
    }		
}