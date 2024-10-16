package jogomemoria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JogoMemoria {

    public static void main(String[] args) {
        
        int linha = 4;// numero de linhas das matrizes
        int coluna = 4;// numero de coluna das matrizes

        char cartas[][] = new char[linha][coluna];// matriz com as respostas.
        char cartasViradas[][] = new char[linha][coluna];//matriz com X        
        int linha1 = 0;// peca 1
        int linha2 = 0; // peca 2
        int coluna1 = 0; // peca 1
        int coluna2 = 0; // peca 2
        int contAcertos = 0;

        for (int linhas = 0; linhas < 4; linhas++) {

            for (int colunas = 0; colunas < 4; colunas++) {

                cartasViradas[linhas][colunas] = 'X';
            }

        }

        for (int linhas = 0; linhas < linha; linhas++) {
            for (int colunas = 0; colunas < coluna; colunas++) {
                if (colunas < 3) {
                    System.out.print(cartasViradas[linhas][colunas] + " - ");
                } else {
                    System.out.print(cartasViradas[linhas][colunas]);
                }
            }
            System.out.println("");

        }

       /* System.out.println("");

        cartas[0][0] = 'A';
        cartas[0][1] = 'B';
        cartas[0][2] = 'C';
        cartas[0][3] = 'D';
        cartas[1][0] = 'E';
        cartas[1][1] = 'F';
        cartas[1][2] = 'G';
        cartas[1][3] = 'H';
        cartas[2][0] = 'A';
        cartas[2][1] = 'B';
        cartas[2][2] = 'C';
        cartas[2][3] = 'D';
        cartas[3][0] = 'E';
        cartas[3][1] = 'F';
        cartas[3][2] = 'G';
        cartas[3][3] = 'H';*/
        
        //sorteio de caracteres aleatorios.
        
        // gera uma lista de caracteres pares.
        List<Character> caracteres = new ArrayList<>();
        
        //adiciona os pares de caractere na lista de char criada       
        for (char ch = 'A'; ch < 'A' + (linha*coluna)/2; ch++){
            caracteres.add(ch);
            caracteres.add(ch);
        }
        
        //embaralha a lista de caracteres
        Collections.shuffle(caracteres);
        
        //preenche a matriz com os caracteres embaralhados
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cartas[i][j] = caracteres.get(index++);
            }            
        }
        
        /*//imprime a matriz
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(cartas[i][j]+ " ");
            }
            System.out.println(" ");
        }*/

        while (contAcertos < 8) {

            linha1 = Entrada.leiaInt("Informe a linha da primeira carta. (DE 0 A 3)");
            coluna1 = Entrada.leiaInt("Informe a coluna da primeira carta. (DE 0 A 3)");

            cartasViradas[linha1][coluna1] = cartas[linha1][coluna1];
            
            System.out.println(linha1 + " , " + coluna1);
            System.out.println("");

            for (int linhas = 0; linhas < 4; linhas++) {
                for (int colunas = 0; colunas < 4; colunas++) {
                    if (colunas < 3) {
                        System.out.print(cartasViradas[linhas][colunas] + " - ");

                    } else {
                        System.out.print(cartasViradas[linhas][colunas]);
                    }
                }
                System.out.println("");
            }
            System.out.println("");

            linha2 = Entrada.leiaInt("Informe a linha da segunda carta. (DE 0 A 3)");
            coluna2 = Entrada.leiaInt("Informe a coluna da segunda carta. (DE 0 A 3)");

            cartasViradas[linha2][coluna2] = cartas[linha2][coluna2];
            
            System.out.println(linha2 + " , " + coluna2);
            System.out.println("");

            for (int linhas = 0; linhas < 4; linhas++) {
                for (int colunas = 0; colunas < 4; colunas++) {
                    if (colunas < 3) {
                        System.out.print(cartasViradas[linhas][colunas] + " - ");

                    } else {
                        System.out.print(cartasViradas[linhas][colunas]);
                    }
                }
                System.out.println("");
            }
            System.out.println("");

            if (cartasViradas[linha1][coluna1] != cartasViradas[linha2][coluna2]) {
                // se as cartas viradas nas posições 1 e 2 forem diferentes uma com a outra então, desvire as cartas
                cartasViradas[linha1][coluna1] = 'X';
                cartasViradas[linha2][coluna2] = 'X';
                for (int linhas = 0; linhas < 4; linhas++) {
                    for (int colunas = 0; colunas < 4; colunas++) {
                        if (colunas < 3) {
                            System.out.print(cartasViradas[linhas][colunas] + " - ");
                        } else {
                            System.out.print(cartasViradas[linhas][colunas]);
                        }
                    }
                    System.out.println("");
                }

            }else if (cartasViradas[linha1][coluna1] == cartasViradas[linha2][coluna2]){
                contAcertos++;
            }
            
        }

        System.out.println("PARABÉNS, VOCÊ VENCEU:");
        System.exit(0);
    }

}
