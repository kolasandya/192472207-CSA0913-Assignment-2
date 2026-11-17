import java.util.*;

public class TicketBuilderBenchmark {
    interface Builder { String build(String[] fields); }
    static String withPlus(String[] f) { String s = ""; for (String x : f) s += x; return s; }
    static String withBuilder(String[] f) { StringBuilder b = new StringBuilder(); for (String x : f) b.append(x); return b.toString(); }
    static String withBuffer(String[] f) { StringBuffer b = new StringBuffer(); for (String x : f) b.append(x); return b.toString(); }
    static long measure(Builder b, String[] data, int repeats) {
        long start = System.nanoTime(); int checksum = 0;
        for (int i=0;i<repeats;i++) checksum += b.build(data).length();
        long elapsed = System.nanoTime()-start;
        if (checksum == -1) System.out.println(checksum);
        return elapsed / repeats;
    }
    static String[] fields(int n) { String[] a=new String[n]; for(int i=0;i<n;i++) a[i]="FIELD"+i+" "; return a; }
    public static void main(String[] args) {
        int[][] workloads={{6,2000},{50,10000},{200,3000}};
        String[] names={"Short ticket","10,000 tickets x 50 fields","Custom: 3,000 tickets x 200 fields"};
        Builder[] methods={TicketBuilderBenchmark::withPlus,TicketBuilderBenchmark::withBuilder,TicketBuilderBenchmark::withBuffer};
        String[] methodNames={"String +","StringBuilder","StringBuffer"};
        System.out.println("Average time per ticket (ns); run several times for more reliable evidence");
        for(int w=0;w<workloads.length;w++) {
            String[] data=fields(workloads[w][0]); int repeats=workloads[w][1];
            System.out.println("\n"+names[w]);
            for(int m=0;m<methods.length;m++) System.out.printf("%-14s %d ns%n",methodNames[m],measure(methods[m],data,repeats));
            System.out.println("Estimated intermediate concatenation results for +: about " + Math.max(0,data.length-1) + " per ticket.");
        }
        System.out.println("Decision: use StringBuilder for a ticket built by one thread; use StringBuffer only if the same mutable buffer must be shared between threads. Prefer separate per-ticket builders.");
    }
}
