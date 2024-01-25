package use.cases.command.commendProperty.get;

import an.awesome.pipelinr.Command;
import com.nur.model.CommendProperty;
import com.nur.repositories.ICommendPropertyRepository;
import core.BusinessRuleValidationException;
import dtos.CommendPropertyDTO;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.CommendPropertyMapper;

@Component
public class GetCommentHandler
    implements Command.Handler<GetCommendPropertyQuery, List<CommendPropertyDTO>> {

  private final ICommendPropertyRepository commendRepository;

  public GetCommentHandler(ICommendPropertyRepository passangerRepository) {
    this.commendRepository = passangerRepository;
  }

  @Override
  public List<CommendPropertyDTO> handle(GetCommendPropertyQuery command) {
    try {
      List<CommendProperty> comment =
          this.commendRepository.getByPropiedadId(UUID.fromString(command.id));
      return comment.stream().map(CommendPropertyMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
