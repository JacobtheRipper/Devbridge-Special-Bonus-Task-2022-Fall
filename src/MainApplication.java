import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    private final BufferedReader reader;

    public MainApplication() throws FileNotFoundException {
        String fileName = "src/inputFile.txt";
        reader = new BufferedReader(new FileReader(fileName));
    }

    public void printLinesWithNumbersGreaterThanNine() throws IOException {
        String currentLineInFile;
        int highestExtractedInteger;

        while ((currentLineInFile = reader.readLine()) != null) {
            highestExtractedInteger = extractHighestIntegerFromString(currentLineInFile);
            if (highestExtractedInteger > 9) System.out.println(currentLineInFile);
        }
    }

    public int extractHighestIntegerFromString(String inputString) {
        int outputInteger;
        String[] arrayOfNumericStrings;
        List<Integer> listOfIntegers = new ArrayList<>();

        // replace non-digit character with " "
        inputString = inputString.replaceAll("[^0-9]", " ");
        inputString.trim();
        // replace consecutive spaces with " "
        inputString.replaceAll(" +", " ");

        arrayOfNumericStrings = inputString.split(" ");

        for (String string: arrayOfNumericStrings) {
            if (!string.equals("")) {
                listOfIntegers.add(Integer.parseInt(string));
            }
        }

        outputInteger = listOfIntegers.get(0);

        for (Integer integerElement : listOfIntegers) {
            if (integerElement > outputInteger) outputInteger = integerElement;
        }

        return outputInteger;
    }

    public void closeFile() throws IOException {
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        MainApplication application = new MainApplication();
        application.printLinesWithNumbersGreaterThanNine();
        application.closeFile();
    }
}
