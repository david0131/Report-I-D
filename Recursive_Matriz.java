/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labcord;

import java.util.Random;


public class LabCord {
int comp1=0;
    public static void main(String[] args) {
        Random r = new Random();
        /*int N= 6;
            int [][] coords = {
                {3, 3},
                {2, 4},
               {10, 8},
                {13, 5},
                {16, 4},
               {15, 3}
            };*/
        / test N/
        int c = 1;
        int N = 100; //2 * r.nextInt((int) Math.random() * 15 + 10);
        System.out.println(+c + ".Número de puntos es " + N);
        while (N<6){
                c=c+1;
                N=2*r.nextInt((int) Math.random()*15+10);
                System.out.println(+c+".Número de puntos es "+N);
            }
        int[][] coords = new int[N][2];
        System.out.println("|x||y|");
                for (int x = 0; x < coords.length; x++) {
            for (int y = 0; y < coords[x].length; y++) {
                coords[x][y] = (int) (Math.random() * 9 + 1);
            }
        }
        for (int x = 0; x < coords.length; x++) {
            for (int y = 0; y < coords[x].length; y++) {

                System.out.print(" | " + coords[x][y]);
            }
            System.out.println(" |\n");
        }
        System.out.println("__________");
        

        LabCord dismin = new LabCord();
        long ITime = System.nanoTime();
        System.out.println(dismin.ClosestPairRecursive(N, coords, 0, 1, 0));
        
        long FTime = System.nanoTime();
        long DTime = FTime - ITime;
        System.out.println("N es: " + N);
        System.out.println("tiempo de ejecucion: " + DTime + " nanosegundos ");
    }
    /iterative functiom
    public double ClosestPair(int N, int coords[][]) {
        int i = 0, j = 0, comps = 0, primero, segundo, primero1, segundo1, primero2, segundo2;
        double dl_min = Double.POSITIVE_INFINITY;
        double dr_min = Double.POSITIVE_INFINITY;
        double dc_min = Double.POSITIVE_INFINITY;
        double d;

        for (i = 0; i <= N - 2; i++) {
            for (j = i + 1; j < N; j++) {
                if (i < (N / 2) & j < (N / 2) + 1) {
                    d = (double) distance(coords, i, j);
                    if (d < dl_min) {
                        primero = i;
                        segundo = j;
                        dl_min = d;
                        System.out.println("la distancia minima izquierda actual es " + dl_min);
                    }
                    comps = comps + 1;
                }
                if (i > (N / 2) & j > (N / 2) + 1) {
                    d = (double) distance(coords, i, j);
                    if (d < dr_min) {
                        primero1 = i;
                        segundo1 = j;
                        dr_min = d;
                        System.out.println("la distancia minima derecha actual es " + dr_min);
                    }
                    comps = comps + 1;
                }
                comps = comps + 1;
                if (i >= (N / 2) - 2 & j < (N / 2) + 2) {
                    d = (double) distance(coords, i, j);
                    if (d < dc_min) {
                        primero2 = i;
                        segundo2 = j;
                        dc_min = d;
                        System.out.println("la distancia minima central actual es " + dc_min);
                    }
                    comps = comps + 1;
                }
            }
        }
        if (dl_min <= dr_min & dl_min <= dc_min) {
            System.out.println("_________________");
            System.out.println("# de comps: " + comps);
            System.out.print("LA DISTANCIA MINIMA ES: ");
            return dl_min;
        }

        if (dr_min <= dl_min & dr_min <= dc_min) {
            System.out.println("_________________");
            System.out.println("# de comps: " + comps);
            System.out.print("LA DISTANCIA MINIMA ES: ");
            return dr_min;
        }
        if (dc_min <= dr_min & dc_min <= dl_min) {
            System.out.println("_________________");
            System.out.println("# de comps: " + comps);
            System.out.print("LA DISTANCIA MINIMA ES: ");
            return dc_min;
        }
        return 0;
    }
    /recursive method
    public String ClosestPairRecursive(int N, int coords[][], int i, int j, int comp) {
        int primero, segundo, primero1, segundo1, primero2, segundo2;
        double dl_min = Double.POSITIVE_INFINITY;
        double dr_min = Double.POSITIVE_INFINITY;
        double dc_min = Double.POSITIVE_INFINITY;
        double d;

        if (i <= coords.length - 2) {

            if (j < coords[i].length) {

                if (i < (N / 2) & j < (N / 2) + 1) {

                    d = (double) distance(coords, i, j);
                    if (d < dl_min && j < N) {

                        primero = i;
                        segundo = j;
                        dl_min = d;
                        comp1=comp;
                        ClosestPairRecursive(N, coords, i, j + 1, comp+4);

                    }
                    ClosestPairRecursive(N, coords, i + 1, j, comp+4);
                }
                if (i > (N / 2) & j > (N / 2) + 1) {

                    d = (double) distance(coords, i, j);
                    if (d < dr_min && j < N) {
                        primero1 = i;
                        segundo1 = j;

                        dr_min = d;
                        comp1=comp;
                        ClosestPairRecursive(N, coords, i, j + 1, comp+5);

                    }
                    ClosestPairRecursive(N, coords, i + 1, j, comp+5);

                }
                if (i >= (N / 2) - 2 & j < (N / 2) + 2) {

                    
                    d = (double) distance(coords, i, j);
                    if (d < dc_min) {
                        primero2 = i;
                        segundo2 = j;
                        dc_min = d;
                        comp1=comp;
                        ClosestPairRecursive(N, coords, i, j + 1, comp+6);

                    }
                    ClosestPairRecursive(N, coords, i + 1, j, comp+6);
                
                }
                
            }comp++;
        }comp++;
        
        if (dl_min <= dr_min & dl_min <= dc_min) {
            comp1++;

            return "distancia minima: " + dl_min + " con " + comp1 + " comparaciones";
        }

        if (dr_min <= dl_min & dr_min <= dc_min) {
            comp1++;
            return "distancia minima: " + dr_min + " con " + comp1 + "  comparaciones";
        }
        if (dc_min <= dr_min & dc_min <= dl_min) {
            comp1++;

            return "distancia minima: " + dc_min + " con " + comp1 + "  comparaciones";
        }
        return "0";
    }
     //Get distance between points.
    public double distance(int coords[][], int i, int j) {
        int x1, y1, x2, y2;
        x1 = coords[i][0];
        x2 = coords[j][0];
        y1 = coords[i][1];
        y2 = coords[j][1];

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return d;

    }

}
