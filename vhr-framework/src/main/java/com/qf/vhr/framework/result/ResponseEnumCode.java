package com.qf.hui.common.result;

import lombok.Getter;

@Getter
public enum ResponseEnumCode {

    /**
     *
     */
    USERNAME_OR_PASSWORD_ERROR(100,"error","用户名或者密码错误"),
    /**
     *
     */
    ACCOUNT_IS_LOCKED(203,"error","用户账号被锁定"),
    /**
     *
     */

    USER_NOT_EXIST(401,"error","用户不存在"),
    /**
     *
     */
    SUCCESS(200, "success", "成功"),
    /**
     *
     */
    ERROR(400, "error", "系统繁忙!!!"),
    /**
     *
     */
    SYS_ERROR(40010, "error", "系统错误!!! 请稍后再试!!!"),

    //  ====== 用户相关========
    /**
     * 验证码过期
     */
    MEMBER_VERIFICATION_EXPIRE(40040, "verification  code  expire", "验证码已过期"),
    /**
     * 1
     */
    MEMBER_VERIFICATION_ERROR(40041, "verification  code  error", "验证码错误"),
    /**
     * 1
     */
    MEMBER_LOGIN_ERROR(40042, "login  fail", "登录失败"),
    /**
     * 邮箱被注册
     */
    REGISTER_EMAIL_EXIST(40044, "email is exist", "该邮箱已被注册!"),
    // ========= 幂等性相关的错误信息=========
    /**
     * 删除token失败
     */
    IDEMPOTENT_TOKEN_DELETE_ERROR(400010, "token is delete error", "token删除失败"),
    /**
     * 错误的token
     */
    IDEMPOTENT_TOKEN_ERROR(400011, "token is error", "token 错误"),
    /**
     * token不能为空
     */
    IDEMPOTENT_NOT_NULL_ERROR(400011, "token is null", "token 不能为空"),
    /**
     * 商品下架
     */
    ORDER_PRODUCT_OUT(40001, "order product out", "该商品已经下架"),
    /**
     * 支付相关
     */
    PAY_FAIL_ERROR(40100, "ali pay fail", "支付宝支付失败!!!"),


    // 用户相关
    UN_LOGIN(40001, "no login", "未登录"), UN_AUTH(40003, "no auth  account", "未授权"),

    /*用户未登录*/
    ACCOUNT_NOT_LOGIN(10001, "user no login", "用户未登录"), /*账号不存在或密码错误*/
    ACCOUNT_LOGIN_ERROR(10002, "user login error", "账号不存在或密码错误"), /*账号已存在*/
    ACCOUNT_IS_EXISTENT(10003, "account is existent", "账号已存在"),


    /*账号不存在*/
    ACCOUNT_NOT_EXIST(10004, "account not exist", "账号不存在!"), /*账号已禁止  请与管理员联系*/
    USER_ACCOUNT_LOCKED(10005, "user account locked", "账号被锁定, 请与管理员联系"), LOGIN_COUNT_LIMIT(10006, "account is existent", "登录失败多次，请稍后在试"), SMS_SEND_ERROR(10007, "send  code  error", "发送验证码失败"),

    SMS_CODE_ERROR(10008, "code  is  error", "验证错误"),

    /*  参数错误   */
    /*参数不为空*/
    PARAMS_NOT_IS_BLANK(20001, "params not is blank", "参数不能为空"),

    /*参数无效*/
    PARAMS_IS_INVALID(20002, "params is invalid", "无效参数"),

    /*参数类型错误*/
    PARAM_TYPE_ERROR(20003, "param type error", "参数类型错误"),

    /*参数缺失*/
    PARAM_IS_DEFICIENCY(20004, "param is deficiency", "参数缺失"),

    /*暂无权限*/
    PERMISSION_NO_ACCESS(20006, "no permissions access", "暂无权限"),

    AUTH_ERROR(20007, "auth error", "认证失败"),
    /* 业务错误 */

    /* 业务繁忙 请稍后在试 */
    BUSINESS_UNKNOW_ERROR(30001, " busy with business", "业务繁忙 请稍后在试"),

    SYSTEM_ERROR(99999, "system  error", "接口错误"),

    /* ======系统错误：40001-49999===== */
    /* 提示语 "系统繁忙，请稍后重试"*/
    SYSTEM_INNER_ERROR(40001, "system error", "系统繁忙，请稍后重试"),

    /*未知错误 请稍后在试*/
    SYSTEM_UNKNOW_ERROR(40002, "system unknow error", "未知错误 请稍后在试"),

    /*内部系统接口调用异常*/
    INNER_INVOKE_ERROR(50001, "inner invoke error", "内部系统接口调用异常"),

    /*外部系统接口调用异常*/
    OUTER_INVOKE_ERROR(50002, "outer invoke error", "外部系统接口调用异常"),

    /*该接口禁止访问*/
    NO_ACCESS_FORBIDDEN(50003, "no access forbidden", "禁止访问"),

    /*接口地址无效*/
    NO_FOUND_ERROR(50004, "no found error", "接口地址无效"),

    /* 数据错误 */
    DATA_IS_WRONG(60001, "data is wrong", "数据错误"), /* 其它业务错误信息 */
    IDEM_TOKEN_ERROR(62001, "token is miss", "token错误"),
    /**
     * token过期
     */
    IDEM_TOKEN_EXPIRE(62002, "token is expire", "token过期"),
    USER_NO_LOGIN(60001,"user isNot login ","用户未登录" );



    /**
     * 错误信息
     */
    private final String msg;
    /**
     * 状态码
     */
    private final Integer status;
    /**
     * 提示信息
     */
    private final String tip;

    ResponseEnumCode(Integer status, String msg, String tip) {
        this.msg = msg;
        this.status = status;
        this.tip = tip;
    }

}
