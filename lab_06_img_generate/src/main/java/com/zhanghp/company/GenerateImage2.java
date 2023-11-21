package com.zhanghp.company;

import com.zhanghp.company.enums.ChartDataEnum;
import com.zhanghp.company.enums.PushHourEnum;
import com.zhanghp.company.entity.AdsPdNewPushByHourE;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/7/17 13:33
 */
public class GenerateImage2 {

	private static final String PATH = "D:\\work_space\\my_gitee\\java\\java\\Image_" + System.currentTimeMillis()
			+ ".png";

	private static final int FIRST_CELL = 250;

	private static final int SECONDE_CELL = 450;

	private static final int THIRD_CELL = 600;

	private static final int FORTH_CELL = 200;

	/**
	 * 信息流插入（包含23:30）
	 * @param graphics
	 * @param messageList
	 */
	public static void insertMessage(Graphics2D graphics, List<AdsPdNewPushByHourE> messageList) {
		for (int i = 0; i < messageList.size(); i++) {
			final AdsPdNewPushByHourE data = messageList.get(i);
			int y = i * 20;
			// 例子数
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1(), ChartDataEnum.MESSAGE_EXAMPLE.getX2(),
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getExample(), Font.PLAIN, 15), null);
			// 重复率
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX2(),
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y,
					ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getRepeatPercent(), Font.PLAIN, 15), null);
			// 到课数
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getArriveCount(), Font.PLAIN, 15), null);
			// 到课率
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getArrivePercent(), Font.PLAIN, 15), null);

			// 结果数据
			// 转化订单数
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y,
					ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getConvertOrderCount(), Font.PLAIN, 15),
					null);
			// 转化率
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5),
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5),
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getConvertPercent(), Font.PLAIN, 15), null);
			// 到课转化率
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getArriveConvertPercent(), Font.PLAIN, 15), null);
			// GMV
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getGmv(), Font.PLAIN, 15), null);
			// 例子价值
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getExampleValue(), Font.PLAIN, 15), null);

			// 听课意愿
			// 听10分占比
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getMoreThanTen(), Font.PLAIN, 15), null);
			// 听80分占比
			drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2,
					ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2,
					ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y,
					new Font(data.getMoreThanEighty(), Font.PLAIN, 15), null);
		}
	}

	/**
	 * 直播流插入（包含23:30）
	 * @param graphics
	 * @param liveList
	 */
	public static void insertLive(Graphics2D graphics, List<AdsPdNewPushByHourE> liveList) {
		for (int i = 0; i < liveList.size(); i++) {
			final AdsPdNewPushByHourE data = liveList.get(i);
			int y = i * 20;
			// 例子数
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1(), ChartDataEnum.LIVE_NEW_EXAMPLE.getX2(),
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getExample(), Font.PLAIN, 15), null);
			// 重复率
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2(),
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getRepeatPercent(), Font.PLAIN, 15), null);
			// 到课数
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getArriveCount(), Font.PLAIN, 15), null);
			// 到课率
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getArrivePercent(), Font.PLAIN, 15), null);

			// 结果数据
			// 转化订单数
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getConvertOrderCount(), Font.PLAIN, 15),
					null);
			// 转化率
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5),
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5),
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getConvertPercent(), Font.PLAIN, 15), null);
			// 到课转化率
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getArriveConvertPercent(), Font.PLAIN, 15), null);
			// GMV
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getGmv(), Font.PLAIN, 15), null);
			// 例子价值
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getExampleValue(), Font.PLAIN, 15), null);

			// 听课意愿
			// 听10分占比
			drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getMoreThanTen(), Font.PLAIN, 15), null);
			// 听80分占比
			drawCenterText(graphics,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2,
					ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y,
					new Font(data.getMoreThanEighty(), Font.PLAIN, 15), null);
		}
	}

	public static void main(String[] args) {
		final GrapParams grapParams = generate("盖伦 6月20日 13:00 数据播报");
		final BufferedImage image = grapParams.getImage();
		final Graphics2D graphics = grapParams.getGraphics();
		// charu 数据
		final AdsPdNewPushByHourE data = AdsPdNewPushByHourE.generate("直播间");
		final AdsPdNewPushByHourE data1 = AdsPdNewPushByHourE.generate("直播间");
		final AdsPdNewPushByHourE data2 = AdsPdNewPushByHourE.generate("直播间");
		final AdsPdNewPushByHourE data3 = AdsPdNewPushByHourE.generate("直播间");
		final AdsPdNewPushByHourE data4 = AdsPdNewPushByHourE.generate("直播间");
		final AdsPdNewPushByHourE data5 = AdsPdNewPushByHourE.generate("直播间");
		final AdsPdNewPushByHourE data6 = AdsPdNewPushByHourE.generate("直播间");
		List<AdsPdNewPushByHourE> list = new ArrayList<>();
		list.add(data);
		list.add(data1);
		list.add(data2);
		list.add(data3);
		list.add(data4);
		list.add(data5);
		list.add(data6);
		// 例子数
		insertLive(graphics, list);
		;
		// drawCenterText(graphics, ChartDataEnum.MESSAGE_NEW_TOTAL_EXAMPLE.getX1(),
		// ChartDataEnum.MESSAGE_NEW_TOTAL_EXAMPLE.getX2(),
		// ChartDataEnum.MESSAGE_NEW_TOTAL_EXAMPLE.getY1(),
		// ChartDataEnum.MESSAGE_NEW_TOTAL_EXAMPLE.getY2(), new Font(data.getExample(),
		// Font.PLAIN, 15), null);
		// drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1(),
		// ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2(),
		// ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(),
		// ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExample(),
		// Font.PLAIN, 15), null);
		// drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1(),
		// ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2(),
		// ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(),
		// ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getExample(),
		// Font.PLAIN, 15), null);
		//
		// drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1(),
		// ChartDataEnum.LIVE_NEW_EXAMPLE.getX2(), ChartDataEnum.LIVE_NEW_EXAMPLE.getY1(),
		// ChartDataEnum.LIVE_NEW_EXAMPLE.getY2(), new Font(data.getExample(), Font.PLAIN,
		// 15), null);
		// drawCenterText(graphics, ChartDataEnum.LIVE_NEW_TOTAL_EXAMPLE.getX1(),
		// ChartDataEnum.LIVE_NEW_TOTAL_EXAMPLE.getX2(),
		// ChartDataEnum.LIVE_NEW_TOTAL_EXAMPLE.getY1(),
		// ChartDataEnum.LIVE_NEW_TOTAL_EXAMPLE.getY2(), new Font(data.getExample(),
		// Font.PLAIN, 15), null);
		// drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1(),
		// ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2(),
		// ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(),
		// ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExample(),
		// Font.PLAIN, 15), null);
		// drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1(),
		// ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2(),
		// ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(),
		// ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getExample(),
		// Font.PLAIN, 15), null);
		//
		// drawCenterText(graphics, ChartDataEnum.OTHER.getX1(),
		// ChartDataEnum.OTHER.getX2(), ChartDataEnum.OTHER.getY1(),
		// ChartDataEnum.OTHER.getY2(), new Font(data.getExample(), Font.PLAIN, 15),
		// null);
		// drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1(),
		// ChartDataEnum.DAY_SUM.getX2(), ChartDataEnum.DAY_SUM.getY1(),
		// ChartDataEnum.DAY_SUM.getY2(), new Font(data.getExample(), Font.PLAIN, 15),
		// null);
		createImg(image, PATH);
	}

	public static GrapParams generate(String title) {
		// 竖线的行数
		int imageWidth = 1500;
		int imageHeight = 510;
		int titleEndY = 30;
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		// 图片清晰
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(new Color(220, 240, 240));

		drawCenterText(graphics, 0, imageWidth, 0, titleEndY, new Font(title, Font.BOLD, 20), new Color(186, 206, 253));
		graphics.setColor(Color.black);
		handleLine(graphics, titleEndY, 20, imageWidth, imageHeight);
		// 横线
		drawAcrossLine(graphics, imageWidth);

		final GrapParams result = new GrapParams();
		result.setImage(image);
		result.setGraphics(graphics);
		return result;

	}

	private static void createImg(BufferedImage image, String filePath) {
		// 图片生成
		try {
			// 创建文件输出流
			FileOutputStream out = new FileOutputStream(filePath);
			// 以这个代替掉 JPEGCodec
			ImageIO.write(image, "png", out);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Long end = System.currentTimeMillis();
	}

	private static void handleLine(Graphics2D graphics, int titleEndY, int cellHeight, int imageWidth,
			int imageHeight) {

		// 标题下方的第一个单元格 endy
		int firstCellEndY = titleEndY + cellHeight;
		// 标题下方的第二个单元格 endy
		int secondCellEndY = titleEndY + cellHeight * 2;
		// 内容填充

		int first_start = 0;
		int first_end = FIRST_CELL;

		int second_start = FIRST_CELL;
		int second_end = FIRST_CELL + SECONDE_CELL;

		int third_start = FIRST_CELL + SECONDE_CELL;
		int third_end = FIRST_CELL + SECONDE_CELL + THIRD_CELL;

		int forth_start = FIRST_CELL + SECONDE_CELL + THIRD_CELL;
		int forth_end = FIRST_CELL + SECONDE_CELL + THIRD_CELL + FORTH_CELL;

		// 颜色补充
		// 信息流颜色补充
		graphics.setColor(new Color(254, 212, 164));
		graphics.fillRect(first_start + (FIRST_CELL / 3), secondCellEndY + 7 * 20, imageWidth, 20);
		graphics.setColor(new Color(222, 224, 227));
		graphics.fillRect(first_start + (FIRST_CELL / 3), secondCellEndY + 9 * 20, imageWidth, 20);
		graphics.setColor(new Color(186, 206, 253));
		// 直播间颜色补充
		graphics.fillRect(0, imageHeight - 20, imageWidth, 20);
		graphics.setColor(new Color(222, 224, 227));
		graphics.fillRect((FIRST_CELL / 3) * 1, imageHeight - 60, imageWidth, 20);
		graphics.setColor(new Color(254, 212, 164));
		graphics.fillRect((FIRST_CELL / 3) * 1, imageHeight - 100, imageWidth, 20);

		// 信息补充
		// 信息流
		drawCenterText(graphics, 20, (FIRST_CELL / 3) * 1, secondCellEndY,
				secondCellEndY + 20 * PushHourEnum.getDetailList().size() + 20, new Font("信息流", Font.BOLD, 20), null);
		// 直播间
		drawCenterText(graphics, 20, (FIRST_CELL / 3) * 1, secondCellEndY + 20 * PushHourEnum.getDetailList().size(),
				secondCellEndY + 2 * 20 * (PushHourEnum.getDetailList().size() + 2) + 20,
				new Font("直播间", Font.BOLD, 20), null);
		// 其他流量类型
		graphics.drawString("其他流量类型", 5, (imageHeight - 40) + 15);
		// 日合计
		graphics.drawString("日合计", 20, (imageHeight - 20) + 15);

		// 人群相关
		int personCrowdY = secondCellEndY + 20 * (PushHourEnum.getDetailList().size() - 1);
		int secondPersonCrowDy = personCrowdY + 20 * (PushHourEnum.getDetailList().size() - 1);
		int secondPersonCrowdYEnd = secondPersonCrowDy + 20 * (PushHourEnum.getDetailList().size() - 1);
		graphics.drawLine((FIRST_CELL / 3) * 1, personCrowdY, imageWidth, personCrowdY);
		graphics.drawLine((FIRST_CELL / 3) * 1, personCrowdY + 20, imageWidth, personCrowdY + 20);
		graphics.drawLine((FIRST_CELL / 3) * 1, personCrowdY + 40, imageWidth, personCrowdY + 40);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 20, (FIRST_CELL / 3) * 2, secondCellEndY, personCrowdY,
				new Font("新量", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 40, (FIRST_CELL / 3) * 2, personCrowdY, personCrowdY + 15,
				new Font("新量合计", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 40, (FIRST_CELL / 3) * 2, personCrowdY + 20,
				personCrowdY + 15 + 20, new Font("老量合计", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 20, (FIRST_CELL / 3) * 2, personCrowdY + 40,
				personCrowdY + 15 + 40, new Font("总计", Font.BOLD, 20), null);

		graphics.drawLine((FIRST_CELL / 3) * 1, imageHeight - 100, imageWidth, imageHeight - 100);
		graphics.drawLine((FIRST_CELL / 3) * 1, imageHeight - 80, imageWidth, imageHeight - 80);
		graphics.drawLine((FIRST_CELL / 3) * 1, imageHeight - 60, imageWidth, imageHeight - 60);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 20, (FIRST_CELL / 3) * 2, imageHeight - 240, imageHeight - 100,
				new Font("新量", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 40, (FIRST_CELL / 3) * 2, imageHeight - 100, imageHeight - 85,
				new Font("新量合计", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 40, (FIRST_CELL / 3) * 2, imageHeight - 80, imageHeight - 65,
				new Font("老量合计", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1 + 20, (FIRST_CELL / 3) * 2, imageHeight - 60, imageHeight - 45,
				new Font("总计", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1, (FIRST_CELL / 3) * 2, imageHeight - 40, imageHeight - 25,
				new Font("/", Font.BOLD, 20), null);
		drawCenterText(graphics, (FIRST_CELL / 3) * 1, (FIRST_CELL / 3) * 2, imageHeight - 20, imageHeight,
				new Font("/", Font.BOLD, 20), null);

		drawCenterText(graphics, first_start, first_end, titleEndY, firstCellEndY, new Font("基础信息", Font.PLAIN, 15),
				new Color(222, 224, 227));
		drawCenterText(graphics, second_start, second_end, titleEndY, firstCellEndY, new Font("过程数据", Font.PLAIN, 15),
				new Color(217, 245, 214));
		drawCenterText(graphics, third_start, third_end, titleEndY, firstCellEndY, new Font("结果数据", Font.PLAIN, 15),
				new Color(222, 224, 227));
		drawCenterText(graphics, forth_start, forth_end, titleEndY, firstCellEndY, new Font("听课意愿", Font.PLAIN, 15),
				new Color(217, 245, 214));

		int first = FIRST_CELL / 3;
		graphics.setColor(new Color(222, 224, 227));
		graphics.fillRect(first_start, 50, FIRST_CELL, 20);
		drawCenterText(graphics, first_start + 0 * first, first_start + 1 * first, firstCellEndY, secondCellEndY,
				new Font("流量类型", Font.PLAIN, 15), null);
		drawCenterText(graphics, first_start + 1 * first, first_start + 2 * first, firstCellEndY, secondCellEndY,
				new Font("人群", Font.PLAIN, 15), null);
		drawCenterText(graphics, first_start + 2 * first, first_start + 3 * first, firstCellEndY, secondCellEndY,
				new Font("统计时间", Font.PLAIN, 15), null);
		graphics.drawLine(first_start + 1 * first, firstCellEndY, first_start + 1 * first, imageHeight);
		graphics.drawLine(first_start + 2 * first, firstCellEndY, first_start + 2 * first, imageHeight);

		int second = SECONDE_CELL / 4;

		graphics.setColor(new Color(217, 245, 214));
		graphics.fillRect(second_start, 50, SECONDE_CELL, 20);
		drawCenterText(graphics, second_start + second * 0, second_start + second * 1, firstCellEndY, secondCellEndY,
				new Font("例子数", Font.PLAIN, 15), null);
		drawCenterText(graphics, second_start + second * 1, second_start + second * 2, firstCellEndY, secondCellEndY,
				new Font("重复率", Font.PLAIN, 15), null);
		drawCenterText(graphics, second_start + second * 2, second_start + second * 3, firstCellEndY, secondCellEndY,
				new Font("到课数", Font.PLAIN, 15), null);
		drawCenterText(graphics, second_start + second * 3, second_start + second * 4, firstCellEndY, secondCellEndY,
				new Font("到课率", Font.PLAIN, 15), null);
		graphics.drawLine(second_start + second * 0, firstCellEndY - 20, second_start + second * 0, imageHeight);
		graphics.drawLine(second_start + second * 1, firstCellEndY, second_start + second * 1, imageHeight);
		graphics.drawLine(second_start + second * 2, firstCellEndY, second_start + second * 2, imageHeight);
		graphics.drawLine(second_start + second * 3, firstCellEndY, second_start + second * 3, imageHeight);

		int third = THIRD_CELL / 5;
		graphics.setColor(new Color(222, 224, 227));
		graphics.fillRect(third_start, 50, THIRD_CELL, 20);
		drawCenterText(graphics, third_start + third * 0, third_start + third * 1, firstCellEndY, secondCellEndY,
				new Font("转化订单数", Font.PLAIN, 15), null);
		drawCenterText(graphics, third_start + third * 1, third_start + third * 2, firstCellEndY, secondCellEndY,
				new Font("转化率", Font.PLAIN, 15), null);
		drawCenterText(graphics, third_start + third * 2, third_start + third * 3, firstCellEndY, secondCellEndY,
				new Font("到课转化率", Font.PLAIN, 15), null);
		drawCenterText(graphics, third_start + third * 3, third_start + third * 4, firstCellEndY, secondCellEndY,
				new Font("GMV", Font.PLAIN, 15), null);
		drawCenterText(graphics, third_start + third * 4, third_start + third * 5, firstCellEndY, secondCellEndY,
				new Font("例子价值", Font.PLAIN, 15), null);
		graphics.drawLine(third_start + third * 0, firstCellEndY - 20, third_start + third * 0, imageHeight);
		graphics.drawLine(third_start + third * 1, firstCellEndY, third_start + third * 1, imageHeight);
		graphics.drawLine(third_start + third * 2, firstCellEndY, third_start + third * 2, imageHeight);
		graphics.drawLine(third_start + third * 3, firstCellEndY, third_start + third * 3, imageHeight);
		graphics.drawLine(third_start + third * 4, firstCellEndY, third_start + third * 4, imageHeight);

		int fourth = FORTH_CELL / 2;
		graphics.setColor(new Color(217, 245, 214));
		graphics.fillRect(forth_start, 50, FORTH_CELL, 20);
		drawCenterText(graphics, forth_start + fourth * 0, forth_start + fourth * 1, firstCellEndY, secondCellEndY,
				new Font("听10m占比", Font.PLAIN, 15), null);
		drawCenterText(graphics, forth_start + fourth * 1, forth_start + fourth * 2, firstCellEndY, secondCellEndY,
				new Font("听80m占比", Font.PLAIN, 15), null);
		graphics.drawLine(forth_start + fourth * 0, firstCellEndY - 20, forth_start + fourth * 0, imageHeight);
		graphics.drawLine(forth_start + fourth * 1, firstCellEndY, forth_start + fourth * 1, imageHeight);

		// 22个线
		for (int i = 1; i <= 22; i++) {
			graphics.drawLine(first_start + (FIRST_CELL / 3) * 2, (i * 20) + (secondCellEndY), imageWidth,
					(i * 20) + (secondCellEndY));
		}
		final List<String> detailList = PushHourEnum.getDetailList();
		int startY = 0;
		for (int i = 1; i <= 2; i++) {
			int middleNum = secondCellEndY;
			if (i == 2) {
				// 写两个
				drawCenterText(graphics, first_start + (FIRST_CELL / 3) * 2, second_start, startY, startY + 20,
						new Font("23:30", Font.PLAIN, 15), null);
				drawCenterText(graphics, first_start + (FIRST_CELL / 3) * 2, second_start, startY + 20, startY + 40,
						new Font("23:30", Font.PLAIN, 15), null);
				middleNum = startY + 40;
				// 添加一条实线
				graphics.drawLine(0, middleNum, imageWidth, middleNum);
			}
			for (int it = 1; it <= detailList.size(); it++) {
				drawCenterText(graphics, first_start + (FIRST_CELL / 3) * 2, second_start, middleNum + (it - 1) * 20,
						middleNum + it * 20, new Font(detailList.get(it - 1), Font.PLAIN, 15), null);
				if (it == detailList.size()) {
					startY = middleNum + (it) * 20;
				}
				// 最后
				if (i == 2 && it == detailList.size()) {
					int lastStarY = middleNum + it * 20;
					for (int k = 1; k <= 4; k++) {
						drawCenterText(graphics, first_start + (FIRST_CELL / 3) * 2, second_start,
								lastStarY + (k - 1) * 20, lastStarY + k * 20, new Font("23:30", Font.PLAIN, 15), null);
						// 添加2条实线
						if (k >= 2) {
							graphics.drawLine(0, lastStarY + k * 20, imageWidth, lastStarY + k * 20);
						}
					}
				}
			}
		}

	}

	/**
	 * 居中字体写入，背景颜色设置
	 * @param graphics {@link Graphics2D}
	 * @param startX 起始x
	 * @param endX 结束x
	 * @param startY 起始y
	 * @param endY 结束y
	 */
	private static void drawCenterText(Graphics2D graphics, int startX, int endX, int startY, int endY, Font font,
			Color color) {
		// rgb(186,206,253)
		// graphics.setColor(new Color(186, 206, 253));
		// 背景颜色填充
		if (color != null) {
			graphics.setColor(color);
			graphics.fillRect(startX, startY, endX - startX, endY - startY);
		}

		// 字体颜色设置
		graphics.setColor(Color.black);
		// 字体规格对象
		final FontMetrics fontMetrics = graphics.getFontMetrics(font);
		// 文本宽度
		// final int textWidth = fontMetrics.stringWidth(font.getName());
		int textWidth = getWordWidth(font, font.getName());
		// 居中设置
		// 字体基线 -》 上升符的距离，如x^2
		int ascent = fontMetrics.getAscent();
		// 字体基线 -》 下降符的距离 如 H2O 化学符号的水
		final int descent = fontMetrics.getDescent();
		// x y 设置
		int x = startX + (((endX - startX) - textWidth) / 2);
		int y = startY + (((endY - startY) - (ascent + descent)) / 2 + ascent);
		// 写入
		graphics.drawString(font.getName(), x, y);
	}

	/**
	 * 横线
	 * @param graphics
	 */
	private static void drawAcrossLine(Graphics2D graphics, int imageWidth) {
		graphics.drawLine(0, 30, imageWidth, 30);
		graphics.drawLine(0, 50, imageWidth, 50);
		graphics.drawLine(0, 70, imageWidth, 70);
	}

	public static int getWordWidth(Font font, String content) {
		FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
		int width = 0;
		for (int i = 0; i < content.length(); i++) {
			width += metrics.charWidth(content.charAt(i));
		}
		return width;
	}

}
