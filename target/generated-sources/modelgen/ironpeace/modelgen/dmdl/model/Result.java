package ironpeace.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.LongOption;
import com.asakusafw.runtime.value.StringOption;
import ironpeace.modelgen.dmdl.io.ResultInput;
import ironpeace.modelgen.dmdl.io.ResultOutput;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * Resultを表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(ResultInput.class)@ModelOutputLocation(ResultOutput.class)@PropertyOrder({
            "userid", "data0", "data1", "alert"}) public class Result implements DataModel<Result>, Writable {
    private final StringOption userid = new StringOption();
    private final LongOption data0 = new LongOption();
    private final LongOption data1 = new LongOption();
    private final StringOption alert = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.userid.setNull();
        this.data0.setNull();
        this.data1.setNull();
        this.alert.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(Result other) {
        this.userid.copyFrom(other.userid);
        this.data0.copyFrom(other.data0);
        this.data1.copyFrom(other.data1);
        this.alert.copyFrom(other.alert);
    }
    /**
     * useridを返す。
     * @return userid
     * @throws NullPointerException useridの値が<code>null</code>である場合
     */
    public Text getUserid() {
        return this.userid.get();
    }
    /**
     * useridを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setUserid(Text value) {
        this.userid.modify(value);
    }
    /**
     * <code>null</code>を許すuseridを返す。
     * @return userid
     */
    public StringOption getUseridOption() {
        return this.userid;
    }
    /**
     * useridを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setUseridOption(StringOption option) {
        this.userid.copyFrom(option);
    }
    /**
     * data0を返す。
     * @return data0
     * @throws NullPointerException data0の値が<code>null</code>である場合
     */
    public long getData0() {
        return this.data0.get();
    }
    /**
     * data0を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setData0(long value) {
        this.data0.modify(value);
    }
    /**
     * <code>null</code>を許すdata0を返す。
     * @return data0
     */
    public LongOption getData0Option() {
        return this.data0;
    }
    /**
     * data0を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setData0Option(LongOption option) {
        this.data0.copyFrom(option);
    }
    /**
     * data1を返す。
     * @return data1
     * @throws NullPointerException data1の値が<code>null</code>である場合
     */
    public long getData1() {
        return this.data1.get();
    }
    /**
     * data1を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setData1(long value) {
        this.data1.modify(value);
    }
    /**
     * <code>null</code>を許すdata1を返す。
     * @return data1
     */
    public LongOption getData1Option() {
        return this.data1;
    }
    /**
     * data1を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setData1Option(LongOption option) {
        this.data1.copyFrom(option);
    }
    /**
     * alertを返す。
     * @return alert
     * @throws NullPointerException alertの値が<code>null</code>である場合
     */
    public Text getAlert() {
        return this.alert.get();
    }
    /**
     * alertを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlert(Text value) {
        this.alert.modify(value);
    }
    /**
     * <code>null</code>を許すalertを返す。
     * @return alert
     */
    public StringOption getAlertOption() {
        return this.alert;
    }
    /**
     * alertを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setAlertOption(StringOption option) {
        this.alert.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=result");
        result.append(", userid=");
        result.append(this.userid);
        result.append(", data0=");
        result.append(this.data0);
        result.append(", data1=");
        result.append(this.data1);
        result.append(", alert=");
        result.append(this.alert);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + userid.hashCode();
        result = prime * result + data0.hashCode();
        result = prime * result + data1.hashCode();
        result = prime * result + alert.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Result other = (Result) obj;
        if(this.userid.equals(other.userid) == false) {
            return false;
        }
        if(this.data0.equals(other.data0) == false) {
            return false;
        }
        if(this.data1.equals(other.data1) == false) {
            return false;
        }
        if(this.alert.equals(other.alert) == false) {
            return false;
        }
        return true;
    }
    /**
     * useridを返す。
     * @return userid
     * @throws NullPointerException useridの値が<code>null</code>である場合
     */
    public String getUseridAsString() {
        return this.userid.getAsString();
    }
    /**
     * useridを設定する。
     * @param userid0 設定する値
     */
    @SuppressWarnings("deprecation") public void setUseridAsString(String userid0) {
        this.userid.modify(userid0);
    }
    /**
     * alertを返す。
     * @return alert
     * @throws NullPointerException alertの値が<code>null</code>である場合
     */
    public String getAlertAsString() {
        return this.alert.getAsString();
    }
    /**
     * alertを設定する。
     * @param alert0 設定する値
     */
    @SuppressWarnings("deprecation") public void setAlertAsString(String alert0) {
        this.alert.modify(alert0);
    }
    @Override public void write(DataOutput out) throws IOException {
        userid.write(out);
        data0.write(out);
        data1.write(out);
        alert.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        userid.readFields(in);
        data0.readFields(in);
        data1.readFields(in);
        alert.readFields(in);
    }
}