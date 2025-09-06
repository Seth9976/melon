package com.iloen.melon.utils.log.error;

import com.iloen.melon.utils.log.FileLog;

public class OomeFileLog extends FileLog {
    static final class OomeFileLogHolder {
        public static final OomeFileLog a;

        static {
            OomeFileLogHolder.a = new OomeFileLog("oom", "oom_log", ".txt", true, 5);  // 初始化器: Lcom/iloen/melon/utils/log/FileLog;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
        }
    }

    public static OomeFileLog getInstance() {
        return OomeFileLogHolder.a;
    }
}

