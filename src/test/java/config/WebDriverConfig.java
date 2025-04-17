package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverConfig {
    private final DataConfig configData = ConfigFactory.create(DataConfig.class, System.getProperties());

    public void configParams() {

        Configuration.pageLoadStrategy = "eager";


        boolean isRemote = configData.remote() ||
                Boolean.parseBoolean(System.getProperty("isRemote", "false")) ||
                "remote".equals(System.getProperty("env"));

        Configuration.baseUrl = resolveBaseUrl();
        Configuration.browser = resolveBrowser();
        Configuration.browserSize = resolveBrowserSize();
        Configuration.browserVersion = resolveBrowserVersion();

        if (isRemote) {
            configureRemote();
        }
    }

    private void configureRemote() {
        Configuration.remote = configData.remoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }


    private String resolveBaseUrl() {
        return System.getProperty("baseUrl", configData.getBaseUrl());
    }

    private String resolveBrowser() {
        return System.getProperty("browser", configData.getBrowser());
    }

    private String resolveBrowserSize() {
        return System.getProperty("browserSize", configData.getBrowserSize());
    }

    private String resolveBrowserVersion() {
        return System.getProperty("browserVersion", configData.getBrowserVersion());
    }
}