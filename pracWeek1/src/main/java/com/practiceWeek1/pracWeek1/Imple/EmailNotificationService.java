package Imple;

import com.practiceWeek1.pracWeek1.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService  {

    @Override
    public void send(String message){
        System.out.println("Email sending...."+message);
    }

}
