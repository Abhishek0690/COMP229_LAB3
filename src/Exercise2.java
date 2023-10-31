import javax.swing.JOptionPane;
abstract class GameTester{
    String Name;
    Boolean isFullTime;
    public String toString(){
        return "Name: " + Name
                + "\n Is Full Time: " + isFullTime
                + "\n Salary: " + salary;
    }
    int salary;
    abstract void setSalary();
    abstract void displayInfo();
}

class FullTime extends GameTester{
    @Override
    void setSalary() {
        this.salary = 3000;
    }
    @Override
    void displayInfo(){
        JOptionPane.showMessageDialog(null, toString());
    }
}
class PartTime extends GameTester{
    @Override
    void setSalary() {
        int numberOfHours = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of hours worked: "));
        double salary = numberOfHours * 20;
        this.salary = (int) salary;
    }
    @Override
    void displayInfo(){
        JOptionPane.showMessageDialog(null, toString());
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        String typeOfTester = JOptionPane.showInputDialog("Enter the type of tester (Full Time or Part Time):");
        GameTester tester;
        if (typeOfTester.equalsIgnoreCase("Full Time")) {
            tester = new FullTime();
            tester.isFullTime = true;
            tester.Name = "Full Time Tester";
            tester.setSalary();
        } else if (typeOfTester.equalsIgnoreCase("Part Time")) {
            tester = new PartTime();
            tester.isFullTime = false;
            tester.Name = "Part Time Tester";
            tester.setSalary();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input");
            return;
        }
        tester.displayInfo();
    }
}
