package Proxy_Pattern;

interface Service {
    void request();
}

class Proxy implements Service {
    RealService realService;

    public Proxy(Service realService) {
        this.realService = (RealService) realService;
    }

    public boolean checkAccess() {
        System.out.println("proxy connection");
        return true;
    }

    public void request() {
        if (checkAccess()) {
            realService.request();
        }
    }
}

class RealService implements Service {
    public void request() {
        System.out.println("I'm connection, this is realService");
    }
}

public class Proxy_Pattern {
    public static void main(String[] args) {
        Service realService = new RealService();
        Service proxy = new Proxy(realService);
        proxy.request();
    }
}
