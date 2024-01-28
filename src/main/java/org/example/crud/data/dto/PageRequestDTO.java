package org.example.crud.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageRequestDTO {
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
