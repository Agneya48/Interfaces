import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ShortLister {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String lineRec = "";
        ArrayList<String> textDocLines = new ArrayList<>();
        ShortWordFilter filter = new ShortWordFilter(4);
        //defaults to accepting Strings of less than 5 chars, but parameter can be set to other values
        SafeInputObj safeInput = new SafeInputObj();
        //exists solely to enable filter at start of program run; wanted to compare outputs

        System.out.println();
        boolean filterToggle = safeInput.getYNConfirm("Enable filter of longer words? [Y/N]");

        try {

            File workingDirectory = new File(System.getProperty("user.dir") + "\\src");

            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
                {
                    while (reader.ready()) {
                        lineRec = reader.readLine();
                        textDocLines.add(lineRec);
                    }
                }

                System.out.println();
                int lineNumber = 0;
                for (String line : textDocLines) {
                    System.out.println();
                    System.out.print(lineNumber + "   ");
                    String[] words = line.split("\\s+"); //splits words in line via whitespace
                    for (String word : words) {
                        if (filterToggle) {
                            if (filter.accept(word)) {
                                System.out.print(word + " ");
                            }
                        }
                        else {
                            System.out.print(word + " ");
                        }
                    }
                    lineNumber++;
                }
                System.out.println();
                if (filterToggle) {
                    System.out.println();
                    System.out.println("Successful filtering of words longer than " + filter.getMaxChar() + " characters.");
                    System.out.println();
                    System.out.println("Text file reading complete.");
                }
                else {
                    System.out.println();
                    System.out.println("Text file reading complete.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No file selected, please run the program again.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}