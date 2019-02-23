package net.me.june.dev;

import net.me.june.dev.domain.User;
import net.me.june.dev.domain.UserDTO;
import net.me.june.dev.serivice.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Test
    public void createUser() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                                .userId("ces518")
                                .userPassword("thwjd3859")
                                .userName("박준영")
                                .phone("010-4760-9270")
                                .email("pupupee9@gmail.com").build();

        User savedUser = userService.createUser(userDTO);
        logger.debug("savedUser = {}",savedUser);

        assertThat(savedUser.getUserId()).isEqualTo("ces518");
        assertThat(savedUser.getUserName()).isEqualTo("박준영");
        assertThat(savedUser.getEmail()).isEqualTo("pupupee9@gmail.com");

    }
}
