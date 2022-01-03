package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set의 size")
    void checkSize() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
        System.out.println(size);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();

    }

    @DisplayName("set 내부 값의 존재 여부 확인 - 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_containsTest(int element) {
        assertTrue(numbers.contains(element));
    }

    @DisplayName("true, false 값을 같이 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void set_contains_ture_false(int element, boolean expected){
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }

}
