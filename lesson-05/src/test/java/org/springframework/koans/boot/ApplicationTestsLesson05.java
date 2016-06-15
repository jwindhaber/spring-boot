package org.springframework.koans.boot;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
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
    public void igniteClusterIsWorking() throws Exception {

        Assert.assertNotNull(ignite);

        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

        // Store keys in cache (values will end up on different cache nodes).
        for (Integer i = 0; i < 10; i++)
            cache.put(i, Integer.toString(i));

        for (Integer i = 0; i < 10; i++) {

            System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');

            Assert.assertEquals(i.toString(),cache.get(i));
        }


    }

}
