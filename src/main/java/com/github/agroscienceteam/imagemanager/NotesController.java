package com.github.agroscienceteam.imagemanager;

import static asavershin.generated.package_.Tables.NOTES;

import asavershin.generated.package_.tables.records.NotesRecord;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotesController {

  private final DSLContext dslContext;

  @GetMapping
  public List<NoteDto> get() {
    return dslContext.selectFrom(NOTES).stream()
            .map(r -> NoteDto.builder()
                    .id(r.getId())
                    .date(r.getDate())
                    .title(r.getTitle())
                    .message(r.getMessage())
                    .build()
            )
            .toList();
  }

  @PostMapping
  public void post(final @RequestBody NoteDto dto) {
    NotesRecord entity = new NotesRecord();
    entity.setId(UUID.randomUUID());
    entity.setTitle(dto.getTitle());
    entity.setMessage(dto.getMessage());
    entity.setDate(LocalDate.now());

    dslContext.executeInsert(entity);
  }

}