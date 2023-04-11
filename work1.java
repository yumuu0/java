import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Scanner scanner=new Scanner(System.in);
        System.out.println("1、B 2、B 3、D 4、B 5、D");
        System.out.println("----------------------------");

        int n=input.nextInt();
        showTriangle(n);
        System.out.println("----------------------------");

        String s=scanner.nextLine();
        reverseString(s);
        System.out.println("----------------------------");

        int x=input.nextInt();
        isPalindrome(x);
        System.out.println("----------------------------");

        ShuiXianHua();
        System.out.println();
        System.out.println("----------------------------");

        int[] y=new int[10];
        int i;
        for(i=0;i<10;i++)
        {
            y[i]=input.nextInt();
        }
        arraysDemo(y);
        
    }


    public static void showTriangle(int n) {
        int i,j;
        for(i=0;i<n;i++)
        {
           for(j=0;j<n-1-i;j++)
           {
               System.out.print(' ');
           }
           for(j=0;j<2*i+1;j++)
           {
               System.out.print('*');
           }
            System.out.println();
        }

    }

    public static void reverseString(String s) {
        char[] chars = s .toCharArray();
        int i,a=s.length();
        char temp;
        for(i=0;i<a/2;i++)
        {temp=chars[i];
            chars[i]=chars[a-1-i];
            chars[a-1-i]=temp;
        }
        String s1 = String.valueOf(chars);
        System.out.println(s1);
    }
    public static void isPalindrome(int num) {
        boolean flag = true;
        String s=String.valueOf(num);
        char[] b = s .toCharArray();
        int a=s.length(),i;
        for(i=0;i<a/2;i++)
        {
            if(b[i]!=b[a-1-i])
            {
                flag=false;
            }
        }
        if (flag) {
            System.out.println("是的") ; }
        else
            System.out.println("不是") ; }

    public static void ShuiXianHua() {
        int i,a,b,c;
        for(i=100;i<1000;i++)
        {   a=i/100;
            b=i/10%10;
            c=i%10;
            if((a*a*a+b*b*b+c*c*c)==i)
            {
                System.out.print(i+" ");
            }

        }
    }

    public static void arraysDemo(int[] a) {
        int min =a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }
        int sum=max+min;
        System.out.println("最小值为：" + min + "最大值为："+max +"最小值和最大值之和为"+sum);
    }
}

