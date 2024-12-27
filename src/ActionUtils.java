public class ActionUtils {


    public static void run(Action forAction, int withShift) {

        Alphabet.fillAlphabetShiftMap(withShift);

        TextUtils.doProcess(forAction);
    }


    public static int runBrutForce() {

        int maxShiftCharsInAlphabet = Alphabet.getCountCharsInAlphabet();

        for (int shift = 0; shift < maxShiftCharsInAlphabet; shift++) {

            run(Action.BRUTFORCE, shift);

            if (TextUtils.isDecrypted()) {
                return shift;
            }
        }
        throw new RuntimeException("Не удалось определить смещение");
    }

}

