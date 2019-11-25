import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Dictionary {

    private List<String> dictList = new ArrayList<>();
    private File dictFile = new File(System.getProperty("user.dir") + "\\src\\Dictionary_File.txt");
    private FileReader fr = new FileReader(dictFile);

    public File getDictFile() {
        return dictFile;
    }

    Dictionary() throws FileNotFoundException {
    }

    List<String> getDictList() throws IOException {

        int i;
        StringBuilder stringBuilder = new StringBuilder();

        while ((i = fr.read()) != -1) {
            stringBuilder.append((char) i);
        }

        String[] arrDict = stringBuilder.toString().split(" ");


        dictList.addAll(Arrays.asList(arrDict));
        return dictList;
    }
}
