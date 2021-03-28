package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCSV {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/royeyu/Downloads/user7.csv", true);

        BufferedWriter bw = new BufferedWriter(fileWriter); // 附加

        // 添加新的数据行
        bw.write("123");
//        bw.newLine();
        bw.close();
    }
}
