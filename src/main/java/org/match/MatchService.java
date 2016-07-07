package org.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eugennekhai on 06/07/16.
 */
@Service
public class MatchService {
    private static final Logger logger = LoggerFactory.getLogger(MatchService.class);
    @Autowired
    private ResourceLoader resourceLoader;
    private List<String> lines = new ArrayList<>();

    @PostConstruct
    public void init() {
        Resource resource = resourceLoader.getResource("classpath:phrases.txt");

        try {
            lines = Files.readAllLines(resource.getFile().toPath());
        } catch (IOException ex) {
            logger.error(ex.toString());
        }

    }

    public List<String> match(String value) {
        return lines.stream().filter(value::contains).collect(Collectors.toList());
    }
}
