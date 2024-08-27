package com.smarteducationserverside.utils;

import io.github.briqt.spark4j.SparkClient;
import io.github.briqt.spark4j.constant.SparkApiVersion;
import io.github.briqt.spark4j.model.SparkMessage;
import io.github.briqt.spark4j.model.request.SparkRequest;
import jakarta.annotation.Resource;

import com.smarteducationserverside.pojo.ChatData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 星火AI工具类
 */
@Component
public class SparkAIUtils {
    @Resource
    private SparkClient sparkClient;
    /**
     * AI生成问题的预设条件
     */
    private final String PRECONDITION = "你是一个英语老师，接下来将给出学生与你的对话，请根据对话内容给出以及最后一次学生提问，给出你的回答";

    /**
     * 向星火AI发送请求
     *
     * @param msgList 历史对话记录列表
     * @return AI生成的回答
     */
    public String sendMesToAIUseXingHuo(final List<ChatData> msgList) {
        // 消息列表，可以在此列表添加历史对话记录
        List<SparkMessage> messages = new ArrayList<>();
        messages.add(SparkMessage.systemContent(PRECONDITION));
        for (ChatData cData : msgList)
            if (cData.isUser() == false)
                messages.add(SparkMessage.userContent("老师：" + cData.getText()));
            else
                messages.add(SparkMessage.userContent("学生：" + cData.getText()));
        // 构造请求
        SparkRequest sparkRequest = SparkRequest.builder()
                // 消息列表
                .messages(messages)
                // 模型回答的tokens的最大长度，非必传，默认为2048
                .maxTokens(2048)
                // 结果随机性，取值越高随机性越强，即相同的问题得到的不同答案的可能性越高，非必传，取值为[0,1]，默认为0.5
                .temperature(0.2)
                // 指定请求版本
                .apiVersion(SparkApiVersion.V1_5)
                .build();
        // 同步调用
        return sparkClient.chatSync(sparkRequest).getContent().substring(3);
    }
}