package rafpio.common;

public class MySingleton {

    private MySingleton() {
    }

    private static class MySingletonHolder {
        private static final MySingleton INSTANCE = new MySingleton();
    }

    public static MySingleton getInstance() {
        return MySingletonHolder.INSTANCE;
    }

}
