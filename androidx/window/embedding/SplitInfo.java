package androidx.window.embedding;

import Ce.g;
import android.app.Activity;
import android.os.IBinder;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.SplitInfo.Token;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\'\b\u0011\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tB\'\b\u0011\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\fB\u001F\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\rB3\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000EJ\u0011\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0086\u0002J\u0013\u0010\u001A\u001A\u00020\u00172\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u001C\u001A\u00020\u000BH\u0001¢\u0006\u0002\b\u001DJ\r\u0010\u001E\u001A\u00020\bH\u0001¢\u0006\u0002\b\u001FJ\b\u0010 \u001A\u00020!H\u0016J\b\u0010\"\u001A\u00020#H\u0016R\u0018\u0010\n\u001A\u0004\u0018\u00010\u000B8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/window/embedding/SplitInfo;", "", "primaryActivityStack", "Landroidx/window/embedding/ActivityStack;", "secondaryActivityStack", "splitAttributes", "Landroidx/window/embedding/SplitAttributes;", "token", "Landroidx/window/extensions/embedding/SplitInfo$Token;", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;Landroidx/window/extensions/embedding/SplitInfo$Token;)V", "binder", "Landroid/os/IBinder;", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;Landroid/os/IBinder;)V", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;)V", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;Landroid/os/IBinder;Landroidx/window/extensions/embedding/SplitInfo$Token;)V", "getBinder$annotations", "()V", "getPrimaryActivityStack", "()Landroidx/window/embedding/ActivityStack;", "getSecondaryActivityStack", "getSplitAttributes", "()Landroidx/window/embedding/SplitAttributes;", "contains", "", "activity", "Landroid/app/Activity;", "equals", "other", "getBinder", "getBinder$window_release", "getToken", "getToken$window_release", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitInfo {
    @Nullable
    private final IBinder binder;
    @NotNull
    private final ActivityStack primaryActivityStack;
    @NotNull
    private final ActivityStack secondaryActivityStack;
    @NotNull
    private final SplitAttributes splitAttributes;
    @Nullable
    private final SplitInfo.Token token;

    public SplitInfo(@NotNull ActivityStack activityStack0, @NotNull ActivityStack activityStack1, @NotNull SplitAttributes splitAttributes0) {
        q.g(activityStack0, "primaryActivityStack");
        q.g(activityStack1, "secondaryActivityStack");
        q.g(splitAttributes0, "splitAttributes");
        this(activityStack0, activityStack1, splitAttributes0, null, null);
    }

    @RequiresWindowSdkExtension(version = 3)
    public SplitInfo(@NotNull ActivityStack activityStack0, @NotNull ActivityStack activityStack1, @NotNull SplitAttributes splitAttributes0, @NotNull IBinder iBinder0) {
        q.g(activityStack0, "primaryActivityStack");
        q.g(activityStack1, "secondaryActivityStack");
        q.g(splitAttributes0, "splitAttributes");
        q.g(iBinder0, "binder");
        this(activityStack0, activityStack1, splitAttributes0, iBinder0, null);
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(new g(3, 4, 1));  // 初始化器: LCe/e;-><init>(III)V
    }

    private SplitInfo(ActivityStack activityStack0, ActivityStack activityStack1, SplitAttributes splitAttributes0, IBinder iBinder0, SplitInfo.Token splitInfo$Token0) {
        this.primaryActivityStack = activityStack0;
        this.secondaryActivityStack = activityStack1;
        this.splitAttributes = splitAttributes0;
        this.binder = iBinder0;
        this.token = splitInfo$Token0;
    }

    @RequiresWindowSdkExtension(version = 5)
    public SplitInfo(@NotNull ActivityStack activityStack0, @NotNull ActivityStack activityStack1, @NotNull SplitAttributes splitAttributes0, @NotNull SplitInfo.Token splitInfo$Token0) {
        q.g(activityStack0, "primaryActivityStack");
        q.g(activityStack1, "secondaryActivityStack");
        q.g(splitAttributes0, "splitAttributes");
        q.g(splitInfo$Token0, "token");
        this(activityStack0, activityStack1, splitAttributes0, null, splitInfo$Token0);
    }

    public final boolean contains(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.primaryActivityStack.contains(activity0) || this.secondaryActivityStack.contains(activity0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SplitInfo)) {
            return false;
        }
        if(!q.b(this.primaryActivityStack, ((SplitInfo)object0).primaryActivityStack)) {
            return false;
        }
        if(!q.b(this.secondaryActivityStack, ((SplitInfo)object0).secondaryActivityStack)) {
            return false;
        }
        if(!q.b(this.splitAttributes, ((SplitInfo)object0).splitAttributes)) {
            return false;
        }
        return q.b(this.token, ((SplitInfo)object0).token) ? q.b(this.binder, ((SplitInfo)object0).binder) : false;
    }

    @d
    private static void getBinder$annotations() {
    }

    @RequiresWindowSdkExtension(version = 3)
    @NotNull
    public final IBinder getBinder$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(new g(3, 4, 1));  // 初始化器: LCe/e;-><init>(III)V
        IBinder iBinder0 = this.binder;
        if(iBinder0 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        return iBinder0;
    }

    @NotNull
    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    @NotNull
    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    @NotNull
    public final SplitAttributes getSplitAttributes() {
        return this.splitAttributes;
    }

    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    public final SplitInfo.Token getToken$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        SplitInfo.Token splitInfo$Token0 = this.token;
        if(splitInfo$Token0 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        return splitInfo$Token0;
    }

    @Override
    public int hashCode() {
        int v = this.primaryActivityStack.hashCode();
        int v1 = this.secondaryActivityStack.hashCode();
        int v2 = this.splitAttributes.hashCode();
        int v3 = 0;
        int v4 = this.token == null ? 0 : this.token.hashCode();
        IBinder iBinder0 = this.binder;
        if(iBinder0 != null) {
            v3 = iBinder0.hashCode();
        }
        return ((v2 + (v1 + v * 0x1F) * 0x1F) * 0x1F + v4) * 0x1F + v3;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SplitInfo:{");
        stringBuilder0.append("primaryActivityStack=" + this.primaryActivityStack + ", ");
        stringBuilder0.append("secondaryActivityStack=" + this.secondaryActivityStack + ", ");
        stringBuilder0.append("splitAttributes=" + this.splitAttributes + ", ");
        if(this.token != null) {
            stringBuilder0.append("token=" + this.token);
        }
        if(this.binder != null) {
            stringBuilder0.append("binder=" + this.binder);
        }
        stringBuilder0.append("}");
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

