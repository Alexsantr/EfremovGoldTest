package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverConfig {
    private final DataConfig dataConfig;

    public WebDriverConfig(DataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }

    public void dataConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = dataConfig.getBaseUrl();
        Configuration.browser = dataConfig.getBrowser();
        Configuration.browserSize = dataConfig.getBrowserSize();
        Configuration.browserVersion = dataConfig.getBrowserVersion();
        if (dataConfig.remote()) {
            Configuration.remote = dataConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Configuration.browserCapabilities = capabilities;
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }
    }
}