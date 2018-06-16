public class iteratio {
   /* Константин
    В целях повышения эффективности работы команды для менеджера надо написать программу,
    которая выводит номера недельных итераций, когда было выполнено задач выше среднего.
    Входные данные:
    Массив чисел (количество закрытых задач). Идут по порядку по итерациям.
    Выходные данные.
    Номера итераций, когда была производительность в задачах была выше среднего значения.*/
    public static void main(String[] args) {

    int averageValue = 0;
    int[] completedTasks = {5, 8, 10, 15, 13, 12, 8, 9, 7, 10, 15, 20, 18, 16, 13, 10};

    for (int i = 0; i<completedTasks.length; i++) {
          averageValue = averageValue + completedTasks [i];
        }

    averageValue = averageValue / completedTasks.length;
    System.out.println("Среднее значение выполненных задач - " + averageValue);
    System.out.println("Номера итераций с количеством задач выше среднего");

    for (int i = 0; i<completedTasks.length; i++) {
        if (averageValue < completedTasks[i]) {
            System.out.print(" " + (i+1));
        }
    }
}




}
