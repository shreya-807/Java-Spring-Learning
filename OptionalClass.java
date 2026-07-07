import java.util.*;
public class OptionalClass {
    public static void main(String[] args){
List<String> list = new ArrayList<>();
        list.add("Abc");
        list.add("Bcd");
        list.add("Cde");
        list.add("Def");
        list.add("Efg");
        
        Optional<String> names = list.stream()
        .filter(s -> s.contains("p"))
        .findFirst();
        
       System.out.println(names.orElse("null"));
    }
}
