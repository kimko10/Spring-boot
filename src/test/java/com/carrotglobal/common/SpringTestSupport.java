package com.carrotglobal.common;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.carrotglobal.sample.SampleApplication;

@ExtendWith(SpringExtension.class) // Junit4의 RunWith(SpringRunner.class)와 비슷
@SpringBootTest(classes = SampleApplication.class)
@ActiveProfiles("test")
public abstract class SpringTestSupport {

}
