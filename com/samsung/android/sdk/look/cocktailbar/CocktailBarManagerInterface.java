package com.samsung.android.sdk.look.cocktailbar;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.RemoteViews;

interface CocktailBarManagerInterface {
    void closeCocktail(int arg1, int arg2);

    void disableCocktail(ComponentName arg1);

    int getCocktailBarWindowType();

    int[] getCocktailIds(ComponentName arg1);

    boolean isEnabledCocktail(ComponentName arg1);

    void notifyCocktailViewDataChanged(int arg1, int arg2);

    void partiallyUpdateCocktail(int arg1, RemoteViews arg2);

    void registerListener(Object arg1);

    void setCocktailBarStatus(boolean arg1, boolean arg2);

    void setOnLongClickPendingIntent(RemoteViews arg1, int arg2, PendingIntent arg3);

    void setOnLongClickPendingIntentTemplate(RemoteViews arg1, int arg2, PendingIntent arg3);

    void setOnPullPendingIntent(int arg1, int arg2, PendingIntent arg3);

    void showCocktail(int arg1);

    void unregisterListener(Object arg1);

    void updateCocktail(int arg1, int arg2, int arg3, RemoteViews arg4, RemoteViews arg5, Bundle arg6, ComponentName arg7);

    void updateCocktail(int arg1, RemoteViews arg2);

    void updateCocktail(int arg1, RemoteViews arg2, RemoteViews arg3);

    void updateLongpressGesture(boolean arg1);
}

