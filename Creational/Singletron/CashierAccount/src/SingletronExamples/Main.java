package SingletronExamples;

class CashierAccount{
    private static CashierAccount cashierAccount ;
    double account_balance ;
    public CashierAccount(){
        account_balance = 0 ;
    }

    public void addBalance(double account_balance){
        this.account_balance += account_balance ;
    }

    public double getBalance(){
        return account_balance ;
    }

    public static CashierAccount getCashierAccount(){
        if(cashierAccount==null){
            cashierAccount = new CashierAccount() ;
            return cashierAccount ;
        }
        else return cashierAccount ;
    }
}
public class Main {

    public static void main(String[] args) {
        CashierAccount a = CashierAccount.getCashierAccount();
        a.addBalance(50) ;
        System.out.println(a.getBalance());
        CashierAccount b = CashierAccount.getCashierAccount() ;
        b.addBalance(100);
        System.out.println(b.getBalance());
    }
}
