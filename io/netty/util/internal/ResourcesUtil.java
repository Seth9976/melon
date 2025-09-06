package io.netty.util.internal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class ResourcesUtil {
    public static File getFile(Class class0, String s) {
        try {
            return new File(URLDecoder.decode(class0.getResource(s).getFile(), "UTF-8"));
        }
        catch(UnsupportedEncodingException unused_ex) {
            return new File(class0.getResource(s).getFile());
        }
    }
}

