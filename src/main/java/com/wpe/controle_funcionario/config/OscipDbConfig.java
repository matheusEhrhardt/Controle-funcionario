package com.wpe.controle_funcionario.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "oscipEntityManager",
        basePackages = {"com.wpe.controle_funcionario.repository.oscip"})
public class OscipDbConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "oscip.datasource")
    public DataSource oscipDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean oscipEntityManager(EntityManagerFactoryBuilder builder,
                                                                     @Qualifier("oscipDataSource") DataSource dataSource){
        return builder
                .dataSource(dataSource)
                .packages("com.wpe.controle_funcionario.model.oscip")
                .build();
    }
}
