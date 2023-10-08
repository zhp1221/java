package com.zhanghp.company;

import com.zhanghp.company.entity.AdsPdNewPushByHourE;
import com.zhanghp.company.enums.*;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhanghp
 * @date 2023/7/17 13:33
 */
//@Slf4j
public class GenerateImage {
    private static final String PATH = "D:\\work_space\\my_gitee\\java\\lab_06_img_generate\\src\\main\\resources\\Image_" + System.currentTimeMillis() + ".png";

    private static final int FIRST_CELL = 250;
    private static final int SECONDE_CELL = 450;
    private static final int THIRD_CELL = 600;
    private static final int FORTH_CELL = 200;

    private static final int FONT_DEFAULT = 12;
    private static final int FONT_DEFAULT_FIRST_TITLE = 17;
    private static final int FONT_DEFAULT_SECOND = 15;
    /**
     * 黑体
     */
    private static final String FONT_TYPE = "黑体";
    //    private final Integer imgWidth = 1500;
    private final Integer startCell = 70;
    private final Integer firstCell = 250;

    public static void drawCenterText(Graphics2D graphics, int startX, int endX, int startY, int endY, Font font, Color color, Integer nu) {
        // rgb(186,206,253)
//        graphics.setColor(new Color(186, 206, 253));
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
//        final int textWidth = fontMetrics.stringWidth(font.getName());
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
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = font.getSize();
        int style = font.getStyle();
        graphics.setFont(new Font(FONT_TYPE, style, size));
//		graphics.setFont(font);
        graphics.drawString(font.getName(), x, y);
    }

    /**
     * 居中字体写入，背景颜色设置
     *
     * @param graphics {@link Graphics2D}
     * @param startX   起始x
     * @param endX     结束x
     * @param startY   起始y
     * @param endY     结束y
     */
    public static void drawCenterText(Graphics2D graphics, int startX, int endX, int startY, int endY, Font font, Color color) {
        // rgb(186,206,253)
//        graphics.setColor(new Color(186, 206, 253));
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
        final int textWidth = fontMetrics.stringWidth(font.getName());
//        int textWidth = getWordWidth(font, font.getName());
        // 居中设置
        // 字体基线 -》 上升符的距离，如x^2
        int ascent = fontMetrics.getAscent();
        // 字体基线 -》 下降符的距离 如 H2O 化学符号的水
        final int descent = fontMetrics.getDescent();
        // x y 设置
        int x = startX + (((endX - startX) - textWidth) / 2);
        int y = startY + (((endY - startY) - (ascent + descent)) / 2 + ascent);
        // 写入
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = font.getSize();
        int style = font.getStyle();
        graphics.setFont(new Font(FONT_TYPE, style, size));
        graphics.drawString(font.getName(), x, y);
    }

    /**
     * 一级，二级，三级横线
     *
     * @param graphics
     */
    private static void drawAcrossLine(Graphics2D graphics, TalentImgParams params) {
        int imageWidth = params.imgWidth;
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

    public static List<String> hourCirculationHandle() {
        List<String> hourList = new ArrayList<>();
        hourList.add("10:00");
        hourList.add("13:00");
        hourList.add("15:00");
        hourList.add("16:00");
        hourList.add("18:00");
        hourList.add("19:20");
        hourList.add("20:20");
        hourList.add("21:00");
        hourList.add("21:30");
        hourList.add("22:30");
        return hourList;
    }

    public static List<String> hourPartHandle() {
        List<String> hourList = new ArrayList<>();
        hourList.add("10:00");
        hourList.add("13:00");
        hourList.add("15:00");
        hourList.add("16:00");
        hourList.add("18:00");
        hourList.add("19:20");
        hourList.add("20:20");
        hourList.add("21:00");
        hourList.add("21:30");
        hourList.add("22:30");
        hourList.add("22:30");
        hourList.add("22:30");
        return hourList;
    }

    public static List<String> hourAllHandle() {
        List<String> hourList = new ArrayList<>();
        hourList.add("10:00");
        hourList.add("13:00");
        hourList.add("15:00");
        hourList.add("16:00");
        hourList.add("18:00");
        hourList.add("19:20");
        hourList.add("20:20");
        hourList.add("21:00");
        hourList.add("21:30");
        hourList.add("22:30");
        hourList.add("22:30");
        hourList.add("22:30");

        hourList.add("10:00");
        hourList.add("13:00");
        hourList.add("15:00");
        hourList.add("16:00");
        hourList.add("18:00");
        hourList.add("19:20");
        hourList.add("20:20");
        hourList.add("21:00");
        hourList.add("21:30");
        hourList.add("22:30");
        hourList.add("22:30");
        hourList.add("22:30");

        hourList.add("22:30");
        hourList.add("22:30");
        return hourList;
    }

    public static void main(String[] args) {
        final GenerateImage generateImage = new GenerateImage();
        final GrapParams grapParams = generateImage.generateImg("測試", hourCirculationHandle());
        generateImage.createImg(grapParams.getImage(), PATH);
    }

    /**
     * 信息流插入-新量
     *
     * @param graphics
     * @param messageList
     */
    public boolean insertMessageForNew(Graphics2D graphics, List<AdsPdNewPushByHourE> messageList, TalentImgParams params) {
        if (Objects.isNull(messageList)) {

//			log.info(" 信息流插入-新量 ，数据为空");
            return false;
        }
        int firstMinWidth = params.firstMinWidth;
        int secondTitleHeight = params.secondTitleHeight;
        int thirdTitleHeight = params.thirdTitleHeight;
        int forthMinWidth = params.forthMinWidth;
        for (int i = 0; i < messageList.size(); i++) {
            final AdsPdNewPushByHourE data = messageList.get(i);
            int y = i * 20;
            // 例子数
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1(), ChartDataEnum.MESSAGE_EXAMPLE.getX2(), ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
            // 重复率
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX2(), ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
            // 到课数
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
            // 到课率
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

            // 结果数据
            // 转化订单数
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
            // 转化率
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
            // 到课转化率
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
            // GMV
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
            // 例子价值
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

            // 听课意愿
            // 听10分占比
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
            // 听80分占比
            drawCenterText(graphics, ChartDataEnum.MESSAGE_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.MESSAGE_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.MESSAGE_EXAMPLE.getY1() + y, ChartDataEnum.MESSAGE_EXAMPLE.getY2() + y, new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
        }
        return true;
    }

    /**
     * 直播流插入-新量
     *
     * @param graphics
     * @param liveList
     */
    public boolean insertLiveForNew(Graphics2D graphics, List<AdsPdNewPushByHourE> liveList) {
        if (Objects.isNull(liveList)) {
//			log.info(" 直播流插入-新量 ，数据为空");
            return false;
        }
        int cellHeight = TalentImgParams.INSTANCE.cellHeight;
        TalentTitleEnum[] talentTitleEnums = TalentTitleEnum.values();
        for (int i = 0; i < liveList.size(); i++) {
            final AdsPdNewPushByHourE data = liveList.get(i);
            int y = i * cellHeight;
            // 例子数
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1(), ChartDataEnum.LIVE_NEW_EXAMPLE.getX2(), ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
            // 重复率
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2(), ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
            // 到课数
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
            // 到课率
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

            // 结果数据
            // 转化订单数
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
            // 转化率
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
            // 到课转化率
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
            // GMV
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
            // 例子价值
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

            // 听课意愿
            // 听10分占比
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
            // 听80分占比
            drawCenterText(graphics, ChartDataEnum.LIVE_NEW_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.LIVE_NEW_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.LIVE_NEW_EXAMPLE.getY1() + y, ChartDataEnum.LIVE_NEW_EXAMPLE.getY2() + y, new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
        }
        return true;
    }

    /**
     * 日统计
     *
     * @param graphics
     */
    public void insertDaySum(Graphics2D graphics, AdsPdNewPushByHourE data) {
        if (data == null) {
//			log.info(" 日统计 ，数据为空");
            return;
        }
// 例子数
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1(), ChartDataEnum.DAY_SUM.getX2(), ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX2(), ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL / 4, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL / 4, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, ChartDataEnum.DAY_SUM.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.DAY_SUM.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.DAY_SUM.getY1(), ChartDataEnum.DAY_SUM.getY2(), new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    /**
     * 其他流量类型
     *
     * @param graphics
     */
    public void insertOther(Graphics2D graphics, AdsPdNewPushByHourE data) {
        if (data == null) {
//			log.info("其他流量类型 - 插入数据，数据为空");
            return;
        }
// 例子数
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1(), ChartDataEnum.OTHER.getX2(), ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, ChartDataEnum.OTHER.getX2(), ChartDataEnum.OTHER.getX2() + SECONDE_CELL / 4, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, ChartDataEnum.OTHER.getX2() + SECONDE_CELL / 4, ChartDataEnum.OTHER.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, ChartDataEnum.OTHER.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.OTHER.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL, ChartDataEnum.OTHER.getX2() + SECONDE_CELL, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.OTHER.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.OTHER.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.OTHER.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.OTHER.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.OTHER.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, ChartDataEnum.OTHER.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.OTHER.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.OTHER.getY1(), ChartDataEnum.OTHER.getY2(), new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    /**
     * 直播流插入-总计
     *
     * @param graphics
     */
    public void insertLiveTotal(Graphics2D graphics, AdsPdNewPushByHourE data) {
        if (data == null) {
//			log.info("直播流插入-总计, 数据为空");
            return;
        }
// 例子数
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    /**
     * 信息流插入-总计
     *
     * @param graphics
     */
    public void insertMessageTotal(Graphics2D graphics, AdsPdNewPushByHourE data) {
        if (data == null) {
//			log.info("信息流插入-总计，数据为空");
            return;
        }
// 例子数
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    /**
     * 信息流插入-老量
     *
     * @param graphics
     */
    public void insertMessageForOld(Graphics2D graphics, AdsPdNewPushByHourE data) {
        if (data == null) {
//			log.info("信息流插入-老量合计，数据为空");
            return;
        }
// 例子数
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.MESSAGE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    /**
     * 直播流插入-老量
     *
     * @param graphics
     */
    public void insertLiveForOld(Graphics2D graphics, AdsPdNewPushByHourE data) {
        if (data == null) {
//			log.info("直播流插入-老量合计，数据为空");
            return;
        }
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
// 例子数
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 2, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL / 4 * 3, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 2, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 3 + 25, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 3, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + (THIRD_CELL / 5) * 4, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX1() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getX2() + SECONDE_CELL + THIRD_CELL + FORTH_CELL / 2, ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY1(), ChartDataEnum.LIVE_OLD_TOTAL_EXAMPLE.getY2(), new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    public GrapParams generateImg(String title, List<String> hourList) {
        // 全量
        List<String> hourAllList = hourRule(hourList, true);
        // 半量
        List<String> hourPartList = hourRule(hourList, false);

        // 图片宽高比例数值设定
        // 宽
        int imageWidth = TalentTitleEnum.getImgWidth();
        // 高
        int imageHeight = TalentImgEnum.getFixationTitleEndY() + (TalentImgEnum.FIXATION_CELL_HEIGHT.getNum() * hourAllList.size());

        // 图片设定
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        // 所用参数设定
        TalentImgParams newInstance = TalentImgParams.getNewInstance();
        newInstance.setParams(imageWidth, imageHeight, hourList, hourAllList, hourPartList, title);

        // 图片轮廓渲染
        imgFacade(graphics, newInstance);

        // 回参处理
        return new GrapParams(image, graphics);

    }


    /**
     * 信息流插入-新量
     *
     * @param graphics
     * @param messageList
     */
    public boolean insertMessageOrLive(Graphics2D graphics, List<AdsPdNewPushByHourE> messageList, TalentImgParams params, int type, boolean totalFlag) {
        if (Objects.isNull(messageList)) {

//			log.info(" 信息流插入-新量 ，数据为空");
            return false;
        }
        // y
        int starY = params.thirdTitleHeight;
        int endY = starY + params.cellHeight;

        if (totalFlag) {
            starY = params.hourCirculationList.size() * params.cellHeight + params.thirdTitleHeight;
            endY = starY + params.cellHeight;
        }

        if (type == TalentSideFirstTitleEnum.LIVE.getType()) {
            starY = params.hourPartList.size() * params.cellHeight + params.thirdTitleHeight;
            endY = starY + params.cellHeight;
        }

        for (int i = 0; i < messageList.size(); i++) {
            final AdsPdNewPushByHourE data = messageList.get(i);
            int incredmentY = i * params.cellHeight;
            write(graphics, incredmentY, starY, endY, data, params);
        }
        return true;
    }

    public boolean insertOther(Graphics2D graphics,AdsPdNewPushByHourE data, TalentImgParams params, boolean totalFlag){
        // y
        int starY = params.imgHeight - params.cellHeight * 2;
        int endY = starY - params.cellHeight;
        write(graphics, 0,  starY, endY, data, params);
        return true;
    }

    public boolean insertDaySumTotal(Graphics2D graphics,AdsPdNewPushByHourE data, TalentImgParams params, boolean totalFlag){
        // y
        int starY = params.imgHeight - params.cellHeight;
        int endY = starY;
        write(graphics, 0,  starY, endY, data, params);
        return true;
    }

    private void write(Graphics2D graphics, int incredmentY, int starY, int endY, AdsPdNewPushByHourE data, TalentImgParams params) {
        int firstMinWidth = params.firstMinWidth;
        int secondMinWidth = params.secondMinWidth;
        int thirdMinWidth = params.thirdMinWidth;
        int forthMinWidth = params.forthMinWidth;
        // x
        int secondStartX = firstMinWidth * TalentTitleEnum.BASIC.getChildTitle().size();
        int thirdStarX = secondStartX + secondMinWidth * TalentTitleEnum.PROCESS.getChildTitle().size();
        int forthStarX = thirdStarX + thirdMinWidth * TalentTitleEnum.RESULT.getChildTitle().size();

        // 例子数
        drawCenterText(graphics, secondStartX, secondStartX + secondMinWidth, starY + incredmentY, endY + incredmentY, new Font(data.getExampleNum(), Font.PLAIN, FONT_DEFAULT), null);
        // 重复率
        drawCenterText(graphics, secondStartX + secondMinWidth, secondStartX + secondMinWidth * 2, starY + incredmentY, endY + incredmentY, new Font(data.getRepeatPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课数
        drawCenterText(graphics, secondStartX + secondMinWidth * 2, secondStartX + secondMinWidth * 3, starY + incredmentY, endY + incredmentY, new Font(data.getArriveCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课率
        drawCenterText(graphics, secondStartX + secondMinWidth * 3, thirdStarX, starY + incredmentY, endY + incredmentY, new Font(data.getArrivePercent(), Font.PLAIN, FONT_DEFAULT), null);

        // 结果数据
        // 转化订单数
        drawCenterText(graphics, thirdStarX, thirdStarX + thirdMinWidth, starY + incredmentY, endY + incredmentY, new Font(data.getConvertOrderCount(), Font.PLAIN, FONT_DEFAULT), null);
        // 转化率
        drawCenterText(graphics, thirdStarX + thirdMinWidth, thirdStarX + thirdMinWidth * 2, starY + incredmentY, endY + incredmentY, new Font(data.getConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // 到课转化率
        drawCenterText(graphics, thirdStarX + thirdMinWidth * 2, thirdStarX + thirdMinWidth * 3, starY + incredmentY, endY + incredmentY, new Font(data.getArriveConvertPercent(), Font.PLAIN, FONT_DEFAULT), null);
        // GMV
        drawCenterText(graphics, thirdStarX + thirdMinWidth * 3, thirdStarX + thirdMinWidth * 4, starY + incredmentY, endY + incredmentY, new Font(data.getNewGmv(), Font.PLAIN, FONT_DEFAULT), null);
        // 例子价值
        drawCenterText(graphics, thirdStarX + thirdMinWidth * 4, forthStarX, starY + incredmentY, endY + incredmentY, new Font(data.getExampleValue(), Font.PLAIN, FONT_DEFAULT), null);

        // 听课意愿
        // 听10分占比
        drawCenterText(graphics, forthStarX, forthStarX + forthMinWidth, starY + incredmentY, endY + incredmentY, new Font(data.getMoreThanTen(), Font.PLAIN, FONT_DEFAULT), null);
        // 听80分占比
        drawCenterText(graphics, forthStarX + forthMinWidth, forthStarX + forthMinWidth * 2, starY + incredmentY, endY + incredmentY, new Font(data.getMoreThanEighty(), Font.PLAIN, FONT_DEFAULT), null);
    }

    /**
     * 图表形成入口
     *
     * @param graphics {@link Graphics2D}
     * @param params   图表参数对象
     */
    private void imgFacade(Graphics2D graphics, TalentImgParams params) {
        // 1. 图表轮廓及标题渲染
        drawImgAndTitle(graphics, params);
        // 2. 侧边栏标题渲染
        drawSideTitleAndLine(graphics, params);
        // 3. 二三级标题渲染
        drawOtherTitle(graphics, params);
        // 4. 轮询时间单元格渲染
        drawTimeAndLine(graphics, params);
        // 5. 垂直线分布渲染
        drawPerpendicularLine(graphics, params);
        // 6. 标题水平线渲染
        drawAcrossLine(graphics, params);
    }


    /**
     * 图片建立
     *
     * @param image    图片buffer
     * @param filePath 路径
     */
    public void createImg(BufferedImage image, String filePath) {
        // 图片生成
        try {
            //创建文件输出流
            FileOutputStream out = new FileOutputStream(filePath);
            //以这个代替掉 JPEGCodec
            ImageIO.write(image, "png", out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 图片轮廓及主标题渲染
     *
     * @param graphics {@link Graphics2D}
     * @param params   图表参数对象
     */
    private void drawImgAndTitle(Graphics2D graphics, TalentImgParams params) {
        int imageWidth = params.imgWidth;
        int imageHeight = params.imgHeight;
        int titleEndY = params.firstTitleHeight;
        String title = params.title;
        //图片清晰
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(new Color(220, 240, 240));

        drawCenterText(graphics, 0, imageWidth, 0, titleEndY, new Font(title, Font.BOLD, FONT_DEFAULT_FIRST_TITLE), new Color(186, 206, 253), null);
        graphics.setColor(Color.black);
    }

    /**
     * 二级，三级标题
     *
     * @param graphics {@link Graphics2D}
     * @param params   图表参数对象
     */
    private void drawOtherTitle(Graphics2D graphics, TalentImgParams params) {
        // 二级
        int sStarX = 0;
        int sEndX = 0;
        int sStarY = params.firstTitleHeight;
        int sEndY = params.secondTitleHeight;
        // 三级
        int tStarX = 0;
        int tEndX = 0;
        int tStartY = params.secondTitleHeight;
        int tEndY = params.secondTitleHeight + params.cellHeight;
        // other
        TalentTitleEnum[] talentTitleEnums = TalentTitleEnum.values();
        int secondTitleCount = talentTitleEnums.length;

        // 标题插入
        for (int i = 0; i < secondTitleCount; i++) {
            TalentTitleEnum value = talentTitleEnums[i];
            int minCellWidth = value.getMinCellWidth();
            List<String> childTitle = value.getChildTitle();
            // 二级标题
            sEndX += childTitle.size() * minCellWidth;
            drawCenterText(graphics, sStarX, sEndX, sStarY, sEndY, new Font(value.getSecondTitle(), Font.PLAIN, FONT_DEFAULT), value.getColor());
            sStarX += childTitle.size() * minCellWidth;
            // 三级标题
            for (int j = 0; j < childTitle.size(); j++) {
                tEndX += minCellWidth;
                drawCenterText(graphics, tStarX, tEndX, tStartY, tEndY, new Font(childTitle.get(j), Font.PLAIN, FONT_DEFAULT), value.getColor());
                tStarX += minCellWidth;
            }
        }

    }


    /**
     * 时间及线的划分
     *
     * @param graphics {@link Graphics2D}
     * @param params   图表所需参数
     */
    private void drawTimeAndLine(Graphics2D graphics, TalentImgParams params) {
        int fixationHeight = params.thirdTitleHeight;
        int cellHeight = params.cellHeight;

        int endX = TalentTitleEnum.BASIC.getMinCellWidth() * 3;
        int imgWidth_ = params.imgWidth;
        int startX = TalentTitleEnum.BASIC.getMinCellWidth() * 2;
        // 线
        List<String> hourAllList = params.hourAllList;
        int rows = hourAllList.size();
        for (int i = 0; i <= rows; i++) {
            graphics.drawLine(startX, (i * cellHeight) + (fixationHeight), imgWidth_, (i * cellHeight) + (fixationHeight));
        }
        // 文本
        for (int it = 0; it < hourAllList.size(); it++) {
            drawCenterText(graphics, startX, endX, fixationHeight + it * cellHeight, fixationHeight + (it + 1) * cellHeight, new Font(hourAllList.get(it), Font.PLAIN, FONT_DEFAULT), null);
        }
    }


    /**
     * 竖线划分
     *
     * @param graphics {@link Graphics2D}
     * @param params   图表所需参数对象
     */
    private void drawPerpendicularLine(Graphics2D graphics, TalentImgParams params) {
        int starX = 0;
        int startY = params.secondTitleHeight;
        int imgHeight = params.imgHeight;
        for (int i = 0; i < TalentTitleEnum.values().length; i++) {
            TalentTitleEnum value = TalentTitleEnum.values()[i];
            List<String> childTitle = value.getChildTitle();
            for (int j = 0; j < childTitle.size(); j++) {
                starX += value.getMinCellWidth();
                if (j == childTitle.size() - 1) {
                    graphics.drawLine(starX, startY - params.cellHeight, starX, imgHeight);
                } else {
                    graphics.drawLine(starX, startY, starX, imgHeight);
                }
            }
        }
    }


    /**
     * 侧边标题渲染
     *
     * @param graphics {@link Graphics2D}
     * @param params   图表参数对象
     */
    private void drawSideTitleAndLine(Graphics2D graphics, TalentImgParams params) {
        TalentTitleEnum basic = TalentTitleEnum.BASIC;
        int imgWidth = params.imgWidth;
        List<String> hourPartList = params.hourPartList;
        List<String> hourCirculationList = params.hourCirculationList;
        int size = hourPartList.size();
        int cellHeight = params.cellHeight;
        int sideFixationFirstHeight = size * cellHeight;
        int titleDownStartY = params.thirdTitleHeight;
        int startY = titleDownStartY + sideFixationFirstHeight;
        int minCellWidth = basic.getMinCellWidth();
        TalentSideSecondTitleEnum[] talentSideSecondTitleEnums = TalentSideSecondTitleEnum.values();

        // 处理侧边连
        int circulSize = hourCirculationList.size();
        int sideScondeEndY = titleDownStartY + (circulSize - 1) * cellHeight;
        TalentSideFirstTitleEnum[] talentSideFirstTitleEnums = TalentSideFirstTitleEnum.values();
        for (int i = 0; i < talentSideFirstTitleEnums.length; i++) {
            int incredment = sideFixationFirstHeight * i;
            // 第二列处理
            for (int j = 0; j < talentSideSecondTitleEnums.length; j++) {
                fillBackgroudColor(graphics,
                        talentSideSecondTitleEnums[j].getColor(),
                        minCellWidth,
                        sideScondeEndY + j * cellHeight + incredment,
                        imgWidth,
                        sideScondeEndY + cellHeight + j * cellHeight + incredment);
                drawCenterText(graphics,
                        minCellWidth,
                        minCellWidth * 2,
                        sideScondeEndY + j * cellHeight + incredment,
                        sideScondeEndY + cellHeight + j * cellHeight + incredment,
                        new Font(talentSideSecondTitleEnums[j].getSideTitle(), Font.PLAIN, FONT_DEFAULT),
                        null);
                graphics.drawLine(minCellWidth, sideScondeEndY + j * cellHeight + incredment, imgWidth, sideScondeEndY + j * cellHeight + incredment);
            }
            // 第一列处理
            drawCenterText(graphics, 0, minCellWidth, titleDownStartY + incredment, startY + incredment, new Font(talentSideFirstTitleEnums[i].getSideTitle(), Font.PLAIN, FONT_DEFAULT), null);
            drawCenterText(graphics,
                    minCellWidth,
                    minCellWidth * 2,
                    titleDownStartY + incredment,
                    sideScondeEndY + incredment,
                    new Font("新量", Font.PLAIN, FONT_DEFAULT),
                    null);
            graphics.drawLine(0, startY + incredment, imgWidth, startY + incredment);
        }

        // 其他
        fillBackgroudColor(graphics,
                new Color(186, 206, 253),
                0,
                startY + sideFixationFirstHeight + cellHeight,
                imgWidth,
                startY + sideFixationFirstHeight + cellHeight * 2);
        drawCenterText(graphics, 0, minCellWidth, startY + sideFixationFirstHeight, startY + sideFixationFirstHeight + cellHeight, new Font("其他流量类型", Font.PLAIN, FONT_DEFAULT), null);
        drawCenterText(graphics, minCellWidth, minCellWidth * 2, startY + sideFixationFirstHeight, startY + sideFixationFirstHeight + cellHeight, new Font("/", Font.BOLD, FONT_DEFAULT), null);
        drawCenterText(graphics, 0, minCellWidth, startY + sideFixationFirstHeight + cellHeight, startY + sideFixationFirstHeight + cellHeight * 2, new Font("日合计", Font.PLAIN, FONT_DEFAULT), null);
        drawCenterText(graphics, minCellWidth, minCellWidth * 2, startY + sideFixationFirstHeight + cellHeight, startY + sideFixationFirstHeight + cellHeight * 2, new Font("/", Font.BOLD, FONT_DEFAULT), null);
        graphics.drawLine(0, startY + sideFixationFirstHeight + cellHeight, imgWidth, startY + sideFixationFirstHeight + cellHeight);


    }

    /**
     * 背景颜色填充
     *
     * @param graphics {@link Graphics2D}
     * @param color    {@link Color}
     * @param startX   起始x
     * @param startY   起始y
     * @param endX     末尾x
     * @param endY     末尾y
     */
    private void fillBackgroudColor(Graphics2D graphics, Color color, int startX, int startY, int endX, int endY) {
        if (color != null) {
            graphics.setColor(color);
            graphics.fillRect(startX, startY, endX - startX, endY - startY);
        }

    }

    /**
     * 时间处理
     *
     * @param hour 时间循环
     * @param flag true-全量 false-半量
     * @return
     */
    private List<String> hourRule(List<String> hour, boolean flag) {
        String lastHour = hour.get(hour.size() - 1);

        if (flag) {
            List<String> result = new ArrayList<>();
            result.addAll(hour);
            result.add(lastHour);
            result.add(lastHour);

            result.addAll(result);
            result.add(lastHour);
            result.add(lastHour);
            return result;
        } else {
            List<String> result = new ArrayList<>();
            result.addAll(hour);
            result.add(lastHour);
            result.add(lastHour);
            return result;
        }
    }

    /**
     * 相关参数
     */
    public static class TalentImgParams {
        private static final TalentImgParams INSTANCE = new TalentImgParams();
        /**
         * 首标题高度
         */
        private final int firstTitleHeight;
        /**
         * 二级标题高度
         */
        private final int secondTitleHeight;
        /**
         * 三级标题高度
         */
        private final int thirdTitleHeight;
        /**
         * 单元格宽度
         */
        private final int cellHeight;
        /**
         * 图片宽度
         */
        private int imgWidth;
        /**
         * 图片高度
         */
        private int imgHeight;
        /**
         * 推送时间列表
         */
        private List<String> hourCirculationList;
        /**
         * 信息流/直播间所需的半量时间列表
         */
        private List<String> hourPartList;
        /**
         * 图片所需的全量时间列表
         */
        private List<String> hourAllList;

        /**
         * 标题
         */
        private String title;

        private int firstMinWidth;

        private int secondMinWidth;

        private int thirdMinWidth;

        private int forthMinWidth;

        private TalentImgParams() {
            firstTitleHeight = TalentImgEnum.TITLE_HEIGHT.getNum();
            secondTitleHeight = TalentImgEnum.TITLE_HEIGHT.getNum() + TalentImgEnum.FIXATION_CELL_HEIGHT.getNum();
            thirdTitleHeight = TalentImgEnum.getFixationTitleEndY();
            cellHeight = TalentImgEnum.FIXATION_CELL_HEIGHT.getNum();
            firstMinWidth = TalentTitleEnum.BASIC.getMinCellWidth();
            secondMinWidth = TalentTitleEnum.PROCESS.getMinCellWidth();
            thirdMinWidth = TalentTitleEnum.RESULT.getMinCellWidth();
            forthMinWidth = TalentTitleEnum.COURSE.getMinCellWidth();
        }

        // 提供一个全局访问点,供外部获取单例对象
        public static TalentImgParams getNewInstance() {
            return INSTANCE;
        }

        public void setParams(int imgWidth, int imgHeight, List<String> hourCirculationList, List<String> hourAllList, List<String> hourPartList, String title) {
            this.imgWidth = imgWidth;
            this.imgHeight = imgHeight;
            this.hourCirculationList = hourCirculationList;
            this.hourAllList = hourAllList;
            this.hourPartList = hourPartList;
            this.title = title;
        }
    }
}
