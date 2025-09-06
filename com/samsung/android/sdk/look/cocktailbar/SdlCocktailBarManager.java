package com.samsung.android.sdk.look.cocktailbar;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;

class SdlCocktailBarManager implements CocktailBarManagerInterface {
    public static final String COCKTAIL_BAR_SERVICE = "CocktailBarService";
    private Object mCocktailBarManager;

    public SdlCocktailBarManager(Context context0) {
        this.mCocktailBarManager = context0.getSystemService("CocktailBarService");
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void closeCocktail(int v, int v1) {
        RefCocktailBarManager.get().closeCocktail(this.mCocktailBarManager, v, v1);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void disableCocktail(ComponentName componentName0) {
        RefCocktailBarManager.get().disableCocktail(this.mCocktailBarManager, componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public int getCocktailBarWindowType() {
        return RefCocktailBarManager.get().getCocktailBarWindowType(this.mCocktailBarManager);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public int[] getCocktailIds(ComponentName componentName0) {
        return RefCocktailBarManager.get().getCocktailIds(this.mCocktailBarManager, componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public boolean isEnabledCocktail(ComponentName componentName0) {
        return RefCocktailBarManager.get().isEnabledCocktail(this.mCocktailBarManager, componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void notifyCocktailViewDataChanged(int v, int v1) {
        RefCocktailBarManager.get().notifyCocktailViewDataChanged(this.mCocktailBarManager, v, v1);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void partiallyUpdateCocktail(int v, RemoteViews remoteViews0) {
        RefCocktailBarManager.get().partiallyUpdateCocktail(this.mCocktailBarManager, v, remoteViews0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void registerListener(Object object0) {
        RefCocktailBarManager.get().registerListener(this.mCocktailBarManager, object0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void setCocktailBarStatus(boolean z, boolean z1) {
        RefCocktailBarManager.get().setCocktailBarStatus(this.mCocktailBarManager, z, z1);
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
        RefCocktailBarManager.get().setOnPullPendingIntent(this.mCocktailBarManager, v, v1, pendingIntent0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void showCocktail(int v) {
        RefCocktailBarManager.get().showCocktail(this.mCocktailBarManager, v);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void unregisterListener(Object object0) {
        RefCocktailBarManager.get().unregisterListener(this.mCocktailBarManager, object0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateCocktail(int v, int v1, int v2, RemoteViews remoteViews0, RemoteViews remoteViews1, Bundle bundle0, ComponentName componentName0) {
        RefCocktailBarManager.get().updateCocktail(this.mCocktailBarManager, v, v1, v2, remoteViews0, remoteViews1, bundle0, componentName0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateCocktail(int v, RemoteViews remoteViews0) {
        RefCocktailBarManager.get().updateCocktail(this.mCocktailBarManager, v, RefCocktailBarManager.get().COCKTAIL_DISPLAY_POLICY_GENERAL, RefCocktailBarManager.get().COCKTAIL_CATEGORY_GLOBAL, remoteViews0, null);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateCocktail(int v, RemoteViews remoteViews0, RemoteViews remoteViews1) {
        RefCocktailBarManager.get().updateCocktail(this.mCocktailBarManager, v, RefCocktailBarManager.get().COCKTAIL_DISPLAY_POLICY_GENERAL, RefCocktailBarManager.get().COCKTAIL_CATEGORY_GLOBAL, remoteViews0, remoteViews1, null);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.CocktailBarManagerInterface
    public void updateLongpressGesture(boolean z) {
        RefCocktailBarManager.get().updateLongpressGesture(this.mCocktailBarManager, z);
    }
}

