import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] numbers = readFile(fileName);
        int count = 0;
        for(int i=1; i<numbers.length; i++){
            if(numbers[i]>numbers[i-1]){
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] numberAddition = readFile(fileName);
        int count = 0;
        for(int i=1; i<fileName.length()-1; i++){
            if(numberAddition[i-1]+numberAddition[i]+numberAddition[i+1] > numberAddition[i]+numberAddition[i-1]+numberAddition[i-2]){
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] numberAddition = readFileTwo(fileName);
        int horizontal = 0;
        int depth = 0;
        for (int i = 0; i < numberAddition.length; i++) {
            int value = Integer.parseInt(numberAddition[i].substring(numberAddition[i].indexOf(' ') + 1));
            if (numberAddition[i].contains("forward")) {
                horizontal += value;
            }
            else if (numberAddition[i].contains("down")) {
                depth += value;
            }
            else if (numberAddition[i].contains("up")) {
                depth -= value;
            }
        }
        return horizontal*depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] withAim = readFileTwo(filename);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (int i=0; i<withAim.length; i++){
            int value = Integer.parseInt(withAim[i].split(" ")[1]);

            if (withAim[i].contains("forward")) {
                horizontal+=value;
                depth+=aim*value;
            }
            else if (withAim[i].contains("down")) {
                aim+=value;
            }
            else if (withAim[i].contains("up")) {
                aim-=value;
            }
        }
        return horizontal*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }
    private static String[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] info = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            info[index++] = scanner.nextLine();
        }
        scanner.close();
        return info;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}
