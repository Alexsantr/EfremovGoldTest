package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "system:properties",
        "system:env"
})
public interface DataConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("127.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://efremov.gold/")
    String getBaseUrl();

    @Key("isRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();
}