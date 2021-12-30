package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : study
 * fileName : StringTest
 * author : haedoang
 * date : 2021-12-22
 * description :
 */
public class StringTest {

    @Test
    @DisplayName("String 객체의 값 비교하기")
    public void compare() {
        // given
        String given1 = "안녕하세요";
        String given2 =  new String("안녕하세요");

        // when
        boolean case1 = given1.equals(given2);
        boolean case2 = given1 == given2;

        // then
        assertThat(case1).isTrue();
        assertThat(case2).isFalse();
    }


    @Test
    @DisplayName("split 테스트하기")
    public void create() throws Exception{
        // given
        String str = "haedoang@gmail.com";

        // when
        String[] split = str.split("@");

        // then
        assertThat(split).hasSize(2);
    }
}
