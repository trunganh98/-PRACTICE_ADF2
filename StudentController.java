package Practice;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    public void insertItem(Student item) {
        String query = "INSERT INTO Student (Name, Address, Phone) " +
                "VALUES ('" + item.getName() + "', '" + item.getAddress() + "', '" + item.getPhone() + "');";
        System.out.println("Câu query của bạn là: \n" +query);

        int recordCount = Utility.executeUpdate("eStudent", query);
        if (recordCount > 0) {
            System.out.println("Thành công! Số bản ghi bị ảnh hưởng: " + recordCount);
        } else {
            System.out.println("Lỗi!  Số bản ghi bị ảnh hưởng: " + recordCount);
        }
    }

    public List<Student> selectAllColumn() {
        try {
            ResultSet resultSet = Utility.executeQuery("eStudent", "SELECT * FROM Student;");
            List<Student> lstStudent = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setIDStudent(resultSet.getInt("IDStudent"));
                student.setName(resultSet.getString("Name"));
                student.setAddress(resultSet.getString("Address"));
                student.setPhone(resultSet.getString("Phone"));
                lstStudent.add(student);
            }
            return lstStudent;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
