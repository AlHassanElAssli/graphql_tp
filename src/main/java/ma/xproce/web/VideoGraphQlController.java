package ma.xproce.web;

import ma.xproce.dtos.CreatorDTO;
import ma.xproce.dtos.VideoDTO;
import ma.xproce.entities.Creator;
import ma.xproce.entities.Video;
import ma.xproce.mappers.ModelMapperConfig;
import ma.xproce.repositories.CreatorRepository;
import ma.xproce.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {

    private VideoRepository videoRepository;
    private CreatorRepository creatorRepository;
    @Autowired
    private ModelMapperConfig modelMapperConfig;
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
    public Video saveVideo(@Argument("video") VideoDTO videoDTO){
        System.out.println(videoDTO);
        Video video = modelMapperConfig.toVideo(videoDTO);
        return videoRepository.save(video);
    }
    @MutationMapping
    public Creator saveCreator(@Argument("creator") CreatorDTO creatorDTO){
        System.out.println(creatorDTO);
        Creator creator = modelMapperConfig.toCreator(creatorDTO);
        return creatorRepository.save(creator);
    }


}
