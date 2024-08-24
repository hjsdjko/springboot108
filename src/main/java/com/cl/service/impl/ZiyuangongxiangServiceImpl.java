package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZiyuangongxiangDao;
import com.cl.entity.ZiyuangongxiangEntity;
import com.cl.service.ZiyuangongxiangService;
import com.cl.entity.view.ZiyuangongxiangView;

@Service("ziyuangongxiangService")
public class ZiyuangongxiangServiceImpl extends ServiceImpl<ZiyuangongxiangDao, ZiyuangongxiangEntity> implements ZiyuangongxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiyuangongxiangEntity> page = this.selectPage(
                new Query<ZiyuangongxiangEntity>(params).getPage(),
                new EntityWrapper<ZiyuangongxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiyuangongxiangEntity> wrapper) {
		  Page<ZiyuangongxiangView> page =new Query<ZiyuangongxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZiyuangongxiangView> selectListView(Wrapper<ZiyuangongxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiyuangongxiangView selectView(Wrapper<ZiyuangongxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
