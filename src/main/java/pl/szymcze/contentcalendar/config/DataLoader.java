package pl.szymcze.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.szymcze.contentcalendar.model.Content;
import pl.szymcze.contentcalendar.repository.ContentRepository;

import java.io.InputStream;
import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    private final ContentRepository contentRepository;
    private final ObjectMapper mapper;

    public DataLoader(ContentRepository contentRepository, ObjectMapper mapper) {
        this.contentRepository = contentRepository;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            contentRepository.saveAll(mapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }
    }
}
