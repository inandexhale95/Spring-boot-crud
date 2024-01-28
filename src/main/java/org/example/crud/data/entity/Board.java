package org.example.crud.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    int bno;
    String title;
    String content;
    String author;
    LocalDateTime createDate;
}
