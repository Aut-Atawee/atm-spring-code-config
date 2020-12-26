package th.ac.ku;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {
    @Bean
    public DataSource dataSource() {
        return new DataSourceDB() ;
    }

    @Bean
    public Bank bank() {
        return new Bank("My Bank", dataSource()) ;
    }

    @Bean
    public Atm atm() {
        return new Atm(bank()) ;
    }

    @Bean
    public AtmUI atmUI() {
        return new AtmUI(atm()) ;
    }
}
