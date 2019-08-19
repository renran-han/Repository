import java.text.Format;
import java.util.Random;
import java.util.Scanner;
/*
场景说明：
模拟微信抢红包
 */
public class MoneyPackage {
    public static void main(String[] args) {
        System.out.println("------------模拟微信抢红包------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入微信红包金额（元）：");
        double total = sc.nextDouble();
        System.out.println("请输入红包的个数（个）");
        int bagcount = sc.nextInt();

        double min = 0.01;//红包最小金额
        Random r = new Random();

        for(int i=1;i<bagcount;i++){
            /**
             * 本个红包最大金额=total-（bagcount-已发出的红包个数）*min
             */
            double max = total-(bagcount-i)*min;
            double range = max - min;//红包金额的范围

            double safe = r.nextInt((int)(range*100))/100;
            double money = safe + min;//最终的红包金额
            total = total-money;//发完第i个红包后的金额

            System.out.println("第"+i+"个红包的金额为"+String.format("%.2f", money)+"元");
        }
        System.out.println("第"+bagcount+"个红包的金额为"+String.format("%.2f", total)+"元");
        sc.close();
    }
}
