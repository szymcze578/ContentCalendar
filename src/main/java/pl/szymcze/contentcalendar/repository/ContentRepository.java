package pl.szymcze.contentcalendar.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import pl.szymcze.contentcalendar.model.Content;
import pl.szymcze.contentcalendar.model.Status;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
          SELECT * FROM Content
          WHERE status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
