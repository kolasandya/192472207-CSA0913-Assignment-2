import java.util.*;

class Student {
    private final String regNo; private final String name;
    Student(String regNo,String name){this.regNo=regNo;this.name=name;}
    @Override public boolean equals(Object o){if(this==o)return true;if(!(o instanceof Student))return false;Student s=(Student)o;return Objects.equals(regNo,s.regNo);}
    @Override public int hashCode(){return Objects.hash(regNo);}
    @Override public String toString(){return regNo+" "+name;}
}
class MutableStudent {
    String regNo; MutableStudent(String r){regNo=r;}
    @Override public boolean equals(Object o){return o instanceof MutableStudent && Objects.equals(regNo,((MutableStudent)o).regNo);}
    @Override public int hashCode(){return Objects.hash(regNo);}
}
public class Attendance {
    public static void main(String[] args){
        Set<Student> present=new HashSet<>();present.add(new Student("192311001","Arun"));present.add(new Student("192311002","Divya"));present.add(new Student("192311001","Arun"));
        System.out.println("Corrected HashSet unique students: "+present.size());
        Set<Student> differentIds=new HashSet<>();differentIds.add(new Student("192311001","Arun"));differentIds.add(new Student("192311002","Divya"));System.out.println("Different IDs test size: "+differentIds.size());
        Set<Student> sameIdDifferentName=new HashSet<>();sameIdDifferentName.add(new Student("192311003","Ravi"));sameIdDifferentName.add(new Student("192311003","Ravi Kumar"));System.out.println("Same ID, different name test size: "+sameIdDifferentName.size());
        Set<MutableStudent> changing=new HashSet<>();MutableStudent m=new MutableStudent("A1");changing.add(m);m.regNo="B2";System.out.println("Contains after changing key field: "+changing.contains(m)+" (may be false; never mutate hash key fields)");
        System.out.println("Alternative: HashMap<String,Student> uses regNo as key; TreeSet with comparator gives O(log n) operations.");
    }
}
