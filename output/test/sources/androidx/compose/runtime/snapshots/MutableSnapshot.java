package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J'\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\u0080\bø\u0001\u0000¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/compose/runtime/collection/IdentityArraySet;", "modified", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setModified", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private IdentityArraySet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int id, SnapshotIdSet invalid, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(id, invalid, null);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        int newId;
        SnapshotIdSet snapshotIdSet;
        Function1 mergedWriteObserver;
        int i;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            try {
                newId = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = newId + 1;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet.set(newId);
                SnapshotIdSet currentInvalid = getInvalid();
                try {
                    setInvalid$runtime_release(currentInvalid.set(newId));
                    SnapshotIdSet addRange = SnapshotKt.addRange(currentInvalid, getId() + 1, newId);
                    Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, null);
                    mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
                    NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(newId, addRange, mergedReadObserver$default, mergedWriteObserver, this);
                    if (!getApplied() && !getDisposed()) {
                        int previousId$iv = getId();
                        Object lock$iv$iv$iv = SnapshotKt.getLock();
                        synchronized (lock$iv$iv$iv) {
                            i = SnapshotKt.nextSnapshotId;
                            SnapshotKt.nextSnapshotId = i + 1;
                            setId$runtime_release(i);
                            snapshotIdSet2 = SnapshotKt.openSnapshots;
                            SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                            Unit unit = Unit.INSTANCE;
                        }
                        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
                    }
                    return nestedMutableSnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db A[Catch: all -> 0x01ca, TryCatch #1 {, blocks: (B:8:0x0044, B:10:0x004e, B:13:0x0055, B:18:0x007f, B:19:0x00e7, B:71:0x00a9, B:73:0x00cf, B:78:0x00db), top: B:7:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (!getDisposed()) {
            super.dispose();
            mo2598nestedDeactivated$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        int readonlyId;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        int i;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int previousId = getId();
        recordPrevious$runtime_release(getId());
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            readonlyId = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = readonlyId + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(readonlyId);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(readonlyId, SnapshotKt.addRange(getInvalid(), previousId + 1, readonlyId), readObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int previousId$iv = getId();
            Object lock$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv) {
                i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                setId$runtime_release(i);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo2597nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo2598nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (!(this.snapshots > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.snapshots--;
        if (this.snapshots == 0 && !this.applied) {
            abandon();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    private final void validateNotAppliedOrPinned() {
        boolean z = true;
        if (this.applied) {
            MutableSnapshot this_$iv = this;
            Snapshot this_$iv2 = ((Snapshot) this_$iv).pinningTrackingHandle >= 0 ? 1 : null;
            if (this_$iv2 == null) {
                z = false;
            }
        }
        if (!z) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    private final void abandon() {
        IdentityArraySet modified = getModified$runtime_release();
        if (modified != null) {
            validateNotApplied();
            setModified(null);
            int id = getId();
            Object[] values$iv = modified.getValues();
            int size = modified.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                Object obj = values$iv[i$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                StateObject state = (StateObject) obj;
                for (StateRecord current = state.getFirstStateRecord(); current != null; current = current.getNext()) {
                    if (current.getSnapshotId() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(current.getSnapshotId()))) {
                        current.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0053, code lost:
    
        r3 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r14, getId(), r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.runtime.snapshots.SnapshotApplyResult innerApplyLocked$runtime_release(int r24, java.util.Map<androidx.compose.runtime.snapshots.StateRecord, ? extends androidx.compose.runtime.snapshots.StateRecord> r25, androidx.compose.runtime.snapshots.SnapshotIdSet r26) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.innerApplyLocked$runtime_release(int, java.util.Map, androidx.compose.runtime.snapshots.SnapshotIdSet):androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        int i;
        SnapshotIdSet snapshotIdSet;
        Intrinsics.checkNotNullParameter(block, "block");
        recordPrevious$runtime_release(getId());
        T invoke = block.invoke();
        if (!getApplied() && !getDisposed()) {
            int previousId = getId();
            Object lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
                try {
                    i = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i + 1;
                    setId$runtime_release(i);
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId + 1, getId()));
        }
        return invoke;
    }

    public final void advance$runtime_release() {
        int i;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int previousId$iv = getId();
        Object lock$iv$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv$iv) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
            Unit unit2 = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
    }

    public final void recordPrevious$runtime_release(int id) {
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        Intrinsics.checkNotNullParameter(handles, "handles");
        if (handles.length == 0) {
            return;
        }
        int[] pinned = this.previousPinnedSnapshots;
        this.previousPinnedSnapshots = pinned.length == 0 ? handles : ArraysKt.plus(pinned, handles);
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int index = 0; index < length; index++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[index]);
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        Intrinsics.checkNotNullParameter(snapshots, "snapshots");
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            this.previousIds = this.previousIds.or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo2599recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        IdentityArraySet it = getModified$runtime_release();
        if (it == null) {
            it = new IdentityArraySet();
            setModified(it);
        }
        it.add(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteCount$runtime_release, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        this.modified = identityArraySet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    /* renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    /* renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    /* compiled from: Snapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
