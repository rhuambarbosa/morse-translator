package br.com.rbs.translator

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@ActiveProfiles(value = ["test"])
@WebAppConfiguration
@ContextConfiguration(loader = SpringBootContextLoader.class, classes = [MorseTranslatorApplication.class])
class MorseTranslatorApplicationTests extends Specification {

    @Autowired
    WebApplicationContext context

    MockMvc mockMvc
}
