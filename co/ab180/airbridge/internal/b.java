package co.ab180.airbridge.internal;

import Tf.o;
import U4.x;
import android.util.Log;
import ie.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lco/ab180/airbridge/internal/b;", "", "<init>", "()V", "e", "a", "b", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003JC\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J1\u0010\u0011\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0013\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0011\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0015J1\u0010\u0016\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0012J;\u0010\u0016\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u0016\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0015J1\u0010\u0013\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0012J;\u0010\u000F\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0014J\u0019\u0010\u0013\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0015J1\u0010\u0017\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0012J;\u0010\u0011\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0014J\u0019\u0010\u0017\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0015J1\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\r\u0010\u0012J;\u0010\r\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\r\u0010\u0014J\u0019\u0010\r\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\r\u0010\u0015J1\u0010\u0018\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0012J;\u0010\u0017\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0014J\u0019\u0010\u0018\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0015J9\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0019JC\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0016\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u000EJ!\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u001AJ\u0017\u0010\u0016\u001A\u00020\u001B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0015\u00A2\u0006\u0004\b\u0016\u0010\u001CJ!\u0010\u0016\u001A\u00020\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u001EJ)\u0010\u000F\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0010\u0010\u000B\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\nH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u001FJ3\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u001D\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H$\u00A2\u0006\u0004\b\u0016\u0010 R\u001A\u0010\u001D\u001A\u00020\b8\u0010X\u0090D\u00A2\u0006\f\n\u0004\b\u0016\u0010!\u001A\u0004\b\u0016\u0010\"\u00A8\u0006#"}, d2 = {"co/ab180/airbridge/internal/b$a", "", "<init>", "()V", "", "priority", "", "t", "", "message", "", "args", "Lie/H;", "b", "(ILjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "c", "(Ljava/lang/Throwable;)Ljava/lang/String;", "e", "(Ljava/lang/String;[Ljava/lang/Object;)V", "d", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;)V", "a", "f", "g", "(ILjava/lang/String;[Ljava/lang/Object;)V", "(ILjava/lang/Throwable;)V", "", "(I)Z", "tag", "(Ljava/lang/String;I)Z", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Ljava/lang/String;", "()Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static abstract class a {
        @NotNull
        private final String a;

        public a() {
            this.a = "Airbridge";
        }

        @NotNull
        public String a() [...] // 潜在的解密器

        public abstract void a(int arg1, @Nullable String arg2, @NotNull String arg3, @Nullable Throwable arg4);

        public void a(int v, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(v, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void a(int v, @Nullable Throwable throwable0) {
            this.b(v, throwable0, null, new Object[0]);
        }

        public void a(int v, @Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(v, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void a(@Nullable String s, @NotNull Object[] arr_object) {
            this.b(3, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void a(@Nullable Throwable throwable0) {
            this.b(3, throwable0, null, new Object[0]);
        }

        public void a(@Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(3, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        @d
        public boolean a(int v) {
            return true;
        }

        public boolean a(@Nullable String s, int v) [...] // Inlined contents

        private final void b(int v, Throwable throwable0, String s, Object[] arr_object) {
            if(s == null || s.length() == 0) {
                if(throwable0 == null) {
                    return;
                }
                s = this.c(throwable0);
            }
            else {
                if(arr_object.length != 0) {
                    s = this.c(s, arr_object);
                }
                if(throwable0 != null) {
                    StringBuilder stringBuilder0 = x.p(s, "\n");
                    stringBuilder0.append(this.c(throwable0));
                    s = stringBuilder0.toString();
                }
            }
            this.a(v, "Airbridge", s, throwable0);
        }

        public void b(@Nullable String s, @NotNull Object[] arr_object) {
            this.b(6, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void b(@Nullable Throwable throwable0) {
            this.b(6, throwable0, null, new Object[0]);
        }

        public void b(@Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(6, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        private final String c(Throwable throwable0) {
            StringWriter stringWriter0 = new StringWriter(0x100);
            PrintWriter printWriter0 = new PrintWriter(stringWriter0, false);
            throwable0.printStackTrace(printWriter0);
            printWriter0.flush();
            return stringWriter0.toString();
        }

        @NotNull
        public String c(@NotNull String s, @NotNull Object[] arr_object) {
            Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
            return String.format(s, Arrays.copyOf(arr_object1, arr_object1.length));
        }

        public void c(@Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(4, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void d(@Nullable String s, @NotNull Object[] arr_object) {
            this.b(4, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void d(@Nullable Throwable throwable0) {
            this.b(4, throwable0, null, new Object[0]);
        }

        public void d(@Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(2, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void e(@Nullable String s, @NotNull Object[] arr_object) {
            this.b(2, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void e(@Nullable Throwable throwable0) {
            this.b(2, throwable0, null, new Object[0]);
        }

        public void e(@Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(5, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void f(@Nullable String s, @NotNull Object[] arr_object) {
            this.b(5, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void f(@Nullable Throwable throwable0) {
            this.b(5, throwable0, null, new Object[0]);
        }

        public void f(@Nullable Throwable throwable0, @Nullable String s, @NotNull Object[] arr_object) {
            this.b(7, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void g(@Nullable String s, @NotNull Object[] arr_object) {
            this.b(7, null, s, Arrays.copyOf(arr_object, arr_object.length));
        }

        public void g(@Nullable Throwable throwable0) {
            this.b(7, throwable0, null, new Object[0]);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000E\u001A\u00020\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u000E\u0010\u000FJ=\u0010\u0012\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u000E\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u000E\u0010\u0014J3\u0010\u0015\u001A\u00020\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0015\u0010\u000FJ=\u0010\u0015\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0015\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u0015\u0010\u0014J3\u0010\u0012\u001A\u00020\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0012\u0010\u000FJ=\u0010\u0016\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0016\u0010\u0013J\u0019\u0010\u0012\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u0012\u0010\u0014J3\u0010\u0017\u001A\u00020\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0017\u0010\u000FJ=\u0010\u000E\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u000E\u0010\u0013J\u0019\u0010\u0017\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u0017\u0010\u0014J3\u0010\u0007\u001A\u00020\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0007\u0010\u000FJ=\u0010\u0007\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0007\u0010\u0013J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u0007\u0010\u0014J3\u0010\u0018\u001A\u00020\u00062\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0018\u0010\u000FJ=\u0010\u0017\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0017\u0010\u0013J\u0019\u0010\u0018\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u0018\u0010\u0014J;\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0015\u0010\u0019JE\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t2\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000B\"\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u0015\u0010\u001AJ!\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0017\u00A2\u0006\u0004\b\u0015\u0010\u001BJ3\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u001C\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\t2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u001DJ\u0010\u0010\u0007\u001A\u00020\u0001H\u0097\b\u00A2\u0006\u0004\b\u0007\u0010\u001EJ\u0017\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u0001H\u0007\u00A2\u0006\u0004\b\u0015\u0010 J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u0001H\u0007\u00A2\u0006\u0004\b\u0007\u0010 J\u000F\u0010\u000E\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u000E\u0010\u0003J\u0015\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00010!H\u0007\u00A2\u0006\u0004\b\u0016\u0010\"J#\u0010\u0015\u001A\u00020\u00062\u0012\u0010#\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000B\"\u00020\u0001H\u0007\u00A2\u0006\u0004\b\u0015\u0010$R\u0011\u0010&\u001A\u00020\u00048G\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010%R\u0014\u0010\'\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u001C\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R$\u0010#\u001A\u0012\u0012\u0004\u0012\u00020\u00010+j\b\u0012\u0004\u0012\u00020\u0001`,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010-R\u0016\u0010.\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010(\u00A8\u0006/"}, d2 = {"co/ab180/airbridge/internal/b$b", "Lco/ab180/airbridge/internal/b$a;", "<init>", "()V", "", "priority", "Lie/H;", "b", "(I)V", "", "message", "", "", "args", "e", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "d", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;)V", "a", "c", "f", "g", "(ILjava/lang/String;[Ljava/lang/Object;)V", "(ILjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(ILjava/lang/Throwable;)V", "tag", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "()Lco/ab180/airbridge/internal/b$a;", "interceptor", "(Lco/ab180/airbridge/internal/b$a;)V", "", "()Ljava/util/List;", "interceptors", "([Lco/ab180/airbridge/internal/AirbridgeLogger$Interceptor;)V", "()I", "interceptorCount", "MAX_LOG_LENGTH", "I", "interceptorArray", "[Lco/ab180/airbridge/internal/AirbridgeLogger$Interceptor;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "logLevel", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.b.b extends a {
        private co.ab180.airbridge.internal.b.b() {
        }

        public co.ab180.airbridge.internal.b.b(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(int v, @Nullable String s, @NotNull String s1, @Nullable Throwable throwable0) {
            if(s1.length() < 4000) {
                if(v == 7) {
                    Log.wtf(s, s1);
                    return;
                }
                Log.println(v, s, s1);
                return;
            }
            int v1 = s1.length();
            long v2 = System.currentTimeMillis();
            int v3 = 1;
            for(int v4 = 0; v4 < v1; v4 = v6 + 1) {
                int v5 = o.E0(s1, '\n', v4, 4);
                if(v5 == -1) {
                    v5 = v1;
                }
                while(true) {
                    int v6 = Math.min(v5, v4 + 4000);
                    String s2 = s1.substring(v4, v6) + "log{page=" + v3 + '/' + (v1 / 4000 + 1) + ", id=" + v2 + '}';
                    if(v == 7) {
                        Log.wtf(s, s2);
                    }
                    else {
                        Log.println(v, s, s2);
                    }
                    ++v3;
                    if(v6 >= v5) {
                        break;
                    }
                    v4 = v6;
                }
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(int v, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            if(v >= 4) {
                super.a(v, s, Arrays.copyOf(arr_object, arr_object.length));
            }
            a[] arr_b$a = b.d;
            for(int v1 = 0; v1 < arr_b$a.length; ++v1) {
                arr_b$a[v1].a(v, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(int v, @Nullable Throwable throwable0) {
            if(v >= 4) {
                super.a(v, throwable0);
            }
            a[] arr_b$a = b.d;
            for(int v1 = 0; v1 < arr_b$a.length; ++v1) {
                arr_b$a[v1].a(v, throwable0);
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(int v, @Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            if(v >= 4) {
                super.a(v, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
            a[] arr_b$a = b.d;
            for(int v1 = 0; v1 < arr_b$a.length; ++v1) {
                arr_b$a[v1].a(v, throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        public final void a(@NotNull a b$a0) {
            if(b$a0 == this) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
            synchronized(b.c) {
                b.c.add(b$a0);
                Object[] arr_object = b.c.toArray(new a[0]);
                if(arr_object != null) {
                    b.d = (a[])arr_object;
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].a(s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(@Nullable Throwable throwable0) {
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].a(throwable0);
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void a(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].a(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        public final void a(@NotNull a[] arr_b$a) {
            for(int v = 0; v < arr_b$a.length; ++v) {
                if(arr_b$a[v] == this) {
                    throw new IllegalArgumentException("Cannot plant Timber into itself.");
                }
            }
            synchronized(b.c) {
                Collections.addAll(b.c, ((a[])Arrays.copyOf(arr_b$a, arr_b$a.length)));
                Object[] arr_object = b.c.toArray(new a[0]);
                if(arr_object != null) {
                    b.d = (a[])arr_object;
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @NotNull
        public a b() [...] // Inlined contents

        public final void b(int v) {
            b.b = v;
        }

        public final void b(@NotNull a b$a0) {
            synchronized(b.c) {
                if(b.c.remove(b$a0)) {
                    Object[] arr_object = b.c.toArray(new a[0]);
                    if(arr_object == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    b.d = (a[])arr_object;
                    return;
                }
            }
            throw new IllegalArgumentException(("Cannot uproot tree which is not planted: " + b$a0).toString());
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void b(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.b(s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].b(s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void b(@Nullable Throwable throwable0) {
            super.b(throwable0);
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].b(throwable0);
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void b(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.b(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].b(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @NotNull
        public final List c() {
            synchronized(b.c) {
                return Collections.unmodifiableList(p.P0(b.c));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void c(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.c(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].c(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        public final int d() [...] // 潜在的解密器

        @Override  // co.ab180.airbridge.internal.b$a
        public void d(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.d(s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].d(s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void d(@Nullable Throwable throwable0) {
            super.d(throwable0);
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].d(throwable0);
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void d(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].d(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        public final void e() {
            synchronized(b.c) {
                b.c.clear();
                b.d = new a[0];
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void e(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].e(s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void e(@Nullable Throwable throwable0) {
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].e(throwable0);
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void e(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.e(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].e(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void f(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.f(s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].f(s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void f(@Nullable Throwable throwable0) {
            super.f(throwable0);
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].f(throwable0);
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void f(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.f(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].f(throwable0, s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void g(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
            super.g(s, Arrays.copyOf(arr_object, arr_object.length));
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].g(s, Arrays.copyOf(arr_object, arr_object.length));
            }
        }

        @Override  // co.ab180.airbridge.internal.b$a
        public void g(@Nullable Throwable throwable0) {
            super.g(throwable0);
            a[] arr_b$a = b.d;
            for(int v = 0; v < arr_b$a.length; ++v) {
                arr_b$a[v].g(throwable0);
            }
        }
    }

    private static final int a = 4000;
    private static int b;
    private static final ArrayList c;
    private static volatile a[] d;
    @NotNull
    public static final co.ab180.airbridge.internal.b.b e;

    static {
        b.e = new co.ab180.airbridge.internal.b.b(null);
        b.b = 4;
        b.c = new ArrayList();
        b.d = new a[0];
    }

    private b() {
        throw new AssertionError();
    }

    public static void a(int v, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.a(v, s, arr_object);
    }

    public static void a(int v, @Nullable Throwable throwable0) {
        b.e.a(v, throwable0);
    }

    public static void a(int v, @Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.a(v, throwable0, s, arr_object);
    }

    public static final void a(@NotNull a b$a0) {
        b.e.a(b$a0);
    }

    public static void a(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.a(s, arr_object);
    }

    public static void a(@Nullable Throwable throwable0) {
        b.e.a(throwable0);
    }

    public static void a(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.a(throwable0, s, arr_object);
    }

    public static final void b(int v) {
        b.e.b(v);
    }

    public static final void b(@NotNull a b$a0) {
        b.e.b(b$a0);
    }

    public static void b(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.b(s, arr_object);
    }

    public static void b(@Nullable Throwable throwable0) {
        b.e.b(throwable0);
    }

    public static void b(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.b(throwable0, s, arr_object);
    }

    public static final void b(@NotNull a[] arr_b$a) {
        b.e.a(arr_b$a);
    }

    public static final int c() [...] // 潜在的解密器

    public static void c(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.d(s, arr_object);
    }

    public static void c(@Nullable Throwable throwable0) {
        b.e.d(throwable0);
    }

    public static void c(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.c(throwable0, s, arr_object);
    }

    @NotNull
    public static a d() {
        return b.e;
    }

    public static void d(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.e(s, arr_object);
    }

    public static void d(@Nullable Throwable throwable0) {
        b.e.e(throwable0);
    }

    public static void d(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.d(throwable0, s, arr_object);
    }

    @NotNull
    public static final List e() {
        return b.e.c();
    }

    public static void e(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.f(s, arr_object);
    }

    public static void e(@Nullable Throwable throwable0) {
        b.e.f(throwable0);
    }

    public static void e(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.e(throwable0, s, arr_object);
    }

    // 去混淆评级： 低(20)
    public static final int f() {
        return 0;
    }

    public static void f(@NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.g(s, arr_object);
    }

    public static void f(@Nullable Throwable throwable0) {
        b.e.g(throwable0);
    }

    public static void f(@Nullable Throwable throwable0, @NonNls @Nullable String s, @NotNull Object[] arr_object) {
        b.e.f(throwable0, s, arr_object);
    }

    public static final void g() {
        b.e.e();
    }
}

