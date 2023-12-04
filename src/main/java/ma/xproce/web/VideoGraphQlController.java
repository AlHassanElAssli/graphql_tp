package ma.xproce.web;

import ma.xproce.dtos.CreatorDTO;
import ma.xproce.dtos.VideoDTO;
import ma.xproce.entities.Creator;
import ma.xproce.entities.Video;
import ma.xproce.repositories.CreatorRepository;
import ma.xproce.repositories.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private VideoRepository videoRepository;
    private CreatorRepository creatorRepository;
    final ModelMapper modelMapper = new ModelMapper();
    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.videoRepository = videoRepository;
        this.creatorRepository = creatorRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id){
        return creatorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Creator %s not found ",id)));
    }
    @MutationMapping
    public Video saveBook(VideoDTO videoDTO){
        Video video = modelMapper.map(videoDTO,Video.class);
        return videoRepository.save(video);
    }
    @MutationMapping
    public Creator saveCreator(CreatorDTO creatorDTO){
        Creator creator = modelMapper.map(creatorDTO,Creator.class);
        return creatorRepository.save(creator);
    }


}
