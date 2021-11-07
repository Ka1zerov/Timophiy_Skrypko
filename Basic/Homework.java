package Basic;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

public class Homework {

    public static List<Object> getIntegersFromList(List<Object> array) {
        return array.stream().filter(x -> x instanceof Integer).collect(Collectors.toList());
    }

    public static String firstNonRepeatingLetter(String str) {
        Map<Character, Integer> charMap = new LinkedHashMap();
        for (Character ch : str.toCharArray()) {
            charMap.put(ch, (charMap.containsKey(Character.toUpperCase(ch)) || charMap.containsKey(Character.toLowerCase(ch))) ? 0 : 1);
        }
        return charMap.isEmpty() ? "" : String.valueOf(charMap.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey());
    }

    public static int digitalRoot(int number) {
        int div = number / 10;
        int sum = number % 10 + (div < 10 ? div : digitalRoot(div));
        if (sum > 10) {
            return digitalRoot(sum);
        } else {
            return sum;
        }
    }

    public static int countPairs(int[] arr, int sumNumber) {
        int counter = 0;
        Map<Integer, Integer> intMap = new LinkedHashMap();
        for (int i : arr) {
            intMap.put(i, intMap.containsKey(i) ? intMap.get(i) + 1 : 1);
        }

        Iterator<Integer> iterator = intMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer currInt = iterator.next();
            if (intMap.containsKey(sumNumber - currInt)) {
                counter += intMap.get(currInt) * intMap.get(sumNumber - currInt);
                iterator.remove();
            }
        }
        return counter;
    }

    public static String generateInvite(String unformattedInvite) {
        if (unformattedInvite.equals("")) {
            return "";
        }

        class Person implements Comparable<Person> {
            String name;
            String surname;

            public Person(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String toString() {
                return "(" + surname + ", " + name + ")";
            }

            @Override
            public int compareTo(Person o) {
                int result = surname.compareTo(o.surname);
                if (result == 0) {
                    result = name.compareTo(o.name);
                }
                return result;
            }
        }

        ArrayList<Person> people = new ArrayList<>();

        String[] peopleSting = unformattedInvite.split(";");

        for (String str : peopleSting) {
            String[] separated = str.split(":");
            people.add(new Person(separated[0].toUpperCase(), separated[1].toUpperCase()));
        }

        people.sort(Person::compareTo);

        StringBuilder formattedInvite = new StringBuilder();
        for (Person p : people) {
            formattedInvite.append(p.toString());
        }

        return String.valueOf(formattedInvite);
    }

    public static int nextBigger(int number) {
        ArrayList<Integer> digits = new ArrayList<>();

        //number to array
        while (number >= 10) {
            digits.add(number % 10);
            number /= 10;
        }
        digits.add(number);

        if (digits.size() == 1) {
            return -1;
        }

        int first = digits.get(0);
        for (int i = 1; i < digits.size(); i++) {
            if (digits.get(i) > first) {
                return -1;
            }
        }

        int index = 0;
        FindSmaller:
        {
            for (int i = 0; i < digits.size(); i++) {
                for (int j = i + 1; j < digits.size(); j++) {
                    if (digits.get(i) > digits.get(j)) {
                        swap(digits, i, j);
                        index = j;
                        break FindSmaller;
                    }
                }
            }
        }

        for (int i = 0; i < index - 1; i++) {
            for (int j = i; j < index; j++) {
                if (digits.get(i) < digits.get(j)) {
                    swap(digits, i, j);
                }
            }
        }
        // array back to number
        int res = 0;
        for (int i = 0; i < digits.size(); i++) {
            res += digits.get(i) * Math.pow(10, i);
        }
        return res;
    }

    public static String numberToIpAddress(long longAddress) {
        String binaryString = Long.toBinaryString(longAddress);

        StringBuilder sb = new StringBuilder(binaryString);
        while (sb.length() < 32) {
            sb.insert(0, "0");
        }

        StringBuilder ipv4 = new StringBuilder();
        while (!sb.isEmpty()) {
            ipv4.append(Integer.parseInt(sb.substring(0, 8), 2) + ".");
            sb.delete(0, 8);
        }
        ipv4.deleteCharAt(ipv4.length() - 1);
        return ipv4.toString();
    }
}
