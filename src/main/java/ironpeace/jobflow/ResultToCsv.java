package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.csv.AbstractResultCsvOutputDescription;


public class ResultToCsv extends  AbstractResultCsvOutputDescription{

	@Override
	public String getBasePath() {
		return "ironpeace/grouping/output/";
	}

	@Override
	public String getResourcePattern() {
		return "result.csv";
	}

}
