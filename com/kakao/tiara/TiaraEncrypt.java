package com.kakao.tiara;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

class TiaraEncrypt {
    static enum DataType {
        IDENTIFIER,
        NON_IDENTIFIER;

    }

    private static final String CIPHER_TRANSFORMATION_ALGORITHM = "RSA/ECB/OAEPPadding";
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final String KEY_IDENTIFIER = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsduN7gOpMwuyN+YjfmfoUFd4gE7Jp+dxi0+i25soHrEiCC5W76fIRIHeGzUHI3e5vhD9kzpMqKbDFK7HtUUCAMMXj9sg64mV8blRz/yB6Ge6wWA4CKiXMpyzQXPBYngH18DA3xFjkjOj3Xe5A51AFc+DWSe9QRAPRJkxRKzeJjDK3sCodnp9OotSLsUuBX10BEzixGlFRxAsIwripp+aQIrbEtxexD+0L7LWKCD2JTala79TeyvCRrTSz64HL/zY1llrUB2xQ6v3o6fTOWnZTLBxbv/2B2M6pvtkJqO9eekjPaW+m6ba+ub3YHkkDxMUlDShqEqY2LQPebYIVMBViwIDAQAB";
    private static final String KEY_NON_IDENTIFIER = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoIlMNxDKUB0rjM1e/cM7dw7Xf/r5jyNp2iMg16IJUyYa4q7gryv85TQ08S+O1w1Ct283xVGomIEHeOockwHW0k4Yy75FlqwQJ1Z0BfV6jgx2vfLuBha1mTcs0/JDooZThQ9Gqvl8CgYsG3oD7hSOrGP84Z3kV0V3lBwJIhnq/F4Twrw+s0qBlAxv4XsrKAKMLpeu7A6dJgfTH5Ls7TS0SX+dydxRO+a/5mEd4LiqnaNF05qWipt+HMKD0FOw+8ekF8S78SGMzMF/46ufgBsdK+G+qOqqhzHkicqDRrR5INOwFP9vu9qw5aYqZxkxz/PO99N+qf5zj6j5ueJ7TXEBdwIDAQAB";
    private static final String TAG = "TiaraEncrypt";
    private static Cipher identifierCipher;
    private static final Object identifierLock;
    private static Cipher nonIdentifierCipher;
    private static final Object nonIdentifierLock;

    static {
        TiaraEncrypt.identifierLock = new Object();
        TiaraEncrypt.nonIdentifierLock = new Object();
        try {
            X509EncodedKeySpec x509EncodedKeySpec0 = new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsduN7gOpMwuyN+YjfmfoUFd4gE7Jp+dxi0+i25soHrEiCC5W76fIRIHeGzUHI3e5vhD9kzpMqKbDFK7HtUUCAMMXj9sg64mV8blRz/yB6Ge6wWA4CKiXMpyzQXPBYngH18DA3xFjkjOj3Xe5A51AFc+DWSe9QRAPRJkxRKzeJjDK3sCodnp9OotSLsUuBX10BEzixGlFRxAsIwripp+aQIrbEtxexD+0L7LWKCD2JTala79TeyvCRrTSz64HL/zY1llrUB2xQ6v3o6fTOWnZTLBxbv/2B2M6pvtkJqO9eekjPaW+m6ba+ub3YHkkDxMUlDShqEqY2LQPebYIVMBViwIDAQAB", 0));
            PublicKey publicKey0 = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec0);
            Cipher cipher0 = Cipher.getInstance("RSA/ECB/OAEPPadding");
            TiaraEncrypt.identifierCipher = cipher0;
            cipher0.init(1, publicKey0);
            X509EncodedKeySpec x509EncodedKeySpec1 = new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoIlMNxDKUB0rjM1e/cM7dw7Xf/r5jyNp2iMg16IJUyYa4q7gryv85TQ08S+O1w1Ct283xVGomIEHeOockwHW0k4Yy75FlqwQJ1Z0BfV6jgx2vfLuBha1mTcs0/JDooZThQ9Gqvl8CgYsG3oD7hSOrGP84Z3kV0V3lBwJIhnq/F4Twrw+s0qBlAxv4XsrKAKMLpeu7A6dJgfTH5Ls7TS0SX+dydxRO+a/5mEd4LiqnaNF05qWipt+HMKD0FOw+8ekF8S78SGMzMF/46ufgBsdK+G+qOqqhzHkicqDRrR5INOwFP9vu9qw5aYqZxkxz/PO99N+qf5zj6j5ueJ7TXEBdwIDAQAB", 0));
            PublicKey publicKey1 = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec1);
            Cipher cipher1 = Cipher.getInstance("RSA/ECB/OAEPPadding");
            TiaraEncrypt.nonIdentifierCipher = cipher1;
            cipher1.init(1, publicKey1);
        }
        catch(Exception exception0) {
            Logger.error("TiaraEncrypt", exception0.toString(), new Object[0]);
        }
    }

    public static String encrypt(String s, DataType tiaraEncrypt$DataType0) {
        byte[] arr_b;
        try {
            if(tiaraEncrypt$DataType0 == DataType.IDENTIFIER) {
                synchronized(TiaraEncrypt.identifierLock) {
                    arr_b = TiaraEncrypt.identifierCipher.doFinal(s.getBytes());
                }
                return Base64.encodeToString(arr_b, 2);
            }
            synchronized(TiaraEncrypt.nonIdentifierLock) {
                arr_b = TiaraEncrypt.nonIdentifierCipher.doFinal(s.getBytes());
            }
            return Base64.encodeToString(arr_b, 2);
        }
        catch(Exception exception0) {
            Logger.error("TiaraEncrypt", exception0.toString(), new Object[0]);
            return null;
        }
    }
}

