package ma.xproce;

import ma.xproce.entities.Creator;
import ma.xproce.entities.Video;
import ma.xproce.repositories.CreatorRepository;
import ma.xproce.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ma.xproce.repositories")
@EntityScan(basePackages = "ma.xproce.entities")
public class VideoApplication {
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    CreatorRepository creatorRepository;
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }


    @Bean
    CommandLineRunner start() {
        return args -> {
            creatorRepository.save(Creator.builder().id(Long.valueOf(1)).name("creator1").email("test@gmail.com").build());
            creatorRepository.save(Creator.builder().id(Long.valueOf(2)).name("creator2").email("test2@gmail.com").build());
            Creator c1 = creatorRepository.getById(Long.valueOf(1));
            Creator c2 = creatorRepository.getById(Long.valueOf(2));
            videoRepository.save(Video.builder().id(Long.valueOf(1)).name("video1").url("url1").datePublication(new Date()).description("desc1").creator(c1).build());
            videoRepository.save(Video.builder().id(Long.valueOf(2)).name("video2").url("url12").datePublication(new Date()).description("desc2").creator(c2).build());
        };
    }
}
