package androidx.tracing;

/* loaded from: classes5.dex */
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(String label) {
        android.os.Trace.beginSection(label);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
