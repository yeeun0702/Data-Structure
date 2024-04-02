package Sort;

import java.util.*;


class Student2 {
    int StudentId;
    String name;
    String Department;
    int grade;

    public Student2(int StudentId, String name, String Department, int grade) {
        this.StudentId = StudentId;
        this.name = name;
        this.Department = Department;
        this.grade = grade;
    }
}

class StudentComparator implements Comparator<Student2> {

    private int sortBy;

    public StudentComparator(int sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Student2 o1, Student2 o2) {
        switch (sortBy) {
            case 0:
                return Integer.compare(o1.StudentId, o2.StudentId);
            case 1:
                return o1.name.compareTo(o2.name);
            case 2:
                return o1.Department.compareTo(o2.Department);
            case 3:
                return Integer.compare(o1.grade, o2.grade);
            default:
                return 0;
        }
    }
}

public class ComparatorEx {

    public static void main(String[] args) {
        Student2 s1 = new Student2(202234001, "김", "AI", 4);
        Student2 s2 = new Student2(202234002, "이", "Computer Science", 3);
        Student2 s3 = new Student2(202234003, "박", "Software engineering", 2);
        Student2 s4 = new Student2(202234004, "최", "Information and Communication Engineering", 1);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("정렬 기준을 입력해주세요.\n학번 : 0  이름 : 1  학과 : 2 학년 : 3\n");
            int sortBy = sc.nextInt();

            ArrayList<Student2> studentList = new ArrayList<Student2>();
            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
            studentList.add(s4);

            Collections.sort(studentList, new StudentComparator(sortBy));

            System.out.println("\n정렬 결과:");
            for (Student2 s : studentList) {
                System.out.println(s.StudentId + " " + s.name + " " + s.Department + " " + s.grade);
            }
   
        }
    }
}