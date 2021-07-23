import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.Iterator;

public class TextClass{
    private String text;

    public TextClass(String text) {
        this.text = text;
    }

    public static String check(String oldText) {      // for checking and fixing the text
        ArrayList<String> words_AL = new ArrayList<String>();
        words_AL = splitText(oldText);    // calling splitText() method
        oldText = words_AL.get(0);
        words_AL.remove(0);

        String newText = reformText(oldText, words_AL);    // calling reformText() method

        return newText;    // return fixed text
    }

    public static ArrayList<String> splitText(String oldText){
        ArrayList<String> words_AL = new ArrayList<String>();
        words_AL.add(oldText);
        oldText = oldText.replace("-", " ");              // - containing words edited

        String[] inputWords = oldText.split("[. ,;]");   // the text is divided according to . ,; expressions.

        for (int i = 0; i < inputWords.length; i++) {
            if(inputWords[i].equals("")){           // if word equals null, it is not added to array list
                continue;
            }
            else
                words_AL.add(inputWords[i].toString());   //  else, word is added
        }


        return words_AL;
    }

    public static String reformText(String oldText, ArrayList<String> words_AL){
        String fileName = "C:\\Users\\berfi\\IdeaProjects\\OOP_Project2\\src\\words.txt";

        ArrayList<String> dict = readFile(fileName);    // calling readFile() method



        String[][] editedTable = new String[words_AL.size()][2];    // keep the old version and new version of the words


        Iterator wordsIterator = words_AL.iterator();          // for traverse words_AL arrayList

        int i = 0;

        while (wordsIterator.hasNext()) {
            String word = (String) wordsIterator.next();
            Iterator dictIterator = dict.iterator();          // for traverse words.txt file

            while (dictIterator.hasNext()) {
                String word_dict = (String) dictIterator.next();
                if (word.equalsIgnoreCase(word_dict)) {        // if word is in the words.txt, adding to table
                    editedTable[i][0] = word;
                    editedTable[i][1] = word_dict;
                } else {
                    //if word is not in the words.txt, calling the singleTransposition() method.
                    String[] combinations = singleTransposition(word);

                    for (int k = 0; k < combinations.length; k++) {    // loop for combinations of words with single tranpositions
                        if(combinations[k].equalsIgnoreCase(word_dict)){    // if any combination of word is in words.txt, adding to table
                            editedTable[i][0] = word;
                            editedTable[i][1] = word_dict;
                        }
                    }
                }
                if((editedTable[i][0] == null) && (editedTable[i][1] == null) ){

                    editedTable[i][0] = word;
                    editedTable[i][1] = word;
                }
            }
            i++;
        }

        String newText = oldText.substring(0);
        for(String[] item : editedTable){       // scrolls over the table and creates fixed text
            int sizeOfWord = item[0].length();
            int startIndex = oldText.indexOf(item[0]);
            String sbstr = oldText.substring(startIndex, (startIndex+sizeOfWord));

            newText = newText.replace(sbstr, item[1].toString());

        }

        return newText;

    }

    public static ArrayList<String> readFile(String fileName){
        ArrayList<String> dict = new ArrayList<>();
        // with try-catch blocks, file is reading and every word is added to arrayList
        try {
            File file1 = new File(fileName);
            Scanner file = new Scanner(file1);

            try {
                while (file.hasNext()){
                    String satir = file.next();

                    dict.add(satir);
                }
                file.close();
            } catch (NoSuchElementException e) {
                System.out.println("No Such Element!" + e.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!" + e.toString());
            System.exit(0);
        }

        return dict;


    }

    public static String[] singleTransposition(String wrongWord){

        String[] combinations = new String[wrongWord.length()-1];

        for (int i = 0; i < wrongWord.length()-1; i++) {   // By exchanging two letters, all possible possibilities are created
            String copyWrongWord = wrongWord.substring(0);    // protected original form of word


            copyWrongWord = wrongWord.substring(0, i) + Character.toString(wrongWord.charAt(i+1)) + Character.toString(wrongWord.charAt(i)) + wrongWord.substring(i+2);

            combinations[i] = copyWrongWord;
        }



        return combinations;
    }

    public static String findReplace(String area, String find, String replace) {
        if(area.contains(find)){       // if the word to find is in the text
            area = (area.replaceAll(find, replace));    // all find words will replace with replace word
        } else {
            JOptionPane.showMessageDialog(null,"Word can not found.");     // error message
        }
        return area;        // returning the new text
    }
}