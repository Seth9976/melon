package com.iloen.melon.activity.crop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MonitoredActivity extends AppCompatActivity {
    private final ArrayList mListeners;

    public MonitoredActivity() {
        this.mListeners = new ArrayList();
    }

    public void addLifeCycleListener(m m0) {
        if(this.mListeners.contains(m0)) {
            return;
        }
        this.mListeners.add(m0);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        for(Object object0: this.mListeners) {
            ((m)object0).getClass();
        }
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onDestroy() {
        super.onDestroy();
        for(Object object0: this.mListeners) {
            ((o)(((m)object0))).e.run();
            ((o)(((m)object0))).d.removeCallbacks(((o)(((m)object0))).e);
        }
    }

    @Override  // android.app.Activity
    public boolean onSearchRequested() {
        return false;
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onStart() {
        super.onStart();
        for(Object object0: this.mListeners) {
            ((o)(((m)object0))).b.show();
        }
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onStop() {
        super.onStop();
        for(Object object0: this.mListeners) {
            ((o)(((m)object0))).b.hide();
        }
    }

    public void removeLifeCycleListener(m m0) {
        this.mListeners.remove(m0);
    }
}

