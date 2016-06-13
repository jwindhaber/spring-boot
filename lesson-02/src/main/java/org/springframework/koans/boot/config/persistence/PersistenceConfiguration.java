package org.springframework.koans.boot.config.persistence;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author juergen.windhaber on 13.06.2016.
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("org.springframework.koans.boot.repository")
@EntityScan({"org.springframework.koans.boot.entity"})
public class PersistenceConfiguration {


}
