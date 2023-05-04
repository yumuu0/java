import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        //TODO:在此编写第一题测试代码
        Monkey m=new Monkey("吉吉");
        People p=new People("光头强");
        m.speak();
        p.speak();
        p.think();
        System.out.println("<-------第二题------->");
        //TODO:在此编写第二题测试代码
        Car c=new Car(4, 1150.0,3);
        c.a();
        System.out.println("---------------------------------");
        Truck t=new Truck(6,15000.0,1,3000.0);
        t.a();

        System.out.println("<-------第三题------->");
        //TODO:在此编写第三题测试代码
        String a="88888888888888888";
        String b="25461213124533465";
        System.out.println(getSum(a,b));
        System.out.println("<-------第四题------->");
        //TODO:在此编写第四题测试代码
        Scanner in = new Scanner(System.in);
        System.out.println("请输入网格大小 m 和 n：");
        int x = in.nextInt();
        int y = in.nextInt();
        int paths = path(x, y);
        System.out.printf("路径数为：%d\n", paths);
        System.out.println("<-------第五题------->");
        //TODO:在此编写第五题测试代码
        String[] strs1 = {"flower","flow","flight"};
        String prefix1 = seek(strs1);
        System.out.println("最长公共前缀为：" + prefix1);

        String[] strs2 = {"dog","racecar","car"};
        String prefix2 = seek(strs2);
        System.out.println("最长公共前缀为：" + prefix2);

        String[] strs3 = {"beijing","beida","best"};
        String prefix3 = seek(strs3);
        System.out.println("最长公共前缀为：" + prefix3);
    }
    public static String getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for(int i = a.length()-1;i >= 0;--i){
            la.add(a.charAt(i)- '0');
        }
        for(int i = b.length()-1;i >= 0;--i){
            lb.add(b.charAt(i)- '0');
        }
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        int x=0;
        for(int i=0;i<Math.max(a.length(),b.length());i++)
        {
            int sum=x;
            if(i<a.length())
                sum+= la.get(i);
            if(i<b.length())
                sum+=lb.get(i);
            c+=sum%10;
            x=sum/10;

        }
        if(x>0)
            c+=x;
        char[] chars=c.toCharArray();
        StringBuilder rc=new StringBuilder();
        for(int i= chars.length-1;i>=0;i--)
        {
            rc.append(chars[i]);
        }
        String rc1= rc.toString();
        return rc1;
    }

    public static int path(int m,int n) {
    int[][] p=new int[m][n];
    for(int i=0;i<m;i++){
        p[i][0]=1;
    }
    for(int j=0;j<n;j++){
        p[0][j]=1;
    }
    for(int i=1;i<m;i++){
        for (int j = 1; j < n; j++) {
            p[i][j]=p[i-1][j]+p[i][j-1];
        }
    }
    return p[m-1][n-1];
    }

    public static void indexstr(String[] args) {

    }

    public static String seek(String[] str) {
        if(str ==null || str.length==0){
            return "\"\"";
        }
        int min=str[0].length();
        int i,j = 0;
        String c="";
        for(i=0;i<str.length;i++){
            if(str[i].length()<min)
                min=str[i].length();
        }
        for(i=0;i<str.length-1;i++)
        {
            for(j=0;j<min;j++)
            {
                if(str[i].charAt(j)!=str[i+1].charAt(j)){
                    break;
                }
            }
            if(j==0){
                return "\"\"";
            }
        }
        if (i == str.length - 1) {
            for(i=0;i<j;i++)
            {
                c+=str[0].charAt(i);
            }

        }
        return c;
    }
}
class Monkey{
    String name;
    Monkey(String s){
        name=s;
    }
    public void speak(){
        System.out.println("咿咿呀呀 ......");
    }
}
class People extends Monkey{
    People(String s){
        super(s);
    }
    public void speak(){
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    void think(){
        System.out.println("别说话！认真思考！");
    }
}
class Vehicle{
    int wheels;
    double weight;
    Vehicle(int wheels,double weight){
        this.wheels=wheels;
        this.weight=weight;
    }
    public void a(){
        System.out.println("车轮的个数是："+wheels+" 车重："+weight);
    }
}
class Car extends Vehicle{
    int loader;
    int lpeople=5;
    Car(int wheels, double weight,int loader) {
        super(wheels, weight);
        this.loader=loader;
    }
    public void a(){
        super.a();
        if (loader<lpeople){
            System.out.println("这是一辆小车，"+"能载" + lpeople + "人，实载" + loader + "人");
        } else{
            System.out.println("这是一辆小车，"+"能载" + lpeople + "人，实载" + loader + "人,"+"你超员了！！！");
        }
    }

}
class Truck extends Vehicle{
    int loader;
    double payload;
    int lpeople=3;
    float lpayload=5000;
    Truck(int wheels, double weight,int loader,double payload) {
        super(wheels, weight);
        this.loader=loader;
        this.payload=payload;
    }

    @Override
    public void a() {
        super.a();
        if (loader<lpeople){
            System.out.println("这是一辆卡车，"+"能载"+lpeople+"人,实载"+loader+"人");
        } else{
            System.out.println("这是一辆卡车，"+"能载"+lpeople+"人,实载"+loader+"人，"+"你超员了！！！");
        }
        if (payload<lpayload){
            System.out.println("这是一辆卡车，"+"核载"+lpayload+"kg,你已装载"+payload+"kg");
        } else{
            System.out.println("这是一辆卡车，"+"核载"+lpayload+"kg,你已装载"+payload+"kg"+"，你超载了！！！");
        }
    }
}