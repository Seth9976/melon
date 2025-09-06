package com.kakao.tiara;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

class Tracker implements Runnable {
    private static final int CONNECTION_TIME = 5000;
    private static final int MAX_BODY_LENGTH = 80000;
    private static final int READ_TIMEOUT = 5000;
    private static final String TAG = "Tracker";
    private static final String TIARA_SERVER_URL_REAL = "https://stat.tiara.daum.net/track";
    private String entity;

    public Tracker(String s) {
        this.entity = s;
    }

    private void closeSilently(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(Exception unused_ex) {
            }
        }
    }

    @Override
    public void run() {
        URL uRL0;
        boolean z = TiaraManager.getInstance().getGlobalSettings().getServerUrl() != null;
        Closeable closeable0 = null;
        try {
            uRL0 = null;
            uRL0 = new URL("https://stat.tiara.daum.net/track");
        }
        catch(MalformedURLException unused_ex) {
        }
        if(uRL0 != null) {
            Logger.debug("Tracker", "server url is : " + uRL0.toString(), new Object[0]);
            try {
                byte[] arr_b = this.entity.getBytes("UTF-8");
                if(arr_b.length <= 80000) {
                    String s = TiaraManager.getInstance().getUuidCookie();
                    Logger.debug("Tracker", "tiara cookie : %s", new Object[]{s});
                    HttpURLConnection httpURLConnection0 = (HttpURLConnection)uRL0.openConnection();
                    httpURLConnection0.setRequestMethod("POST");
                    httpURLConnection0.setDoOutput(true);
                    httpURLConnection0.setDoInput(false);
                    httpURLConnection0.setReadTimeout(5000);
                    httpURLConnection0.setConnectTimeout(5000);
                    httpURLConnection0.setRequestProperty("Connection", "Close");
                    httpURLConnection0.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    if(!TextUtils.isEmpty(s)) {
                        httpURLConnection0.addRequestProperty("Cookie", s);
                    }
                    Locale locale0 = Locale.getDefault();
                    if(locale0 != null) {
                        httpURLConnection0.setRequestProperty("Accept-Language", locale0.toString());
                    }
                    closeable0 = httpURLConnection0.getOutputStream();
                    ((OutputStream)closeable0).write(arr_b);
                    ((OutputStream)closeable0).close();
                    Logger.debug("Tracker", "server response code : %d", new Object[]{httpURLConnection0.getResponseCode()});
                    httpURLConnection0.disconnect();
                    goto label_28;
                }
                goto label_30;
            }
            catch(Throwable unused_ex) {
            }
        label_28:
            this.closeSilently(closeable0);
            return;
        label_30:
            this.closeSilently(null);
        }
    }
}

