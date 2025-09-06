package com.melon.net.res.v3;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000F\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/melon/net/res/v3/AttachUploadErrorCode;", "", "<init>", "()V", "SUCCESS", "", "SERVER_FILE_SIZE_ERROR", "HTML_FILE_SIZE_ERROR", "PARTIAL_UPLOAD_ERROR", "TRANSFER_ERROR", "TEMP_FOLDER_ERROR", "IO_ERROR", "INTERRUPT_BY_EXTENSION_ERROR", "UPLOADING_ERROR", "FILE_SIZE_EXCEED_ERROR", "AUTH_FAIL_ERROR", "NO_AUTH_KEY_ERROR", "OVERWRITE_PARAM_ERROR", "UPLOAD_FILE_PARAM_ERROR", "NOT_POST_METHOD_ERROR", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AttachUploadErrorCode {
    public static final int $stable = 0;
    public static final int AUTH_FAIL_ERROR = 94;
    public static final int FILE_SIZE_EXCEED_ERROR = 91;
    public static final int HTML_FILE_SIZE_ERROR = 2;
    @NotNull
    public static final AttachUploadErrorCode INSTANCE = null;
    public static final int INTERRUPT_BY_EXTENSION_ERROR = 8;
    public static final int IO_ERROR = 7;
    public static final int NOT_POST_METHOD_ERROR = 99;
    public static final int NO_AUTH_KEY_ERROR = 0x5F;
    public static final int OVERWRITE_PARAM_ERROR = 0x60;
    public static final int PARTIAL_UPLOAD_ERROR = 3;
    public static final int SERVER_FILE_SIZE_ERROR = 1;
    public static final int SUCCESS = 0;
    public static final int TEMP_FOLDER_ERROR = 6;
    public static final int TRANSFER_ERROR = 4;
    public static final int UPLOADING_ERROR = 9;
    public static final int UPLOAD_FILE_PARAM_ERROR = 98;

    static {
        AttachUploadErrorCode.INSTANCE = new AttachUploadErrorCode();
    }
}

