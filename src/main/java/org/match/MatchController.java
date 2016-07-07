package org.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by eugennekhai on 06/07/16.
 */
@Controller
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<String> matchedWords(@RequestParam String q) {
        return matchService.match(q);
    }
}
