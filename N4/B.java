package n4;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest.Builder;
import android.adservices.customaudience.LeaveCustomAudienceRequest.Builder;
import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.view.InputEvent;
import l.a;

public abstract class b {
    public static Class A() {
        return AppSetIdManager.class;
    }

    public static void B() {
        new JoinCustomAudienceRequest.Builder();
    }

    public static Class C() {
        return CustomAudienceManager.class;
    }

    public static Class D() {
        return MeasurementManager.class;
    }

    public static int a(AppSetId appSetId0) {
        return appSetId0.getScope();
    }

    public static AdId c(Object object0) [...] // Inlined contents

    public static AdIdManager d(Object object0) [...] // Inlined contents

    public static AdSelectionManager e(Context context0) {
        return AdSelectionManager.get(context0);
    }

    public static AdSelectionManager f(Object object0) [...] // Inlined contents

    public static AdSelectionOutcome g(Object object0) [...] // Inlined contents

    public static AppSetId h(Object object0) [...] // Inlined contents

    public static AppSetIdManager i(Context context0) {
        return AppSetIdManager.get(context0);
    }

    public static AppSetIdManager j(Object object0) [...] // Inlined contents

    public static CustomAudienceManager k(Context context0) {
        return CustomAudienceManager.get(context0);
    }

    public static CustomAudienceManager l(Object object0) [...] // Inlined contents

    public static MeasurementManager m(Context context0) {
        return MeasurementManager.get(context0);
    }

    public static MeasurementManager n(Object object0) [...] // Inlined contents

    public static Class p() {
        return AdSelectionManager.class;
    }

    public static String q(AdId adId0) {
        return adId0.getAdId();
    }

    public static String r(AppSetId appSetId0) {
        return appSetId0.getId();
    }

    public static void s() {
        new LeaveCustomAudienceRequest.Builder();
    }

    public static void t(AdIdManager adIdManager0, a a0, OutcomeReceiver outcomeReceiver0) {
        adIdManager0.getAdId(a0, outcomeReceiver0);
    }

    public static void u(AppSetIdManager appSetIdManager0, a a0, OutcomeReceiver outcomeReceiver0) {
        appSetIdManager0.getAppSetId(a0, outcomeReceiver0);
    }

    public static void v(MeasurementManager measurementManager0, Uri uri0, InputEvent inputEvent0, a a0, OutcomeReceiver outcomeReceiver0) {
        measurementManager0.registerSource(uri0, inputEvent0, a0, outcomeReceiver0);
    }

    public static void w(MeasurementManager measurementManager0, Uri uri0, a a0, OutcomeReceiver outcomeReceiver0) {
        measurementManager0.registerTrigger(uri0, a0, outcomeReceiver0);
    }

    public static void x(MeasurementManager measurementManager0, a a0, OutcomeReceiver outcomeReceiver0) {
        measurementManager0.getMeasurementApiStatus(a0, outcomeReceiver0);
    }

    public static void y(Object object0) {
        AdSelectionManager adSelectionManager0 = (AdSelectionManager)object0;
    }

    public static boolean z(AdId adId0) {
        return adId0.isLimitAdTrackingEnabled();
    }
}

