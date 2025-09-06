package com.melon.log.db;

import Eb.b;
import Eb.i;
import Eb.n;
import androidx.room.H;
import d3.g;
import ie.r;
import kotlin.Metadata;
import z6.f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/melon/log/db/LogDatabase;", "Landroidx/room/H;", "<init>", "()V", "z6/f", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LogDatabase extends H {
    public final r a;
    public final r b;
    public static final f c;
    public static LogDatabase d;

    static {
        LogDatabase.c = new f(11);
    }

    public LogDatabase() {
        this.a = g.Q(new n(this, 0));
        this.b = g.Q(new n(this, 1));
    }

    public abstract i b();

    public abstract b c();
}

