package com.droidyu.designpattern.factory.method;

import java.util.HashMap;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {

        Phone oppoPhone = PhoneFactoryFactory.getFactory(PhoneType.oppo).createPhone();
        oppoPhone.start();

        Phone vivoPhone = PhoneFactoryFactory.getFactory(PhoneType.vivo).createPhone();
        vivoPhone.start();

        Phone xiaomiPhone = PhoneFactoryFactory.getFactory(PhoneType.xiaomi).createPhone();
        xiaomiPhone.start();
    }
}

enum PhoneType {
    oppo, vivo, xiaomi
}

abstract class Phone {
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

abstract class PhoneFactory {
    public abstract Phone createPhone();
}

class OppoFactory extends PhoneFactory {
    @Override
    public Phone createPhone() {
        return new OppoPhone();
    }
}

class VivoFactory extends PhoneFactory {
    @Override
    public Phone createPhone() {
        return new VivoPhone();
    }
}

class XiaomiFactory extends PhoneFactory {
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }
}

class PhoneFactoryFactory {
    static HashMap<PhoneType, PhoneFactory> map = new HashMap<>();

    static {
        map.put(PhoneType.oppo, new OppoFactory());
        map.put(PhoneType.vivo, new VivoFactory());
        map.put(PhoneType.xiaomi, new XiaomiFactory());
    }

    public static PhoneFactory getFactory(PhoneType type) {
        return map.get(type);
    }
}



