import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static String file = "data/staff.txt";
    private static String dataFormat = "dd.MM.yyyy";
    private static ArrayList<Integer> topSalaryEmployees = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Employee> listEmployees = loadStaffFromFile();
        listEmployees.forEach(System.out::println);
        topSalaryEmployees = getTopSalaryEmployees(listEmployees);
        System.out.println("Top 5 salary employees: ");
        topSalaryEmployees.forEach(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> listStaff = new ArrayList<>();
        try {
            List<String> listLines = Files.readAllLines(Paths.get(file));
            for (String line : listLines) {
                String[] fragments = line.split("\s{2,}");
                if (fragments.length != 3) {
                    System.out.println("Count components wrongly!");
                    continue;
                }

                listStaff.add(
                        new Employee(
                                fragments[0],
                                Integer.parseInt(fragments[1]),
                                (new SimpleDateFormat(dataFormat)).parse(fragments[2])
                                ));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listStaff;
    }

    private static ArrayList<Integer> getTopSalaryEmployees(ArrayList<Employee> listEmployees) {
        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -o1.getSalary().compareTo(o2.getSalary());
            }
        });
        for (int i = 0; i < 5; i++) {
            topSalaryEmployees.add(listEmployees.get(i).getSalary());
        }
        return topSalaryEmployees;
    }
}
