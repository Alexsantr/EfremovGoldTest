package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverConfig {

    private final DataConfig configData = ConfigFactory.create(DataConfig.class, System.getProperties());

    public void configParams() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = configData.getBaseUrl();
        Configuration.browser = configData.getBrowser();
        Configuration.browserVersion = configData.getBrowserVersion();
        Configuration.browserSize = configData.getBrowserSize();

        if (configData.isRemote()) {
            Configuration.remote = configData.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Configuration.browserCapabilities = capabilities;
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }
    }
}