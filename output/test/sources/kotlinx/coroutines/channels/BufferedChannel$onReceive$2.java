package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: BufferedChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
/* synthetic */ class BufferedChannel$onReceive$2 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onReceive$2 INSTANCE = new BufferedChannel$onReceive$2();

    BufferedChannel$onReceive$2() {
        super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(BufferedChannel<?> bufferedChannel, Object p1, Object p2) {
        Object processResultSelectReceive;
        processResultSelectReceive = bufferedChannel.processResultSelectReceive(p1, p2);
        return processResultSelectReceive;
    }
}
