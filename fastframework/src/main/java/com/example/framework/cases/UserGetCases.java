package com.example.framework.cases;


import com.example.framework.factory.YamlPropertySourceFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix="testcase.http.user.get")
@PropertySource(value = "classpath:testdata/yml/UserGetCase.yml", factory = YamlPropertySourceFactory.class)
public class UserGetCases {
    List<UserGetCase> userGetCaseList;
}