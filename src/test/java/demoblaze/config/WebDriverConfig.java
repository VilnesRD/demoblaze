package demoblaze.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/test.properties"})

public interface WebDriverConfig extends Config {
    @Key("browser")
    String getBrowser();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("ifRemote")
    Boolean IfRemote();

    @Key("remote")
    String getRemote();

    @Key("userLogin")
    String getUserLogin();

    @Key("userPassword")
    String userPassword();

    @Key("unregisteredUserLogin")
    String unregisteredUserLogin();

    @Key("unregisteredUserPassword")
    String unregisteredUserPassword();
}
