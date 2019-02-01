# ObjectGlide
simple glide util for object


简单的Glide的使用,传入定义Object对象即可申请图片.
Object对象最好带有ID,用于判断例如列表中的不同项.
ObjectCoverUtil.java中重写get方法,图片最终是从这个获取,可以不用返回string,直接返回bitmap,url也可,
但需要另外写get方法.
