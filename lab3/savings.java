package lab3;

public class savings {

    private String name;          
    private String currency;     
    private double annualRate;    
    private int months;           
    private double initialBalance; 

    public savings(String name, String currency, double annualRate, int months, double initialBalance) {
        this.name = name;
        this.currency = currency;
        this.annualRate = annualRate;
        this.months = months;
        this.initialBalance = initialBalance;
    }

    private double savingsCalcAccrued() {
        return initialBalance * (annualRate / 12) * months / 100;
    }
  
    private double savingsCalc() {
        return initialBalance + savingsCalcAccrued();
    }

    public void savingsReport() {
        System.out.println("----- Хадгаламжийн тайлан -----");
        System.out.printf("Хадгаламжийн нэр: %s%n", name);
        System.out.printf("Валют: %s%n", currency);
        System.out.printf("Жилийн хүү: %.2f%%%n", annualRate);
        System.out.printf("Хугацаа: %d сар%n", months);
        System.out.printf("Эхний үлдэгдэл: %.2f %s%n", initialBalance, currency);
        System.out.printf("Хуримтлагдсан хүү: %.2f %s%n", savingsCalcAccrued(), currency);
        System.out.printf("Эцсийн үлдэгдэл: %.2f %s%n", savingsCalc(), currency);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        savings s1 = new savings("Хугацаатай хадгаламж", "MNT", 12.0, 6, 1000000);
        s1.savingsReport();
    }
}