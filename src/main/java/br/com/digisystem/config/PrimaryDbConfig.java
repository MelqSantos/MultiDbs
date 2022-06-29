package br.com.digisystem.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "br.com.digisystem.entities.primary")
@EnableJpaRepositories(
    basePackages = "br.com.digisystem.repositories.primary", 
    entityManagerFactoryRef = "primaryEntityManager", 
    transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDbConfig {

	@Primary
    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix = "primary.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="primaryEntityManager")
    public LocalContainerEntityManagerFactoryBean primaryEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("br.com.digisystem.entities.primary")
                .build();
    }
    
    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
        @Qualifier("primaryEntityManager") EntityManagerFactory primaryEntityManagerFactory) {
      return new JpaTransactionManager(primaryEntityManagerFactory);
    }
}
