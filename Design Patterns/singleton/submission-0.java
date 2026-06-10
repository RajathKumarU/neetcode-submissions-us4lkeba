static class Singleton {

    private String s;
    private static Singleton INSTANCE;

    private Singleton() {
        s = new String();
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    public String getValue() {
        return s;
    }

    public void setValue(String value) {
        s = value;
    }
    
}
