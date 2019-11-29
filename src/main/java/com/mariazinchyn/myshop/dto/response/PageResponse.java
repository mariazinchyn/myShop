package com.mariazinchyn.myshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PageResponse<T> {
    private Long totalElement;
    private Integer totalPages;
    private List<T> data;
}
