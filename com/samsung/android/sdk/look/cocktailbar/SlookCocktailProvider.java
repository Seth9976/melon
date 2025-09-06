package com.samsung.android.sdk.look.cocktailbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SlookCocktailProvider extends BroadcastReceiver {
    private static final String ACTION_COCKTAIL_DISABLED = "com.samsung.android.cocktail.action.COCKTAIL_DISABLED";
    private static final String ACTION_COCKTAIL_ENABLED = "com.samsung.android.cocktail.action.COCKTAIL_ENABLED";
    private static final String ACTION_COCKTAIL_UPDATE = "com.samsung.android.cocktail.action.COCKTAIL_UPDATE";
    private static final String ACTION_COCKTAIL_UPDATE_V2 = "com.samsung.android.cocktail.v2.action.COCKTAIL_UPDATE";
    private static final String ACTION_COCKTAIL_VISIBILITY_CHANGED = "com.samsung.android.cocktail.action.COCKTAIL_VISIBILITY_CHANGED";
    private static final String EXTRA_COCKTAIL_ID = "cocktailId";
    private static final String EXTRA_COCKTAIL_IDS = "cocktailIds";
    private static final String EXTRA_COCKTAIL_VISIBILITY = "cocktailVisibility";
    private static final String TAG = "SlookCocktail";

    public void onDisabled(Context context0) {
    }

    public void onEnabled(Context context0) {
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        String s = intent0.getAction();
        if("com.samsung.android.cocktail.action.COCKTAIL_UPDATE".equals(s) || "com.samsung.android.cocktail.v2.action.COCKTAIL_UPDATE".equals(s)) {
            Bundle bundle1 = intent0.getExtras();
            if(bundle1 != null && bundle1.containsKey("cocktailIds")) {
                int[] arr_v = bundle1.getIntArray("cocktailIds");
                this.onUpdate(context0, SlookCocktailManager.getInstance(context0), arr_v);
            }
        }
        else {
            if("com.samsung.android.cocktail.action.COCKTAIL_ENABLED".equals(s)) {
                return;
            }
            if("com.samsung.android.cocktail.action.COCKTAIL_DISABLED".equals(s)) {
                return;
            }
            if("com.samsung.android.cocktail.action.COCKTAIL_VISIBILITY_CHANGED".equals(s)) {
                Bundle bundle0 = intent0.getExtras();
                if(bundle0 != null && bundle0.containsKey("cocktailId")) {
                    int v = bundle0.getInt("cocktailId");
                    if(bundle0.containsKey("cocktailVisibility")) {
                        this.onVisibilityChanged(context0, v, bundle0.getInt("cocktailVisibility"));
                    }
                }
            }
        }
    }

    public void onUpdate(Context context0, SlookCocktailManager slookCocktailManager0, int[] arr_v) {
    }

    public void onVisibilityChanged(Context context0, int v, int v1) {
    }
}

