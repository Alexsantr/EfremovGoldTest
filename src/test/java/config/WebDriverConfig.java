package config;

import com.codeborne.selenide.Configuration;

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
        }
    }
}