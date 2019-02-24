package net.me.june.dev.web;

import net.me.june.dev.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MockMvc mockMvc;

    @Test
    public void postList() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get("/posts")
                .param("searchCondition", "2")
                .param("searchKeyword", "박준영"))
                .andDo(print())
                .andExpect(status().isOk());

        Map<String, Object> model = resultActions.andReturn().getModelAndView().getModel();

        logger.debug("model = {}",model.get("posts"));
    }

    @Test
    public void createPost() throws Exception {
        mockMvc.perform(post("/posts")
                        .param("title","title-test")
                        .param("content","content-test"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection());
    }
}