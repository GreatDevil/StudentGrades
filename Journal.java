import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Journal {
    private static Map<String, Student> studentMap = new HashMap<>();

    public static Map<String, Student> getStudentMap() {
        return studentMap;
    }
    public static String addStudent(String studentName) {
        if (!studentName.isEmpty()) {
            if (studentMap.containsKey(studentName)) {
                return "ученик уже существует";
            }
            Student newStudent = new Student();
            newStudent.setName(studentName);
            newStudent.setGrades(new ArrayList<>());
            studentMap.put(studentName, newStudent);
            return "ученик добавлен";
        }
        return "недопустимое имя";
    }

    public static String removeStudent(String studentName) {
        if (studentMap.containsKey(studentName)) {
            studentMap.remove(studentName);
            return "ученик удален";
        }
        return "нет такого ученика";
    }

    public static String updateGrade(String studentNameWithGrade) {
        String[] nameAndGrade = studentNameWithGrade.split("\\s+");
        if(nameAndGrade.length != 2 || !checkByte(nameAndGrade)) {
            return "неверный ввод";
        }
        if (studentMap.containsKey(nameAndGrade[0])) {
            studentMap.get(nameAndGrade[0]).getGrades().add(Byte.parseByte(nameAndGrade[1]));
            return "оценка " + nameAndGrade[1] + " для " + nameAndGrade[0] + " добавлена";
        }
        return "нет такого ученика";
    }

    public static String showStudentGrades(String studentName) {
        if (studentMap.containsKey(studentName)) {
            System.out.println("Ученик : " + studentName + "\nОценки: " + studentMap.get(studentName).getGrades());
            return "готово";
        }
        return "нет такого ученика";
    }

    public static String showAllGrades(String empty) {
        if (!studentMap.isEmpty()) {
            studentMap.forEach((k,v) -> System.out.println("Ученик : " + k + "\nОценки: " + v.getGrades()));
            return "готово";
        }
        return "нет ни одного ученика";
    }

    private static boolean checkByte(String[] input) {
        try {
            Byte.parseByte(input[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
