package cn.e3mall.service;

import cn.e3mall.page.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem getItemByid(long itemId);
	
	EasyUIDataGridResult getPageExemple(int page,int pageSize);
}
