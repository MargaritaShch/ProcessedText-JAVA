import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        String inputFilePath = "Text.txt";
        String outputFilePath = "Text2.txt";

        String vouwelsLetters = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        String consonantLetters = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";

        int vouwelsLettersCount = 0;
        int consonantLettersCount = 0;

        try (Stream<String> lines = Files.lines(Paths.get(inputFilePath));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {
            for (String line : (Iterable<String>) lines::iterator) {
                vouwelsLettersCount += line.replaceAll("[^" + vouwelsLetters + "]", "").length();
                consonantLettersCount += line.replaceAll("[^" + consonantLetters + "]", "").length();
                
                String modifiedLine = line
                .replaceAll("[" + vouwelsLetters + "]", "a")
                .replaceAll("[" + consonantLetters + "]", "м");

                writer.write(modifiedLine);
                writer.newLine();
            }

            System.out.println("Количество гласных: " + vouwelsLettersCount);
            System.out.println("Количество согласных: " + consonantLettersCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
