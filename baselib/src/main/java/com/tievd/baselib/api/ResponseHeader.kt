package com.tievd.baselib.api


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class ResponseHeader(
    /** 请求流⽔号，回带 */
    var requestNo: String="",
    /** ocr识别状态，success：成功，failed：失败 */
    var execStatus: String="",
    /** 返回信息 */
    var retCode: String="",
    /** 反馈信息 */
    var retMsg: String="",
    /** 请求⽅⾃定义应⽤名称 */
    var requestAppName: String=""
) {
}