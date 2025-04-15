package config;

import org.aeonbits.owner.Config;

import static com.codeborne.selenide.Browsers.CHROME;

@Config.Sources({"classpath:local.properties", "classpath:web.properties"})
public interface DataConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://efremov.gold/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue(CHROME)
    String getBrowser();

    @Key("browserSize")
    @DefaultValue("1220x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("125")
    String getBrowserVersion();

    @Key("remote")
    @DefaultValue("false")
    boolean remote();

    @Key("remoteUrl")
    @DefaultValue("https://efremov.gold/")
    String remoteUrl();
}