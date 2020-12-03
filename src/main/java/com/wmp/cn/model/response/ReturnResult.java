package com.wmp.cn.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ReturnResult
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/6/30
 * @Version V1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnResult<T> {


    /**
     *status状态值：代表本次请求response的状态结果
     */
    private Integer status;

    /**
     * response描述：对本次状态码的描述
     */
    private String desc;

    /**
     * data数据：本次返回的数据
     */
    private T data;

    /**
     * 成功，创建Result:没Data数据
     * @return
     */
    public static ReturnResult suc(){
        ReturnResult result = new ReturnResult();
        result.setResultCode(ReturnResultCode.SUCCESS);
        return  result;
    }

    /**
     * 成功，创建Result:返回Data数据
     * @return
     */
    public static ReturnResult suc(Object data){
        ReturnResult result = new ReturnResult();
        result.setResultCode(ReturnResultCode.SUCCESS);
        result.setData(data);
        return  result;
    }

    /**
     * 失败，指定status  desc
     * @return
     */
    public static ReturnResult fail(Integer status, String desc){
        ReturnResult result = new ReturnResult();
        result.setStatus(status);
        result.setDesc(desc);
        return  result;
    }


    /**
     * 失败，指定ResultCode枚举
     * @return
     */
    public static ReturnResult fail(ReturnResultCode resultCode){
        ReturnResult result = new ReturnResult();
        result.setResultCode(resultCode);
        return  result;
    }

    /**
     * 把ResultCode枚举转换为ResResult
     */
    private void setResultCode(ReturnResultCode code){
        this.status = code.code();
        this.desc = code.message();
    }

}
