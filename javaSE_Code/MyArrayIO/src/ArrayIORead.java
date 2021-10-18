import com.itheima.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayIORead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("MyArrayIO\\student.txt"));

        ArrayList<Student> array = new ArrayList<Student>();

        String line;
        while ((line = br.readLine()) != null) {
            //line.split每次只分割一行数据，所以String[] split的大小每次都是4
            String[] split = line.split(",");

            Student s = new Student();

            //不用循坏，每次重新进入line都是一行数据split大小都为4
/*            for (int i = 0; i < split.length; i++) {
                if (i % 4 == 0) {
                    s.setAvg(split[i]);
                } else if (i % 4 == 1) {
                    s.setName(split[i]);
                } else if (i % 4 == 2) {
                    s.setAge(split[i]);
                } else if (i % 4 == 3) {
                    s.setAddress(split[i]);
                }
            }*/

            s.setAvg(split[0]);
            s.setName(split[1]);
            s.setAge(split[2]);
            s.setAddress(split[3]);


            array.add(s);
            //输出四次4
            //System.out.println(split.length);
        }
        br.close();
        for (Student s : array) {
            System.out.println(s.getAvg() + "," + s.getName() + "," + s.getAge() + "," + s.getAddress());
        }
    }
}
