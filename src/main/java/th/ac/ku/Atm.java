package th.ac.ku;

public class Atm {
    private Bank bank ;
    private Customer loginCustomer ;

    public Atm(Bank bank) {
        this.bank = bank ;
        this.loginCustomer = null ;
    }

    public String validateCustomer(int id, int pin) {

        //ดูว่า id ตรงกับที่มีใน Bank หรือไม่
        Customer customer = bank.findCustomer(id) ;

        //ถ้า id ตรงจะตรวจสอบ pin ของลูกค้าว่าตรงกับที่เก็บไว้หรือไม่
        if (customer != null && customer.checkPin(pin)) {
            loginCustomer = customer ;
            return customer.getName() ;
        } return null ;
    }


    //Delegation : ไม่ทำงานเอง แต่ส่งงานให้คนอื่นทำ เช่น Atm ไม่ได้ทำการฝากถอนเอง แต่ให้ BankAccount ทำให้
    public void deposit(double amount) {
        loginCustomer.getAccount().deposit(amount);
    }

    public void withdraw(double amount) {
        loginCustomer.getAccount().withdraw(amount);
    }

    public double getBalance() {
        return loginCustomer.getAccount().getBalance() ;
    }

    public void transfer(int receivingId, double amount) {
        Customer receivingCustomer = bank.findCustomer(receivingId) ;
        loginCustomer.getAccount().withdraw(amount);
        receivingCustomer.getAccount().deposit(amount);
    }

    public void  end() {
        loginCustomer = null ;
    }
}
