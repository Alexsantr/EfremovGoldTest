package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverConfig {
    private final DataConfig configData = ConfigFactory.create(DataConfig.class, System.getProperties());


    public void configParams() {
        boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
        String environment = System.getProperty("env");

        Configuration.pageLoadStrategy = "eager";
        if (isRemote) {
            Configuration.baseUrl = System.getProperty("baseUrl", "https://efremov.gold/");
            Configuration.browserSize = System.getProperty("browserSize", "1240x1832");
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserVersion = System.getProperty("browserVersion");


            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;

        } else {
            if (environment.equals("remote")) {
                Configuration.baseUrl = configData.getBaseUrl();
                Configuration.browser = configData.getBrowser();
                Configuration.browserSize = configData.getBrowserSize();
                Configuration.browserVersion = configData.getBrowserVersion();


                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
                Configuration.browserCapabilities = capabilities;
            }
            Configuration.baseUrl = configData.getBaseUrl();
            Configuration.browser = configData.getBrowser();
            Configuration.browserSize = configData.getBrowserSize();
            Configuration.browserVersion = configData.getBrowserVersion();
        }
    }
}
