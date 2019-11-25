import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static Dictionary dictionary;

    static {
        try {
            dictionary = new Dictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<String> list = new ArrayList<>();
    private static List<String> sortedList = new ArrayList<>();
    private static InputStream is = System.in;
    private static StringBuilder userWord = new StringBuilder();
    private static FileWriter fw;

    static {
        try {
            fw = new FileWriter(dictionary.getDictFile(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enterLetter() throws IOException {

        char choice = 777;

        while (true) {

            if (choice != '\n') {
                System.out.println("Your word is: " + userWord);
                System.out.println("--- If it was last letter of the word, please type number: \"0\"");
                System.out.println("--- If you would like to finish the program, please type number: \"1\"");
                System.out.println("--- Or just enter your NEXT LETTER under this line and press \"Enter\":");
            }

            choice = (char) is.read();

            if (choice != '\n') {
                if (choice == '0') {
                    String str = userWord.toString();
                    fw.write(" " + str);
                    fw.flush();
                    list = dictionary.getDictList();
                    userWord.setLength(0);
                } else if (choice == '1') {
                    is.close();
                    break;
                }

                if (choice != '0') {
                    userWord.append(choice);

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).startsWith(String.valueOf(userWord))) {
                            sortedList.add(list.get(i));
                        }
                    }
                }
            }

            Collections.sort(sortedList);

            for (String s : sortedList) {
                System.out.println("Matching word is: " + s);
            }

            sortedList.clear();
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {

        list = dictionary.getDictList();
        enterLetter();
    }
}
