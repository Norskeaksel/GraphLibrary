// https://open.kattis.com/problems/crosscountry?tab=metadata
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import java.io.File
import kotlin.test.Test


class KingEscape3 {
    companion object {
        @JvmStatic
        @AfterAll
        fun resetInput() {
            _reader = INPUT.bufferedReader()
        }
    }

    @Test
    fun KingEscape3a() {
        _reader = File("src/test/SampleInput/KingEscape3/input1").inputStream().bufferedReader()
        assertThat(kingEscape3()).isEqualTo("YES")
    }
    @Test
    fun KingEscape3b() {
        _reader = File("src/test/SampleInput/KingEscape3/input2").inputStream().bufferedReader()
        assertThat(kingEscape3()).isEqualTo("NO")
    }
    @Test
    fun KingEscape3c() {
        _reader = File("src/test/SampleInput/KingEscape3/input3").inputStream().bufferedReader()
        assertThat(kingEscape3()).isEqualTo("NO")
    }
}