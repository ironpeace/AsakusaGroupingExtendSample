package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import ironpeace.modelgen.dmdl.model.Result;
import java.io.IOException;
/**
 * <code>result</code>をTSVなどのレコード形式で出力する。
 */
public final class ResultOutput implements ModelOutput<Result> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public ResultOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(Result model) throws IOException {
        emitter.emit(model.getUseridOption());
        emitter.emit(model.getData0Option());
        emitter.emit(model.getData1Option());
        emitter.emit(model.getAlertOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}