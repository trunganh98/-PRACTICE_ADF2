package Practice;

import java.sql.*;
import java.util.Scanner;

public class Utility {
    //region DataBase_Methods


    public static ResultSet executeQuery(String database, String query) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database + "?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public static int executeUpdate(String database, String query) {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database + "?" +
                                "&serverTimezone=UTC" +
                                "&allowPublicKeyRetrieval=true" +
                                "&useSSL=false",
                        "root",
                        ""
                );

                Statement statement = connection.createStatement();
        ) {
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    //endregion

    //region Input Methods

    /**
     * @return <b>Trả về số kiểu INT nhập vào từ bàn phím của console</b>
     */
    public static int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * @return <b>Trả về số kiểu double nhập vào từ bàn phím của console</b>
     */
    public static double getInputDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    /**
     * @return Chuổi String do người dùng nhập vào từ bàn phím của console
     */
    public static String getInputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static void pause_PressEnterToContinue() {
        System.out.println("\n\tNhấn phím [Enter] để tiếp tục...");
        try {
            System.in.read();
            //getInputStringLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] " + e);
        }
    }

    /**
     * <b>Hiện thị thông báo kèm nội dung xác nhận 1 task</b>
     *
     * @param message Nội dung muốn hiện thị
     * @return {@code true} nếu người dùng xác nhận <br> {@code false} nếu người dùng KHÔNG xác nhận
     */
    public static boolean isConfirm(String message) {
        System.out.print(message + " [Y/N]: ");
        while (true) {
            String confirm = getInputLine();
            switch (confirm) {
                case "Y":
                case "y":
                    System.out.println("Bạn chọn [CÓ]");
                    return true;
                case "N":
                case "n":
                    System.out.println("Bạn chọn [KHÔNG]");
                    return false;
                default:
                    System.out.println("[ERROR] Lựa chọn không hợp lệ, mời chọn lại...");
                    break;
            }
        }
    }
    //endregion
}
