package ba.edu.ibu.webengineeringproject.rest.controllers;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class AuthControllerTest {
    static String jwtToken;
    @Autowired
    MockMvc mockMvc;
    private MockMvcRequestBuilders builders;

    @BeforeEach
    public void init() throws Exception {
        if (jwtToken == null) {
            System.out.println("######## EXECUTED ---------");
            String body = """
                    {
                      "email": "t1",
                      "password": "t1"
                    }
                    """;

            MvcResult result = mockMvc.perform(
                            MockMvcRequestBuilders
                                    .post("/api/auth/login")
                                    .content(body)
                                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            System.out.println("###### " + result.getResponse().getContentAsString());

            String response = result.getResponse().getContentAsString();
            jwtToken = JsonPath.read(response, "$.jwt");
        }
    }
    @Test
    void shouldGetAllUsers() throws Exception {
        System.out.println("BEFORE HAS BEEN EXECUTED <--> ".concat(jwtToken));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users/")
                .header("Authorization", "Bearer " + jwtToken)).andExpect(status().isOk()).andReturn();
        System.out.println(result);
    }
}

