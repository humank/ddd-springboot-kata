package solid.humank.tutorials;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import solid.humank.tutorials.applications.Tutorial;
import solid.humank.tutorials.interfaces.TutorialController;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// This is 鳳先, Hello World
// 到此一遊
// DaMuSe歸位

@SpringBootTest
@AutoConfigureMockMvc
public class DddSpringbootKataApplicationTests {

    ObjectMapper objectMapper;

    @BeforeEach
    public void init(){
        objectMapper = new ObjectMapper();
    }

    @Autowired
    private TutorialController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void should_get_correct_json() throws Exception {
        String uri = "/api/tutorials";
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        tutorials.add(new Tutorial(91,"test1","kimtest",true));
        tutorials.add(new Tutorial(92,"test2","fongtest",true));
        tutorials.add(new Tutorial(93,"test3","arthurtest",true));//
        tutorials.add(new Tutorial(94,"test4","rivertest",true));

        String  expected= objectMapper.writeValueAsString(tutorials);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(uri));
        String content = result.andReturn().getResponse().getContentAsString();
        assertEquals(expected,content);
    }

    @Test
    void create_tutorail_should_get_correct_json() throws Exception {
        String uri = "/api/tutorials";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content("{\"id\":99,\"title\":\"this is title\",\"desctiption\":\"this is description\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

    }

}

