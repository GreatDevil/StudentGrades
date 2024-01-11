import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class FileWorker {

    public static String save(String filename) {
        File file = new File(System.getProperty("user.dir") + "/" + filename);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, Student> entry : Journal.getStudentMap().entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue().getGrades());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "сохранено";
    }

    public static String read(String filename) {
        try(Stream<String> lines = Files.lines(Paths.get(System.getProperty("user.dir") + "/" + filename))){
            lines.filter(line -> line.contains(":")).forEach(
                    line -> Journal.getStudentMap().putIfAbsent(line.split(":")[0],
                            new Student(line.split(":")[0], getByteListFromString(line.split(":")[1]))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "прочитано";
    }

    private static List<Byte> getByteListFromString(String input) {
        return Stream.of(input.replaceAll("\\s+|^.|.$", "").split(","))
                .filter(r -> !r.isEmpty())
                .map(Byte::parseByte)
                .toList();
    }
}
