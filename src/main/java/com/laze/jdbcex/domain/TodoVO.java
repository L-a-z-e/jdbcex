package com.laze.jdbcex.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TodoVO {

    private Long tno;
    private String title;
    private LocalDateTime dueDate;
    private boolean finished;

}
