package com.huan.config;

import com.huan.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 12/11/15 - 10:16
 */
public class AbstractApplication extends SpringBootServletInitializer {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractApplication.class);
    protected static Environment staticEnv;
    @Autowired
    protected ConfigurableEnvironment env;

    protected static void abstractMain(SpringApplication app, String[] args) throws UnknownHostException {
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        addDefaultProfile(app, source);
        //addLiquibaseScanPackages();
        staticEnv = app.run(args).getEnvironment();
        showAppInfo(staticEnv);
    }

    protected static void showAppInfo(final Environment env) throws UnknownHostException {
        String isSslEnabled = env.getProperty("server.ssl.enabled");
        String protocol = "http";
        if (isSslEnabled != null && "true".equals(isSslEnabled)) {
            protocol = "https";
        }
        logger.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\t" + protocol + "://127.0.0.1:{}\n\t" +
                        "External: \t" + protocol + "://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    /**
     * If no profile has been configured, set by default the "dev" profile.
     */
    protected static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if ((System.getProperty("spring.profiles.active") == null)
                && !source.containsProperty("spring.profiles.active")
                && !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(this.getClass());
    }

    /**
     * Initializes the application. Do some checks on profile configuration
     * <p>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     * <p>
     */
    @PostConstruct
    public void initApplication() throws IOException {
        if (env.getActiveProfiles().length == 0) {
            logger.warn("No Spring profile configured, running with default configuration");
        } else {
            logger.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
            Collection activeProfiles = Arrays.asList(env.getActiveProfiles());
            if (activeProfiles.contains("dev") && activeProfiles.contains("prod")) {
                logger.error("You have misconfigured your application! It should not run with both the 'dev' and 'prod' profiles at the same time.");
            }
            if (activeProfiles.contains("prod") && activeProfiles.contains("fast")) {
                logger.error("You have misconfigured your application! It should not run with both the 'prod' and 'fast' profiles at the same time.");
            }
        }
    }
}
