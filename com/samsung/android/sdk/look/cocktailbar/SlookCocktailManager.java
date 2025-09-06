package com.samsung.android.sdk.look.cocktailbar;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.RemoteViews;
import com.samsung.android.sdk.look.Slook;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class SlookCocktailManager {
    public static final int COCKTAIL_VISIBILITY_HIDE = 2;
    public static final int COCKTAIL_VISIBILITY_SHOW = 1;
    private static final String TAG = "SlookCocktailManager";
    private CocktailBarManagerInterface mCocktailBarManager;
    private static boolean mIsSemAvailable;
    private Slook mSlook;
    static WeakHashMap sManagerCache;

    static {
        SlookCocktailManager.sManagerCache = new WeakHashMap();
    }

    private SlookCocktailManager(Context context0) {
        Slook slook0 = new Slook();
        this.mSlook = slook0;
        if(slook0.isFeatureEnabled(7)) {
            this.initSemFeature(context0);
            if(SlookCocktailManager.mIsSemAvailable) {
                this.mCocktailBarManager = new SepCocktailBarManager(context0);
                return;
            }
            this.mCocktailBarManager = new SdlCocktailBarManager(context0);
        }
    }

    // 去混淆评级： 低(20)
    public int[] getCocktailIds(ComponentName componentName0) {
        return this.mSlook.isFeatureEnabled(7) ? this.mCocktailBarManager.getCocktailIds(componentName0) : new int[0];
    }

    public static SlookCocktailManager getInstance(Context context0) {
        synchronized(SlookCocktailManager.sManagerCache) {
            if(context0 != null) {
                if(context0 instanceof ContextWrapper && ((ContextWrapper)context0).getBaseContext() == null) {
                    throw new IllegalArgumentException("Base context is null.");
                }
                WeakReference weakReference0 = (WeakReference)SlookCocktailManager.sManagerCache.get(context0);
                SlookCocktailManager slookCocktailManager0 = weakReference0 == null ? null : ((SlookCocktailManager)weakReference0.get());
                if(slookCocktailManager0 == null) {
                    slookCocktailManager0 = new SlookCocktailManager(context0);
                    SlookCocktailManager.sManagerCache.put(context0, new WeakReference(slookCocktailManager0));
                }
                return slookCocktailManager0;
            }
        }
        throw new IllegalArgumentException("context is null.");
    }

    private void initSemFeature(Context context0) {
        if(context0.getPackageManager().hasSystemFeature("com.samsung.feature.samsung_experience_mobile")) {
            SlookCocktailManager.mIsSemAvailable = true;
            return;
        }
        SlookCocktailManager.mIsSemAvailable = false;
    }

    public void notifyCocktailViewDataChanged(int v, int v1) {
        if(this.mSlook.isFeatureEnabled(7)) {
            this.mCocktailBarManager.notifyCocktailViewDataChanged(v, v1);
        }
    }

    public void setOnLongClickPendingIntent(RemoteViews remoteViews0, int v, PendingIntent pendingIntent0) {
        if(this.mSlook.isFeatureEnabled(7)) {
            if(remoteViews0 == null) {
                Log.d("SlookCocktailManager", "setOnLongClickPendingIntent: invalid RemoteViews");
                return;
            }
            this.mCocktailBarManager.setOnLongClickPendingIntent(remoteViews0, v, pendingIntent0);
        }
    }

    public void setOnLongClickPendingIntentTemplate(RemoteViews remoteViews0, int v, PendingIntent pendingIntent0) {
        if(this.mSlook.isFeatureEnabled(7)) {
            if(remoteViews0 == null) {
                Log.d("SlookCocktailManager", "setOnLongClickPendingIntentTemplate: invalid RemoteViews");
                return;
            }
            this.mCocktailBarManager.setOnLongClickPendingIntentTemplate(remoteViews0, v, pendingIntent0);
        }
    }

    public void setOnPullPendingIntent(int v, int v1, PendingIntent pendingIntent0) {
        if(this.mSlook.isFeatureEnabled(7)) {
            this.mCocktailBarManager.setOnPullPendingIntent(v, v1, pendingIntent0);
        }
    }

    public void updateCocktail(int v, RemoteViews remoteViews0) {
        if(this.mSlook.isFeatureEnabled(7)) {
            if(remoteViews0 == null) {
                throw new IllegalArgumentException("view is null.");
            }
            this.mCocktailBarManager.updateCocktail(v, remoteViews0);
        }
    }

    public void updateCocktail(int v, RemoteViews remoteViews0, RemoteViews remoteViews1) {
        if(this.mSlook.isFeatureEnabled(7)) {
            if(remoteViews0 == null) {
                throw new IllegalArgumentException("contentView is null.");
            }
            this.mCocktailBarManager.updateCocktail(v, remoteViews0, remoteViews1);
        }
    }
}

