package closestpair_linkedlist;

import static java.lang.Math.sqrt;
import java.util.Random;
import java.util.*;

//@author escorciaad
 
  
public class ClosestPair_LinkedList {

        public static void main(String[] args) {
            System.out.println("iniciando");
            Random r = new Random();
            int c = 1, comps=0;
            int N = 2*r.nextInt((int) Math.random()*15+10);
            System.out.println(+c+".Numero de puntos es "+N);
            LinkedList<Integer> listx = new LinkedList();
            LinkedList<Integer> listy = new LinkedList();
            while (N<4){
                c=c+1;
                N=2*r.nextInt((int) Math.random()*150+100);
                System.out.println(+c+".Numero de puntos es "+N);
            }
            System.out.println("x,y");
            for (int x=0; x < N; x++) {
                    listx.add((x*2)+(int)(Math.random()*5+1));
                    listy.add((x*2)+(int)(Math.random()*5+1));
                    
            }
            Iterator<Integer> iteratorx=listx.iterator();
            Iterator<Integer> iteratory=listy.iterator();
            while(iteratorx.hasNext() & iteratory.hasNext()){
                System.out.println(iteratorx.next()+","+iteratory.next());
            }
            
            System.out.println("____________________________");           
            //int [][] coords = {
               // {3, 3},
               // {2, 4},
               // {10, 8},
               // {13, 5},
               // {16, 4},
             //   {15, 3}
           // };
            ClosestPair_LinkedList dismin = new ClosestPair_LinkedList();
            long ITime =  System.nanoTime();
            System.out.println(dismin.ClosestPair(N, listx, listy));
            long FTime =  System.nanoTime();
            long DTime = FTime - ITime;
            System.out.println("N es: "+N);
            System.out.println("tiempo de ejecucion: "+DTime+ " nanosegundos " );
        }
        
        
        public double ClosestPair(int N, java.util.LinkedList listx, java.util.LinkedList listy){
            int i, j, comps=0, primero, segundo, primero1, segundo1, primero2, segundo2;
            double dl_min = Double.POSITIVE_INFINITY;
            double dr_min = Double.POSITIVE_INFINITY;
            double dc_min = Double.POSITIVE_INFINITY;
            double d;
            for (i = 0; i <= N-2; i++){
               for (j = i+1; j  < N; j++){
                  if(i<(N/2) & j<(N/2)+1){
                   d = (double)distance(listx,listy,i,j);
                    if(d < dl_min){
                        primero = i;
                        segundo = j;
                        dl_min = d;
                        System.out.println("la distancia minima izquierda actual es "+dl_min);
                    }comps = comps+1;
                  }
                  if(i>(N/2) & j>(N/2)+1){
                    d = (double)distance(listx,listy,i,j);
                    if(d < dr_min){
                        primero1 = i;
                        segundo1 = j;
                        dr_min = d;
                        System.out.println("la distancia minima derecha actual es "+dr_min);
                    }comps = comps+1;  
                  }
                        comps = comps+1;
                  if(i>=(N/2)-2 & j<(N/2)+2){
                    d = (double)distance(listx,listy,i,j);
                    if(d < dc_min){
                        primero2 = i;
                        segundo2 = j;
                        dc_min = d;
                        System.out.println("la distancia minima central actual es "+dc_min);
                    }comps = comps+1;  
                  }
               }
            }
            if (dl_min<=dr_min & dl_min<=dc_min){
                System.out.println("_______________________________________________");
                System.out.println("# de comps: "+comps);
                System.out.print("LA DISTANCIA MINIMA ES: ");
                return  dl_min;
            }
            
            if (dr_min<=dl_min & dr_min<=dc_min){
                System.out.println("_______________________________________________");
                System.out.println("# de comps: "+comps);
                System.out.print("LA DISTANCIA MINIMA ES: ");
                return  dr_min; 
            }
            if (dc_min<=dr_min & dc_min<=dl_min){
                System.out.println("_______________________________________________");
                System.out.println("# de comps: "+comps);
                System.out.print("LA DISTANCIA MINIMA ES: ");
                return  dc_min;
            }
            return 0;
        }
    
        public double distance(java.util.LinkedList listx, java.util.LinkedList listy, int i, int j){
            double x1, y1, x2, y2;
            System.out.println("i="+i);
            System.out.println("j="+j);
            x1 = (int)listx.get(i);
            x2 = (int)listx.get(j);
            y1 = (int)listy.get(i);
            y2 = (int)listy.get(j);
            double d = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
            System.out.println("la distancia entre los putnos actuales es: "+d);
            return d;
            
        }
 
}