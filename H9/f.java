package h9;

import android.text.TextUtils;
import android.util.Log;
import com.iloen.melon.custom.S0;
import com.iloen.melon.mcache.util.FileLog;
import f9.q;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class f {
    public static FileLog a;
    public static final S0 b;

    static {
        f.b = new S0(19, false);
    }

    public static File a(String s) {
        if(TextUtils.isEmpty(s)) {
            f.h("createNewFile() - invalid filename");
            return null;
        }
        File file0 = new File(s);
        try {
            file0.createNewFile();
        }
        catch(IOException unused_ex) {
        }
        return file0;
    }

    // 去混淆评级： 低(30)
    public static void b(String s, String s1) {
    }

    public static void c(String s, String s1) {
        BufferedOutputStream bufferedOutputStream1;
        BufferedOutputStream bufferedOutputStream0;
        if(s1 != null) {
            try {
                bufferedOutputStream0 = null;
                File file0 = f.a(s);
                if(file0 == null) {
                    f.h("writeOnFile() fail to create file");
                    return;
                }
                bufferedOutputStream1 = new BufferedOutputStream(new FileOutputStream(file0, true), 0x19000);
            }
            catch(IOException iOException0) {
                goto label_31;
            }
            catch(SecurityException securityException0) {
                goto label_34;
            }
            catch(Exception exception0) {
                goto label_37;
            }
            catch(Throwable throwable0) {
                goto label_41;
            }
            try {
                bufferedOutputStream1.write(s1.getBytes("utf-8"));
                bufferedOutputStream1.flush();
            }
            catch(IOException iOException0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                goto label_31;
            }
            catch(SecurityException securityException0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                goto label_34;
            }
            catch(Exception exception0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                goto label_37;
            }
            catch(Throwable throwable0) {
                goto label_42;
            }
            try {
                bufferedOutputStream1.close();
                return;
            }
            catch(IOException unused_ex) {
            }
        }
        try {
            while(true) {
                do {
                    do {
                        return;
                        try {
                            goto label_41;
                        }
                        catch(IOException iOException0) {
                        }
                        catch(SecurityException securityException0) {
                            goto label_34;
                        }
                        catch(Exception exception0) {
                            goto label_37;
                        }
                    label_31:
                        f.h(("writeOnFile() " + iOException0));
                    }
                    while(bufferedOutputStream0 == null);
                    break;
                label_34:
                    f.h(("writeOnFile() " + securityException0));
                }
                while(bufferedOutputStream0 == null);
                break;
            label_37:
                f.h(("writeOnFile() " + exception0));
                if(bufferedOutputStream0 == null) {
                    return;
                }
                break;
            }
        }
        catch(Throwable throwable0) {
            goto label_41;
        }
        try {
            bufferedOutputStream0.close();
        }
        catch(IOException unused_ex) {
        }
        return;
    label_41:
        bufferedOutputStream1 = bufferedOutputStream0;
    label_42:
        if(bufferedOutputStream1 != null) {
            try {
                bufferedOutputStream1.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
    }

    // 去混淆评级： 低(30)
    public static void d(String s, String s1) {
    }

    public static long e(String s) {
        File file0 = new File(s);
        return file0.exists() ? file0.length() : 0L;
    }

    // 去混淆评级： 低(30)
    public static void f(String s, String s1) {
    }

    public static void g(String s, String s1) {
        Throwable throwable1;
        Class class0 = f.class;
        __monitor_enter(class0);
        try {
            if(q.d) {
                try {
                    String s2 = q.b;
                    if(f.a == null && !TextUtils.isEmpty(s2)) {
                        f.a = new FileLog(s2 + "/log", "mcache", ".txt", true, 5);
                    }
                    if(f.a != null && new File(s2).exists()) {
                        f.a.write(s, s1);
                        goto label_13;
                    }
                }
                catch(Exception unused_ex) {
                }
                goto label_15;
            label_11:
                __monitor_exit(class0);
                throw throwable1;
            }
            goto label_15;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_11;
        }
        throw throwable1;
    label_13:
        __monitor_exit(class0);
        return;
    label_15:
        __monitor_exit(class0);
    }

    public static void h(String s) {
        if(q.a() && q.e <= 3) {
            f.i("FileUtils", s);
        }
    }

    public static void i(String s, String s1) {
        Log.w(("MCACHE-" + s), s1);
    }

    public static void j(String s, String s1) {
        if(q.a() && q.e <= 3) {
            f.i(s, s1);
            f.g(s, s1);
        }
    }
}

