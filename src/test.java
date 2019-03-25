
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;

public class test {
    public static void main(String []args) throws FileNotFoundException {
        double[] a = new double[10000];
        double[] b = new double[10000];
        double[] m = new double[1000];
        double[] n = new double[1000];
        double[][] s = new double[1000][2];
        int p;

        PrintStream ps = new PrintStream("e:/log.txt");
        System.setOut(ps);

        p = readFile(a,1);
        int q = readFile(b, 2);
        System.out.println("第一份文件的数据数量为： " + p);
        System.out.println("第二份文件的数据数量为： " + q);
        sort(a,0,p-1);
        sort(b,0,q-1);
        function(a,b,m,n,s,p,q);
        int i = 0;
        System.out.println("第一份文件中的的数字在第二份文件中没有的为：");
        while(m[i] != 0){
            System.out.println(m[i] + " ");
            i++;
        }
        System.out.println("第二份文件中的的数字在第一份文件中没有的为：");
        i = 0;
        while(n[i] != 0){
            System.out.println(n[i] + " ");
            i++;
        }
        i = 0;
        System.out.println("重复出现的数字为(左边为重复出现的数据，右边为重复出现的次数)：");
        while(s[i][0] != 0){
            System.out.println(s[i][0] + " " + s[i][1]);
            i++;
        }
    }

    //读取文本文档中的数据
    public static int readFile(double[] num,int c) {
        String pathname = "E:\\" + c + ".txt";
       int i = 0;
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.length() != 0) {
                    num[i] = new DecimalFormat().parse(line).doubleValue();
                    i++;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return i;
    }

    // 快速排序
    public static void sort(double[] a, int low, int high) {
        int start = low;
        int end = high;
        double key = a[low];

        while (end > start) {

            while (end > start && a[end] >= key)
                end--;
            if (a[end] <= key) {
                double temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            while (end > start && a[start] <= key)
                start++;
            if (a[start] >= key) {
                double temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }

        if (start > low)
            sort(a, low, start - 1);
        if (end < high)
            sort(a, end + 1, high);
    }

    //计算不一样的数字
    public static void function(double[] a,double[] b,double[] m,double[] n,double[][] s,int p,int q){
        int i = 0,j = 0,k = 0,l = 0,o = 0;
        double temp = a[0];
        int num = 0;
        while(i < p && j < q){
            if(a[i] == b[j] && temp == a[i]){
                i++;
                j++;
                num++;
            }else if(a[i] == b[j] && temp != a[i]){
                if(num > 1){
                    s[o][0] = temp;
                    s[o][1] = num;
                    o++;
                }
                temp = a[i];
                num = 0;
            }else if(a[i] > b[j]){
                n[l++] = b[j];
                j++;
                if(num > 1){
                    s[o][0] = temp;
                    s[o][1] = num;
                    o++;
                }
                temp = a[i];
                num = 0;
            }else{
                m[k++] = a[i];
                i++;
                if(num > 1){
                    s[o][0] = temp;
                    s[o][1] = num;
                    o++;
                }
                temp = a[i];
                num = 0;
            }
        }

        while(i < p){
            m[k++] = a[i++];
        }
        while(j < q){
            n[l++] = b[j++];
        }
    }
}
