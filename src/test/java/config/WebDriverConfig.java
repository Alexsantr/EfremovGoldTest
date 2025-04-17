package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverConfig {
    private final DataConfig configData = ConfigFactory.create(DataConfig.class, System.getProperties());

    public void configParams() {
        // Устанавливаем общие настройки
        Configuration.pageLoadStrategy = "eager";

        // Определяем, работает ли тест в удаленном режиме
        boolean isRemoteMode = isRemoteExecution();

        if (isRemoteMode) {
            configureRemoteExecution();
        } else {
            configureLocalExecution();
        }
    }

    private boolean isRemoteExecution() {
        String environment = System.getProperty("env", "");
        boolean isRemoteFlag = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
        return "remote".equals(environment) || isRemoteFlag;
    }

    private void configureRemoteExecution() {
        // Настройки для удаленного выполнения
        Configuration.remote = configData.remoteUrl();
        Configuration.baseUrl = System.getProperty("baseUrl", configData.getBaseUrl());
        Configuration.browser = System.getProperty("browser", configData.getBrowser());
        Configuration.browserSize = System.getProperty("browserSize", configData.getBrowserSize());
        Configuration.browserVersion = System.getProperty("browserVersion", configData.getBrowserVersion());

        // Настройки Selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    private void configureLocalExecution() {
        // Настройки для локального выполнения
        Configuration.baseUrl = configData.getBaseUrl();
        Configuration.browser = configData.getBrowser();
        Configuration.browserSize = configData.getBrowserSize();
        Configuration.browserVersion = configData.getBrowserVersion();
    }
}