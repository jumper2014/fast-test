package com.example.utils.yaml;

import com.example.App;
import com.example.beans.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class YamlTest {

    @Test
    public void loadAsTest() {
        Yaml yaml = new Yaml();
        InputStream is = YamlTest.class.getResourceAsStream("/yaml/person.yml");
        PersonEntity personEntity = yaml.loadAs(is, PersonEntity.class);
        System.out.println(personEntity);
    }


}
