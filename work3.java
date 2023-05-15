import java.util.Scanner;

public class work3 {
    public static void main(String[] args) {
        //todo 第一题测试代码
        System.out.println("--------------第一题-------------");
        System.out.println();
        Compute add = new Add();
        Compute minus = new Minus();
        Compute multiply = new Multiply();
        Compute divide = new Divide();

        UseCompute u = new UseCompute();
        //todo 测试加法
        u.useCom(add, 1, 2);
        //todo 测试减法
        u.useCom(minus, 1, 2);
        //todo 测试乘法
        u.useCom(multiply, 1, 2);
        //todo 测试正常除法
        u.useCom(divide, 1, 2);
        //todo 测试异常除法
        u.useCom(divide, 1, 0);
        System.out.println();

        //todo 第二题
        System.out.println("--------------第二题-------------");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的成绩");
        int score= scanner.nextInt();
        try
        {
            if (score < 0 || score > 100) {
                throw new Exception("分数必须在0-100之间！");
        }
            System.out.println("你的成绩是："+score);
    } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //todo 第三题
        System.out.println("--------------第三题-------------");
        System.out.println();
        Scanner scanner1 = new Scanner(System.in);
        int sum = 0;
        double average = 0;
        boolean flag=false;
        System.out.print("请输入要计算的整数个数：");
        int n = scanner.nextInt();
        int i=0;
        while(!flag) {
            try {
                for (; i < n; i++) {
                    System.out.printf("请输入第%d个整数：", (i + 1));
                    int num = scanner.nextInt();
                    if (num < 0) {
                        throw new Exception("必须是正数或者0。");
                    }
                    sum += num;
                }
                average = (double) sum / n;
                flag=true;
                System.out.printf("平均数为：%.2f\n", average);
            } catch (Exception e) {
                System.out.println("输入不合法：" + e.getMessage());
            }
        }
        System.out.println();
        //todo 第四题
        System.out.println("--------------第四题-------------");
        System.out.println();
        MyDate m=new MyDate(1996,9,9);
        Employee1 employee1=new Employee1("zhw",10000000,m) {
            @Override
            double earnings() {
                return getnumber();
            }
        };
        employee1.earnings();
        employee1.tostring();
        System.out.println();
        //todo 第五题
        System.out.println("--------------第五题-------------");
        System.out.println();
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int count = 0;

        for (String word : words) {
            if (equal(word, S)) {
                count++;
            }
        }

        System.out.println("单词字典中是 S 的子序列的单词个数： " + count);
    }

    public static boolean equal(String word, String S) {
        int i = 0, j = 0, n = word.length(), m = S.length();
        while (i < n && j < m) {
            if (word.charAt(i) == S.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
interface Compute{
    int computer(int n, int m);
}
class Add implements Compute{
    @Override
    public int computer(int n, int m) {
        return n+m;
    }
}
class Minus implements Compute{
    @Override
    public int computer(int n, int m) {
        return n-m;
    }
}
class Multiply implements Compute{
    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}
class Divide implements Compute{
    @Override
    public int computer(int n, int m) {
        if(m!=0){return n/m;}
        else {
            System.out.println("除数不能为零");
            return 0;
        }
    }
}
class UseCompute{
    public void useCom(Compute com, int one, int two){
        int result=com.computer(one,two);
        System.out.println("运算结果是"+result);
    }
}
abstract class Employee1{
    private String name;
    private long number;
    private MyDate birthday;
    abstract double earnings();
    String getName(){
        return name;
    }
    void setName(String name){
        this.name=name;
    }
    long getnumber(){
        return number;
    }
    void setNumber(long number){
        this.number=number;
    }
    Employee1(String name, long number, MyDate birthday){
        this.name=name;
        this.number=number;
        this.birthday=birthday;
    }
    void tostring(){
        System.out.println("姓名"+name+",工资"+number+",生日，"+"年："+birthday.year+"，月："+ birthday.month+"，日："+birthday.day);
    }
}
class MyDate{
    int year;
    int month;
    int day;
    MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
}