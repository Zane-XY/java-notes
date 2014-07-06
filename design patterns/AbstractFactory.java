/**
 * Created by znw on 7/6/14.
 */


abstract class AbstractSystemConfigFactory {
    public abstract String getLogPath();
}

class WindowsConfigFactory extends AbstractSystemConfigFactory {
    public String getLogPath() {
        return "D:\\";
    }
}

class OSXConfigFactory extends AbstractSystemConfigFactory {
    public String getLogPath() {
        return "/var/log";
    }
}

class AppBuilder {
    public void init(AbstractSystemConfigFactory config) {
        System.out.println(config.getLogPath());
    }
}

public class AbstractFactory {
    public static void main(String[] args) throws Exception {
        AbstractSystemConfigFactory configFactory = null;
        if (System.getProperty("os.name").indexOf("win") > 0) {
            configFactory = new WindowsConfigFactory();
        } else if (System.getProperty("os.name").indexOf("OS X") > 0) {
            configFactory = new OSXConfigFactory();
        } else {
            throw new Exception("Configuration Not Supported");
        }
        AppBuilder builder = new AppBuilder();
        builder.init(configFactory);
    }
}

