package com.tecnocode.payload;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QualificationDTO implements Serializable {
    private String name;

    private String level;

    private String institution;

    private String status;
}
