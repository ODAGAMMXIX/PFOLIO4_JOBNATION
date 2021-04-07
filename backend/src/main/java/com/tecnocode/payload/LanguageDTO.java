package com.tecnocode.payload;

import java.io.Serializable;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LanguageDTO implements Serializable {
	private String name;

	private String level;
}
