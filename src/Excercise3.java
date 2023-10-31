import javax.swing.*;

interface MortgageConstants {
    int shortTerm = 1;
    int mediumTerm = 3;
    int longTerm = 5;
    String bankName = "CityToronto";
    double maxMortgageAmount = 300000;
}

abstract class Mortgage implements MortgageConstants{
    int mortgageNumber;
    String customerName;
    double mortgageAmount;
    double interestRate;
    int term;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageAmount = mortgageAmount;
        this.interestRate = interestRate;
        this.term = term;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getMortgageAmount() {
        return mortgageAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMortgageAmount(double mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String toString(){
        return "Mortgage Number: " + mortgageNumber
                + "\n Customer Name: " + customerName
                + "\n Mortgage Amount: " + mortgageAmount
                + "\n Interest Rate: " + interestRate
                + "\n Term: " + term + "Years";
    }
    abstract void getMortgageInfo();
}
class BusinessMortgage extends Mortgage{
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        super(mortgageNumber, customerName, mortgageAmount, interestRate, term);
        this.interestRate = interestRate + 1;
    }
    @Override
    void getMortgageInfo(){
        JOptionPane.showMessageDialog(null, toString());
    }
}
class PersonalMortgage extends Mortgage{
    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        super(mortgageNumber, customerName, mortgageAmount, interestRate, term);
        this.interestRate = interestRate + 2;
    }
    @Override
    void getMortgageInfo(){
        JOptionPane.showMessageDialog(null, toString());
    }
}
class ProcessMortgage{
    public static void main(String[] args) { double interestRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the current interest rate:"));

        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < 3; i++) {
            int mortgageType = Integer.parseInt(JOptionPane.showInputDialog("Enter mortgage type (1 for Business, 2 for Personal):"));

            int mortgageNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter mortgage number:"));
            String customerName = JOptionPane.showInputDialog("Enter customer name:");
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter mortgage amount:"));
            int term = Integer.parseInt(JOptionPane.showInputDialog("Enter mortgage term \n (1 for Short-term \n 2 for Medium-term \n 3 for Long-term):"));

            if (mortgageType == 1 && amount < MortgageConstants.maxMortgageAmount) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, (double) term, (int) interestRate);
            } else if (mortgageType == 2  && amount < MortgageConstants.maxMortgageAmount) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, (double) term, (int) interestRate);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid mortgage type or amount.");
                i--; // Retry input for this mortgage
            }
        }

        StringBuilder mortgageDetails = new StringBuilder("Mortgage Details:\n");
        for (Mortgage mortgage : mortgages) {
            mortgageDetails.append(mortgage.toString()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, mortgageDetails.toString());
    }
}
public class Excercise3 {

    public static void main(String[] args) {

    }
}
