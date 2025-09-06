package com.iloen.melon.activity;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Intent;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.MelonWidgetSettingFragment;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.utils.system.CompatUtils;

public class WidgetSettingActivity extends PopupFragmentActivity {
    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Actor actor0;
        Intent intent0 = this.getIntent();
        if(intent0 == null) {
            return null;
        }
        if("android.appwidget.action.APPWIDGET_CONFIGURE".equals(intent0.getAction())) {
            int v = intent0.getExtras().getInt("appWidgetId", 0);
            if(v > 0) {
                AppWidgetProviderInfo appWidgetProviderInfo0 = AppWidgetManager.getInstance(this).getAppWidgetInfo(v);
                if(appWidgetProviderInfo0 == null) {
                    actor0 = null;
                }
                else {
                    ComponentName componentName0 = appWidgetProviderInfo0.provider;
                    if(componentName0 == null) {
                        actor0 = null;
                    }
                    else {
                        String s = componentName0.getClassName();
                        if("com.iloen.melon.appwidget.MelOnAppWidgetSize21".equals(s)) {
                            actor0 = Actor.Widget_2x1;
                        }
                        else if("com.iloen.melon.appwidget.MelOnAppWidgetSize22".equals(s)) {
                            actor0 = Actor.Widget_2x2;
                        }
                        else if("com.iloen.melon.appwidget.MelOnAppWidgetSize41".equals(s)) {
                            actor0 = Actor.Widget_4x1;
                        }
                        else if("com.iloen.melon.appwidget.MelOnAppWidgetSize42".equals(s)) {
                            actor0 = Actor.Widget_4x2;
                        }
                        else {
                            actor0 = null;
                        }
                    }
                }
                if(actor0 != null) {
                    return MelonWidgetSettingFragment.newInstance(actor0, v);
                }
            }
            return null;
        }
        return MelonWidgetSettingFragment.newInstance(((Actor)CompatUtils.getSerializableExtra(intent0, "com.iloen.melon.intent.extra.actor", Actor.class)));
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }
}

