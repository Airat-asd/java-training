import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("абрикос", "манго", "яблоко", "абрикос", "яблоко", "вишня", "капуста", "персик", "машина","компьютер", "телефон" ));
        ArrayList<Integer> quantity = new ArrayList<>();
        int s;
        for (int i = 0; i < arrayList.size(); i++) {
            s=1;
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                if (arrayList.get(i) == arrayList.get(j)) {
                    s++;
                    System.out.println(arrayList.get(i));
                }
            }
            quantity.add(i, s);
        }
        quantity.trimToSize();
        System.out.println(quantity);
        Phonebook phonebook = new Phonebook();
        phonebook.add ("Василий", 19357565);
        phonebook.add ("Василий", 9999999);
        phonebook.add ("Tdutybq", 1231231);
        phonebook.add ("фывфывфы", 77897897);
        phonebook.add ("прпропрор", 999956756);
        phonebook.add ("Василий", 999956756);

        System.out.println(phonebook.get("Василий"));
        System.out.println(phonebook.get("Tdutybq"));
    }

}
