package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        SocketAdapter adapter = new SocketAdapterImpl();
        Volt v = adapter.get120Volt();

        SocketAdapter adapter2 = new SocketAdapterImplNew();
        Volt v2 = adapter.get120Volt();

        System.out.println(v);
        System.out.println(v2);
    }
}


class Volt {
    private int volt;

    public Volt(int volt) {
        this.volt = volt;
    }

    public int getVolt() {
        return volt;
    }

    public void setVolt(int volt) {
        this.volt = volt;
    }

    @Override
    public String toString() {
        return "Volt{" +
                "volt=" + volt +
                '}';
    }
}

class Socket {

    public Volt getVolt() {
        return new Volt(240);
    }
}

interface SocketAdapter {
    Volt get240Volt();

    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();

}

class SocketAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get240Volt() {
        return getVolt();
    }

    @Override
    public Volt get120Volt() {
        Volt v = getVolt();
        return converVolts(v, 2);
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return converVolts(v, 20);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return converVolts(v, 80);
    }

    private Volt converVolts(Volt v, int fraction) {
        return new Volt(v.getVolt() / fraction);
    }
}

class SocketAdapterImplNew implements SocketAdapter {

    Socket s = new Socket();

    @Override
    public Volt get240Volt() {
        return s.getVolt();
    }

    @Override
    public Volt get120Volt() {
        Volt v = s.getVolt();
        return converVolts(v, 2);
    }

    @Override
    public Volt get12Volt() {
        Volt v = s.getVolt();
        return converVolts(v, 20);
    }

    @Override
    public Volt get3Volt() {
        Volt v = s.getVolt();
        return converVolts(v, 80);
    }

    private Volt converVolts(Volt v, int fraction) {
        return new Volt(v.getVolt() / fraction);
    }
}