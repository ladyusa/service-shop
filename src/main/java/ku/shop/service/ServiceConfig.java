package ku.shop.service;

import ku.shop.model.TaxCalculator;
import ku.shop.model.TaxCalifornia;
import ku.shop.model.TaxNewYork;
import ku.shop.model.TaxThailand;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    @ConditionalOnProperty(name = "tax.city", havingValue = "Thailand", matchIfMissing = true)
    public TaxCalculator thailandTaxCalculator() {
        return new TaxThailand();
    }

    @Bean
    @ConditionalOnProperty(name = "tax.city", havingValue = "NY")
    public TaxCalculator newyorkTaxCalculator() {
        return new TaxNewYork();
    }

    @Bean
    @ConditionalOnProperty(name = "tax.city", havingValue = "CA")
    public TaxCalculator californiaTaxCalculator() {
        return new TaxCalifornia();
    }
}
