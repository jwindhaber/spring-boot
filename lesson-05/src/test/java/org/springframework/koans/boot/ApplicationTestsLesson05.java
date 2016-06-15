package org.springframework.koans.boot;

import org.apache.ignite.Ignite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTestsLesson05 {

    @Autowired
    private Ignite ignite;

    @Test
    public void getBarneyOverRest() throws Exception {

        Assert.assertNotNull(ignite);


    }

}
