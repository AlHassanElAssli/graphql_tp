package ma.xproce.mappers;
import ma.xproce.dtos.CreatorDTO;
import ma.xproce.dtos.VideoDTO;
import ma.xproce.entities.Creator;
import ma.xproce.entities.Video;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {

    private final ModelMapper modelMapper = new ModelMapper();

    public CreatorDTO fromCreator(Creator creator) {
        return this.modelMapper.map(creator, CreatorDTO.class);
    }
    public VideoDTO fromVideo(Video video) { return this.modelMapper.map(video, VideoDTO.class);
    }
}