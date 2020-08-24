package by.chyzh.cityinfo.dto;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CityDto {

    private Long id;
    private String name;
    private String description;
}
