package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import ironpeace.modelgen.dmdl.model.Middata;
import java.io.IOException;
/**
 * <code>middata</code>をTSVなどのレコード形式で出力する。
 */
public final class MiddataOutput implements ModelOutput<Middata> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public MiddataOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(Middata model) throws IOException {
        emitter.emit(model.getUseridOption());
        emitter.emit(model.getData0Option());
        emitter.emit(model.getData1Option());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}