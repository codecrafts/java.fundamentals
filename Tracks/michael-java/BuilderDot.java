package lesson_7;
    import java.util.Scanner;

class BuilderDot {

    static Point createDot(){
       Scanner take = new Scanner (System.in);

       System.out.println("Введите 1ю коодинату точки:");
       int x = take.nextInt ();
       System.out.println("Введите 2ю коодинату точки:");
       int y = take.nextInt ();

       return new Point( x, y );
   }
}
