package ironpeace.operator;

import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;

import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.MasterJoin;

public abstract class GroupingExtendSampleOperator {

	@Branch
	public Term balance(OriginalData originaldata){
		if(originaldata.getTerm() == 2011){
			return Term.BEFORE;
		}else if(originaldata.getTerm() == 2012){
			return Term.CURRENT;
		}else{
			return Term.OLD;
		}
	}
	
	public static enum Term { BEFORE, CURRENT, OLD }
	
	@MasterJoin
	public abstract Middata join4Mid(OriginalData t11, OriginalData t12);
	
	
	@Convert
	public Result convertedResult(PreResult pre){
		Result result = new Result();
		if(pre.getData0() < pre.getData1()){
			result.setAlertAsString("A");
		}else{
			result.setAlertAsString("B");
		}
		return result;
	}
}
