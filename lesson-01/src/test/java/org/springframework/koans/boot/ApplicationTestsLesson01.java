package org.springframework.koans.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * See: <a href="http://docs.spring.io/spring-boot/docs/1.4.0.M3/reference/htmlsingle/#boot-features-testing-spring-boot-applications">Testing Spring Boot applications</a>
 */
@RunWith(SpringRunner.class)
public class ApplicationTestsLesson01 {

	@Autowired
	private PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;

	@Test
	public void contextLoads() {

		Assert.assertNotNull(propertySourcesPlaceholderConfigurer);

	}

}
