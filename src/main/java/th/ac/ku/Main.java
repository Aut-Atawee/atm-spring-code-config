package th.ac.ku;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ATMConfig.class) ;

        AtmUI atmUI = context.getBean(AtmUI.class) ;
        atmUI.run();

//        Atm atm = context.getBean(Atm.class) ;
//
//        String name = atm.validateCustomer(2, 2345) ;
//        System.out.println( name + " has " + atm.getBalance() );
//        atm.withdraw(200);
//        System.out.println( name + " has " + atm.getBalance() );
//
//        Bank bank = context.getBean(Bank.class) ;
//        System.out.println(bank.getName());



//        DataSourceDB dataSourceDB = new DataSourceDB() ;
//        DataSourceFile dataSourceFile = new DataSourceFile() ;
//
//        Bank myBank = new Bank("My Bank", new DataSourceWebAPI()) ;
//
//        //Bank yourBank = new Bank("Your Bank", dataSourceFile) ;


//        //การส่ง dependency ของ bank ให้ Atm
//        Atm atm = new Atm(myBank) ;
//
//        String name = atm.validateCustomer(2, 2345) ;
//        System.out.println( name + " has " + atm.getBalance() );
//        atm.withdraw(200);
//        System.out.println( name + " has " + atm.getBalance() );
    }
}
