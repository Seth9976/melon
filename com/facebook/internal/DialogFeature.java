package com.facebook.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001A\u00020\u0003H&J\b\u0010\b\u001A\u00020\tH&R\u001A\u0010\u0002\u001A\u00020\u00038gX¦\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/internal/DialogFeature;", "", "name", "", "name$annotations", "()V", "()Ljava/lang/String;", "getAction", "getMinVersion", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface DialogFeature {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static void name$annotations() {
        }
    }

    @NotNull
    String getAction();

    int getMinVersion();

    @NotNull
    String name();
}

