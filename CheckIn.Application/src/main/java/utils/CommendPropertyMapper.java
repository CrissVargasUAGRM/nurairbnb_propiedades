package utils;

import com.nur.model.CommendProperty;
import dtos.CommendPropertyDTO;

import java.util.UUID;

public class CommendPropertyMapper {
	public static CommendPropertyDTO from(CommendProperty commendProperty){
		if(commendProperty == null) return new CommendPropertyDTO();
		return new CommendPropertyDTO(
				String.valueOf(commendProperty.getId()),
				String.valueOf(commendProperty.getUserId()),
				commendProperty.getValoration(),
				commendProperty.getCommend(),
				commendProperty.getPoints(),
				String.valueOf(commendProperty.getPropertyId())
		);
	}

	public static CommendProperty from(CommendPropertyDTO commendPropertyDTO){
		return new CommendProperty(
				UUID.fromString(commendPropertyDTO.getId()),
				UUID.fromString(commendPropertyDTO.getUserId()),
				commendPropertyDTO.getValoration(),
				commendPropertyDTO.getCommend(),
				commendPropertyDTO.getPoints(),
				UUID.fromString(commendPropertyDTO.getPropertyId())
		);
	}
}
