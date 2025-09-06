package org.apache.http.util;

public final class TextUtils {
    public static boolean isBlank(CharSequence charSequence0) {
        if(charSequence0 == null) {
            return true;
        }
        for(int v = 0; v < charSequence0.length(); ++v) {
            if(!Character.isWhitespace(charSequence0.charAt(v))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence0) {
        return charSequence0 == null ? true : charSequence0.length() == 0;
    }
}

