package W;

import android.app.ActivityOptions;
import android.app.BroadcastOptions;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.GraphemeClusterSegmentFinder;
import android.text.SegmentFinder;
import android.text.TextPaint;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.SelectRangeGesture;
import android.widget.EditText;
import com.google.android.material.search.SearchBar;

public abstract class m {
    public static boolean C(Object object0) {
        return object0 instanceof SelectRangeGesture;
    }

    public static boolean D(Object object0) {
        return object0 instanceof DeleteRangeGesture;
    }

    public static int a() {
        return 0x200;
    }

    public static ActivityOptions c(ActivityOptions activityOptions0) {
        return activityOptions0.setPendingIntentBackgroundActivityStartMode(1);
    }

    public static BroadcastOptions e(BroadcastOptions broadcastOptions0) {
        return broadcastOptions0.setShareIdentityEnabled(true);
    }

    public static JobScheduler f(JobScheduler jobScheduler0) {
        return jobScheduler0.forNamespace("androidx.work.systemjobscheduler");
    }

    public static GraphemeClusterSegmentFinder k(CharSequence charSequence0, TextPaint textPaint0) {
        return new GraphemeClusterSegmentFinder(charSequence0, textPaint0);
    }

    public static SegmentFinder l(Object object0) {
        return (SegmentFinder)object0;
    }

    public static DeleteGesture m(Object object0) [...] // Inlined contents

    public static DeleteRangeGesture n(Object object0) [...] // Inlined contents

    public static SelectRangeGesture o(Object object0) [...] // Inlined contents

    public static void s() {
    }

    public static void u(Context context0, Intent intent0, Bundle bundle0) {
        context0.sendBroadcast(intent0, null, bundle0);
    }

    public static void v(EditText editText0) {
        editText0.setIsHandwritingDelegate(true);
    }

    public static void w(SearchBar searchBar0, float f, float f1) {
        searchBar0.setHandwritingBoundsOffsets(f, 0.0f, f1, 0.0f);
    }

    public static boolean y(Object object0) {
        return object0 instanceof DeleteGesture;
    }
}

