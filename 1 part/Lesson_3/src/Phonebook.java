import java.util.HashMap;
import java.util.Map;

public class Phonebook {
//    private String family;
//    private int number;
    private HashMap<Integer, String> phonebook = new HashMap<>();

    void add(String family, Integer number) {
        if (phonebook.containsKey(number) ) System.out.println("Номер "+ number + " уже существует");
        else phonebook.put(number, family);
    }

    String get(String family) {
        String s = "";
        for (Map.Entry<Integer, String> entry: phonebook.entrySet())
            if (entry.getValue().equals(family)) s = entry.getKey() + "\n" + s;
        return s;
    }
}
