package com.iloen.melon.popup;

import A8.e;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;

public class MelonUpgradePopup extends MelonBasePopup implements View.OnClickListener {
    public static final int BUTTON_MARKET = 1;
    public static final int BUTTON_NEXT = 3;
    public static final int BUTTON_NONMARKET = 2;
    public static final int BUTTON_TSTORE;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public boolean f;
    public AppVersionInfo g;
    public Intent h;

    public MelonUpgradePopup(Activity activity0, int v) {
        super(activity0, v);
        this.a = null;
        this.f = false;
    }

    public Intent getUpdateIntent() {
        return this.h;
    }

    public boolean isCentFlag() {
        return this.f;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v;
        if(view0 == this.b) {
            v = 0;
        }
        else if(view0 == this.c) {
            v = 1;
        }
        else if(view0 == this.d) {
            v = 2;
        }
        else {
            v = view0 == this.e ? 3 : -2;
        }
        DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
        if(dialogInterface$OnClickListener0 != null) {
            dialogInterface$OnClickListener0.onClick(this, v);
        }
        this.dismiss();
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        boolean z = false;
        this.setCancelable(false);
        ((TextView)this.findViewById(0x7F0A0782)).setText(this.getTitleName());  // id:list_title
        TextView textView0 = (TextView)this.findViewById(0x7F0A0C67);  // id:tv_dlg_message
        this.a = textView0;
        textView0.setText(this.getBodyMsg());
        if(this.isCentFlag()) {
            this.a.setGravity(17);
        }
        this.b = (TextView)this.findViewById(0x7F0A0BEC);  // id:tstore
        this.c = (TextView)this.findViewById(0x7F0A07D1);  // id:market
        this.d = (TextView)this.findViewById(0x7F0A08BB);  // id:nonmarket
        this.e = (TextView)this.findViewById(0x7F0A08B0);  // id:next
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        if(this.g == null || this.g.d.equals("")) {
            this.c.setVisibility(8);
        }
        if(this.g == null || this.g.e.equals("")) {
            this.b.setVisibility(8);
        }
        else {
            String s = this.g.e;
            LogU.v("MelonUpgradePopup", "onCreate() url2 : " + s);
            if(s.startsWith("tstore://")) {
                String s1 = s.substring(9);
                LogU.v("MelonUpgradePopup", "onCreate() shopViewStr:" + s1);
                Intent intent0 = new Intent();
                this.h = intent0;
                intent0.setFlags(0x20000000);
                this.h.setClassName("com.skt.skaf.A000Z00040", "com.skt.skaf.A000Z00040.A000Z00040");
                this.h.setAction("COLLAB_ACTION");
                this.h.putExtra("com.skt.skaf.COL.URI", s1.getBytes());
                this.h.putExtra("com.skt.skaf.COL.REQUESTER", "A000Z00040");
                if(this.getContext().getPackageManager().queryIntentActivities(this.h, 0x10000).size() <= 0) {
                    this.b.setVisibility(8);
                }
            }
            else {
                this.b.setVisibility(8);
            }
        }
        if(this.g != null && !this.g.f.equals("")) {
            this.d.setVisibility(8);
        }
        if(MelonAppBase.instance.getDeviceData().c() == e.b) {
            try {
                String s2 = new BufferedReader(new InputStreamReader(new DataInputStream(Runtime.getRuntime().exec("getprop ro.cts.cert").getInputStream()), "UTF-8")).readLine();
                LogU.i("MelonUpgradePopup", "isCTSCert() str : " + s2);
                z = "1".equalsIgnoreCase(s2);
            }
            catch(Exception exception0) {
                Z.v(exception0, new StringBuilder("isCTSCert() "), "MelonUpgradePopup");
            }
            LogU.v("MelonUpgradePopup", "onCreate() ctsCert: " + z);
            boolean z1 = AppUtils.checkExistApplication(this.getContext(), "com.android.vending");
            LogU.v("MelonUpgradePopup", "onCreate() isExistVendingApp: " + z1);
            if(!z && !z1) {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
                return;
            }
        }
        this.d.setVisibility(8);
    }

    public void setCentFlag(boolean z) {
        this.f = z;
    }

    public void setUpgradeInfo(AppVersionInfo appVersionInfo0) {
        this.g = appVersionInfo0;
    }
}

