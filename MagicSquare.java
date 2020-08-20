

//@author scarfinson
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
        MagicSquare metodo = new MagicSquare();
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Entrada: ");
            int x[][] = metodo.generarMatrizResultante(entrada.nextInt());
            System.out.println("Salida: ");
            for (int[] vector : x) {
                System.out.println(Arrays.toString(vector));
            }
        } catch (InputMismatchException e) {
            System.err.println("Ha ingresado datos no válidos. Revise de nuevo.");
        }

    }

    public int[][] generarMatrizResultante(int dimension) {
        int vector[][] = new int[dimension][dimension];
        int media = (((dimension * dimension) / 2) + 1);
        if (dimension % 2 == 0) {
            throw new InputMismatchException();
        } else {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (i == 0 && j == 0) {
                        vector[i][j] = media - (dimension / 2);
                    } else if (i == 0 && j % 2 == 0) {
                        vector[i][j] = vector[i][j - 2] - (dimension - 1);
                    } else if (i % 2 == 0 && j % 2 == 0) {
                        vector[i][j] = vector[i - 2][j] + (dimension + 1);
                    } else if (i % 2 != 0 && j % 2 != 0) {
                        vector[i][j] = vector[i - 1][j - 1] + 1;
                    }
                }
            }

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if ((i == 0 && j % 2 != 0)) {
                        vector[i][j] = media + vector[i][j - 1];
                    } else if (j == vector.length - 1 && i % 2 != 0) {
                        vector[i][j] = media + vector[i - 1][j];
                    } else if (j == 0 && i % 2 != 0) {
                        vector[i][j] = vector[i + 1][j] - media;
                    } else if (i == vector.length - 1 && j % 2 != 0) {
                        vector[i][j] = vector[i][j + 1] - media;
                    }
                }
            }

            if (dimension > 3) {
                for (int j = 1; j < dimension; j += 2) {
                    for (int k = 0, l = j; k < dimension - (l + 2); k++, l++) {
                        vector[k + 1][l + 1] = vector[k][l] + 1;
                    }
                }
                for (int i = dimension - 2; i > 0; i -= 2) {
                    for (int k = i, l = dimension - 1; l > dimension - (k); k--, l--) {
                        vector[k - 1][l - 1] = vector[k][l] - 1;
                    }
                }
                for (int i = 1; i < dimension; i += 2) {
                    for (int k = i, l = 0; l < dimension - (k + 2); k++, l++) {
                        vector[k + 1][l + 1] = vector[k][l] + 1;
                    }
                }
                for (int j = dimension - 2; j > 0; j -= 2) {
                    for (int k = dimension - 1, l = j; k > dimension - (l); k--, l--) {
                        vector[k - 1][l - 1] = vector[k][l] - 1;
                    }
                }
            }
        }
        return vector;
    }
}
