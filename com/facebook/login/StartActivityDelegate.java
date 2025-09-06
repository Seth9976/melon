package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001A\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/facebook/login/StartActivityDelegate;", "", "Landroid/content/Intent;", "intent", "", "requestCode", "Lie/H;", "startActivityForResult", "(Landroid/content/Intent;I)V", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface StartActivityDelegate {
    @Nullable
    Activity getActivityContext();

    void startActivityForResult(@NotNull Intent arg1, int arg2);
}

