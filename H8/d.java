package H8;

import G4.c;
import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import we.k;

public final class d implements k {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public d(int v, String s, String s1, String s2, String s3, String s4) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s = this.f;
        String s1 = this.e;
        String s2 = this.d;
        String s3 = this.c;
        String s4 = this.b;
        if(this.a != 0) {
            q.g(((a)object0), "$this$click");
            ((a)object0).a = s4;
            ((a)object0).b = s3;
            ((a)object0).e = s2;
            ((a)object0).f = s1;
            ((a)object0).g = s;
            return H.a;
        }
        try(c c0 = ((G4.a)object0).l0("UPDATE local_contents SET album_id = ?, album_key = ?, artist_ids = ?, artists = ? WHERE song_id = ?")) {
            c0.e(1, s4);
            c0.e(2, s3);
            c0.e(3, s2);
            c0.e(4, s1);
            c0.e(5, s);
            c0.j0();
            return Q1.c.F(((G4.a)object0));
        }
    }
}

