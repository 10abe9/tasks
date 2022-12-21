import com.sun.jdi.IntegerValue;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(p1(5));
        System.out.println(p2("have"));
        System.out.println(p3("(0,0,0)"));
        System.out.println(p4("https://aasd?a=1,b=3,f=3"));
        System.out.println(p5("Hello my name cocoant boy"));
        System.out.println(p6(9));
        System.out.println(p7("asdssaass"));
        System.out.println(p8(11));
        System.out.println(p9("21+22+42+12=122"));
        System.out.println(p10(122221));

    }
    public static int p1(int n)
    {
        /*1
          1  2
          2  3  5
          5  7  10 15
          15 20 27 37 52
         */
        int[][] s = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j > i)
                    s[i][j] = 0;
                else if (i == j)
                    s[i][j] = 1;
                else if (i == 0 || j == 0)
                    s[i][j] = 0;
                else {
                    s[i][j]
                            = j * s[i - 1][j] + s[i - 1][j - 1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans += s[n][i];
        }
        return ans;
    }
    public static Boolean IsEven(char c){if (c=='a'|c=='e'|c=='y'|c=='u'|c=='o') {return true;}
    else return false;
    }
    public static String p2(String str)
    {
        if (IsEven(str.charAt(0))){str=str+"yay";return str;}
        else str=str.substring(1)+str.charAt(0)+"ay";
    return str;
    }

    public static boolean p3(String str)
    {
        ArrayList<String> arr=new ArrayList<>();
        int n=0;
        int beg=0;int end=0;
        for (int i=0;i<str.length();i++)
        {
            if (str.charAt(i)=='(') {beg=i+1;}
            if (str.charAt(i)==')') {end=i;}
        }
        str=str.substring(beg,end);
        for (int i=0;i<str.length();i++)
        {
            if (str.charAt(i)==','){arr.add(str.substring(n,i));n=i+1;}
        }
        for (String num:arr)
        {
            try {
                int c=Integer.parseInt(num);
                if (c>255||c<0){return false;}
            }catch (NumberFormatException numberFormatException){return false;}
        }


        return true;
    }
    public static String p4(String str)
    {
        String res=str.substring(0,str.indexOf('=')-2);
        ArrayList<String>arr=new ArrayList<>();
        int x=str.indexOf('=');

        while (str.indexOf('=')!=-1)
        {
            arr.add(str.substring(x-1,x+2));
            str=str.substring(x+1,str.length());
            x=str.indexOf('=');

        }
        for (int i=0;i<arr.size();i++)
        {
            for (int j=0;j<arr.size();j++)
            {
                if (i!=j) {
                    if (arr.get(i).equals(arr.get(j))) {
                        arr.remove(j);
                    }

                    if (arr.get(i).charAt(0) == arr.get(j).charAt(0)) {
                        arr.remove(i);
                    }
                }
            }
        }
        for (String s:arr){res+=s;}
        return res;
    }
    public static String p5(String str)
    {
        int n=0;
        ArrayList<String> arr = new ArrayList<>();
        while (str.indexOf(' ')!=-1)
        {
            arr.add(str.substring(0,str.indexOf(' ')));
            str=str.substring(str.indexOf(' ')+1,str.length());
        }
        String s1="",s2="",s3="";
        int[] sym=new int[arr.size()];
        for (int i=0;i<arr.size();i++)
        {
            sym[i]=arr.get(i).length();
        }
        int[] clone = sym;
        Arrays.sort(clone);
        for (Integer c:clone){System.out.println(c);}
        int i1=clone[clone.length-1],i2=clone[clone.length-2],i3=clone[clone.length-3];
        for (int f=0;f<sym.length;f++)
        {
            if (sym[f]==i1){s1=arr.get(f);}
            if (sym[f]==i2){s2=arr.get(f);}
            if (sym[f]==i3){s3=arr.get(f);}
        }
        return s1+","+s2+","+s3;
    }

    public static ArrayList<Integer> p6(int u) {

        ArrayList<Integer> arr=new ArrayList<>();
        int MAX=1000;
        arr.add(1);
        arr.add(2);
        for (int i = 3; i < MAX; i++) {
            int count = 0;
            for (int j = 0; j < arr.size() - 1; j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(j) + arr.get(k) == i) {
                        count++;
                    }
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr.add(i);
            }
        }
        return arr;
    }
    public static String p7(String str) {
        if(str==null||str.length()==0){
            return null;
        }
        Set<String> set = new HashSet<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                set.add(s);
            }
        }
        int max = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            LinkedHashSet<String> setchar = new LinkedHashSet<>();
            String  st = iterator.next().toString();
            for (int a = 0; a < st.length(); a++) {
                setchar.add(String.valueOf(st.charAt(a)));
            }
            if(setchar.size()==st.length()){
                int len = st.length();
                if(max<len){
                    max = Math.max(max, len);
                    result = st;
                }
            }
        }
        return result;
    }

    public static String p8(int a)
    {
        String res="";
        String[] l={"","I","II","III","IV","V","VI","VII","IIX","IX","X"};
        if (a>30){return "too big";}
        if (a>20){res+=l[10]+l[10]+l[a%10];}
        else if (a>10){res=l[10]+l[a%10];}
        else {res=l[a%10];}
        return res;
    }

    public static int calculate(int a,char sym,int b)
    {
        if(sym=='+'){return a+b;}
        if(sym=='-'){return a-b;}
        if(sym=='*'){return a*b;}
        if(sym=='/'){return a/b;}
        return 0;
    }

    public static boolean p9(String str)
    {
        String s1=str.substring(0,str.indexOf('='));
        String s2=str.substring(str.indexOf('=')+1);
        String sym1=s1.replaceAll("[a-zA-Z0-9]", "");
        String sym2=s2.replaceAll("[a-zA-Z0-9]", "");
        String num1=s1.replaceAll("[^0-9]", " ");
        String num2=s2.replaceAll("[^0-9]", " ");
        int f=0;
        String[] n1=num1.split(" ");
        String[] n2=num2.split(" ");
        int res1,res2;
        res1=Integer.parseInt(n1[0]);
        for (int i=1;i<n1.length;i++)
        {
            res1=calculate(res1,sym1.charAt(f),Integer.parseInt(n1[i]));f++;
        }
        System.out.println(res1);
        res2=Integer.parseInt(n2[0]);
        f=0;
        for (int i=1;i<n2.length;i++)
        {
            res2=calculate(res2,sym2.charAt(f),Integer.parseInt(n2[i]));f++;
        }
        return res1==res2;
    }

    public static boolean p10(int x)
    {
        if (x<10){return true;}
        String str=Integer.toString(x);
        String res="";
        while (str.length()>2)
        {
            String s1= str.substring(0,2);
            str=str.substring(2);
            int l1=Character.getNumericValue(s1.charAt(0));
            int l2=Character.getNumericValue(s1.charAt(1));
            int s=l1+l2;
            res += Integer.toString(s);
        }
        System.out.println(res);
        return  (Integer.parseInt(res)==Integer.reverse(Integer.parseInt(res)));
    }
}