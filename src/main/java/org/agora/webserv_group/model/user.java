package org.agora.webserv_group.model;

import lombok.Data;

@Data

public class user {
    private String uid;
    private String password;
    private String name;
    private String email;
    private String interest;
    private String admin;
}
