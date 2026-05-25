package creational.singleton;

public class AppConfig {
    private static volatile AppConfig instance;

    private String dbUrl;
    private int maxConnections;
    private String appName;

    private AppConfig() {
        dbUrl = "jdbc:postgresql://localhost:5432/mydb";
        maxConnections = 10;
        appName = "PatternDemo";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String getDbUrl() { return dbUrl; }
    public int getMaxConnections() { return maxConnections; }
    public String getAppName() { return appName; }

    @Override
    public String toString() {
        return "AppConfig{app='" + appName + "', dbUrl='" + dbUrl + "', maxConnections=" + maxConnections + "}";
    }
}
