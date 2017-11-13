package messenger;

import notification.Notification;
import request.RequestProcessor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by annterina on 11.11.17.
 */
public class ImageMessengerRequestProcessor extends RequestProcessor {

    private MultipartFile image;

    @Override
    protected void preprocess(HttpServletRequest request)
    {
        super.preprocess(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        image = multipartRequest.getFile("image");
    }

    @Override
    protected void postprocess(HttpServletRequest request, Notification notification)
    {
        super.postprocess(request, notification);
    }

    @Override
    protected Notification constructNotification(HttpServletRequest request) {

        return new ImageMessengerNotificationBuilder()
                .withSenderName(request.getParameter("image-sender-name"))
                .withReceiverName(request.getParameter("image-receiver-name"))
                .withImage(image)
                .build();
    }

}
