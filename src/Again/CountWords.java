package Again;

public class CountWords {
    public static void main(String[] args) {
        String sentence = " A quick brown fox leaps over a lazy dog";
        String[] words= sentence.trim().split(" ");
        System.out.println("No.of.words in the sentence :" +words.length);
    }
}
