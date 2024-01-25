package use.cases.command.commendProperty.get;

import an.awesome.pipelinr.Command;
import dtos.CommendPropertyDTO;

import java.util.List;

public class GetCommendPropertyQuery implements Command<List<CommendPropertyDTO>> {
	String id;
	public GetCommendPropertyQuery(String id) {
		this.id = id;
	}

}
