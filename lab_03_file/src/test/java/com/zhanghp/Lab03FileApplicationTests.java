package com.zhanghp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
class Lab03FileApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    static File file;
    @BeforeAll
    static void init(){
        file = new File("C:\\Users\\zhang\\Desktop\\test.doc");
    }

    @Test
    void contextLoads() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        MockMultipartFile file = new MockMultipartFile(
                "name",
                "original_name.doc",
                "multipart/form-data",
                fileInputStream);
//        String response = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload")
//                .file(file)
//                .characterEncoding("utf-8")
//        ).andReturn().getResponse().getContentAsString();
        String respoqnse = mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                .file(file)
                .characterEncoding("utf-8")
        ).andReturn().getResponse().getContentAsString();
        System.out.println(respoqnse);

    }

}
