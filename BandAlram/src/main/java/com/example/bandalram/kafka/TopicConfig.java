package com.example.bandalram.kafka;

import org.springframework.stereotype.Component;

@Component
public class TopicConfig {
    public final static String board = "board";
    public final static String boardUpdate = "boardUpdate";

    public final static String memberUpdate = "memberUpdate";

    public final static String memberDelete = "memberDelete";
    public final static String socketServer2 = "socketServer2";

}
