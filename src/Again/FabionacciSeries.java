package Again;

public class FabionacciSeries {
    public static void main(String[] args) {
        int number1= 0;
        int number2= 1;
        int count = 10;
        System.out.println(" The fabionacci series is following : ");
        for (int i=0; i<count; i++){
            int number3 = number1 + number2;
            number1 = number2;
            number2 = number3;

            System.out.println(+number1);
        }

    }

}
