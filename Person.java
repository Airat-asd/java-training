/**
 * Java level 1. Lesson 5. Home work
 * @author Zagretdinov Airat
 * @version 1.0 date 13.02.2020
 * @link https://github.com/Airat-asd/java-training
 */
class HW5Lesson {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov", "Sergei", "Matveevich", "technology", "qweqwe@asdasd.com", "+144544", "64563", 35);
        persArray[1] = new Person("Petrov", "Andrei", "Sergeevich", "menedger", "ffgh@asdasd.com", "+453784", "64563", 45);
        persArray[2] = new Person("Sidorov", "Nikolai", "Antonovich", "couching", "bvnvbe@asdasd.com", "+54364", "64563", 25);
        persArray[3] = new Person("Alekseev", "David", "Nikolaevich", "CEO", "qhtyujsdasd.com", "+767554", "64563", 27);
        persArray[4] = new Person("Gabasov", "Maksim", "Leonidovich", "economist", "zxcvxcv@asdasd.com", "+14564254", "64563", 55);
        //persArray[0].printPerson();
        for (int i = 0; i <5; i++) {
            if (persArray[i].getAge() > 40)
                persArray[i].printPerson();
        }
    }
}

    public class Person {
        private String surname, name, patronymic, position, email, telephone, salary;
        private int age;

        public Person(String surname, String name, String patronymic, String position, String email, String telephone, String salary, int age) {
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.position = position;
            this.email = email;
            this.telephone = telephone;
            this.salary = salary;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getSurname() {
            return surname;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getPosition() {
            return position;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getSalary() {
            return salary;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        void printPerson() {
            System.out.println("Person: " + this.surname + " " + name + " " + patronymic);
            System.out.println("position: " + this.position);
            System.out.println("e-mail: " + this.email);
            System.out.println("telephone: " + this.telephone);
            System.out.println("salary: " + this.salary);
            System.out.println("age: " + this.age);
    }

}