package ma.xproce.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Data @Getter @Setter
public class VideoDTO {
    private Long id;
    private String title;
    private String description;
    private CreatorDTO creator; // Use the DTO, not the entity

}

