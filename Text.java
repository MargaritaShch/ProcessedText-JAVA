import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Text {
    public static void main(String[] args){
        String inputFile = "TextFile/Text.txt";
        String outputFile = "TextFile/ProcessedText.txt";
        createNewTextFile(inputFile, outputFile);
    }

    private static void createNewTextFile(String inputFile, String outputFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String consonantsLetters = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
            String vowelLetters = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
            
            int consonantsLettersCount = 0;
            int vowelLettersCount = 0;

            int ch;
            while((ch = reader.read()) != -1){
                char character = (char) ch;
                if(vowelLetters.indexOf(character) != -1){
                    writer.write('а');
                    vowelLettersCount++;
                } else if(consonantsLetters.indexOf(character) != -1){
                    writer.write('м');
                    consonantsLettersCount++;
                } else{
                    writer.write(character);
                }
            }
            System.out.println("Vowel Letters: " + vowelLettersCount);
            System.out.println("Consonants Letters: " + consonantsLettersCount);

        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}