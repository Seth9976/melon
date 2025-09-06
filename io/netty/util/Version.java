package io.netty.util;

import androidx.appcompat.app.o;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import jeb.synthetic.TWR;

public final class Version {
    private static final String PROP_BUILD_DATE = ".buildDate";
    private static final String PROP_COMMIT_DATE = ".commitDate";
    private static final String PROP_LONG_COMMIT_HASH = ".longCommitHash";
    private static final String PROP_REPO_STATUS = ".repoStatus";
    private static final String PROP_SHORT_COMMIT_HASH = ".shortCommitHash";
    private static final String PROP_VERSION = ".version";
    private final String artifactId;
    private final String artifactVersion;
    private final long buildTimeMillis;
    private final long commitTimeMillis;
    private final String longCommitHash;
    private final String repositoryStatus;
    private final String shortCommitHash;

    private Version(String s, String s1, long v, long v1, String s2, String s3, String s4) {
        this.artifactId = s;
        this.artifactVersion = s1;
        this.buildTimeMillis = v;
        this.commitTimeMillis = v1;
        this.shortCommitHash = s2;
        this.longCommitHash = s3;
        this.repositoryStatus = s4;
    }

    public String artifactId() {
        return this.artifactId;
    }

    public String artifactVersion() {
        return this.artifactVersion;
    }

    public long buildTimeMillis() {
        return this.buildTimeMillis;
    }

    public long commitTimeMillis() {
        return this.commitTimeMillis;
    }

    public static Map identify() {
        return Version.identify(null);
    }

    public static Map identify(ClassLoader classLoader0) {
        ClassLoader classLoader1 = classLoader0 == null ? PlatformDependent.getContextClassLoader() : classLoader0;
        Properties properties0 = new Properties();
        try {
            Enumeration enumeration0 = classLoader1.getResources("META-INF/io.netty.versions.properties");
            while(enumeration0.hasMoreElements()) {
                InputStream inputStream0 = ((URL)enumeration0.nextElement()).openStream();
                TWR.declareResource(inputStream0);
                TWR.useResource$NT(inputStream0);
                properties0.load(inputStream0);
            }
        }
        catch(Exception unused_ex) {
        }
        HashSet hashSet0 = new HashSet();
        for(Object object0: properties0.keySet()) {
            String s = (String)object0;
            int v = s.indexOf(46);
            if(v > 0) {
                String s1 = s.substring(0, v);
                if(properties0.containsKey(s1 + ".version") && properties0.containsKey(s1 + ".buildDate") && properties0.containsKey(s1 + ".commitDate") && properties0.containsKey(s1 + ".shortCommitHash") && properties0.containsKey(s1 + ".longCommitHash") && properties0.containsKey(s1 + ".repoStatus")) {
                    hashSet0.add(s1);
                }
            }
        }
        Map map0 = new TreeMap();
        for(Object object1: hashSet0) {
            ((TreeMap)map0).put(((String)object1), new Version(((String)object1), properties0.getProperty(((String)object1) + ".version"), Version.parseIso8601(properties0.getProperty(((String)object1) + ".buildDate")), Version.parseIso8601(properties0.getProperty(((String)object1) + ".commitDate")), properties0.getProperty(((String)object1) + ".shortCommitHash"), properties0.getProperty(((String)object1) + ".longCommitHash"), properties0.getProperty(((String)object1) + ".repoStatus")));
        }
        return map0;
    }

    public String longCommitHash() {
        return this.longCommitHash;
    }

    public static void main(String[] arr_s) {
        for(Object object0: Version.identify().values()) {
            System.err.println(((Version)object0));
        }
    }

    private static long parseIso8601(String s) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(s).getTime();
        }
        catch(ParseException unused_ex) {
            return 0L;
        }
    }

    public String repositoryStatus() {
        return this.repositoryStatus;
    }

    public String shortCommitHash() {
        return this.shortCommitHash;
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return this.artifactId + '-' + this.artifactVersion + '.' + this.shortCommitHash + ("clean".equals(this.repositoryStatus) ? "" : o.r(new StringBuilder(" (repository: "), this.repositoryStatus, ')'));
    }
}

