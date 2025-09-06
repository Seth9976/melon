package okio.internal;

import Tf.o;
import Tf.v;
import d3.g;
import ie.j;
import ie.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import jd.e3;
import je.p;
import je.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B#\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0001\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\u000E\u001A\u00020\r*\u00020\tH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ%\u0010\u0012\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u00110\u0010*\u00020\u0002H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011*\u00020\u0014H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011*\u00020\u0014H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0018\u0010\fJ\u001D\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0019\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0019\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0017\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\'\u0010#\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\t2\u0006\u0010!\u001A\u00020\u00042\u0006\u0010\"\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010&\u001A\u0004\u0018\u00010%2\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020(2\u0006\u0010\u001D\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010,\u001A\u00020+2\u0006\u0010\u001D\u001A\u00020\t2\u0006\u0010!\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b,\u0010-J\u001F\u0010.\u001A\u00020+2\u0006\u0010\u001D\u001A\u00020\t2\u0006\u0010\"\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b.\u0010-J\u001F\u00100\u001A\u00020/2\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010!\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b0\u00101J\u001F\u00103\u001A\u00020/2\u0006\u0010)\u001A\u00020\t2\u0006\u00102\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b3\u00104J\u001F\u00105\u001A\u00020/2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\"\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b5\u00101J\u001F\u00106\u001A\u00020/2\u0006\u0010)\u001A\u00020\t2\u0006\u00102\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b6\u00104R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00107R\u0014\u0010\u0006\u001A\u00020\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u00108R-\u0010=\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u00110\u00108BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<\u00A8\u0006?"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "classLoader", "", "indexEagerly", "systemFileSystem", "<init>", "(Ljava/lang/ClassLoader;ZLokio/FileSystem;)V", "Lokio/Path;", "path", "canonicalizeInternal", "(Lokio/Path;)Lokio/Path;", "", "toRelativePath", "(Lokio/Path;)Ljava/lang/String;", "", "Lie/m;", "toClasspathRoots", "(Ljava/lang/ClassLoader;)Ljava/util/List;", "Ljava/net/URL;", "toFileRoot", "(Ljava/net/URL;)Lie/m;", "toJarRoot", "canonicalize", "dir", "list", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "Lie/H;", "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "Ljava/lang/ClassLoader;", "Lokio/FileSystem;", "roots$delegate", "Lie/j;", "getRoots", "()Ljava/util/List;", "roots", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ResourceFileSystem extends FileSystem {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "<init>", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "removeBase", "base", "keepPath", "", "path", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        private final boolean keepPath(Path path0) {
            return !v.i0(path0.name(), ".class", true);
        }

        @NotNull
        public final Path removeBase(@NotNull Path path0, @NotNull Path path1) {
            q.g(path0, "<this>");
            q.g(path1, "base");
            return this.getROOT().resolve(v.o0(o.N0(path0.toString(), path1.toString()), '\\', '/'));
        }
    }

    @NotNull
    private static final Companion Companion;
    @NotNull
    private static final Path ROOT;
    @NotNull
    private final ClassLoader classLoader;
    @NotNull
    private final j roots$delegate;
    @NotNull
    private final FileSystem systemFileSystem;

    static {
        ResourceFileSystem.Companion = new Companion(null);
        ResourceFileSystem.ROOT = okio.Path.Companion.get$default(Path.Companion, "/", false, 1, null);
    }

    public ResourceFileSystem(@NotNull ClassLoader classLoader0, boolean z, @NotNull FileSystem fileSystem0) {
        q.g(classLoader0, "classLoader");
        q.g(fileSystem0, "systemFileSystem");
        super();
        this.classLoader = classLoader0;
        this.systemFileSystem = fileSystem0;
        this.roots$delegate = g.Q(new e3(this, 13));
        if(z) {
            this.getRoots().size();
        }
    }

    public ResourceFileSystem(ClassLoader classLoader0, boolean z, FileSystem fileSystem0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            fileSystem0 = FileSystem.SYSTEM;
        }
        this(classLoader0, z, fileSystem0);
    }

    @Override  // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path path0, boolean z) {
        q.g(path0, "file");
        throw new IOException(this + " is read-only");
    }

    @Override  // okio.FileSystem
    public void atomicMove(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        throw new IOException(this + " is read-only");
    }

    public static List c(ResourceFileSystem resourceFileSystem0) {
        return ResourceFileSystem.roots_delegate$lambda$0(resourceFileSystem0);
    }

    @Override  // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path0) {
        q.g(path0, "path");
        return this.canonicalizeInternal(path0);
    }

    private final Path canonicalizeInternal(Path path0) {
        return ResourceFileSystem.ROOT.resolve(path0, true);
    }

    @Override  // okio.FileSystem
    public void createDirectory(@NotNull Path path0, boolean z) {
        q.g(path0, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override  // okio.FileSystem
    public void createSymlink(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        throw new IOException(this + " is read-only");
    }

    @Override  // okio.FileSystem
    public void delete(@NotNull Path path0, boolean z) {
        q.g(path0, "path");
        throw new IOException(this + " is read-only");
    }

    public static boolean f(ZipEntry zipEntry0) {
        return ResourceFileSystem.toJarRoot$lambda$7(zipEntry0);
    }

    private final List getRoots() {
        return (List)this.roots$delegate.getValue();
    }

    @Override  // okio.FileSystem
    @NotNull
    public List list(@NotNull Path path0) {
        q.g(path0, "dir");
        String s = this.toRelativePath(path0);
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        boolean z = false;
        for(Object object0: this.getRoots()) {
            FileSystem fileSystem0 = (FileSystem)((m)object0).a;
            Path path1 = (Path)((m)object0).b;
            try {
                Iterable iterable0 = fileSystem0.list(path1.resolve(s));
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: iterable0) {
                    if(ResourceFileSystem.Companion.keepPath(((Path)object1))) {
                        arrayList0.add(object1);
                    }
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object2: arrayList0) {
                    arrayList1.add(ResourceFileSystem.Companion.removeBase(((Path)object2), path1));
                }
                u.U(linkedHashSet0, arrayList1);
                z = true;
            }
            catch(IOException unused_ex) {
            }
        }
        if(!z) {
            throw new FileNotFoundException("file not found: " + path0);
        }
        return p.P0(linkedHashSet0);
    }

    @Override  // okio.FileSystem
    @Nullable
    public List listOrNull(@NotNull Path path0) {
        q.g(path0, "dir");
        String s = this.toRelativePath(path0);
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        Iterator iterator0 = this.getRoots().iterator();
        boolean z = false;
        while(true) {
            Iterable iterable0 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            Path path1 = (Path)((m)object0).b;
            Path path2 = path1.resolve(s);
            List list0 = ((FileSystem)((m)object0).a).listOrNull(path2);
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: list0) {
                    if(ResourceFileSystem.Companion.keepPath(((Path)object1))) {
                        arrayList0.add(object1);
                    }
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object2: arrayList0) {
                    arrayList1.add(ResourceFileSystem.Companion.removeBase(((Path)object2), path1));
                }
                iterable0 = arrayList1;
            }
            if(iterable0 != null) {
                u.U(linkedHashSet0, iterable0);
                z = true;
            }
        }
        return z ? p.P0(linkedHashSet0) : null;
    }

    @Override  // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path0) {
        q.g(path0, "path");
        if(!Companion.access$keepPath(ResourceFileSystem.Companion, path0)) {
            return null;
        }
        String s = this.toRelativePath(path0);
        for(Object object0: this.getRoots()) {
            Path path1 = ((Path)((m)object0).b).resolve(s);
            FileMetadata fileMetadata0 = ((FileSystem)((m)object0).a).metadataOrNull(path1);
            if(fileMetadata0 != null) {
                return fileMetadata0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path path0) {
        q.g(path0, "file");
        if(!Companion.access$keepPath(ResourceFileSystem.Companion, path0)) {
            throw new FileNotFoundException("file not found: " + path0);
        }
        String s = this.toRelativePath(path0);
        Iterator iterator0 = this.getRoots().iterator();
    label_4:
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            FileSystem fileSystem0 = (FileSystem)((m)object0).a;
            Path path1 = (Path)((m)object0).b;
            try {
                return fileSystem0.openReadOnly(path1.resolve(s));
            }
            catch(FileNotFoundException unused_ex) {
                goto label_4;
            }
        }
        throw new FileNotFoundException("file not found: " + path0);
    }

    @Override  // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path path0, boolean z, boolean z1) {
        q.g(path0, "file");
        throw new IOException("resources are not writable");
    }

    private static final List roots_delegate$lambda$0(ResourceFileSystem resourceFileSystem0) {
        return resourceFileSystem0.toClasspathRoots(resourceFileSystem0.classLoader);
    }

    @Override  // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path path0, boolean z) {
        q.g(path0, "file");
        throw new IOException(this + " is read-only");
    }

    @Override  // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path path0) {
        q.g(path0, "file");
        if(!ResourceFileSystem.Companion.keepPath(path0)) {
            throw new FileNotFoundException("file not found: " + path0);
        }
        String s = Path.resolve$default(ResourceFileSystem.ROOT, path0, false, 2, null).relativeTo(ResourceFileSystem.ROOT).toString();
        URL uRL0 = this.classLoader.getResource(s);
        if(uRL0 == null) {
            throw new FileNotFoundException("file not found: " + path0);
        }
        URLConnection uRLConnection0 = uRL0.openConnection();
        if(uRLConnection0 instanceof JarURLConnection) {
            ((JarURLConnection)uRLConnection0).setUseCaches(false);
        }
        InputStream inputStream0 = uRLConnection0.getInputStream();
        q.f(inputStream0, "getInputStream(...)");
        return Okio.source(inputStream0);
    }

    private final List toClasspathRoots(ClassLoader classLoader0) {
        Enumeration enumeration0 = classLoader0.getResources("");
        q.f(enumeration0, "getResources(...)");
        ArrayList arrayList0 = Collections.list(enumeration0);
        q.f(arrayList0, "list(...)");
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            q.d(((URL)object0));
            m m0 = this.toFileRoot(((URL)object0));
            if(m0 != null) {
                arrayList1.add(m0);
            }
        }
        Enumeration enumeration1 = classLoader0.getResources("META-INF/MANIFEST.MF");
        q.f(enumeration1, "getResources(...)");
        ArrayList arrayList2 = Collections.list(enumeration1);
        q.f(arrayList2, "list(...)");
        ArrayList arrayList3 = new ArrayList();
        for(Object object1: arrayList2) {
            q.d(((URL)object1));
            m m1 = this.toJarRoot(((URL)object1));
            if(m1 != null) {
                arrayList3.add(m1);
            }
        }
        return p.A0(arrayList1, arrayList3);
    }

    private final m toFileRoot(URL uRL0) {
        if(!q.b(uRL0.getProtocol(), "file")) {
            return null;
        }
        File file0 = new File(uRL0.toURI());
        Path path0 = okio.Path.Companion.get$default(Path.Companion, file0, false, 1, null);
        return new m(this.systemFileSystem, path0);
    }

    private final m toJarRoot(URL uRL0) {
        String s = uRL0.toString();
        q.f(s, "toString(...)");
        if(v.r0(s, "jar:file:", false)) {
            int v = o.K0(s, "!", 0, 6);
            if(v != -1) {
                String s1 = s.substring(4, v);
                q.f(s1, "substring(...)");
                File file0 = new File(URI.create(s1));
                Path path0 = okio.Path.Companion.get$default(Path.Companion, file0, false, 1, null);
                ld.j j0 = new ld.j(11);
                return new m(ZipFilesKt.openZip(path0, this.systemFileSystem, j0), ResourceFileSystem.ROOT);
            }
        }
        return null;
    }

    private static final boolean toJarRoot$lambda$7(ZipEntry zipEntry0) {
        q.g(zipEntry0, "entry");
        return Companion.access$keepPath(ResourceFileSystem.Companion, zipEntry0.getCanonicalPath());
    }

    private final String toRelativePath(Path path0) {
        return this.canonicalizeInternal(path0).relativeTo(ResourceFileSystem.ROOT).toString();
    }
}

