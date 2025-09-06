package com.iloen.melon.analytics;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v3x.ClickLogReq;
import com.iloen.melon.task.ReportService;
import d5.s;

public class ClickLog {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public ClickLog(s s0) {
        this.a = (String)s0.a;
        this.b = (String)s0.b;
        this.c = (String)s0.c;
        this.d = (String)s0.d;
        this.e = (String)s0.e;
        this.f = (String)s0.f;
        this.g = (String)s0.g;
        this.h = (String)s0.h;
        this.i = (String)s0.i;
        this.j = (String)s0.j;
        this.k = (String)s0.k;
        this.l = (String)s0.l;
        this.m = (String)s0.m;
        this.n = (String)s0.n;
    }

    public final void a() {
        ReportService.sendLogging(new ClickLogReq(MelonAppBase.instance.getContext(), this));
    }
}

