package com.iloen.melon.mcache.util;

import A1.f;
import android.os.Build.VERSION;
import android.os.Build;
import android.text.TextUtils;
import h9.a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import k8.Y;

public class FileLog {
    private static final String TAG = "FileLog";
    private final File mFile;
    private String mFilename;
    private final int mMax;

    public FileLog(String s, String s1, String s2, boolean z, int v) {
        StringBuilder stringBuilder0 = Y.p(s);
        stringBuilder0.append("/");
        stringBuilder0.append(s1);
        if(z) {
            stringBuilder0.append("_");
            stringBuilder0.append("2025-09-06");
        }
        stringBuilder0.append(s2);
        this.mFile = new File(stringBuilder0.toString());
        this.mFilename = s1;
        this.mMax = v;
        this.createDirs();
        this.deleteEmptyFiles();
        this.deleteOldFiles();
    }

    private void createDirs() {
        File file0 = this.mFile.getParentFile();
        if(file0 != null && !file0.exists()) {
            file0.mkdirs();
        }
    }

    private void deleteEmptyFiles() {
        File file0 = this.mFile.getParentFile();
        if(file0 != null) {
            File[] arr_file = file0.listFiles();
            if(arr_file != null) {
                String s = this.mFile.getName();
                for(int v = 0; v < arr_file.length; ++v) {
                    File file1 = arr_file[v];
                    if(!file1.getName().equals(s) && file1.length() == 0L) {
                        file1.delete();
                    }
                }
            }
        }
    }

    private void deleteOldFiles() {
        File file0 = this.mFile.getParentFile();
        if(file0 != null) {
            File[] arr_file = file0.listFiles(new a(this));
            if(arr_file != null) {
                Arrays.sort(arr_file, new f(12));
                int v = this.mMax < 0 ? arr_file.length : arr_file.length - this.mMax;
                for(int v1 = 0; v1 < arr_file.length; ++v1) {
                    File file1 = arr_file[v1];
                    if(v <= 0) {
                        break;
                    }
                    file1.delete();
                    --v;
                }
            }
        }
    }

    private String getDeviceInfo() {
        return "MODEL:" + Build.MODEL + ", RELEASE:" + Build.VERSION.RELEASE;
    }

    public void write(String s, String s1) {
        this.createDirs();
        if(this.mFile.length() == 0L) {
            this.writeImpl("", this.getDeviceInfo());
        }
        this.writeImpl(s, s1);
    }

    private void writeImpl(String s, String s1) {
        if(!TextUtils.isEmpty(s1)) {
            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.o("2025-09-06 11:31:29", " ", s, " ", s1);
            stringBuilder0.append("\n");
            try {
                h9.f.c(this.mFile.getCanonicalPath(), stringBuilder0.toString());
            }
            catch(IOException unused_ex) {
            }
        }
    }
}

