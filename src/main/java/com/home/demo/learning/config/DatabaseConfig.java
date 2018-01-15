package com.home.demo.learning.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.home.demo.learning.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
