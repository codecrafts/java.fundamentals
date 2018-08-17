package lesson_4;

public class Lesson4 {
    public static void main(String[] args)
    {
        // реализаци€ с for each
        long[] june = {0, 0, 1232300, 54000, 76500, 4534500, 0, 0, 32432400, 0, 4433200, 1200, 321000, 54300, 65400, 86700, 0, 0, 0, 5430400, 0, 567000, 0, 10000, 0, 0, 65656500, 0, 121000, 0};
        System.out.println("ƒни, когда не было выдано кредитов:");
        int dayNumber = 1;
        for (long days: june) {
            if (days == 0)
                System.out.print(dayNumber + ", ");
            dayNumber++;
        }
        System.out.println();

        // реализаци€ c for
        long[] april = {0, 000, 1232300, 54000, 76500, 4534500, 0, 0, 32432400, 0, 4433200, 1200, 321000, 54300, 65400, 86700, 0, 0, 0, 5430400, 0, 567000, 0, 10000, 0, 0, 65656500, 0, 121000, 0};
        System.out.println("ƒни, когда не было выдано кредитов:");
        for (int day = 0; day < april.length;  day++) {
            if (april[day] == 0)
                System.out.print(day + 1 + ", ");
        }
    }
}