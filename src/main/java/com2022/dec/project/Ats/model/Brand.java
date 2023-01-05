package com2022.dec.project.Ats.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("brand")
@ToString
public class Brand {
	@Id
	@NotBlank(message="must required field")
	@JsonProperty("serialNo")
	private String serialNo;
	@JsonProperty("brandName")
	private String brandName;

}
