package androidx.window.embedding;

import Tf.o;
import Tf.v;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000F\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\f\u001A\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\nH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\f\u001A\u00020\nH\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001F\u001A\u00020\u001C2\u0006\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010 \u001A\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "<init>", "()V", "", "name", "pattern", "", "wildcardMatch", "(Ljava/lang/String;Ljava/lang/String;)Z", "Landroidx/window/core/ActivityComponentInfo;", "activityComponent", "ruleComponent", "areComponentsMatching$window_release", "(Landroidx/window/core/ActivityComponentInfo;Landroidx/window/core/ActivityComponentInfo;)Z", "areComponentsMatching", "Landroid/app/Activity;", "activity", "isActivityMatching$window_release", "(Landroid/app/Activity;Landroidx/window/core/ActivityComponentInfo;)Z", "isActivityMatching", "Landroid/content/Intent;", "intent", "isIntentMatching$window_release", "(Landroid/content/Intent;Landroidx/window/core/ActivityComponentInfo;)Z", "isIntentMatching", "packageName", "className", "Lie/H;", "validateComponentName$window_release", "(Ljava/lang/String;Ljava/lang/String;)V", "validateComponentName", "sDebugMatchers", "Z", "sMatchersTag", "Ljava/lang/String;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class MatcherUtils {
    @NotNull
    public static final MatcherUtils INSTANCE = null;
    public static final boolean sDebugMatchers = false;
    @NotNull
    public static final String sMatchersTag = "SplitRuleResolution";

    static {
        MatcherUtils.INSTANCE = new MatcherUtils();
    }

    public final boolean areComponentsMatching$window_release(@Nullable ActivityComponentInfo activityComponentInfo0, @NotNull ActivityComponentInfo activityComponentInfo1) {
        q.g(activityComponentInfo1, "ruleComponent");
        if(activityComponentInfo0 == null) {
            return q.b(activityComponentInfo1.getPackageName(), "*") && q.b(activityComponentInfo1.getClassName(), "*");
        }
        if(o.v0(activityComponentInfo0.toString(), "*", false)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        return (q.b(activityComponentInfo0.getPackageName(), activityComponentInfo1.getPackageName()) || this.wildcardMatch(activityComponentInfo0.getPackageName(), activityComponentInfo1.getPackageName())) && (q.b(activityComponentInfo0.getClassName(), activityComponentInfo1.getClassName()) || this.wildcardMatch(activityComponentInfo0.getClassName(), activityComponentInfo1.getClassName()));
    }

    public final boolean isActivityMatching$window_release(@NotNull Activity activity0, @NotNull ActivityComponentInfo activityComponentInfo0) {
        q.g(activity0, "activity");
        q.g(activityComponentInfo0, "ruleComponent");
        ComponentName componentName0 = activity0.getComponentName();
        q.f(componentName0, "getComponentName(...)");
        if(this.areComponentsMatching$window_release(new ActivityComponentInfo(componentName0), activityComponentInfo0)) {
            return true;
        }
        Intent intent0 = activity0.getIntent();
        return intent0 == null ? false : MatcherUtils.INSTANCE.isIntentMatching$window_release(intent0, activityComponentInfo0);
    }

    public final boolean isIntentMatching$window_release(@NotNull Intent intent0, @NotNull ActivityComponentInfo activityComponentInfo0) {
        q.g(intent0, "intent");
        q.g(activityComponentInfo0, "ruleComponent");
        ComponentName componentName0 = intent0.getComponent();
        if(this.areComponentsMatching$window_release((componentName0 == null ? null : new ActivityComponentInfo(componentName0)), activityComponentInfo0)) {
            return true;
        }
        if(intent0.getComponent() != null) {
            return false;
        }
        String s = intent0.getPackage();
        return s == null ? false : (s.equals(activityComponentInfo0.getPackageName()) || this.wildcardMatch(s, activityComponentInfo0.getPackageName())) && q.b(activityComponentInfo0.getClassName(), "*");
    }

    public final void validateComponentName$window_release(@NotNull String s, @NotNull String s1) {
        q.g(s, "packageName");
        q.g(s1, "className");
        if(s.length() <= 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        }
        if(s1.length() <= 0) {
            throw new IllegalArgumentException("Activity class name must not be empty");
        }
        if(o.v0(s, "*", false) && o.F0(s, "*", 0, false, 6) != s.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if(o.v0(s1, "*", false) && o.F0(s1, "*", 0, false, 6) != s1.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
        }
    }

    private final boolean wildcardMatch(String s, String s1) {
        if(!o.v0(s1, "*", false)) {
            return false;
        }
        if(s1.equals("*")) {
            return true;
        }
        if(o.F0(s1, "*", 0, false, 6) != o.K0(s1, "*", 0, 6) || !v.i0(s1, "*", false)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String s2 = s1.substring(0, s1.length() - 1);
        q.f(s2, "substring(...)");
        return v.r0(s, s2, false);
    }
}

