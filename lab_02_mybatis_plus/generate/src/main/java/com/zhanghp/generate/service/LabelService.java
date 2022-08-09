package com.zhanghp.generate.service;

import com.zhanghp.generate.dao.entity.Label;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanghp.generate.model.vo.LabelVO;
import com.zhanghp.generate.model.ro.LabelRO;
import com.zhanghp.generate.model.qo.LabelQO;
import java.util.*;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author zhanghp
 * @since 2022-08-09
 */
public interface LabelService extends IService<Label> {
    boolean create(LabelRO ro);

    boolean delete(Long id);

    boolean update(LabelRO ro);

    LabelVO getById(Long id);

    List<LabelVO> findList(LabelQO qo);

    List<LabelVO> findPage(LabelQO qo);
}
