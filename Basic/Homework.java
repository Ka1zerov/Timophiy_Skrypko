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

    public static int pairCounter(int[] arr, int target){
        int counter = 0;
        Map<Integer, Integer> counterTable = new HashMap<>();
        for (var i : arr) {
            if (counterTable.containsKey(i)){
                counterTable.put(i, counterTable.get(i)+1);
            } else {
                counterTable.put(i, 1);
            }
        }
        for (var entry : counterTable.entrySet()) {
            if (counterTable.containsKey(target - entry.getKey())){
                counter += entry.getValue() * counterTable.get(target - entry.getKey());
                counterTable.put(entry.getKey(), 0);
            }
        }
        return counter;
    }

    public static String sorter(String str){
        return Arrays.stream(str.split(";"))
                .map(p -> p.split(":"))
                .sorted(Comparator.comparing((String[] p) -> p[1]).thenComparing((String[] p) -> p[0]))
                .map(p -> String.format("(%s, %s)", p[1].toUpperCase(), p[0].toUpperCase()))
                .collect(Collectors.joining());
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
