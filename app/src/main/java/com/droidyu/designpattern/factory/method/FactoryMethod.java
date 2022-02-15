package com.droidyu.designpattern.factory.method;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {
        PhoneFactory factory = new RealPhoneFactory();

        OppoPhone oppoPhone = factory.createPhone(OppoPhone.class);
        oppoPhone.start();

        VivoPhone vivoPhone = factory.createPhone(VivoPhone.class);
        vivoPhone.start();

        XiaomiPhone xiaomiPhone = factory.createPhone(XiaomiPhone.class);
        xiaomiPhone.start();

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

abstract class PhoneFactory{
    public abstract <T extends Phone> T createPhone(Class<T> clz);
}

class RealPhoneFactory extends PhoneFactory {
    @Override
    public <T extends Phone> T createPhone(Class<T> clz) {
        Phone phone = null;
        String className = clz.getName();
        try {
            phone = (Phone) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) phone;
    }
}