package com.digicap.melon.log;

import U4.x;
import android.util.Log;
import java.io.File;

public class DigicapLog {
    public static DigicapLog a;

    public void D(String s) {
    }

    public void E(String s) {
        if(s == null) {
            return;
        }
        StringBuilder stringBuilder0 = x.p(s, "||Class:");
        stringBuilder0.append("com.digicap.melon.log.DigicapLog");
        stringBuilder0.append("||Function:");
        stringBuilder0.append(new Throwable().getStackTrace()[1].getFileName());
        stringBuilder0.append("||Line:");
        stringBuilder0.append(new Throwable().getStackTrace()[1].getLineNumber());
        Log.e("MelOnDRM", stringBuilder0.toString());
    }

    public void EXCEPTION(String s) {
        if(s == null) {
            return;
        }
        Log.e("MelOnDRM", s);
    }

    public void I(String s) {
        if(s == null) {
            return;
        }
        Log.i("MelOnDRM", s);
    }

    public void W(String s) {
    }

    public boolean debuggable() {
        return false;
    }

    @Override
    public void finalize() {
        try {
            super.finalize();
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
    }

    public static DigicapLog getInstance() {
        synchronized(DigicapLog.class) {
            if(DigicapLog.a == null) {
                DigicapLog digicapLog0 = new DigicapLog();  // 初始化器: Ljava/lang/Object;-><init>()V
                File file0 = new File("/sdcard///MelOnDRMLog.txt");
                if(file0.exists()) {
                    file0.delete();
                }
                DigicapLog.a = digicapLog0;
            }
            return DigicapLog.a;
        }
    }
}

