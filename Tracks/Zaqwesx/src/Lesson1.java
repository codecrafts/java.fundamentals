public class Lesson1 {
    public static void main(String[] args){

        //Определяем переменные.
        double energy;
        double gravity = 9.8; // Явное объявление ускорения свободного падения.
        double mass = 10.3; //Явное объявление массы тела.
        double heigth = 12.6; // Явное объявление высоты тела над поверхностью Земли.
        double velocity = 33.2; // Явное объявление скорости тела.

        // Рассчитываем значение энергии по формуле.
        energy = mass * gravity * heigth + mass * velocity * velocity / 2;

        //Выводим результат в консоль.
        System.out.println();
        System.out.println("При заданных параметрах рассчета:");
        System.out.println("Масса тела = " + mass + " кг.");
        System.out.println("Высота тела над поверхностью Земли = " + heigth + " м.");
        System.out.println("Ускорение свободного падения в атмосфере Земли = " + gravity + " м/с^2.");
        System.out.println("Скорость движения тела = " + velocity + " м/с.");
        System.out.println();
        System.out.print("Полная энергия тела = ");
        System.out.printf("%.2f", energy);
        System.out.println(" Дж.");


    }

}
