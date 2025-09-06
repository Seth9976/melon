package i3;

import android.media.AudioProfile;
import android.media.MediaDrm.PlaybackComponent;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.TrackChangeEvent.Builder;
import android.view.RoundedCorner;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest.Builder;
import android.view.translation.ViewTranslationResponse;

public abstract class i {
    public static RoundedCorner C(WindowInsets windowInsets0) {
        return windowInsets0.getRoundedCorner(1);
    }

    public static void D(TrackChangeEvent.Builder trackChangeEvent$Builder0) {
        trackChangeEvent$Builder0.setTrackState(1);
    }

    public static AudioProfile e(Object object0) {
        return (AudioProfile)object0;
    }

    public static MediaDrm.PlaybackComponent g(Object object0) [...] // Inlined contents

    public static MediaMetricsManager h(Object object0) {
        return (MediaMetricsManager)object0;
    }

    public static RoundedCorner k(WindowInsets windowInsets0) {
        return windowInsets0.getRoundedCorner(0);
    }

    public static ViewTranslationRequest.Builder m(AutofillId autofillId0, long v) {
        return new ViewTranslationRequest.Builder(autofillId0, v);
    }

    public static ViewTranslationResponse o(Object object0) {
        return (ViewTranslationResponse)object0;
    }

    public static void q() {
    }

    public static void u(TrackChangeEvent.Builder trackChangeEvent$Builder0) {
        trackChangeEvent$Builder0.setTrackState(0);
    }

    public static void w(ViewTranslationRequest.Builder viewTranslationRequest$Builder0, TranslationRequestValue translationRequestValue0) {
        viewTranslationRequest$Builder0.setValue("android:text", translationRequestValue0);
    }

    public static boolean z(LogSessionId logSessionId0) {
        return logSessionId0.equals(LogSessionId.LOG_SESSION_ID_NONE);
    }
}

