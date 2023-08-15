package com.example.verify;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import com.example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.guava.api.Assertions.assertThat;
import static org.assertj.guava.api.Assertions.entry;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AssertJTest {

    @Test
    public void compareMultimap() {
        // Multimap assertions
        Multimap<String, String> actual = ArrayListMultimap.create();
        actual.putAll("Lakers", newArrayList("Kobe Bryant", "Magic Johnson", "Kareem Abdul Jabbar"));
        actual.putAll("Spurs", newArrayList("Tony Parker", "Tim Duncan", "Manu Ginobili"));
        assertThat(actual).containsKeys("Lakers", "Spurs");
        assertThat(actual).contains(entry("Lakers", "Kobe Bryant"), entry("Spurs", "Tim Duncan"));
    }

    @Test
    public void compareMultiset() {
        // Multiset assertions
        Multiset<String> actual = HashMultiset.create();
        actual.add("shoes", 2);
        assertThat(actual).contains(2, "shoes");
        assertThat(actual).containsAtLeast(1, "shoes");
        assertThat(actual).containsAtMost(3, "shoes");
    }

    @Test
    public void compareRange() {
        // Range assertions
        Range<Integer> range = Range.closed(10, 12);
        assertThat(range).isNotEmpty()
                .contains(10, 11, 12)
                .hasClosedLowerBound()
                .hasLowerEndpointEqualTo(10)
                .hasUpperEndpointEqualTo(12);
    }

    @Test
    public void compareTable() {
        // Table assertions
        Table<Integer, String, String> bestMovies = HashBasedTable.create();
        bestMovies.put(1970, "Palme d'Or", "M.A.S.H");
        bestMovies.put(1994, "Palme d'Or", "Pulp Fiction");
        bestMovies.put(2008, "Palme d'Or", "Entre les murs");
        bestMovies.put(2000, "Best picture Oscar", "American Beauty");
        bestMovies.put(2011, "Goldener Bär", "A Separation");
        assertThat(bestMovies).hasRowCount(5).hasColumnCount(3).hasSize(5)
                .containsValues("American Beauty", "A Separation", "Pulp Fiction")
                .containsCell(1994, "Palme d'Or", "Pulp Fiction")
                .containsColumns("Palme d'Or", "Best picture Oscar", "Goldener Bär")
                .containsRows(1970, 1994, 2000, 2008, 2011);

    }

    @Test
    public void compareOptional() {
        // Optional assertions
        Optional<String> optional = Optional.of("Test");
        assertThat(optional).isPresent().contains("Test");
    }


}
