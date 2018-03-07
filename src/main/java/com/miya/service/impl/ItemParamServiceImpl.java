package com.miya.service.impl;


import com.miya.dto.RespObject;
import com.miya.dto.ResponseModal;
import com.miya.entity.ItemParam;
import com.miya.entity.dao.ItemParamDao;
import com.miya.service.ItemParamService;
import com.springboot.ping.mybatis.extend.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 商品规格参数模板管理
 */
@Service
public class ItemParamServiceImpl extends BaseCURDService<ItemParam,ItemParamDao> implements ItemParamService {

	@Autowired
	private ItemParamDao itemParamDao;
	
	@Override
	public RespObject<ItemParam> getItemParamByCid(long cid) {
		//判断是否查询到结果
		return new RespObject(ResponseModal.success(),null);

	}

	@Override
	public RespObject<ItemParam>  insertItemParam(ItemParam itemParam) {
		//补全pojo
		itemParam.setCreate_time(new Date());
		itemParam.setUpdate_time(new Date());
		//插入到规格参数模板表
		itemParamDao.insert(itemParam);
		return new RespObject(ResponseModal.success(),null);


	}

}
