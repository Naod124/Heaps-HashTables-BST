package com.company;
/** https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/ */

import java.util.Scanner;

public class wordPuzzle {

    static int R, C;

    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static boolean hittad;

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        R = 4;
        C = 4;
        char[][] grid = {
                {'t','h','i','s'},
                {'w','a','t','s'},
                {'o','a','h','g'},
                {'f','g','d','t',}

        };


        int i = 0;
        while (i < R) {
            System.out.println();
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j] +"  ");
            }
            i++;
        }
        System.out.println("\n\nEnter the word you want to search from the above matrix");
       String word = input.next();

        patternSearch(grid, word);
        System.out.println();
    }


    static boolean findWord2D(char[][] grid, int row,
                            int col, String word)
    {
        String path = word.charAt(0) + "(" + row + "," + col + ")";


        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();


        int dir = 0;
        while (dir < 8) {

            int k, rd = row + x[dir], cd = col + y[dir];


            k = 1;
            while (k < len) {
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;

                if (grid[rd][cd] != word.charAt(k))
                    break;
                else{
                    path = path.concat(grid[rd][cd] + "(" + rd + "," + cd + ")");

                }

                rd += x[dir];
                cd += y[dir];
                k++;
            }


            if (k == len) {
                hittad = true;
                System.out.println("Found the word \"" + word + "\" At: position: " + path);
                return true;
            }

            dir++;
        }
        return false;
    }

    static void patternSearch(
            char[][] grid,
            String word)
    {

        int row = 0;
        while (row < R) {
            int col = 0;
            while (col < C) {
                findWord2D(grid, row, col, word);
                col++;
            }
            row++;
        }
        if (!hittad){
            System.out.println("The word " + "'" + word + "'" +  " is not found");
        }
    }


}