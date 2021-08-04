package com.qf.utils;



import java.net.URLEncoder;

/**
 * 短信API发送
 * @author JiangPengFei
 * @version $Id: javaHttpNewApiDemo, v 0.1 2019/1/23 11:42 JiangPengFei Exp $$
 */
public class SmsApiHttpSendTest {

	/**
	 * 短信发送(验证码通知，会员营销)
	 * 接口文档地址：http://www.miaodiyun.com/doc/https_sms.html
	 */
	public void execute(String tel,String res) throws Exception{

		StringBuilder sb = new StringBuilder();
		sb.append("accountSid").append("=").append(Config.ACCOUNT_SID);
		sb.append("&to").append("=").append(tel);
		sb.append("&param").append("=").append(URLEncoder.encode(res,"UTF-8"));

		sb.append("&templateid").append("=").append("241816");
//		sb.append("&template").append("=").append("饿了么】您的验证码为123456，该验证码2分钟内有效。请勿泄漏于他人。");

//		sb.append("&smsContent").append("=").append( URLEncoder.encode("【饿了么】您的验证码为123456，该验证码2分钟内有效。请勿泄漏于他人。","UTF-8"));
		String body = sb.toString() + HttpUtil.createCommonParam(Config.ACCOUNT_SID, Config.AUTH_TOKEN);
		String result = HttpUtil.post(Config.BASE_URL, body);

	}


}
