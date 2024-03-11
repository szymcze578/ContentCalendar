package pl.szymcze.contentcalendar.repository;

import jdk.jshell.Snippet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.szymcze.contentcalendar.model.Content;
import pl.szymcze.contentcalendar.model.Status;
import pl.szymcze.contentcalendar.model.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Content mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Content(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                Status.valueOf(resultSet.getString("status")),
                Type.valueOf(resultSet.getString("contentType")),
                resultSet.getObject("dateCreated",LocalDateTime.class),
                resultSet.getObject("dateUpdated",LocalDateTime.class),
                resultSet.getString("url")
        );
    }

    public List<Content> getAllContent(){
        String sql = "SELECT * FROM Content";
        return jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
    }

    public void createContent(String title, String description, Status status,Type type, String url){
        String sql = "INSERT INTO Content(title,description,status,content_type,date_created,URL) VALUES (?,?,?,?,NOW(),null)";
        jdbcTemplate.update(sql,title,description,status,type,url);
    }

    public void updateContent(int id, String title,String desc, Status status, Type type, String url){
        String sql = "UPDATE Content SET title=?, description=?, status=?, content_type=?,date_updated=NOW(),url=? WHERE id=?";
        jdbcTemplate.update(sql,title,desc,status,type,url,id);
    }

    public void deleteContent(int id){
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    public Content getContent(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
        return content;
    }
}
