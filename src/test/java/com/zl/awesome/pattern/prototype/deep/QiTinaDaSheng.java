package com.zl.awesome.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @author: netposa
 * @Date: 2020/12/3 15:04
 * @Description:
 */
public class QiTinaDaSheng extends Monkey implements Cloneable, Serializable {
    public JinGuBang jinGuBang;
    public QiTinaDaSheng(){
        //初始化
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    //克隆方法，采用的是深拷贝，
    //可能会出现单例b被破坏的问题
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone(){
        try {
            //内存中完成操作，对象读写，是通过字节码直接操作
            //序列化操作类似
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            //完整的新的对象
            QiTinaDaSheng qiTinaDaSheng = (QiTinaDaSheng) objectInputStream.readObject();
            qiTinaDaSheng.birthday = new Date();
            return qiTinaDaSheng;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    public QiTinaDaSheng shallowClone(QiTinaDaSheng target){
        QiTinaDaSheng qiTianDaSheng = new QiTinaDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.height;

        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.birthday = new Date();
        return qiTianDaSheng;
    }
}
