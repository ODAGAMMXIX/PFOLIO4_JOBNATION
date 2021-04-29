package com.tecnocode.payload;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExperienceDTO implements Serializable{
	private String company;
	private String city;
	private LocalDate start;
	private LocalDate end;
	private String title;
	private String achiev;
}
