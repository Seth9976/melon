package androidx.room;

import G4.a;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public abstract class B {
    public void onCreate(@NotNull a a0) {
        q.g(a0, "connection");
        if(a0 instanceof A4.a) {
            this.onCreate(((A4.a)a0).a);
        }
    }

    public void onCreate(H4.a a0) {
        q.g(a0, "db");
    }

    public void onDestructiveMigration(@NotNull a a0) {
        q.g(a0, "connection");
        if(a0 instanceof A4.a) {
            this.onDestructiveMigration(((A4.a)a0).a);
        }
    }

    public void onDestructiveMigration(@NotNull H4.a a0) {
        q.g(a0, "db");
    }

    public void onOpen(@NotNull a a0) {
        q.g(a0, "connection");
        if(a0 instanceof A4.a) {
            this.onOpen(((A4.a)a0).a);
        }
    }

    public abstract void onOpen(H4.a arg1);
}

