package com.samsung.android.sdk.look.smartclip;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ExtractionListenerProxy implements InvocationHandler {
    private static final String TAG = "SlookSmartClip";
    private DataExtractionListener mDataExtractionListener;

    private ExtractionListenerProxy(DataExtractionListener slookSmartClip$DataExtractionListener0) {
        this.mDataExtractionListener = slookSmartClip$DataExtractionListener0;
    }

    @Override
    public Object invoke(Object object0, Method method0, Object[] arr_object) {
        return method0.getName().equals("onExtractSmartClipData") ? this.mDataExtractionListener.onExtractSmartClipData(((View)arr_object[0]), ((SlookSmartClipDataElement)arr_object[1]), ((SlookSmartClipCroppedArea)arr_object[2])) : null;
    }

    public static Object newInstance(DataExtractionListener slookSmartClip$DataExtractionListener0) {
        Class class0;
        try {
            class0 = ReflectionUtils.getClassByName("com.samsung.android.smartclip.SmartClipDataExtractionListener");
        }
        catch(ClassNotFoundException classNotFoundException0) {
            Log.e("SlookSmartClip", "newInstance : e=" + classNotFoundException0);
            classNotFoundException0.printStackTrace();
            class0 = null;
        }
        ExtractionListenerProxy extractionListenerProxy0 = new ExtractionListenerProxy(slookSmartClip$DataExtractionListener0);
        return Proxy.newProxyInstance(class0.getClassLoader(), new Class[]{class0}, extractionListenerProxy0);
    }
}

