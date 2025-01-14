package workers;

//소방관 클래스: Person 클래스를 상속받고 Duty 인터페이스를 구현
public class Firefighter extends Person implements Duty {
 private int yearsOfService; // 근무 연수
 private double salary; // 봉급
 private String station; // 소속 소방서
 private int emergenciesHandled; // 처리한 비상 상황 수

 // 생성자: 부모 클래스의 필드와 소방관 고유 필드를 초기화
 public Firefighter(String name, String gender, String socialSecurityNumber, int yearsOfService, double salary, String station, int emergenciesHandled) {
     super(name, gender, socialSecurityNumber);
     this.yearsOfService = yearsOfService;
     this.salary = salary;
     this.station = station;
     this.emergenciesHandled = emergenciesHandled;
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

 public String getStation() {
     return station;
 }

 public void setStation(String station) {
     this.station = station;
 }

 public int getEmergenciesHandled() {
     return emergenciesHandled;
 }

 public void setEmergenciesHandled(int emergenciesHandled) {
     this.emergenciesHandled = emergenciesHandled;
 }

 // 소방관 고유 메서드: 화재 진압
 public void extinguishFire() {
     System.out.println(getName() + " 소방관이 " + station + " 소방서에서 화재를 진압하고 있습니다.");
 }

 // Duty 인터페이스의 메서드 구현
 @Override
 public void performDuty() {
     System.out.println(getName() + " 소방관이 " + station + " 소방서에서 화재 진압 임무를 수행하고 있습니다.");
 }

 // toString 메서드: 객체 정보를 문자열 형태로 반환
 @Override
 public String toString() {
     return super.toString() +
            ", 근무 연수: " + yearsOfService +
            ", 봉급: " + salary +
            ", 소속 소방서: " + station +
            ", 처리한 사건 수: " + emergenciesHandled;
 }
}
