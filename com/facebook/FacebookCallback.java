package com.facebook;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/facebook/FacebookCallback;", "RESULT", "", "result", "Lie/H;", "onSuccess", "(Ljava/lang/Object;)V", "onCancel", "()V", "Lcom/facebook/FacebookException;", "error", "onError", "(Lcom/facebook/FacebookException;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface FacebookCallback {
    void onCancel();

    void onError(@NotNull FacebookException arg1);

    void onSuccess(Object arg1);
}

