public class Lesson1 {
    public static void main(String[] args){

        //Определяем переменные.
        float E, g = 9.8f, m = 10.3f, h = 12.6f, V = 33.2f;

        // Рассчитываем значение энергии по формуле.
        E = m*g*h + m*V*V/2;

        //Выводим результат в консоль.
        System.out.print("Результат = " + E);


    }

}
