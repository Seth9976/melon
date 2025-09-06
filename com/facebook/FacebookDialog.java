package com.facebook;

import f.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000F\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\rH&¢\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u000F\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0012\u001A\u00020\u0011H&¢\u0006\u0004\b\u000F\u0010\u0013J%\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\f\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/FacebookDialog;", "CONTENT", "RESULT", "", "content", "", "canShow", "(Ljava/lang/Object;)Z", "Lie/H;", "show", "(Ljava/lang/Object;)V", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallback", "(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V", "", "requestCode", "(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;I)V", "Lf/b;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createActivityResultContractForShowingDialog", "(Lcom/facebook/CallbackManager;)Lf/b;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface FacebookDialog {
    boolean canShow(Object arg1);

    @NotNull
    b createActivityResultContractForShowingDialog(@Nullable CallbackManager arg1);

    void registerCallback(@NotNull CallbackManager arg1, @NotNull FacebookCallback arg2);

    void registerCallback(@NotNull CallbackManager arg1, @NotNull FacebookCallback arg2, int arg3);

    void show(Object arg1);
}

