package org.springframework.koans.boot.config.persistence;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * See: <a href="http://docs.spring.io/spring-boot/docs/1.4.0.M3/reference/htmlsingle/#howto-use-spring-data-repositories">Use Spring Data repositories</a>
 *
 * @see EnableJpaRepositories
 * @see EntityScan
 * @see EnableTransactionManagement
 * @see Configuration
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("org.springframework.koans.boot.persistence.repository")
@EntityScan({"org.springframework.koans.boot.persistence.entity"})
public class PersistenceConfiguration {


}
