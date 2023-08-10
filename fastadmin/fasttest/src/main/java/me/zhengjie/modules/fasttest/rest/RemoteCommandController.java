package me.zhengjie.modules.fasttest.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.modules.fasttest.domain.RemoteCommand;
import me.zhengjie.utils.fasttest.SshHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Api(tags = "FastTest：运行远程命令")
@RequestMapping("/api/rcommand")
public class RemoteCommandController {
    private static final Logger logger = LoggerFactory.getLogger(Km2XlsController.class);

    @PostMapping
    @AnonymousAccess
    public Object run(@RequestBody RemoteCommand command) {
        String output = SshHelper.run(command.getCmd(), false);
        return ResponseEntity.ok(output);
    }

}
