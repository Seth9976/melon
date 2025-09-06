package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.cast.framework.R.layout;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class zzbq extends ArrayAdapter implements View.OnClickListener {
    private final Context zza;
    private int zzb;

    public zzbq(Context context0, List list0, int v) {
        if(list0 == null) {
            list0 = new ArrayList();
        }
        super(context0, 0x7F0D0134, list0);  // layout:cast_tracks_chooser_dialog_row_layout
        this.zza = context0;
        this.zzb = v;
    }

    @Override  // android.widget.ArrayAdapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        zzbo zzbo0;
        boolean z = false;
        if(view0 == null) {
            view0 = ((LayoutInflater)Preconditions.checkNotNull(((LayoutInflater)this.zza.getSystemService("layout_inflater")))).inflate(layout.cast_tracks_chooser_dialog_row_layout, viewGroup0, false);
            zzbo0 = new zzbo(this, ((TextView)view0.findViewById(id.text)), ((RadioButton)view0.findViewById(id.radio)), null);
            view0.setTag(zzbo0);
        }
        else {
            zzbo0 = (zzbo)Preconditions.checkNotNull(((zzbo)view0.getTag()));
        }
        RadioButton radioButton0 = zzbo0.zzb;
        radioButton0.setTag(v);
        if(this.zzb == v) {
            z = true;
        }
        radioButton0.setChecked(z);
        view0.setOnClickListener(this);
        MediaTrack mediaTrack0 = (MediaTrack)Preconditions.checkNotNull(((MediaTrack)this.getItem(v)));
        String s = mediaTrack0.getName();
        Locale locale0 = mediaTrack0.getLanguageLocale();
        if(TextUtils.isEmpty(s)) {
            if(mediaTrack0.getSubtype() == 2) {
                s = this.zza.getString(string.cast_tracks_chooser_dialog_closed_captions);
            }
            else if(locale0 == null) {
                s = this.zza.getString(string.cast_tracks_chooser_dialog_default_track_name, new Object[]{((int)(v + 1))});
            }
            else {
                s = locale0.getDisplayLanguage();
                if(TextUtils.isEmpty(s)) {
                    s = this.zza.getString(string.cast_tracks_chooser_dialog_default_track_name, new Object[]{((int)(v + 1))});
                }
            }
        }
        zzbo0.zza.setText(s);
        return view0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        this.zzb = (int)(((Integer)Preconditions.checkNotNull(((zzbo)Preconditions.checkNotNull(((zzbo)view0.getTag()))).zzb.getTag())));
        this.notifyDataSetChanged();
    }

    public final MediaTrack zza() {
        return this.zzb < 0 || this.zzb >= this.getCount() ? null : ((MediaTrack)this.getItem(this.zzb));
    }
}

