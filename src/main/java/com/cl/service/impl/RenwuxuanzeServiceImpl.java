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


import com.cl.dao.RenwuxuanzeDao;
import com.cl.entity.RenwuxuanzeEntity;
import com.cl.service.RenwuxuanzeService;
import com.cl.entity.view.RenwuxuanzeView;

@Service("renwuxuanzeService")
public class RenwuxuanzeServiceImpl extends ServiceImpl<RenwuxuanzeDao, RenwuxuanzeEntity> implements RenwuxuanzeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenwuxuanzeEntity> page = this.selectPage(
                new Query<RenwuxuanzeEntity>(params).getPage(),
                new EntityWrapper<RenwuxuanzeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenwuxuanzeEntity> wrapper) {
		  Page<RenwuxuanzeView> page =new Query<RenwuxuanzeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenwuxuanzeView> selectListView(Wrapper<RenwuxuanzeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenwuxuanzeView selectView(Wrapper<RenwuxuanzeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
