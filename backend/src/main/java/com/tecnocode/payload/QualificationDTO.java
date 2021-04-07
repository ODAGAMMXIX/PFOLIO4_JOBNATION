package com.tecnocode.payload;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class QualificationDTO implements Serializable {
    private Integer id;
    private String name;
    private String level;
    private String institution;
    private String couse;
    private LocalDate start;
    private LocalDate end;
    private String status;
}
