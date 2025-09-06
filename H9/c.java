package h9;

import android.util.Base64;
import com.iloen.melon.mcache.error.NetworkError.PortError;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c {
    public static final AtomicInteger a;

    static {
        c.a = new AtomicInteger(new Random(System.currentTimeMillis()).nextInt(40000) + 10000);
    }

    public static int a() {
        int v;
        IOException iOException1;
        ServerSocket serverSocket1;
        ServerSocket serverSocket0 = null;
        try {
            serverSocket1 = null;
            serverSocket1 = new ServerSocket(0);
        }
        catch(IOException iOException0) {
            iOException1 = iOException0;
            throw new PortError("CacheServerUtils", "Can\'t get an available port.\n" + iOException1.getMessage());
        }
        catch(Throwable throwable0) {
            goto label_16;
        }
        try {
            try {
                v = serverSocket1.getLocalPort();
                goto label_19;
            }
            catch(IOException iOException1) {
            }
            throw new PortError("CacheServerUtils", "Can\'t get an available port.\n" + iOException1.getMessage());
        }
        catch(Throwable throwable1) {
            throwable0 = throwable1;
            serverSocket0 = serverSocket1;
        }
    label_16:
        if(serverSocket0 != null) {
            try {
                serverSocket0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
        try {
        label_19:
            serverSocket1.close();
        }
        catch(IOException unused_ex) {
        }
        return v;
    }

    public static String b(String s) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("MD5").digest(s.getBytes()), 11);
        }
        catch(NoSuchAlgorithmException unused_ex) {
            try {
                return URLEncoder.encode(s.replaceAll("://|[^\\d\\w]", "_"), "utf-8");
            }
            catch(UnsupportedEncodingException unused_ex) {
                throw new IllegalStateException();
            }
        }
        catch(NullPointerException nullPointerException0) {
            f.d("CacheServerUtils", "makeSafeFileNameByMD5() - Err: " + nullPointerException0.toString());
            return null;
        }
    }

    public static boolean c(int v) {
        DatagramSocket datagramSocket0;
        ServerSocket serverSocket0;
        if(v < 0x400 || v > 0xFFFF) {
            new PortError("CacheServerUtils", "Port number is out of range: " + v);
        }
        try {
            serverSocket0 = null;
            serverSocket0 = new ServerSocket(v);
        }
        catch(IOException unused_ex) {
            datagramSocket0 = null;
            goto label_18;
        }
        catch(Throwable throwable0) {
            datagramSocket0 = null;
            goto label_24;
        }
        try {
            serverSocket0.setReuseAddress(true);
            datagramSocket0 = null;
            datagramSocket0 = new DatagramSocket(v);
            goto label_16;
        }
        catch(IOException unused_ex) {
            datagramSocket0 = null;
            goto label_18;
            try {
            label_16:
                datagramSocket0.setReuseAddress(true);
                goto label_29;
            }
            catch(IOException unused_ex) {
            }
            catch(Throwable throwable0) {
                goto label_24;
            }
        label_18:
            if(serverSocket0 != null) {
                serverSocket0.close();
            }
            if(datagramSocket0 != null) {
                datagramSocket0.close();
            }
            return false;
        }
        catch(Throwable throwable0) {
        }
    label_24:
        if(serverSocket0 != null) {
            serverSocket0.close();
        }
        if(datagramSocket0 != null) {
            datagramSocket0.close();
        }
        throw throwable0;
    label_29:
        serverSocket0.close();
        datagramSocket0.close();
        return true;
    }
}

