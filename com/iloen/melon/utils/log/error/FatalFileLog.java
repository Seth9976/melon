package com.iloen.melon.utils.log.error;

import com.iloen.melon.utils.log.FileLog;

public class FatalFileLog extends FileLog {
    static final class FatalFileLogHolder {
        public static final FatalFileLog a;

        static {
            FatalFileLogHolder.a = new FatalFileLog("fatal", "fatal_log", ".txt", true, 10);  // 初始化器: Lcom/iloen/melon/utils/log/FileLog;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
        }
    }

    public static FatalFileLog getInstance() {
        return FatalFileLogHolder.a;
    }
}

