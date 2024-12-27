import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.String.valueOf;

public class TextUtils {

    public static final int MIN_COUNT_EXISTS_WORDS = 2;

    public static void doProcess(Action forAction) {

        try {
            Path pathFrom = Paths.From(forAction);
            Path pathTo = Paths.To(forAction);

            List<String> listIn = Files.readAllLines(pathFrom);

            List<String> listOut = decodeAllLines(listIn);

            Files.write(pathTo, listOut);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean isDecrypted() {
        try {
            Path pathFrom = Paths.From(Action.FIND_WORDS);
            Path pathTo = Paths.To(Action.FIND_WORDS);

            Set<String> setTrimDecryptedWords = getTrimWordsSet(Files.readAllLines(pathFrom));
            Set<String> setExistsWords = getTrimWordsSet(Files.readAllLines(pathTo));

            int countMatchWords = 0;
            for (String word : setExistsWords) {
                if (setTrimDecryptedWords.contains(word)) {
                    countMatchWords++;
                }
                if (countMatchWords >= MIN_COUNT_EXISTS_WORDS) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> decodeAllLines(List<String> listFrom) {
        List<String> listOut = new ArrayList<>();
        for (int i = 0; i < listFrom.size(); i++) {
            listOut.add(i, decodeLine(listFrom.get(i)));
        }
        return listOut;
    }

    private static String decodeLine(String line) {

        char[] ch = line.toCharArray();
        Map<Character, Character> alphabetMap = Alphabet.getShiftMap();

        for (int j = 0; j < ch.length; j++) {
            if (alphabetMap.containsKey(ch[j])) {
                ch[j] = alphabetMap.get(ch[j]);
            }
        }
        System.out.println(valueOf(ch));

        return valueOf(ch);
    }


    private static Set<String> getTrimWordsSet(List<String> list) {

        Set<String> set = new HashSet<>();

        for (String string : list) {
            String[] stringArray = string.split(" ");
            for (int i = 0; i < stringArray.length; i++) {
                set.add(stringArray[i].replaceAll("\\pP", "").toLowerCase());
            }
        }

        return set;
    }

}

