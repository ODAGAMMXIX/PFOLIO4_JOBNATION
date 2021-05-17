package com.tecnocode.payload;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MatchPayload {
    private String candidateName;
    private String vacancyTitle;
    private String companyName;
    private Integer languageGrade;
    private Integer skillGrade;
    private Integer qualificationGrade;
}
