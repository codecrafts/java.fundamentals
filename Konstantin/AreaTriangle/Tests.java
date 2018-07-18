public class Tests {
    static void checkLogic() {
        if (Area.findeArea(1,2,3) == 0) System.out.println("(123)тест пройден");
        if (Area.findeArea(2,2,2) == 1.7320508075688772) System.out.println("(222)тест пройден");
        if (Area.findeArea(0,0,0) == 0) System.out.println("(000)тест пройден");
    }

}
