package com.night.domain;

import lombok.*;

import java.util.Objects;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Entity {
    private Integer key;
    private Long value;
}
