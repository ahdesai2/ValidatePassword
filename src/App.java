import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
//import java.security.Key;
//import java.security.KeyStore.Entry;
import java.util.Map.Entry;


public class App {
    public static void main(String[] args) throws Exception {
        if(args.length == 0){
       System.out.println("Please try again and input a validate password!");
        System.exit(1);
        }
        String password = args[0];
        System.out.println("Your password is " + password);
        int len = password.length();
        if (len < 8 || len > 16){
           System.out.println("Please try and again and input a validate password between 8 and 16 characters");
           System.exit(0);
        }

Set<Character> upperCaseLetters = new TreeSet<>();
Set<Character> lowerCaseLetters = new TreeSet<>();
Set<Character> numbers = new TreeSet<>();
Set<Character> specialSymbols = new TreeSet<>();

Map<String, Integer> count = new TreeMap<>();
for (int i = (int)'A'; i <= (int)'Z'; i++){
    Character c = (char) i;
    upperCaseLetters.add(c);
    lowerCaseLetters.add(Character.toLowerCase(c));
}
for (int i = (int)'0'; i <= (int)'9'; i++){
    Character c = (char) i;
    numbers.add(c);
}

String str = "~!@#$%^&*()-=+_";
for (Character c : str.toCharArray()){
    specialSymbols.add(c);
}

for (Character c : password.toCharArray()){
    String key = "lowerCaseLetters";
    if (lowerCaseLetters.contains(c)){
        if (count.containsKey(key)){
            count.put(key, count.get(key) + 1);
        } else {
            count.put(key, 1); //value?
        }
    }
    key = "upperCaseLetters";
    if (upperCaseLetters.contains(c)){
        if (count.containsKey(key)){
            count.put(key, count.get(key) + 1);
        } else {
            count.put(key, 1); //value?
        }
    }
    key = "numbers";
    if (numbers.contains(c)){
        if (count.containsKey(key)){
            count.put(key, count.get(key) + 1);
        } else {
            count.put(key, 1); //value?
        }
    }
    key = "specialSymbols";
    if (specialSymbols.contains(c)){
        if (count.containsKey(key)){
            count.put(key, count.get(key) + 1);
        } else {
            count.put(key, 1); //value?
        }
    }
}
for (Entry<String, Integer> entry: count.entrySet()){
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

/*Iterator<Character> iterator = upperCaseLetters.iterator();
while (iterator.hasNext()){
    System.out.print(iterator.next());
} */
if (count.size() < 3){
    System.out.println("Please try and again and input a validate password between 8 and 16 characters");
           System.exit(0);
}

System.out.println("Great job! Your password satisfies all the requirements.");

}
}