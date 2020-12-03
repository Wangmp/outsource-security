package com.wmp.cn.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 异常码枚举
 *
 * @author jwb
 */
public enum ExceptionCodes {

    ERROR(-1, "系统错误"),
    SUCCESS(0, "成功"),
    PARAM_ERROR(3, "参数异常"),
    CHECK_ERROR(4, "自定义校验异常"),

    // 100-999 系统错误码
    SYSTEM_ERROR(100, "系统模块异常"),
    USER_ERROR(101, "账号不存在"),
    USER_INVALID(102, "账号被禁用"),
    USER_DELETED(103, "账号被删除"),
    PASSWORD_ERROR(104, "密码错误"),
    NAME_ERROR(106, "名称已存在"),
    GENERATION_TIME(107, "生成时间结合失败"),

    AUDITED(180, "数据已审核"),

    CODE_NULL(197, "验证码为空"),
    CODE_EXPIRE(198, "验证码失效"),
    CODE_ERROR(199, "验证码错误"),

    UNAUTHORIZED(401, "授权失败（无效token/登录过期/账号在别处登录）"),
    FORBIDDEN(403, "没有分配权限，请联系管理员"),
    SERVICE_NOT_FOUND(404, "服务未找到或路径不存在"),

    // 1000-1499 订单系统误码
    ORDER_ERROR(1000, "订单系统模块异常"),
    ORDER_MERGE_STATUS_ERROR(1001, "订单已进入生产以及之后环节不能合并"),
    ORDER_MERGE_CO_ERROR(1002, "客户不同不能合并"),
    ORDER_MERGE_CHECK_ERROR(1003, "订单没有审核通过不能合并"),
    ORDER_SPLIT_CHECK_ERROR(1004, "订单没有审核通过不能拆分"),
    ORDER_SPLIT_STATUS_ERROR(1005, "订单已进入生产以及之后环节不能拆分"),
    ORDER_SPLIT_ERROR(1006, "订单已拆分，请取消此单之前拆分操作，才可以拆分"),
    ORDER_SPLIT_ERROR2(1007, "订单已合并，请取消此单之前合并操作，才可以拆分"),
    ORDER_MERGE_ERROR(1008, "订单已合并，请取消此单之前合并操作，才可以合并"),
    ORDER_MERGE_ERROR2(1009, "订单已拆分，请取消此单之前拆分操作，才可以合并"),
    ORDER_CANCEL_SPLIT_ERROR(1010, "不是被拆分的单不能操作取消拆分"),
    ORDER_CANCEL_SPLIT_ERROR2(1011, "子订单有被合并的不能操作取消拆分"),
    ORDER_CANCEL_MERGE_ERROR(1012, "不是合并的单不能操作取消合并"),

    ORDER_CHECK_STATUS(1100, "订单已审核通过不能修改"),

    // 1500-2499 基础数据（设备管理，模具管理，产品工艺）
    PRODUCT_COMMON_ERROR(1500, "物料模块异常"),
    CATEGORY_NOT_FOUND(1501, "物料操作,物料分类不存在"),
    PARENT_NOT_FOUND(1502, "父级BOM编码不存在"),
    MATERIAL_CODE_NOT_FOUND(1502, "物料编码不存在"),
    BOM_CODE_NOT_FOUND(1503, "BOM编码不存在"),
    PRODUCT_LINE_NOT_FOUND(1504, "产线编码不存在"),
    UNIT_CODE_NOT_FOUND(1505, "计量单位编号不存在"),
    FILE_TYPE_NOT_FOUND(1506, "文件分类不存在"),
    EXCEL_EMPTY(1507, "表格无数据"),
    MATERIAL_CATEGORY_PARENT_ID_ERROR(1508, "物料分类的父ID不存在"),
    PARAM_EMPTY(1509, "入参为空"),
    BOM_EROOR(1510, "BOM未配置正确"),
    CAPACITY_EMPTY(1511, "未配置产线路径"),


    DEVICE_TYPE_REPEAT(1600, "同一级下设备类型名称重复"),
    DEVICE_TYPE_CHILD_NOTNULL(1601, "该设备类型下含有子类型，删除失败"),
    DEVICE_TYPE_NOT_ALLOWED(1602, "不允许修改父级类型"),

    DFAULT_CLASS_REPEAT(1603, "同一级下设备故障分类名称重复"),
    DFAULT_CLASS_CHILD_NOTNULL(1604, "该设备故障分类下含有子分类，删除失败"),
    DFAULT_CLASS_NOT_ALLOWED(1605, "不允许修改父级类型"),

    QUALITY_DOCUMENT_REPEAT(1606, "同一级下类型名称重复"),
    QUALITY_DOCUMENT_CHILD_NOTNULL(1607, "该类型下含有子类型，删除失败"),



    //2000-2499 产线

    PRODUCTION_API_SELECT_ERROR(20001,"调用api查询产线接口失败"),


    // 2500-2999 仓库系统
    WMS_ERROR(2999,"仓储模块调用失败"),
    WAREHOUSE_LINE_TYPE_CHILD_NOTNULL(2500, "该节点类型下含有子类型，删除失败"),
    WMS_WAREHOUSE_CODE_ERROR(2501, "仓库编码不能重复"),
    WMS_WAREHOUSE_DETELE_ERROR(2502, "仓库数据为空，删除失败"),
    WMS_WAREHOUSE_DETELE_ERROR_AREA(2503, "该仓库下存在这库区信息，删除失败"),
    WMS_WAREHOUSE_CODE_UPDATE_ERROR(2503, "仓库编码不能修改，更新失败"),

    WMS_AREA_CODE_ERROR(2511, "库区编码不能重复"),
    WMS_AREA_STATUS_ERROR(2512, "库区状态和仓库状态不一致，添加库区失败"),
    WMS_AREA_CODE_UPDATE_ERROR(2513, "库区编码不能修改，更新失败"),
    WMS_AREA_SHELF_UPDATE_ERROR(2525, "该库区下有货架或库位存在，更新失败"),
    WMS_AREA_SHELF_DELETE_ERROR(2526, "该库区下有货架或库位存在，删除失败"),
    WMS_AREA_SUB_WAREHOUSE_CODE_NULL_ERROR(2527, "所属仓库编码不能为空，添加库区失败"),
    WMS_AREA_SUB_WAREHOUSE_CODE_UPDATE_ERROR(2528, "该库位下存在货架或者库位，所属仓库编不能修改"),

    WMS_SHELF_CODE_ERROE(2521, "货架编码不能重复"),
    WMS_SHELF_CODE_UPDATE_ERROR(2522, "货架编码不能修改，更新失败"),
    WMS_SHELF_POSITION_STATUS_UPDATE_ERROR(2523, "更新库位状态失败，货架状态不进行更新"),
    WMS_SHELF_STATUS_ERROR(2524, "货架状态和库区状态不一致，添加货架失败"),
    WMS_SHELF_DELETE_ERROR(2525, "货架下有库位存在，删除失败"),
    WMS_SHELF_POSITION_LEVEL_ERROR(2526, "货架下有库位存在，无法更改层数和每层库位数"),
    WMS_SHELF_POSITION_AREA_ERROR(2527, "货架下有库位存在，无法更改所属库区"),


    WMS_POSITION_CODE_UPDATE_ERROR(2531, "库位编码不能修改,更新失败"),
    WMS_POSITION_DELETE_INVENTORY_ERROR(2532, "库位上有原料存储，删除失败"),
    WMS_POSITION_ADD_AREA_CODE_ERROR(2533, "库区编码为空，添加地面库位失败"),
    WMS_POSITION_ADD_SHELF_CODE_ERROR(2534, "货架编码为空，添加库位失败"),
    WMS_POSITION_UPDATE_INVENTORY_ERROR(2535, "库位上有原料存储，不能更改所属库区或者货架编码"),


    WMS_STORAEG_TYPE_ERROR(2541,"暂不支持的入库类型，创建入库单失败"),
    WMS_STORAEG_TYPE_NULL_ERROR(2541,"入库类型不能为空，创建入库单失败"),
    WMS_STORAEG_MATERIL_ERROR(2547,"调取远程物料服务失败，创建入库单失败"),
    WMS_STORAEG_IN_WAREHOUSE_TYPE_ERROR(2542,"原料仓库类型和入库的仓库类型不一致，创建入库单失败"),
    WMS_STORAEG_QTY_ERROR(2545,"该入库单已上架，数量不能小于之前上架数量,入库单创建失败"),
    WMS_STORAEG_IN_WAREHOOUSE_CODE_ERROR(2546,"该物料选择的仓库和之前上架的仓库不一致,入库单创建失败"),

    WMS_STORAEG_IN_DTL_QTY_ERROR(2547,"原材数量发生了改变,入库单上架失败"),


    WMS_INVENTORY_QUALITY_ERROR(2551,"上架物料质量类型跟库位类型不一致,库存上架失败"),
    WMS_INVENTORY_STATUS_ERROR(2552,"暂不支持的库存状态,库存上架失败"),
    WMS_MIXED_TYPE_ERROR(2553,"暂不支持的存放类型,库存上架失败"),
    WMS_MIXED_ONE_ERROR(2554,"该库位是一品一位，不能存放多种物料,库存上架失败"),
    WMS_MIXED_SN_MULTI_ERROR(2555,"该库位是批次混放，物料不混放，不能存放多个批次,库存上架失败"),
    WMS_POSITION_FORBID_ERROR(2556,"该库位禁用,库存上架失败"),
    WMS_POSITION_FORBID_STORE_ERROR(2557,"该库位禁存,库存上架失败"),


    WMS_STORAGE_OUT_QTY_ERROR(2561,"可用库存不足，创建出库单失败"),
    WMS_STORAGE_INVENTORY_QTY_ERROR(2562,"库存数量已改变，创建出库单失败"),


    // 3000-3499 计划排产

    // 3500-3999 生产系统
    EMPLOYEES_UPDATE_ERROR(3501,"批量更新员工工位异常!"),
    PRODUCTION_ADD_ERROR(3502,"批量添加生产计划失败"),
    PICKING_ADD_ERROR(3503,"生成领料单时物料为空,请核对!"),
    PICKING_STOCK_ERROR(3504,"库存为空!"),
    PICKING_ERROR(3505,"添加领料单失败!"),
    PICKING_NULL_ERROR(3506,"查询为空!无法删除"),
    PICKING_LIST_ERROR(3507,"删除领料单失败!"),
    PICKING_DELETE_ERROR(3508,"删除领料单详情失败!"),
    PICKING_WMS_ADD(3509,"通知仓库生成领料到失败!"),
    PICKING_SELECT_NULL(3510,"查询为空,请核对!"),


    // 4000-4499 包装系统
    SCHEDULE_ERROR(4001,"排班计划异常！"),
    PLAN_ERROR(4002,"排产计划异常！"),
    BOM_ERROR(4003,"BOM清单生成异常！"),
    NONE_PLAN(4004,"未查询到工单信息！"),

    // 4500-4999 采购系统
    PURCHASE_ERROR(4500, "采购订单模块异常"),
    NONE_MODIFY(4501, "已关闭/作废的采购订单不能修改"),
    NONE_CANCEL(4502, "已有到货信息的采购订单不能取消"),
    MATERIAL_EXIST(4503, "物料价格信息已存在"),
    MATERIAL_UPDATE_FAILED(4504, "物料价格更新失败"),
    MATERIAL_RELATION(4505, "有关联的物料信息存在，不能删除"),
    SUPPLIER_EXIST(4506, "供应商已存在"),
    NONE_MATERIAL(4507, "物料信息为空"),

    // 5000-5499 质量管理系统

    // 5500-5999 实验室管理系统


    // 6000-6499 品控
    INSPECTION_TASK_ERROR(6000, "添加巡检质检单异常"),
    INSPECTION_TASK_DETAIL_ERROR(6001, "添加巡检质检单子模块异常"),
    INSPECTION_TASK_NULL(6002, "巡检质检单为空"),
    INSPECTION_TASK_DELETE_ERROR(6003, "删除巡检质检单异常"),
    INSPECTION_TASK_DETAIL_DELETE_ERROR(6004, "删除巡检质检单子模块异常"),
    IMG_ERROR(6005, "图片上传失败"),
    EXECUTION_ADD(6006, "更新质检执行管理记录失败"),
    EXECUTION_SAMPLING(6007, "已存在取样记录,待送检"),
    UPDATE_TASK_ERROR(6008, "报告修订失败,请核对"),
    ADD_WORK_ORDER(6009, "添加来料质检失败"),
    ADD_REVIEW(6010, "批量添加部门评审失败!"),
    ADD_DEPARTMENT_NOTICE(6011, "修改不合格品状态失败!")
    ;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回码说明
     */
    private String message;

    ExceptionCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code获取对应的ExceptionCode
     *
     * @param code 错误码
     */
    public static ExceptionCodes getExceptionCodes(int code) {
        if (code == 0) {
            throw new NullPointerException("响应编码为空");
        }

        for (ExceptionCodes e : ExceptionCodes.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("未能找到匹配的ExceptionCodes:" + code);
    }

    public static List getAllCodes() {
        List<Map> list = new ArrayList<>();
        for (ExceptionCodes commonCode : ExceptionCodes.values()) {
            Map map = new HashMap();
            map.put("code", commonCode.getCode());
            map.put("message", commonCode.getMessage());
            list.add(map);
        }
        return list;
    }

    /**
     * 获取响应编码
     *
     * @return
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 获取编码对应消息
     *
     * @return
     */
    public String getMessage() {
        return this.message;
    }

}