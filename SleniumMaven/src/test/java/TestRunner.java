import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestRunner {
    public static void main(String[] args) {
        KeywordActions keywordActions = new KeywordActions();
        String csvFile = "C:/Users/anany/SeleniumProjects/SleniumMaven/src/test/test_data.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                Keyword keyword = Keyword.valueOf(data[0]);
                String param1 = data.length > 1 ? data[1] : null;
                String param2 = data.length > 2 ? data[2] : null;
                keywordActions.performAction(keyword, param1, param2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
