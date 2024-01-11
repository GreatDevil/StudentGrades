import java.util.function.Function;

public enum Menu {
    A("a. Добавьте нового ученика", "введите имя", Journal::addStudent),
    B("b. Удалите ученика", "введите имя", Journal::removeStudent),
    C("c. Обновите оценку ученика", "введите имя ученика и оценку через пробел", Journal::updateGrade),
    D("d. Просмотр оценок всех учащихся", "нажмите ввод для просмотра", Journal::showAllGrades),
    E("e. Просмотр оценок конкретного учащегося", "введите имя", Journal::showStudentGrades),
    X("x. сохранить", "введите название файла", FileWorker::save);

    public final String describe;
    public final String answer;
    public final Function<String, String> action;
    Menu(String describe, String answer, Function<String, String> action) {
        this.describe = describe;
        this.answer = answer;
        this.action = action;
    }
}

