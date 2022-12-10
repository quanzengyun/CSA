package CSA.Homework5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/csa?useSSL=false";
        String username = "root";
        String password = "12345678";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        List<String> id = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<String> college = new ArrayList<>();

//        插入数据
        System.out.println("第1题的效果");
        System.out.println("---------------");
        String sql = "insert into student values ('s001', '老大', 20, '计算机学院'),('s002', '老二', 19, '计算机学院'),('s003', '老三', 18, '计算机学院'),('s004', '老四', 17, '计算机学院');";
        boolean rs1 = statement.execute(sql);

        ResultSet rs = statement.executeQuery("select * from student");
        addList(id, name, age, college,rs);
        printList(id, name, age, college);
        clearList(id, name, age, college);
        System.out.println("---------------");

        System.out.println("第2题的效果");
        System.out.println("---------------");      //查找全部数据


        String sql1 = "select * from student";
        rs = statement.executeQuery(sql1);
        addList(id, name, age, college,rs);
        printList(id, name, age, college);
        clearList(id, name, age, college);
        System.out.println("---------------");


        System.out.println("第3题的效果");
        System.out.println("---------------");        //3.把sno为s004的记录删除

        String sql2 = "delete from student where SNO = 's004'";
        rs1 = statement.execute(sql2);

        rs = statement.executeQuery(sql1);
        addList(id, name, age, college,rs);
        printList(id, name, age, college);
        clearList(id, name, age, college);
        System.out.println("---------------");

        System.out.println("第4题的效果");
        System.out.println("---------------");      //4.查询sno为s003的记录
        String sql3 = "select * from student where SNO = 's003'";
        rs = statement.executeQuery(sql3);
        addList(id, name, age, college,rs);
        System.out.println("Student={sno='"+ id.get(0) +"', name='" + name.get(0) +"', age=" +age.get(0) +
                ", college='" + college.get(0) +"'}");
        clearList(id, name, age, college);
        //
        rs = statement.executeQuery(sql1);
        addList(id, name, age, college,rs);
        printList(id, name, age, college);
        clearList(id, name, age, college);
        System.out.println("---------------");

        System.out.println("第5题的效果");
        System.out.println("---------------");       //5.把sno为s001的记录修改为('s001','老大',20,'通信学院')
        String sql4 = "update student set College = '通信学院' where SNO = 's001'";
        rs1 = statement.execute(sql4);

        rs = statement.executeQuery(sql1);
        addList(id, name, age, college,rs);
        printList(id, name, age, college);
        clearList(id, name, age, college);
        System.out.println("---------------");

        statement.close();
        connection.close();
    }

    public static void clearList(List<String> id, List<String> name, List<Integer> age, List<String> college) {
        id.clear();
        name.clear();
        age.clear();
        college.clear();
    }

    public static void addList(List<String> id, List<String> name, List<Integer> age, List<String> college, ResultSet rs) throws SQLException {
        while (rs.next()) {
            id.add(rs.getString("SNO"));
            name.add(rs.getString("Name"));
            age.add(rs.getInt("Age"));
            college.add(rs.getString("College"));
        }
    }

    public static void printList(List<String> id, List<String> name, List<Integer> age, List<String> college) {
        for (int i = 0; i < id.size(); i++) {
            System.out.println(id.get(i) + "," + name.get(i) + "," + age.get(i) + "," + college.get(i));
        }
    }
}