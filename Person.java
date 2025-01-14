package workers;

//공무원 관리 프로그램의 기본 클래스
//모든 공무원이 공통으로 가지는 정보를 관리하는 부모 클래스
public class Person {
 private String name; // 이름
 private String gender; // 성별
 private String socialSecurityNumber; // 주민등록번호

 // 생성자: 객체를 생성할 때 이름, 성별, 주민등록번호를 초기화
 public Person(String name, String gender, String socialSecurityNumber) {
     this.name = name;
     this.gender = gender;
     this.socialSecurityNumber = socialSecurityNumber;
 }

 // Getter와 Setter 메서드: 필드에 접근하고 수정할 수 있도록 제공
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getGender() {
     return gender;
 }

 public void setGender(String gender) {
     this.gender = gender;
 }

 public String getSocialSecurityNumber() {
     return socialSecurityNumber;
 }

 public void setSocialSecurityNumber(String socialSecurityNumber) {
     this.socialSecurityNumber = socialSecurityNumber;
 }

 // toString 메서드: 객체 정보를 문자열 형태로 반환
 // 객체 정보를 출력할 때 유용하게 사용됨
 @Override
 public String toString() {
     return "이름: " + name + ", 성별: " + gender + ", 주민등록번호: " + socialSecurityNumber;
 }
}
