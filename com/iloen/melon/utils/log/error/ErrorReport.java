package com.iloen.melon.utils.log.error;

import com.iloen.melon.utils.log.FileLog;
import java.io.File;
import java.io.IOException;

public class ErrorReport {
    public static final File a;

    static {
        ErrorReport.a = new File(FileLog.getPath() + "/__ERROR_REPORT__");
    }

    public static boolean isUseErrorReport() {
        synchronized(ErrorReport.class) {
            return ErrorReport.a.exists();
        }
    }

    public static boolean setUseErrorReport(boolean z) {
        boolean z1 = true;
        synchronized(ErrorReport.class) {
            if(z) {
                File file0 = ErrorReport.a;
                if(!file0.exists()) {
                    File file1 = file0.getParentFile();
                    if(file1 != null && !file1.exists()) {
                        z1 = file1.mkdirs();
                    }
                    if(z1) {
                        try {
                            z1 = file0.createNewFile();
                        }
                        catch(IOException unused_ex) {
                            z1 = false;
                        }
                    }
                }
            }
            else {
                File file2 = ErrorReport.a;
                if(file2.exists()) {
                    z1 = file2.delete();
                }
            }
            return z1;
        }
    }
}

