package com.tecnocode.payload;

import lombok.*;
import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class  SkillDTO implements Serializable {
    private String name;

    private String level;

    private String others;

}

