package lesson_5.homework;

public class HomeWork {

    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov Ivan", "Комондир", "ivivan@mailbox.com", 959345645, 75000, 40);
        employeeArray[1] = new Employee("Petr Petrov", "Связист", "mtc_v_tanke@mailbox.com", 959678234, 100000, 25);
        employeeArray[2] = new Employee("Serghei Sergeevich", "Мехвод", "lada_narmalinaea_mashina@mailbox.com", 959637637, 40000, 53);
        employeeArray[3] = new Employee("Alexei Alexeevich", "Заряжающий", "snareadov_net_no_vi_derjitesi@mailbox.com", 959688569, 68000, 23);
        employeeArray[4] = new Employee("Jenea Jenkovich", "Наводчик", "da_kak_ne_popal_to?@mailbox.com", 959611237, 10000, 45);

        for (Employee employee : employeeArray) {
            if (employee.getAge() > 40){
                employee.getInfo();
            }
        }
    }


}