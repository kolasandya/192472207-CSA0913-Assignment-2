import java.util.*;

public class ListBenchmark {
    static volatile long sink;
    static long time(Runnable r) { long s=System.nanoTime(); r.run(); return System.nanoTime()-s; }
    static ArrayList<Integer> array(int n){ ArrayList<Integer> a=new ArrayList<>(n); for(int i=0;i<n;i++)a.add(i); return a; }
    static LinkedList<Integer> linked(int n){ LinkedList<Integer> a=new LinkedList<>(); for(int i=0;i<n;i++)a.add(i); return a; }
    public static void main(String[] args) {
        int[] sizes={1000,10000,30000};
        System.out.println("Size,ArrayList append ns,LinkedList append ns,ArrayList middle insert/remove ns,LinkedList middle insert/remove ns,ArrayList random access ns,LinkedList random access ns,ArrayList iterate ns,LinkedList iterate ns");
        for(int n:sizes){
            long aa=time(()->{ArrayList<Integer>a=new ArrayList<>();for(int i=0;i<n;i++)a.add(i);});
            long la=time(()->{LinkedList<Integer>a=new LinkedList<>();for(int i=0;i<n;i++)a.add(i);});
            ArrayList<Integer> a=array(n); LinkedList<Integer> l=linked(n); int mid=n/2;
            long ai=time(()->{for(int k=0;k<100;k++){a.add(mid,k);a.remove(mid);}});
            long li=time(()->{for(int k=0;k<100;k++){l.add(mid,k);l.remove(mid);}});
            long ar=time(()->{long x=0;for(int k=0;k<1000;k++)x+=a.get((k*31)%n);sink=x;});
            long lr=time(()->{long x=0;for(int k=0;k<1000;k++)x+=l.get((k*31)%n);sink=x;});
            long at=time(()->{long x=0;for(int v:a)x+=v;sink=x;});
            long lt=time(()->{long x=0;for(int v:l)x+=v;sink=x;});
            System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d%n",n,aa,la,ai,li,ar,lr,at,lt);
        }
        System.out.println("Up Next recommendation: ArrayDeque, because addFirst/addLast/removeFirst are amortized O(1). It is not intended for indexed access.");
    }
}
