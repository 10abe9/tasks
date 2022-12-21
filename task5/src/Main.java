import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[]ar=new String[]{"ладья", "A8", "H8"};//p2
        int[]arr=new int[]{16,28};//p4
        String[]ar1=new String[]{"toe", "ocelot", "maniac"};//p5
        System.out.println(p1("Hi there!"));
        System.out.println(p2(ar));
        System.out.println(p3("butl", "beautiful"));
        System.out.println(p4(arr));
        System.out.println(p5(ar1));
        System.out.println(p6("12345678901231231"));
        System.out.println(p7(33));
        System.out.println(p8("1231231"));
        System.out.println(p9("kjh hk kjh kjj of"));
        System.out.println(p10(19));

    }
    public static String p1(String str)
    {
        char[] a = str.toCharArray();
        int[] arr = new int[str.length()];
        arr[0] = Character.getNumericValue(str.charAt(0));
        for (int i=1;i<str.length();i++)
        {
            arr[i] = a[i]-a[i-1];
        }
        return Arrays.toString(arr);
    }

    public static boolean p2(String[]a)
            //- "пешка", "конь", "слон", "Ладья", "Ферзь" и " король".
    {
        char[]firstPoint=a[1].toCharArray();
        char[]secondPoint=a[2].toCharArray();
        if (a[0].toLowerCase()=="пешка")
        {
            if((firstPoint[1]==secondPoint[1]-1) && (firstPoint[0]==secondPoint[0])){return true;}

        }
        if (a[0].toLowerCase()=="конь")
        {
            if(((firstPoint[0]==secondPoint[0]+2)&&(firstPoint[1]==secondPoint[1]+1))|firstPoint[0]==secondPoint[0]+1&&firstPoint[1]==secondPoint[1]+2){return true;}
        }
        if (a[0].toLowerCase()=="слон")
        {
            if (firstPoint[0]-secondPoint[0]==firstPoint[1]-secondPoint[1]){return true;}
        }
        if (a[0].toLowerCase()=="ладья")
        {
            if (firstPoint[0]==secondPoint[0]|firstPoint[1]==secondPoint[1]){return true;}
        }
        if (a[0].toLowerCase()=="ферзь")
        {
            if (firstPoint[0]-secondPoint[0]==firstPoint[1]-secondPoint[1]){return true;}
            if (firstPoint[0]-secondPoint[0]==0|firstPoint[1]-secondPoint[1]==0){return true;}
        }
        if (a[0].toLowerCase()=="король")
        {
            if (firstPoint[0]-secondPoint[0]<=1&&firstPoint[0]-secondPoint[1]<=1){return true;}
            if (firstPoint[0]-secondPoint[0]<=-1&&firstPoint[0]-secondPoint[1]<=-1){return true;}
        }
        return false;
    }

    public static boolean p3(String s0, String s1)
    {
        int cou=0;
        while (s1.length()>0)
        {
            if (s0.charAt(0)==s1.charAt(0))
            {
                s0=s0.substring(1);
                s1=s1.substring(1);
            }
            else {s1=s1.substring(1);}
            if (s0.length()==0){return true;}
        }
        return false;
    }

    public static Integer p4(int[] arr)
    {
        int x=9;
        int sum = Arrays.stream(arr).sum();
        if (sum<10){return sum;}
        while (sum>10)
        {
            x = sum/10;
            sum = sum%10*x;
        }
        return sum;
    }

    public static boolean isVowel(char c){if (c=='a'|c=='e'|c=='i'|c=='o'|c=='u'|c=='y'){return true;}else return false;}

    public static String[] p5(String[] str)
    {//a e i o u y
        int j = 0;
        int cou=0;
        String[] res= new String[]{};
        char[] c = new char[10];
        for (int i = 0; i < str[0].length(); i++)
        {
            if (isVowel(str[0].charAt(i))) {
                c[j] = str[0].charAt(i);
                j++;
            }
        }
        String s = c.toString();
        for (int i=0;i<str.length;i++)
            for (int f=0;f<str[i].length();f++)
                for (int k=0;k<s.length();k++)
                {
                    if (s.charAt(k)==str[i].charAt(f)){s=s.substring(1);}
                    if (s.length()==0){res[cou]=str[i];}
                }
        return res;
    }

    public static int CharArrayToInt(char[] arr)
    {
        int res=0;
        int l=1;
        for(int i=arr.length-1;i>-1;i--)
        {
            res = res+Character.getNumericValue(arr[i])*l;
            l=l*10;
        }
        System.out.println(res);
    return res;
    }

    public static boolean p6(String str)
    {
        int sum=0;
        int n=0;
        if(str.length()<14){return false;}
        if(str.length()>19){return false;}
        int h = str.charAt(str.length()-1);
        str=str.substring(0,str.length()-1);
        for (int i=0;i<str.length();i++)
        {
            if (i%2==0){sum+=str.charAt(i);}
            else
            {
                if (str.charAt(i)*2<10){sum+=str.charAt(i)*2;}
                else
                {
                    n=str.charAt(i)*2;
                    n=n/10+n%10;
                    sum+=n;
                }
            }
        }
        return sum%10==h;
    }

    public static String p7(int x)
    {
        String[] ar1=new String[]{"","один","два","три","четыре","пять","шесть","семь","восемь","девять","десять","одиннадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать"};
        String[] ar2=new String[]{"","","двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят","девяносто"};
        String[] ar3=new String[]{"","сто","двести","триста","четыресто","пятьсот","шестьсот","семьсот","восемьсот","девятьсот"};
        if (x>10&&x<20){return ar1[x];}
        int l1=x%10;
        int x1=x/10;
        int l2=x1%10;
        int l3=x/100;
        return ar3[l3]+' '+ar2[l2]+' '+ar1[l1];
    }
    public static String p8(String str) throws NoSuchAlgorithmException
    {

        MessageDigest digest =MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(str.getBytes());
        return  hash.toString();
    }
    public static String p9(String str)
    {
        str=str.toLowerCase();
        String[] arr=str.split(" ");
        int a= arr.length;
        System.out.println(arr[1]);
        for (int i=0;i<a;i++)
        {//and, the, of и in
            if (arr[i].equals("and")|arr[i].equals("the")|arr[i].equals("of")|arr[i].equals("in")){}
            else {arr[i]=arr[i].substring(0,1).toUpperCase()+arr[i].substring(1);}
        }
        String x=" ";
        for (int i=0;i<a;i++)
        {
            x=x+arr[i]+" ";
        }

        return x;
    }

    public static String strgen(int a)
    {//a-кол. кругов.
        String c = "@";
        String str="";
        for (int i=0;i<a;i++){str=str+c;}
        return str;
    }
    public static String p10(int a)
    {
        int c=0;
        int k=1;
        int l=0;
        if (a==1){System.out.println("o");return "";}
        while (a>5)
        {
            a=a-6;
            k+=1;
            if (a==1){c+=1;}
        }
        if (c==1)
        {
            String str=strgen(k);
            for (int i=0;i<k;i++)
            {
                System.out.println(str);
                str=str+"@";
            }
            str=str.substring(1);
            for (int i=0;i<k-1;i++)
            {
                System.out.println(str.substring(1));
            }

        }
        else return "недопустимо";
        return "";
    }

}
