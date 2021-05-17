package com.tecnocode.payload;

import com.tecnocode.model.Vacancy;
import com.tecnocode.model.Candidate;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplyDTO implements Serializable {
    private Integer vacancyId;
    private Integer candidateId;
}
