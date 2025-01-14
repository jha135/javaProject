package workers;

//경찰관 클래스: Person 클래스를 상속받고 Duty 인터페이스를 구현
public class PoliceOfficer extends Person implements Duty {
 private int yearsOfService; // 근무 연수
 private double salary; // 봉급
 private String region; // 근무 지역
 private String department; // 소속 부서

 // 생성자: 부모 클래스의 필드와 경찰관 고유 필드를 초기화
 public PoliceOfficer(String name, String gender, String socialSecurityNumber, int yearsOfService, double salary, String region, String department) {
     super(name, gender, socialSecurityNumber); // 부모 클래스(Person)의 생성자 호출
     this.yearsOfService = yearsOfService;
     this.salary = salary;
     this.region = region;
     this.department = department;
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

 public String getRegion() {
     return region;
 }

 public void setRegion(String region) {
     this.region = region;
 }

 public String getDepartment() {
     return department;
 }

 public void setDepartment(String department) {
     this.department = department;
 }

 // 경찰관 고유 메서드: 수사를 수행
 public void investigate() {
     System.out.println(getName() + " 경찰관이 " + region + "에서 수사를 수행하고 있습니다.");
 }

 // Duty 인터페이스의 메서드 구현
 @Override
 public void performDuty() {
     System.out.println(getName() + " 경찰관이 " + region + "에서 치안을 유지하고 있습니다.");
 }

 // toString 메서드: 객체 정보를 문자열 형태로 반환
 @Override
 public String toString() {
     return super.toString() +
            ", 근무 연수: " + yearsOfService +
            ", 봉급: " + salary +
            ", 근무 지역: " + region +
            ", 소속 부서: " + department;
 }
}
