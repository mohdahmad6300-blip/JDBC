import com.jdbc.JDBCExample;

import java.util.Scanner;

class RunJDBC {


    public static void main(String[] args) {
        while (true) {
            JDBCExample jdbc = new JDBCExample();
            System.out.println("\n==============================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");

            Scanner input = new Scanner(System.in);

            System.out.print("Enter your choice : ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    jdbc.addData();
                    break;

                case 2:
                    jdbc.viewAllData();
                    break;

                case 3:
                    jdbc.updateData();
                    break;

                case 4:
                    jdbc.deleteData();
                    break;
                case 5:
                    jdbc.searchData();
                    break;
                case 6:
                    System.out.println("Thanks for using my application ");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid choice ! ");
            }
        }

    }
}
