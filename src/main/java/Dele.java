import java.io.File;
import java.util.Scanner;

/*
    需求：
        根据所获得的文件路径，删除带特定字符的文件
 */
public class Dele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的文件名");
        String reg = sc.nextLine();

        System.out.println("请输入目标文件夹的绝对路径");
        String filePath = sc.nextLine();
        File file = new File(filePath);

        deleteFile(file,reg);
    }

    public static void deleteFile(File file,String reg) {
        int count = 0;  //定义一个计数变量，用于存储删除文件的数目
        if (!file.isDirectory()) {
            return;
        }    //只处理文件夹对象
        String directoryPath = file.getAbsolutePath();  //获得该文件夹对象的绝对路径
        File[] files = file.listFiles();    //获得该文件夹对象下的子文件集合
        if (files == null) {
            System.out.println("该文件夹下无文件，无需操作");
            return;
        }
        for (File f : files) {
            String fileName = f.getName();
            if(!fileName.contains(reg)){
                f.delete();
                count++;
            }
        }
        StringBuilder msg = new StringBuilder();
        msg.append("完成！已删除指定文件，总计：")
                .append(count)
                .append("个");
        System.out.println(msg);
    }
}
