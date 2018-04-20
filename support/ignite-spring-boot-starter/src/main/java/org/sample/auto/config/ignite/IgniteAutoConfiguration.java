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
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * See:
 * <ul>
 *    <li><a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-external-config-typesafe-configuration-properties">Type-safe Configuration Properties</a></li>
 *    <li><a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-developing-auto-configuration">Creating your own auto-configuration</a></li>
 *    <li>Define the spring.factories file</li>
 * </ul>
 *
 * @see EnableConfigurationProperties
 *
 */
@Configuration
public class IgniteAutoConfiguration {

    /**
     *See: <a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-condition-annotations">Condition annotations</a>
     *
     * @see ConditionalOnMissingBean
     *
     */
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
