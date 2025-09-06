package androidx.window.embedding;

import A7.d;
import android.app.Activity;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.ActivityStack.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u001D\b\u0017\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007B\'\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0004H\u0086\u0002J\u0013\u0010\u0010\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0012\u001A\u00020\tH\u0001¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u001A\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\rR\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/window/embedding/ActivityStack;", "", "activitiesInProcess", "", "Landroid/app/Activity;", "isEmpty", "", "(Ljava/util/List;Z)V", "token", "Landroidx/window/extensions/embedding/ActivityStack$Token;", "(Ljava/util/List;ZLandroidx/window/extensions/embedding/ActivityStack$Token;)V", "getActivitiesInProcess$window_release", "()Ljava/util/List;", "()Z", "contains", "activity", "equals", "other", "getToken", "getToken$window_release", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityStack {
    @NotNull
    private final List activitiesInProcess;
    private final boolean isEmpty;
    @Nullable
    private final ActivityStack.Token token;

    public ActivityStack(@NotNull List list0, boolean z) {
        q.g(list0, "activitiesInProcess");
        this(list0, z, null);
    }

    public ActivityStack(@NotNull List list0, boolean z, @Nullable ActivityStack.Token activityStack$Token0) {
        q.g(list0, "activitiesInProcess");
        super();
        this.activitiesInProcess = list0;
        this.isEmpty = z;
        this.token = activityStack$Token0;
    }

    public final boolean contains(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.activitiesInProcess.contains(activity0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ActivityStack)) {
            return false;
        }
        if(!q.b(this.activitiesInProcess, ((ActivityStack)object0).activitiesInProcess)) {
            return false;
        }
        return this.isEmpty == ((ActivityStack)object0).isEmpty ? q.b(this.token, ((ActivityStack)object0).token) : false;
    }

    @NotNull
    public final List getActivitiesInProcess$window_release() {
        return this.activitiesInProcess;
    }

    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    public final ActivityStack.Token getToken$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        q.d(this.token);
        return this.token;
    }

    @Override
    public int hashCode() {
        int v = d.e(this.activitiesInProcess.hashCode() * 0x1F, 0x1F, this.isEmpty);
        return this.token == null ? v : v + this.token.hashCode();
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    @NotNull
    public String toString() {
        return "ActivityStack{activitiesInProcess=" + this.activitiesInProcess + ", isEmpty=" + this.isEmpty + ", token=" + this.token + '}';
    }
}

