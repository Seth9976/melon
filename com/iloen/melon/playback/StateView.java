package com.iloen.melon.playback;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class StateView implements Checkable {
    public interface StateChangeListener {
        void onStateChange(StateView arg1);
    }

    public static final StateView EMPTY_VIEW;
    private int bgIdDisabled;
    private int[] bgIds;
    int id;
    private StateChangeListener mListener;
    private HashMap map;
    private int state;
    private WeakReference viewRef;

    static {
        StateView.EMPTY_VIEW = new StateView(null);
    }

    public StateView(View view0) {
        this.viewRef = new WeakReference(null);
        this.state = 0;
        this.bgIdDisabled = -1;
        this.bgIds = null;
        this.map = new HashMap();
        this.viewRef = new WeakReference(view0);
    }

    private StateView(View view0, int v, int[] arr_v) {
        this.viewRef = new WeakReference(null);
        int v1 = 0;
        this.state = 0;
        this.bgIdDisabled = -1;
        this.bgIds = null;
        this.map = new HashMap();
        this.viewRef = new WeakReference(view0);
        this.bgIdDisabled = v;
        if(arr_v != null) {
            this.bgIds = new int[arr_v.length];
            for(int v2 = 0; v1 < arr_v.length; ++v2) {
                this.bgIds[v2] = arr_v[v1];
                ++v1;
            }
        }
        this.syncState();
    }

    public int getBgId(int v) {
        return this.bgIds == null || this.bgIds.length - 1 < v || v < 0 ? -1 : this.bgIds[v];
    }

    public int getCurrentBgId() {
        return this.getBgId(this.getState());
    }

    public Object getData(String s) {
        return this.map.get(s);
    }

    public static StateView getDisableView(View view0, int v, int v1) {
        return StateView.getStateViewWithDisable(view0, v1, new int[]{v});
    }

    public int getDisabledBgId() {
        return this.bgIdDisabled;
    }

    public int getId() {
        return this.id;
    }

    public static StateView getLoadingView(View view0, int v) {
        return StateView.getStateView(view0, new int[]{v});
    }

    public int getState() {
        synchronized(this) {
        }
        return this.state;
    }

    public static StateView getStateView(View view0, int[] arr_v) {
        return new StateView(view0, -1, arr_v);
    }

    public static StateView getStateViewWithDisable(View view0, int v, int[] arr_v) {
        return new StateView(view0, v, arr_v);
    }

    public static StateView getToggleView(View view0, int v, int v1) {
        return StateView.getStateView(view0, new int[]{v1, v});
    }

    public static StateView getToggleView(View view0, int v, int v1, int v2) {
        return StateView.getStateViewWithDisable(view0, v2, new int[]{v1, v});
    }

    public static StateView getToggleViewWithReply(View view0, int v, int v1, int v2) {
        return StateView.getStateView(view0, new int[]{v1, v, v2});
    }

    public static StateView getView(View view0) {
        return new StateView(view0, -1, new int[0]);
    }

    public View getView() {
        return (View)this.viewRef.get();
    }

    public int getVisibility() {
        View view0 = (View)this.viewRef.get();
        return view0 == null ? 8 : view0.getVisibility();
    }

    private void hitStateChanged() {
        StateChangeListener stateView$StateChangeListener0 = this.mListener;
        if(stateView$StateChangeListener0 != null) {
            stateView$StateChangeListener0.onStateChange(this);
        }
    }

    @Override  // android.widget.Checkable
    public boolean isChecked() {
        return this.state == 1;
    }

    public boolean isEnabled() {
        View view0 = (View)this.viewRef.get();
        return view0 == null ? false : view0.isEnabled();
    }

    public Object removeData(String s) {
        return this.map.remove(s);
    }

    @Override  // android.widget.Checkable
    public void setChecked(boolean z) {
        this.setState(((int)z));
    }

    public void setCheckedWithReply(int v) {
        this.setState(v);
    }

    public void setData(String s, Object object0) {
        this.map.put(s, object0);
    }

    public void setEnabled(boolean z) {
        synchronized(this) {
            View view0 = (View)this.viewRef.get();
            if(view0 != null) {
                if(this.bgIdDisabled == -1) {
                    ViewUtils.setEnable(view0, z);
                }
                else {
                    view0.setEnabled(z);
                }
                this.syncState();
                this.hitStateChanged();
            }
        }
    }

    public int setId(int v) {
        this.id = v;
        return v;
    }

    public void setListener(StateChangeListener stateView$StateChangeListener0) {
        this.mListener = stateView$StateChangeListener0;
    }

    public void setSelected(boolean z) {
        synchronized(this) {
            View view0 = (View)this.viewRef.get();
            if(view0 != null) {
                view0.setSelected(z);
            }
        }
    }

    public void setState(int v) {
        synchronized(this) {
            if(this.state != v) {
                this.state = v;
                this.syncState();
                this.hitStateChanged();
            }
        }
    }

    public void setVisibility(int v) {
        View view0 = (View)this.viewRef.get();
        if(view0 != null) {
            view0.setVisibility(v);
        }
    }

    public void syncState() {
        LogU.d("ViewUtils", "syncState() " + this.toString());
        View view0 = (View)this.viewRef.get();
        if(view0 != null) {
            if(view0.isEnabled()) {
                int v = this.getCurrentBgId();
                if(v != -1) {
                    this.updateViewResource(view0, v);
                }
            }
            else {
                int v1 = this.bgIdDisabled;
                if(v1 != -1) {
                    this.updateViewResource(view0, v1);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "StateView {id:" + this.id + ", state:" + this.state + ", view:" + this.viewRef.get() + "}";
    }

    @Override  // android.widget.Checkable
    public void toggle() {
        this.setChecked(!this.isChecked());
    }

    private void updateViewResource(View view0, int v) {
        if(view0 == null) {
            return;
        }
        if(view0 instanceof TextView) {
            Drawable[] arr_drawable = ((TextView)view0).getCompoundDrawables();
            if(arr_drawable != null && arr_drawable.length > 0) {
                for(int v1 = 0; v1 < arr_drawable.length; ++v1) {
                    if(arr_drawable[v1] != null) {
                        Drawable drawable0 = view0.getContext().getResources().getDrawable(v);
                        drawable0.setBounds(0, 0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight());
                        arr_drawable[v1] = drawable0;
                    }
                }
                ((TextView)view0).setCompoundDrawables(arr_drawable[0], arr_drawable[1], arr_drawable[2], arr_drawable[3]);
                return;
            }
            view0.setBackgroundResource(v);
            return;
        }
        if(view0 instanceof ImageView) {
            if(((ImageView)view0).getBackground() != null) {
                view0.setBackgroundResource(v);
                return;
            }
            ((ImageView)view0).setImageResource(v);
            return;
        }
        view0.setBackgroundResource(v);
    }
}

