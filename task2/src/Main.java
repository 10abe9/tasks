import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("__task1__ . введите строку и число ..  ");
        System.out.println(p1(scan.nextLine(), scan.nextInt()));
        System.out.println("__task2__");
        int[] mas;
        mas = new int[5];
        mas = new int[] {1,2,3,4,2};
        System.out.println(p2(mas));
        System.out.println("__task3__");
        System.out.println(p3(mas));
        System.out.println("__task4__");
        p4(mas);
        p5("11.2311");
        p6(14);
        p7("12311");
        p8("qwqqqw","wq");
        System.out.println(IsPrefix("wwwsasd", "asd"));
        System.out.println(IsSuffix("wqeqdf","wqe"));
        System.out.println(p10(3));
        scan.close();
    }

    public static String p1(String str, int num) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {

            for (int i = 0; i < num; i++) {
                s.append(str.charAt(j));
            }
        }
        return s.toString();
    }

    public static int p2(int[] mas) {
        return Math.abs(Arrays.stream(mas).min().getAsInt()-Arrays.stream(mas).max().getAsInt());
    }

    public static boolean p3(int[] mas) {
        mas = new int[]{1,2,3,2,1};
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum = sum + mas[i];

        }
        if ((sum) % mas.length == 0) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    public static int[] p4(int[] mas) {
        mas = new int[]{4,1,2,6,1};
        int[] mas2;
        mas2 = new int[5];
        mas2[0] = mas[0];
        for (int i = 0; i<mas.length;i++)
        mas2[i] = mas2[i-1]+mas[i];
        for (int n = 0; n < mas2.length; n++) {
            System.out.println(Array.get(mas2, n));

        }
        System.out.println("__task5__");
        return mas2;
    }

    public static int p5(String str) {
        int res;
        char ch = '.';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                res=str.length()-(i+1);
                return res;

            }
        }
    return 0;
    }
    public static int p6(int n)
    {
        System.out.println("__task6__");
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    System.out.println(arr[n-1]);
    return arr[n-1];
    }
    public static boolean p7(String ind)
    {
        System.out.println("__task7__");
        if (ind.length()>5){System.out.println("false");return false;}
        for (int i = 0; i<ind.length();i++)
        {
            if (Character.isDigit(ind.charAt(i))){}
            else{System.out.println("False");return false;}
        }
    System.out.println("True");
    return true;
    }
    public static boolean p8(String s1, String s2)
    {
        System.out.println("__task8__");
        if (s1.charAt(0)==s2.charAt(s2.length()-1))
        {
            if (s2.charAt(0)==s1.charAt(s1.length()-1)){System.out.println("true");return true;}
        }
    System.out.println("false");
    return false;
    }
    public static boolean IsPrefix(String str, String pref)
    {
        System.out.println("__task9__");
        int j = 0;
        for (int i=str.length()-1;i>=0;i--,j++)
        {
            if (j < pref.length()){
                if (str.charAt(i)==pref.charAt(pref.length()-1-j)){}
                else return false;
            }
        }
    return true;
    }
    public static boolean IsSuffix(String str, String suf)
    {
        for (int i = 0; i<suf.length();i++ )
        {
            if (str.charAt(i)==suf.charAt(i)){}
            else return false;
        }

    return true;
    }

    public static int p10(int n)
    {
        System.out.println("__task10__");
        int res = 0;
        if (n ==0) {return 0;}
        if (n%2==0){res = n;}
        else res = ((n+1)/2*3) - ((n-1)/2);

    return res;
    }
}



