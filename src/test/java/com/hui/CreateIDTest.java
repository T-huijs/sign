package com.hui;

import com.hui.util.CreateID;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class CreateIDTest {



    @Test
    public void testGetUUid(){
        log.info("type-'',UUID-{}", CreateID.getUUid(""));
        log.info("type-'USER',UUID-{}", CreateID.getUUid("USER"));
        log.info("type-'0001',UUID-{}", CreateID.getUUid("0001"));
        log.info("type-'0000',UUID-{}", CreateID.getUUid("0000"));
    }


}
