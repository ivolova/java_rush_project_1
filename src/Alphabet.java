import java.util.*;

public class Alphabet {
    private static final List<Character> alphabet = get();

    private static HashMap<Character, Character> shiftMap;

    public static int getCountCharsInAlphabet() {
        return alphabet.size();
    }

    public static void fillAlphabetShiftMap(int shift) {

        int offset = shift % alphabet.size();
        ArrayList<Character> offsetAlphabet = new ArrayList(alphabet);
        Collections.rotate(offsetAlphabet, -offset);
        if (shiftMap == null) {
            shiftMap = new HashMap<>();
        }
        for (int i = 0; i < offsetAlphabet.size(); i++) {

            shiftMap.put(alphabet.get(i), offsetAlphabet.get(i));

        }

        System.out.println(shiftMap.toString());

    }

    public static HashMap<Character, Character> getShiftMap() {

        return shiftMap;
    }

    private static List<Character> get() {

        ArrayList<Character> newAlphabet = new ArrayList<>();
        add('a', 'z', newAlphabet);
        add('A', 'Z', newAlphabet);
        add('А', 'Я', newAlphabet);
        add('а', 'я', newAlphabet);
        add(new String(",.;!"), newAlphabet);

        return newAlphabet;
    }


    private static ArrayList<Character> add(Character from, Character to, ArrayList<Character> inList) {

        List<Character> chars = getListChars(from, to);
        if (chars.size() == 0) {
            return inList;
        }
        inList.addAll(chars);

        return inList;
    }

    private static List<Character> add(String stringSimbols, List<Character> inList) {

        if (stringSimbols.isBlank()) {
            return inList;
        }
        char[] chars = stringSimbols.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            inList.add(Character.valueOf(chars[i]));
        }

        return inList;
    }


    private static List<Character> getListChars(Character from, Character to) {

        ArrayList<Character> listChars = new ArrayList<>();
        for (char c = from; c <= to; c++) {
            listChars.add(c);
        }

        return listChars;
    }
}
