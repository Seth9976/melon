package com.kakao.tiara;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.n;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Install;
import com.kakao.tiara.data.TiaraLog;
import com.kakao.tiara.track.App;
import com.kakao.tiara.track.Ecommerce;
import com.kakao.tiara.track.Event;
import com.kakao.tiara.track.Extra;
import com.kakao.tiara.track.Location;
import com.kakao.tiara.track.Page;
import com.kakao.tiara.track.Usage;
import com.kakao.tiara.track.ViewImp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TiaraTracker {
    private final Object[] LockObject;
    private static final int MAX_QUEUE_SIZE = 10;
    private static final String TAG = "TiaraTracker";
    private Map globalCustomProps;
    private long lastReportTime;
    private final TiaraManager manager;
    private List queue;
    private SessionIds sessionId;
    private final TiaraSettings settings;
    private String tsidOnAppLaunch;

    public TiaraTracker(String s, TiaraSettings tiaraSettings0) {
        this.LockObject = new Object[0];
        this.queue = Collections.synchronizedList(new ArrayList());
        this.globalCustomProps = new ConcurrentHashMap();
        this.lastReportTime = SystemClock.elapsedRealtime();
        this.settings = tiaraSettings0;
        tiaraSettings0.setSvcDomain(s);
        TiaraManager tiaraManager0 = TiaraManager.getInstance();
        this.manager = tiaraManager0;
        if(!this.isInitialized()) {
            return;
        }
        tiaraSettings0.initialize(tiaraManager0.getGlobalSettings());
        this.sessionId = TiaraManager.getInstance().getSessionId();
        this.trackAppInstallOrUpdateIfNeeded();
    }

    public void clearGlobalCustomProps() {
        this.globalCustomProps.clear();
    }

    private List dequeue() {
        List list0 = null;
        if(!this.isInitialized()) {
            return null;
        }
        synchronized(this.LockObject) {
            if(!this.queue.isEmpty()) {
                list0 = new ArrayList(this.queue);
                this.queue.clear();
            }
            return list0;
        }
    }

    public static void enableDebugLogger() {
        Logger.setEnabled(true);
        Logger.info("TiaraTracker", "Tiara internal debugging log is enabled.", new Object[0]);
    }

    public void enqueue(TiaraLog tiaraLog0) {
        if(this.isInitialized()) {
            Object[] arr_object = this.LockObject;
            synchronized(arr_object) {
                this.queue.add(tiaraLog0);
                int v1 = this.queue.size() - Math.max(10, this.settings.getBatchSize());
                if(v1 > 0) {
                    while(true) {
                        this.queue.remove(0);
                        --v1;
                        if(v1 <= 0) {
                            break;
                        }
                    }
                }
            }
            if(this.queue.size() >= this.settings.getBatchSize() || SystemClock.elapsedRealtime() - this.lastReportTime > this.settings.getBatchIntervalMillis()) {
                this.flush();
            }
        }
    }

    public void flush() {
        String s;
        if(this.isInitialized()) {
            if(!this.isNetworkAvailable(this.getContext())) {
                Logger.info("TiaraTracker", "network is not available.", new Object[0]);
                return;
            }
            List list0 = this.dequeue();
            if(list0 == null || list0.isEmpty()) {
                Logger.info("TiaraTracker", "log queue is empty.", new Object[0]);
                return;
            }
            try {
                s = null;
                s = new n().k(list0);
            }
            catch(Exception unused_ex) {
            }
            if(!TextUtils.isEmpty(s)) {
                Logger.debug("TiaraTracker", "flush -> " + s, new Object[0]);
                Tracker tracker0 = new Tracker(s);
                if(this.manager.flush(tracker0)) {
                    this.lastReportTime = SystemClock.elapsedRealtime();
                }
            }
        }
    }

    public static TiaraTracker get(String s) {
        return TiaraManager.getInstance().get(s);
    }

    public Context getContext() {
        return this.manager.getContext();
    }

    public String getGlobalCustomProperty(String s) {
        return (String)this.globalCustomProps.get(s);
    }

    public Map getGlobalCustomProps() {
        return new LinkedHashMap(this.globalCustomProps);
    }

    public Install getInstall() {
        return this.manager.getGlobalSettings().getInstall();
    }

    public static String getIsuid() {
        return TiaraManager.getInstance().getSessionId().getIsuid();
    }

    public SessionIds getSessionId() {
        return this.sessionId;
    }

    public TiaraSettings getSettings() {
        return this.settings;
    }

    public static String getSuid() {
        return TiaraManager.getInstance().getSessionId().getSuid();
    }

    public static String getTsid() {
        return TiaraManager.getInstance().getSessionId().getTsid();
    }

    public static String getTuid() {
        return TiaraManager.getInstance().getGlobalSettings().getTuid();
    }

    public static String getUuid() {
        return TiaraManager.getInstance().getGlobalSettings().getUuid();
    }

    public static void holdSessionForBackgroundTask() {
        TiaraManager.getInstance().holdSession();
    }

    public static void initialize(Application application0, TiaraConfiguration tiaraConfiguration0) {
        TiaraManager.getInstance().initialize(application0, tiaraConfiguration0);
    }

    private boolean isInitialized() {
        return this.manager.isInitialized();
    }

    private boolean isNetworkAvailable(Context context0) {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)context0.getSystemService("connectivity");
        if(connectivityManager0 != null) {
            NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            return networkInfo0 != null && networkInfo0.isConnected();
        }
        return false;
    }

    public static TiaraTracker newInstance(String s, TiaraSettings tiaraSettings0) {
        return TiaraManager.getInstance().newInstance(s, tiaraSettings0);
    }

    public void onBackground() {
        this.trackAppExit();
    }

    public void onForeground() {
        String s = this.sessionId.getTsid();
        if(s.equals(this.tsidOnAppLaunch)) {
            return;
        }
        this.tsidOnAppLaunch = s;
        this.trackAppLaunch();
    }

    public String putGlobalCustomProperty(String s, String s1) {
        return (String)this.globalCustomProps.put(s, s1);
    }

    public void putGlobalCustomProps(Map map0) {
        this.globalCustomProps.putAll(map0);
    }

    public static void releaseSessionForBackgroundTask() {
        TiaraManager.getInstance().releaseSession();
    }

    public String removeGlobalCustomProperty(String s) {
        return (String)this.globalCustomProps.remove(s);
    }

    public void resetSeqNum() {
        this.settings.resetSeqNum();
    }

    public static void setAccountIdCookie(String s) {
        TiaraManager.getInstance().setAccountIdCookie(s);
    }

    @Deprecated
    public static void setAdidCookie(String s) {
        TiaraManager.getInstance().setAdidCookie(s);
    }

    public static void setAdidCookie(String s, boolean z) {
        TiaraManager.getInstance().setAdidCookie(s);
        TiaraManager.getInstance().setAdidTrackingEnabledCookie(z);
        TiaraManager.getInstance().setTAnoCookie(s, z);
    }

    @Deprecated
    public static void setAdidTrackingEnabledCookie(boolean z) {
        TiaraManager.getInstance().setAdidTrackingEnabledCookie(z);
    }

    public void setSessionId(SessionIds sessionIds0) {
        this.sessionId = sessionIds0;
    }

    public void startNewSessionIfExpired() {
        TiaraManager.getInstance().startNewSessionIfExpired();
    }

    private App trackApp(String s) {
        return new App(this, s, this.getSettings().getAppAdTrackId());
    }

    private void trackAppExit() {
        if(!this.settings.isAppLogEnabled()) {
            return;
        }
        this.trackApp("앱종료").actionKind(ActionKind.AppExit).track().flush();
    }

    public final void trackAppInstall() {
        this.trackApp("앱설치").actionKind(ActionKind.AppInstall).track().flush();
    }

    private void trackAppInstallOrUpdateIfNeeded() {
        if(this.settings.isAppLogEnabled()) {
            String s = this.manager.getGlobalSettings().getAppVersion();
            String s1 = this.manager.getAppVersion();
            if(!TextUtils.equals(s1, s)) {
                this.manager.saveAppVersion(s);
                if(!TextUtils.isEmpty(s1)) {
                    this.trackAppUpdate();
                    return;
                }
                TiaraManager.getInstance().updateFirstLaunchTime();
                TiaraInstallReferrer.startConnection(this.getContext(), this);
            }
        }
    }

    private void trackAppLaunch() {
        if(!this.settings.isAppLogEnabled()) {
            return;
        }
        this.trackApp("앱실행").actionKind(ActionKind.AppLaunch).track().flush();
    }

    private void trackAppUpdate() {
        this.trackApp("앱업데이트").actionKind(ActionKind.AppUpdate).track().flush();
    }

    @Deprecated
    public Ecommerce trackEcommerce(String s) {
        return new Ecommerce(this, s);
    }

    public Event trackEvent(String s) {
        return new Event(this, s);
    }

    public Extra trackExtra(String s) {
        return new Extra(this, s);
    }

    public Location trackLocation(String s) {
        return new Location(this, s);
    }

    public Page trackPage(String s) {
        return new Page(this, s);
    }

    public Usage trackUsage() {
        return new Usage(this, null);
    }

    public Usage trackUsage(String s) {
        return new Usage(this, s);
    }

    public ViewImp trackViewImp() {
        return new ViewImp(this, null);
    }

    public ViewImp trackViewImp(String s) {
        return new ViewImp(this, s);
    }
}

