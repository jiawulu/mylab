package cn.easywork

/**
 * 产品信息库
 * @author admin
 *
 */
class Cpxxk {

    static constraints = {
    }
	
	String productId  //产品货号
	String desc //产品描述
	double innerQty  //内盒装箱率
	double cartonQty //外箱装箱率
	String packingInfo  //包装信息
	String innerSize    //内盒尺寸
	String cartonSize    //外箱尺寸   lXwXh单位CM
	double fcl20    //装柜量
	double fcl40
	double hq40
	double price    //单价
	String pict     //产品图片
	
	
}
