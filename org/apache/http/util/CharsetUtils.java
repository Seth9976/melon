package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtils {
    public static Charset get(String s) {
        if(s == null) {
            return null;
        }
        try {
            return Charset.forName(s);
        }
        catch(UnsupportedCharsetException unused_ex) {
            throw new UnsupportedEncodingException(s);
        }
    }

    public static Charset lookup(String s) {
        if(s == null) {
            return null;
        }
        try {
            return Charset.forName(s);
        }
        catch(UnsupportedCharsetException unused_ex) {
            return null;
        }
    }
}

