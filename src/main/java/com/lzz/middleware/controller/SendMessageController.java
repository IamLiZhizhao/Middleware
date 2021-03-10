package com.lzz.middleware.controller;

import com.lzz.middleware.dto.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @GetMapping("send/{message}")
    public void send(@PathVariable String message) {
        // send方法是一个异步方法，我们可以通过回调的方式来确定消息是否发送成功
        ListenableFuture<SendResult<String, KafkaMessage>> future = this.kafkaTemplate.send("test", new KafkaMessage("lizhizhao", message));
        future.addCallback(new ListenableFutureCallback<SendResult<String, KafkaMessage>>() {
            @Override
            public void onSuccess(SendResult<String, KafkaMessage> result) {
                logger.info("成功发送消息：{}，offset=[{}]", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("消息：{} 发送失败，原因：{}", message, ex.getMessage());
            }
        });
    }
}