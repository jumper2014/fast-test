package me.zhengjie.modules.fasttest.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.modules.fasttest.domain.LocalCommand;
import me.zhengjie.thread.CommandThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "FastTest：运行本地命令")
@RequestMapping("/api/lcommand")
public class LocalCommandController {
    private static final Logger logger = LoggerFactory.getLogger(Km2XlsController.class);


    @PostMapping
    @AnonymousAccess
    public Object run(@RequestBody LocalCommand command) {
        CommandThread commandThread = new CommandThread();
        Thread thread = new Thread(commandThread);
        thread.start();
        return ResponseEntity.ok();
    }

}
