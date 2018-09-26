package com.bichuang.vo.account;

import java.io.Serializable;

/**
 * 通联云账户请求报文对象定义
 *    如：http://192.168.1.110/srv/soa?sysid=128984721&sign=DA944624C718CAA806A5E5555D78ED9B&timestamp= 2010-03-01 12:12:12&v=1.0&req={“service”:” AmsService”, “method”:” queryAccount”, “param” : {“userId” : “USJWLS27WF9SA”}}
 * @param <T>
 */
public class YunAccountReuqest<T>  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**分配的系统编号***/
    private String sysId;
    /**签名***/
    private String sign;
    /**请求时间戳***/
    private String timestamp;
    /**接口版本(现为1.0)***/
    private String version;

    /***服务请求的对象,要转换成json对象 */
    private YunAccountSerivceDesc<T>  req;

    public YunAccountSerivceDesc<T> getReq() {
        return req;
    }

    public void setReq(YunAccountSerivceDesc<T> req) {
        this.req = req;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
