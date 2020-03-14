package ru.geekbrains.java_one.lesson_4;

public class Lesson_4 {

    //п.6 Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    private static void setSalary (Employee[] arrPerson){
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getAge() > 45) arrPerson[i].setSalary(arrPerson[i].getSalary()+5000f);
        }

    }

    public static void main(String[] args) {

        //п.4 Вывести при помощи методов из пункта 3 ФИО и должность.
        Employee person = new Employee();
        System.out.println("Вывод результата по п.4");
        System.out.println("Name: "+person.getSurname()+", Age: "+person.getAge()+", Position: "+person.getPosition()+", Salary: "+person.getSalary()+", ID: "+person.getObjId());

        //п.5 Создать массив из 5 сотрудников.
        Employee[] arrPerson = new Employee[5];
        arrPerson[0] = new Employee("Иванов",45000f,29,"Тестер");
        arrPerson[1] = new Employee("Петров",90000f,26,"Программер");
        arrPerson[2] = new Employee("Сидоров",110000f,48,"Тимлид");
        arrPerson[3] = new Employee("Кузнецов",130000f,46,"Продуктменеджер");
        arrPerson[4] = new Employee("Светлов",140000f,38,"Прожектменеджер");

        //п.5 С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("Вывод результата по п.5");
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getAge()>40) System.out.println("Name: "+arrPerson[i].getSurname()+", Age: "+arrPerson[i].getAge()+", Position: "+arrPerson[i].getPosition()+", Salary: "+arrPerson[i].getSalary()+", ID: "+arrPerson[i].getObjId());
        }

        //п.6 Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
        setSalary(arrPerson);
        System.out.println("Вывод результата по п.6");
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getAge()>40) System.out.println("Name: "+arrPerson[i].getSurname()+", Age: "+arrPerson[i].getAge()+", Position: "+arrPerson[i].getPosition()+", Salary: "+arrPerson[i].getSalary()+", ID: "+arrPerson[i].getObjId());
        }

        //п.7 Подсчитать средние арифметические зарплаты и возраста сотрудников из п.5
        System.out.println("Вывод результата по п.7");
        float middleSalary = 0f;
        float middleAge = 0f;
        int count=0;
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getAge()>40) {
                count++;
                middleSalary += arrPerson[i].getSalary();
                middleAge += arrPerson[i].getAge();
            }
        }
        middleAge /= count;
        middleSalary /= count;
        System.out.println("Количество для расчета: "+count+" Средняя зарплата: "+middleSalary+" Средний возраст: "+middleAge);

    }

}
