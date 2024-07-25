package Questao4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplicacaoMatrizes {
   public static void main(String[] args){                                                                             
        int[][] matrizA = lerMatriz("C:\\Users\\uso\\eclipse-workspace\\Atividade_Avaliativa_2_POO\\src\\Questao4\\MatrizA.txt", 3,2);
        int[][] matrizB = lerMatriz("C:\\Users\\uso\\eclipse-workspace\\Atividade_Avaliativa_2_POO\\src\\Questao4\\MatrizB.txt", 2,3);
    
        if (matrizA != null && matrizB != null) {
            int[][] resultado = multiplicarMatrizes(matrizA, matrizB);
            if (resultado != null) {
                System.out.println("Resultado Da Mutiplicação das Matriz A e Matriz B  é:");
                imprimirMatriz(resultado);
            } else {
                System.out.println("Erro! Não é possível multiplicar as matrizes.");
            }
        	} else {
        		System.out.println("Erro! Falha na leitura do arquivo.");
        }
    }

    public static int[][] lerMatriz(String arquivo, int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;

            for (int i = 0; i < linhas; i++) {
                linha = br.readLine();
                if (linha == null) {
                    br.close();
                    return null; 
                }
                String[] valores = linha.split(" ");

                if (valores.length != colunas) {
                    br.close();
                    return null; 
                }
                for (int j = 0; j < colunas; j++) {
                    matriz[i][j] = Integer.parseInt(valores[j]);
                }
            }
            		br.close();
            	
        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        }
        	return matriz;
    }
    public static int[][] multiplicarMatrizes(int[][] A, int[][] B) {
        int linhasA = A.length;
        int colunasA = A[0].length;
        int linhasB = B.length;
        int colunasB = B[0].length;
        if (colunasA != linhasB) {
            return null;
        }

        int[][] resultado = new int[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return resultado;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}