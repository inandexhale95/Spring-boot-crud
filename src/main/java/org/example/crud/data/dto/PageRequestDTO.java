package org.example.crud.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PageRequestDTO {
    private String type;
    private String keyword;
    private int size;
    private int currentPage;

    public PageRequestDTO() {
        this(15, 1);
    }

    public PageRequestDTO(int size, int currentPage) {
        this.size = size;
        this.currentPage = currentPage;
    }
}
