package com.myhome.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "mainEntityManagerFactory",
	transactionManagerRef = "mainTransactionManager",
	basePackages = ["com.myhome.repository"],
)
class MainDataSourceConfig {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	fun mainDatasourceProperties(): DataSourceProperties = DataSourceProperties()

	@Bean
	fun mainDataSource(mainDatasourceProperties: DataSourceProperties): DataSource =
		mainDatasourceProperties.initializeDataSourceBuilder().build()

	@Bean
	fun mainEntityManagerFactory(
		mainDataSource: DataSource,
		builder: EntityManagerFactoryBuilder,
	): LocalContainerEntityManagerFactoryBean =
		builder.dataSource(mainDataSource)
			.packages("com.myhome.entity")
			.persistenceUnit("main")
			.build()

	@Bean
	fun mainTransactionManager(mainTransactionManager: EntityManagerFactory): PlatformTransactionManager =
		JpaTransactionManager(mainTransactionManager)
}