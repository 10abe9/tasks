import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        p1(10,7,"hello my name is Bessie and this is my essay");
        p2("()()()");
        toCamelCase("asdasd_asda");
        toSnakeCase("helloEdabit");

        System.out.println(p4(9, 17, 30, 1.5));
        System.out.println(p5(90,1.80));
        System.out.println(p6(999));
        System.out.println(p7("abbccc"));
        System.out.println(p8("Sam I am!", "Green eggs and ham."));
        System.out.println(p9(451999277, 411779928));
        System.out.println(p10("AZYWABBCATTTA", 'A'));

    }
    public static void p1(int n, int k, String str)
    {//n words(1-15), k symbols in string.
        String[] arr = new String[n+1];
        String str2;
        int j=0;
        int f=0;
        for (int i =0;i<str.length();i++)
        {
            if (str.charAt(i)==' '){arr[j]=str.substring(f,i);j+=1;f=i+1;}
        }
        System.out.println(f);
        int d=0;
        while (d<n)
        {
            if (d==n-1){break;}
            if (arr[d].length()+arr[d+1].length()>k){System.out.println(arr[d]);d++;}
            else {System.out.println(arr[d]+' '+arr[d+1]);d=d+2;}
        }
        System.out.println(str.substring(f,str.length()));
    }

    public static void p2(String str)
    {// ()()()
        int l = 0;
        int r = 0;
        int s = 0;
        for (int i = 0; i<str.length();i++)
        {
            if (l == r && l!=0){System.out.print(str.substring(s,i)+',');s=i;}
            if (str.charAt(i)=='('){l+=1;}
            if (str.charAt(i)==')'){r+=1;}
            if (str.length()==i+1){System.out.println(str.substring(s,i+1));}
        }
    }

    static public void toCamelCase(String str)
    {//lower
        int j = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i<str.length();i++)
        {
            if (str.charAt(i)=='_')
            {
                arr[i]=' ';
                arr[i+1]=Character.toUpperCase(arr[i+1]);
            }
        }
        String d = new String(arr);
        d = d.replace(" ","");
        System.out.println(d);
    }
    static public void toSnakeCase (String str)
    {//_
        int j = 0;
        String sub;
        char[] arr = str.toCharArray();
        for (int i = 0; i<str.length();i++)
        {
            if (Character.isUpperCase(arr[i]))
            {
                arr[i]=Character.toLowerCase(arr[i]);
                j = i;
            }
        }
        String d = new String(arr);
        System.out.println(d.substring(0,j)+'_'+d.substring(j,str.length()-1));
    }
    static public String p4(double a,double b,double c,double d)
    {//a-beg,b-end,c-st ,d-mul.
        if (b<17){return "$" + (b-a)*c ; }
        else {return "$" + (17-a)*c+(b-17)*c*d; }
    }
    static public String p5(double w, double h)
    {
        double ind = w/(h*h);
        if (ind<18.5 ){return ind + " Малый вес";}
        if (ind<24 ){return ind + " нормальный вес"; }
        return ind + " ожирение ";
    }

        public static int p6_1(int a)
        {
            int f = 1;
            String str = Integer.toString(a);
            for (int i=0;i<str.length();i++)
            {
                f=f*(Character.getNumericValue(str.charAt(i)));
            }
            return f;
        }
    public static int p6(int a)
    {
        int k = 0;
        if (a<10){return 0;}
        while (a>10)
        {
            a = p6_1(a);
            k++;
        }
        return k;
    }

    public static String p7(String str)
    {
        int x=0;
        int f=0;
        int c =0;
        char[] arr = str.toCharArray();
        char[] res = new char[10];
        char b = str.charAt(0);
        for (int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==b)
            {
                str=str.substring(1);
                f++;
            }
            else
            {
                res[c]=Integer.toString(f).charAt(0);res[c+1]='*';res[c+2]=b;
                f=0;b=str.charAt(i);c=c+3;
            }
        }

        return res.toString();
    }

    public static boolean isVowel(char c)
    {
        if (c=='a'|c=='e'|c=='y'|c=='u'|c=='i'|c=='o'){return true;}
        return false;
    }
    public static boolean p8(String s1, String s2)
    {
        String lw1=" ";
        String lw2 ="";
        int n=0;
        int k=0;
        char[] ar1=new char[4];
        char[] ar2=new char[4];
        for (int i=s1.length()-1;i>-1;i--)
        {
            if (s1.charAt(i)==' '){lw1=s1.substring(i);break;}
        }
        for (int i=s2.length()-1;i>-1;i--)
        {
            if (s2.charAt(i)==' '){lw2=s2.substring(i);break;}
        }

        for (int i=0;i<lw1.length();i++)
        {
            if (isVowel(lw1.charAt(i))){ar1[n]=lw1.charAt(i);n++;}
        }
        for (int i=0;i<lw2.length();i++)
        {
            if (isVowel(lw2.charAt(i))){ar2[k]=lw2.charAt(i);k++;}
        }


        return ar1[0]==ar2[0]&&ar1[1]==ar2[1]&&ar1[2]==ar2[2];
    }

    public static boolean p9 (int a, int b)
    {
        char k='s';
        String str1 = Integer.toString(a);
        String str2 = Integer.toString(b);
        for (int i=0; i<str1.length()-2;i++)
        {
            if (str1.charAt(i)==str1.charAt(i+1)&&str1.charAt(i+1)==str1.charAt(i+2)){k=str1.charAt(i+1);break;}
        }
        for (int i=0;i<str2.length()-1;i++)
        {
            if (str2.charAt(i)==k){if (str2.charAt(i+1)==k){return true;}}
        }
    return false;
    }

    public static int uniqueChars(String str)
    {//asdaassd
        int res=0;
        char[]arr = str.toCharArray();
        for (int i=0;i<str.length()-1;i++)
        {
            for (int j=i+1;j<arr.length;j++)
            {
                if (str.charAt(i)==str.charAt(j)){arr[i]=0;}
            }
        }
        for (int i=0;i<arr.length;i++){if (arr[i]!=0){res++;}}
        return res;
    }

    public static int p10(String str, char ch)
    {
        String[]arr = new String[10];
        int c=0;
        int x=0;
        int k =0;
        int res =0;
        for (int i=0;i<str.length();i++)
        {
            if (str.charAt(i)==ch && x%2==0){c=i;x++;}
            if (str.charAt(i)==ch && x%2!=0){arr[k]=str.substring(c,i+1);k++;x++;}
        }
        for (int i=0; i<arr.length;i++)
        {
            if (arr[i]!=null)
            {
            res = res + uniqueChars(arr[i]);
            }
        }
    return res;
    }
}

