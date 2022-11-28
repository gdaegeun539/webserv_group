package org.agora.webserv_group.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Post {
    private int pid;
    private String writer;
    private int capacity;
    private List<String> people;
    private Date created_at;
    private Date updated_at;
    private String category;
    private String title;
    private String introduction;
    private String content;
    private String location;
    private Boolean is_end;
}