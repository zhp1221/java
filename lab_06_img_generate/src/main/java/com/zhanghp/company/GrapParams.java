package com.zhanghp.company;

import com.alibaba.fastjson.JSONObject;
import com.zhanghp.company.entity.AdsPdNewPushByHourE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author zhanghp
 * @date 2023/7/17 20:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrapParams {
    BufferedImage image;
    Graphics2D graphics;
}
