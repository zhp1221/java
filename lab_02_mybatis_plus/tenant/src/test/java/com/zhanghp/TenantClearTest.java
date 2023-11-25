package com.zhanghp;

import com.zhanghp.config.tenant.TenantContextHolder;
import com.zhanghp.service.DemoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @since 2023/11/21 20:45
 */
public class TenantClearTest extends AppTest {

	@Resource
	private DemoService demoService;

	@BeforeAll
	public static void setTenantId(){
		TenantContextHolder.setTenantId(1L);
	}

	@Test
	public void add() {
		// 有租户查询
		demoService.getAllByTenantClear();
		// 无租户查询
		demoService.getAllByTenantClear();
		// globalFlag:true ->  无租户标志查询
		// globalFlag:false -> 有租户标志查询
		demoService.getAllByTenantClear();
	}

}
