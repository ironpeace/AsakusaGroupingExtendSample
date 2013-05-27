package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;
import ironpeace.operator.GroupingExtendSampleOperatorFactory;
import ironpeace.operator.GroupingExtendSampleOperatorFactory.Balance;
import ironpeace.operator.GroupingExtendSampleOperatorFactory.ConvertedResult;
import ironpeace.operator.GroupingExtendSampleOperatorFactory.Join4Mid;

import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory.Extend;

@JobFlow(name="TheGroupingExtendSampleJobFlow")
public class GroupingExtendSampleJobFlow extends FlowDescription {

	final In<OriginalData> originaldata;
	final Out<Result> result;
	final CoreOperatorFactory coreOp = new CoreOperatorFactory();

	public GroupingExtendSampleJobFlow(
			@Import(name="originaldata", description=OriginaldataFromCsv.class)
			In<OriginalData> originaldata,
			@Export(name="result", description=ResultToCsv.class)
			Out<Result> result
		){
		this.originaldata = originaldata;
		this.result = result;
	}

	
	@Override
	protected void describe() {
		GroupingExtendSampleOperatorFactory operators
			= new GroupingExtendSampleOperatorFactory();
		
		Balance balance = operators.balance(originaldata);
		coreOp.stop(balance.old);
		
		Join4Mid joinedMid
			= operators.join4Mid(balance.before, balance.current);
		coreOp.stop(joinedMid.missed);
		
		Extend<PreResult> preresult
			= coreOp.extend(joinedMid.joined, PreResult.class);
		
		ConvertedResult convertedResult
			= operators.convertedResult(preresult);
		coreOp.stop(convertedResult.original);
		
		result.add(convertedResult.out);
	}

}
