package com.bichuang.controller.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资金报表、资金明细等交易明细数据API入口
 * 
 * @author liufei
 * @version 2018年3月22日  
 * @see AccountReportManageApi  
 * @since
 */
@RestController
@RequestMapping("/accountReportApi")
public class AccountReportManageApi
{

	@GetMapping("/test")
	public String test() {
		System.out.println("这是一个测试@@@@@@@@@@@@@@@@@@@@@@");
		return "hellow";
		
	}
}
