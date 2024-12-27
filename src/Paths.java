import java.nio.file.Path;

public class Paths {

    private static final Path SOURCE_PATH = Path.of("src/data.txt");
    private static final Path ENCRYPTED_PATH = Path.of("src/encrypted.txt");
    private static final Path DECRYPTED_PATH =Path.of("src/decrypted.txt");
    private static final Path EXISTS_WORDS_PATH  = Path.of("src/existswords.txt");

    public static Path From(Action forAction) {

        Path path = switch (forAction) {
            case ENCRYPTED -> SOURCE_PATH;
            case DECRYPTED, BRUTFORCE  -> ENCRYPTED_PATH;
            case FIND_WORDS -> DECRYPTED_PATH;
        };

        return path;
    }

    public static Path To(Action forAction) {

        Path path = switch (forAction) {
            case ENCRYPTED -> ENCRYPTED_PATH;
            case DECRYPTED, BRUTFORCE  -> DECRYPTED_PATH;
            case FIND_WORDS -> EXISTS_WORDS_PATH;
        };

        return path;
    }
}
