package org.apache.http.util;

import java.util.Map;

@Deprecated
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";

    public VersionInfo(String s, String s1, String s2, String s3, String s4) {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo fromMap(String s, Map map0, ClassLoader classLoader0) {
        throw new RuntimeException("Stub!");
    }

    public final String getClassloader() {
        throw new RuntimeException("Stub!");
    }

    public final String getModule() {
        throw new RuntimeException("Stub!");
    }

    public final String getPackage() {
        throw new RuntimeException("Stub!");
    }

    public final String getRelease() {
        throw new RuntimeException("Stub!");
    }

    public final String getTimestamp() {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo loadVersionInfo(String s, ClassLoader classLoader0) {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo[] loadVersionInfo(String[] arr_s, ClassLoader classLoader0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

