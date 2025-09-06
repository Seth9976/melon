package com.samsung.android.sdk.look.cocktailbar;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.RemoteViews;

class RefCocktailBarManager extends AbstractBaseReflection {
    public int COCKTAIL_CATEGORY_GLOBAL;
    public int COCKTAIL_DISPLAY_POLICY_GENERAL;
    private static RefCocktailBarManager sInstance;

    public RefCocktailBarManager() {
    }

    public RefCocktailBarManager(Class class0) {
        super(class0);
    }

    public RefCocktailBarManager(String s) {
        super(s);
    }

    public void closeCocktail(Object object0, int v, int v1) {
        this.invokeNormalMethod(object0, "closeCocktail", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{v, v1});
    }

    public void disableCocktail(Object object0, ComponentName componentName0) {
        this.invokeNormalMethod(object0, "disableCocktail", new Class[]{ComponentName.class}, new Object[]{componentName0});
    }

    public static RefCocktailBarManager get() {
        synchronized(RefCocktailBarManager.class) {
            if(RefCocktailBarManager.sInstance == null) {
                RefCocktailBarManager.sInstance = new RefCocktailBarManager();
            }
            return RefCocktailBarManager.sInstance;
        }
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.AbstractBaseReflection
    public String getBaseClassName() {
        return "com.samsung.android.cocktailbar.CocktailBarManager";
    }

    public int getCocktailBarWindowType(Object object0) {
        Object object1 = this.invokeNormalMethod(object0, "getCocktailBarWindowType");
        return object1 == null ? 0 : ((int)(((Integer)object1)));
    }

    public int[] getCocktailIds(Object object0, ComponentName componentName0) {
        Object object1 = this.invokeNormalMethod(object0, "getCocktailIds", new Class[]{ComponentName.class}, new Object[]{componentName0});
        return object1 == null ? null : ((int[])object1);
    }

    public boolean isEnabledCocktail(Object object0, ComponentName componentName0) {
        Object object1 = this.invokeNormalMethod(object0, "isEnabledCocktail", new Class[]{ComponentName.class}, new Object[]{componentName0});
        return object1 != null && ((Boolean)object1).booleanValue();
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.AbstractBaseReflection
    public void loadStaticFields() {
        this.COCKTAIL_DISPLAY_POLICY_GENERAL = this.getIntStaticValue("COCKTAIL_DISPLAY_POLICY_GENERAL", 1);
        this.COCKTAIL_CATEGORY_GLOBAL = this.getIntStaticValue("COCKTAIL_CATEGORY_GLOBAL", 1);
    }

    public void notifyCocktailViewDataChanged(Object object0, int v, int v1) {
        this.invokeNormalMethod(object0, "notifyCocktailViewDataChanged", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{v, v1});
    }

    public void partiallyUpdateCocktail(Object object0, int v, RemoteViews remoteViews0) {
        this.invokeNormalMethod(object0, "partiallyUpdateCocktail", new Class[]{Integer.TYPE, RemoteViews.class}, new Object[]{v, remoteViews0});
    }

    public void registerListener(Object object0, Object object1) {
        this.invokeNormalMethod(object0, "registerListener", new Class[]{this.loadClassIfNeeded("com.samsung.android.cocktailbar.CocktailBarManager$CocktailBarStateListener")}, new Object[]{object1});
    }

    public void setCocktailBarStatus(Object object0, boolean z, boolean z1) {
        this.invokeNormalMethod(object0, "setCocktailBarStatus", new Class[]{Boolean.TYPE, Boolean.TYPE}, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z1)});
    }

    public void setOnPullPendingIntent(Object object0, int v, int v1, PendingIntent pendingIntent0) {
        this.invokeNormalMethod(object0, "setOnPullPendingIntent", new Class[]{Integer.TYPE, Integer.TYPE, PendingIntent.class}, new Object[]{v, v1, pendingIntent0});
    }

    public void showCocktail(Object object0, int v) {
        this.invokeNormalMethod(object0, "showCocktail", new Class[]{Integer.TYPE}, new Object[]{v});
    }

    public void unregisterListener(Object object0, Object object1) {
        this.invokeNormalMethod(object0, "unregisterListener", new Class[]{this.loadClassIfNeeded("com.samsung.android.cocktailbar.CocktailBarManager$CocktailBarStateListener")}, new Object[]{object1});
    }

    public void updateCocktail(Object object0, int v, int v1, int v2, RemoteViews remoteViews0, Bundle bundle0) {
        this.invokeNormalMethod(object0, "updateCocktail", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, RemoteViews.class, Bundle.class}, new Object[]{v, v1, v2, remoteViews0, bundle0});
    }

    public void updateCocktail(Object object0, int v, int v1, int v2, RemoteViews remoteViews0, RemoteViews remoteViews1, Bundle bundle0) {
        this.invokeNormalMethod(object0, "updateCocktail", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, RemoteViews.class, RemoteViews.class, Bundle.class}, new Object[]{v, v1, v2, remoteViews0, remoteViews1, bundle0});
    }

    public void updateCocktail(Object object0, int v, int v1, int v2, RemoteViews remoteViews0, RemoteViews remoteViews1, Bundle bundle0, ComponentName componentName0) {
        this.invokeNormalMethod(object0, "updateCocktail", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, RemoteViews.class, RemoteViews.class, Bundle.class, ComponentName.class}, new Object[]{v, v1, v2, remoteViews0, remoteViews1, bundle0, componentName0});
    }

    public void updateLongpressGesture(Object object0, boolean z) {
        this.invokeNormalMethod(object0, "updateLongpressGesture", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }
}

