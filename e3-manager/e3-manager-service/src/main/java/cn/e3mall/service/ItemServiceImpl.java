package cn.e3mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.page.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper mapper;
	@Override
	public TbItem getItemByid(long itemId) {
		TbItem item = mapper.selectByPrimaryKey(itemId);
		
		return item;
	}
	@Override
	public EasyUIDataGridResult getPageExemple(int page, int pageSize) {
//		设置当前页数和每页显示条数
		PageHelper.startPage(page, pageSize);
//		设置查询条件并执行查询语句
		TbItemExample example = new TbItemExample();
		List<TbItem> list = mapper.selectByExample(example);
//		在查询结果中取分页
		PageInfo info=new PageInfo<>(list);
//		通过pagebeen封装total和rows数据并返回
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(info.getTotal());
		
		return result;
	}

}
