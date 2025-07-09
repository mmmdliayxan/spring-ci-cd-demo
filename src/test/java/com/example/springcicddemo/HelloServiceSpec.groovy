package com.example.springcicddemo

import com.example.springcicddemo.controller.HelloController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = HelloController)
class HelloControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    def "GET /api/hello should return greeting"() {
        expect:
        mockMvc.perform(get("/api/hello?name=Ayxan"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi, Ayxan!"))
    }

    def "GET /api/hello with no param should use default"() {
        expect:
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi, Ayxan!"))
    }
}