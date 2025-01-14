package workers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Person> employees = new ArrayList<>(); // 공무원 데이터를 저장할 컬렉션

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        employees = FileManager.loadFromFile(); // 프로그램 시작 시 데이터 로드

        while (true) {
            System.out.println("\n=== 공무원 관리 시스템 ===");
            System.out.println("1. 공무원 추가");
            System.out.println("2. 공무원 목록 출력");
            System.out.println("3. 공무원 검색");
            System.out.println("4. 공무원 수정");
            System.out.println("5. 데이터 저장");
            System.out.println("6. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1 -> addEmployee(scanner);
                case 2 -> listEmployees();
                case 3 -> searchEmployee(scanner);
                case 4 -> modifyEmployee(scanner);
                case 5 -> FileManager.saveToFile(employees);
                case 6 -> {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    // 공무원 추가
    private static void addEmployee(Scanner scanner) {
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("성별: ");
        String gender = scanner.nextLine();
        System.out.print("주민등록번호: ");
        String ssn = scanner.nextLine();
        System.out.println("직업을 선택하세요 (1. 경찰관 2. 소방관 3. 교사 4. 구청 직원): ");
        int jobChoice = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        Person employee = null;
        switch (jobChoice) {
            case 1 -> {
                System.out.print("근무 연수: ");
                int years = scanner.nextInt();
                System.out.print("봉급: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // 개행 문자 제거
                System.out.print("근무 지역: ");
                String region = scanner.nextLine();
                System.out.print("소속 부서: ");
                String department = scanner.nextLine();
                employee = new PoliceOfficer(name, gender, ssn, years, salary, region, department);
            }
            case 2 -> {
                System.out.print("근무 연수: ");
                int years = scanner.nextInt();
                System.out.print("봉급: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // 개행 문자 제거
                System.out.print("소속 소방서: ");
                String station = scanner.nextLine();
                System.out.print("처리한 사건 수: ");
                int handled = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 제거
                employee = new Firefighter(name, gender, ssn, years, salary, station, handled);
            }
            case 3 -> {
                System.out.print("근무 연수: ");
                int years = scanner.nextInt();
                System.out.print("봉급: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // 개행 문자 제거
                System.out.print("담당 과목: ");
                String subject = scanner.nextLine();
                System.out.print("소속 학교: ");
                String school = scanner.nextLine();
                employee = new Teacher(name, gender, ssn, years, salary, subject, school);
            }
            case 4 -> {
                System.out.print("근무 연수: ");
                int years = scanner.nextInt();
                System.out.print("봉급: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // 개행 문자 제거
                System.out.print("소속 지역: ");
                String region = scanner.nextLine();
                System.out.print("소속 부서: ");
                String department = scanner.nextLine();
                employee = new CityHallWorker(name, gender, ssn, years, salary, region, department);
            }
            default -> System.out.println("잘못된 선택입니다.");
        }

        if (employee != null) {
            employees.add(employee);
            System.out.println("공무원이 추가되었습니다.");
        }
    }

    // 공무원 목록 출력
    private static void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("등록된 공무원이 없습니다.");
        } else {
            System.out.println("\n=== 공무원 목록 ===");
            for (Person employee : employees) {
                System.out.println(employee);
            }
        }
    }

    // 공무원 검색
    private static void searchEmployee(Scanner scanner) {
        System.out.print("검색할 주민등록번호: ");
        String ssn = scanner.nextLine();
        for (Person employee : employees) {
            if (employee.getSocialSecurityNumber().equals(ssn)) {
                System.out.println("검색 결과: " + employee);
                return;
            }
        }
        System.out.println("해당 주민등록번호를 가진 공무원이 없습니다.");
    }

    // 공무원 수정
    private static void modifyEmployee(Scanner scanner) {
        System.out.print("수정할 주민등록번호: ");
        String ssn = scanner.nextLine();
        for (Person employee : employees) {
            if (employee.getSocialSecurityNumber().equals(ssn)) {
                System.out.print("새 이름: ");
                String newName = scanner.nextLine();
                employee.setName(newName);
                System.out.println("정보가 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 주민등록번호를 가진 공무원이 없습니다.");
    }
}
