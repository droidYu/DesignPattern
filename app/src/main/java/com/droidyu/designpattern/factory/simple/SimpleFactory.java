package com.droidyu.designpattern.factory.simple;

/**
 * 简单工厂模式
 */
public class SimpleFactory {
    public static void main(String[] args) {
        PhoneFactory.createPhone("oppo").start();
        PhoneFactory.createPhone("vivo").start();
        PhoneFactory.createPhone("xiaomi").start();

        AutoPhoneFactory.createPhone(OppoPhone.class).start();
        AutoPhoneFactory.createPhone(VivoPhone.class).start();
        AutoPhoneFactory.createPhone(XiaomiPhone.class).start();
    }
}

abstract class Phone{
    public abstract void start();
}

class OppoPhone extends Phone {
    @Override
    public void start() {
        System.out.println("OPPO start");
    }
}

class VivoPhone extends Phone {
    @Override
    public void start() {
        System.out.println("VIVO start");
    }
}
class XiaomiPhone extends Phone {
    @Override
    public void start() {
        System.out.println("XiaoMi start");
    }
}

class PhoneFactory{
    public static Phone createPhone(String type) {
        Phone phone = null;
        switch (type) {
            case "oppo":
                phone = new OppoPhone();
                break;
            case "vivo":
                phone = new VivoPhone();
                break;
            case "xiaomi":
                phone = new XiaomiPhone();
                break;
        }
        return phone;
    }
}

class AutoPhoneFactory {
    public static  <T extends Phone> T createPhone(Class<T> clazz) {
        Phone phone = null;
        try {
            phone = (Phone) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) phone;
    }
}