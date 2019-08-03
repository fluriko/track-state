package sol.in.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sol.in.soul.controller.model.WebResourceExt;
import sol.in.soul.model.WebResource;
import sol.in.soul.model.WebResourceShort;
import sol.in.soul.service.WebResourceService;
import sol.in.soul.service.WebResourceShortService;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WebResourceController {

    @Autowired
    private WebResourceService webResourceService;

    @Autowired
    private WebResourceShortService webResourceShortService;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello and welcome!");
        return "welcome";
    }

    @RequestMapping(value = "/webResources", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<WebResourceExt> webResources = webResourceService.getAll()
                .orElseGet(Collections::emptyList)
                .stream()
                .map(WebResourceExt::of)
                .collect(Collectors.toList());

        modelAndView.addObject("webResources", webResources);
        modelAndView.setViewName("webResources");
        return modelAndView;
    }

    @RequestMapping(value = "/addWebResource", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.addObject("webResourceShort", new WebResourceShort());
        modelAndView.setViewName("addWebResource");
        return modelAndView;
    }

    @RequestMapping(value = "/addWebResource", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute WebResourceShort webResourceShort, ModelAndView modelAndView) {
        URI.create(webResourceShort.getResourceUrl());
        webResourceShortService.create(webResourceShort);
        List<WebResource> webResources = webResourceService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("webResources", webResources);
        modelAndView.setViewName("webResources");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteWebResource", method = RequestMethod.GET)
    public ModelAndView getAll(@RequestParam("w_id") Long id, ModelAndView modelAndView) {
        WebResource webResource = webResourceService.getById(id).orElseGet(WebResource::new);
        webResourceService.delete(webResource);
        List<WebResource> webResources = webResourceService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("webResources", webResources);
        modelAndView.setViewName("webResources");
        return modelAndView;
    }
}

