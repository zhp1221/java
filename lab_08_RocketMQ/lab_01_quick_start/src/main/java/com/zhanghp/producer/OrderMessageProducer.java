package com.zhanghp.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023-07-26 08:44
 */
public class OrderMessageProducer {

	public static void main(String[] args) {

	}

	public static void orderMessage() throws MQClientException, MQBrokerException, RemotingException,
			InterruptedException, UnsupportedEncodingException {
		// 创建Producer
		DefaultMQProducer producer = new DefaultMQProducer("group_name_order");
		// 启动
		producer.start();
		// 消息生成并发送
		for (int i = 0; i < 100; i++) {
			//
			int orderId = i % 10;
			Message message = new Message("topic_name", "tag_name", "KEY" + i,
					("Hello RocketMQ - Order:" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
			SendResult sendResult = producer.send(message, new MessageQueueSelector() {
				@Override
				public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
					return null;
				}
			}, orderId);
			System.out.printf("%s%n", sendResult);
		}
		producer.shutdown();
	}

	public static void officalOrderMessage() {
		try {
			DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
			producer.start();

			String[] tags = new String[] { "TagA", "TagB", "TagC", "TagD", "TagE" };
			for (int i = 0; i < 100; i++) {
				int orderId = i % 10;
				Message msg = new Message("TopicTest", tags[i % tags.length], "KEY" + i,
						("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
				SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
					@Override
					public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
						Integer id = (Integer) arg;
						int index = id % mqs.size();
						return mqs.get(index);
					}
				}, orderId);

				System.out.printf("%s%n", sendResult);
			}

			producer.shutdown();
		}
		catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
