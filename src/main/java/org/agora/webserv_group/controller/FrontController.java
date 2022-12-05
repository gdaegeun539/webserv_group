package org.agora.webserv_group.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "FrontController", value = "/FrontController/*.do")
public class FrontController extends HttpServlet  {

    HashMap<String, ControllerInterface> list = null;

    public void FrontController(){
        list.put("/FrontController/post.do", new PostController());
        list.put("/FrontController/user.do", new UserController());
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getRequestURI();
        ControllerInterface controller = list.get(uri);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.service(request,response)
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
