// package com.esucuelaing.app.BackSpring;
// import com.esucuelaing.app.BackSpring.model.Task;
// import com.esucuelaing.app.BackSpring.repository.TaskRepository;
// import com.esucuelaing.app.BackSpring.service.TaskService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// @SpringJUnitConfig
// @SpringBootTest
// @AutoConfigureMockMvc
// public class ControllerIntegrationTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Autowired
//     private TaskRepository taskRepository;

//     @Test
//     public void createTaskTest() throws Exception {
//         String taskJson = "{ \"name\": \"Task Name\", \"description\": \"Task Description\", \"createdBy\": \"User\", \"status\": \"Pending\" }";

//         mockMvc.perform(MockMvcRequestBuilders
//                 .post("/api/tasks")
//                 .content(taskJson)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andDo(print());
//     }

//     // Write similar tests for other CRUD operations
// }