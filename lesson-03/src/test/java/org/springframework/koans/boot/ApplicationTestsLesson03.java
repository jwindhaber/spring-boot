package org.springframework.koans.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.koans.boot.controller.HelloController;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * See: <a href="http://docs.spring.io/spring-boot/docs/1.4.0.M3/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests">Auto-configured Spring MVC tests</a>
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class ApplicationTestsLesson03 {

	@Autowired
	private MockMvc mvc;


	@Test
	public void testHelloWorld() throws Exception {

		this.mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk()).andExpect(content().string("Hello World!"));

	}

}
