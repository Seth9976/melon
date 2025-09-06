package org.apache.http.util;

import com.iloen.melon.utils.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class VersionInfoHC4 {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    public VersionInfoHC4(String s, String s1, String s2, String s3, String s4) {
        Args.notNull(s, "Package identifier");
        this.infoPackage = s;
        if(s1 == null) {
            s1 = "UNAVAILABLE";
        }
        this.infoModule = s1;
        if(s2 == null) {
            s2 = "UNAVAILABLE";
        }
        this.infoRelease = s2;
        if(s3 == null) {
            s3 = "UNAVAILABLE";
        }
        this.infoTimestamp = s3;
        if(s4 == null) {
            s4 = "UNAVAILABLE";
        }
        this.infoClassloader = s4;
    }

    public static VersionInfoHC4 fromMap(String s, Map map0, ClassLoader classLoader0) {
        String s7;
        String s6;
        String s5;
        Args.notNull(s, "Package identifier");
        String s1 = null;
        if(map0 == null) {
            s6 = null;
            s7 = null;
            s5 = null;
        }
        else {
            String s2 = (String)map0.get("info.module");
            if(s2 != null && s2.length() < 1) {
                s2 = null;
            }
            String s3 = (String)map0.get("info.release");
            if(s3 != null && (s3.length() < 1 || s3.equals("${pom.version}"))) {
                s3 = null;
            }
            String s4 = (String)map0.get("info.timestamp");
            s5 = s4 == null || s4.length() >= 1 && !s4.equals("${mvn.timestamp}") ? s4 : null;
            s6 = s2;
            s7 = s3;
        }
        if(classLoader0 != null) {
            s1 = classLoader0.toString();
        }
        return new VersionInfoHC4(s, s6, s7, s5, s1);
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public static String getUserAgent(String s, String s1, Class class0) {
        VersionInfoHC4 versionInfoHC40 = VersionInfoHC4.loadVersionInfo(s1, class0.getClassLoader());
        StringBuilder stringBuilder0 = a.o(s, "/", (versionInfoHC40 == null ? "UNAVAILABLE" : versionInfoHC40.getRelease()), " (Java 1.5 minimum; Java/", "0");
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static VersionInfoHC4 loadVersionInfo(String s, ClassLoader classLoader0) {
        Properties properties0;
        InputStream inputStream0;
        Args.notNull(s, "Package identifier");
        if(classLoader0 == null) {
            classLoader0 = Thread.currentThread().getContextClassLoader();
        }
        try {
            inputStream0 = classLoader0.getResourceAsStream(s.replace('.', '/') + "/version.properties");
            if(inputStream0 != null) {
                goto label_5;
            }
        }
        catch(IOException unused_ex) {
        }
        properties0 = null;
        return properties0 == null ? null : VersionInfoHC4.fromMap(s, properties0, classLoader0);
        try {
        label_5:
            properties0 = new Properties();
            properties0.load(inputStream0);
        }
        catch(Throwable throwable0) {
            try {
                inputStream0.close();
                throw throwable0;
            }
            catch(IOException unused_ex) {
                properties0 = null;
                return properties0 == null ? null : VersionInfoHC4.fromMap(s, properties0, classLoader0);
            }
        }
        try {
            inputStream0.close();
            return properties0 == null ? null : VersionInfoHC4.fromMap(s, properties0, classLoader0);
        }
        catch(IOException unused_ex) {
        }
        return properties0 == null ? null : VersionInfoHC4.fromMap(s, properties0, classLoader0);
    }

    public static VersionInfo[] loadVersionInfo(String[] arr_s, ClassLoader classLoader0) {
        Args.notNull(arr_s, "Package identifier array");
        ArrayList arrayList0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            VersionInfoHC4 versionInfoHC40 = VersionInfoHC4.loadVersionInfo(arr_s[v], classLoader0);
            if(versionInfoHC40 != null) {
                arrayList0.add(versionInfoHC40);
            }
        }
        return (VersionInfo[])arrayList0.toArray(new VersionInfo[arrayList0.size()]);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(this.infoClassloader.length() + (this.infoTimestamp.length() + (this.infoRelease.length() + (this.infoModule.length() + (this.infoPackage.length() + 20)))));
        stringBuilder0.append("VersionInfo(");
        stringBuilder0.append(this.infoPackage);
        stringBuilder0.append(':');
        stringBuilder0.append(this.infoModule);
        if(!"UNAVAILABLE".equals(this.infoRelease)) {
            stringBuilder0.append(':');
            stringBuilder0.append(this.infoRelease);
        }
        if(!"UNAVAILABLE".equals(this.infoTimestamp)) {
            stringBuilder0.append(':');
            stringBuilder0.append(this.infoTimestamp);
        }
        stringBuilder0.append(')');
        if(!"UNAVAILABLE".equals(this.infoClassloader)) {
            stringBuilder0.append('@');
            stringBuilder0.append(this.infoClassloader);
        }
        return stringBuilder0.toString();
    }
}

