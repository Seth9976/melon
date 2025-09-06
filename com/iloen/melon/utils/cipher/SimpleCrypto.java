package com.iloen.melon.utils.cipher;

import android.util.Base64;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.DeviceIdentifier;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import x9.b;

public class SimpleCrypto {
    public static byte[] a;

    public static String decrypt(String s) {
        try {
            return new String(new b(SimpleCrypto.getSecretKey()).i(Base64.decode(s, 0), new byte[]{99, 0x6F, 109, 46, 105, 108, 0x6F, 101, 110, 46, 109, 101, 108, 0x6F, 110}), StandardCharsets.UTF_8);
        }
        catch(Exception exception0) {
            H0.b.v(exception0, new StringBuilder("decrypt() "), "SimpleCrypto");
            return "";
        }
    }

    @Deprecated
    public static String decrypt(String s, String s1) {
        byte[] arr_b = InsecureSHA1PRNGKeyDerivator.deriveInsecureKey(s.getBytes(), 0x20);
        byte[] arr_b1 = SimpleCrypto.toByte(s1);
        SecretKeySpec secretKeySpec0 = new SecretKeySpec(arr_b, "AES");
        Cipher cipher0 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher0.init(2, secretKeySpec0);
        return new String(cipher0.doFinal(arr_b1));
    }

    public static byte[] decrypt(byte[] arr_b) {
        try {
            return new b(SimpleCrypto.getSecretKey()).i(arr_b, new byte[]{99, 0x6F, 109, 46, 105, 108, 0x6F, 101, 110, 46, 109, 101, 108, 0x6F, 110});
        }
        catch(Exception exception0) {
            H0.b.v(exception0, new StringBuilder("decrypt() "), "SimpleCrypto");
            return new byte[0];
        }
    }

    public static String encrypt(String s) {
        try {
            return Base64.encodeToString(new b(SimpleCrypto.getSecretKey()).l(s.getBytes(), new byte[]{99, 0x6F, 109, 46, 105, 108, 0x6F, 101, 110, 46, 109, 101, 108, 0x6F, 110}), 0);
        }
        catch(Exception exception0) {
            H0.b.v(exception0, new StringBuilder("encrypt() "), "SimpleCrypto");
            return "";
        }
    }

    public static byte[] encrypt(byte[] arr_b) {
        try {
            return new b(SimpleCrypto.getSecretKey()).l(arr_b, new byte[]{99, 0x6F, 109, 46, 105, 108, 0x6F, 101, 110, 46, 109, 101, 108, 0x6F, 110});
        }
        catch(Exception exception0) {
            H0.b.v(exception0, new StringBuilder("encrypt() "), "SimpleCrypto");
            return new byte[0];
        }
    }

    public String fromHex(String s) {
        return new String(SimpleCrypto.toByte(s));
    }

    public static byte[] getAAD() [...] // 潜在的解密器

    public static byte[] getSecretKey() {
        byte[] arr_b = SimpleCrypto.a;
        if(arr_b != null && arr_b.length > 0) {
            return arr_b;
        }
        byte[] arr_b1 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(("com.iloen.melon" + DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a)).toCharArray(), new byte[]{99, 0x6F, 109, 46, 105, 108, 0x6F, 101, 110, 46, 109, 101, 108, 0x6F, 110}, 0x400, 0x100)).getEncoded();
        SimpleCrypto.a = arr_b1;
        return arr_b1;
    }

    public static byte[] toByte(String s) [...] // 潜在的解密器

    public static String toHex(byte[] arr_b) {
        if(arr_b == null) {
            return "";
        }
        StringBuffer stringBuffer0 = new StringBuffer(arr_b.length * 2);
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            stringBuffer0.append("0123456789ABCDEF".charAt(v1 >> 4 & 15));
            stringBuffer0.append("0123456789ABCDEF".charAt(v1 & 15));
        }
        return stringBuffer0.toString();
    }

    public String toHex(String s) {
        return SimpleCrypto.toHex(s.getBytes());
    }
}

