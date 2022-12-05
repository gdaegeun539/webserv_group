package org.agora.webserv_group.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public interface ControllerInterface {
    void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
