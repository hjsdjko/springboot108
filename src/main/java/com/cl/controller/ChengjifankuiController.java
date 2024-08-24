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

import com.cl.entity.ChengjifankuiEntity;
import com.cl.entity.view.ChengjifankuiView;

import com.cl.service.ChengjifankuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 成绩反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@RestController
@RequestMapping("/chengjifankui")
public class ChengjifankuiController {
    @Autowired
    private ChengjifankuiService chengjifankuiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengjifankuiEntity chengjifankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			chengjifankui.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChengjifankuiEntity> ew = new EntityWrapper<ChengjifankuiEntity>();

		PageUtils page = chengjifankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjifankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChengjifankuiEntity chengjifankui, 
		HttpServletRequest request){
        EntityWrapper<ChengjifankuiEntity> ew = new EntityWrapper<ChengjifankuiEntity>();

		PageUtils page = chengjifankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjifankui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengjifankuiEntity chengjifankui){
       	EntityWrapper<ChengjifankuiEntity> ew = new EntityWrapper<ChengjifankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengjifankui, "chengjifankui")); 
        return R.ok().put("data", chengjifankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengjifankuiEntity chengjifankui){
        EntityWrapper< ChengjifankuiEntity> ew = new EntityWrapper< ChengjifankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengjifankui, "chengjifankui")); 
		ChengjifankuiView chengjifankuiView =  chengjifankuiService.selectView(ew);
		return R.ok("查询成绩反馈成功").put("data", chengjifankuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengjifankuiEntity chengjifankui = chengjifankuiService.selectById(id);
		chengjifankui = chengjifankuiService.selectView(new EntityWrapper<ChengjifankuiEntity>().eq("id", id));
        return R.ok().put("data", chengjifankui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengjifankuiEntity chengjifankui = chengjifankuiService.selectById(id);
		chengjifankui = chengjifankuiService.selectView(new EntityWrapper<ChengjifankuiEntity>().eq("id", id));
        return R.ok().put("data", chengjifankui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengjifankuiEntity chengjifankui, HttpServletRequest request){
    	chengjifankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengjifankui);
        chengjifankuiService.insert(chengjifankui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengjifankuiEntity chengjifankui, HttpServletRequest request){
    	chengjifankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengjifankui);
        chengjifankuiService.insert(chengjifankui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengjifankuiEntity chengjifankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengjifankui);
        chengjifankuiService.updateById(chengjifankui);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengjifankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
