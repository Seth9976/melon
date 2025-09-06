package com.samsung.android.sdk.look.smartclip;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import va.e;

public final class SlookSmartClip {
    public interface DataExtractionListener {
        public static final int EXTRACTION_DEFAULT = 1;
        public static final int EXTRACTION_DISCARD;

        int onExtractSmartClipData(View arg1, SlookSmartClipDataElement arg2, SlookSmartClipCroppedArea arg3);
    }

    private static final String PERMISSION_API_USAGE_LOG = "com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY";
    private static final String TAG = "SmartClip";
    private static boolean mApiUsageLogSent = false;
    private DataExtractionListener mDataExtractionListener;
    private Slook mSlook;
    private View mView;

    public SlookSmartClip(View view0) {
        this.mSlook = new Slook();
        this.mDataExtractionListener = null;
        this.mView = view0;
        if(view0 != null && !SlookSmartClip.mApiUsageLogSent) {
            this.sendApiUsageLog(view0.getContext(), "SlookSmartClip");
            SlookSmartClip.mApiUsageLogSent = true;
        }
    }

    public void addMetaTag(SlookSmartClipMetaTag slookSmartClipMetaTag0) {
        if(!this.isSupport(1)) {
            return;
        }
        try {
            ReflectionUtils.invokeStaticMethod("com.samsung.android.smartclip.SmartClipMetaUtils", "addMetaTag", new Object[]{this.mView, slookSmartClipMetaTag0});
        }
        catch(Exception exception0) {
            Log.e("SmartClip", "Failed to invoke the method. e=" + exception0);
            exception0.printStackTrace();
        }
    }

    public void clearAllMetaTag() {
        if(!this.isSupport(1)) {
            return;
        }
        try {
            ReflectionUtils.invokeStaticMethod("com.samsung.android.smartclip.SmartClipMetaUtils", "clearAllMetaTag", new Object[]{this.mView});
        }
        catch(Exception exception0) {
            Log.e("SmartClip", "Failed to invoke the method. e=" + exception0);
            exception0.printStackTrace();
        }
    }

    public int extractDefaultSmartClipData(SlookSmartClipDataElement slookSmartClipDataElement0, SlookSmartClipCroppedArea slookSmartClipCroppedArea0) {
        if(!this.isSupport(1)) {
            return 0;
        }
        View view0 = this.mView;
        if(view0 == null) {
            Log.e("SmartClip", "extractDefaultSmartClipData : The view is null!");
            return 0;
        }
        if(slookSmartClipDataElement0 == null) {
            Log.e("SmartClip", "extractDefaultSmartClipData : The result element is null!");
            return 0;
        }
        if(slookSmartClipCroppedArea0 == null) {
            Log.e("SmartClip", "extractDefaultSmartClipData : The cropped area is null!");
            return 0;
        }
        try {
            return (int)(((Integer)ReflectionUtils.invokeStaticMethod("com.samsung.android.smartclip.SmartClipMetaUtils", "extractDefaultSmartClipData", new Object[]{view0, slookSmartClipDataElement0, slookSmartClipCroppedArea0})));
        }
        catch(Exception exception0) {
            Log.e("SmartClip", "Failed to invoke the method. e=" + exception0);
            exception0.printStackTrace();
            return 1;
        }
    }

    private boolean isSupport(int v) {
        return this.mSlook.isFeatureEnabled(2);
    }

    public void removeMetaTag(String s) {
        if(!this.isSupport(1)) {
            return;
        }
        try {
            ReflectionUtils.invokeStaticMethod("com.samsung.android.smartclip.SmartClipMetaUtils", "removeMetaTag", new Object[]{this.mView, s});
        }
        catch(Exception exception0) {
            Log.e("SmartClip", "Failed to invoke the method. e=" + exception0);
            exception0.printStackTrace();
        }
    }

    private void sendApiUsageLog(Context context0, String s) {
        int v;
        String s1 = this.mSlook.getClass().getPackage().getName();
        try {
            v = context0.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 0x80).versionCode;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.e("SmartClip", "sendApiUsageLog : Could not find ContextProvider");
            v = -1;
        }
        e.f(v, "sendApiUsageLog : Context framework\'s versionCode = ", "SmartClip");
        if(v > 1) {
            if(context0.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
                throw new SecurityException("Requires com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
            }
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("app_id", s1);
            contentValues0.put("feature", "com.iloen.melon#" + 6);
            contentValues0.put("extra", s);
            Intent intent0 = new Intent();
            intent0.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent0.putExtra("data", contentValues0);
            intent0.setPackage("com.samsung.android.providers.context");
            context0.sendBroadcast(intent0);
            return;
        }
        Log.d("SmartClip", "sendApiUsageLog : Add com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
    }

    public void setDataExtractionListener(DataExtractionListener slookSmartClip$DataExtractionListener0) {
        if(!this.isSupport(1)) {
            return;
        }
        this.mDataExtractionListener = slookSmartClip$DataExtractionListener0;
        Object object0 = ExtractionListenerProxy.newInstance(slookSmartClip$DataExtractionListener0);
        try {
            ReflectionUtils.invokeStaticMethod("com.samsung.android.smartclip.SmartClipMetaUtils", "setDataExtractionListener", new Object[]{this.mView, object0});
        }
        catch(Exception exception0) {
            Log.e("SmartClip", "Failed to invoke the method. e=" + exception0);
            exception0.printStackTrace();
        }
    }
}

