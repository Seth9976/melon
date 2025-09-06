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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0000\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000BJ\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\u0016\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AJ\u0016\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u0018J\b\u0010\u001D\u001A\u00020\u0006H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\r¨\u0006\u001E"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "_primaryActivityName", "Landroidx/window/core/ActivityComponentInfo;", "_secondaryActivityName", "(Landroidx/window/core/ActivityComponentInfo;Landroidx/window/core/ActivityComponentInfo;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitPairFilter {
    @NotNull
    private final ActivityComponentInfo _primaryActivityName;
    @NotNull
    private final ActivityComponentInfo _secondaryActivityName;
    @Nullable
    private final String secondaryActivityIntentAction;

    public SplitPairFilter(@NotNull ComponentName componentName0, @NotNull ComponentName componentName1, @Nullable String s) {
        q.g(componentName0, "primaryActivityName");
        q.g(componentName1, "secondaryActivityName");
        this(new ActivityComponentInfo(componentName0), new ActivityComponentInfo(componentName1), s);
    }

    public SplitPairFilter(@NotNull ActivityComponentInfo activityComponentInfo0, @NotNull ActivityComponentInfo activityComponentInfo1, @Nullable String s) {
        q.g(activityComponentInfo0, "_primaryActivityName");
        q.g(activityComponentInfo1, "_secondaryActivityName");
        super();
        this._primaryActivityName = activityComponentInfo0;
        this._secondaryActivityName = activityComponentInfo1;
        this.secondaryActivityIntentAction = s;
        MatcherUtils.INSTANCE.validateComponentName$window_release(activityComponentInfo0.getPackageName(), activityComponentInfo0.getClassName());
        MatcherUtils.INSTANCE.validateComponentName$window_release(activityComponentInfo1.getPackageName(), activityComponentInfo1.getClassName());
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!SplitPairFilter.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.window.embedding.SplitPairFilter");
        if(!q.b(this._primaryActivityName, ((SplitPairFilter)object0)._primaryActivityName)) {
            return false;
        }
        return q.b(this._secondaryActivityName, ((SplitPairFilter)object0)._secondaryActivityName) ? q.b(this.secondaryActivityIntentAction, ((SplitPairFilter)object0).secondaryActivityIntentAction) : false;
    }

    @NotNull
    public final ComponentName getPrimaryActivityName() {
        return new ComponentName(this._primaryActivityName.getPackageName(), this._primaryActivityName.getClassName());
    }

    @Nullable
    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    @NotNull
    public final ComponentName getSecondaryActivityName() {
        return new ComponentName(this._secondaryActivityName.getPackageName(), this._secondaryActivityName.getClassName());
    }

    @Override
    public int hashCode() {
        int v = this._primaryActivityName.hashCode();
        int v1 = this._secondaryActivityName.hashCode();
        return this.secondaryActivityIntentAction == null ? (v1 + v * 0x1F) * 0x1F : (v1 + v * 0x1F) * 0x1F + this.secondaryActivityIntentAction.hashCode();
    }

    public final boolean matchesActivityIntentPair(@NotNull Activity activity0, @NotNull Intent intent0) {
        q.g(activity0, "primaryActivity");
        q.g(intent0, "secondaryActivityIntent");
        MatcherUtils matcherUtils0 = MatcherUtils.INSTANCE;
        if(!matcherUtils0.isActivityMatching$window_release(activity0, this._primaryActivityName)) {
            return false;
        }
        return matcherUtils0.isIntentMatching$window_release(intent0, this._secondaryActivityName) ? this.secondaryActivityIntentAction == null || q.b(this.secondaryActivityIntentAction, intent0.getAction()) : false;
    }

    public final boolean matchesActivityPair(@NotNull Activity activity0, @NotNull Activity activity1) {
        q.g(activity0, "primaryActivity");
        q.g(activity1, "secondaryActivity");
        MatcherUtils matcherUtils0 = MatcherUtils.INSTANCE;
        if(!matcherUtils0.isActivityMatching$window_release(activity0, this._primaryActivityName)) {
            return false;
        }
        if(!matcherUtils0.isActivityMatching$window_release(activity1, this._secondaryActivityName)) {
            return false;
        }
        String s = this.secondaryActivityIntentAction;
        if(s != null) {
            Intent intent0 = activity1.getIntent();
            return q.b(s, (intent0 == null ? null : intent0.getAction()));
        }
        return true;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SplitPairFilter{primaryActivityName=");
        stringBuilder0.append(this.getPrimaryActivityName());
        stringBuilder0.append(", secondaryActivityName=");
        stringBuilder0.append(this.getSecondaryActivityName());
        stringBuilder0.append(", secondaryActivityAction=");
        return o.r(stringBuilder0, this.secondaryActivityIntentAction, '}');
    }
}

