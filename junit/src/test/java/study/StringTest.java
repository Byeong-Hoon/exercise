package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
    @DisplayName("split 활용")
    public void splitTest(){
        //given
        String str1 = "1,2";
        String str2 = "1";

        //when
        String[] split1 = str1.split(",");
        String[] split2 = str2.split(",");

        //then
        assertThat(split1).contains("1","2");
        assertThat(split1).containsExactly("1","2");

        assertThat(split2).contains("1");
        assertThat(split2).containsExactly("1");
    }

    @Test
    @DisplayName("substring 활용")
    public void subStringTest(){
        //given
        String str = "(1,2)";
        //when
        String result = str.substring(1,4);
        //then
        assertThat(result).isEqualTo("1,2");
        System.out.println(result);
    }

    @Test
    @DisplayName("charAt() 활용")
    public void charAtTest(){
        //given
        String str = "abc";

        //when
        char c = str.charAt(2);

        //then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt에서 assertThatThrownBy를 사용하여 Exception 처리")
    public void assertThatThrownByTest(){
        //given
        String str = "abc";
        int index = 21;
        //when
        assertThatThrownBy(() -> {
            char c = str.charAt(index);
            assertThat(c).isEqualTo('c');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d",index);
        //then
    }

    @Test
    @DisplayName("charAt에서 assertThatExceptionOfType를 사용하여 Exception 처리")
    public void assertThatExceptionOfTypeTest(){
        //given
        String str = "abc";
        int index = 21;
        //when
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d",index);
        //then
    }

}
