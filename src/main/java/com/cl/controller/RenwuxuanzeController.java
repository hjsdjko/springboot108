package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.RenwuxuanzeEntity;
import com.cl.entity.view.RenwuxuanzeView;

import com.cl.service.RenwuxuanzeService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 任务选择
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@RestController
@RequestMapping("/renwuxuanze")
public class RenwuxuanzeController {
    @Autowired
    private RenwuxuanzeService renwuxuanzeService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenwuxuanzeEntity renwuxuanze,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			renwuxuanze.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenwuxuanzeEntity> ew = new EntityWrapper<RenwuxuanzeEntity>();

		PageUtils page = renwuxuanzeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwuxuanze), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenwuxuanzeEntity renwuxuanze, 
		HttpServletRequest request){
        EntityWrapper<RenwuxuanzeEntity> ew = new EntityWrapper<RenwuxuanzeEntity>();

		PageUtils page = renwuxuanzeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwuxuanze), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenwuxuanzeEntity renwuxuanze){
       	EntityWrapper<RenwuxuanzeEntity> ew = new EntityWrapper<RenwuxuanzeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renwuxuanze, "renwuxuanze")); 
        return R.ok().put("data", renwuxuanzeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenwuxuanzeEntity renwuxuanze){
        EntityWrapper< RenwuxuanzeEntity> ew = new EntityWrapper< RenwuxuanzeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renwuxuanze, "renwuxuanze")); 
		RenwuxuanzeView renwuxuanzeView =  renwuxuanzeService.selectView(ew);
		return R.ok("查询任务选择成功").put("data", renwuxuanzeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenwuxuanzeEntity renwuxuanze = renwuxuanzeService.selectById(id);
		renwuxuanze = renwuxuanzeService.selectView(new EntityWrapper<RenwuxuanzeEntity>().eq("id", id));
        return R.ok().put("data", renwuxuanze);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenwuxuanzeEntity renwuxuanze = renwuxuanzeService.selectById(id);
		renwuxuanze = renwuxuanzeService.selectView(new EntityWrapper<RenwuxuanzeEntity>().eq("id", id));
        return R.ok().put("data", renwuxuanze);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenwuxuanzeEntity renwuxuanze, HttpServletRequest request){
    	renwuxuanze.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwuxuanze);
        renwuxuanzeService.insert(renwuxuanze);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenwuxuanzeEntity renwuxuanze, HttpServletRequest request){
    	renwuxuanze.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwuxuanze);
        renwuxuanzeService.insert(renwuxuanze);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenwuxuanzeEntity renwuxuanze, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renwuxuanze);
        renwuxuanzeService.updateById(renwuxuanze);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renwuxuanzeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
