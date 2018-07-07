package CodeCrafts;

public class lesson2 {
    private static final int hundredPercent = 100;      // Сто процентов
    private static final int kopeckInRuble = 100;       // Копеек в рублях

    public static void main(String[] args) {

        double income;                      // Доход
        int time = 100;                      // Срок вложения в днях
        int startAmountRub = 12345;         // Начальная сумма - рубли
        int startAmountKop = 99;            // Начальная сумма - копейки
        int startAmount;                    // Начальная сумма в рублях
        double percent = 7.5;               // Годовой процент депозита
        int dayInYear = 365;                // Дней в году

        startAmount = startAmountRub * kopeckInRuble + startAmountKop;      // Начальная сумма в копейках
        income = (startAmount * percent * time / (dayInYear * hundredPercent));
        income = income / kopeckInRuble;                                    // Начальная сумма в рублях

        System.out.println("Доход за " + time + " дней под " + percent + "% годовых");
        System.out.println("с размером начального вклада: " + startAmountRub + "." + startAmountKop + " руб");
        System.out.println("составил: " + income + " руб");

    }
}
