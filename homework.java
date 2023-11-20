

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class homework {
    static class PhoneBook {
        private final HashMap<String, List<Integer>> phoneBook = new HashMap<>();

        public void add(String name, Integer phoneNum) {
            if (phoneBook.containsKey(name)) {
                List<Integer> phoneList = phoneBook.get(name);
                phoneList.add(phoneNum);
            } else {
                List<Integer> phoneList = new ArrayList<>();
                phoneList.add(phoneNum);
                phoneBook.put(name, phoneList);
            }
        }

        public List<Integer> find(String name) {
            return phoneBook.getOrDefault(name, new ArrayList<>());
        }

        public Map<String, List<Integer>> getPhoneBook() {
            return phoneBook.entrySet()
                    .stream()
                    .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        }
    }

    public static class PhoneBookApp {
        public static void main(String[] args) {
            PhoneBook myPhoneBook = new PhoneBook();

            myPhoneBook.add("Александр Белов", 938294148 );
            myPhoneBook.add("Анастасия Фролова", 949105473);
            myPhoneBook.add("Илья Калашников", 987654321);
            myPhoneBook.add("Сергей Комаров", 1424953425);
            myPhoneBook.add("Екатерина Уварова", 57635763);
            myPhoneBook.add("Дарья Гончарова", 533332345);
            myPhoneBook.add("Дарья Гончарова", 574327574);

            System.out.println("Contacts:");
            Map<String, List<Integer>> phoneBook = myPhoneBook.getPhoneBook();

            phoneBook.forEach((name, phoneNum) -> System.out.println(name + " -> " + phoneNum));


        }
    }



}