package com.zl.awesome.pattern.prototype.deep;

/**
 * @author: netposa
 * @Date: 2020/12/3 15:19
 * @Description:
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        QiTinaDaSheng qiTinaDaSheng = new QiTinaDaSheng();
        try {
            QiTinaDaSheng smallMonkry = (QiTinaDaSheng) qiTinaDaSheng.clone();
            System.out.println("深克隆："+(qiTinaDaSheng.jinGuBang == smallMonkry.jinGuBang));
        }catch (Exception e){
            e.printStackTrace();
        }

        QiTinaDaSheng q = new QiTinaDaSheng();
        QiTinaDaSheng n = q.shallowClone(q);
        System.out.println("深克隆："+(q.jinGuBang==n.jinGuBang));
    }
}
