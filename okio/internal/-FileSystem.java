package okio.internal;

import De.I;
import Q0.W0;
import Sf.k;
import Sf.l;
import Sf.m;
import d5.n;
import ie.H;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u001B\u0010\u0004\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u001B\u0010\u0007\u001A\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A#\u0010\f\u001A\u00020\u000B*\u00020\u00002\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\r\u001A#\u0010\u0010\u001A\u00020\u000B*\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001A#\u0010\u0014\u001A\u00020\u000B*\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u0014\u0010\r\u001A)\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00010\u0016*\u00020\u00002\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001AH\u0010\u001E\u001A\u00020\u000B*\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u001A\u001A\u00020\u00002\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00010\u001B2\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u0006H\u0080@¢\u0006\u0004\b\u001E\u0010\u001F\u001A\u001D\u0010 \u001A\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lokio/FileSystem;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "commonMetadata", "(Lokio/FileSystem;Lokio/Path;)Lokio/FileMetadata;", "", "commonExists", "(Lokio/FileSystem;Lokio/Path;)Z", "dir", "mustCreate", "Lie/H;", "commonCreateDirectories", "(Lokio/FileSystem;Lokio/Path;Z)V", "source", "target", "commonCopy", "(Lokio/FileSystem;Lokio/Path;Lokio/Path;)V", "fileOrDirectory", "mustExist", "commonDeleteRecursively", "followSymlinks", "LSf/k;", "commonListRecursively", "(Lokio/FileSystem;Lokio/Path;Z)LSf/k;", "LSf/m;", "fileSystem", "Lje/m;", "stack", "postorder", "collectRecursively", "(LSf/m;Lokio/FileSystem;Lje/m;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "symlinkTarget", "(Lokio/FileSystem;Lokio/Path;)Lokio/Path;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -FileSystem {
    @Nullable
    public static final Object collectRecursively(@NotNull m m0, @NotNull FileSystem fileSystem0, @NotNull je.m m1, @NotNull Path path0, boolean z, boolean z1, @NotNull Continuation continuation0) {
        Iterator iterator0;
        boolean z5;
        Path path4;
        FileSystem fileSystem1;
        boolean z2;
        m m3;
        je.m m2;
        okio.internal.-FileSystem.collectRecursively.1 -FileSystem$collectRecursively$10;
        if(continuation0 instanceof okio.internal.-FileSystem.collectRecursively.1) {
            -FileSystem$collectRecursively$10 = (okio.internal.-FileSystem.collectRecursively.1)continuation0;
            int v = -FileSystem$collectRecursively$10.label;
            if((v & 0x80000000) == 0) {
                -FileSystem$collectRecursively$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    boolean Z$0;
                    boolean Z$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return -FileSystem.collectRecursively(null, null, null, null, false, false, this);
                    }
                };
            }
            else {
                -FileSystem$collectRecursively$10.label = v ^ 0x80000000;
            }
        }
        else {
            -FileSystem$collectRecursively$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                boolean Z$0;
                boolean Z$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return -FileSystem.collectRecursively(null, null, null, null, false, false, this);
                }
            };
        }
        Object object0 = -FileSystem$collectRecursively$10.result;
        a a0 = a.a;
        H h0 = H.a;
        switch(-FileSystem$collectRecursively$10.label) {
            case 0: {
                n.D(object0);
                if(!z1) {
                    -FileSystem$collectRecursively$10.L$0 = m0;
                    -FileSystem$collectRecursively$10.L$1 = fileSystem0;
                    -FileSystem$collectRecursively$10.L$2 = m1;
                    -FileSystem$collectRecursively$10.L$3 = path0;
                    -FileSystem$collectRecursively$10.Z$0 = z;
                    -FileSystem$collectRecursively$10.Z$1 = false;
                    -FileSystem$collectRecursively$10.label = 1;
                    m0.a(path0, -FileSystem$collectRecursively$10);
                    return a0;
                }
                m2 = m1;
                m3 = m0;
                z2 = z;
                fileSystem1 = fileSystem0;
                goto label_42;
            }
            case 1: {
                boolean z3 = -FileSystem$collectRecursively$10.Z$1;
                boolean z4 = -FileSystem$collectRecursively$10.Z$0;
                Path path1 = (Path)-FileSystem$collectRecursively$10.L$3;
                m2 = (je.m)-FileSystem$collectRecursively$10.L$2;
                fileSystem1 = (FileSystem)-FileSystem$collectRecursively$10.L$1;
                m3 = (m)-FileSystem$collectRecursively$10.L$0;
                n.D(object0);
                z1 = z3;
                z2 = z4;
                path0 = path1;
            label_42:
                List list0 = fileSystem1.listOrNull(path0);
                if(list0 == null) {
                    list0 = w.a;
                }
                if(!list0.isEmpty()) {
                    int v1 = 0;
                    Path path2 = path0;
                    while(true) {
                        if(z2 && m2.contains(path2)) {
                            throw new IOException("symlink cycle at " + path0);
                        }
                        Path path3 = -FileSystem.symlinkTarget(fileSystem1, path2);
                        if(path3 == null) {
                            if(!z2 && v1 != 0) {
                                break;
                            }
                            m2.addLast(path2);
                            try {
                                path4 = path0;
                                z5 = z1;
                                iterator0 = list0.iterator();
                                goto label_75;
                            }
                            catch(Throwable throwable0) {
                                goto label_88;
                            }
                        }
                        ++v1;
                        path2 = path3;
                    }
                }
                goto label_102;
            }
            case 2: {
                break;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        boolean z6 = -FileSystem$collectRecursively$10.Z$1;
        boolean z7 = -FileSystem$collectRecursively$10.Z$0;
        iterator0 = (Iterator)-FileSystem$collectRecursively$10.L$4;
        Path path5 = (Path)-FileSystem$collectRecursively$10.L$3;
        je.m m4 = (je.m)-FileSystem$collectRecursively$10.L$2;
        FileSystem fileSystem2 = (FileSystem)-FileSystem$collectRecursively$10.L$1;
        m m5 = (m)-FileSystem$collectRecursively$10.L$0;
        try {
            n.D(object0);
            z5 = z6;
            z2 = z7;
            path4 = path5;
        }
        catch(Throwable throwable0) {
            m4.removeLast();
            throw throwable0;
        }
        while(true) {
            m2 = m4;
            fileSystem1 = fileSystem2;
            m3 = m5;
            try {
            label_75:
                if(!iterator0.hasNext()) {
                    goto label_99;
                }
                Object object1 = iterator0.next();
                Path path6 = (Path)object1;
                -FileSystem$collectRecursively$10.L$0 = m3;
                -FileSystem$collectRecursively$10.L$1 = fileSystem1;
                -FileSystem$collectRecursively$10.L$2 = m2;
                -FileSystem$collectRecursively$10.L$3 = path4;
                -FileSystem$collectRecursively$10.L$4 = iterator0;
                -FileSystem$collectRecursively$10.Z$0 = z2;
                -FileSystem$collectRecursively$10.Z$1 = z5;
                -FileSystem$collectRecursively$10.label = 2;
            }
            catch(Throwable throwable0) {
            label_88:
                m4 = m2;
                break;
            }
            try {
                m5 = m3;
                fileSystem2 = fileSystem1;
                m4 = m2;
                if(-FileSystem.collectRecursively(m3, fileSystem1, m2, path6, z2, z5, -FileSystem$collectRecursively$10) != a0) {
                    continue;
                }
                return a0;
            }
            catch(Throwable throwable0) {
            }
            break;
        }
        m4.removeLast();
        throw throwable0;
    label_99:
        m2.removeLast();
        z1 = z5;
        path0 = path4;
    label_102:
        if(z1) {
            -FileSystem$collectRecursively$10.L$0 = null;
            -FileSystem$collectRecursively$10.L$1 = null;
            -FileSystem$collectRecursively$10.L$2 = null;
            -FileSystem$collectRecursively$10.L$3 = null;
            -FileSystem$collectRecursively$10.L$4 = null;
            -FileSystem$collectRecursively$10.label = 3;
            m3.a(path0, -FileSystem$collectRecursively$10);
            return a0;
        }
        return h0;
    }

    public static final void commonCopy(@NotNull FileSystem fileSystem0, @NotNull Path path0, @NotNull Path path1) {
        Throwable throwable4;
        Long long0;
        BufferedSink bufferedSink0;
        q.g(fileSystem0, "<this>");
        q.g(path0, "source");
        q.g(path1, "target");
        Source source0 = fileSystem0.source(path0);
        Throwable throwable0 = null;
        try {
            bufferedSink0 = Okio.buffer(FileSystem.sink$default(fileSystem0, path1, false, 2, null));
        }
        catch(Throwable throwable1) {
            goto label_26;
        }
        try {
            long0 = bufferedSink0.writeAll(source0);
        }
        catch(Throwable throwable2) {
            if(bufferedSink0 != null) {
                try {
                    bufferedSink0.close();
                }
                catch(Throwable throwable3) {
                    try {
                        e2.a.q(throwable2, throwable3);
                        throwable4 = throwable2;
                        long0 = null;
                        goto label_21;
                    }
                    catch(Throwable throwable1) {
                        goto label_26;
                    }
                }
            }
            throwable4 = throwable2;
            long0 = null;
            goto label_21;
        }
        try {
            bufferedSink0.close();
            throwable4 = null;
        }
        catch(Throwable throwable4) {
        }
        try {
        label_21:
            if(throwable4 != null) {
                throw throwable4;
            }
            long0.longValue();
            goto label_33;
        label_26:
            if(source0 != null) {
                goto label_27;
            }
            throwable0 = throwable1;
            goto label_37;
        }
        catch(Throwable throwable1) {
            goto label_26;
        }
        try {
        label_27:
            source0.close();
        }
        catch(Throwable throwable5) {
            e2.a.q(throwable1, throwable5);
        }
        throwable0 = throwable1;
        goto label_37;
    label_33:
        if(source0 != null) {
            try {
                source0.close();
            }
            catch(Throwable throwable0) {
            }
        }
    label_37:
        if(throwable0 != null) {
            throw throwable0;
        }
    }

    public static final void commonCreateDirectories(@NotNull FileSystem fileSystem0, @NotNull Path path0, boolean z) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "dir");
        je.m m0 = new je.m();
        for(Path path1 = path0; path1 != null && !fileSystem0.exists(path1); path1 = path1.parent()) {
            m0.addFirst(path1);
        }
        if(z && m0.isEmpty()) {
            throw new IOException(path0 + " already exists.");
        }
        for(Object object0: m0) {
            FileSystem.createDirectory$default(fileSystem0, ((Path)object0), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(@NotNull FileSystem fileSystem0, @NotNull Path path0, boolean z) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "fileOrDirectory");
        l l0 = I.P(new we.n(fileSystem0, path0, null) {
            final Path $fileOrDirectory;
            final FileSystem $this_commonDeleteRecursively;
            private Object L$0;
            int label;

            {
                this.$this_commonDeleteRecursively = fileSystem0;
                this.$fileOrDirectory = path0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new okio.internal.-FileSystem.commonDeleteRecursively.sequence.1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            public final Object invoke(m m0, Continuation continuation0) {
                return ((okio.internal.-FileSystem.commonDeleteRecursively.sequence.1)this.create(m0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((m)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        m m0 = (m)this.L$0;
                        je.m m1 = new je.m();
                        this.label = 1;
                        return -FileSystem.collectRecursively(m0, this.$this_commonDeleteRecursively, m1, this.$fileOrDirectory, false, true, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        });
        while(l0.hasNext()) {
            fileSystem0.delete(((Path)l0.next()), z && !l0.hasNext());
        }
    }

    public static final boolean commonExists(@NotNull FileSystem fileSystem0, @NotNull Path path0) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "path");
        return fileSystem0.metadataOrNull(path0) != null;
    }

    @NotNull
    public static final k commonListRecursively(@NotNull FileSystem fileSystem0, @NotNull Path path0, boolean z) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "dir");
        return new W0(new we.n(path0, fileSystem0, z, null) {
            final Path $dir;
            final boolean $followSymlinks;
            final FileSystem $this_commonListRecursively;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                this.$dir = path0;
                this.$this_commonListRecursively = fileSystem0;
                this.$followSymlinks = z;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new okio.internal.-FileSystem.commonListRecursively.1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            public final Object invoke(m m0, Continuation continuation0) {
                return ((okio.internal.-FileSystem.commonListRecursively.1)this.create(m0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((m)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Iterator iterator0;
                je.m m3;
                m m2;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        m m0 = (m)this.L$0;
                        je.m m1 = new je.m();
                        m1.addLast(this.$dir);
                        m2 = m0;
                        m3 = m1;
                        iterator0 = this.$this_commonListRecursively.list(this.$dir).iterator();
                        break;
                    }
                    case 1: {
                        iterator0 = (Iterator)this.L$2;
                        je.m m4 = (je.m)this.L$1;
                        m2 = (m)this.L$0;
                        n.D(object0);
                        m3 = m4;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    this.L$0 = m2;
                    this.L$1 = m3;
                    this.L$2 = iterator0;
                    this.label = 1;
                    if(-FileSystem.collectRecursively(m2, this.$this_commonListRecursively, m3, ((Path)object1), this.$followSymlinks, false, this) == a0) {
                        return a0;
                    }
                    if(false) {
                        break;
                    }
                }
                return H.a;
            }
        });
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull FileSystem fileSystem0, @NotNull Path path0) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "path");
        FileMetadata fileMetadata0 = fileSystem0.metadataOrNull(path0);
        if(fileMetadata0 == null) {
            throw new FileNotFoundException("no such file: " + path0);
        }
        return fileMetadata0;
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull FileSystem fileSystem0, @NotNull Path path0) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "path");
        Path path1 = fileSystem0.metadata(path0).getSymlinkTarget();
        if(path1 == null) {
            return null;
        }
        Path path2 = path0.parent();
        q.d(path2);
        return path2.resolve(path1);
    }
}

