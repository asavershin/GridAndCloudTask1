package com.github.agroscienceteam.imagemanager;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class NoteDto {

  @JsonProperty(access = READ_ONLY)
  private UUID id;
  private String title;
  private String message;
  @JsonProperty(access = READ_ONLY)
  private LocalDate date;

}