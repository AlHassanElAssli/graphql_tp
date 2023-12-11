package ma.xproce.dtos;

import lombok.*;
import ma.xproce.entities.Creator;

@AllArgsConstructor @NoArgsConstructor @Data @Getter @Setter
public class VideoDTO {
    private String name;
    private String url;
    private String description;
    private String datePublication;
    private Creator creator;
}

