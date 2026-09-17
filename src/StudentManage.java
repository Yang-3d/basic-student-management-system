import java.util.Scanner;

public class StudentManage {
    int count = 0;
    Student[] students = new Student[100];

    static class Student {
        String id;
        String name;
        int age;
        String major;
    }

    public void addStudent(Scanner scanner) {
        if (count >= students.length) {
            System.out.println("学生数量已满！");
            return;
        }
        students[count] = new Student(); // 关键：先 new 出对象，否则空指针
        System.out.println("请输入学生ID：");
        students[count].id = scanner.next();
        System.out.println("请输入学生姓名：");
        students[count].name = scanner.next();
        System.out.println("请输入学生年龄：");
        students[count].age = scanner.nextInt();
        System.out.println("请输入学生专业：");
        students[count].major = scanner.next();
        count++; // 添加成功后再加人数
        System.out.println("已添加第 " + count + " 个学生");
    }

    public void deleteStudent(Scanner scanner) {
        System.out.println("请输入要删除的ID: ");
        String id = scanner.next();
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                // 后面的元素整体前移，覆盖被删除的学生
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;
                System.out.println("已删除ID为" + id + "的学生");
                return;
            }
        }
        System.out.println("未找到ID为" + id + "的学生");
    }

    public void modifyStudent(Scanner scanner) {
        System.out.println("请输入要修改的ID: ");
        String id = scanner.next();
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                System.out.println("请输入新的姓名：");
                students[i].name = scanner.next();
                System.out.println("请输入新的年龄：");
                students[i].age = scanner.nextInt();
                System.out.println("请输入新的专业：");
                students[i].major = scanner.next();
                System.out.println("已修改ID为" + id + "的学生");
                return;
            }
        }
        System.out.println("未找到ID为" + id + "的学生");
    }

    public void queryStudent(Scanner scanner) {
        System.out.println("请输入要查询的ID: ");
        String id = scanner.next();
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                System.out.println("ID: " + students[i].id + " 姓名: " + students[i].name
                        + " 年龄: " + students[i].age + " 专业: " + students[i].major);
                return;
            }
        }
        System.out.println("未找到ID为" + id + "的学生");
    }

    public void showAllStudents() {
        if (count == 0) {
            System.out.println("暂无学生信息");
            return;
        }
        System.out.println("共有 " + count + " 名学生：");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + students[i].id + " 姓名: " + students[i].name
                    + " 年龄: " + students[i].age + " 专业: " + students[i].major);
        }
    }

    public static void main(String[] args) { // 必须是 static
        StudentManage sm = new StudentManage();
        Scanner scanner = new Scanner(System.in);

        System.out.println("学生管理表");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.显示所有学生");
        System.out.println("6.退出系统");

        while (true) {
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sm.addStudent(scanner);
                    break;
                case 2:
                    sm.deleteStudent(scanner);
                    break;
                case 3:
                    sm.modifyStudent(scanner);
                    break;
                case 4:
                    sm.queryStudent(scanner);
                    break;
                case 5:
                    sm.showAllStudents();
                    break;
                case 6:
                    System.out.println("退出系统");
                    System.exit(0);
                default:
                    System.out.println("输入无效，请重新选择");
            }
        }
    }
}