package cn.e3mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper mapper;
	@Override
	public TbItem getItemByid(long itemId) {
		TbItem item = mapper.selectByPrimaryKey(itemId);
		
		return item;
	}

}
