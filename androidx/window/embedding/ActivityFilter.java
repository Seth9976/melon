package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.appcompat.app.o;
import androidx.window.core.ActivityComponentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0000\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u000E\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0017J\u000E\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u001AJ\b\u0010\u001B\u001A\u00020\u0005H\u0016R\u0014\u0010\u0007\u001A\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001C"}, d2 = {"Landroidx/window/embedding/ActivityFilter;", "", "componentName", "Landroid/content/ComponentName;", "intentAction", "", "(Landroid/content/ComponentName;Ljava/lang/String;)V", "activityComponentInfo", "Landroidx/window/core/ActivityComponentInfo;", "(Landroidx/window/core/ActivityComponentInfo;Ljava/lang/String;)V", "getActivityComponentInfo$window_release", "()Landroidx/window/core/ActivityComponentInfo;", "getComponentName", "()Landroid/content/ComponentName;", "getIntentAction", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "matchesActivity", "activity", "Landroid/app/Activity;", "matchesIntent", "intent", "Landroid/content/Intent;", "toString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityFilter {
    @NotNull
    private final ActivityComponentInfo activityComponentInfo;
    @Nullable
    private final String intentAction;

    public ActivityFilter(@NotNull ComponentName componentName0, @Nullable String s) {
        q.g(componentName0, "componentName");
        this(new ActivityComponentInfo(componentName0), s);
    }

    public ActivityFilter(@NotNull ActivityComponentInfo activityComponentInfo0, @Nullable String s) {
        q.g(activityComponentInfo0, "activityComponentInfo");
        super();
        this.activityComponentInfo = activityComponentInfo0;
        this.intentAction = s;
        MatcherUtils.INSTANCE.validateComponentName$window_release(activityComponentInfo0.getPackageName(), activityComponentInfo0.getClassName());
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ActivityFilter)) {
            return false;
        }
        return q.b(this.activityComponentInfo, ((ActivityFilter)object0).activityComponentInfo) ? q.b(this.intentAction, ((ActivityFilter)object0).intentAction) : false;
    }

    @NotNull
    public final ActivityComponentInfo getActivityComponentInfo$window_release() {
        return this.activityComponentInfo;
    }

    @NotNull
    public final ComponentName getComponentName() {
        return new ComponentName(this.activityComponentInfo.getPackageName(), this.activityComponentInfo.getClassName());
    }

    @Nullable
    public final String getIntentAction() {
        return this.intentAction;
    }

    @Override
    public int hashCode() {
        int v = this.activityComponentInfo.hashCode();
        return this.intentAction == null ? v * 0x1F : v * 0x1F + this.intentAction.hashCode();
    }

    public final boolean matchesActivity(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        if(MatcherUtils.INSTANCE.isActivityMatching$window_release(activity0, this.activityComponentInfo)) {
            String s = this.intentAction;
            if(s != null) {
                Intent intent0 = activity0.getIntent();
                return q.b(s, (intent0 == null ? null : intent0.getAction()));
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        return MatcherUtils.INSTANCE.isIntentMatching$window_release(intent0, this.activityComponentInfo) ? this.intentAction == null || q.b(this.intentAction, intent0.getAction()) : false;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ActivityFilter(componentName=");
        stringBuilder0.append(this.activityComponentInfo);
        stringBuilder0.append(", intentAction=");
        return o.r(stringBuilder0, this.intentAction, ')');
    }
}

