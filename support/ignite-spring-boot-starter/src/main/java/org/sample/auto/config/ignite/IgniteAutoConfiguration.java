package org.sample.auto.config.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.IgniteSpring;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author juergen.windhaber on 15.06.2016.
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(IgniteConfigurationProperties.class)
public class IgniteAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(Ignite.class)
    public Ignite ignite(ApplicationContext applicationContext, IgniteConfigurationProperties igniteConfigurationProperties ) throws IgniteCheckedException {

        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();

        TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();

        TcpDiscoveryVmIpFinder finder = new TcpDiscoveryVmIpFinder();
        finder.setAddresses(Arrays.asList(igniteConfigurationProperties.getAdresses()));

        discoverySpi.setIpFinder(finder);
        igniteConfiguration.setDiscoverySpi(discoverySpi);

        return IgniteSpring.start(igniteConfiguration, applicationContext);
    }






}
