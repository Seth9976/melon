package e7;

import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Debug;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public abstract class f {
    public static final char[] a;

    static {
        f.a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static long a(Context context0) {
        synchronized(f.class) {
            ActivityManager.MemoryInfo activityManager$MemoryInfo0 = new ActivityManager.MemoryInfo();
            ((ActivityManager)context0.getSystemService("activity")).getMemoryInfo(activityManager$MemoryInfo0);
            return activityManager$MemoryInfo0.totalMem;
        }
    }

    public static void b(Closeable closeable0, String s) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException iOException0) {
                Log.e("FirebaseCrashlytics", s, iOException0);
            }
        }
    }

    public static int c() {
        int v = f.f();
        if(f.g()) {
            v |= 2;
        }
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger() ? v | 4 : v;
    }

    public static int d(Context context0, String s, String s1) {
        String s2;
        Resources resources0 = context0.getResources();
        int v = context0.getApplicationContext().getApplicationInfo().icon;
        if(v > 0) {
            try {
                s2 = context0.getResources().getResourcePackageName(v);
                return "android".equals(s2) ? resources0.getIdentifier(s, s1, "com.iloen.melon") : resources0.getIdentifier(s, s1, s2);
            }
            catch(Resources.NotFoundException unused_ex) {
                return resources0.getIdentifier(s, s1, "com.iloen.melon");
            }
            return resources0.getIdentifier(s, s1, "com.iloen.melon");
        }
        else {
            s2 = "com.iloen.melon";
        }
        return resources0.getIdentifier(s, s1, s2);
    }

    public static String e(byte[] arr_b) {
        char[] arr_c = new char[arr_b.length * 2];
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            arr_c[v * 2] = f.a[(v1 & 0xFF) >>> 4];
            arr_c[v * 2 + 1] = f.a[v1 & 15];
        }
        return new String(arr_c);
    }

    // 去混淆评级： 低(30)
    public static boolean f() {
        return Build.PRODUCT.contains("sdk") || (Build.HARDWARE.contains("goldfish") || Build.HARDWARE.contains("ranchu"));
    }

    public static boolean g() {
        boolean z = f.f();
        if(!z && Build.TAGS != null && Build.TAGS.contains("test-keys")) {
            return true;
        }
        return new File("/system/app/Superuser.apk").exists() ? true : !z && new File("/system/xbin/su").exists();
    }

    public static String h(String s) {
        MessageDigest messageDigest0;
        byte[] arr_b = s.getBytes();
        try {
            messageDigest0 = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            Log.e("FirebaseCrashlytics", "Could not create hashing algorithm: SHA-1, returning empty string.", noSuchAlgorithmException0);
            return "";
        }
        messageDigest0.update(arr_b);
        return f.e(messageDigest0.digest());
    }

    public static String i(FileInputStream fileInputStream0) {
        try(Scanner scanner0 = new Scanner(fileInputStream0).useDelimiter("\\A")) {
            return scanner0.hasNext() ? scanner0.next() : "";
        }
    }
}

