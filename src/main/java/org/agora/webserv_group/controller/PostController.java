package org.agora.webserv_group.controller;

import org.agora.webserv_group.dao.PostDAO;
import org.agora.webserv_group.model.Post;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "PostController", value = "/post")
public class PostController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PostDAO dao;
    private ServletContext ctx;

    // 웹 리소스 기본 경로 지정
    private final String START_PAGE = "postlist.jsp";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new PostDAO();
        ctx = getServletContext();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        // 자바 리플렉션을 사용해 if, switch 없이 요청에 따라 구현 메서드가 실행되도록 함. 즉 action이름과 동일한 메서드를 호출
        Method m;
        String view = null;

        // action 파라미터 없이 접근한 경우
        if (action == null) {
            action = "getPosts";
        }

        try {
            // 현재 클래스에서 action 이름과 HttpServletRequest 를 파라미터로 하는 메서드 찾음
            m = this.getClass().getMethod(action, HttpServletRequest.class);
            // 메서드 실행후 리턴값 받아옴
            view = (String)m.invoke(this, request);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            // 에러 로그를 남기고 view 를 로그인 화면으로 지정, 앞에서와 같이 redirection 사용도 가능.
            ctx.log("요청 action 없음!!");
            request.setAttribute("error", "action 파라미터가 잘못 되었습니다!!");
            view = START_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // POST 요청 처리후에는 리디렉션 방법으로 이동 할 수 있어야 함.
        if(view.startsWith("redirect:/")) {
            // redirect:/ 문자열 이후 경로만 가지고 옴
            String rview = view.substring("redirect:/".length());
            response.sendRedirect(rview);
        } else {
            // 지정된 뷰로 포워딩, 포워딩시 컨텍스트경로는 필요없음.
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }

    public String search(HttpServletRequest request) {
        String title = request.getParameter("title");
        try {
            List<Post> posts = dao.getPostsByTitle(title);
            request.setAttribute("PostList", posts);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.log("게시물 목록 생성 과정에서 문제 발생!!");
            request.setAttribute("error", "게시물 목록이 정상적으로 처리되지 않았습니다!!");
        }
        return "postlist.jsp";
    }

    public String category(HttpServletRequest request) {
        String category = request.getParameter("category");
        try {
            List<Post> posts;
            if (Objects.equals(category, "all")) {
                posts = dao.getPosts();
            } else {
                posts = dao.getPostsByCategory(category);
            }
            request.setAttribute("PostList", posts);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.log("게시물 목록 생성 과정에서 문제 발생!!");
            request.setAttribute("error", "게시물 목록이 정상적으로 처리되지 않았습니다!!");
        }
        return "postlist.jsp";
    }

    public String addPost(HttpServletRequest request) {
        Post post = new Post();
        try {
            BeanUtils.populate(post, request.getParameterMap());
            dao.addPost(post);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.log("게시물 추가 과정에서 문제 발생!!");
            request.setAttribute("error", "게시물가 정상적으로 등록되지 않았습니다!!");
            return getPosts(request);
        }

        return "redirect:/post?action=getPosts";

    }

    public String getPosts(HttpServletRequest request) {
        List<Post> list;
        try {
            list = dao.getPosts();
            request.setAttribute("PostList", list);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.log("게시물 목록 생성 과정에서 문제 발생!!");
            request.setAttribute("error", "게시물 목록이 정상적으로 처리되지 않았습니다!!");
        }
        return "postlist.jsp";
    }

    public String getPost(HttpServletRequest request) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        try {
            Post post = dao.getPostById(pid);
            request.setAttribute("Post", post);
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
            request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
        }
        return "detail_page.jsp";
    }

    public String deletePost(HttpServletRequest request) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        try {
            dao.delPost(pid);
        } catch (SQLException e) {
            e.printStackTrace();
            ctx.log("뉴스 삭제 과정에서 문제 발생!!");
            request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
            return getPosts(request);
        }

        return "redirect:/Post.nhn?action=getPosts";
    }

    public String updatePost(HttpServletRequest request) {
        Post inputPost = new Post();
        try {
            // 입력 Post
            BeanUtils.populate(inputPost, request.getParameterMap());
            int pid = inputPost.getPid();
            // 현재 Post
            Post nowPost = dao.getPostById(pid);
            // 입력 Post 와 현재 Post 비교
            if (inputPost.getTitle() == null) {
                nowPost.setTitle(inputPost.getTitle());
            }
            if (inputPost.getContent() == null) {
                nowPost.setTitle(inputPost.getContent());
            }

            dao.updatePost(nowPost);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.log("뉴스 수정 과정에서 문제 발생!!");
            request.setAttribute("error", "뉴스가 정상적으로 수정되지 않았습니다!!");
            return getPosts(request);
        }

        return "redirect:/Post.nhn?action=getPosts";
    }
}
