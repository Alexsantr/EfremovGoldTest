package config;

import org.aeonbits.owner.Config;

import static com.codeborne.selenide.Browsers.CHROME;

@Config.Sources({"classpath:web.properties", "classpath:web.properties"})
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
    @DefaultValue("127.0")
    String getBrowserVersion();

    @Key("remote")
    @DefaultValue("false")
    boolean remote();

    @Key("remoteUrl")
    String remoteUrl();
}