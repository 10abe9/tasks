import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(p1(1,2,1));
        System.out.println(p2("zip zie zks zippo"));
        System.out.println(p3(12));
        System.out.println(p4("asdsasadss."));
        System.out.println(p5("#eaecee"));
        int[] ar1 = new int[3];
        int[] ar2 = new int[5];
        System.out.println(p6(ar1,ar2));
        System.out.println(p7(297));
        p8(11000001);
        System.out.println(p9(24));
        System.out.println(p10(145,105,100));

    }
    public static int p1(int a, int b, int c)
    {
        int dis = b*b-(4*a*c);
        if (dis < 0 ) {return 0;}
        if (dis == 0){return 1;}
        else return 2;
    }
    public static int p2(String str)
    {
        int p = 0;
        for (int i = 0; i<str.length();i++)
        {
            if (p==2){return i-1;}
            if (str.charAt(i) == "z".charAt(0))
            {
                if (str.charAt(i+1) == "i".charAt(0))
                {
                    if (str.charAt(i+2) == "p".charAt(0)){p+=1;}
                }
            }
        }
        return -1;
    }
    public static boolean p3(int a)
    {
        int f = 0;
        for (int i = 1;i<a;i++)
        {
            if (a%i==0){f+=i;}
        }
    if (a == f){return true;}
    return false;
    }
    public static String p4(String str)
    {
        if(str.length()<2){return "несовместимо";}
        if(str.charAt(0) == str.charAt(str.length()-1)){return "два - эот пара";}
        String res = str.charAt(str.length()-1)+str.substring(1,str.length()-1)+str.charAt(0);
        return res;
    }
    public static boolean p5(String str)
    {
        if (str.charAt(0) == "#".charAt(0))
        {
            if (str.length() == 7)
            {
                for (int i = 1;i<str.length();i++)
                {

                    char x = str.charAt(i);
                    if (Character.isDigit(x));
                    else if (!(x>'f'&& x<'A' && x>'F'));
                    else return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean p6(int[] ar1, int[] ar2)
    {
        ar1 = new int[]{1,3,5,6,6,5};
        ar2 = new int[]{1,2,3,3,3,1,3};
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        int f1 = ar1.length;
        int f2 = ar2.length;
        for (int i = 0;i<ar1.length-1;i++)
        {
            if (ar1[i]==ar1[i+1]){f1-=1;}
        }
        for (int i = 0;i<ar2.length-1;i++)
        {
            if (ar2[i]==ar2[i+1]){f2-=1;}
        }
        System.out.print("task6: ");
        return (f1==f2);

    }

    public static boolean p7(int n)
    {
        System.out.println("__task7__");

        if(n<2){return true;}
        int a = n*n;
        String str = Integer.toString(a);
        if (str.length()<2){return false;}
        if (str.length() % 2 == 0)
        {
            int i = (str.length()/2) - 1;
            String l1 = str.substring(0,i);
            String l2 = str.substring(i,str.length()-1);
            int r1 = Integer.parseInt(l1);
            int r2 = Integer.parseInt(l2);
            return (r1+r2==n);
        }
        else
        {
            int ind = (str.length()-1)/2;
            String l1 = str.substring(0,ind);
            String l2 = str.substring(ind);
            int r1 = Integer.parseInt(l1);
            int r2 = Integer.parseInt(l2);
            return (r1+r2==n);
        }
    }
    public static String p8(int b)
    {
        String str = Integer.toString(b);
        int s = 0;
        int f = 0;
        for (int i = 0; i<str.length();i++ )
        {
            if (str.charAt(i) == "0".charAt(0))
            {
                s+=1;
                if (s>f){f =s;}
                System.out.println(f);
            }
            else {s = 0;}
        }
        System.out.println(f);
        while (f>0){System.out.print("0");f-=1;}
        System.out.println("");
        return Integer.toString(f);
    }

    public static boolean IsP(int a)
    {
        int r = a;
        for (int i=2;i<a;i++)
        {
            if (r%i==0){return false;}
        }
        return true;
    }
    public static int p9(int a)
    {
        while (true)
        {
            if (IsP(a)){return a;}
            else {a = a+1 ;}
        }
    }
    public static boolean p10(int x, int y, int z)
    {
        if (x+y<z){return false;}
        if (x+z<y){return false;}
        if (z+y<x){return false;}
        int [] ar = new int[]{x,y,z};
        Integer c = Arrays.stream(ar).max().getAsInt();
        System.out.println(x);
        if (x==c){return x*x==y*y+z*z ;}
        if (y==c){return y*y==x*x+z*z ;}
        if (z==c){return z*z==x*x+y*y ;}
        else return false;
    }




}