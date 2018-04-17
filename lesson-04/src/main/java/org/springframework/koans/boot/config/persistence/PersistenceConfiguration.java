package org.springframework.koans.boot.config.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * See: <a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#howto-use-spring-data-repositories">Use Spring Data repositories</a>
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("org.springframework.koans.boot.persistence.repository")
@EntityScan({"org.springframework.koans.boot.persistence.entity"})
public class PersistenceConfiguration {


}
