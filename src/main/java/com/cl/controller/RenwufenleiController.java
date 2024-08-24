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

import com.cl.entity.RenwufenleiEntity;
import com.cl.entity.view.RenwufenleiView;

import com.cl.service.RenwufenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 任务分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@RestController
@RequestMapping("/renwufenlei")
public class RenwufenleiController {
    @Autowired
    private RenwufenleiService renwufenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenwufenleiEntity renwufenlei,
		HttpServletRequest request){
        EntityWrapper<RenwufenleiEntity> ew = new EntityWrapper<RenwufenleiEntity>();

		PageUtils page = renwufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwufenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenwufenleiEntity renwufenlei, 
		HttpServletRequest request){
        EntityWrapper<RenwufenleiEntity> ew = new EntityWrapper<RenwufenleiEntity>();

		PageUtils page = renwufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwufenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenwufenleiEntity renwufenlei){
       	EntityWrapper<RenwufenleiEntity> ew = new EntityWrapper<RenwufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renwufenlei, "renwufenlei")); 
        return R.ok().put("data", renwufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenwufenleiEntity renwufenlei){
        EntityWrapper< RenwufenleiEntity> ew = new EntityWrapper< RenwufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renwufenlei, "renwufenlei")); 
		RenwufenleiView renwufenleiView =  renwufenleiService.selectView(ew);
		return R.ok("查询任务分类成功").put("data", renwufenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenwufenleiEntity renwufenlei = renwufenleiService.selectById(id);
		renwufenlei = renwufenleiService.selectView(new EntityWrapper<RenwufenleiEntity>().eq("id", id));
        return R.ok().put("data", renwufenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenwufenleiEntity renwufenlei = renwufenleiService.selectById(id);
		renwufenlei = renwufenleiService.selectView(new EntityWrapper<RenwufenleiEntity>().eq("id", id));
        return R.ok().put("data", renwufenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenwufenleiEntity renwufenlei, HttpServletRequest request){
    	renwufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwufenlei);
        renwufenleiService.insert(renwufenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenwufenleiEntity renwufenlei, HttpServletRequest request){
    	renwufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwufenlei);
        renwufenleiService.insert(renwufenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenwufenleiEntity renwufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renwufenlei);
        renwufenleiService.updateById(renwufenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renwufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
