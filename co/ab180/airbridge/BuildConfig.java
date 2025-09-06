package co.ab180.airbridge;

public final class BuildConfig {
    public static final String AIRBRIDGE_SERVER_URL = "https://{FUNCTION}.airbridge.io";
    public static final String AIRBRIDGE_VERSION_NAME = "4.7.0";
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final boolean IS_DEV = false;
    public static final String LIBRARY_PACKAGE_NAME = "co.ab180.airbridge";
    public static final Boolean RESTRICTED;

    static {
        BuildConfig.RESTRICTED = Boolean.FALSE;
    }
}

