package net.azurewebsites.mypet.bootstrap;

import net.azurewebsites.mypet.services.CommentService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RunMyPet implements ApplicationListener<ContextRefreshedEvent> {
    CommentService commentService;

    public RunMyPet(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commentService.listAllComments();
    }
}
