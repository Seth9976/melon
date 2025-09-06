package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;
import l.a;
import pc.t;
import w4.c;

public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        PackageInfo packageInfo0;
        if(intent0 != null) {
            String s = intent0.getAction();
            if("androidx.profileinstaller.action.INSTALL_PROFILE".equals(s)) {
                c.t(context0, new a(1), new t(this, 29), true);
                return;
            }
            if("androidx.profileinstaller.action.SKIP_FILE".equals(s)) {
                Bundle bundle0 = intent0.getExtras();
                if(bundle0 != null) {
                    String s1 = bundle0.getString("EXTRA_SKIP_FILE_OPERATION");
                    if("WRITE_SKIP_FILE".equals(s1)) {
                        t t0 = new t(this, 29);
                        PackageManager packageManager0 = context0.getPackageManager();
                        try {
                            packageInfo0 = packageManager0.getPackageInfo("com.iloen.melon", 0);
                        }
                        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                            t0.f(7, packageManager$NameNotFoundException0);
                            return;
                        }
                        c.e(packageInfo0, context0.getFilesDir());
                        t0.f(10, null);
                        return;
                    }
                    if("DELETE_SKIP_FILE".equals(s1)) {
                        new File(context0.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        this.setResultCode(11);
                    }
                }
            }
            else {
                if("androidx.profileinstaller.action.SAVE_PROFILE".equals(s)) {
                    Process.sendSignal(Process.myPid(), 10);
                    Log.d("ProfileInstaller", "");
                    this.setResultCode(12);
                    return;
                }
                if("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(s)) {
                    Bundle bundle1 = intent0.getExtras();
                    if(bundle1 != null) {
                        String s2 = bundle1.getString("EXTRA_BENCHMARK_OPERATION");
                        t t1 = new t(this, 29);
                        if("DROP_SHADER_CACHE".equals(s2)) {
                            if(c.c((Build.VERSION.SDK_INT < 34 ? context0.createDeviceProtectedStorageContext().getCodeCacheDir() : context0.createDeviceProtectedStorageContext().getCacheDir()))) {
                                t1.f(14, null);
                                return;
                            }
                            t1.f(15, null);
                            return;
                        }
                        if("SAVE_PROFILE".equals(s2)) {
                            Process.sendSignal(bundle1.getInt("EXTRA_PID", Process.myPid()), 10);
                            t1.f(12, null);
                            return;
                        }
                        t1.f(16, null);
                    }
                }
            }
        }
    }
}

