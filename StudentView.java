package Practice;

import java.util.List;

public class StudentView {
    public static void RunMenu() {
        try {
            while (true) {
                System.out.print("\n------ Menu------\n" +
                        " 1. Add student records              \n" +
                        " 2. Display student records          \n" +
                        " 3. Save                             \n" +
                        " 0. Exit                             \n" +
                        "  => Bạn chọn: ");
                int chose = Utility.getInputInt();
                System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");

                switch (chose) {
                    case 1:
                        addNewStudent();
                        break;
                    case 2:
                        viewStudent();
                        break;
                    case 3:
                        break;
                    case 0:
                        System.exit(1);
                    default:
                        break;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void addNewStudent() {
        Student student = new Student();

        System.out.println("Mời nhập các thông tin cho sinh viên: ");

        System.out.print("Name: ");
        String Name = Utility.getInputLine();
        student.setName(Name);

        System.out.print("Address: ");
        String Address = Utility.getInputLine();
        student.setAddress(Address);

        System.out.print("Phone: ");
        String Phone = Utility.getInputLine();
        student.setPhone(Phone);

        if (Utility.isConfirm("Xác nhận thêm 1 bản ghi? ")) {
            StudentController studentController = new StudentController();
            studentController.insertItem(student);
            System.out.println("Thêm thành công");
        }
    }

    private static void viewStudent() {
        StudentController studentController = new StudentController();
        List<Student> lstStudent = studentController.selectAllColumn();

        System.out.println("Danh sach sinh vien: ");
        for (var item : lstStudent) {
            System.out.println(item);
        }
    }
}
