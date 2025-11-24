package Imple;

import com.practiceWeek1.pracWeek1.NotificationService;

public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS sending...."+message);
    }
}
