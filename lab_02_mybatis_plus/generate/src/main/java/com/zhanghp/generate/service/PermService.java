package com.zhanghp.generate.service;

import com.zhanghp.generate.dao.entity.Perm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanghp.generate.model.vo.PermVO;
import com.zhanghp.generate.model.ro.PermRO;
import com.zhanghp.generate.model.qo.PermQO;
import java.util.*;

/**
 * <p>
 * 功能权限表 服务类
 * </p>
 *
 * @author zhanghp
 * @since 2022-07-29
 */
public interface PermService extends IService<Perm> {
    boolean create(PermRO ro);

    boolean delete(Integer id);

    boolean update(PermRO ro);

    PermVO getById(Integer id);

    List<PermVO> findList(PermQO qo);

    List<PermVO> findPage(PermQO qo);
}
