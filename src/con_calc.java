import java.util.TreeMap;

public class con_calc {
    TreeMap<Character, Integer> KeyMap = new TreeMap<>();
    TreeMap<Integer, String> ArKeyMap = new TreeMap<>();

    public con_calc() {
        KeyMap.put('I', 1);
        KeyMap.put('V', 5);
        KeyMap.put('X', 10);
        KeyMap.put('L', 50);
        KeyMap.put('C', 100);
        KeyMap.put('D', 500);
        KeyMap.put('M', 1000);

        ArKeyMap.put(1000, "M");
        ArKeyMap.put(900, "CM");
        ArKeyMap.put(500, "D");
        ArKeyMap.put(400, "CD");
        ArKeyMap.put(100, "C");
        ArKeyMap.put(90, "XC");
        ArKeyMap.put(50, "L");
        ArKeyMap.put(40, "XL");
        ArKeyMap.put(10, "X");
        ArKeyMap.put(9, "IX");
        ArKeyMap.put(5, "V");
        ArKeyMap.put(4, "IV");
        ArKeyMap.put(1, "I");

    }


    public boolean num(String number){
        return KeyMap.containsKey(number.charAt(0));
    }

    //15
    public String intToNum(int number) {
        String num = "";
        int arabianKey;
        do {
            arabianKey = ArKeyMap.floorKey(number);
            num += ArKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return num;


    }
    //XV
    public int numToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int ar;
        int result = KeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            ar = KeyMap.get(arr[i]);

            if (ar < KeyMap.get(arr[i + 1])) {
                result -= ar;
            } else {
                result += ar;
            }


        }
        return result;

    }
}