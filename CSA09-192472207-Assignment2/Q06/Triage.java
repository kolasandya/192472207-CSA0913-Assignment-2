import java.util.*;

class Patient {final String name;final int severity;final long arrival;Patient(String n,int s,long a){name=n;severity=s;arrival=a;}public String toString(){return name+"(S"+severity+")";} }
public class Triage {
    private long counter=0;
    private final PriorityQueue<Patient> queue=new PriorityQueue<>(Comparator.comparingInt((Patient p)->p.severity).thenComparingLong(p->p.arrival));
    void admit(String name,int severity){if(severity<1||severity>5)throw new IllegalArgumentException("Severity must be 1 to 5");queue.add(new Patient(name,severity,counter++));}
    Patient next(){return queue.poll();}
    public static void main(String[] args){Triage er=new Triage();er.admit("Ravi",3);er.admit("Meena",1);er.admit("John",3);er.admit("Asha",5);er.admit("Kumar",1);er.admit("Lata",2);
        StringBuilder order=new StringBuilder();Patient p;while((p=er.next())!=null)order.append(p).append(' ');System.out.println(order.toString().trim());
        System.out.println("PriorityQueue add/poll: O(log n); peek: O(1). Arrival counter preserves FIFO among equal severity.");
        System.out.println("Starvation risk: minor cases can wait if critical cases continuously arrive. Fair rule: promote a waiting patient one severity level after a defined waiting interval, while preserving arrival order within a level.");
        System.out.println("For 5,000 arrivals/day, a PriorityQueue is practical in memory if queue size is bounded and persistence/monitoring are handled separately.");
    }
}
