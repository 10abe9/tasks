import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("____1st task____");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        task1(in.nextInt(),in.nextInt());
        System.out.println("____2 task____");
        task2(in.nextInt(),in.nextInt());
        System.out.println("____3 task____");
        task3(in.nextInt(),in.nextInt(),in.nextInt());
        System.out.println("____4 task____");
        task4(in.nextInt(),in.nextInt(),in.nextInt());
        System.out.println("____5 task____");
        task5(in.nextInt(),in.nextInt(),in.nextInt());
        System.out.println("____6__ task____");
        task6(in.next());
        System.out.println("____7 task____");
        task7(in.nextInt(),in.nextInt());
        System.out.println("____8 task____");
        task8(in.nextInt(),in.nextInt());
        System.out.println("____9 task____");
        task9(in.nextInt(),in.nextInt(),in.nextInt());
        System.out.println("____10 task____");
        task10(in.nextInt(),in.nextInt(),in.nextInt());
        in.close();
    }
    public static int task1(int hi, int osn)
    {
        System.out.println("____2nd task____");
        System.out.println((hi*osn)/2);
        return((hi*osn)/2);
    }
    public static float task2(int hi,int osn)
    {
        System.out.println("____2nd task____");
        System.out.println((hi*osn)/2);
        return((hi*osn)/2);
    }
    public static int task3(int chiken, int cows, int pigs)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("____3rd task____");
        System.out.println(chiken*2+cows*4+pigs*4);
        return(chiken*2+cows*4+pigs*4);
    }
    public static boolean task4(int prob, int price, int pay ) {
        boolean x = ((prob * price) > pay);
        if (x) {
            System.out.println("True");
        } else System.out.println("False");
        return (x);
    }

    public static String task5(int a1, int a2, int n)
    {
        if (a1+a2==n)
            return "+";
        else if (a1-a2==n)
            return "-";
        else if (a1*a2==n)
            return "*";
        else if (a1/a2==n)
            return "/";
        else
            return "None";
    }
    public static int task6(String c1)
    {
        char c = c1.charAt(0);
        System.out.println((int) c);
        return ((int) c);
    }

    public static int task7(int o, int x )
    {
        while (o>0)
        {
            x = x+0;
            o = o-1;
        }
        return (x);
    }
    public static int task8(int d1, int d2)
    {
        int ot = d1+d2-1;
        return (ot);
    }
    public static int task9(int v1, int v2, int v3)
    {
        return (v1*v1*v1+v2*v2*v2+v3*v3*v3);
    }
    public static boolean task10(int f1, int f2, int f3)
    {
        if ((f1*f2)%f3 == 0){
            return (1==1);
        }
        else
            {return (1==0);}
    }
}