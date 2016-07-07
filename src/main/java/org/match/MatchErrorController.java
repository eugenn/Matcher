package org.match;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eugennekhai on 07/07/16.
 */
@RestController
public class MatchErrorController implements ErrorController {
    private static final String ERROR_MSG = "Error! Please check input params";
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return ERROR_MSG;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
