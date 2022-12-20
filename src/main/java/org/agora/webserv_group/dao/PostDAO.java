package org.agora.webserv_group.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.agora.webserv_group.model.Post;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private ConnectionMaker connectionMaker;
    Type listType = new TypeToken<ArrayList<String>>() {}.getType();
    Gson gson;

    public PostDAO() {
        connectionMaker = new ConnectionMaker();
        gson = new Gson();
    }

    public void addPost(Post post) throws Exception {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "insert into post(pid, writer, capacity, people, created_at, updated_at, category, title, introduction, content, location, is_end) values(?,?,?,?,CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try(conn; pstmt) {
            pstmt.setInt(1, post.getPid());
            pstmt.setString(2, post.getWriter());
            pstmt.setInt(3, post.getCapacity());
            pstmt.setString(4, gson.toJson(post.getPeople()));
            pstmt.setString(5, post.getCategory());
            pstmt.setString(6, post.getTitle());
            pstmt.setString(7, post.getIntroduction());
            pstmt.setString(8, post.getContent());
            pstmt.setString(9, post.getLocation());
            pstmt.setBoolean(10, post.getIs_end());
            pstmt.executeUpdate();
        }
    }

    public List<Post> getPosts() throws Exception {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "select pid, writer, capacity, people, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as created_at, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as updated_at, category, title, introduction, content, location, is_end from post";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = getPostsFromRs(rs);

        return posts;
    }

    public List<Post> getPostsByTitle(String title) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "select pid, writer, capacity, people, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as created_at, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as updated_at, category, title, introduction, content, location, is_end from post where title=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = getPostsFromRs(rs);

        return posts;
    }


    public Post getPostById(int pid) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "select pid, writer, capacity, people, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as created_at, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as updated_at, category, title, introduction, content, location, is_end from post where pid=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, pid);
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = getPostsFromRs(rs);

        return posts.get(0);
    }

    public void addPeople(Post post, String uid) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        int pid = post.getPid();
        ArrayList<String> people = post.getPeople();

        String updateSql = "UPDATE post SET people = ?, updated_at = CURRENT_TIMESTAMP() WHERE pid = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateSql);

        try (conn; pstmt) {
            pstmt.setString(1, gson.toJson(people.add(uid)));
            pstmt.setInt(2, pid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removePeople(Post post, String uid) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        int pid = post.getPid();
        ArrayList<String> people = post.getPeople();

        String updateSql = "UPDATE post SET people = ?, updated_at = CURRENT_TIMESTAMP() WHERE pid = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateSql);

        try (conn; pstmt) {
            pstmt.setString(1, gson.toJson(people.remove(uid)));
            pstmt.setInt(2, pid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closePost(int pid) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();

        String updateSql = "UPDATE post SET is_end = false, updated_at = CURRENT_TIMESTAMP() WHERE pid = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateSql);

        try (conn; pstmt) {
            pstmt.setInt(1, pid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Post> getPostsByCategory(String category) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "select pid, writer, capacity, people, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as created_at, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as updated_at, category, title, introduction, content, location, is_end from post where category=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, category);
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = getPostsFromRs(rs);

        return posts;
    }

    public List<Post> getMyGroupPostsByUid(String uid) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        String uidStr = "%" + uid + "%";
        String sql = "select pid, writer, capacity, people, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as created_at, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as updated_at, category, title, introduction, content, location, is_end from post where people LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uidStr);
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = getPostsFromRs(rs);

        return posts;
    }

    public List<Post> getPostsByWriter(String writer) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "select pid, writer, capacity, people, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as created_at, PARSEDATETIME(date,'yyyy-MM-dd HH:mm:ss.SSSSSS') as updated_at, category, title, introduction, content, location, is_end from post where writer = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, writer);
        ResultSet rs = pstmt.executeQuery();
        List<Post> posts = getPostsFromRs(rs);

        return posts;
    }

    public void updatePost(Post post) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        int pid = post.getPid();
        String updateSql = "UPDATE post SET title = ?, content = ?, updated_at = CURRENT_TIMESTAMP() WHERE pid = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateSql);

        try (conn; pstmt) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, pid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delPost(int pid) throws SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        String sql = "delete from news where pid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try(conn; pstmt) {
            pstmt.setInt(1, pid);
            // 삭제된 뉴스 기사가 없을 경우
            if(pstmt.executeUpdate() == 0) {
                throw new SQLException("DB에러");
            }
        }
    }


    private List<Post> getPostsFromRs(ResultSet rs) throws SQLException {
        List<Post> posts = new ArrayList<>();
        try(rs) {
            while(rs.next()) {
                Post post = new Post();
                post.setPid(rs.getInt("pid"));
                post.setWriter(rs.getString("writer"));
                post.setCapacity(rs.getInt("capacity"));
                post.setPeople(gson.fromJson(rs.getString("people"), listType));
                post.setCategory(rs.getString("category"));
                post.setTitle(rs.getString("title"));
                post.setIntroduction(rs.getString("introduction"));
                post.setContent(rs.getString("content"));
                post.setLocation(rs.getString("location"));
                post.setIs_end(rs.getBoolean("is_end"));
                posts.add(post);
            }
            return posts;
        }
    }
}