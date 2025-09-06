package com.iloen.melon.mcache.error;

import android.text.TextUtils;

public class StorageError extends ErrorBase {
    public static class CacheFileError extends StorageError {
        public CacheFileError(String s, String s1) {
            super(s, (TextUtils.isEmpty(s1) ? "This error can be caused by permission or invalid path." : "This error can be caused by permission or invalid path.\n" + s1));
        }

        @Override  // com.iloen.melon.mcache.error.StorageError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StorageError", this.getClass().getSimpleName());
        }
    }

    public static class PathError extends StorageError {
        public PathError(String s, String s1) {
            super(s, (TextUtils.isEmpty(s1) ? "This error can be caused by permission or invalid path." : "This error can be caused by permission or invalid path.\n" + s1));
        }

        @Override  // com.iloen.melon.mcache.error.StorageError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StorageError", this.getClass().getSimpleName());
        }
    }

    public static final String TAG = "StorageError";
    private static final String prefix = "This error can be caused by permission or invalid path.";

    public StorageError(String s, String s1) {
        super(s, s1);
    }

    @Override  // com.iloen.melon.mcache.error.ErrorBase
    public String getCallerTag() {
        return "StorageError";
    }
}

