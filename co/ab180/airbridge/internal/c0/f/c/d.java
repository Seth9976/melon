package co.ab180.airbridge.internal.c0.f.c;

import De.w;
import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ze.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u000B\u0010\fJ$\u0010\u000B\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00022\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u000EH\u0096\u0002¢\u0006\u0004\b\u000B\u0010\u0010J,\u0010\u000B\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00022\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u000E2\u0006\u0010\u0011\u001A\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000B\u0010\u0013R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u0014R\u0014\u0010\u0006\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/c0/f/c/d;", "Lze/c;", "", "", "Landroid/content/SharedPreferences;", "preferences", "name", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "uuid", "", "a", "(Ljava/lang/String;)Z", "thisRef", "LDe/w;", "property", "(Ljava/lang/Object;LDe/w;)Ljava/lang/String;", "value", "Lie/H;", "(Ljava/lang/Object;LDe/w;Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", "b", "Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d implements c {
    private final SharedPreferences a;
    private final String b;

    public d(@NotNull SharedPreferences sharedPreferences0, @NotNull String s) {
        this.a = sharedPreferences0;
        this.b = s;
    }

    private final boolean a(String s) {
        try {
            UUID.fromString(s);
            return true;
        }
        catch(IllegalArgumentException unused_ex) {
            return false;
        }
    }

    @NotNull
    public String a(@NotNull Object object0, @NotNull w w0) {
        String s = this.a.getString(this.b, "");
        if(((s.length() == 0 ? 1 : 0) | true ^ this.a(s)) != 0) {
            s = "862f179a-dc51-4b12-a743-3b8825bdabab";
            this.a.edit().putString(this.b, "862f179a-dc51-4b12-a743-3b8825bdabab").apply();
        }
        return s;
    }

    public void a(@NotNull Object object0, @NotNull w w0, @NotNull String s) {
        throw new UnsupportedOperationException();
    }

    @Override  // ze.b
    public Object getValue(Object object0, w w0) {
        return this.a(object0, w0);
    }

    @Override  // ze.c
    public void setValue(Object object0, w w0, Object object1) {
        this.a(object0, w0, ((String)object1));
    }
}

