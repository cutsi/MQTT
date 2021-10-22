package PUJ.vjezba3;

interface MineCallBack {                   //declare an interface with the callback methods, so you can use on more than one class and just refer to the interface
    void methodToCallBack();
}

public class CallBack implements MineCallBack {
	public void methodToCallBack() {
        System.out.println("I've been called back");
    }
}
