package Again2;


public class DuplicateChar {
    public static void main(String[] args) {
        String str1 = "There are many duplicate characters in this sentence";
        String str2 = str1.replaceAll("\\s", "");
        int count = 0;
        char[] characters = str2.toCharArray();
        for (int i = 0; i < str2.length(); i++) {
            for (int j = i + 1; j < str2.length(); j++) {
                if (characters[i] == characters[j]) {
                    System.out.println(characters[j]);
                    count++;
                    break;
                }

            }


        }
        System.out.println(count);
        System.out.println(characters.length);
        System.out.println(str1.length());
        System.out.println(str2.length());
    }
}
