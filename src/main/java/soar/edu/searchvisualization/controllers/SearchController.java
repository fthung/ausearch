package soar.edu.searchvisualization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import soar.edu.searchvisualization.model.CodeSearch;
import soar.edu.searchvisualization.model.ResolvedData;

@Controller
public class SearchController {

    @GetMapping({ "/"})
    public String index(Model model,
            @RequestParam(value = "query", required = false, defaultValue = "") String query) {
        model.addAttribute("query", query);
        CodeSearch cs = new CodeSearch(query);
        ResolvedData resolvedData = cs.run(); 
        cs.clean();
        
        // ArrayList<ResolvedFile> resolvedFiles = new ArrayList<ResolvedFile>();
        // ResolvedFile resolvedFile = new ResolvedFile("www.google.com","", 1, 1);
        // resolvedFiles.add(resolvedFile);
        model.addAttribute("resolvedFiles", resolvedData.getResolvedFiles());
    
        return "index";
    }

}