package hu.czsoft.cshex_sb.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.boot.SpringBootVersion;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ApiVersion {
    private String id;
    private String springVersion = SpringBootVersion.getVersion();
}
