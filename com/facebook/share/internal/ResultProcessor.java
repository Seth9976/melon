package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/facebook/share/internal/ResultProcessor;", "", "Lcom/facebook/FacebookCallback;", "appCallback", "<init>", "(Lcom/facebook/FacebookCallback;)V", "Lcom/facebook/internal/AppCall;", "appCall", "Landroid/os/Bundle;", "results", "Lie/H;", "onSuccess", "(Lcom/facebook/internal/AppCall;Landroid/os/Bundle;)V", "onCancel", "(Lcom/facebook/internal/AppCall;)V", "Lcom/facebook/FacebookException;", "error", "onError", "(Lcom/facebook/internal/AppCall;Lcom/facebook/FacebookException;)V", "Lcom/facebook/FacebookCallback;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class ResultProcessor {
    @Nullable
    private final FacebookCallback appCallback;

    public ResultProcessor(@Nullable FacebookCallback facebookCallback0) {
        this.appCallback = facebookCallback0;
    }

    public void onCancel(@NotNull AppCall appCall0) {
        q.g(appCall0, "appCall");
        FacebookCallback facebookCallback0 = this.appCallback;
        if(facebookCallback0 != null) {
            facebookCallback0.onCancel();
        }
    }

    public void onError(@NotNull AppCall appCall0, @NotNull FacebookException facebookException0) {
        q.g(appCall0, "appCall");
        q.g(facebookException0, "error");
        FacebookCallback facebookCallback0 = this.appCallback;
        if(facebookCallback0 != null) {
            facebookCallback0.onError(facebookException0);
        }
    }

    public abstract void onSuccess(@NotNull AppCall arg1, @Nullable Bundle arg2);
}

