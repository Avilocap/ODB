package org.springframework.samples.oculusdb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.services.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentsController {

    private CommentsService commentsService;
    private ApplicationService applicationService;

    @Autowired
    public CommentsController (CommentsService commentsService, ApplicationService applicationService) {
        this.commentsService = commentsService;
        this.applicationService = applicationService;
    }


    @GetMapping(value = "/appInfo/{appId}/comments/new")
    public String agregarProducto(@PathVariable("appId") int appId, Model model) {

        Application app = new Application();
        Optional<Application> ap = this.applicationService.findApplicationById(appId);
        if (ap.isPresent()) {
            app = ap.get();
        }

        Comments comment = new Comments();
        app.addComment(comment);
        model.addAttribute("comment", comment);
        return "comments/newComment";

    }


    @PostMapping(value = "/appInfo/{appId}/comments/new")
    public String guardarProducto(@PathVariable("appId") int appId,@Valid Comments comment, BindingResult result, Model model) {
        if (result.hasErrors()) {

            Application app = new Application();
            Optional<Application> ap = this.applicationService.findApplicationById(appId);
            if (ap.isPresent()) {
                app = ap.get();
            }

            model.addAttribute("comment",comment);
            return "comments/newComment";
        } else {
            this.commentsService.saveComment(comment);
            return "redirect:/applications/appInfo/{appId}";
        }

    }

    @GetMapping(value = "/appInfo/{appId}/comments/list")
    public String listarComentarios(@PathVariable("appId") int appId, Model model) {
        Iterable<Comments> comments = this.commentsService.findAllByAplicationId(appId);
        model.addAttribute("comments", comments);

        return "comments/listComments";
    }

}
