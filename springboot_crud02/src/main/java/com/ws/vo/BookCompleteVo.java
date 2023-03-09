package com.ws.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCompleteVo {

    private Integer id;

    private String name;

    private String type;

    private String description;

    private String authorName;

}
