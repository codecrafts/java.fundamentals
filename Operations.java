package ru.codecrafts;

public class Operations
{
    public static void main(String[] args)
    {
        double operand1 = 20.0;
        double operand2 = 10.0;
        // Сравнительные и логические операции
        boolean isEqual = (operand1 == operand2); // Бинарный опреатор сравнения. Результат тип boolean
        boolean isNotEqual = (operand1 != operand2); // Бинарный опреатор неравенства. Результат тип boolean
        boolean isGreater = (operand1 > operand2); // Бинарный опреатор больше. Результат тип boolean
        boolean  isLesser = (operand1 < operand2); // Бинарный опреатор <. Результат тип boolean
        boolean isGreaterOrEqual = isEqual || isGreater; // Бинарный опреатор логическое или. Результат тип boolean
        isGreaterOrEqual = operand1 >= operand2; // Бинарный опреатор >=. Результат тип boolean
        boolean isLesserOrEqual = isEqual || isLesser; // Бинарный опреатор логиеское или. Результат тип boolean
        isLesserOrEqual = operand1 <= operand2; // Бинарный опреатор <=. Результат тип boolean
        isEqual = isGreaterOrEqual && isLesserOrEqual; // Бинарный опреатор логичкое И. Результат тип boolean

        boolean trueFlag = true;
        boolean falseFlag = !trueFlag; // Унарный оператор отрицания. True -> False. False -> True

        // Битовые операции
        int bitwiseOperand1 = 1;
        int bitwiseOperand2 = 2;
        int res1 = ~bitwiseOperand1; // Унарная операция битового отрицания
        int res2 = bitwiseOperand1 & bitwiseOperand2; // Бинарная операция битовое 'И'
        int res3 = bitwiseOperand1 | bitwiseOperand2; // Бинарная операция битовое 'ИЛИ'
        int res4 = bitwiseOperand1 ^ bitwiseOperand2; // Бинарная операция битовое 'XOR
        int res5 = bitwiseOperand1 >> 1; // Бинарная операция битового сдвига вправо
        int res6 = bitwiseOperand1 << 1; // Бинарная операция битового сдвига влево
        int res7 = bitwiseOperand1 >>> 1; // Бинарная операция битового сдвига вправо с дополнением нулями.

        // Арифметические операции
        double dres1 = operand1 + operand2;
        double dres2 = operand1 - operand2;
        double dres3 = operand1 * operand2;
        double dres4 = operand1 / operand2;
        double dres5 = operand1 % operand2;

        // Сокращенная запись операций
        int number = 123;
        number = number + 1;
        number += 1;
        number++; // инкремент

        number = number - 1;
        number -= 1;
        number--; // декремент

        byte num1 = 100;
        byte num2 = 50;
        byte num3 = (byte)(100 + 50);
    }
}
