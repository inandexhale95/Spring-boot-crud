package org.example.crud.data.dto;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@ToString
public class PageResultDTO<DTO> {

    private List<DTO> dtoList;
    private int totalCount;

    // 총 페이지 번호
    private int totalPage;
    // 현재 페이지
    private int currentPage;
    // 화면에 표시할 게시물 수
    private int size;
    // 시작 페이지, 마지막 페이지
    private int start, end;
    // 이전, 다음
    private boolean prev, next;
    // 페이지 번호 출력
    private List<Integer> pageList;

    public PageResultDTO(List<DTO> dtoList, int totalCount, PageRequestDTO requestDTO) {
        this.dtoList = dtoList;
        this.totalCount = totalCount;
        make(requestDTO);
    }

    private void make(PageRequestDTO requestDTO) {
        this.size = requestDTO.getSize();
        this.currentPage = requestDTO.getCurrentPage();

        totalPage = (int)(Math.ceil(totalCount / (double)size));

        int tempEnd = (int)((Math.ceil(currentPage / 10.0)) * 10);

        start = tempEnd - 9;
        end = Math.min(totalPage, tempEnd);

        prev = start > 1;
        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }
}
