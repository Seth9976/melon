package com.iloen.melon.utils.cipher;

import java.io.UnsupportedEncodingException;
import security.Rijndael_Algorithm;

public class RijndaelAlgorithmUtils {
    public static String decode(String s) {
        return RijndaelAlgorithmUtils.decode(s, "euc-kr");
    }

    public static String decode(String s, String s1) {
        if(s != null && !"".equals(s)) {
            try {
                return new String(Rijndael_Algorithm.Decrypt_String(s.getBytes(), s.getBytes().length), s1).trim();
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                throw new IllegalArgumentException("Could not support a character encoding: " + s1, unsupportedEncodingException0);
            }
        }
        return null;
    }

    public static String decode(byte[] arr_b) {
        return arr_b.length == 0 ? null : new String(Rijndael_Algorithm.Decrypt_String(arr_b, arr_b.length)).trim();
    }

    public static String encode(String s) {
        return s == null || "".equals(s) ? null : new String(Rijndael_Algorithm.Encrypt_String(s.getBytes(), s.getBytes().length)).trim();
    }

    public static String encode(byte[] arr_b) {
        return arr_b.length == 0 ? null : new String(Rijndael_Algorithm.Encrypt_String(arr_b, arr_b.length)).trim();
    }
}

