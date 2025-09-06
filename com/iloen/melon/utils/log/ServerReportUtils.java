package com.iloen.melon.utils.log;

import android.text.TextUtils;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.mcache.error.StreamIOError.CloseError;
import com.iloen.melon.mcache.error.StreamIOError.OpenError;

public class ServerReportUtils {
    public static boolean isMeaningfulErrorForFabric(MCacheError mCacheError0) {
        return !(mCacheError0 instanceof CloseError);
    }

    public static boolean isMeaningfulErrorForRedash(MCacheError mCacheError0) {
        if(mCacheError0 instanceof CloseError) {
            return false;
        }
        if(mCacheError0 instanceof OpenError) {
            String s = mCacheError0.getMessage();
            return TextUtils.isEmpty(s) || !s.contains("Failed to write the Cache meta");
        }
        return true;
    }
}

