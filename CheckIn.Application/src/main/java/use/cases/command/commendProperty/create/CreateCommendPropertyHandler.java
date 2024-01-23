package use.cases.command.commendProperty.create;

import an.awesome.pipelinr.Command;
import com.nur.factories.commendProperty.CommendPropertyFactoryImpl;
import com.nur.factories.commendProperty.ICommendPropertyFactory;
import com.nur.model.CommendProperty;
import com.nur.repositories.ICommendPropertyRepository;
import dtos.CommendPropertyDTO;
import java.util.UUID;
import org.springframework.stereotype.Component;
import utils.CommendPropertyMapper;

@Component
public class CreateCommendPropertyHandler
    implements Command.Handler<CreateCommendPropertyCommand, CommendPropertyDTO> {
  private final ICommendPropertyRepository commendPropertyRepository;
  private final ICommendPropertyFactory commendPropertyFactory;

  public CreateCommendPropertyHandler(ICommendPropertyRepository commendPropertyRepository) {
    this.commendPropertyRepository = commendPropertyRepository;
    this.commendPropertyFactory = new CommendPropertyFactoryImpl();
  }

  @Override
  public CommendPropertyDTO handle(CreateCommendPropertyCommand command) {
    CommendProperty commendProperty = null;
    try {
      commendProperty =
          commendPropertyFactory.createCommend(
              UUID.fromString(command.commendPropertyDTO.getId()),
              UUID.fromString(command.commendPropertyDTO.getUserId()),
              command.commendPropertyDTO.getValoration(),
              command.commendPropertyDTO.getCommend(),
              command.commendPropertyDTO.getPoints(),
              UUID.fromString(command.commendPropertyDTO.getPropertyId()));
      if (commendProperty == null) return null;
      commendPropertyRepository.createCommendProperty(commendProperty);
      return CommendPropertyMapper.from(commendProperty);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
