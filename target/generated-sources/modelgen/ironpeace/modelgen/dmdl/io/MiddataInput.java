package ironpeace.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import ironpeace.modelgen.dmdl.model.Middata;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>middata</code>を読み出す
 */
public final class MiddataInput implements ModelInput<Middata> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public MiddataInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(Middata model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getUseridOption());
        parser.fill(model.getData0Option());
        parser.fill(model.getData1Option());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}