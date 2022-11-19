package lab_cordenadas;

import static java.lang.Math.sqrt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Lab_Cordenadas {
int comp1=0;
int j=0;
    

    public static void main(String[] args) {

       
        Lab_Cordenadas dismin = new Lab_Cordenadas();
        Random r = new Random();
            int c = 1, comps=0;
            int N = 25;//2*r.nextInt((int) (Math.random() * 15 + 10));
            System.out.println(+c+".Numero de puntos es "+N);
            LinkedList<Integer> listx = new LinkedList();
            LinkedList<Integer> listy = new LinkedList();
            while (N<6){
                c=c+1;
                N=2*r.nextInt((int) (Math.random() * 15 + 10));
                System.out.println(+c+".Número de puntos es "+N);
            }
            /*int [][] coords = new int[N][2];*/
            System.out.println("|x||y|");
            for (int x=0; x < N; x++) {
                    listx.add((x*2)+(int)(Math.random() * 9 + 1));
                    listy.add(((x*2)+(int)(Math.random() * 9 + 1)));
                    
                    /*coords[x][y] = (x*2)+(int)(Math.random()*5+1);*/
            }
            Iterator iteratorx=listx.iterator();
            Iterator iteratory=listy.iterator();
            while(iteratorx.hasNext()){
                System.out.println(iteratorx.next()+"|"+iteratory.next());
            }System.out.println("");
            
        
        long startTime = System.nanoTime();
        System.out.println(dismin.ClosestPairRecursive(N, listx, listy, 0, 0));
        long endTime = System.nanoTime();
        long TkTime = endTime - startTime;
        System.out.println("tiempo de ejecucion: " + TkTime + " nanosegundos ");
        System.out.println("N : " + N);

    }

    public double distance( LinkedList listx, LinkedList listy, int i, int j) {
        double x1, y1, x2, y2;
        System.out.println("i= "+i);
        System.out.println("j="+j);
        x1 = (int)listx.get(i);
        y1 = (int)listy.get(i);
        x2 = (int)listx.get(j);
        y2 = (int)listy.get(j);

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        //System.out.println("la distancia entre los puntos actuales es: "+d);
        return d;

    }public String ClosestPairRecursive(int N, LinkedList listx, LinkedList listy,int i, int comp) {
        
        int  primero, segundo, primero1, segundo1, primero2, segundo2;
        double dl_min = Double.POSITIVE_INFINITY;
        double dr_min = Double.POSITIVE_INFINITY;
        double dc_min = Double.POSITIVE_INFINITY;
        double d;

        if ( i <= N  ) {
                if (i < ( N / 2) & j < ((N / 2) + 1)) {

                    d = (double) distance( listx, listy, i, i+1);
                    if (d < dl_min ) {

                        primero = i;
                        segundo = j;
                        dl_min = d;
                        comp1=comp;
                        j++;
                        ClosestPairRecursive(N,  listx, listy, i++, comp+3);

                    }
                    
                }
                if (i > (N / 2) & j > (N / 2) + 1) {
                    d = (double) distance( listx, listy, i, i+1);
                    if (d < dr_min ) {
                        primero1 = i;
                        segundo1 = j;

                        dr_min = d;
                        comp1=comp;
                        j++;
                        ClosestPairRecursive(N,  listx, listy, i , comp+4);
                    }
                }
                if (i >= (N / 2) - 2 & j < (N / 2) + 2) {
                    d = (double) distance( listx, listy, i, i+1);
                    if (d < dc_min ) {
                        System.out.println(comp);
                        primero2 = i;
                        segundo2 = j;
                        dc_min = d;
                        comp1=comp;
                        j++;
                        ClosestPairRecursive(N,  listx, listy, i, comp+5);
                    }
                }
        }else{
            ClosestPairRecursive(N,  listx, listy, i+1, comp);
        }
        
        
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

    

    

}
