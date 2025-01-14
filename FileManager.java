package workers;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "employees.dat"; // 저장 파일 이름

    // 데이터를 파일에 저장
    public static void saveToFile(ArrayList<Person> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees); // 컬렉션을 직렬화하여 저장
            System.out.println("데이터가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    // 파일에서 데이터를 불러오기
    public static ArrayList<Person> loadFromFile() {
        ArrayList<Person> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (ArrayList<Person>) ois.readObject(); // 파일에서 직렬화된 데이터를 읽어옴
            System.out.println("데이터가 성공적으로 로드되었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("저장된 파일이 없습니다. 새로운 데이터로 시작합니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일 로드 중 오류 발생: " + e.getMessage());
        }
        return employees;
    }
}
