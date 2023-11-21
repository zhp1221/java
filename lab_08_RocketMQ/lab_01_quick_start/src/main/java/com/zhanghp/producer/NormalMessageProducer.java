package com.zhanghp.producer;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanghp
 * @date 2023-07-24 23:06
 */
public class NormalMessageProducer {

	public static void main(String[] args) throws Exception {
		// 同步消息发送
		// syncMessage();
		// 异步消息发送
		// asyncMessaage();
		// 单向消息发送
		onewayMessage();
	}

	@SneakyThrows
	public static void syncMessage() {
		// 1.初始化Producer 设置group name
		DefaultMQProducer producer = new DefaultMQProducer("group_name_sync");
		// 2.设置NameServer地址
		producer.setNamesrvAddr("localhost:9876");
		// 3.启动Producer
		producer.start();

		// 4.创建消息
		// 指定topic，tag，boy等
		Message message = new Message("topic_name", "tag_name",
				"Hello,RockerMQ - Sync".getBytes(RemotingHelper.DEFAULT_CHARSET));

		// 5.利用producer进行发送，并同步等待结果
		SendResult result = producer.send(message);
		System.out.printf("%s%n", result);

		// 6.关闭producer
		producer.shutdown();

	}

	@SneakyThrows
	public static void asyncMessaage() {
		// 1.初始化Producer 设置group name
		DefaultMQProducer producer = new DefaultMQProducer("group_name_async");
		// 2.设置NameServer地址
		producer.setNamesrvAddr("localhost:9876");
		// 3.启动Producer
		producer.start();
		producer.setRetryTimesWhenSendAsyncFailed(0);
		int messageCount = 5;
		CountDownLatch countDownLatch = new CountDownLatch(messageCount);
		for (int i = 0; i < messageCount; i++) {
			try {
				final int index = i;
				// 指定topic，tag，boy等
				Message message = new Message("topic_name", "tag_name",
						("Hello,RockerMQ - Async:" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

				// 异步发送消息，发送结果通过callback返回客户端
				producer.send(message, new SendCallback() {
					@Override
					public void onSuccess(SendResult sendResult) {
						// %-10d:左对齐并用空格填充，总宽度为10个字符的整数类型（十进制）
						System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
						countDownLatch.countDown();
					}

					@Override
					public void onException(Throwable throwable) {
						System.out.printf("%-10d Exception %s %n", index, throwable);
						throwable.printStackTrace();
						countDownLatch.countDown();
					}
				});
			}
			catch (Exception e) {
				e.printStackTrace();
				countDownLatch.countDown();
			}

		}

		// 异步发送，如果要求可靠传输，必须要等回调接口返回明确结果后才能结束逻辑，否则立即关闭Producer可能导致部分消息尚未传输成功
		countDownLatch.await(5, TimeUnit.SECONDS);
		// 一旦producer不再使用，关闭producer
		producer.shutdown();
	}

	public static void onewayMessage() throws Exception {
		// 初始化Producer
		DefaultMQProducer producer = new DefaultMQProducer("group_name_oneway");
		// 设置NameServer地址
		producer.setNamesrvAddr("localhost:9876");
		// 启动producer
		producer.start();
		// 创建一条消息，并指定topic、tag、body等信息，tag可以理解成标签，对消息进行再归类，RocketMQ可以在消费端对tag进行过滤
		Message message = new Message("topic_name", "tag_name",
				"Hello RocketMQ - Oneway".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// 由于在oneway方式发送消息时没有请求应答处理，如果出现消息发送失败，则会因为没有重试而导致数据丢失。若数据不可丢，建议选用可靠同步或可靠异步发送方式。
		producer.sendOneway(message);
		// 关闭producer
		producer.shutdown();
	}

}
