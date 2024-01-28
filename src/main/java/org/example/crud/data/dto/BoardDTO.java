package org.example.crud.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    int bno;

    @Size(min = 2, message = "제목은 2자 이상 입력해주세요.")
    @NotBlank(message = "제목은 필수 입력입니다.")
    String title;

    @Size(min = 2, message = "내용은 2자 이상 입력해주세요.")
    @NotBlank(message = "내용은 필수 입력입니다.")
    String content;

    String author;
    LocalDateTime createDate;
}
