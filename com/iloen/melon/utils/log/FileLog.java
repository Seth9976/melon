package com.iloen.melon.utils.log;

import A7.d;
import Td.b;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.system.AppUtils;
import com.melon.utils.system.DeviceData;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileLog {
    public static final String DIR_NAME = "log";
    public final String a;
    public final int b;
    protected final File mFile;

    public FileLog(String s, String s1, String s2, boolean z, int v) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(FileLog.getPath());
        d.u(stringBuilder0, "/", s, "/", s1);
        if(z) {
            stringBuilder0.append("_");
            stringBuilder0.append("2025-09-06");
        }
        stringBuilder0.append(s2);
        File file0 = new File(stringBuilder0.toString());
        this.mFile = file0;
        this.a = s1;
        this.b = v;
        this.createDirs();
        File file1 = file0.getParentFile();
        if(file1 != null) {
            File[] arr_file = file1.listFiles();
            if(arr_file != null) {
                String s3 = file0.getName();
                for(int v2 = 0; v2 < arr_file.length; ++v2) {
                    File file2 = arr_file[v2];
                    if(!file2.getName().equals(s3) && file2.length() == 0L) {
                        file2.delete();
                    }
                }
            }
        }
        File file3 = this.mFile.getParentFile();
        if(file3 != null) {
            File[] arr_file1 = file3.listFiles(new FileLog.1(this));
            if(arr_file1 != null) {
                Arrays.sort(arr_file1, new FileLog.2());  // 初始化器: Ljava/lang/Object;-><init>()V
                int v3 = this.b;
                int v4 = arr_file1.length;
                if(v3 >= 0) {
                    v4 -= v3;
                }
                for(int v1 = 0; v1 < arr_file1.length; ++v1) {
                    File file4 = arr_file1[v1];
                    if(v4 <= 0) {
                        break;
                    }
                    file4.delete();
                    --v4;
                }
            }
        }
    }

    public final void a(String s, String s1) {
        if(!TextUtils.isEmpty(s1)) {
            StringBuilder stringBuilder0 = a.o("2025-09-06 11:33:31", " ", s, " ", s1);
            stringBuilder0.append("\n");
            try {
                FileUtils.writeOnFile(this.mFile.getCanonicalPath(), stringBuilder0.toString(), false, true);
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public void checkPermissionAndWriteImpl(String s, String s1) {
        if(b.e(MelonAppBase.instance.getContext(), "android.permission.READ_MEDIA_AUDIO")) {
            this.createDirs();
            if(this.mFile.length() == 0L) {
                this.a("", this.getDeviceInfo());
            }
            this.a(s, s1);
        }
    }

    public void createDirs() {
        File file0 = this.mFile.getParentFile();
        if(file0 != null && !file0.exists()) {
            file0.mkdirs();
        }
    }

    public String getDeviceInfo() {
        Context context0 = MelonAppBase.instance.getContext();
        if(context0 == null) {
            return "";
        }
        MelonAppBase.instance.getDeviceData().getClass();
        return "MODEL:" + Build.MODEL + ", RELEASE:" + Build.VERSION.RELEASE + ", APPVER:" + AppUtils.getVersionName(context0) + ", DRM:" + DeviceData.d().a + ", SKT:" + MelonAppBase.instance.getDeviceData().f().a;
    }

    public static String getPath() {
        String s = FileUtils.getExternalAppDirLogPath();
        return TextUtils.isEmpty(s) ? "/storage/emulated/0/Android/data/com.iloen.melon/files/log" : s;
    }

    public void write(String s, String s1) {
        this.checkPermissionAndWriteImpl(s, s1);
    }
}

