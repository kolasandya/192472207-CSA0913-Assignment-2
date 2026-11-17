import java.util.*;

class Medicine { final String code,name; final int stock; Medicine(String c,String n,int s){code=c;name=n;stock=s;} public String toString(){return code+" "+name+" stock="+stock;} }
public class PharmacyInventory {
    static volatile int sink;
    static long lookupTime(Map<String,Medicine> map,List<String> keys){long s=System.nanoTime();int x=0;for(int i=0;i<100000;i++){Medicine m=map.get(keys.get(i%keys.size()));if(m!=null)x+=m.stock;}sink=x;return System.nanoTime()-s;}
    public static void main(String[] args){
        int[] sizes={100,1000,10000};
        for(int n:sizes){
            Map<String,Medicine> hash=new HashMap<>(),tree=new TreeMap<>(),linked=new LinkedHashMap<>();List<String> keys=new ArrayList<>();
            for(int i=n-1;i>=0;i--){String k=String.format("MED%05d",i);Medicine m=new Medicine(k,"Medicine"+i,i%500);hash.put(k,m);tree.put(k,m);linked.put(k,m);keys.add(k);}
            System.out.println("\nMedicines="+n);
            System.out.println("100,000 lookup ns: HashMap="+lookupTime(hash,keys)+", TreeMap="+lookupTime(tree,keys)+", LinkedHashMap="+lookupTime(linked,keys));
            long s=System.nanoTime();String firstHash=hash.keySet().iterator().next();long hashReport=System.nanoTime()-s;
            s=System.nanoTime();String firstTree=tree.keySet().iterator().next();long treeReport=System.nanoTime()-s;
            s=System.nanoTime();String firstLinked=linked.keySet().iterator().next();long linkedReport=System.nanoTime()-s;
            System.out.println("First key (code order / insertion order evidence): HashMap="+firstHash+", TreeMap="+firstTree+", LinkedHashMap="+firstLinked);
            System.out.println("First-key iteration ns: "+hashReport+", "+treeReport+", "+linkedReport);
        }
        System.out.println("Choice: HashMap for fast exact lookup; TreeMap for code-sorted report; LinkedHashMap for insertion-order report. Hashtable is legacy synchronized collection; modern code usually uses HashMap unless synchronization is required.");
        System.out.println("Sorted-array alternative: binary search O(log n) lookup, O(n) insertion, O(n) storage; sorted report O(n).");
    }
}
