package workers;

// 교사 클래스: Person 클래스를 상속받고 Duty 인터페이스를 구현
public class Teacher extends Person implements Duty {
    private int yearsOfService; // 근무 연수
    private double salary; // 봉급
    private String subject; // 담당 과목
    private String school; // 소속 학교

    // 생성자: 부모 클래스의 필드와 교사 고유 필드를 초기화
    public Teacher(String name, String gender, String socialSecurityNumber, int yearsOfService, double salary, String subject, String school) {
        super(name, gender, socialSecurityNumber);
        this.yearsOfService = yearsOfService;
        this.salary = salary;
        this.subject = subject;
        this.school = school;
    }

    // Getter와 Setter 메서드
    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    // 교사 고유 메서드: 수업을 진행
    public void teachClass() {
        System.out.println(getName() + " 교사가 " + school + "에서 " + subject + " 과목을 가르치고 있습니다.");
    }

    // Duty 인터페이스의 메서드 구현
    @Override
    public void performDuty() {
        System.out.println(getName() + " 교사가 " + school + "에서 학생들을 가르치고 있습니다.");
    }

    // toString 메서드: 객체 정보를 문자열 형태로 반환
    @Override
    public String toString() {
        return super.toString() +
               ", 근무 연수: " + yearsOfService +
               ", 봉급: " + salary +
               ", 과목: " + subject +
               ", 학교: " + school;
    }
}
