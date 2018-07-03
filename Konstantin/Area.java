public class Area {
    public static void main(String[] args) {
    Triangle abc = new Triangle(0,0,0);
    abc.inputSize();
    System.out.println(abc.getSizeA()+" "+abc.getSizeB()+" "+abc.getSizeC());
    abc.areaFind();
    abc.getSquare();
    abc.getSquare(5);
    test();

    }
    static void test(){
        Triangle test = new Triangle(2,2,2);
        if (test.areaFind() == 1.7320508075688772) System.out.println("Тест 1 пройден ");
        test.chekAndSend(7,9,5);
        if(test.areaFind() == 17.41228014936585) System.out.println("Тест 2 пройден");
        test.chekAndSend(-3,0,6);
        if (test.areaFind() == 0)System.out.println("Тест 3 пройден");
    }

}
