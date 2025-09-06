package com.samsung.android.sdk.look.cocktailbar;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.samsung.android.cocktailbar.SemCocktailBarManager;

class SepCocktailBarManager implements CocktailBarManagerInterface {
    public static final String COCKTAIL_BAR_SERVICE = "CocktailBarService";
    private Context mContext;
    private SemCocktailBarManager mSemCocktailBarManager;

    public SepCocktailBarManager(Context context0) {
        this.mSemCocktailBarManager = SemCocktailBarManager.getInstance(context0);
        this.mContext = context0;
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void closeCocktail(int v, int v1) {
        this.mSemCocktailBarManager.closeCocktail(v);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void disableCocktail(ComponentName componentName0) {
        this.mSemCocktailBarManager.disableCocktail(componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public int getCocktailBarWindowType() {
        return this.mSemCocktailBarManager.getCocktailBarWindowType();
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public int[] getCocktailIds(ComponentName componentName0) {
        return this.mSemCocktailBarManager.getCocktailIds(componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public boolean isEnabledCocktail(ComponentName componentName0) {
        return this.mSemCocktailBarManager.isCocktailEnabled(componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void notifyCocktailViewDataChanged(int v, int v1) {
        this.mSemCocktailBarManager.notifyCocktailViewDataChanged(v, v1);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void partiallyUpdateCocktail(int v, RemoteViews remoteViews0) {
        this.mSemCocktailBarManager.updateCocktailView(v, remoteViews0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void registerListener(Object object0) {
        RefCocktailBarManager.get().registerListener(this.mContext.getSystemService("CocktailBarService"), object0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void setCocktailBarStatus(boolean z, boolean z1) {
        RefCocktailBarManager.get().setCocktailBarStatus(this.mContext.getSystemService("CocktailBarService"), z, z1);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void setOnLongClickPendingIntent(RemoteViews remoteViews0, int v, PendingIntent pendingIntent0) {
        remoteViews0.semSetOnLongClickPendingIntent(v, pendingIntent0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void setOnLongClickPendingIntentTemplate(RemoteViews remoteViews0, int v, PendingIntent pendingIntent0) {
        remoteViews0.semSetOnLongClickPendingIntentTemplate(v, pendingIntent0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void setOnPullPendingIntent(int v, int v1, PendingIntent pendingIntent0) {
        RefCocktailBarManager.get().setOnPullPendingIntent(this.mContext.getSystemService("CocktailBarService"), v, v1, pendingIntent0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void showCocktail(int v) {
        this.mSemCocktailBarManager.showCocktail(v);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void unregisterListener(Object object0) {
        RefCocktailBarManager.get().unregisterListener(this.mContext.getSystemService("CocktailBarService"), object0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateCocktail(int v, int v1, int v2, RemoteViews remoteViews0, RemoteViews remoteViews1, Bundle bundle0, ComponentName componentName0) {
        RefCocktailBarManager.get().updateCocktail(this.mContext.getSystemService("CocktailBarService"), v, v1, v2, remoteViews0, remoteViews1, bundle0, componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateCocktail(int v, RemoteViews remoteViews0) {
        this.mSemCocktailBarManager.updateCocktail(v, 1, 1, remoteViews0, null);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateCocktail(int v, RemoteViews remoteViews0, RemoteViews remoteViews1) {
        this.mSemCocktailBarManager.updateCocktail(v, 1, 1, remoteViews0, remoteViews1);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateLongpressGesture(boolean z) {
        RefCocktailBarManager.get().updateLongpressGesture(this.mContext.getSystemService("CocktailBarService"), z);
    }
}

