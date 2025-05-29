package io.github.ryansilva.veticore.controller.response.people;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PeopleResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
