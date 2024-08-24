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


import com.cl.dao.ShixunrenwuDao;
import com.cl.entity.ShixunrenwuEntity;
import com.cl.service.ShixunrenwuService;
import com.cl.entity.view.ShixunrenwuView;

@Service("shixunrenwuService")
public class ShixunrenwuServiceImpl extends ServiceImpl<ShixunrenwuDao, ShixunrenwuEntity> implements ShixunrenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShixunrenwuEntity> page = this.selectPage(
                new Query<ShixunrenwuEntity>(params).getPage(),
                new EntityWrapper<ShixunrenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShixunrenwuEntity> wrapper) {
		  Page<ShixunrenwuView> page =new Query<ShixunrenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShixunrenwuView> selectListView(Wrapper<ShixunrenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShixunrenwuView selectView(Wrapper<ShixunrenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
