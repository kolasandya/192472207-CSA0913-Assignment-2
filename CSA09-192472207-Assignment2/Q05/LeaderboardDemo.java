import java.util.*;

class Team { final String name;final int points,goalDiff;Team(String n,int p,int g){name=n;points=p;goalDiff=g;}public String toString(){return name+"("+points+","+goalDiff+")";} }
class Leaderboard<T>{private final List<T> items=new ArrayList<>();private final Comparator<? super T> order;Leaderboard(Comparator<? super T> o){order=o;}void add(T item){items.add(item);}List<T> ranking(){List<T> copy=new ArrayList<>(items);copy.sort(order);return copy;}}
public class LeaderboardDemo {
    public static void main(String[] args){
        Comparator<Team> byRank=Comparator.comparingInt((Team t)->t.points).reversed().thenComparing(Comparator.comparingInt((Team t)->t.goalDiff).reversed()).thenComparing(t->t.name);
        Leaderboard<Team> board=new Leaderboard<>(byRank);board.add(new Team("Panthers",9,4));board.add(new Team("Eagles",9,6));board.add(new Team("Cobras",6,1));board.add(new Team("Bisons",9,4));
        System.out.println(board.ranking());
        List<Team> second=Arrays.asList(new Team("Zebras",12,2),new Team("Ants",12,2),new Team("Wolves",12,5),new Team("Foxes",8,9));second.sort(byRank);System.out.println("Second test: "+second);
        System.out.println("Bisons is above Panthers because both have 9 points and goal difference 4, so alphabetical name order puts Bisons first.");
        System.out.println("Comparator chain is reusable for other types; sorting a copy keeps original insertion order unchanged.");
    }
}
