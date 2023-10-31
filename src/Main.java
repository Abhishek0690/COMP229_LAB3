import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
abstract class Insurance{
    String typeOfInsurance;

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    Double monthlyCost;

    public Double getMonthlyCost() {
        return monthlyCost;
    }
    public String toString(){
        return "Type of Insurance:" + typeOfInsurance
        + "\n Monthly Cost: " + monthlyCost
        +"\n ";
    }
    abstract void setInsuranceCost(Double monthlyCost);
    abstract void displayInfo();
}
class Health extends Insurance{

    @Override
    void setInsuranceCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    void displayInfo(){
        JOptionPane.showMessageDialog(null, toString());
    }

}
class  Life extends Insurance {
    @Override
    void setInsuranceCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    void displayInfo(){
        JOptionPane.showMessageDialog(null, toString());
    }

}
public class Main {

    public static void main(String[] args) {
        String insuranceType = JOptionPane.showInputDialog("Enter the type of insurance (Life or Health):");
        double monthlyFee = Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly fee: $"));

        Insurance insurance;

        if (insuranceType.equalsIgnoreCase("Life")) {
            insurance = new Life();
            insurance.setInsuranceCost(monthlyFee);
            insurance.typeOfInsurance = insuranceType;
        } else if (insuranceType.equalsIgnoreCase("Health")) {
            insurance = new Health();
            insurance.setInsuranceCost(monthlyFee);
            insurance.typeOfInsurance = insuranceType;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid insurance type entered.");
            return;
        }

        insurance.displayInfo();

    }
}