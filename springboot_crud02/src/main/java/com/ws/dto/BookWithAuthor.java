package com.ws.dto;

import com.ws.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithAuthor {

    private Integer id;

    private String name;

    private String type;

    private String description;

    private Author author;

}
