package com.android.volley;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class InternalUtils {
    private static final char[] HEX_CHARS;

    static {
        InternalUtils.HEX_CHARS = "0123456789ABCDEF".toCharArray();
    }

    private static String convertToHex(byte[] arr_b) {
        char[] arr_c = new char[arr_b.length * 2];
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            arr_c[v * 2] = InternalUtils.HEX_CHARS[(v1 & 0xFF) >>> 4];
            arr_c[v * 2 + 1] = InternalUtils.HEX_CHARS[v1 & 15];
        }
        return new String(arr_c);
    }

    public static String sha1Hash(String s) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-1");
            byte[] arr_b = s.getBytes("UTF-8");
            messageDigest0.update(arr_b, 0, arr_b.length);
            return InternalUtils.convertToHex(messageDigest0.digest());
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            noSuchAlgorithmException0.printStackTrace();
            return null;
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
            return null;
        }
    }
}

